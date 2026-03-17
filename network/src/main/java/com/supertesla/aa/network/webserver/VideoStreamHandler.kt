package com.supertesla.aa.network.webserver

import android.util.Log
import io.ktor.websocket.DefaultWebSocketSession
import io.ktor.websocket.Frame
import kotlinx.coroutines.flow.Flow
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicLong

/**
 * Streams raw Annex B H.264 NAL units to WebSocket clients as binary frames.
 *
 * Each binary WebSocket frame carries exactly the bytes received from the video flow.
 * The data is already Annex B formatted (starts with 0x00000001 start code). The
 * browser decodes it using the WebCodecs API, so no fMP4 muxing is required here.
 */
class VideoStreamHandler(
    private val width: Int,
    private val height: Int,
    private val frameRate: Int
) {
    private val clients = ConcurrentHashMap<String, DefaultWebSocketSession>()
    private val framesSent = AtomicLong(0)

    companion object {
        private const val TAG = "VideoStreamHandler"
    }

    /**
     * Collect [videoFlow] and forward every byte array as a binary WebSocket frame.
     *
     * The function suspends until the flow completes or the session is closed.
     */
    suspend fun handleClient(session: DefaultWebSocketSession, videoFlow: Flow<ByteArray>) {
        val clientId = java.util.UUID.randomUUID().toString().take(8)
        clients[clientId] = session
        Log.i(TAG, "Client connected: $clientId (${width}x${height} @ ${frameRate}fps)")

        try {
            videoFlow.collect { nalData ->
                if (nalData.isNotEmpty()) {
                    session.send(Frame.Binary(true, nalData))
                    framesSent.incrementAndGet()
                }
            }
        } catch (e: Exception) {
            Log.d(TAG, "Client $clientId ended: ${e.message}")
        } finally {
            clients.remove(clientId)
            Log.i(TAG, "Client disconnected: $clientId")
        }
    }

    /**
     * Send a JSON status message to the client while waiting for a video flow to become available.
     */
    suspend fun sendWaitingMessage(session: DefaultWebSocketSession) {
        try {
            session.send(Frame.Text("""{"type":"status","message":"Waiting for Android Auto video..."}"""))
        } catch (_: Exception) {}
    }

    val connectedClients: Int get() = clients.size
    val totalFramesSent: Long get() = framesSent.get()
}
