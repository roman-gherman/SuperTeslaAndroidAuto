# 07 — Audio Bluetooth Bypass: Unit Test Plan

## Overview

Tests verify `ServiceDiscovery.buildResponse` channel inclusion/exclusion logic.  The BT-bypass
path (`includeAudioSinks=false`, the default) must omit services 5 and 7 and always include
service 6.  When `includeAudioSinks=true` all three audio sink services must be present in the
TaaDa-canonical order.  Separate config tests verify field-level protobuf encoding for each audio
sink service.

All code is written as compilable Kotlin targeting JUnit 5.  No mocking is required — all tested
methods are pure functions.

---

## Test Classes

| Test Class | File Path | Class Under Test |
|---|---|---|
| `ServiceDiscoveryAudioTest` | `androidauto/src/test/java/com/supertesla/aa/androidauto/proto/ServiceDiscoveryAudioTest.kt` | `ServiceDiscovery` |
| `ServiceDiscoveryAudioConfigTest` | `androidauto/src/test/java/com/supertesla/aa/androidauto/proto/ServiceDiscoveryAudioConfigTest.kt` | `ServiceDiscovery` |

---

## Shared proto-walking utilities

File: `androidauto/src/test/java/com/supertesla/aa/androidauto/proto/ProtoTestUtils.kt`

These helpers walk raw protobuf bytes produced by `ServiceDiscovery.buildResponse` without
depending on any generated proto library.

```kotlin
package com.supertesla.aa.androidauto.proto

/**
 * Walks a ServiceDiscoveryResponse byte array and returns service IDs in emission order.
 *
 * The top-level repeated field 1 (wire type 2, tag = 0x0A) carries each Service message.
 * Field 1 inside a Service message (tag = 0x08, wire type 0) is the integer service ID.
 */
fun extractServiceIds(bytes: ByteArray): List<Int> {
    val ids = mutableListOf<Int>()
    for (field in ProtoEncoder.readFields(bytes)) {
        if (field.fieldNumber == 1 && field.wireType == 2) {
            val svcFields = ProtoEncoder.readFields(field.bytesValue!!)
            val idField = svcFields.firstOrNull { it.fieldNumber == 1 && it.wireType == 0 }
            if (idField != null) ids.add(idField.intValue)
        }
    }
    return ids
}

/**
 * Returns the raw embedded bytes for the Service with the given ID.
 * Throws if not found.
 */
fun extractServiceBytes(bytes: ByteArray, serviceId: Int): ByteArray {
    for (field in ProtoEncoder.readFields(bytes)) {
        if (field.fieldNumber == 1 && field.wireType == 2) {
            val svcBytes  = field.bytesValue!!
            val svcFields = ProtoEncoder.readFields(svcBytes)
            if (svcFields.any { it.fieldNumber == 1 && it.intValue == serviceId }) {
                return svcBytes
            }
        }
    }
    error("Service id=$serviceId not found in response")
}

/**
 * Extracts the first embedded message at [fieldNumber] from a protobuf byte array.
 * Wire type must be 2 (length-delimited).
 */
fun extractEmbeddedMessage(bytes: ByteArray, fieldNumber: Int): ByteArray =
    ProtoEncoder.readFields(bytes)
        .first { it.fieldNumber == fieldNumber && it.wireType == 2 }
        .bytesValue!!
```

---

## ServiceDiscoveryAudioTest

File: `androidauto/src/test/java/com/supertesla/aa/androidauto/proto/ServiceDiscoveryAudioTest.kt`

