package com.supertesla.aa.network.relay

import org.java_websocket.WebSocket
import org.java_websocket.handshake.ClientHandshake
import org.java_websocket.server.WebSocketServer
import org.json.JSONObject
import timber.log.Timber
import java.net.InetSocketAddress
import java.nio.ByteBuffer

/**
 * WebSocket server for video + control relay (TaaDa ControlSocketServer equivalent).
 *
 * Outbound (server → browser):
 *   - Binary frames: H.264 video data (NAL units or fMP4 segments)
 *
 * Inbound (browser → server):
 *   - JSON text: control commands (START, STOP, PING, REQUEST_KEYFRAME, touch events, GPS, NIGHT)
 *   - Binary: compact multi-touch events (BinaryTouchDecoder format)
 *
 * Port: dynamically assigned (part of 3-port group: control, audio, voice)
 */
class ControlSocketServer(
    port: Int,
    private val onAction: (String, JSONObject?) -> Unit = { _, _ -> },
    private val onTouch: (action: Int, x: Int, y: Int, pointerId: Int) -> Unit = { _, _, _, _ -> }
) : WebSocketServer(InetSocketAddress(port)) {

    companion object {
        private const val TAG = "ControlSocketServer"

        // Ping response: 5 bytes {0,0,0,0,31}
        private val PING_RESPONSE = ByteBuffer.wrap(byteArrayOf(0, 0, 0, 0, 31))

        // Touch actions
        const val ACTION_DOWN = 0
        const val ACTION_UP = 1
        const val ACTION_MOVE = 2
    }

    @Volatile
    private var currentClient: WebSocket? = null

    val isClientConnected: Boolean
        get() = currentClient?.isOpen == true

    override fun onStart() {
        Timber.i("$TAG: Server started on port $port")
        connectionLostTimeout = 0  // Disable built-in timeout, we handle our own
    }

    override fun onOpen(conn: WebSocket, handshake: ClientHandshake) {
        Timber.i("$TAG: Client connected from ${conn.remoteSocketAddress}")
        // Wait a moment for client to stabilize (TaaDa waits 1000ms)
        Thread.sleep(500)
        currentClient = conn
        // Notify: toggle video focus off initially (browser will send START when ready)
        onAction("CONNECTED", null)
    }

    override fun onClose(conn: WebSocket, code: Int, reason: String, remote: Boolean) {
        Timber.i("$TAG: Client disconnected (code=$code, reason=$reason)")
        if (currentClient == conn) {
            currentClient = null
        }
        onAction("DISCONNECTED", null)
    }

    override fun onMessage(conn: WebSocket, message: String) {
        try {
            val json = JSONObject(message)
            val action = json.optString("action", "")

            when (action) {
                "START" -> onAction("START", json)
                "STOP" -> onAction("STOP", json)
                "RELOAD" -> onAction("RELOAD", json)
                "REQUEST_KEYFRAME" -> onAction("REQUEST_KEYFRAME", json)
                "PING" -> {
                    // Respond with 5-byte binary
                    conn.send(PING_RESPONSE.duplicate())
                    onAction("PING", json)
                }
                "ACK" -> { /* log only */ }

                // Touch events (TaaDa MULTITOUCH format)
                "MULTITOUCH_DOWN" -> handleMultiTouch(ACTION_DOWN, json)
                "MULTITOUCH_MOVE" -> handleMultiTouch(ACTION_MOVE, json)
                "MULTITOUCH_UP" -> handleMultiTouch(ACTION_UP, json)
                "MULTITOUCH_CANCEL" -> handleMultiTouch(ACTION_UP, json)

                // Sensor events
                "GPS" -> onAction("GPS", json)
                "NIGHT" -> onAction("NIGHT", json)

                else -> {
                    // Try legacy simple touch format
                    if (json.optString("type") == "touch") {
                        handleSimpleTouch(json)
                    } else {
                        Timber.v("$TAG: Unknown action: $action")
                    }
                }
            }
        } catch (e: Exception) {
            Timber.w(e, "$TAG: Error parsing message: ${message.take(100)}")
        }
    }

    override fun onMessage(conn: WebSocket, message: ByteBuffer) {
        // Binary touch events (compact format)
        // TODO: Implement BinaryTouchDecoder (Phase 3.2)
        Timber.v("$TAG: Binary message received (${message.remaining()} bytes)")
    }

    override fun onError(conn: WebSocket?, ex: Exception) {
        Timber.e(ex, "$TAG: WebSocket error")
        conn?.close(1011)
    }

    /**
     * Send a video frame to the connected browser client.
     */
    fun sendVideoFrame(data: ByteArray) {
        val client = currentClient ?: return
        if (!client.isOpen) return
        try {
            client.send(data)
        } catch (e: Exception) {
            Timber.w(e, "$TAG: Failed to send video frame")
        }
    }

    /**
     * Send a video frame from a ByteBuffer.
     */
    fun sendVideoFrame(buffer: ByteBuffer) {
        val client = currentClient ?: return
        if (!client.isOpen) return
        try {
            client.send(buffer)
        } catch (e: Exception) {
            Timber.w(e, "$TAG: Failed to send video frame")
        }
    }

    private fun handleMultiTouch(action: Int, json: JSONObject) {
        val allTouches = json.optJSONArray("allTouches")
        val touches = json.optJSONArray("touches")

        val points = allTouches ?: touches ?: return

        for (i in 0 until points.length()) {
            val point = points.getJSONObject(i)
            val id = point.optInt("id", 0)
            val x = point.optInt("x", 0)
            val y = point.optInt("y", 0)
            onTouch(action, x, y, id)
        }
    }

    private fun handleSimpleTouch(json: JSONObject) {
        val action = when (json.optString("action")) {
            "down" -> ACTION_DOWN
            "move" -> ACTION_MOVE
            "up" -> ACTION_UP
            else -> return
        }
        val x = (json.optDouble("x", 0.0) * 1280).toInt()  // normalized → pixels
        val y = (json.optDouble("y", 0.0) * 720).toInt()
        val pointerId = json.optInt("pointerId", 0)
        onTouch(action, x, y, pointerId)
    }
}
