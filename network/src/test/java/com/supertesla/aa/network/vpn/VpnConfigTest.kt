package com.supertesla.aa.network.vpn

import com.supertesla.aa.core.config.AppConfig
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Tests VPN configuration constants and design contracts.
 * These are pure unit tests — no Android framework needed.
 */
class VpnConfigTest {

    @Test
    fun `virtual IP is non-RFC1918 routable`() {
        assertEquals("51.75.29.16", AppConfig.DEFAULT_VIRTUAL_IP)
    }

    @Test
    fun `AA package constant matches gearhead`() {
        assertEquals("com.google.android.projection.gearhead", VpnTunnelService.AA_PACKAGE)
    }

    @Test
    fun `EXTRA_VIRTUAL_IP key is defined`() {
        assertEquals("extra_virtual_ip", VpnTunnelService.EXTRA_VIRTUAL_IP)
    }

    @Test
    fun `virtual IP is not RFC1918 private range`() {
        // Tesla blocks 10.x, 172.16-31.x, 192.168.x
        val parts = AppConfig.DEFAULT_VIRTUAL_IP.split(".")
        assertEquals(4, parts.size)
        val first = parts[0].toInt()
        val second = parts[1].toInt()
        assertFalse(first == 10, "Must not be 10.x.x.x")
        assertFalse(first == 192 && second == 168, "Must not be 192.168.x.x")
        assertFalse(first == 172 && second in 16..31, "Must not be 172.16-31.x.x")
        assertFalse(first in 240..255, "Must not be Class E (240-255)")
    }
}
