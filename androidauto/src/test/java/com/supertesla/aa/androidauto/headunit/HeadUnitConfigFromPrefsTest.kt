package com.supertesla.aa.androidauto.headunit

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HeadUnitConfigFromPrefsTest {

    @Test
    fun `fromMap with empty map returns defaults`() {
        val config = HeadUnitConfig.fromMap(emptyMap())
        assertEquals(1280, config.videoWidth)
        assertEquals(720, config.videoHeight)
        assertEquals(120, config.videoDensity)
        assertFalse(config.rightHandDrive)
        assertTrue(config.useBluetooth)
        assertTrue(config.useVpn)
    }

    @Test
    fun `fromMap reads resolution 1080p`() {
        val config = HeadUnitConfig.fromMap(mapOf("resolution" to "1080p"))
        assertEquals(1920, config.videoWidth)
        assertEquals(1080, config.videoHeight)
    }

    @Test
    fun `fromMap reads resolution 480p`() {
        val config = HeadUnitConfig.fromMap(mapOf("resolution" to "480p"))
        assertEquals(800, config.videoWidth)
        assertEquals(480, config.videoHeight)
    }

    @Test
    fun `fromMap reads resolution portrait 720p`() {
        val config = HeadUnitConfig.fromMap(mapOf("resolution" to "720p_portrait"))
        assertEquals(720, config.videoWidth)
        assertEquals(1280, config.videoHeight)
    }

    @Test
    fun `fromMap reads dpi clamped to range`() {
        assertEquals(100, HeadUnitConfig.fromMap(mapOf("dpi" to "50")).videoDensity)
        assertEquals(300, HeadUnitConfig.fromMap(mapOf("dpi" to "999")).videoDensity)
        assertEquals(160, HeadUnitConfig.fromMap(mapOf("dpi" to "160")).videoDensity)
    }

    @Test
    fun `fromMap reads rhd flag`() {
        assertTrue(HeadUnitConfig.fromMap(mapOf("rhd" to "true")).rightHandDrive)
        assertFalse(HeadUnitConfig.fromMap(mapOf("rhd" to "false")).rightHandDrive)
    }

    @Test
    fun `fromMap reads usebt flag`() {
        assertFalse(HeadUnitConfig.fromMap(mapOf("usebt" to "false")).useBluetooth)
    }

    @Test
    fun `fromMap reads usevpn flag`() {
        assertFalse(HeadUnitConfig.fromMap(mapOf("usevpn" to "false")).useVpn)
    }

    @Test
    fun `unknown resolution falls back to 720p`() {
        val config = HeadUnitConfig.fromMap(mapOf("resolution" to "garbage"))
        assertEquals(1280, config.videoWidth)
        assertEquals(720, config.videoHeight)
    }

    @Test
    fun `resolution presets cover all TaaDa options`() {
        val presets = HeadUnitConfig.RESOLUTION_PRESETS
        assertTrue(presets.containsKey("480p"))
        assertTrue(presets.containsKey("720p"))
        assertTrue(presets.containsKey("1080p"))
        assertTrue(presets.containsKey("1440p"))
        assertTrue(presets.containsKey("4k"))
        assertTrue(presets.containsKey("720p_portrait"))
        assertTrue(presets.containsKey("1080p_portrait"))
    }
}