```kotlin
package com.supertesla.aa.androidauto.proto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ServiceDiscoveryAudioTest {

    // =========================================================================
    // BT bypass ON (includeAudioSinks = false) — default
    // =========================================================================

    @Test
    fun `default buildResponse omits service 5 (media audio)`() {
        val ids = extractServiceIds(ServiceDiscovery.buildResponse())
        assertFalse(5 in ids, "Service 5 must be absent with BT bypass (default)")
    }

    @Test
    fun `default buildResponse omits service 7 (guidance audio)`() {
        val ids = extractServiceIds(ServiceDiscovery.buildResponse())
        assertFalse(7 in ids, "Service 7 must be absent with BT bypass (default)")
    }

    @Test
    fun `default buildResponse includes service 6 (system audio always present)`() {
        val ids = extractServiceIds(ServiceDiscovery.buildResponse())
        assertTrue(6 in ids, "Service 6 must always be present")
    }

    @Test
    fun `buildResponse with includeAudioSinks=false omits service 5`() {
        val ids = extractServiceIds(ServiceDiscovery.buildResponse(includeAudioSinks = false))
        assertFalse(5 in ids)
    }

    @Test
    fun `buildResponse with includeAudioSinks=false omits service 7`() {
        val ids = extractServiceIds(ServiceDiscovery.buildResponse(includeAudioSinks = false))
        assertFalse(7 in ids)
    }

    @Test
    fun `buildResponse with includeAudioSinks=false includes service 6`() {
        val ids = extractServiceIds(ServiceDiscovery.buildResponse(includeAudioSinks = false))
        assertTrue(6 in ids)
    }

    @Test
    fun `buildResponse with includeAudioSinks=false contains exactly 6 services`() {
        // Expected: 1 (input), 2 (sensor), 3 (video), 6 (system audio), 4 (mic), 9 (playback)
        val ids = extractServiceIds(ServiceDiscovery.buildResponse(includeAudioSinks = false))
        assertEquals(6, ids.size,
            "BT bypass must produce exactly 6 services, got: $ids")
    }

    @Test
    fun `buildResponse with includeAudioSinks=false emits services in order 1,2,3,6,4,9`() {
        val ids = extractServiceIds(ServiceDiscovery.buildResponse(includeAudioSinks = false))
        assertEquals(listOf(1, 2, 3, 6, 4, 9), ids)
    }

    // =========================================================================
    // BT bypass OFF (includeAudioSinks = true)
    // =========================================================================

    @Test
    fun `buildResponse with includeAudioSinks=true includes service 5 (media audio)`() {
        val ids = extractServiceIds(ServiceDiscovery.buildResponse(includeAudioSinks = true))
        assertTrue(5 in ids, "Service 5 must be present when BT bypass is disabled")
    }

    @Test
    fun `buildResponse with includeAudioSinks=true includes service 7 (guidance audio)`() {
        val ids = extractServiceIds(ServiceDiscovery.buildResponse(includeAudioSinks = true))
        assertTrue(7 in ids, "Service 7 must be present when BT bypass is disabled")
    }

    @Test
    fun `buildResponse with includeAudioSinks=true includes service 6`() {
        val ids = extractServiceIds(ServiceDiscovery.buildResponse(includeAudioSinks = true))
        assertTrue(6 in ids)
    }

    @Test
    fun `buildResponse with includeAudioSinks=true contains exactly 8 services`() {
        // Expected: 1, 2, 3, 6, 7, 5, 4, 9
        val ids = extractServiceIds(ServiceDiscovery.buildResponse(includeAudioSinks = true))
        assertEquals(8, ids.size,
            "Full audio mode must produce exactly 8 services, got: $ids")
    }

    @Test
    fun `buildResponse with includeAudioSinks=true emits services in TaaDa order 1,2,3,6,7,5,4,9`() {
        val ids = extractServiceIds(ServiceDiscovery.buildResponse(includeAudioSinks = true))
        assertEquals(listOf(1, 2, 3, 6, 7, 5, 4, 9), ids,
            "Service order must match TaaDa canonical order")
    }

    // =========================================================================
    // Sanity
    // =========================================================================

    @Test
    fun `buildResponse produces non-empty bytes`() {
        assertTrue(ServiceDiscovery.buildResponse().isNotEmpty())
    }

    @Test
    fun `buildResponse is deterministic across calls`() {
        val a = ServiceDiscovery.buildResponse(includeAudioSinks = true)
        val b = ServiceDiscovery.buildResponse(includeAudioSinks = true)
        assertContentEquals(a, b)
    }

    @Test
    fun `buildResponse false and true produce different byte arrays`() {
        val withBt    = ServiceDiscovery.buildResponse(includeAudioSinks = false)
        val withoutBt = ServiceDiscovery.buildResponse(includeAudioSinks = true)
        assertFalse(withBt.contentEquals(withoutBt),
            "The two configurations must produce different protobuf bytes")
    }
}
```

---

## ServiceDiscoveryAudioConfigTest

File: `androidauto/src/test/java/com/supertesla/aa/androidauto/proto/ServiceDiscoveryAudioConfigTest.kt`

