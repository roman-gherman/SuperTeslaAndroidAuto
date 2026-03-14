package com.supertesla.aa.network.webserver

import android.util.Log
import com.supertesla.aa.streaming.video.FragmentedMp4Muxer
import com.supertesla.aa.streaming.video.NalUnitParser
import io.ktor.websocket.DefaultWebSocketSession
import io.ktor.websocket.Frame
import kotlinx.coroutines.flow.Flow
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicLong

/**
 * Streams H.264 video as fMP4 segments to WebSocket clients.
 * Handles both Annex B (from AAP) and raw encoder output (from MediaProjection).
 */
class VideoStreamHandler(
    private val width: Int,
    private val height: Int,
    private val frameRate: Int
) {
    private val muxer = FragmentedMp4Muxer(width, height, frameRate)
    private val clients = ConcurrentHashMap<String, ClientState>()
    private val framesSent = AtomicLong(0)

    // SPS/PPS cached from codec config output
    private var cachedSps: ByteArray? = null
    private var cachedPps: ByteArray? = null
    private var initSegment: ByteArray? = null

    companion object {
        private const val TAG = "VideoStreamHandler"
    }

    private data class ClientState(
        val session: DefaultWebSocketSession,
        var initSent: Boolean = false
    )

    suspend fun handleClient(session: DefaultWebSocketSession, videoFlow: Flow<ByteArray>) {
        val clientId = java.util.UUID.randomUUID().toString().take(8)
        val state = ClientState(session)
        clients[clientId] = state
        Log.i(TAG, "Client connected: $clientId")

        try {
            videoFlow.collect { h264Data ->
                processFrame(state, h264Data)
            }
        } catch (e: Exception) {
            Log.d(TAG, "Client $clientId ended: ${e.message}")
        } finally {
            clients.remove(clientId)
            Log.i(TAG, "Client disconnected: $clientId")
        }
    }

    private suspend fun processFrame(state: ClientState, data: ByteArray) {
        if (data.isEmpty()) return

        // Detect format: Annex B starts with 0x00000001, raw AVCC doesn't
        val isAnnexB = data.size >= 4 &&
                data[0] == 0.toByte() && data[1] == 0.toByte() &&
                data[2] == 0.toByte() && data[3] == 1.toByte()

        if (isAnnexB) {
            processAnnexB(state, data)
        } else {
            processRawEncoder(state, data)
        }
    }

    /**
     * Process raw MediaCodec encoder output.
     * First frame with SPS+PPS is codec config, subsequent frames are H.264 data.
     */
    private suspend fun processRawEncoder(state: ClientState, data: ByteArray) {
        // Check if this looks like SPS (NAL type 7) - first byte after possible length prefix
        val nalType = findNalType(data)

        if (nalType == 7) {
            // Codec config: contains SPS + PPS
            extractSpsAndPps(data)
            if (cachedSps != null && cachedPps != null && !state.initSent) {
                sendInitSegment(state)
            }
            return
        }

        if (!state.initSent) return

        // Regular frame - wrap as fMP4 segment
        val isKeyframe = nalType == 5
        try {
            // Data from MediaCodec is already in AVCC format (length-prefixed)
            val frame = FragmentedMp4Muxer.VideoFrame(data, isKeyframe)
            val segment = muxer.createMediaSegment(listOf(frame))
            state.session.send(Frame.Binary(true, segment))
            framesSent.incrementAndGet()
        } catch (e: Exception) {
            Log.v(TAG, "Send failed: ${e.message}")
        }
    }

    /**
     * Process Annex B format (from AAP protocol).
     */
    private suspend fun processAnnexB(state: ClientState, data: ByteArray) {
        val parser = NalUnitParser()
        val nalUnits = parser.parse(data)

        for (nal in nalUnits) {
            when (nal.type) {
                NalUnitParser.NalType.SPS -> {
                    cachedSps = nal.dataWithoutStartCode
                    if (cachedPps != null && !state.initSent) sendInitSegment(state)
                }
                NalUnitParser.NalType.PPS -> {
                    cachedPps = nal.dataWithoutStartCode
                    if (cachedSps != null && !state.initSent) sendInitSegment(state)
                }
                NalUnitParser.NalType.SLICE_IDR -> {
                    if (!state.initSent && cachedSps != null && cachedPps != null) sendInitSegment(state)
                    if (state.initSent) {
                        val avcc = NalUnitParser.annexBToAvcc(nal)
                        val frame = FragmentedMp4Muxer.VideoFrame(avcc, isKeyframe = true)
                        try {
                            state.session.send(Frame.Binary(true, muxer.createMediaSegment(listOf(frame))))
                            framesSent.incrementAndGet()
                        } catch (_: Exception) {}
                    }
                }
                NalUnitParser.NalType.SLICE_NON_IDR -> {
                    if (state.initSent) {
                        val avcc = NalUnitParser.annexBToAvcc(nal)
                        val frame = FragmentedMp4Muxer.VideoFrame(avcc, isKeyframe = false)
                        try {
                            state.session.send(Frame.Binary(true, muxer.createMediaSegment(listOf(frame))))
                            framesSent.incrementAndGet()
                        } catch (_: Exception) {}
                    }
                }
                else -> {}
            }
        }
    }

    private suspend fun sendInitSegment(state: ClientState) {
        val sps = cachedSps ?: return
        val pps = cachedPps ?: return

        try {
            muxer.reset()
            val init = muxer.createInitSegment(sps, pps)
            initSegment = init
            state.session.send(Frame.Binary(true, init))
            state.initSent = true
            Log.i(TAG, "Init segment sent: ${init.size} bytes, SPS=${sps.size}, PPS=${pps.size}")
        } catch (e: Exception) {
            Log.w(TAG, "Failed to send init: ${e.message}")
        }
    }

    /**
     * Extract SPS and PPS from codec config data.
     * MediaCodec outputs them concatenated with Annex B start codes.
     */
    private fun extractSpsAndPps(configData: ByteArray) {
        // Config data is usually: [0x00 0x00 0x00 0x01] SPS [0x00 0x00 0x00 0x01] PPS
        val positions = mutableListOf<Int>()
        for (i in 0 until configData.size - 3) {
            if (configData[i] == 0.toByte() && configData[i + 1] == 0.toByte()) {
                if (i + 3 < configData.size && configData[i + 2] == 0.toByte() && configData[i + 3] == 1.toByte()) {
                    positions.add(i)
                } else if (configData[i + 2] == 1.toByte()) {
                    positions.add(i)
                }
            }
        }

        if (positions.size >= 2) {
            val spsStart = positions[0]
            val ppsStart = positions[1]
            val startCodeLen1 = if (configData[spsStart + 2] == 0.toByte()) 4 else 3
            val startCodeLen2 = if (configData[ppsStart + 2] == 0.toByte()) 4 else 3

            cachedSps = configData.copyOfRange(spsStart + startCodeLen1, ppsStart)
            cachedPps = configData.copyOfRange(ppsStart + startCodeLen2, configData.size)
            Log.i(TAG, "Extracted SPS(${cachedSps?.size}) + PPS(${cachedPps?.size}) from config")
        } else if (positions.size == 1) {
            // Single NAL - check type
            val startCodeLen = if (configData[positions[0] + 2] == 0.toByte()) 4 else 3
            val nalBody = configData.copyOfRange(positions[0] + startCodeLen, configData.size)
            val type = nalBody[0].toInt() and 0x1F
            if (type == 7) cachedSps = nalBody
            else if (type == 8) cachedPps = nalBody
        }
    }

    private fun findNalType(data: ByteArray): Int {
        // Check for Annex B start code first
        if (data.size >= 5 && data[0] == 0.toByte() && data[1] == 0.toByte()) {
            if (data[2] == 0.toByte() && data[3] == 1.toByte()) {
                return data[4].toInt() and 0x1F
            }
            if (data[2] == 1.toByte()) {
                return data[3].toInt() and 0x1F
            }
        }
        // AVCC format: first 4 bytes are length, then NAL
        if (data.size >= 5) {
            return data[4].toInt() and 0x1F
        }
        return -1
    }

    suspend fun sendWaitingMessage(session: DefaultWebSocketSession) {
        try {
            session.send(Frame.Text("""{"type":"status","message":"Waiting for Android Auto video..."}"""))
        } catch (_: Exception) {}
    }

    val connectedClients: Int get() = clients.size
    val totalFramesSent: Long get() = framesSent.get()
}
