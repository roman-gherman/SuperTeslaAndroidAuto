package com.supertesla.aa.streaming.video

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import timber.log.Timber
import java.nio.ByteBuffer
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicLong

/**
 * Manages H.264 NAL unit reassembly from Android Auto protocol frames.
 *
 * AA sends video data in fragments with an indicator byte:
 *   0 = Continuation fragment (append to buffer)
 *   1 = Start of new frame (clear buffer, begin accumulating)
 *   2 = End of frame (append, then process completed frame)
 *   3 = Complete frame in single message (process immediately)
 *
 * Data offsets:
 *   - MEDIA_DATA messages: skip first 10 bytes (header)
 *   - CODEC_CONFIG messages: skip first 2 bytes (header)
 *
 * Processed frames are emitted via SharedFlow for downstream consumers
 * (FragmentedMp4Muxer, WebSocket relay, etc.)
 */
class NalStreamManager {

    companion object {
        private const val TAG = "NalStreamManager"
        private const val NAL_BUFFER_SIZE = 8_388_608  // 8MB direct buffer (matches TaaDa)
        private const val KEYFRAME_DEBOUNCE_MS = 2000L
        private const val MEDIA_DATA_HEADER_SIZE = 10
        private const val CODEC_CONFIG_HEADER_SIZE = 2
    }

    /** Processed video frames ready for WebSocket relay */
    private val _videoFrames = MutableSharedFlow<ProcessedFrame>(
        replay = 0,
        extraBufferCapacity = 30
    )
    val videoFrames: SharedFlow<ProcessedFrame> = _videoFrames

    /** 8MB direct buffer for NAL unit assembly */
    private val nalBuffer: ByteBuffer = ByteBuffer.allocateDirect(NAL_BUFFER_SIZE)

    // FPS tracking
    private val frameCount = AtomicLong(0)
    private var lastFpsLogTime = System.currentTimeMillis()
    private var lastFpsFrameCount = 0L

    // First frame detection
    private val firstFrameReceived = AtomicBoolean(false)

    // Keyframe request debounce
    private var lastKeyframeRequestTime = 0L

    // Video focus state
    @Volatile
    var hasFocus = false
        private set

    // Callback to send AA protocol messages (set by TransporterService)
    var onSendVideoFocus: ((projected: Boolean, unsolicited: Boolean) -> Unit)? = null

    data class ProcessedFrame(
        val data: ByteArray,
        val timestamp: Long,
        val frameNumber: Long
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is ProcessedFrame) return false
            return timestamp == other.timestamp && data.contentEquals(other.data)
        }
        override fun hashCode(): Int = data.contentHashCode()
    }

    /**
     * Feed a raw video frame fragment from the AA protocol.
     *
     * @param indicator Fragment type: 0=continue, 1=start, 2=end, 3=complete
     * @param data Raw frame data (includes AA header bytes)
     * @param length Number of valid bytes in data
     * @param isCodecConfig true if this is a codec config (SPS/PPS), false if media data
     */
    fun buildNal(indicator: Int, data: ByteArray, length: Int, isCodecConfig: Boolean) {
        try {
            when (indicator) {
                0 -> {
                    // Continuation: append to buffer
                    val offset = if (isCodecConfig) CODEC_CONFIG_HEADER_SIZE else MEDIA_DATA_HEADER_SIZE
                    if (length > offset && nalBuffer.remaining() >= length - offset) {
                        nalBuffer.put(data, offset, length - offset)
                    }
                }

                1 -> {
                    // Start of new frame: clear buffer and begin
                    nalBuffer.clear()
                    val offset = if (isCodecConfig) CODEC_CONFIG_HEADER_SIZE else MEDIA_DATA_HEADER_SIZE
                    if (length > offset) {
                        nalBuffer.put(data, offset, length - offset)
                    }
                }

                2 -> {
                    // End of frame: append remaining data, then process
                    val offset = if (isCodecConfig) CODEC_CONFIG_HEADER_SIZE else MEDIA_DATA_HEADER_SIZE
                    if (length > offset && nalBuffer.remaining() >= length - offset) {
                        nalBuffer.put(data, offset, length - offset)
                    }
                    nalBuffer.flip()
                    processFrame(nalBuffer)
                }

                3 -> {
                    // Complete frame in single message
                    val offset = if (isCodecConfig) CODEC_CONFIG_HEADER_SIZE else MEDIA_DATA_HEADER_SIZE
                    if (length > offset) {
                        processFrame(ByteBuffer.wrap(data, offset, length - offset))
                    }
                }

                127 -> {
                    // Direct process from buffer
                    nalBuffer.flip()
                    processFrame(nalBuffer)
                }

                else -> {
                    Timber.w("$TAG: Unknown indicator: $indicator")
                }
            }
        } catch (e: Exception) {
            Timber.e(e, "$TAG: Error in buildNal (indicator=$indicator, len=$length)")
            nalBuffer.clear()
        }
    }

    /**
     * Feed a complete, already-extracted H.264 frame (no AA headers).
     * Used when VideoChannelHandler has already stripped the headers.
     */
    suspend fun feedFrame(data: ByteArray, timestamp: Long) {
        val num = frameCount.incrementAndGet()
        trackFirstFrame()
        trackFps(num)
        _videoFrames.emit(ProcessedFrame(data, timestamp, num))
    }

    /**
     * Toggle video focus: tells AA to start/stop sending video.
     */
    fun toggleVideoFocus(focused: Boolean) {
        if (hasFocus == focused) {
            Timber.d("$TAG: Video focus already ${if (focused) "ON" else "OFF"} — skipping")
            return
        }
        hasFocus = focused
        onSendVideoFocus?.invoke(focused, true) // TaaDa always sends unsolicited=true
        Timber.d("$TAG: Video focus ${if (focused) "ON (PROJECTED)" else "OFF (NATIVE)"}")
    }

    /**
     * Request a keyframe from AA (debounced to max once per 2s).
     */
    fun requestKeyFrame() {
        val now = System.currentTimeMillis()
        if (now - lastKeyframeRequestTime < KEYFRAME_DEBOUNCE_MS) {
            Timber.d("$TAG: Keyframe request debounced")
            return
        }
        lastKeyframeRequestTime = now
        onSendVideoFocus?.invoke(true, true)  // unsolicited = keyframe request
        Timber.d("$TAG: Keyframe requested")
    }

    private fun processFrame(buffer: ByteBuffer) {
        if (!buffer.hasRemaining()) return

        val frameData = ByteArray(buffer.remaining())
        buffer.get(frameData)

        val num = frameCount.incrementAndGet()
        trackFirstFrame()
        trackFps(num)

        _videoFrames.tryEmit(ProcessedFrame(frameData, System.nanoTime(), num))
    }

    private fun trackFirstFrame() {
        if (firstFrameReceived.compareAndSet(false, true)) {
            Timber.i("$TAG: First video frame received!")
        }
    }

    private fun trackFps(currentCount: Long) {
        val now = System.currentTimeMillis()
        if (now - lastFpsLogTime >= 5000) {
            val elapsed = (now - lastFpsLogTime) / 1000.0
            val frames = currentCount - lastFpsFrameCount
            val fps = frames / elapsed
            Timber.d("$TAG: %.1f fps, %d frames total".format(fps, currentCount))
            lastFpsLogTime = now
            lastFpsFrameCount = currentCount
        }
    }

    fun reset() {
        nalBuffer.clear()
        frameCount.set(0)
        firstFrameReceived.set(false)
        hasFocus = false
        lastKeyframeRequestTime = 0
        lastFpsLogTime = System.currentTimeMillis()
        lastFpsFrameCount = 0
    }
}
