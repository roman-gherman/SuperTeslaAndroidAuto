package com.supertesla.aa.androidauto.protocol

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.isActive
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.net.SocketTimeoutException
import kotlin.coroutines.coroutineContext

/**
 * Channel multiplexer: routes incoming AAP frames to registered handlers,
 * and provides a thread-safe send method for outgoing frames.
 *
 * Handles:
 * - Frame reassembly (multi-frame messages using FIRST/MIDDLE/LAST flags)
 * - Decryption of encrypted frames
 * - Dispatching to channel-specific handlers
 */
class ChannelMux(
    private val framer: AapFramer,
    private val crypto: AapCrypto,
    private val input: InputStream,
    private val output: OutputStream
) {
    private val handlers = mutableMapOf<Int, ChannelHandler>()

    /**
     * Lock that serialises encrypt-then-write so TLS records arrive in order.
     *
     * SSLEngine assigns a monotonic sequence number to each wrap() call.
     * If two threads encrypt concurrently and the second thread's frame
     * reaches the wire before the first's, the peer sees an out-of-order
     * TLS record and fails with BAD_DECRYPT / BAD_RECORD_MAC.
     *
     * Holding this single lock across both encrypt() and writeRawFrame()
     * guarantees the wire order matches the TLS sequence order.
     */
    private val sendLock = Any()

    // Reassembly buffers per channel
    private val reassemblyBuffers = mutableMapOf<Int, MutableList<ByteArray>>()

    fun registerHandler(channelId: Int, handler: ChannelHandler) {
        handlers[channelId] = handler
        Timber.d("Registered handler for channel $channelId: ${handler::class.simpleName}")
    }

    /**
     * Main read loop. Reads frames from the input stream and dispatches them.
     * Runs until the coroutine is cancelled or an error occurs.
     */
    suspend fun readLoop() = withContext(Dispatchers.IO) {
        Timber.i("Channel mux read loop started")
        try {
            while (coroutineContext.isActive) {
                val frame = try {
                    framer.readFrame(input)
                } catch (e: SocketTimeoutException) {
                    // TaaDa returns empty buffer and continues on timeout.
                    // Don't kill the read loop on a transient timeout.
                    Timber.v("MUX: Socket timeout during readFrame — continuing")
                    continue
                }

                // Decrypt payload if encrypted
                val decryptedPayload = if (frame.isEncrypted && crypto.isHandshakeComplete) {
                    try {
                        crypto.decrypt(frame.payload)
                    } catch (e: Exception) {
                        Timber.w(e, "Decryption failed for frame on channel ${frame.channel}")
                        continue
                    }
                } else {
                    frame.payload
                }

                val decryptedFrame = frame.copy(payload = decryptedPayload)
                Timber.d("MUX: ch=${decryptedFrame.channel} flags=0x${decryptedFrame.flags.toString(16)} msgType=0x${decryptedFrame.messageType.toString(16)} payload=${decryptedPayload.size}b")

                // Handle fragmentation
                when {
                    decryptedFrame.isBulk -> {
                        // Complete single-frame message
                        dispatch(decryptedFrame)
                    }
                    decryptedFrame.isFirst && !decryptedFrame.isLast -> {
                        // Start of multi-frame message
                        reassemblyBuffers[decryptedFrame.channel] = mutableListOf(decryptedFrame.payload)
                    }
                    !decryptedFrame.isFirst && !decryptedFrame.isLast -> {
                        // Middle frame
                        reassemblyBuffers[decryptedFrame.channel]?.add(decryptedFrame.payload)
                    }
                    decryptedFrame.isLast && !decryptedFrame.isFirst -> {
                        // Last frame - reassemble
                        val buffers = reassemblyBuffers.remove(decryptedFrame.channel)
                        if (buffers != null) {
                            buffers.add(decryptedFrame.payload)
                            val totalSize = buffers.sumOf { it.size }
                            val reassembled = ByteArray(totalSize)
                            var offset = 0
                            for (buf in buffers) {
                                System.arraycopy(buf, 0, reassembled, offset, buf.size)
                                offset += buf.size
                            }
                            val fullFrame = decryptedFrame.copy(
                                flags = AapFramer.FLAG_BULK or (decryptedFrame.flags and AapFramer.FLAG_ENCRYPTED.inv()),
                                payload = reassembled
                            )
                            dispatch(fullFrame)
                        }
                    }
                    else -> {
                        dispatch(decryptedFrame)
                    }
                }
            }
        } catch (e: SocketTimeoutException) {
            // TaaDa's read loop returns empty buffer and continues on timeout.
            // This should not happen if soTimeout=0, but handle gracefully as a
            // safety net — log and let the loop end naturally rather than crashing.
            Timber.w("Channel mux read loop: socket timeout (non-fatal): ${e.message}")
        } catch (e: IOException) {
            Timber.w("Channel mux read loop ended: ${e.message}")
        } catch (e: Exception) {
            Timber.e(e, "Channel mux read loop error")
        }
        Timber.i("Channel mux read loop stopped")
    }

    private suspend fun dispatch(frame: AapFramer.AapFrame) {
        // Frames with the CONTROL flag (0x04) are control messages (e.g. ChannelOpenRequest)
        // that arrive on the target channel, not channel 0. Route them to the control handler.
        val handler = if (frame.isControl && frame.channel != 0) {
            handlers[0] ?: handlers[frame.channel]
        } else {
            handlers[frame.channel]
        }
        if (handler != null) {
            try {
                handler.onFrame(frame)
            } catch (e: Exception) {
                Timber.e(e, "Error in handler for channel ${frame.channel}")
            }
        } else {
            Timber.v("No handler for channel ${frame.channel}, msgType=0x${frame.messageType.toString(16)}")
        }
    }

    /**
     * Send an encrypted message on the given channel.
     */
    fun sendEncrypted(channel: Int, messageType: Int, data: ByteArray) {
        val payload = ByteArray(2 + data.size)
        payload[0] = (messageType shr 8).toByte()
        payload[1] = (messageType and 0xFF).toByte()
        System.arraycopy(data, 0, payload, 2, data.size)

        synchronized(sendLock) {
            val encrypted = crypto.encrypt(payload)
            val flags = AapFramer.FLAG_BULK or AapFramer.FLAG_ENCRYPTED
            framer.writeRawFrame(output, channel, flags, encrypted)
        }
    }

    /**
     * Send an encrypted control-type message on the given channel.
     */
    fun sendEncryptedControl(channel: Int, messageType: Int, data: ByteArray) {
        val payload = ByteArray(2 + data.size)
        payload[0] = (messageType shr 8).toByte()
        payload[1] = (messageType and 0xFF).toByte()
        System.arraycopy(data, 0, payload, 2, data.size)

        synchronized(sendLock) {
            val encrypted = crypto.encrypt(payload)
            val flags = AapFramer.FLAG_BULK or AapFramer.FLAG_ENCRYPTED or AapFramer.FLAG_CONTROL
            framer.writeRawFrame(output, channel, flags, encrypted)
        }
    }

    /**
     * Send an unencrypted message (for version exchange and SSL handshake).
     */
    fun sendPlain(channel: Int, messageType: Int, data: ByteArray) {
        framer.writeFrame(output, channel, AapFramer.FLAG_BULK, messageType, data)
    }
}

/**
 * Interface for channel-specific message handlers.
 */
interface ChannelHandler {
    suspend fun onFrame(frame: AapFramer.AapFrame)
}
