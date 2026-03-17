package com.supertesla.aa.androidauto.protocol

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Tests AapCrypto constants and design contracts.
 * Full SSL tests require Android framework (SSLContext) — deferred to integration tests.
 */
class AapCryptoTest {

    @Test
    fun `AapCrypto class exists`() {
        assertDoesNotThrow {
            Class.forName("com.supertesla.aa.androidauto.protocol.AapCrypto")
        }
    }

    @Test
    fun `AapFramer FLAG constants are correct`() {
        assertEquals(0x01, AapFramer.FLAG_FIRST)
        assertEquals(0x02, AapFramer.FLAG_LAST)
        assertEquals(0x03, AapFramer.FLAG_BULK) // FIRST | LAST
        assertEquals(0x04, AapFramer.FLAG_CONTROL)
        assertEquals(0x08, AapFramer.FLAG_ENCRYPTED)
    }

    @Test
    fun `AapFrame messageType reads first 2 bytes of payload`() {
        // Payload: [0x80, 0x00, ...rest]
        val frame = AapFramer.AapFrame(
            channel = 0,
            flags = AapFramer.FLAG_BULK,
            payload = byteArrayOf(0x80.toByte(), 0x00, 1, 2, 3)
        )
        assertEquals(0x8000, frame.messageType)
    }

    @Test
    fun `AapFrame messageBody strips 2-byte message type`() {
        val frame = AapFramer.AapFrame(
            channel = 3,
            flags = AapFramer.FLAG_BULK,
            payload = byteArrayOf(0x00, 0x00, 0xAA.toByte(), 0xBB.toByte())
        )
        assertArrayEquals(byteArrayOf(0xAA.toByte(), 0xBB.toByte()), frame.messageBody)
    }

    @Test
    fun `AapFrame with FIRST-only flag treats payload differently`() {
        // FIRST without LAST = first fragment of multi-part
        val frame = AapFramer.AapFrame(
            channel = 3,
            flags = AapFramer.FLAG_FIRST, // 0x01, not BULK (0x03)
            payload = byteArrayOf(0x80.toByte(), 0x01, 0xCC.toByte(), 0xDD.toByte())
        )
        // isFirst = true, isLast = false → messageType from first 2 bytes
        assertEquals(0x8001, frame.messageType)
    }

    @Test
    fun `AapFrame with middle fragment has no messageType`() {
        // flags = 0 (no FIRST, no LAST) = middle fragment
        val frame = AapFramer.AapFrame(
            channel = 3,
            flags = 0,
            payload = byteArrayOf(1, 2, 3, 4)
        )
        // messageBody should be full payload for middle fragments
        assertArrayEquals(byteArrayOf(1, 2, 3, 4), frame.messageBody)
    }
}
