package com.supertesla.aa.service

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Tests Bluetooth auto-start MAC address filtering logic.
 */
class BluetoothAutoStartTest {

    // Pure logic extracted from TeslaBluetoothReceiver

    private fun shouldAutoStart(deviceAddress: String, selectedDevices: Set<String>): Boolean {
        return deviceAddress in selectedDevices
    }

    @Test
    fun `matching MAC address triggers auto-start`() {
        val selected = setOf("AA:BB:CC:DD:EE:FF")
        assertTrue(shouldAutoStart("AA:BB:CC:DD:EE:FF", selected))
    }

    @Test
    fun `non-matching MAC address does not trigger`() {
        val selected = setOf("AA:BB:CC:DD:EE:FF")
        assertFalse(shouldAutoStart("11:22:33:44:55:66", selected))
    }

    @Test
    fun `empty selected set never triggers`() {
        assertFalse(shouldAutoStart("AA:BB:CC:DD:EE:FF", emptySet()))
    }

    @Test
    fun `multiple selected devices all trigger`() {
        val selected = setOf("AA:BB:CC:DD:EE:FF", "11:22:33:44:55:66")
        assertTrue(shouldAutoStart("AA:BB:CC:DD:EE:FF", selected))
        assertTrue(shouldAutoStart("11:22:33:44:55:66", selected))
        assertFalse(shouldAutoStart("99:88:77:66:55:44", selected))
    }

    @Test
    fun `MAC address comparison is case-sensitive`() {
        val selected = setOf("AA:BB:CC:DD:EE:FF")
        // Android BT API returns uppercase MACs
        assertFalse(shouldAutoStart("aa:bb:cc:dd:ee:ff", selected))
    }
}
