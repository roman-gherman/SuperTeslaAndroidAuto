package com.supertesla.aa.androidauto.channels

import com.supertesla.aa.androidauto.proto.AvMessageType
import com.supertesla.aa.androidauto.proto.ProtoEncoder
import com.supertesla.aa.androidauto.proto.ServiceDiscovery
import com.supertesla.aa.androidauto.protocol.AapFramer
import com.supertesla.aa.androidauto.protocol.ChannelHandler
import com.supertesla.aa.androidauto.protocol.ChannelMux
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import timber.log.Timber
import java.io.ByteArrayOutputStream

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

    // Session ID from START_INDICATION, needed for ACKs
    private var sessionId: Int = 0

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
                sendAck()
            }

            AvMessageType.MEDIA_INDICATION -> {
                if (body.isEmpty()) return
                _audioFrames.emit(AudioFrame(body, System.nanoTime(), channelId))
                sendAck()
            }

            AvMessageType.SETUP_REQUEST -> {
                Timber.i("Audio[$channelName]: received SetupRequest")
                val response = ServiceDiscovery.buildMediaSetupResponse(configIndex = 0)
                mux.sendEncrypted(channelId, AvMessageType.SETUP_RESPONSE, response)
                Timber.i("Audio[$channelName]: sent SetupResponse")
            }

            AvMessageType.START_INDICATION -> {
                // Parse session ID for ACK messages
                try {
                    val fields = ProtoEncoder.readFields(body)
                    sessionId = fields.firstOrNull { it.fieldNumber == 1 }?.intValue ?: 0
                } catch (_: Exception) {}
                Timber.i("Audio[$channelName]: stream started, sessionId=$sessionId")
            }

            AvMessageType.STOP_INDICATION -> {
                Timber.i("Audio[$channelName]: stream stopped")
            }

            else -> {
                Timber.v("Audio[$channelName]: unhandled msgType=0x${msgType.toString(16)}")
            }
        }
    }

    /**
     * Send MEDIA_ACK to AA after receiving audio data.
     * TaaDa sends Ack { sessionId, ack=1 } on the same channel.
     */
    private fun sendAck() {
        val out = ByteArrayOutputStream()
        ProtoEncoder.writeVarintField(out, 1, sessionId.toLong())  // session_id
        ProtoEncoder.writeVarintField(out, 2, 1)                    // ack = 1
        mux.sendEncrypted(channelId, AvMessageType.MEDIA_ACK, out.toByteArray())
    }

    private fun readTimestamp(data: ByteArray): Long {
        var ts = 0L
        for (i in 0 until 8) {
            ts = (ts shl 8) or (data[i].toLong() and 0xFF)
        }
        return ts
    }
}
