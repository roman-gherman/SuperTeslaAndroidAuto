package com.supertesla.aa.androidauto.channels

import com.supertesla.aa.androidauto.proto.AvMessageType
import com.supertesla.aa.androidauto.proto.ChannelId
import com.supertesla.aa.androidauto.proto.ServiceDiscovery
import com.supertesla.aa.androidauto.protocol.AapFramer
import com.supertesla.aa.androidauto.protocol.ChannelHandler
import com.supertesla.aa.androidauto.protocol.ChannelMux
import timber.log.Timber

/**
 * Handles media playback status channel (channel 9).
 * AA sends song title, artist, album, duration, and album art here.
 * This stub accepts all messages silently to prevent AA from stalling.
 */
class PlaybackStatusHandler(
    private val mux: ChannelMux
) : ChannelHandler {

    override suspend fun onFrame(frame: AapFramer.AapFrame) {
        when (frame.messageType) {
            AvMessageType.SETUP_REQUEST -> {
                Timber.i("PlaybackStatus: received SetupRequest")
                val response = ServiceDiscovery.buildMediaSetupResponse(configIndex = 0)
                mux.sendEncrypted(ChannelId.PLAYBACK_STATUS, AvMessageType.SETUP_RESPONSE, response)
            }

            AvMessageType.START_INDICATION -> {
                Timber.d("PlaybackStatus: stream started")
            }

            AvMessageType.MEDIA_WITH_TIMESTAMP, AvMessageType.MEDIA_INDICATION -> {
                // Metadata arrives here — silently accept for now
                Timber.v("PlaybackStatus: metadata received (${frame.messageBody.size}b)")
            }

            AvMessageType.STOP_INDICATION -> {
                Timber.d("PlaybackStatus: stream stopped")
            }

            else -> {
                Timber.v("PlaybackStatus: unhandled msgType=0x${frame.messageType.toString(16)}")
            }
        }
    }
}
