package com.supertesla.aa.androidauto.proto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Tests ServiceDiscovery audio channel presence based on includeAudioSinks flag.
 * TaaDa defaults to BT bypass (channels 5,7 omitted).
 */
class ServiceDiscoveryAudioTest {

    private fun extractServiceIds(includeAudio: Boolean): List<Int> {
        val data = ServiceDiscovery.buildResponse(includeAudioSinks = includeAudio)
        val services = ProtoEncoder.readFields(data).filter { it.fieldNumber == 1 }
        return services.map { svc ->
            ProtoEncoder.readFields(svc.bytesValue!!).first { it.fieldNumber == 1 }.intValue
        }
    }

    @Test
    fun `default response omits channels 5 and 7`() {
        val ids = extractServiceIds(false)
        assertFalse(5 in ids, "Media audio (5) should be absent when BT bypass on")
        assertFalse(7 in ids, "Guidance audio (7) should be absent when BT bypass on")
    }

    @Test
    fun `default response includes channel 6 (system audio)`() {
        val ids = extractServiceIds(false)
        assertTrue(6 in ids, "System audio (6) should always be present")
    }

    @Test
    fun `with audio sinks includes channels 5, 6, 7`() {
        val ids = extractServiceIds(true)
        assertTrue(5 in ids, "Media audio (5) should be present")
        assertTrue(6 in ids, "System audio (6) should be present")
        assertTrue(7 in ids, "Guidance audio (7) should be present")
    }

    @Test
    fun `default has 6 services, with audio has 8`() {
        assertEquals(6, extractServiceIds(false).size)
        assertEquals(8, extractServiceIds(true).size)
    }

    @Test
    fun `system audio config is 16kHz mono`() {
        val data = ServiceDiscovery.buildResponse()
        val services = ProtoEncoder.readFields(data).filter { it.fieldNumber == 1 }
        val svc6 = services.first { svc ->
            ProtoEncoder.readFields(svc.bytesValue!!).first { it.fieldNumber == 1 }.intValue == 6
        }
        val svcFields = ProtoEncoder.readFields(svc6.bytesValue!!)
        val mediaSink = svcFields.first { it.fieldNumber == 3 }
        val sinkFields = ProtoEncoder.readFields(mediaSink.bytesValue!!)

        // audio_type = 2 (SYSTEM)
        assertEquals(2, sinkFields.first { it.fieldNumber == 2 }.intValue)

        // audio_config
        val audioConfig = sinkFields.first { it.fieldNumber == 3 }
        val acFields = ProtoEncoder.readFields(audioConfig.bytesValue!!)
        assertEquals(16000, acFields.first { it.fieldNumber == 1 }.intValue, "sample rate")
        assertEquals(16, acFields.first { it.fieldNumber == 2 }.intValue, "bit depth")
        assertEquals(1, acFields.first { it.fieldNumber == 3 }.intValue, "channels (mono)")
    }

    @Test
    fun `media audio config is 48kHz stereo`() {
        val data = ServiceDiscovery.buildResponse(includeAudioSinks = true)
        val services = ProtoEncoder.readFields(data).filter { it.fieldNumber == 1 }
        val svc5 = services.first { svc ->
            ProtoEncoder.readFields(svc.bytesValue!!).first { it.fieldNumber == 1 }.intValue == 5
        }
        val svcFields = ProtoEncoder.readFields(svc5.bytesValue!!)
        val mediaSink = svcFields.first { it.fieldNumber == 3 }
        val sinkFields = ProtoEncoder.readFields(mediaSink.bytesValue!!)

        // audio_type = 3 (MEDIA)
        assertEquals(3, sinkFields.first { it.fieldNumber == 2 }.intValue)

        val audioConfig = sinkFields.first { it.fieldNumber == 3 }
        val acFields = ProtoEncoder.readFields(audioConfig.bytesValue!!)
        assertEquals(48000, acFields.first { it.fieldNumber == 1 }.intValue, "sample rate")
        assertEquals(2, acFields.first { it.fieldNumber == 3 }.intValue, "channels (stereo)")
    }

    @Test
    fun `two configurations produce different bytes`() {
        val withBt = ServiceDiscovery.buildResponse(includeAudioSinks = false)
        val withoutBt = ServiceDiscovery.buildResponse(includeAudioSinks = true)
        assertFalse(withBt.contentEquals(withoutBt), "BT on/off should produce different responses")
    }
}
