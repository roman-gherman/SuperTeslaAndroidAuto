package com.supertesla.aa.androidauto.launcher

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Tests AALauncher constants and pure logic.
 * Android-dependent methods (startActivity, sendBroadcast) are not testable
 * in unit tests — those are verified by integration tests.
 */
class AALauncherTest {

    @Test
    fun `AA_PACKAGE matches gearhead package`() {
        // Use reflection since AA_PACKAGE is private
        val field = AALauncher.javaClass.getDeclaredField("AA_PACKAGE")
        field.isAccessible = true
        assertEquals("com.google.android.projection.gearhead", field.get(null))
    }

    @Test
    fun `WIRELESS_RECEIVER matches TaaDa receiver class`() {
        val field = AALauncher.javaClass.getDeclaredField("WIRELESS_RECEIVER")
        field.isAccessible = true
        assertEquals(
            "com.google.android.apps.auto.wireless.setup.receiver.WirelessStartupReceiver",
            field.get(null)
        )
    }

    @Test
    fun `WIRELESS_ACTIVITY matches TaaDa activity class`() {
        val field = AALauncher.javaClass.getDeclaredField("WIRELESS_ACTIVITY")
        field.isAccessible = true
        assertEquals(
            "com.google.android.apps.auto.wireless.setup.service.impl.WirelessStartupActivity",
            field.get(null)
        )
    }

    @Test
    fun `AA_WIRELESS_PORT is 5288`() {
        val field = AALauncher.javaClass.getDeclaredField("AA_WIRELESS_PORT")
        field.isAccessible = true
        assertEquals(5288, field.get(null))
    }

    @Test
    fun `AA_DEV_PORT is 5277`() {
        val field = AALauncher.javaClass.getDeclaredField("AA_DEV_PORT")
        field.isAccessible = true
        assertEquals(5277, field.get(null))
    }

    @Test
    fun `WIRELESS_RECEIVER_ACTION matches TaaDa broadcast action`() {
        val field = AALauncher.javaClass.getDeclaredField("WIRELESS_RECEIVER_ACTION")
        field.isAccessible = true
        assertEquals(
            "com.google.android.apps.auto.wireless.setup.receiver.wirelessstartup.START",
            field.get(null)
        )
    }
}
