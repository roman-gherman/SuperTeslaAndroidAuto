package com.supertesla.aa.androidauto.channels

import com.supertesla.aa.androidauto.proto.AvMessageType
import com.supertesla.aa.androidauto.proto.ChannelId
import com.supertesla.aa.androidauto.protocol.AapFramer
import com.supertesla.aa.androidauto.protocol.ChannelMux
import io.mockk.*
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class PlaybackStatusHandlerTest {

    private lateinit var mux: ChannelMux
    private lateinit var handler: PlaybackStatusHandler

    @BeforeEach
    fun setUp() {
        mux = mockk(relaxed = true)
        handler = PlaybackStatusHandler(mux)
    }

    @Test
    fun `SETUP_REQUEST responds with SetupResponse`() = runTest {
        handler.onFrame(buildFrame(AvMessageType.SETUP_REQUEST, byteArrayOf()))
        verify { mux.sendEncrypted(ChannelId.PLAYBACK_STATUS, AvMessageType.SETUP_RESPONSE, any()) }
    }

    @Test
    fun `START_INDICATION is accepted without crash`() = runTest {
        handler.onFrame(buildFrame(AvMessageType.START_INDICATION, byteArrayOf(0x08, 0x01)))
    }

    @Test
    fun `MEDIA_WITH_TIMESTAMP metadata is accepted without crash`() = runTest {
        handler.onFrame(buildFrame(AvMessageType.MEDIA_WITH_TIMESTAMP, ByteArray(20)))
    }

    @Test
    fun `unknown message type does not crash`() = runTest {
        handler.onFrame(buildFrame(0xFFFF, byteArrayOf()))
    }

    private fun buildFrame(messageType: Int, body: ByteArray): AapFramer.AapFrame {
        val payload = byteArrayOf((messageType shr 8).toByte(), (messageType and 0xFF).toByte()) + body
        return AapFramer.AapFrame(channel = ChannelId.PLAYBACK_STATUS, flags = AapFramer.FLAG_BULK, payload = payload)
    }
}
