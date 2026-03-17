package com.supertesla.aa.network.dns

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Tests DNS hostname matching and query name extraction logic.
 * Tests the pure logic — no socket/network operations.
 */
class LocalDnsServerTest {

    @Test
    fun `DEFAULT_HOSTNAME is super_taa`() {
        assertEquals("super.taa", LocalDnsServer.DEFAULT_HOSTNAME)
    }

    @Test
    fun `matchesHostname is case insensitive`() {
        val server = LocalDnsServer(hostname = "super.taa")
        // Use reflection to test private method
        val method = server.javaClass.getDeclaredMethod("matchesHostname", String::class.java)
        method.isAccessible = true

        assertTrue(method.invoke(server, "super.taa") as Boolean)
        assertTrue(method.invoke(server, "SUPER.TAA") as Boolean)
        assertTrue(method.invoke(server, "Super.Taa") as Boolean)
    }

    @Test
    fun `matchesHostname accepts FQDN with trailing dot`() {
        val server = LocalDnsServer(hostname = "super.taa")
        val method = server.javaClass.getDeclaredMethod("matchesHostname", String::class.java)
        method.isAccessible = true

        assertTrue(method.invoke(server, "super.taa.") as Boolean)
    }

    @Test
    fun `matchesHostname rejects unrelated domains`() {
        val server = LocalDnsServer(hostname = "super.taa")
        val method = server.javaClass.getDeclaredMethod("matchesHostname", String::class.java)
        method.isAccessible = true

        assertFalse(method.invoke(server, "google.com") as Boolean)
        assertFalse(method.invoke(server, "super.taa.evil.com") as Boolean)
        assertFalse(method.invoke(server, "notsuper.taa") as Boolean)
    }

    @Test
    fun `extractQueryName parses DNS label format`() {
        val server = LocalDnsServer()
        val method = server.javaClass.getDeclaredMethod("extractQueryName", ByteArray::class.java)
        method.isAccessible = true

        // Build a DNS query for "super.taa"
        // 12-byte header (all zeros for testing) + [5]super[3]taa[0] + QTYPE(2) + QCLASS(2)
        val header = ByteArray(12)
        val question = byteArrayOf(
            5, 's'.code.toByte(), 'u'.code.toByte(), 'p'.code.toByte(), 'e'.code.toByte(), 'r'.code.toByte(),
            3, 't'.code.toByte(), 'a'.code.toByte(), 'a'.code.toByte(),
            0, // null terminator
            0, 1, // QTYPE = A
            0, 1  // QCLASS = IN
        )
        val query = header + question

        val result = method.invoke(server, query) as String?
        assertEquals("super.taa", result)
    }

    @Test
    fun `extractQueryName returns null for short packet`() {
        val server = LocalDnsServer()
        val method = server.javaClass.getDeclaredMethod("extractQueryName", ByteArray::class.java)
        method.isAccessible = true

        val result = method.invoke(server, ByteArray(5)) as String?
        assertNull(result)
    }

    @Test
    fun `buildDnsResponse contains correct IP bytes`() {
        val server = LocalDnsServer(virtualIp = "240.3.3.3")
        val method = server.javaClass.getDeclaredMethod("buildDnsResponse", ByteArray::class.java, String::class.java)
        method.isAccessible = true

        // Minimal valid DNS query
        val header = ByteArray(12) { 0 }.apply {
            this[0] = 0x12 // transaction ID
            this[1] = 0x34.toByte()
        }
        val question = byteArrayOf(5, 's'.code.toByte(), 'u'.code.toByte(), 'p'.code.toByte(), 'e'.code.toByte(), 'r'.code.toByte(),
            3, 't'.code.toByte(), 'a'.code.toByte(), 'a'.code.toByte(), 0, 0, 1, 0, 1)

        val response = method.invoke(server, header + question, "240.3.3.3") as ByteArray

        // Transaction ID preserved
        assertEquals(0x12, response[0].toInt() and 0xFF)
        assertEquals(0x34, response[1].toInt() and 0xFF)

        // Response should contain IP bytes 240, 3, 3, 3 near the end
        val ipBytes = response.takeLast(4)
        assertEquals(240.toByte(), ipBytes[0])
        assertEquals(3.toByte(), ipBytes[1])
        assertEquals(3.toByte(), ipBytes[2])
        assertEquals(3.toByte(), ipBytes[3])
    }
}
