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
    private val onAction: ((action: String, json: String) -> Unit)?
) {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private var client: WebSocketClient? = null
    private var flowJobs: Job? = null
    private var reconnectJob: Job? = null

    @Volatile var isConnected = false
        private set

    /** Cached codec config + IDR to send on connect for late-joining Tesla */
    @Volatile var cachedCodecConfig: ByteArray? = null
    @Volatile var cachedIdr: ByteArray? = null

    /** Config JSON to send to Tesla on connect */
    @Volatile var configJson: String? = null

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

                // Send config
                configJson?.let { send(it) }

                // Send cached codec config + IDR
                cachedCodecConfig?.let { send(it) }
                cachedIdr?.let { send(it) }

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
            // Collect video frames
            launch {
                videoFlow.collect { nalData ->
                    if (ws.isOpen && nalData.isNotEmpty()) {
                        ws.send(VideoStreamHandler.prefixVideo(nalData))
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
            // Try touch relay first
            val handled = touchRelay?.handleMessage(text) ?: false
            if (!handled) {
                // Try control action
                val json = org.json.JSONObject(text)
                val action = json.optString("action", "")
                if (action.isNotEmpty()) {
                    onAction?.invoke(action, text)
                }
            }
        } catch (_: Exception) {
            Timber.v("Relay: unhandled text: ${text.take(80)}")
        }
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
