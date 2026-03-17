package com.supertesla.aa.network.relay

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Verifies the PING response sentinel bytes match TaaDa's format.
 */
class PingResponseTest {

    companion object {
        /** TaaDa's exact PING response: 5 bytes */
        val EXPECTED_PING_RESPONSE = byteArrayOf(0x00, 0x00, 0x00, 0x00, 0x1F)
    }

    @Test
    fun `PING response is exactly 5 bytes`() {
        assertEquals(5, EXPECTED_PING_RESPONSE.size)
    }

    @Test
    fun `PING response matches TaaDa format`() {
        assertArrayEquals(
            byteArrayOf(0, 0, 0, 0, 31),
            EXPECTED_PING_RESPONSE
        )
    }

    @Test
    fun `PING response last byte is 0x1F`() {
        assertEquals(0x1F.toByte(), EXPECTED_PING_RESPONSE[4])
    }
}