Verifies field-level protobuf encoding for each audio sink service.  The proto hierarchy is:

```
ServiceDiscoveryResponse
  └─ field 1 (repeated Service)
       └─ field 3 (MediaSinkService)
            ├─ field 1: available_type (AUDIO_PCM = 1)
            ├─ field 2: audio_type     (SYSTEM=2, GUIDANCE=1, MEDIA=3)
            └─ field 3 (AudioConfig)
                 ├─ field 1: sample_rate
                 ├─ field 2: bit_depth
                 └─ field 3: channel_count
```

```kotlin
package com.supertesla.aa.androidauto.proto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ServiceDiscoveryAudioConfigTest {

    // -------------------------------------------------------------------------
    // Helper: reads a named scalar from an audio config embedded message.
    // fieldNumber: 1=sample_rate, 2=bit_depth, 3=channel_count
    // -------------------------------------------------------------------------
    private fun audioConfigField(serviceId: Int, configFieldNumber: Int): Int {
        val bytes    = ServiceDiscovery.buildResponse(
            includeAudioSinks = serviceId != 6  // ch6 is always present; 5+7 need the flag
        )
        val svcBytes  = extractServiceBytes(bytes, serviceId)
        val sinkBytes = extractEmbeddedMessage(svcBytes, fieldNumber = 3) // MediaSinkService
        val acBytes   = extractEmbeddedMessage(sinkBytes, fieldNumber = 3) // AudioConfig
        return ProtoEncoder.readFields(acBytes)
            .first { it.fieldNumber == configFieldNumber }
            .intValue
    }

    private fun audioTypeField(serviceId: Int): Int {
        val bytes     = ServiceDiscovery.buildResponse(
            includeAudioSinks = serviceId != 6
        )
        val svcBytes  = extractServiceBytes(bytes, serviceId)
        val sinkBytes = extractEmbeddedMessage(svcBytes, fieldNumber = 3)
        return ProtoEncoder.readFields(sinkBytes)
            .first { it.fieldNumber == 2 }
            .intValue
    }

    // =========================================================================
    // Service 6 — System audio (always included)
    // =========================================================================

    @Test
    fun `service 6 encodes audio_type = 2 (SYSTEM)`() {
        assertEquals(2, audioTypeField(6))
    }

    @Test
    fun `service 6 encodes sample_rate = 16000`() {
        assertEquals(16000, audioConfigField(6, configFieldNumber = 1))
    }

    @Test
    fun `service 6 encodes bit_depth = 16`() {
        assertEquals(16, audioConfigField(6, configFieldNumber = 2))
    }

    @Test
    fun `service 6 encodes channel_count = 1 (mono)`() {
        assertEquals(1, audioConfigField(6, configFieldNumber = 3))
    }

    @Test
    fun `service 6 encodes available_type = 1 (AUDIO_PCM)`() {
        val bytes     = ServiceDiscovery.buildResponse(includeAudioSinks = false)
        val svcBytes  = extractServiceBytes(bytes, serviceId = 6)
        val sinkBytes = extractEmbeddedMessage(svcBytes, fieldNumber = 3)
        val availType = ProtoEncoder.readFields(sinkBytes)
            .first { it.fieldNumber == 1 }
            .intValue
        assertEquals(1, availType)
    }

    // =========================================================================
    // Service 7 — Guidance / speech audio (only when includeAudioSinks=true)
    // =========================================================================

    @Test
    fun `service 7 encodes audio_type = 1 (GUIDANCE)`() {
        assertEquals(1, audioTypeField(7))
    }

    @Test
    fun `service 7 encodes sample_rate = 16000`() {
        assertEquals(16000, audioConfigField(7, configFieldNumber = 1))
    }

    @Test
    fun `service 7 encodes bit_depth = 16`() {
        assertEquals(16, audioConfigField(7, configFieldNumber = 2))
    }

    @Test
    fun `service 7 encodes channel_count = 1 (mono)`() {
        assertEquals(1, audioConfigField(7, configFieldNumber = 3))
    }

    // =========================================================================
    // Service 5 — Media audio (only when includeAudioSinks=true)
    // =========================================================================

    @Test
    fun `service 5 encodes audio_type = 3 (MEDIA)`() {
        assertEquals(3, audioTypeField(5))
    }

    @Test
    fun `service 5 encodes sample_rate = 48000`() {
        assertEquals(48000, audioConfigField(5, configFieldNumber = 1))
    }

    @Test
    fun `service 5 encodes bit_depth = 16`() {
        assertEquals(16, audioConfigField(5, configFieldNumber = 2))
    }

    @Test
    fun `service 5 encodes channel_count = 2 (stereo)`() {
        assertEquals(2, audioConfigField(5, configFieldNumber = 3))
    }

    // =========================================================================
    // Cross-service consistency: service 6 and 7 have the same audio parameters
    // =========================================================================

    @Test
    fun `services 6 and 7 share the same sample rate 16000`() {
        assertEquals(
            audioConfigField(6, 1),
            audioConfigField(7, 1),
            "Both system and guidance audio must have sample_rate=16000"
        )
    }

    @Test
    fun `services 6 and 7 are both mono`() {
        assertEquals(
            audioConfigField(6, 3),
            audioConfigField(7, 3),
            "Both system and guidance audio must be mono (channel_count=1)"
        )
    }

    @Test
    fun `service 5 has higher sample rate than services 6 and 7`() {
        val mediaRate  = audioConfigField(5, 1)
        val systemRate = audioConfigField(6, 1)
        assert(mediaRate > systemRate) {
            "Media audio (48000 Hz) must have a higher sample rate than system audio (16000 Hz)"
        }
    }

    // =========================================================================
    // Custom config parameters are honoured
    // =========================================================================

    @Test
    fun `custom system audio config sample rate is encoded correctly`() {
        val customConfig = ServiceDiscovery.AudioConfig(
            sampleRate   = 44100,
            bitDepth     = 16,
            channelCount = 1
        )
        val bytes     = ServiceDiscovery.buildResponse(
            systemAudio = customConfig,
            includeAudioSinks = false
        )
        val svcBytes  = extractServiceBytes(bytes, serviceId = 6)
        val sinkBytes = extractEmbeddedMessage(svcBytes, fieldNumber = 3)
        val acBytes   = extractEmbeddedMessage(sinkBytes, fieldNumber = 3)
        val rate      = ProtoEncoder.readFields(acBytes).first { it.fieldNumber == 1 }.intValue
        assertEquals(44100, rate)
    }

    @Test
    fun `custom media audio channel count is encoded correctly`() {
        val customConfig = ServiceDiscovery.AudioConfig(
            sampleRate   = 48000,
            bitDepth     = 16,
            channelCount = 1   // override to mono
        )
        val bytes     = ServiceDiscovery.buildResponse(
            mediaAudio = customConfig,
            includeAudioSinks = true
        )
        val svcBytes  = extractServiceBytes(bytes, serviceId = 5)
        val sinkBytes = extractEmbeddedMessage(svcBytes, fieldNumber = 3)
        val acBytes   = extractEmbeddedMessage(sinkBytes, fieldNumber = 3)
        val ch        = ProtoEncoder.readFields(acBytes).first { it.fieldNumber == 3 }.intValue
        assertEquals(1, ch)
    }
}
```

