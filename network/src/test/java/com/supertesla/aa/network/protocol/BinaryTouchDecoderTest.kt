package com.supertesla.aa.network.protocol

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.nio.ByteBuffer

class BinaryTouchDecoderTest {

    // ===== isBinaryFormat detection =====

    @Test
    fun `isBinaryFormat returns true for valid DOWN with 1 touch`() {
        val data = buildBinaryTouch(action = 0, touches = listOf(Triple(0, 640, 360)))
        assertTrue(BinaryTouchDecoder.isBinaryFormat(data))
    }

    @Test
    fun `isBinaryFormat returns false for too-short data`() {
        assertFalse(BinaryTouchDecoder.isBinaryFormat(ByteArray(7)))
    }

    @Test
    fun `isBinaryFormat returns false for action greater than 3`() {
        val data = ByteArray(8).apply { this[0] = 4; this[1] = 1 }
        assertFalse(BinaryTouchDecoder.isBinaryFormat(data))
    }

    @Test
    fun `isBinaryFormat returns false for touchCount greater than 10`() {
        val data = ByteArray(8).apply { this[0] = 0; this[1] = 11 }
        assertFalse(BinaryTouchDecoder.isBinaryFormat(data))
    }

    @Test
    fun `isBinaryFormat accepts touchCount 10 as valid max`() {
        val data = ByteArray(8 + 10 * 6).apply { this[0] = 1; this[1] = 10 }
        assertTrue(BinaryTouchDecoder.isBinaryFormat(data))
    }

    // ===== decode =====

    @Test
    fun `decode single touch DOWN`() {
        val data = buildBinaryTouch(action = 0, touches = listOf(Triple(0, 500, 300)))
        val result = BinaryTouchDecoder.decode(data)

        assertEquals(0, result.action) // DOWN
        assertEquals(1, result.touches.size)
        assertEquals(0, result.touches[0].id)
        assertEquals(500, result.touches[0].x)
        assertEquals(300, result.touches[0].y)
    }

    @Test
    fun `decode two-touch MOVE with allTouches`() {
        val data = buildBinaryTouch(
            action = 1, // MOVE
            touches = listOf(Triple(0, 100, 200)),
            allTouches = listOf(Triple(0, 100, 200), Triple(1, 300, 400))
        )
        val result = BinaryTouchDecoder.decode(data)

        assertEquals(1, result.action) // MOVE
        assertEquals(1, result.touches.size)
        assertEquals(2, result.allTouches.size)
        assertEquals(1, result.allTouches[1].id)
        assertEquals(300, result.allTouches[1].x)
        assertEquals(400, result.allTouches[1].y)
    }

    @Test
    fun `decode UP with zero allTouches`() {
        val data = buildBinaryTouch(action = 2, touches = listOf(Triple(0, 640, 360)), allTouches = emptyList())
        val result = BinaryTouchDecoder.decode(data)

        assertEquals(2, result.action)
        assertEquals(1, result.touches.size)
        assertEquals(0, result.allTouches.size)
    }

    @Test
    fun `decode max coordinate values (uint16 max)`() {
        val data = buildBinaryTouch(action = 0, touches = listOf(Triple(65535, 65535, 65535)))
        val result = BinaryTouchDecoder.decode(data)

        assertEquals(65535, result.touches[0].id)
        assertEquals(65535, result.touches[0].x)
        assertEquals(65535, result.touches[0].y)
    }

    @Test
    fun `decode extracts timestamp delta`() {
        val data = buildBinaryTouch(action = 0, touches = listOf(Triple(0, 0, 0)), timestampDelta = 12345)
        val result = BinaryTouchDecoder.decode(data)
        assertEquals(12345L, result.timestampDelta)
    }

    // ===== Helper =====

    private fun buildBinaryTouch(
        action: Int,
        touches: List<Triple<Int, Int, Int>>, // id, x, y
        allTouches: List<Triple<Int, Int, Int>> = touches,
        timestampDelta: Int = 0
    ): ByteArray {
        val size = 1 + 1 + touches.size * 6 + 1 + allTouches.size * 6 + 4
        val buf = ByteBuffer.allocate(size)
        buf.put(action.toByte())
        buf.put(touches.size.toByte())
        for ((id, x, y) in touches) {
            buf.putShort(id.toShort())
            buf.putShort(x.toShort())
            buf.putShort(y.toShort())
        }
        buf.put(allTouches.size.toByte())
        for ((id, x, y) in allTouches) {
            buf.putShort(id.toShort())
            buf.putShort(x.toShort())
            buf.putShort(y.toShort())
        }
        buf.putInt(timestampDelta)
        return buf.array()
    }
}
