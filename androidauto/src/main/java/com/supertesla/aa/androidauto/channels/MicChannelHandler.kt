package com.supertesla.aa.androidauto.channels

import com.supertesla.aa.androidauto.proto.AvMessageType
import com.supertesla.aa.androidauto.proto.ChannelId
import com.supertesla.aa.androidauto.proto.ProtoEncoder
import com.supertesla.aa.androidauto.proto.ServiceDiscovery
import com.supertesla.aa.androidauto.protocol.AapFramer
import com.supertesla.aa.androidauto.protocol.ChannelHandler
import com.supertesla.aa.androidauto.protocol.ChannelMux
import timber.log.Timber
import java.io.ByteArrayOutputStream

/**
 * Handles microphone channel (channel 4).
 * Responds to mic open/close requests from AA.
 * Actual mic recording is not implemented yet — this stub prevents AA from hanging.
 */
class MicChannelHandler(
    private val mux: ChannelMux
) : ChannelHandler {

    companion object {
        const val MIC_REQUEST = 0x8005   // MicrophoneRequest
        const val MIC_RESPONSE = 0x8006  // MicrophoneResponse
    }

    override suspend fun onFrame(frame: AapFramer.AapFrame) {
        when (frame.messageType) {
            AvMessageType.SETUP_REQUEST -> {
                Timber.i("Mic: received SetupRequest")
                val response = ServiceDiscovery.buildMediaSetupResponse(configIndex = 0)
                mux.sendEncrypted(ChannelId.MIC, AvMessageType.SETUP_RESPONSE, response)
            }

            MIC_REQUEST -> {
                val body = frame.messageBody
                val open = if (body.isNotEmpty()) {
                    try {
                        ProtoEncoder.readFields(body).firstOrNull { it.fieldNumber == 1 }?.intValue == 1
                    } catch (_: Exception) { false }
                } else false

                if (open) {
                    Timber.i("Mic: open requested — sending MicResponse(sessionId=0, status=0)")
                    val out = ByteArrayOutputStream()
                    ProtoEncoder.writeVarintField(out, 1, 0) // sessionId
                    ProtoEncoder.writeVarintField(out, 2, 0) // status = OK
                    mux.sendEncrypted(ChannelId.MIC, MIC_RESPONSE, out.toByteArray())
                } else {
                    Timber.i("Mic: close requested")
                }
            }

            AvMessageType.START_INDICATION -> {
                Timber.i("Mic: stream started")
            }

            AvMessageType.STOP_INDICATION -> {
                Timber.i("Mic: stream stopped")
            }

            else -> {
                Timber.v("Mic: unhandled msgType=0x${frame.messageType.toString(16)}")
            }
        }
    }
}
