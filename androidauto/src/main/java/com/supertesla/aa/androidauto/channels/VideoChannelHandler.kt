package com.supertesla.aa.androidauto.channels

import com.supertesla.aa.androidauto.proto.AvMessageType
import com.supertesla.aa.androidauto.proto.ChannelId
import com.supertesla.aa.androidauto.proto.ServiceDiscovery
import com.supertesla.aa.androidauto.protocol.AapFramer
import com.supertesla.aa.androidauto.protocol.ChannelHandler
import com.supertesla.aa.androidauto.protocol.ChannelMux
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import timber.log.Timber
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
            }

            AvMessageType.MEDIA_INDICATION -> {
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
                val sessionId = if (body.isNotEmpty()) {
                    try {
                        val fields = com.supertesla.aa.androidauto.proto.ProtoEncoder.readFields(body)
                        fields.firstOrNull { it.fieldNumber == 1 }?.intValue ?: 0
                    } catch (e: Exception) { 0 }
                } else 0
                Timber.d("Video session ID: $sessionId")
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

            else -> {
                Timber.v("Video: unhandled msgType=0x${msgType.toString(16)}")
            }
        }
    }

    private suspend fun emitVideo(data: ByteArray, timestamp: Long) {
        val num = frameCount.incrementAndGet()
        byteCount.addAndGet(data.size.toLong())

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
}
