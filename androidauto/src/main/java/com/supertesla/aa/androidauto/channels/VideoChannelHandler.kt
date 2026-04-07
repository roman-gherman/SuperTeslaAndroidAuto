package com.supertesla.aa.androidauto.channels

import com.supertesla.aa.androidauto.proto.AvMessageType
import com.supertesla.aa.androidauto.proto.ChannelId
import com.supertesla.aa.androidauto.proto.ProtoEncoder
import com.supertesla.aa.androidauto.proto.ServiceDiscovery
import com.supertesla.aa.androidauto.protocol.AapFramer
import com.supertesla.aa.androidauto.protocol.ChannelHandler
import com.supertesla.aa.androidauto.protocol.ChannelMux
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import timber.log.Timber
import java.io.ByteArrayOutputStream
import java.util.concurrent.atomic.AtomicLong

/**
 * Handles video channel (channel 2) messages.
 * Receives H.264 NAL units and emits them via SharedFlow.
 *
 * Video data format:
 * - Message type 0x0000 (MEDIA_WITH_TIMESTAMP): 8 bytes timestamp + H.264 data
 * - Message type 0x0001 (MEDIA_INDICATION): raw H.264 data
 */
class VideoChannelHandler(
    private val mux: ChannelMux
) : ChannelHandler {

    private val _videoFrames = MutableSharedFlow<VideoFrame>(
        replay = 0,
        extraBufferCapacity = 30
    )
    val videoFrames: SharedFlow<VideoFrame> = _videoFrames

    /** Session ID from START_INDICATION, used for ACKs. */
    var sessionId: Int = -1

    // Cache codec config (SPS+PPS) and first IDR for late subscribers
    @Volatile var cachedCodecConfig: ByteArray? = null
        private set
    @Volatile var cachedIdr: ByteArray? = null
        private set

    /** Actual encoded resolution parsed from SPS. Null until first SPS received. */
    @Volatile var encodedWidth: Int? = null
        private set
    @Volatile var encodedHeight: Int? = null
        private set

    /** Called when actual encoded resolution is detected from SPS. */
    var onResolutionDetected: ((width: Int, height: Int) -> Unit)? = null

    private val frameCount = AtomicLong(0)
    private val byteCount = AtomicLong(0)
    private var lastFpsLogTime = System.currentTimeMillis()
    private var lastFpsFrameCount = 0L

    data class VideoFrame(
        val data: ByteArray,
        val timestamp: Long,
        val frameNumber: Long
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is VideoFrame) return false
            return timestamp == other.timestamp && data.contentEquals(other.data)
        }
        override fun hashCode(): Int = data.contentHashCode()
    }

    override suspend fun onFrame(frame: AapFramer.AapFrame) {
        val msgType = frame.messageType
        val body = frame.messageBody

        when (msgType) {
            AvMessageType.MEDIA_WITH_TIMESTAMP -> {
                if (body.size <= 8) return
                val timestamp = readTimestamp(body)
                val videoData = body.copyOfRange(8, body.size)
                emitVideo(videoData, timestamp)
                sendAck() // Server-side ACK (TaaDa sends ACK immediately, not via browser)
            }

            AvMessageType.MEDIA_INDICATION -> {
                // Codec config (SPS/PPS) — do NOT send ACK for this (TaaDa doesn't)
                if (body.isEmpty()) return
                emitVideo(body, System.nanoTime())
            }

            AvMessageType.SETUP_REQUEST -> {
                Timber.i("Video: received SetupRequest")
                val response = ServiceDiscovery.buildMediaSetupResponse(configIndex = 0)
                mux.sendEncrypted(ChannelId.VIDEO, AvMessageType.SETUP_RESPONSE, response)
                Timber.i("Video: sent SetupResponse")
            }

            AvMessageType.START_INDICATION -> {
                Timber.i("Video: stream started (StartIndication)")
                sessionId = if (body.isNotEmpty()) {
                    try {
                        val fields = com.supertesla.aa.androidauto.proto.ProtoEncoder.readFields(body)
                        fields.firstOrNull { it.fieldNumber == 1 }?.intValue ?: 0
                    } catch (e: Exception) { 0 }
                } else 0
                Timber.d("Video session ID: $sessionId")

                // NOW send VideoFocusNotification (0x8008) to tell AA to start
                // sending video frames. TaaDa sends this on channel 3 with
                // focus=PROJECTED, unsolicited=true AFTER the media pipeline
                // is ready (SetupRequest → SetupResponse → START_INDICATION).
                val focusPayload = ServiceDiscovery.buildVideoFocusIndication(mode = 1, unsolicited = true)
                mux.sendEncrypted(ChannelId.VIDEO, AvMessageType.VIDEO_FOCUS_INDICATION, focusPayload)
                Timber.i("Video: sent VideoFocusNotification(PROJECTED, unsolicited=true) on ch=3 type=0x8008 AFTER StartIndication")
            }

            AvMessageType.STOP_INDICATION -> {
                Timber.i("Video: stream stopped (StopIndication)")
            }

            AvMessageType.VIDEO_FOCUS_REQUEST -> {
                Timber.d("Video: received VideoFocusRequest")
                val response = ServiceDiscovery.buildVideoFocusIndication()
                mux.sendEncrypted(ChannelId.VIDEO, AvMessageType.VIDEO_FOCUS_INDICATION, response)
            }

            AvMessageType.MEDIA_ACK -> {
                // Acknowledgment from phone - no action needed
            }

            AvMessageType.SETUP_RESPONSE -> {
                Timber.i("Video: received SetupResponse")
            }

            else -> {
                Timber.v("Video: unhandled msgType=0x${msgType.toString(16)}")
            }
        }
    }

    /**
     * Request a keyframe (IDR + SPS/PPS) from Android Auto.
     */
    fun requestKeyframe() {
        Timber.i("Video: requesting keyframe via VIDEO_FOCUS_REQUEST (0x8007)")
        val payload = ServiceDiscovery.buildVideoFocusIndication(mode = 1, unsolicited = true)
        mux.sendEncrypted(ChannelId.VIDEO, AvMessageType.VIDEO_FOCUS_REQUEST, payload)
    }

    /**
     * Send MEDIA_ACK to AA for video frames.
     * Called by the browser via WebSocket when it has processed a frame.
     * TaaDa uses browser-driven ACKs with maxUnacked=1 for flow control.
     */
    fun sendAck() {
        if (sessionId < 0) return
        val out = ByteArrayOutputStream()
        ProtoEncoder.writeVarintField(out, 1, sessionId.toLong())
        ProtoEncoder.writeVarintField(out, 2, 1) // ack = 1
        mux.sendEncrypted(ChannelId.VIDEO, AvMessageType.MEDIA_ACK, out.toByteArray())
    }

    private suspend fun emitVideo(data: ByteArray, timestamp: Long) {
        val num = frameCount.incrementAndGet()
        byteCount.addAndGet(data.size.toLong())

        // Debug: log NAL types found in the data
        if (num <= 10 || num % 100 == 0L) {
            // Find all NAL start codes and their types
            val nalTypes = mutableListOf<Int>()
            for (i in 0 until data.size - 4) {
                if (data[i] == 0.toByte() && data[i+1] == 0.toByte() &&
                    data[i+2] == 0.toByte() && data[i+3] == 1.toByte()) {
                    nalTypes.add(data[i+4].toInt() and 0x1F)
                }
            }
            val hex = data.take(20).joinToString(" ") { "%02x".format(it) }
            Timber.i("Video#$num: NALs=$nalTypes, ${data.size}b, first20=[$hex]")
        }

        // Cache SPS+PPS (codec config) and IDR for late subscribers
        if (data.size >= 5 && data[0] == 0.toByte() && data[1] == 0.toByte() &&
            data[2] == 0.toByte() && data[3] == 1.toByte()) {
            val nalType = data[4].toInt() and 0x1F
            if (nalType == 7) { // SPS (often SPS+PPS combined)
                cachedCodecConfig = data.copyOf()
                // Parse actual encoded resolution from SPS
                try {
                    val spsBody = data.copyOfRange(5, data.size) // skip start code + NAL header
                    val dim = parseSpsResolution(spsBody)
                    if (dim != null && (dim.first != encodedWidth || dim.second != encodedHeight)) {
                        encodedWidth = dim.first
                        encodedHeight = dim.second
                        Timber.i("Video: actual encoded resolution: ${dim.first}x${dim.second}")
                        onResolutionDetected?.invoke(dim.first, dim.second)
                    }
                } catch (e: Exception) {
                    Timber.w("Video: SPS parse failed: ${e.message}")
                }
                Timber.i("Video: cached codec config (SPS+PPS), ${data.size}b")
            } else if (nalType == 5) { // IDR
                cachedIdr = data.copyOf()
            }
        }

        _videoFrames.emit(VideoFrame(data, timestamp, num))

        // Log FPS every 5 seconds
        val now = System.currentTimeMillis()
        if (now - lastFpsLogTime >= 5000) {
            val elapsed = (now - lastFpsLogTime) / 1000.0
            val frames = num - lastFpsFrameCount
            val fps = frames / elapsed
            val kbps = (byteCount.get() * 8 / 1000.0 / elapsed).toLong()
            Timber.d("Video: %.1f fps, %d kbps, %d frames total".format(fps, kbps, num))
            lastFpsLogTime = now
            lastFpsFrameCount = num
            byteCount.set(0)
        }
    }

    private fun readTimestamp(data: ByteArray): Long {
        var ts = 0L
        for (i in 0 until 8) {
            ts = (ts shl 8) or (data[i].toLong() and 0xFF)
        }
        return ts
    }

    /**
     * Parse width/height from H.264 SPS NAL body (after NAL header byte).
     * Returns (width, height) or null on parse failure.
     */
    private fun parseSpsResolution(sps: ByteArray): Pair<Int, Int>? {
        if (sps.size < 4) return null
        val reader = BitReader(sps)
        val profileIdc = reader.readBits(8)
        reader.readBits(8) // constraint flags
        reader.readBits(8) // level_idc
        reader.readUe() // seq_parameter_set_id

        // High profile has extra fields
        if (profileIdc in intArrayOf(100, 110, 122, 244, 44, 83, 86, 118, 128, 138, 139, 134)) {
            val chromaFormatIdc = reader.readUe()
            if (chromaFormatIdc == 3) reader.readBits(1) // separate_colour_plane_flag
            reader.readUe() // bit_depth_luma_minus8
            reader.readUe() // bit_depth_chroma_minus8
            reader.readBits(1) // qpprime_y_zero_transform_bypass_flag
            val scalingMatrixPresent = reader.readBits(1)
            if (scalingMatrixPresent == 1) {
                val count = if (chromaFormatIdc != 3) 8 else 12
                for (i in 0 until count) {
                    if (reader.readBits(1) == 1) { // scaling_list_present_flag
                        val size = if (i < 6) 16 else 64
                        var last = 8; var next = 8
                        for (j in 0 until size) {
                            if (next != 0) next = (last + reader.readSe() + 256) % 256
                            last = if (next == 0) last else next
                        }
                    }
                }
            }
        }

        reader.readUe() // log2_max_frame_num_minus4
        val picOrderCntType = reader.readUe()
        if (picOrderCntType == 0) {
            reader.readUe() // log2_max_pic_order_cnt_lsb_minus4
        } else if (picOrderCntType == 1) {
            reader.readBits(1) // delta_pic_order_always_zero_flag
            reader.readSe() // offset_for_non_ref_pic
            reader.readSe() // offset_for_top_to_bottom_field
            val numRefFrames = reader.readUe()
            for (i in 0 until numRefFrames) reader.readSe()
        }
        reader.readUe() // max_num_ref_frames
        reader.readBits(1) // gaps_in_frame_num_value_allowed_flag

        val picWidthInMbsMinus1 = reader.readUe()
        val picHeightInMapUnitsMinus1 = reader.readUe()
        val frameMbsOnlyFlag = reader.readBits(1)
        if (frameMbsOnlyFlag == 0) reader.readBits(1) // mb_adaptive_frame_field_flag

        reader.readBits(1) // direct_8x8_inference_flag

        var cropLeft = 0; var cropRight = 0; var cropTop = 0; var cropBottom = 0
        val frameCroppingFlag = reader.readBits(1)
        if (frameCroppingFlag == 1) {
            cropLeft = reader.readUe() * 2
            cropRight = reader.readUe() * 2
            cropTop = reader.readUe() * 2 * (2 - frameMbsOnlyFlag)
            cropBottom = reader.readUe() * 2 * (2 - frameMbsOnlyFlag)
        }

        val width = (picWidthInMbsMinus1 + 1) * 16 - cropLeft - cropRight
        val height = (picHeightInMapUnitsMinus1 + 1) * 16 * (2 - frameMbsOnlyFlag) - cropTop - cropBottom
        return Pair(width, height)
    }

    /** Exp-Golomb bit reader for SPS parsing. */
    private class BitReader(private val data: ByteArray) {
        private var byteOffset = 0
        private var bitOffset = 0

        fun readBits(n: Int): Int {
            var result = 0
            for (i in 0 until n) {
                if (byteOffset >= data.size) return result
                result = (result shl 1) or ((data[byteOffset].toInt() shr (7 - bitOffset)) and 1)
                bitOffset++
                if (bitOffset == 8) { bitOffset = 0; byteOffset++ }
            }
            return result
        }

        fun readUe(): Int {
            var zeros = 0
            while (readBits(1) == 0 && zeros < 31) zeros++
            return if (zeros == 0) 0 else ((1 shl zeros) - 1 + readBits(zeros))
        }

        fun readSe(): Int {
            val v = readUe()
            return if (v % 2 == 0) -(v / 2) else (v + 1) / 2
        }
    }
}
