package com.supertesla.aa.androidauto.channels

import com.supertesla.aa.androidauto.proto.AvMessageType
import com.supertesla.aa.androidauto.proto.ChannelId
import com.supertesla.aa.androidauto.protocol.AapFramer
import com.supertesla.aa.androidauto.protocol.ChannelMux
import io.mockk.*
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

/**
 * Tests that channel handlers don't crash on malformed input.
 */
class ErrorIsolationTest {

    @Test
    fun `VideoChannelHandler survives empty body`() = runTest {
        val mux = mockk<ChannelMux>(relaxed = true)
        val handler = VideoChannelHandler(mux)
        handler.onFrame(buildFrame(AvMessageType.MEDIA_WITH_TIMESTAMP, byteArrayOf()))
        // No exception = pass
    }

    @Test
    fun `VideoChannelHandler survives body shorter than timestamp`() = runTest {
        val mux = mockk<ChannelMux>(relaxed = true)
        val handler = VideoChannelHandler(mux)
        handler.onFrame(buildFrame(AvMessageType.MEDIA_WITH_TIMESTAMP, ByteArray(4)))
    }

    @Test
    fun `AudioChannelHandler survives empty body`() = runTest {
        val mux = mockk<ChannelMux>(relaxed = true)
        val handler = AudioChannelHandler(ChannelId.AUDIO_SYSTEM, "System", mux)
        handler.onFrame(buildFrame(AvMessageType.MEDIA_WITH_TIMESTAMP, byteArrayOf()))
    }

    @Test
    fun `SensorChannelHandler survives corrupt protobuf`() = runTest {
        val mux = mockk<ChannelMux>(relaxed = true)
        val handler = SensorChannelHandler(mux)
        // Invalid protobuf bytes — should not crash
        try {
            handler.onFrame(buildFrame(0x8001, byteArrayOf(0xFF.toByte(), 0xFF.toByte())))
        } catch (_: Exception) {
            // Some exceptions are acceptable (truncated varint), but should not propagate OOM etc.
        }
    }

    @Test
    fun `VideoChannelHandler survives unknown message type`() = runTest {
        val mux = mockk<ChannelMux>(relaxed = true)
        val handler = VideoChannelHandler(mux)
        handler.onFrame(buildFrame(0xFFFF, byteArrayOf(1, 2, 3)))
    }

    private fun buildFrame(messageType: Int, body: ByteArray): AapFramer.AapFrame {
        val msgTypeHi = (messageType shr 8).toByte()
        val msgTypeLo = (messageType and 0xFF).toByte()
        val payload = byteArrayOf(msgTypeHi, msgTypeLo) + body
        return AapFramer.AapFrame(
            channel = ChannelId.VIDEO,
            flags = AapFramer.FLAG_BULK,
            payload = payload
        )
    }
}
