package com.supertesla.aa.network.relay

import org.java_websocket.WebSocket
import org.java_websocket.handshake.ClientHandshake
import org.java_websocket.server.WebSocketServer
import timber.log.Timber
import java.net.InetSocketAddress
import java.nio.ByteBuffer

/**
 * WebSocket server for audio streaming relay (TaaDa MediaSocketServer equivalent).
 *
 * Used for both media audio (port N+1) and voice audio (port N+2).
 * Binary-only output: streams PCM audio data to connected browser client.
 * Includes 512KB buffering for small audio chunks.
 */
class MediaSocketServer(
    port: Int,
    private val name: String = "MediaSocket"
) : WebSocketServer(InetSocketAddress(port)) {

    companion object {
        private const val BUFFER_SIZE = 524_288          // 512KB buffer
        private const val BUFFER_FLUSH_THRESHOLD = 1_048_576  // 1MB flush threshold
    }

    @Volatile
    private var currentClient: WebSocket? = null
    private val audioBuffer = ByteBuffer.allocate(BUFFER_SIZE)
    private val bufferLock = Any()

    val isClientConnected: Boolean
        get() = currentClient?.isOpen == true

    override fun onStart() {
        Timber.i("$name: Server started on port $port")
        connectionLostTimeout = 0
    }

    override fun onOpen(conn: WebSocket, handshake: ClientHandshake) {
        Timber.i("$name: Client connected from ${conn.remoteSocketAddress}")
        Thread.sleep(500)
        currentClient = conn
    }

    override fun onClose(conn: WebSocket, code: Int, reason: String, remote: Boolean) {
        Timber.i("$name: Client disconnected (code=$code)")
        if (currentClient == conn) {
            currentClient = null
        }
    }

    override fun onMessage(conn: WebSocket, message: String) {
        Timber.w("$name: Unexpected text message: ${message.take(50)}")
    }

    override fun onMessage(conn: WebSocket, message: ByteBuffer) {
        Timber.w("$name: Unexpected binary message (${message.remaining()} bytes)")
    }

    override fun onError(conn: WebSocket?, ex: Exception) {
        Timber.e(ex, "$name: WebSocket error")
        conn?.close(1011)
    }

    /**
     * Send audio data to the connected browser client.
     *
     * @param data Audio data (PCM bytes)
     * @param shouldBuffer If true, buffer small chunks and flush when full.
     *                     If false, send immediately.
     */
    fun sendAudioData(data: ByteArray, shouldBuffer: Boolean = true) {
        val client = currentClient ?: return
        if (!client.isOpen) return

        try {
            if (!shouldBuffer) {
                client.send(data)
                return
            }

            synchronized(bufferLock) {
                if (audioBuffer.position() + data.size < BUFFER_FLUSH_THRESHOLD) {
                    audioBuffer.put(data)
                } else {
                    // Buffer full — flush
                    audioBuffer.flip()
                    client.send(audioBuffer)
                    audioBuffer.clear()
                    audioBuffer.put(data)
                }
            }
        } catch (e: Exception) {
            Timber.w(e, "$name: Failed to send audio data")
        }
    }

    /**
     * Flush any buffered audio data immediately.
     */
    fun flushBuffer() {
        val client = currentClient ?: return
        if (!client.isOpen) return

        synchronized(bufferLock) {
            if (audioBuffer.position() > 0) {
                audioBuffer.flip()
                try {
                    client.send(audioBuffer)
                } catch (e: Exception) {
                    Timber.w(e, "$name: Failed to flush buffer")
                }
                audioBuffer.clear()
            }
        }
    }
}
