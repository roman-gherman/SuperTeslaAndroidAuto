package com.supertesla.aa.androidauto.channels

import com.supertesla.aa.androidauto.proto.AvMessageType
import com.supertesla.aa.androidauto.proto.ServiceDiscovery
import com.supertesla.aa.androidauto.protocol.AapFramer
import com.supertesla.aa.androidauto.protocol.ChannelHandler
import com.supertesla.aa.androidauto.protocol.ChannelMux
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import timber.log.Timber

/**
 * Handles audio channel messages (channels 4/5/6).
 * Receives PCM audio data and emits via SharedFlow.
 *
 * Audio data format:
 * - Same as video: 8 bytes timestamp + raw PCM data
 */
class AudioChannelHandler(
    private val channelId: Int,
    private val channelName: String,
    private val mux: ChannelMux
) : ChannelHandler {

    private val _audioFrames = MutableSharedFlow<AudioFrame>(
        replay = 0,
        extraBufferCapacity = 64
    )
    val audioFrames: SharedFlow<AudioFrame> = _audioFrames

    data class AudioFrame(
        val data: ByteArray,
        val timestamp: Long,
        val channelId: Int
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is AudioFrame) return false
            return timestamp == other.timestamp && channelId == other.channelId && data.contentEquals(other.data)
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
                val audioData = body.copyOfRange(8, body.size)
                _audioFrames.emit(AudioFrame(audioData, timestamp, channelId))
            }

            AvMessageType.MEDIA_INDICATION -> {
                if (body.isEmpty()) return
                _audioFrames.emit(AudioFrame(body, System.nanoTime(), channelId))
            }

            AvMessageType.SETUP_REQUEST -> {
                Timber.i("Audio[$channelName]: received SetupRequest")
                val response = ServiceDiscovery.buildMediaSetupResponse(configIndex = 0)
                mux.sendEncrypted(channelId, AvMessageType.SETUP_RESPONSE, response)
                Timber.i("Audio[$channelName]: sent SetupResponse")
            }

            AvMessageType.START_INDICATION -> {
                Timber.i("Audio[$channelName]: stream started")
            }

            AvMessageType.STOP_INDICATION -> {
                Timber.i("Audio[$channelName]: stream stopped")
            }

            else -> {
                Timber.v("Audio[$channelName]: unhandled msgType=0x${msgType.toString(16)}")
            }
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
