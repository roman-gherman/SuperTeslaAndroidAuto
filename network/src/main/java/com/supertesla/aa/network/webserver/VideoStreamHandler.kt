package com.supertesla.aa.network.webserver

import com.supertesla.aa.streaming.video.FragmentedMp4Muxer
import com.supertesla.aa.streaming.video.NalUnitParser
import io.ktor.websocket.DefaultWebSocketSession
import io.ktor.websocket.Frame
import kotlinx.coroutines.flow.Flow
import timber.log.Timber
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicLong

/**
 * Handles streaming fMP4 video segments to connected WebSocket clients.
 * Receives raw H.264 data from the AA emulator, parses NAL units,
 * muxes into fMP4, and streams to all connected browsers.
 */
class VideoStreamHandler(
    private val width: Int,
    private val height: Int,
    private val frameRate: Int
) {
    private val nalParser = NalUnitParser()
    private val muxer = FragmentedMp4Muxer(width, height, frameRate)
    private val clients = ConcurrentHashMap<String, ClientState>()
    private val framesSent = AtomicLong(0)

    private data class ClientState(
        val session: DefaultWebSocketSession,
        var initSent: Boolean = false
    )

    /**
     * Handle a new WebSocket client connection for video streaming.
     * Blocks until the client disconnects.
     */
    suspend fun handleClient(session: DefaultWebSocketSession, videoFlow: Flow<ByteArray>) {
        val clientId = java.util.UUID.randomUUID().toString().take(8)
        val state = ClientState(session)
        clients[clientId] = state
        Timber.i("Video client connected: $clientId (total: ${clients.size})")

        try {
            videoFlow.collect { rawH264Data ->
                processVideoData(clientId, state, rawH264Data)
            }
        } catch (e: Exception) {
            Timber.d("Video client $clientId stream ended: ${e.message}")
        } finally {
            clients.remove(clientId)
            Timber.i("Video client disconnected: $clientId (total: ${clients.size})")
        }
    }

    private suspend fun processVideoData(clientId: String, state: ClientState, rawH264: ByteArray) {
        val nalUnits = nalParser.parse(rawH264)
        for (nalUnit in nalUnits) {
            when (nalUnit.type) {
                NalUnitParser.NalType.SPS, NalUnitParser.NalType.PPS -> {
                    if (!state.initSent && nalParser.hasSpsAndPps) {
                        sendInitSegment(state)
                    }
                }

                NalUnitParser.NalType.SLICE_IDR -> {
                    if (!state.initSent && nalParser.hasSpsAndPps) {
                        sendInitSegment(state)
                    }
                    if (state.initSent) {
                        sendMediaSegment(state, nalUnit, isKeyframe = true)
                    }
                }

                NalUnitParser.NalType.SLICE_NON_IDR -> {
                    if (state.initSent) {
                        sendMediaSegment(state, nalUnit, isKeyframe = false)
                    }
                }

                else -> {}
            }
        }
    }

    private suspend fun sendInitSegment(state: ClientState) {
        val sps = nalParser.cachedSps ?: return
        val pps = nalParser.cachedPps ?: return

        try {
            muxer.reset()
            val initSegment = muxer.createInitSegment(sps, pps)
            state.session.send(Frame.Binary(true, initSegment))
            state.initSent = true
            Timber.i("Sent init segment (${initSegment.size} bytes)")
        } catch (e: Exception) {
            Timber.w("Failed to send init segment: ${e.message}")
        }
    }

    private suspend fun sendMediaSegment(
        state: ClientState,
        nalUnit: NalUnitParser.NalUnit,
        isKeyframe: Boolean
    ) {
        try {
            val avccData = NalUnitParser.annexBToAvcc(nalUnit)
            val frame = FragmentedMp4Muxer.VideoFrame(avccData, isKeyframe)
            val segment = muxer.createMediaSegment(listOf(frame))
            state.session.send(Frame.Binary(true, segment))
            framesSent.incrementAndGet()
        } catch (e: Exception) {
            Timber.v("Failed to send media segment: ${e.message}")
        }
    }

    /**
     * Broadcast a message to all connected clients that video is not yet available.
     */
    suspend fun sendWaitingMessage(session: DefaultWebSocketSession) {
        try {
            session.send(Frame.Text("""{"type":"status","message":"Waiting for Android Auto video..."}"""))
        } catch (_: Exception) {}
    }

    val connectedClients: Int get() = clients.size
    val totalFramesSent: Long get() = framesSent.get()
}