---

## Red / Green / Refactor

### Red Phase

All tests are pure-function tests against existing code and should pass immediately, establishing
a regression baseline.  The one expected failure is any test that relies on `ProtoTestUtils`
functions calling `field.bytesValue` — this property already exists on `ProtoEncoder.ProtoField`
as `bytesValue: ByteArray?`, so no changes are needed there.

If `extractServiceIds` or `extractEmbeddedMessage` throw `NoSuchElementException` for a given
service, that indicates a missing or mis-encoded service in `buildResponse` — this is the
regression the tests are designed to catch.

### Green Phase

No production-code changes required.

### Refactor Phase

- Extract a private `buildAudioSinkService(id: Int, audioType: Int, config: AudioConfig)` helper
  in `ServiceDiscovery` to eliminate the three near-identical blocks for services 5, 6, 7.
- Add `@JvmStatic` to all `ServiceDiscovery` builder functions to improve Java interop.
- Consider replacing the imperative `ByteArrayOutputStream` approach with a lightweight proto DSL:
  ```kotlin
  fun buildResponse(...) = protoMessage {
      message(17) { /* huInfo */ }
      service(1) { inputSource(videoConfig) }
      // ...
  }
  ```
  This would make the service ordering and conditional inclusion visually obvious without
  needing comments to explain the TaaDa order.
