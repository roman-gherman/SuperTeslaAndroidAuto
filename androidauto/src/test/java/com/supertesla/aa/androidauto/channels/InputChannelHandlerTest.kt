package com.supertesla.aa.androidauto.channels

import com.supertesla.aa.androidauto.proto.ChannelId
import com.supertesla.aa.androidauto.proto.InputMessageType
import com.supertesla.aa.androidauto.proto.ProtoEncoder
import com.supertesla.aa.androidauto.protocol.AapFramer
import com.supertesla.aa.androidauto.protocol.ChannelMux
import io.mockk.*
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class InputChannelHandlerTest {

    private lateinit var mux: ChannelMux
    private lateinit var handler: InputChannelHandler

    @BeforeEach
    fun setUp() {
        mux = mockk(relaxed = true)
        handler = InputChannelHandler(mux, 1280, 720)
    }

    // ===== BINDING_REQUEST =====

    @Test
    fun `BINDING_REQUEST responds with BindingResponse`() = runTest {
        val body = byteArrayOf()
        val frame = buildFrame(InputMessageType.BINDING_REQUEST, body)
        handler.onFrame(frame)
        verify {
            mux.sendEncryptedControl(ChannelId.INPUT, InputMessageType.BINDING_RESPONSE, any())
        }
    }

    // ===== sendMultiTouchEvent =====

    @Test
    fun `sendMultiTouchEvent sends on INPUT channel`() {
        val pointers = listOf(InputChannelHandler.TouchPointer(0, 640, 360))
        handler.sendMultiTouchEvent(InputChannelHandler.ACTION_DOWN, 0, pointers)
        verify { mux.sendEncrypted(ChannelId.INPUT, InputMessageType.INPUT_EVENT, any()) }
    }

    @Test
    fun `sendMultiTouchEvent encodes single pointer`() {
        val pointers = listOf(InputChannelHandler.TouchPointer(0, 500, 300))
        handler.sendMultiTouchEvent(InputChannelHandler.ACTION_DOWN, 0, pointers)

        val slot = slot<ByteArray>()
        verify { mux.sendEncrypted(any(), any(), capture(slot)) }
        val fields = ProtoEncoder.readFields(slot.captured)

        // field 3 = touch_event
        val touchEvent = fields.first { it.fieldNumber == 3 }
        val teFields = ProtoEncoder.readFields(touchEvent.bytesValue!!)

        // field 1 = pointer_data (should have 1)
        val pointerDatas = teFields.filter { it.fieldNumber == 1 }
        assertEquals(1, pointerDatas.size)

        val pdFields = ProtoEncoder.readFields(pointerDatas[0].bytesValue!!)
        assertEquals(500, pdFields.first { it.fieldNumber == 1 }.intValue) // x
        assertEquals(300, pdFields.first { it.fieldNumber == 2 }.intValue) // y
        assertEquals(0, pdFields.first { it.fieldNumber == 3 }.intValue)   // pointerId
    }

    @Test
    fun `sendMultiTouchEvent encodes two pointers`() {
        val pointers = listOf(
            InputChannelHandler.TouchPointer(0, 100, 200),
            InputChannelHandler.TouchPointer(1, 300, 400)
        )
        handler.sendMultiTouchEvent(InputChannelHandler.ACTION_POINTER_DOWN, 1, pointers)

        val slot = slot<ByteArray>()
        verify { mux.sendEncrypted(any(), any(), capture(slot)) }
        val fields = ProtoEncoder.readFields(slot.captured)
        val touchEvent = fields.first { it.fieldNumber == 3 }
        val teFields = ProtoEncoder.readFields(touchEvent.bytesValue!!)

        val pointerDatas = teFields.filter { it.fieldNumber == 1 }
        assertEquals(2, pointerDatas.size, "Should have 2 pointer_data entries")

        // Second pointer
        val pd2 = ProtoEncoder.readFields(pointerDatas[1].bytesValue!!)
        assertEquals(300, pd2.first { it.fieldNumber == 1 }.intValue) // x
        assertEquals(400, pd2.first { it.fieldNumber == 2 }.intValue) // y
        assertEquals(1, pd2.first { it.fieldNumber == 3 }.intValue)   // pointerId
    }

    @Test
    fun `sendMultiTouchEvent encodes actionIndex`() {
        val pointers = listOf(
            InputChannelHandler.TouchPointer(0, 100, 100),
            InputChannelHandler.TouchPointer(1, 200, 200)
        )
        handler.sendMultiTouchEvent(InputChannelHandler.ACTION_POINTER_UP, 1, pointers)

        val slot = slot<ByteArray>()
        verify { mux.sendEncrypted(any(), any(), capture(slot)) }
        val fields = ProtoEncoder.readFields(slot.captured)
        val touchEvent = fields.first { it.fieldNumber == 3 }
        val teFields = ProtoEncoder.readFields(touchEvent.bytesValue!!)

        val actionIndex = teFields.first { it.fieldNumber == 4 }
        assertEquals(1, actionIndex.intValue)
    }

    @Test
    fun `sendMultiTouchEvent encodes action correctly`() {
        val pointers = listOf(InputChannelHandler.TouchPointer(0, 0, 0))
        handler.sendMultiTouchEvent(InputChannelHandler.ACTION_MOVE, 0, pointers)

        val slot = slot<ByteArray>()
        verify { mux.sendEncrypted(any(), any(), capture(slot)) }
        val fields = ProtoEncoder.readFields(slot.captured)
        val touchEvent = fields.first { it.fieldNumber == 3 }
        val teFields = ProtoEncoder.readFields(touchEvent.bytesValue!!)

        val action = teFields.first { it.fieldNumber == 3 }
        assertEquals(InputChannelHandler.ACTION_MOVE, action.intValue)
    }

    // ===== Action mapping =====

    @Test
    fun `mapToAaAction maps correctly`() {
        assertEquals(InputChannelHandler.ACTION_DOWN, InputChannelHandler.mapToAaAction(0, 1))          // DOWN, 1 touch
        assertEquals(InputChannelHandler.ACTION_POINTER_DOWN, InputChannelHandler.mapToAaAction(0, 2))  // DOWN, 2 touches
        assertEquals(InputChannelHandler.ACTION_UP, InputChannelHandler.mapToAaAction(2, 0))            // UP, 0 remaining
        assertEquals(InputChannelHandler.ACTION_POINTER_UP, InputChannelHandler.mapToAaAction(2, 1))    // UP, 1 remaining
        assertEquals(InputChannelHandler.ACTION_MOVE, InputChannelHandler.mapToAaAction(1, 2))          // MOVE, any
        assertEquals(InputChannelHandler.ACTION_UP, InputChannelHandler.mapToAaAction(3, 0))            // CANCEL → UP
    }

    // ===== Helper =====

    private fun buildFrame(messageType: Int, body: ByteArray): AapFramer.AapFrame {
        val msgTypeHi = (messageType shr 8).toByte()
        val msgTypeLo = (messageType and 0xFF).toByte()
        val payload = byteArrayOf(msgTypeHi, msgTypeLo) + body
        return AapFramer.AapFrame(
            channel = ChannelId.INPUT,
            flags = AapFramer.FLAG_BULK,
            payload = payload
        )
    }
}
