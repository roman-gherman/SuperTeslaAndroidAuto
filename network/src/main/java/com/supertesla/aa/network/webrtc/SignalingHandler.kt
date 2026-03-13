package com.supertesla.aa.network.webrtc

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.request.receiveText
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import timber.log.Timber

/**
 * HTTP-based WebRTC signaling endpoints for SDP offer/answer
 * and ICE candidate exchange.
 */
class SignalingHandler(
    private val webRtcManager: WebRtcManager
) {
    private val json = Json { ignoreUnknownKeys = true }

    @Serializable
    data class SdpMessage(val type: String, val sdp: String)

    @Serializable
    data class IceCandidateMessage(
        val candidate: String,
        val sdpMid: String,
        val sdpMLineIndex: Int
    )

    @Serializable
    data class IceCandidatesResponse(val candidates: List<IceCandidateMessage>)

    /**
     * Register signaling routes on the Ktor router.
     */
    fun registerRoutes(route: Route) {
        route.route("/webrtc") {
            post("/offer") {
                try {
                    val body = call.receiveText()
                    val offer = json.decodeFromString<SdpMessage>(body)
                    Timber.i("Received WebRTC offer (${offer.sdp.length} chars)")

                    if (!webRtcManager.isInitialized) {
                        webRtcManager.initialize()
                    }

                    val answerSdp = webRtcManager.handleOffer(offer.sdp)
                    val response = json.encodeToString(SdpMessage("answer", answerSdp))
                    call.respondText(response, io.ktor.http.ContentType.Application.Json)
                    Timber.i("Sent WebRTC answer")
                } catch (e: Exception) {
                    Timber.e(e, "WebRTC offer handling failed")
                    call.respond(HttpStatusCode.InternalServerError, """{"error":"${e.message}"}""")
                }
            }

            post("/ice") {
                try {
                    val body = call.receiveText()
                    val candidate = json.decodeFromString<IceCandidateMessage>(body)
                    webRtcManager.addIceCandidate(
                        candidate.sdpMid, candidate.sdpMLineIndex, candidate.candidate
                    )
                    call.respond(HttpStatusCode.OK)
                } catch (e: Exception) {
                    Timber.w(e, "ICE candidate handling failed")
                    call.respond(HttpStatusCode.BadRequest)
                }
            }

            get("/ice") {
                val candidates = webRtcManager.getLocalIceCandidates().map {
                    IceCandidateMessage(it.candidate, it.sdpMid, it.sdpMLineIndex)
                }
                val response = json.encodeToString(IceCandidatesResponse(candidates))
                call.respondText(response, io.ktor.http.ContentType.Application.Json)
            }

            get("/status") {
                val status = if (webRtcManager.isConnected) "connected" else "disconnected"
                call.respondText(
                    """{"webrtc":"$status","initialized":${webRtcManager.isInitialized}}""",
                    io.ktor.http.ContentType.Application.Json
                )
            }
        }
    }
}
