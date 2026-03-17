package com.supertesla.aa.androidauto.proto

import com.supertesla.aa.androidauto.headunit.HeadUnitConfig
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Tests HeadUnitConfig defaults and ServiceDiscovery response shape with different configs.
 */
class HeadUnitConfigTest {

    @Test
    fun `default config has 1280x720 resolution`() {
        val config = HeadUnitConfig()
        assertEquals(1280, config.videoWidth)
        assertEquals(720, config.videoHeight)
    }

    @Test
    fun `default config has 120 DPI`() {
        assertEquals(120, HeadUnitConfig().videoDensity)
    }

    @Test
    fun `default config has 30 FPS`() {
        assertEquals(30, HeadUnitConfig().videoFps)
    }

    @Test
    fun `default config has 48kHz stereo audio`() {
        val config = HeadUnitConfig()
        assertEquals(48000, config.audioSampleRate)
        assertEquals(2, config.audioChannels)
        assertEquals(16, config.audioBitDepth)
    }

    @Test
    fun `default config uses port 5288`() {
        assertEquals(5288, HeadUnitConfig().port)
    }

    @Test
    fun `default config has 2 second heartbeat`() {
        assertEquals(2000L, HeadUnitConfig().heartbeatIntervalMs)
    }

    @Test
    fun `default config has 1MB socket buffers`() {
        assertEquals(1_048_576, HeadUnitConfig().socketBufferSize)
    }

    @Test
    fun `custom resolution config`() {
        val config = HeadUnitConfig(videoWidth = 1920, videoHeight = 1080)
        assertEquals(1920, config.videoWidth)
        assertEquals(1080, config.videoHeight)
    }

    @Test
    fun `SD response includes video config density from HeadUnitConfig`() {
        val videoConfig = ServiceDiscovery.VideoConfig(density = 160)
        val data = ServiceDiscovery.buildResponse(videoConfig = videoConfig)

        // Find service 3 (video) and extract density
        val services = ProtoEncoder.readFields(data).filter { it.fieldNumber == 1 }
        val svc3 = services.first { svc ->
            ProtoEncoder.readFields(svc.bytesValue!!).first { it.fieldNumber == 1 }.intValue == 3
        }
        val svcFields = ProtoEncoder.readFields(svc3.bytesValue!!)
        val mediaSink = svcFields.first { it.fieldNumber == 3 }
        val sinkFields = ProtoEncoder.readFields(mediaSink.bytesValue!!)
        val videoConfigField = sinkFields.first { it.fieldNumber == 4 }
        val vcFields = ProtoEncoder.readFields(videoConfigField.bytesValue!!)
        val density = vcFields.first { it.fieldNumber == 5 }.intValue
        assertEquals(160, density)
    }
}
