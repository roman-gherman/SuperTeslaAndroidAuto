package com.supertesla.aa.androidauto.channels

import com.supertesla.aa.androidauto.proto.AvMessageType
import com.supertesla.aa.androidauto.proto.ChannelId
import com.supertesla.aa.androidauto.proto.ProtoEncoder
import com.supertesla.aa.androidauto.protocol.AapFramer
import com.supertesla.aa.androidauto.protocol.ChannelMux
import io.mockk.*
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MicChannelHandlerTest {

    private lateinit var mux: ChannelMux
    private lateinit var handler: MicChannelHandler

    @BeforeEach
    fun setUp() {
        mux = mockk(relaxed = true)
        handler = MicChannelHandler(mux)
    }

    @Test
    fun `SETUP_REQUEST responds with SetupResponse`() = runTest {
        handler.onFrame(buildFrame(AvMessageType.SETUP_REQUEST, byteArrayOf()))
        verify { mux.sendEncrypted(ChannelId.MIC, AvMessageType.SETUP_RESPONSE, any()) }
    }

    @Test
    fun `MIC_REQUEST open=true responds with MIC_RESPONSE`() = runTest {
        val body = ProtoEncoder.encode { writeVarint(1, 1) } // open=true
        handler.onFrame(buildFrame(MicChannelHandler.MIC_REQUEST, body))
        verify { mux.sendEncrypted(ChannelId.MIC, MicChannelHandler.MIC_RESPONSE, any()) }
    }

    @Test
    fun `MIC_RESPONSE encodes sessionId=0 and status=0`() = runTest {
        val body = ProtoEncoder.encode { writeVarint(1, 1) }
        handler.onFrame(buildFrame(MicChannelHandler.MIC_REQUEST, body))

        val slot = slot<ByteArray>()
        verify { mux.sendEncrypted(ChannelId.MIC, MicChannelHandler.MIC_RESPONSE, capture(slot)) }

        val fields = ProtoEncoder.readFields(slot.captured)
        assertEquals(0L, fields.first { it.fieldNumber == 1 }.varintValue) // sessionId
        assertEquals(0L, fields.first { it.fieldNumber == 2 }.varintValue) // status
    }

    @Test
    fun `MIC_REQUEST open=false does not respond`() = runTest {
        val body = ProtoEncoder.encode { writeVarint(1, 0) } // open=false
        handler.onFrame(buildFrame(MicChannelHandler.MIC_REQUEST, body))
        verify(exactly = 0) { mux.sendEncrypted(ChannelId.MIC, MicChannelHandler.MIC_RESPONSE, any()) }
    }

    @Test
    fun `unknown message type does not crash`() = runTest {
        handler.onFrame(buildFrame(0xFFFF, byteArrayOf(1, 2, 3)))
    }

    private fun buildFrame(messageType: Int, body: ByteArray): AapFramer.AapFrame {
        val payload = byteArrayOf((messageType shr 8).toByte(), (messageType and 0xFF).toByte()) + body
        return AapFramer.AapFrame(channel = ChannelId.MIC, flags = AapFramer.FLAG_BULK, payload = payload)
    }
}
