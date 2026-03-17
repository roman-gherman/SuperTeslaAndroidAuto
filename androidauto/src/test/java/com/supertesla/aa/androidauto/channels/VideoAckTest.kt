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

class VideoAckTest {

    private lateinit var mux: ChannelMux
    private lateinit var handler: VideoChannelHandler

    @BeforeEach
    fun setUp() {
        mux = mockk(relaxed = true)
        handler = VideoChannelHandler(mux)
    }

    // ===== Session ID Parsing =====

    @Test
    fun `START_INDICATION parses session ID from field 1`() = runTest {
        val body = ProtoEncoder.encode { writeVarint(1, 42) }
        val frame = buildFrame(AvMessageType.START_INDICATION, body)
        handler.onFrame(frame)
        assertEquals(42, handler.sessionId)
    }

    @Test
    fun `START_INDICATION with empty body defaults sessionId to 0`() = runTest {
        val frame = buildFrame(AvMessageType.START_INDICATION, byteArrayOf())
        handler.onFrame(frame)
        assertEquals(0, handler.sessionId)
    }

    @Test
    fun `session ID updates on second START_INDICATION`() = runTest {
        handler.onFrame(buildFrame(AvMessageType.START_INDICATION, ProtoEncoder.encode { writeVarint(1, 10) }))
        assertEquals(10, handler.sessionId)
        handler.onFrame(buildFrame(AvMessageType.START_INDICATION, ProtoEncoder.encode { writeVarint(1, 99) }))
        assertEquals(99, handler.sessionId)
    }

    // ===== sendAck =====

    @Test
    fun `sendAck sends MEDIA_ACK on VIDEO channel`() {
        // Set session ID first
        handler.sessionId = 5
        handler.sendAck()

        verify {
            mux.sendEncrypted(ChannelId.VIDEO, AvMessageType.MEDIA_ACK, any())
        }
    }

    @Test
    fun `sendAck encodes sessionId and ack=1 in protobuf`() {
        handler.sessionId = 42
        handler.sendAck()

        val slot = slot<ByteArray>()
        verify { mux.sendEncrypted(any(), any(), capture(slot)) }

        val fields = ProtoEncoder.readFields(slot.captured)
        val sessionField = fields.first { it.fieldNumber == 1 }
        val ackField = fields.first { it.fieldNumber == 2 }
        assertEquals(42L, sessionField.varintValue, "field 1 should be sessionId")
        assertEquals(1L, ackField.varintValue, "field 2 should be ack=1")
    }

    @Test
    fun `sendAck with sessionId 0 still sends`() {
        handler.sessionId = 0
        handler.sendAck()

        val slot = slot<ByteArray>()
        verify { mux.sendEncrypted(any(), any(), capture(slot)) }

        val fields = ProtoEncoder.readFields(slot.captured)
        assertEquals(0L, fields.first { it.fieldNumber == 1 }.varintValue)
    }

    @Test
    fun `sendAck does nothing when sessionId is negative`() {
        handler.sessionId = -1
        handler.sendAck()
        verify(exactly = 0) { mux.sendEncrypted(any(), any(), any()) }
    }

    // ===== Audio ACK parity =====

    @Test
    fun `audio and video ACK format are identical for same sessionId`() {
        val audioHandler = AudioChannelHandler(ChannelId.AUDIO_SYSTEM, "System", mux)

        // Set sessionId via START_INDICATION on audio handler
        runTest {
            val startBody = ProtoEncoder.encode { writeVarint(1, 7) }
            audioHandler.onFrame(buildFrame(AvMessageType.START_INDICATION, startBody))
        }

        // Set same on video
        handler.sessionId = 7

        // Capture both ACK payloads
        val audioSlot = slot<ByteArray>()
        val videoSlot = slot<ByteArray>()

        // Trigger audio ACK via a data frame
        runTest {
            val audioData = ByteArray(16) { 0 } // 8 timestamp + 8 pcm
            audioHandler.onFrame(buildFrame(AvMessageType.MEDIA_WITH_TIMESTAMP, audioData))
        }
        verify { mux.sendEncrypted(ChannelId.AUDIO_SYSTEM, AvMessageType.MEDIA_ACK, capture(audioSlot)) }

        clearMocks(mux, answers = false)

        // Trigger video ACK
        handler.sendAck()
        verify { mux.sendEncrypted(ChannelId.VIDEO, AvMessageType.MEDIA_ACK, capture(videoSlot)) }

        // Payloads should be identical (same sessionId=7, ack=1)
        assertArrayEquals(audioSlot.captured, videoSlot.captured,
            "Audio and video ACK payloads should be identical for the same sessionId")
    }

    // ===== Helper =====

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
