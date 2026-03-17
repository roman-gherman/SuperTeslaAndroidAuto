package com.supertesla.aa.network.webserver

import android.content.res.AssetManager
import com.supertesla.aa.core.config.AppConfig
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.call
import io.ktor.server.application.install
import io.ktor.server.engine.ApplicationEngine
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.plugins.cors.routing.CORS
import io.ktor.server.response.respondOutputStream
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import io.ktor.server.websocket.WebSockets
import io.ktor.server.websocket.webSocket
import io.ktor.websocket.Frame
import io.ktor.websocket.readText
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import com.supertesla.aa.network.webrtc.SignalingHandler
import com.supertesla.aa.network.webrtc.WebRtcManager
import com.supertesla.aa.network.websocket.TouchInputRelay
import timber.log.Timber

class WebServer(
    private val assetManager: AssetManager,
    private val port: Int = AppConfig.SERVER_PORT
) {
    private var server: ApplicationEngine? = null
    private var serverPort80: ApplicationEngine? = null
    var videoStreamHandler: VideoStreamHandler? = null
    /** Stable video flow — lives for the entire server lifetime. Emit into this. */
    val videoSharedFlow = kotlinx.coroutines.flow.MutableSharedFlow<ByteArray>(
        replay = 0,
        extraBufferCapacity = 30
    )
    @Volatile var videoFlowReady: Boolean = false

    /** Legacy setter — for MainService screen capture mode. Collects from the given flow into videoSharedFlow. */
    var videoFlow: Flow<ByteArray>?
        get() = if (videoFlowReady) videoSharedFlow else null
        set(value) {
            if (value != null) {
                videoFlowReady = true
                kotlinx.coroutines.GlobalScope.launch {
                    value.collect { videoSharedFlow.emit(it) }
                }
            }
        }
    // Config endpoint fields (set by TransporterService)
    var configVideoWidth: Int = 1280
    var configVideoHeight: Int = 720
    var configWsPort: Int? = null
    var configResolution: Int = 1
    var configUseBt: Boolean = true

    var touchInputRelay: TouchInputRelay? = null
    var signalingHandler: SignalingHandler? = null
    var onClientConnected: (() -> Unit)? = null
    /** Callback for control actions from browser (START, STOP, ACK, PING, REQUEST_KEYFRAME, etc.) */
    var onAction: ((action: String, json: String) -> Unit)? = null
    var diagnosticInfo: (() -> String)? = null

    val isRunning: Boolean
        get() = server != null

    fun start(bindAddress: String = "0.0.0.0") {
        if (server != null) {
            Timber.w("Server already running")
            return
        }

        Timber.i("Starting web server on $bindAddress:$port")

        server = embeddedServer(Netty, port = port, host = bindAddress) {
            install(WebSockets) {
                pingPeriodMillis = 15000
                timeoutMillis = 30000
                maxFrameSize = Long.MAX_VALUE
                masking = false
            }

            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }

            install(CORS) {
                anyHost()
                allowMethod(HttpMethod.Get)
                allowMethod(HttpMethod.Post)
                allowHeader(HttpHeaders.ContentType)
            }

            routing {
                // Static assets
                get("/") {
                    val html = readAsset("index.html")
                    call.respondText(html, ContentType.Text.Html)
                }

                get("/style.css") {
                    val css = readAsset("style.css")
                    call.respondText(css, ContentType.Text.CSS)
                }

                get("/app.js") {
                    val js = readAsset("app.js")
                    call.respondText(js, ContentType.Application.JavaScript)
                }

                get("/player.js") {
                    val js = readAsset("player.js")
                    call.respondText(js, ContentType.Application.JavaScript)
                }

                get("/touch.js") {
                    val js = readAsset("touch.js")
                    call.respondText(js, ContentType.Application.JavaScript)
                }

                get("/audio.js") {
                    val js = readAsset("audio.js")
                    call.respondText(js, ContentType.Application.JavaScript)
                }

                get("/debug") {
                    val html = readAsset("debug.html")
                    call.respondText(html, ContentType.Text.Html)
                }

                // Health & status
                get("/health") {
                    call.respondText("ok", ContentType.Text.Plain)
                }

                get("/status") {
                    val handler = videoStreamHandler
                    val clients = handler?.connectedClients ?: 0
                    val frames = handler?.totalFramesSent ?: 0
                    val hasVideoFlow = videoFlowReady
                    val signaling = signalingHandler != null
                    call.respondText(
                        """{"status":"running","version":"0.1.0","videoClients":$clients,"framesSent":$frames,"hasVideoFlow":$hasVideoFlow,"hasSignaling":$signaling}""",
                        ContentType.Application.Json
                    )
                }

                // Configuration endpoint for Tesla browser (TaaDa-compatible)
                get("/config") {
                    val screenWidth = call.parameters["w"]?.toIntOrNull() ?: 1920
                    val screenHeight = call.parameters["h"]?.toIntOrNull() ?: 1080
                    val videoWidth = configVideoWidth
                    val videoHeight = configVideoHeight
                    val wMargin = MarginCalculator.calculateWidthMargin(videoWidth, videoHeight, screenWidth, screenHeight)
                    val hMargin = MarginCalculator.calculateHeightMargin(videoWidth, videoHeight, screenWidth, screenHeight)
                    call.respondText(
                        """{"width":$videoWidth,"height":$videoHeight,"widthMargin":$wMargin,"heightMargin":$hMargin,"port":${configWsPort ?: port},"resolution":$configResolution,"version":1,"usebt":$configUseBt,"debug":false}""",
                        ContentType.Application.Json
                    )
                }

                get("/diag") {
                    val info = diagnosticInfo?.invoke() ?: "{}"
                    call.respondText(info, ContentType.Application.Json)
                }

                // MJPEG fallback stream
                get("/stream.mjpeg") {
                    if (!videoFlowReady) {
                        call.respondText("Video not available", status = io.ktor.http.HttpStatusCode.ServiceUnavailable)
                        return@get
                    }
                    call.respondOutputStream(
                        ContentType.parse("multipart/x-mixed-replace; boundary=frame")
                    ) {
                        val mjpeg = com.supertesla.aa.streaming.video.MjpegStreamEncoder(
                            width = 1280, height = 720, quality = 75
                        )
                        try {
                            mjpeg.start(videoSharedFlow).collect { jpeg ->
                                write("--frame\r\n".toByteArray())
                                write("Content-Type: image/jpeg\r\n".toByteArray())
                                write("Content-Length: ${jpeg.size}\r\n\r\n".toByteArray())
                                write(jpeg)
                                write("\r\n".toByteArray())
                                flush()
                            }
                        } finally {
                            mjpeg.stop()
                        }
                    }
                }

                // WebRTC signaling endpoints
                signalingHandler?.registerRoutes(this)

                // Unified WebSocket: video streaming (binary out) + touch events (text in)
                webSocket("/ws") {
                    Timber.d("WebSocket client connected")
                    onClientConnected?.invoke()
                    val handler = videoStreamHandler
                    val relay = touchInputRelay

                    // Stream video: wait until flow is ready, then collect from the
                    // stable shared flow (survives AA reconnects).
                    val videoJob = launch {
                        while (!videoFlowReady) {
                            handler?.sendWaitingMessage(this@webSocket)
                            kotlinx.coroutines.delay(2000)
                        }
                        Timber.i("Video flow ready, starting stream to client")
                        try {
                            handler?.handleClient(this@webSocket, videoSharedFlow)
                        } catch (e: Exception) {
                            Timber.d("Video stream ended: ${e.message}")
                        }
                    }

                    // Read incoming messages (touch events) on the main WS coroutine
                    try {
                        for (frame in incoming) {
                            when (frame) {
                                is Frame.Text -> {
                                    val text = frame.readText()
                                    // Try touch relay first
                                    val handled = relay?.handleMessage(text) ?: false
                                    if (!handled) {
                                        // Try control action (START, STOP, ACK, PING, etc.)
                                        try {
                                            val json = org.json.JSONObject(text)
                                            val action = json.optString("action", "")
                                            if (action.isNotEmpty()) {
                                                onAction?.invoke(action, text)
                                            }
                                        } catch (_: Exception) {
                                            Timber.v("WS unhandled text: $text")
                                        }
                                    }
                                }
                                is Frame.Close -> break
                                else -> {}
                            }
                        }
                    } finally {
                        videoJob.cancel()
                        Timber.d("WebSocket client disconnected")
                    }
                }
            }
        }.start(wait = false)

        Timber.i("Web server started on $bindAddress:$port")

        // Also listen on port 80 so domain works without :8080 (e.g., app.supertesla.top)
        if (port != 80) {
            try {
                serverPort80 = embeddedServer(Netty, port = 80, host = bindAddress) {
                    install(CORS) {
                        anyHost()
                        allowMethod(HttpMethod.Get)
                        allowMethod(HttpMethod.Post)
                        allowHeader(HttpHeaders.ContentType)
                    }

                    routing {
                        // Redirect all requests to the main server on primary port
                        get("{...}") {
                            call.respondText(
                                """<!DOCTYPE html><html><head><script>location.replace("http://"+location.hostname+":$port"+location.pathname+location.search)</script></head></html>""",
                                ContentType.Text.Html
                            )
                        }
                    }
                }.start(wait = false)
                Timber.i("Port 80 redirect server started")
            } catch (e: Exception) {
                Timber.w("Port 80 not available (${e.message}) — use :$port directly")
                serverPort80 = null
            }
        }
    }

    fun stop() {
        Timber.i("Stopping web server")
        serverPort80?.stop(500, 1000)
        serverPort80 = null
        server?.stop(1000, 2000)
        server = null
    }

    private fun readAsset(filename: String): String {
        return try {
            assetManager.open(filename).bufferedReader().readText()
        } catch (e: Exception) {
            Timber.e(e, "Failed to read asset: $filename")
            ""
        }
    }
}
