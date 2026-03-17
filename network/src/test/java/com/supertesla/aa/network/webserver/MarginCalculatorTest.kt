package com.supertesla.aa.network.webserver

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MarginCalculatorTest {

    // Video is 1280x720 (16:9)

    @Test
    fun `identical aspect ratio produces zero margins`() {
        // Screen is 1920x1080 (16:9) — same ratio as 1280x720
        assertEquals(0, MarginCalculator.calculateWidthMargin(1280, 720, 1920, 1080))
        assertEquals(0, MarginCalculator.calculateHeightMargin(1280, 720, 1920, 1080))
    }

    @Test
    fun `narrower screen (4 by 3) produces width margin (pillarbox)`() {
        // Screen 4:3 (1024x768) is narrower than video 16:9
        val wMargin = MarginCalculator.calculateWidthMargin(1280, 720, 1024, 768)
        assertTrue(wMargin > 0, "Should have pillarbox margin, got $wMargin")
        assertEquals(0, MarginCalculator.calculateHeightMargin(1280, 720, 1024, 768))
    }

    @Test
    fun `wider screen (21 by 9) produces height margin (letterbox)`() {
        // Screen 21:9 (2520x1080) is wider than video 16:9
        assertEquals(0, MarginCalculator.calculateWidthMargin(1280, 720, 2520, 1080))
        val hMargin = MarginCalculator.calculateHeightMargin(1280, 720, 2520, 1080)
        assertTrue(hMargin > 0, "Should have letterbox margin, got $hMargin")
    }

    @Test
    fun `Tesla 1920x1200 screen produces some margin`() {
        // Tesla MCU is 1920x1200 (16:10), video is 16:9
        val wMargin = MarginCalculator.calculateWidthMargin(1280, 720, 1920, 1200)
        val hMargin = MarginCalculator.calculateHeightMargin(1280, 720, 1920, 1200)
        // 16:10 < 16:9, so screen is narrower → pillarbox
        assertTrue(wMargin > 0 || hMargin > 0, "Tesla screen should have some margin")
    }

    @Test
    fun `square screen produces width margin`() {
        // Square screen (1:1) is narrower than 16:9
        val wMargin = MarginCalculator.calculateWidthMargin(1280, 720, 800, 800)
        assertTrue(wMargin > 0)
    }

    @Test
    fun `margins are never negative`() {
        // Even with extreme ratios
        assertTrue(MarginCalculator.calculateWidthMargin(1280, 720, 100, 10000) >= 0)
        assertTrue(MarginCalculator.calculateHeightMargin(1280, 720, 10000, 100) >= 0)
    }

    @Test
    fun `margins never exceed video dimensions`() {
        val wMargin = MarginCalculator.calculateWidthMargin(1280, 720, 100, 10000)
        assertTrue(wMargin <= 1280)
        val hMargin = MarginCalculator.calculateHeightMargin(1280, 720, 10000, 100)
        assertTrue(hMargin <= 720)
    }

    @Test
    fun `zero screen height does not crash`() {
        assertEquals(0, MarginCalculator.calculateWidthMargin(1280, 720, 1920, 0))
        assertEquals(0, MarginCalculator.calculateHeightMargin(1280, 720, 1920, 0))
    }
}
