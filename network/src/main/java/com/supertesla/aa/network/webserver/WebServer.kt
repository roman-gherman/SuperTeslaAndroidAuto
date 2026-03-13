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
import kotlinx.serialization.json.Json
import timber.log.Timber

class WebServer(
    private val assetManager: AssetManager,
    private val port: Int = AppConfig.SERVER_PORT
) {
    private var server: ApplicationEngine? = null
    var videoStreamHandler: VideoStreamHandler? = null
    var videoFlow: Flow<ByteArray>? = null

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

                // Health & status
                get("/health") {
                    call.respondText("ok", ContentType.Text.Plain)
                }

                get("/status") {
                    val handler = videoStreamHandler
                    val clients = handler?.connectedClients ?: 0
                    val frames = handler?.totalFramesSent ?: 0
                    call.respondText(
                        """{"status":"running","version":"0.1.0","videoClients":$clients,"framesSent":$frames}""",
                        ContentType.Application.Json
                    )
                }

                // MJPEG fallback stream
                get("/stream.mjpeg") {
                    val flow = videoFlow
                    if (flow == null) {
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
                            mjpeg.start(flow).collect { jpeg ->
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

                // WebSocket for video streaming (MSE fMP4) and touch events
                webSocket("/ws") {
                    Timber.d("WebSocket client connected")
                    val handler = videoStreamHandler
                    val flow = videoFlow

                    if (handler != null && flow != null) {
                        // Stream video to this client
                        handler.handleClient(this, flow)
                    } else {
                        // No video yet - keep connection open for touch events
                        handler?.sendWaitingMessage(this)
                        try {
                            for (frame in incoming) {
                                when (frame) {
                                    is Frame.Text -> {
                                        val text = frame.readText()
                                        Timber.d("WS received: $text")
                                    }
                                    is Frame.Close -> break
                                    else -> {}
                                }
                            }
                        } finally {
                            Timber.d("WebSocket client disconnected")
                        }
                    }
                }
            }
        }.start(wait = false)

        Timber.i("Web server started on $bindAddress:$port")
    }

    fun stop() {
        Timber.i("Stopping web server")
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
