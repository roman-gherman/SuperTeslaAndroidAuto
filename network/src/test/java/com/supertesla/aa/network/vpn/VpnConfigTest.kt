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
    fun `virtual IP is 240_3_3_3`() {
        assertEquals("240.3.3.3", AppConfig.DEFAULT_VIRTUAL_IP)
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
    fun `virtual IP is in class E range`() {
        // Class E: 240.0.0.0 - 255.255.255.255
        val parts = AppConfig.DEFAULT_VIRTUAL_IP.split(".")
        assertEquals(4, parts.size)
        val firstOctet = parts[0].toInt()
        assertTrue(firstOctet in 240..255, "First octet should be in Class E range (240-255)")
    }
}
