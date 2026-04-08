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

    /** Cached SPS+PPS codec config to send to late-joining clients. */
    @Volatile var cachedCodecConfig: ByteArray? = null
    /** Cached IDR (keyframe) — required after codec config for decoder to start. */
    @Volatile var cachedIdr: ByteArray? = null

    /**
     * Collect [videoFlow] and forward every byte array as a binary WebSocket frame.
     *
     * If cached codec config (SPS+PPS) is available, it is sent first so
     * late-joining clients can configure their decoder immediately.
     */
    suspend fun handleClient(session: DefaultWebSocketSession, videoFlow: Flow<ByteArray>) {
        val clientId = java.util.UUID.randomUUID().toString().take(8)
        clients[clientId] = session
        Log.i(TAG, "Client connected: $clientId (${width}x${height} @ ${frameRate}fps)")

        try {
            // Send cached codec config (SPS+PPS) + IDR so late-joining clients
            // can configure their decoder and display a frame immediately.
            cachedCodecConfig?.let { config ->
                session.send(Frame.Binary(true, prefixVideo(config)))
                Log.i(TAG, "Sent cached codec config to $clientId (${config.size}b)")
            }
            cachedIdr?.let { idr ->
                session.send(Frame.Binary(true, prefixVideo(idr)))
                Log.i(TAG, "Sent cached IDR to $clientId (${idr.size}b)")
            }

            videoFlow.collect { nalData ->
                if (nalData.isNotEmpty()) {
                    session.send(Frame.Binary(true, prefixVideo(nalData)))
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

    companion object {
        private const val TAG = "VideoStreamHandler"
        const val TYPE_VIDEO: Byte = 0x00
        const val TYPE_AUDIO_MEDIA: Byte = 0x01
        const val TYPE_AUDIO_SPEECH: Byte = 0x02
        const val TYPE_AUDIO_SYSTEM: Byte = 0x03
        const val TYPE_VIDEO_MJPEG: Byte = 0x04

        /** Prepend type prefix byte to a payload. */
        fun prefixMjpeg(data: ByteArray): ByteArray {
            val out = ByteArray(1 + data.size)
            out[0] = TYPE_VIDEO_MJPEG
            System.arraycopy(data, 0, out, 1, data.size)
            return out
        }

        fun prefixVideo(data: ByteArray): ByteArray {
            val out = ByteArray(1 + data.size)
            out[0] = TYPE_VIDEO
            System.arraycopy(data, 0, out, 1, data.size)
            return out
        }

        fun prefixAudio(type: Byte, data: ByteArray): ByteArray {
            val out = ByteArray(1 + data.size)
            out[0] = type
            System.arraycopy(data, 0, out, 1, data.size)
            return out
        }
    }
}
