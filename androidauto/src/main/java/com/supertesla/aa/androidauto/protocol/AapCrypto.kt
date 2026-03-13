package com.supertesla.aa.androidauto.protocol

import timber.log.Timber
import java.nio.ByteBuffer
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLEngine
import javax.net.ssl.SSLEngineResult
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

/**
 * Handles TLS encryption/decryption for AAP.
 *
 * AAP runs TLS "inside" the protocol: the 4-byte AAP header is always plaintext,
 * but the payload of encrypted frames is a TLS record. The SSL handshake itself
 * is exchanged via SSL_HANDSHAKE (type=3) messages on channel 0.
 *
 * We use SSLEngine in manual (non-blocking) mode, wrapping/unwrapping byte buffers.
 */
class AapCrypto {

    private lateinit var sslEngine: SSLEngine
    private lateinit var netOutBuffer: ByteBuffer
    private lateinit var appInBuffer: ByteBuffer

    val isHandshakeComplete: Boolean
        get() = ::sslEngine.isInitialized &&
                sslEngine.handshakeStatus == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING

    /**
     * Initialize SSLEngine for TLS 1.2 in client mode.
     * We act as the TLS client connecting to the AA server.
     */
    fun init() {
        val sslContext = SSLContext.getInstance("TLSv1.2")
        sslContext.init(null, arrayOf<TrustManager>(TrustAllManager()), SecureRandom())

        sslEngine = sslContext.createSSLEngine()
        sslEngine.useClientMode = true

        val session = sslEngine.session
        netOutBuffer = ByteBuffer.allocate(session.packetBufferSize)
        appInBuffer = ByteBuffer.allocate(session.applicationBufferSize)
    }

    /**
     * Begin handshake and produce the first TLS ClientHello bytes.
     * Returns the raw TLS records to send to the peer inside an SSL_HANDSHAKE message.
     */
    fun beginHandshake(): ByteArray {
        sslEngine.beginHandshake()
        return produceHandshakeData()
    }

    /**
     * Feed received TLS handshake data from the peer and produce our response.
     * Returns the next set of TLS records to send, or empty if handshake is complete.
     */
    fun processHandshakeData(received: ByteArray): ByteArray {
        val inBuf = ByteBuffer.wrap(received)
        appInBuffer.clear()

        while (inBuf.hasRemaining()) {
            val result = sslEngine.unwrap(inBuf, appInBuffer)
            Timber.d("SSL unwrap: status=${result.status}, hs=${result.handshakeStatus}")
            when (result.status) {
                SSLEngineResult.Status.OK -> {}
                SSLEngineResult.Status.BUFFER_UNDERFLOW -> break
                SSLEngineResult.Status.BUFFER_OVERFLOW -> {
                    appInBuffer = ByteBuffer.allocate(appInBuffer.capacity() * 2)
                }
                SSLEngineResult.Status.CLOSED -> {
                    Timber.w("SSL engine closed during handshake")
                    return ByteArray(0)
                }
                else -> {}
            }

            if (result.handshakeStatus == SSLEngineResult.HandshakeStatus.FINISHED ||
                result.handshakeStatus == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING
            ) {
                Timber.i("SSL handshake complete")
                return produceHandshakeData()
            }
        }

        return produceHandshakeData()
    }

    /**
     * Produce any pending handshake data that needs to be sent.
     */
    private fun produceHandshakeData(): ByteArray {
        val output = mutableListOf<ByteArray>()

        while (sslEngine.handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_WRAP) {
            netOutBuffer.clear()
            val result = sslEngine.wrap(ByteBuffer.allocate(0), netOutBuffer)
            Timber.d("SSL wrap: status=${result.status}, hs=${result.handshakeStatus}")

            if (result.bytesProduced() > 0) {
                netOutBuffer.flip()
                val bytes = ByteArray(netOutBuffer.remaining())
                netOutBuffer.get(bytes)
                output.add(bytes)
            }

            if (result.handshakeStatus == SSLEngineResult.HandshakeStatus.FINISHED ||
                result.handshakeStatus == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING
            ) {
                Timber.i("SSL handshake complete (after wrap)")
                break
            }
        }

        // Handle NEED_TASK
        while (sslEngine.handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_TASK) {
            sslEngine.delegatedTask?.run()
        }

        // May need more wrapping after running tasks
        if (sslEngine.handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_WRAP) {
            val extra = produceHandshakeData()
            if (extra.isNotEmpty()) output.add(extra)
        }

        if (output.isEmpty()) return ByteArray(0)

        // Concatenate all TLS records
        val totalSize = output.sumOf { it.size }
        val result = ByteArray(totalSize)
        var offset = 0
        for (chunk in output) {
            System.arraycopy(chunk, 0, result, offset, chunk.size)
            offset += chunk.size
        }
        return result
    }

    /**
     * Encrypt application data for sending.
     * Returns the TLS record(s) wrapping the plaintext.
     */
    fun encrypt(plaintext: ByteArray): ByteArray {
        val inBuf = ByteBuffer.wrap(plaintext)
        val outBuf = ByteBuffer.allocate(sslEngine.session.packetBufferSize + plaintext.size)

        val result = sslEngine.wrap(inBuf, outBuf)
        if (result.status != SSLEngineResult.Status.OK) {
            Timber.w("SSL encrypt status: ${result.status}")
        }

        outBuf.flip()
        val encrypted = ByteArray(outBuf.remaining())
        outBuf.get(encrypted)
        return encrypted
    }

    /**
     * Decrypt received TLS record(s) to application data.
     * Returns the decrypted plaintext.
     */
    fun decrypt(ciphertext: ByteArray): ByteArray {
        val inBuf = ByteBuffer.wrap(ciphertext)
        val outBuf = ByteBuffer.allocate(sslEngine.session.applicationBufferSize + ciphertext.size)

        while (inBuf.hasRemaining()) {
            val result = sslEngine.unwrap(inBuf, outBuf)
            when (result.status) {
                SSLEngineResult.Status.OK -> {}
                SSLEngineResult.Status.BUFFER_UNDERFLOW -> break
                SSLEngineResult.Status.BUFFER_OVERFLOW -> {
                    // This shouldn't happen with our buffer sizing, but handle it
                    Timber.w("SSL decrypt buffer overflow")
                    break
                }
                SSLEngineResult.Status.CLOSED -> {
                    Timber.w("SSL engine closed")
                    break
                }
                else -> {}
            }
        }

        outBuf.flip()
        val decrypted = ByteArray(outBuf.remaining())
        outBuf.get(decrypted)
        return decrypted
    }

    fun close() {
        if (::sslEngine.isInitialized) {
            sslEngine.closeOutbound()
        }
    }

    /**
     * Trust manager that accepts all certificates.
     * This is safe here because we only connect to the local AA server.
     */
    private class TrustAllManager : X509TrustManager {
        override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {}
        override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {}
        override fun getAcceptedIssuers(): Array<X509Certificate> = emptyArray()
    }
}
