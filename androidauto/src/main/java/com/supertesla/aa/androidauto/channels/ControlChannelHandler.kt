package com.supertesla.aa.androidauto.channels

import com.supertesla.aa.androidauto.proto.ChannelId
import com.supertesla.aa.androidauto.proto.MessageType
import com.supertesla.aa.androidauto.proto.ProtoEncoder
import com.supertesla.aa.androidauto.proto.ServiceDiscovery
import com.supertesla.aa.androidauto.protocol.AapFramer
import com.supertesla.aa.androidauto.protocol.ChannelHandler
import com.supertesla.aa.androidauto.protocol.ChannelMux
import timber.log.Timber

/**
 * Handles control channel (channel 0) messages:
 * service discovery, channel open, ping, audio focus, nav focus, shutdown.
 */
class ControlChannelHandler(
    private val mux: ChannelMux,
    private val serviceDiscoveryPayload: ByteArray,
    private val onChannelOpened: (Int) -> Unit = {},
    private val onShutdown: () -> Unit = {}
) : ChannelHandler {

    override suspend fun onFrame(frame: AapFramer.AapFrame) {
        val msgType = frame.messageType
        val body = frame.messageBody

        when (msgType) {
            MessageType.SERVICE_DISCOVERY_REQUEST -> {
                Timber.i("CTRL: Received ServiceDiscoveryRequest (${body.size} bytes)")
                // Log the request content for debugging
                try {
                    val fields = ProtoEncoder.readFields(body)
                    for (f in fields.take(20)) {
                        if (f.bytesValue != null) {
                            Timber.d("CTRL: SDReq field ${f.fieldNumber} (bytes, ${f.bytesValue.size}b)")
                        } else {
                            Timber.d("CTRL: SDReq field ${f.fieldNumber} = ${f.varintValue}")
                        }
                    }
                } catch (e: Exception) {
                    Timber.d("CTRL: SDReq parse error: ${e.message}")
                }
                // Log full response hex for debugging
                val hex = serviceDiscoveryPayload.joinToString("") { "%02x".format(it) }
                Timber.i("CTRL: SDResp (${serviceDiscoveryPayload.size}b) hex=$hex")
                mux.sendEncrypted(ChannelId.CONTROL, MessageType.SERVICE_DISCOVERY_RESPONSE, serviceDiscoveryPayload)
                Timber.i("CTRL: Sent ServiceDiscoveryResponse (${serviceDiscoveryPayload.size} bytes)")
            }

            MessageType.CHANNEL_OPEN_REQUEST -> {
                val fields = ProtoEncoder.readFields(body)
                // The channel from the frame itself is the target channel
                val channelId = frame.channel
                val serviceId = fields.firstOrNull { it.fieldNumber == 1 }?.intValue ?: -1
                Timber.i("CTRL: ChannelOpenRequest — channel=$channelId serviceId=$serviceId fields=${fields.map { "f${it.fieldNumber}=${it.intValue}" }}")

                // TaaDa sends the response on the same channel as the request
                val response = ServiceDiscovery.buildChannelOpenResponse(status = 0)
                mux.sendEncryptedControl(channelId, MessageType.CHANNEL_OPEN_RESPONSE, response)
                Timber.i("CTRL: Sent ChannelOpenResponse OK for channel=$channelId")

                onChannelOpened(channelId)
            }

            MessageType.PING_REQUEST -> {
                val fields = ProtoEncoder.readFields(body)
                val timestamp = fields.firstOrNull { it.fieldNumber == 1 }?.varintValue ?: System.nanoTime()
                Timber.v("Received PingRequest, ts=$timestamp")

                val response = ServiceDiscovery.buildPingResponse(timestamp)
                mux.sendEncrypted(ChannelId.CONTROL, MessageType.PING_RESPONSE, response)
            }

            MessageType.AUDIO_FOCUS_REQUEST -> {
                // Parse the request
                var requestType = 0
                try {
                    val fields = ProtoEncoder.readFields(body)
                    requestType = fields.firstOrNull { it.fieldNumber == 1 }?.intValue ?: 0
                    Timber.i("CTRL: AudioFocusRequest: requestType=$requestType fields=${fields.map { "f${it.fieldNumber}=${it.varintValue}" }}")
                } catch (_: Exception) {}

                // Map request enum to response enum (different enum spaces):
                // AUDIO_FOCUS_RELEASE (4) -> AUDIO_FOCUS_STATE_LOSS_TRANSIENT_CAN_DUCK (4)
                // Everything else -> AUDIO_FOCUS_STATE_GAIN (1)
                val focusState = if (requestType == 4) 4 else 1
                val response = ServiceDiscovery.buildAudioFocusResponse(focusState)
                mux.sendEncrypted(ChannelId.CONTROL, MessageType.AUDIO_FOCUS_RESPONSE, response)
                Timber.i("CTRL: Sent AudioFocusResponse (state=$focusState for request=$requestType)")
            }

            MessageType.NAVIGATION_FOCUS_REQUEST -> {
                Timber.d("Received NavFocusRequest")
                val response = ServiceDiscovery.buildNavFocusResponse(focusType = 2)
                mux.sendEncrypted(ChannelId.CONTROL, MessageType.NAVIGATION_FOCUS_RESPONSE, response)
            }

            MessageType.PING_RESPONSE -> {
                // AA responding to our heartbeat — connection alive
                Timber.v("CTRL: PingResponse received")
            }

            MessageType.SHUTDOWN_REQUEST -> {
                Timber.w("Received ShutdownRequest")
                mux.sendEncrypted(ChannelId.CONTROL, MessageType.SHUTDOWN_RESPONSE, ByteArray(0))
                onShutdown()
            }

            else -> {
                Timber.d("Control channel: unhandled msgType=0x${msgType.toString(16)}, bodySize=${body.size}")
            }
        }
    }
}
