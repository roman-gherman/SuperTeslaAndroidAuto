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
                Timber.i("Received ServiceDiscoveryRequest")
                mux.sendEncrypted(ChannelId.CONTROL, MessageType.SERVICE_DISCOVERY_RESPONSE, serviceDiscoveryPayload)
                Timber.i("Sent ServiceDiscoveryResponse")
            }

            MessageType.CHANNEL_OPEN_REQUEST -> {
                val fields = ProtoEncoder.readFields(body)
                val channelId = fields.firstOrNull { it.fieldNumber == 2 }?.intValue ?: -1
                Timber.i("Received ChannelOpenRequest for channel $channelId")

                val response = ServiceDiscovery.buildChannelOpenResponse(status = 0)
                mux.sendEncrypted(ChannelId.CONTROL, MessageType.CHANNEL_OPEN_RESPONSE, response)
                Timber.i("Sent ChannelOpenResponse OK for channel $channelId")

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
                Timber.d("Received AudioFocusRequest")
                val response = ServiceDiscovery.buildAudioFocusResponse(focusType = 1)
                mux.sendEncrypted(ChannelId.CONTROL, MessageType.AUDIO_FOCUS_RESPONSE, response)
            }

            MessageType.NAVIGATION_FOCUS_REQUEST -> {
                Timber.d("Received NavFocusRequest")
                val response = ServiceDiscovery.buildNavFocusResponse(focusType = 2)
                mux.sendEncrypted(ChannelId.CONTROL, MessageType.NAVIGATION_FOCUS_RESPONSE, response)
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
