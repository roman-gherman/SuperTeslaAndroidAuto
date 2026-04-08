package com.supertesla.aa.network.relay

import com.supertesla.aa.network.webserver.VideoStreamHandler
import com.supertesla.aa.network.websocket.TouchInputRelay
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import timber.log.Timber
import java.net.URI
import java.nio.ByteBuffer

/**
 * Outbound WebSocket client that connects the phone to the cloud relay.
 * Subscribes to video/audio flows and forwards binary frames to the relay.
 * Receives touch/control text frames from relay and forwards to local handlers.
 */
class CloudRelayClient(
    private val relayUrl: String,
    private val roomId: String,
    private val sessionKey: String,
    private val videoFlow: MutableSharedFlow<ByteArray>,
    private val audioMediaFlow: MutableSharedFlow<ByteArray>,
    private val audioSpeechFlow: MutableSharedFlow<ByteArray>,
    private val audioSystemFlow: MutableSharedFlow<ByteArray>,
    private val touchRelay: TouchInputRelay?,
    private val onAction: ((action: String, json: String) -> Unit)?,
    /** Called when Tesla requests approval. Implementation should show UI and call approveConnection()/denyConnection(). */
    val onApprovalRequest: ((CloudRelayClient) -> Unit)? = null
) {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    @Volatile var client: WebSocketClient? = null
        internal set
    private var flowJobs: Job? = null
    private var reconnectJob: Job? = null

    @Volatile var isConnected = false
        private set

    /** Cached codec config + IDR to send on connect for late-joining Tesla */
    @Volatile var cachedCodecConfig: ByteArray? = null
    @Volatile var cachedIdr: ByteArray? = null

    /** Config JSON to send to Tesla on connect */
    @Volatile var configJson: String? = null

    /** Gate: drop P-frames until first SPS/IDR is sent. Reset on Tesla reconnect. */
    @Volatile var keyframeGateOpen: Boolean = false

    /** MJPEG fallback mode: decode H.264 to JPEG on phone, bypass browser VideoDecoder. */
    @Volatile var mjpegMode: Boolean = false
    private var mjpegEncoder: com.supertesla.aa.streaming.video.MjpegStreamEncoder? = null

    /** Video dimensions for MJPEG encoder. Set from TransporterService config. */
    var videoWidth: Int = 1280
    var videoHeight: Int = 720

    /** Approve a pending Tesla connection. Generates a new session key. */
    fun approveConnection() {
        val sessionKey = java.util.UUID.randomUUID().toString().replace("-", "").take(32)
        val msg = """{"action":"APPROVE_TESLA","sessionKey":"$sessionKey"}"""
        try {
            client?.send(msg)
            Timber.i("Relay: approved Tesla connection, key=${sessionKey.take(8)}...")
        } catch (e: Exception) {
            Timber.w(e, "Relay: failed to send approval")
        }
    }

    /** Deny a pending Tesla connection. */
    fun denyConnection() {
        try {
            client?.send("""{"action":"DENY_TESLA"}""")
            Timber.i("Relay: denied Tesla connection")
        } catch (e: Exception) {
            Timber.w(e, "Relay: failed to send denial")
        }
    }

    /** Revoke all saved session keys. Tesla will need re-approval next time. */
    fun revokeAllKeys() {
        try {
            client?.send("""{"action":"REVOKE_ALL_KEYS"}""")
            Timber.i("Relay: revoked all Tesla session keys")
        } catch (e: Exception) {
            Timber.w(e, "Relay: failed to revoke keys")
        }
    }

    fun connect() {
        reconnectJob?.cancel()
        reconnectJob = scope.launch {
            var delay = 2000L
            while (isActive) {
                try {
                    doConnect()
                    delay = 500L // Reset on successful connect
                } catch (e: CancellationException) {
                    throw e
                } catch (e: Exception) {
                    Timber.w("Relay: connection failed: ${e.message}")
                }
                delay(delay)
                // Aggressive reconnect: 500ms → 1s → 2s → 3s max
                delay = (delay * 2).coerceAtMost(3000L)
            }
        }
    }

    private suspend fun doConnect() {
        val uri = URI("$relayUrl?room=$roomId&key=$sessionKey&role=phone")
        Timber.i("Relay: connecting to $uri")

        val latch = CompletableDeferred<Unit>()

        val ws = object : WebSocketClient(uri) {
            init {
                // Use default SSLSocketFactory — it handles IPv4/IPv6 fallback correctly
                // (unlike raw Socket() which creates IPv6 dual-stack that times out)
                this.setSocketFactory(javax.net.ssl.HttpsURLConnection.getDefaultSSLSocketFactory())
                this.connectionLostTimeout = 30
            }
            override fun onOpen(handshake: ServerHandshake?) {
                Timber.i("Relay: connected to room $roomId")
                isConnected = true

                // Send CONFIG — relay server caches it (roomData.config) and
                // replays it to Tesla on each browser connect (line 290 in server.js).
                // Also forward SPS+IDR to relay for caching (lines 356-364).
                configJson?.let { send(it) }

                // Auto-trigger START — Tesla may already be connected
                onAction?.invoke("START", "")

                latch.complete(Unit)
            }

            override fun onMessage(message: String) {
                // Text frame from Tesla (touch events, control actions)
                handleTextMessage(message)
            }

            override fun onMessage(bytes: ByteBuffer) {
                // Binary frame from Tesla (unlikely but forward if any)
                // Not expected in normal flow
            }

            override fun onClose(code: Int, reason: String?, remote: Boolean) {
                Timber.w("Relay: disconnected (code=$code, reason=$reason, remote=$remote)")
                isConnected = false
                latch.completeExceptionally(Exception("closed: $reason"))
            }

            override fun onError(ex: Exception?) {
                Timber.w(ex, "Relay: error")
                isConnected = false
                latch.completeExceptionally(ex ?: Exception("unknown error"))
            }
        }

        client = ws
        ws.connect()

        // Wait for connection to establish
        latch.await()

        // Start flow collection jobs
        startFlowCollection(ws)

        // Block until disconnected
        suspendCancellableCoroutine<Unit> { cont ->
            // Wait for the ws to close
            scope.launch {
                while (ws.isOpen) {
                    delay(1000)
                }
                if (cont.isActive) cont.resume(Unit) {}
            }
        }

        stopFlowCollection()
    }

    private fun startFlowCollection(ws: WebSocketClient) {
        flowJobs = scope.launch {
            launch {
                if (mjpegMode) {
                    // MJPEG mode: decode H.264 → JPEG on phone, send as 0x04 frames.
                    // Bypasses browser's VideoDecoder API (blocked by Tesla while driving).
                    Timber.i("Relay: starting MJPEG flow collection (${videoWidth}x${videoHeight})")
                    val encoder = com.supertesla.aa.streaming.video.MjpegStreamEncoder(
                        width = videoWidth,
                        height = videoHeight,
                        quality = 60,
                        maxFps = 20
                    )
                    mjpegEncoder = encoder
                    try {
                        encoder.start(videoFlow).collect { jpegData ->
                            if (ws.isOpen) {
                                ws.send(VideoStreamHandler.prefixMjpeg(jpegData))
                            }
                        }
                    } finally {
                        encoder.stop()
                    }
                } else {
                    // H.264 mode: forward raw NAL units with keyframe gating.
                    videoFlow.collect { nalData ->
                        if (ws.isOpen && nalData.isNotEmpty()) {
                            val nalType = findFirstNalType(nalData)
                            if (nalType == 7) cachedCodecConfig = nalData.copyOf()
                            else if (nalType == 5) cachedIdr = nalData.copyOf()

                            if (!keyframeGateOpen) {
                                if (nalType == 7 || nalType == 5) {
                                    keyframeGateOpen = true
                                    Timber.d("Relay: gate opened by live NAL type=$nalType (${nalData.size}b)")
                                    ws.send(VideoStreamHandler.prefixVideo(nalData))
                                }
                            } else {
                                ws.send(VideoStreamHandler.prefixVideo(nalData))
                            }
                        }
                    }
                }
            }
            // Collect audio frames
            launch {
                audioMediaFlow.collect { pcm ->
                    if (ws.isOpen) ws.send(VideoStreamHandler.prefixAudio(VideoStreamHandler.TYPE_AUDIO_MEDIA, pcm))
                }
            }
            launch {
                audioSpeechFlow.collect { pcm ->
                    if (ws.isOpen) ws.send(VideoStreamHandler.prefixAudio(VideoStreamHandler.TYPE_AUDIO_SPEECH, pcm))
                }
            }
            launch {
                audioSystemFlow.collect { pcm ->
                    if (ws.isOpen) ws.send(VideoStreamHandler.prefixAudio(VideoStreamHandler.TYPE_AUDIO_SYSTEM, pcm))
                }
            }
        }
    }

    private fun stopFlowCollection() {
        flowJobs?.cancel()
        flowJobs = null
    }

    private fun handleTextMessage(text: String) {
        try {
            val json = org.json.JSONObject(text)

            // Handle relay system messages
            val type = json.optString("type", "")
            when (type) {
                "approval_request" -> {
                    Timber.i("Relay: Tesla requesting approval")
                    onApprovalRequest?.invoke(this)
                    return
                }
                "approval_cancelled" -> {
                    Timber.i("Relay: Tesla cancelled approval request")
                    return
                }
                "tesla_connected" -> {
                    Timber.i("Relay: Tesla connected")
                    // The relay server already sent cached CONFIG + SPS + IDR to Tesla
                    // (server.js lines 290-292). Keep the gate open so live P-frames
                    // flow immediately after the relay's cached IDR.
                    keyframeGateOpen = true
                    // Trigger START in case video focus needs enabling
                    onAction?.invoke("START", text)
                    return
                }
                "tesla_disconnected" -> {
                    Timber.i("Relay: Tesla disconnected")
                    return
                }
            }

            // Handle MJPEG mode switching
            val action = json.optString("action", "")
            if (action == "REQUEST_MJPEG" && !mjpegMode) {
                Timber.i("Relay: Tesla requested MJPEG mode — switching")
                mjpegMode = true
                stopFlowCollection()
                client?.let { startFlowCollection(it) }
                return
            }
            if (action == "REQUEST_H264" && mjpegMode) {
                Timber.i("Relay: Tesla requested H.264 mode — switching back")
                mjpegMode = false
                mjpegEncoder?.stop()
                mjpegEncoder = null
                stopFlowCollection()
                client?.let { startFlowCollection(it) }
                return
            }

            // Try touch relay
            val handled = touchRelay?.handleMessage(text) ?: false
            if (!handled) {
                if (action.isNotEmpty()) {
                    onAction?.invoke(action, text)
                }
            }
        } catch (_: Exception) {
            Timber.v("Relay: unhandled text: ${text.take(80)}")
        }
    }

    /**
     * Find the NAL unit type of the first NAL in Annex B data.
     * Returns the NAL type (7=SPS, 8=PPS, 5=IDR, 1=P-frame) or -1.
     */
    private fun findFirstNalType(data: ByteArray): Int {
        // Look for start code 00 00 00 01 or 00 00 01
        for (i in 0 until data.size - 4) {
            if (data[i] == 0.toByte() && data[i + 1] == 0.toByte()) {
                if (data[i + 2] == 0.toByte() && data[i + 3] == 1.toByte()) {
                    return data[i + 4].toInt() and 0x1F
                }
                if (data[i + 2] == 1.toByte()) {
                    return data[i + 3].toInt() and 0x1F
                }
            }
        }
        return -1
    }

    fun disconnect() {
        reconnectJob?.cancel()
        reconnectJob = null
        stopFlowCollection()
        try { client?.close() } catch (_: Exception) {}
        client = null
        isConnected = false
        scope.cancel()
    }
}
