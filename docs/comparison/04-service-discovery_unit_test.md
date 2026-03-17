# 04 — ServiceDiscovery Response Fixes: Unit Test Plan

## Prerequisites

Test infrastructure defined in `01-cleanup-dead-code_unit_test.md` must be applied first.

---

## 1. Test Classes

| Test Class | File Path | Class Under Test |
|---|---|---|
| `ProtoEncoderTest` | `androidauto/src/test/.../proto/ProtoEncoderTest.kt` | `ProtoEncoder` |
| `ServiceDiscoveryEncodingTest` | `androidauto/src/test/.../proto/ServiceDiscoveryEncodingTest.kt` | `ServiceDiscovery` |
| `ServiceDiscoveryResponseShapeTest` | `androidauto/src/test/.../proto/ServiceDiscoveryResponseShapeTest.kt` | `ServiceDiscovery.buildResponse()` |
| `SensorChannelHandlerTest` | `androidauto/src/test/.../channels/SensorChannelHandlerTest.kt` | `SensorChannelHandler` |
| `ControlChannelHandlerTest` | `androidauto/src/test/.../channels/ControlChannelHandlerTest.kt` | `ControlChannelHandler` |

`ProtoEncoder` and `ServiceDiscovery` have zero Android dependencies — all tests are plain JVM. `SensorChannelHandler` and `ControlChannelHandler` depend on `ChannelMux`, which is mocked.

---

## 2. Test Cases

### 2.1 `ProtoEncoderTest`

**File:** `androidauto/src/test/java/com/supertesla/aa/androidauto/proto/ProtoEncoderTest.kt`

These tests form the foundation: if the encoder is wrong, every higher-level test is unreliable.

```kotlin
class ProtoEncoderTest {

    // --- writeVarint ---

    @Test
    fun `writeVarint encodes zero as single byte 0x00`() {
        // Arrange: val out = ByteArrayOutputStream()
        // Act:     ProtoEncoder.writeVarint(out, 0L)
        // Assert:  assertArrayEquals(byteArrayOf(0x00), out.toByteArray())
    }

    @Test
    fun `writeVarint encodes 1 as single byte 0x01`() {
        // Arrange: val out = ByteArrayOutputStream()
        // Act:     ProtoEncoder.writeVarint(out, 1L)
        // Assert:  assertArrayEquals(byteArrayOf(0x01), out.toByteArray())
    }

    @Test
    fun `writeVarint encodes 127 as single byte 0x7F`() {
        // 127 is the largest value that fits in one varint byte.
        //
        // Arrange: val out = ByteArrayOutputStream()
        // Act:     ProtoEncoder.writeVarint(out, 127L)
        // Assert:  assertArrayEquals(byteArrayOf(0x7F), out.toByteArray())
    }

    @Test
    fun `writeVarint encodes 128 as two bytes 0x80 0x01`() {
        // 128 requires MSB continuation bit.
        //
        // Arrange: val out = ByteArrayOutputStream()
        // Act:     ProtoEncoder.writeVarint(out, 128L)
        // Assert:  assertArrayEquals(byteArrayOf(0x80.toByte(), 0x01), out.toByteArray())
    }

    @Test
    fun `writeVarint encodes 300 correctly as two bytes`() {
        // 300 = 0x12C. Encoded: (0x2C | 0x80) = 0xAC, then 0x02
        //
        // Arrange: val out = ByteArrayOutputStream()
        // Act:     ProtoEncoder.writeVarint(out, 300L)
        // Assert:  assertArrayEquals(byteArrayOf(0xAC.toByte(), 0x02), out.toByteArray())
    }

    // --- writeTag ---

    @Test
    fun `writeTag for field 1 varint produces tag byte 0x08`() {
        // Tag = (fieldNumber << 3) | wireType. Field 1, wire 0 → 0x08.
        //
        // Arrange: val out = ByteArrayOutputStream()
        // Act:     ProtoEncoder.writeTag(out, fieldNumber = 1, wireType = 0)
        // Assert:  assertArrayEquals(byteArrayOf(0x08), out.toByteArray())
    }

    @Test
    fun `writeTag for field 1 length-delimited produces tag byte 0x0A`() {
        // Field 1, wire 2 → (1 << 3) | 2 = 0x0A.
        //
        // Arrange: val out = ByteArrayOutputStream()
        // Act:     ProtoEncoder.writeTag(out, fieldNumber = 1, wireType = 2)
        // Assert:  assertArrayEquals(byteArrayOf(0x0A), out.toByteArray())
    }

    // --- roundtrip: write then read ---

    @Test
    fun `writeVarintField and readFields roundtrip preserves value`() {
        // Arrange: val out = ByteArrayOutputStream()
        //          ProtoEncoder.writeVarintField(out, fieldNumber = 3, value = 42L)
        // Act:     val fields = ProtoEncoder.readFields(out.toByteArray())
        // Assert:  assertEquals(1, fields.size)
        //          assertEquals(3, fields[0].fieldNumber)
        //          assertEquals(42L, fields[0].varintValue)
    }

    @Test
    fun `writeStringField and readFields roundtrip preserves string`() {
        // Arrange: val out = ByteArrayOutputStream()
        //          ProtoEncoder.writeStringField(out, fieldNumber = 2, value = "Desktop Head Unit")
        // Act:     val fields = ProtoEncoder.readFields(out.toByteArray())
        // Assert:  assertEquals(1, fields.size)
        //          assertEquals(2, fields[0].fieldNumber)
        //          assertEquals("Desktop Head Unit", fields[0].stringValue)
    }

    @Test
    fun `readFields handles multiple fields in sequence`() {
        // Arrange:
        //   val out = ByteArrayOutputStream()
        //   ProtoEncoder.writeVarintField(out, 1, 10L)
        //   ProtoEncoder.writeVarintField(out, 2, 20L)
        //   ProtoEncoder.writeStringField(out, 3, "hello")
        //
        // Act: val fields = ProtoEncoder.readFields(out.toByteArray())
        //
        // Assert:
        //   assertEquals(3, fields.size)
        //   assertEquals(10L, fields[0].varintValue)
        //   assertEquals(20L, fields[1].varintValue)
        //   assertEquals("hello", fields[2].stringValue)
    }

    @Test
    fun `readVarint throws on truncated input`() {
        // A partial varint byte (MSB set, but no following byte) must throw.
        //
        // Arrange: val buf = ByteBuffer.wrap(byteArrayOf(0x80.toByte()))  // continuation bit set, no next byte
        // Act+Assert: assertThrows<IllegalStateException> { ProtoEncoder.readVarint(buf) }
    }

    @Test
    fun `readFields throws on unsupported wire type`() {
        // Wire type 3 (groups, deprecated) is not handled.
        //
        // Arrange:
        //   val out = ByteArrayOutputStream()
        //   ProtoEncoder.writeTag(out, fieldNumber = 1, wireType = 3)   // SGROUP — unsupported
        //
        // Act+Assert:
        //   assertThrows<IllegalStateException> { ProtoEncoder.readFields(out.toByteArray()) }
    }

    @Test
    fun `writeEmbeddedMessage and readFields roundtrip preserves nested bytes`() {
        // Arrange:
        //   val out = ByteArrayOutputStream()
        //   ProtoEncoder.writeEmbeddedMessage(out, fieldNumber = 5) { inner ->
        //       ProtoEncoder.writeVarintField(inner, 1, 99L)
        //   }
        //
        // Act:
        //   val fields = ProtoEncoder.readFields(out.toByteArray())
        //   val nested = ProtoEncoder.readFields(fields[0].bytesValue!!)
        //
        // Assert:
        //   assertEquals(5, fields[0].fieldNumber)
        //   assertEquals(2, fields[0].wireType)   // length-delimited
        //   assertEquals(99L, nested[0].varintValue)
    }

    @Test
    fun `ProtoBuilder DSL encode produces same bytes as manual ByteArrayOutputStream`() {
        // Verifies the builder API is equivalent to manual encoding.
        //
        // Arrange:
        //   val manual = ByteArrayOutputStream().also { out ->
        //       ProtoEncoder.writeVarintField(out, 1, 5L)
        //       ProtoEncoder.writeStringField(out, 2, "test")
        //   }.toByteArray()
        //
        //   val dsl = ProtoEncoder.encode {
        //       writeVarint(1, 5L)
        //       writeString(2, "test")
        //   }
        //
        // Assert:
        //   assertArrayEquals(manual, dsl)
    }
}
```

### 2.2 `ServiceDiscoveryEncodingTest`

**File:** `androidauto/src/test/java/com/supertesla/aa/androidauto/proto/ServiceDiscoveryEncodingTest.kt`

Tests each `build*` method in `ServiceDiscovery` by encoding then decoding and asserting field values.

```kotlin
class ServiceDiscoveryEncodingTest {

    // --- buildMediaSetupResponse ---

    @Test
    fun `buildMediaSetupResponse field 1 status is 0 (STATUS_OK)`() {
        // THIS IS THE BUG DESCRIBED IN DOC 04.
        // Current code writes field 1 = 2. After fix it must be 0.
        //
        // Arrange: —
        // Act:     val bytes = ServiceDiscovery.buildMediaSetupResponse(configIndex = 0, maxUnacked = 1)
        //          val fields = ProtoEncoder.readFields(bytes)
        //
        // Assert:
        //   val statusField = fields.first { it.fieldNumber == 1 }
        //   assertEquals(0L, statusField.varintValue,
        //       "MediaSetupResponse field 1 must be 0 (STATUS_OK), was ${statusField.varintValue}")
        //
        // RED: fails currently because field 1 = 2L
    }

    @Test
    fun `buildMediaSetupResponse field 2 is maxUnacked`() {
        // Arrange: —
        // Act:     val bytes = ServiceDiscovery.buildMediaSetupResponse(configIndex = 3, maxUnacked = 5)
        //          val fields = ProtoEncoder.readFields(bytes)
        // Assert:  assertEquals(5L, fields.first { it.fieldNumber == 2 }.varintValue)
    }

    @Test
    fun `buildMediaSetupResponse field 3 is configIndex`() {
        // Arrange: —
        // Act:     val bytes = ServiceDiscovery.buildMediaSetupResponse(configIndex = 3, maxUnacked = 5)
        //          val fields = ProtoEncoder.readFields(bytes)
        // Assert:  assertEquals(3L, fields.first { it.fieldNumber == 3 }.varintValue)
    }

    @Test
    fun `buildMediaSetupResponse default configIndex is 0`() {
        // Arrange: val bytes = ServiceDiscovery.buildMediaSetupResponse()
        //          val fields = ProtoEncoder.readFields(bytes)
        // Assert:
        //   // field 3 either absent (proto3 default) or equals 0
        //   val f3 = fields.firstOrNull { it.fieldNumber == 3 }
        //   assertTrue(f3 == null || f3.varintValue == 0L)
    }

    // --- buildAuthComplete / buildSensorStartResponse / buildChannelOpenResponse ---

    @Test
    fun `buildAuthComplete with status 0 encodes single field 1 = 0`() {
        // Arrange: val bytes = ServiceDiscovery.buildAuthComplete(0)
        //          val fields = ProtoEncoder.readFields(bytes)
        // Assert:
        //   assertEquals(1, fields.size)
        //   assertEquals(1, fields[0].fieldNumber)
        //   assertEquals(0L, fields[0].varintValue)
    }

    @Test
    fun `buildSensorStartResponse delegates to buildAuthComplete`() {
        // Both must produce identical bytes for status = 0.
        //
        // Arrange: val a = ServiceDiscovery.buildAuthComplete(0)
        //          val b = ServiceDiscovery.buildSensorStartResponse(0)
        // Assert:  assertArrayEquals(a, b)
    }

    @Test
    fun `buildChannelOpenResponse delegates to buildAuthComplete`() {
        // Arrange: val a = ServiceDiscovery.buildAuthComplete(0)
        //          val b = ServiceDiscovery.buildChannelOpenResponse(0)
        // Assert:  assertArrayEquals(a, b)
    }

    // --- buildPingResponse ---

    @Test
    fun `buildPingResponse encodes timestamp in field 1`() {
        // Arrange: val ts = 123456789L
        // Act:     val bytes = ServiceDiscovery.buildPingResponse(ts)
        //          val fields = ProtoEncoder.readFields(bytes)
        // Assert:  assertEquals(ts, fields.first { it.fieldNumber == 1 }.varintValue)
    }

    @Test
    fun `buildPingResponse with zero timestamp encodes correctly`() {
        // Arrange: val bytes = ServiceDiscovery.buildPingResponse(0L)
        //          val fields = ProtoEncoder.readFields(bytes)
        // Assert:  assertEquals(1, fields.size)
        //          assertEquals(0L, fields[0].varintValue)
    }

    // --- buildDrivingStatusEvent ---

    @Test
    fun `buildDrivingStatusEvent wraps status in nested message`() {
        // DrivingStatus is a nested protobuf:
        //   outer.field1 = SensorEvent (field1=sensorType=13, field4=DrivingStatusData)
        //   DrivingStatusData.field1 = status
        //
        // Arrange: val bytes = ServiceDiscovery.buildDrivingStatusEvent(status = 0)
        //          val outer = ProtoEncoder.readFields(bytes)
        //
        // Assert: outer has exactly one field with fieldNumber = 1 (the embedded SensorEvent)
        //   val eventBytes = outer.first { it.fieldNumber == 1 }.bytesValue!!
        //   val eventFields = ProtoEncoder.readFields(eventBytes)
        //
        //   // sensor_type field (field 1) = 13 (DRIVING_STATUS)
        //   assertEquals(13L, eventFields.first { it.fieldNumber == 1 }.varintValue)
        //
        //   // DrivingStatusData is at field 4
        //   val dataBytes = eventFields.first { it.fieldNumber == 4 }.bytesValue!!
        //   val dataFields = ProtoEncoder.readFields(dataBytes)
        //   assertEquals(0L, dataFields.first { it.fieldNumber == 1 }.varintValue)
    }

    @Test
    fun `buildDrivingStatusEvent with status 1 encodes status value correctly`() {
        // Arrange: val bytes = ServiceDiscovery.buildDrivingStatusEvent(status = 1)
        //
        // Act: (same field traversal as above, reaching the DrivingStatusData field 1)
        //
        // Assert: dataFields.first { it.fieldNumber == 1 }.varintValue == 1L
    }

    // --- buildAudioFocusResponse ---

    @Test
    fun `buildAudioFocusResponse encodes focusType in field 1`() {
        // Arrange: val bytes = ServiceDiscovery.buildAudioFocusResponse(focusType = 1)
        //          val fields = ProtoEncoder.readFields(bytes)
        // Assert:  assertEquals(1L, fields.first { it.fieldNumber == 1 }.varintValue)
    }

    // --- buildVideoFocusIndication ---

    @Test
    fun `buildVideoFocusIndication encodes mode in field 1 and unsolicited flag in field 2`() {
        // Arrange: val bytes = ServiceDiscovery.buildVideoFocusIndication(mode = 1, unsolicited = true)
        //          val fields = ProtoEncoder.readFields(bytes)
        // Assert:  assertEquals(1L, fields.first { it.fieldNumber == 1 }.varintValue)
        //          assertEquals(1L, fields.first { it.fieldNumber == 2 }.varintValue)
    }

    @Test
    fun `buildVideoFocusIndication encodes unsolicited=false as field 2 = 0`() {
        // Arrange: val bytes = ServiceDiscovery.buildVideoFocusIndication(mode = 1, unsolicited = false)
        //          val fields = ProtoEncoder.readFields(bytes)
        // Assert:  assertEquals(0L, fields.first { it.fieldNumber == 2 }.varintValue)
    }

    // --- buildNavFocusResponse ---

    @Test
    fun `buildNavFocusResponse default focusType is 2`() {
        // Arrange: val bytes = ServiceDiscovery.buildNavFocusResponse()
        //          val fields = ProtoEncoder.readFields(bytes)
        // Assert:  assertEquals(2L, fields.first { it.fieldNumber == 1 }.varintValue)
    }

    // --- buildParkingBrakeEvent (NEW function, not yet implemented) ---

    @Test
    fun `buildParkingBrakeEvent encodes sensorType 7 and parkingBrake=true`() {
        // RED: This function does not exist yet. Test drives its creation.
        //
        // Expected shape (from doc 04 step 2):
        //   outer.field1 = SensorEvent {
        //       field1 = 7 (SENSOR_PARKING_BRAKE)
        //       field7 = ParkingBrakeData { field1 = 1 (engaged=true) }
        //   }
        //
        // Arrange: val bytes = ServiceDiscovery.buildParkingBrakeEvent(engaged = true)
        //          val outer = ProtoEncoder.readFields(bytes)
        //
        // Assert:
        //   val eventBytes = outer.first { it.fieldNumber == 1 }.bytesValue!!
        //   val eventFields = ProtoEncoder.readFields(eventBytes)
        //   assertEquals(7L, eventFields.first { it.fieldNumber == 1 }.varintValue)
        //   val brakeBytes = eventFields.first { it.fieldNumber == 7 }.bytesValue!!
        //   val brakeFields = ProtoEncoder.readFields(brakeBytes)
        //   assertEquals(1L, brakeFields.first { it.fieldNumber == 1 }.varintValue)
    }

    @Test
    fun `buildParkingBrakeEvent with engaged=false encodes field 1 = 0`() {
        // Arrange: val bytes = ServiceDiscovery.buildParkingBrakeEvent(engaged = false)
        // Act:     (same traversal as above)
        // Assert:  brakeFields.first { it.fieldNumber == 1 }.varintValue == 0L
    }
}
```

### 2.3 `ServiceDiscoveryResponseShapeTest`

**File:** `androidauto/src/test/java/com/supertesla/aa/androidauto/proto/ServiceDiscoveryResponseShapeTest.kt`

Verifies the overall structure of `buildResponse()` — that service IDs are present, ordered correctly, and the audio sink conditional logic is respected.

```kotlin
class ServiceDiscoveryResponseShapeTest {

    private fun extractServiceIds(responseBytes: ByteArray): List<Int> {
        // Helper: collect all service IDs from the repeated field 1 (services) in the response.
        // Each service is a length-delimited field at fieldNumber=1 in the response.
        // Inside each service message, field 1 is the service_id varint.
        val outerFields = ProtoEncoder.readFields(responseBytes)
        return outerFields
            .filter { it.fieldNumber == 1 && it.bytesValue != null }
            .mapNotNull { svcField ->
                val svcFields = ProtoEncoder.readFields(svcField.bytesValue!!)
                svcFields.firstOrNull { it.fieldNumber == 1 }?.intValue
            }
    }

    @Test
    fun `buildResponse contains service ID 1 (InputSource)`() {
        // Arrange: val bytes = ServiceDiscovery.buildResponse()
        // Act:     val ids = extractServiceIds(bytes)
        // Assert:  assertTrue(ids.contains(1), "Expected service 1 (InputSource) in response, found: $ids")
    }

    @Test
    fun `buildResponse contains service ID 2 (SensorSource)`() {
        // Arrange: val bytes = ServiceDiscovery.buildResponse()
        // Act:     val ids = extractServiceIds(bytes)
        // Assert:  assertTrue(ids.contains(2))
    }

    @Test
    fun `buildResponse contains service ID 3 (Video)`() {
        // Arrange: val bytes = ServiceDiscovery.buildResponse()
        // Act:     val ids = extractServiceIds(bytes)
        // Assert:  assertTrue(ids.contains(3))
    }

    @Test
    fun `buildResponse contains service ID 6 (AudioSystem) by default`() {
        // Channel 6 (system audio) is always included.
        //
        // Arrange: val bytes = ServiceDiscovery.buildResponse()
        // Act:     val ids = extractServiceIds(bytes)
        // Assert:  assertTrue(ids.contains(6))
    }

    @Test
    fun `buildResponse excludes service IDs 5 and 7 when includeAudioSinks is false`() {
        // Default config must NOT include media (5) or guidance (7) audio sinks.
        //
        // Arrange: val bytes = ServiceDiscovery.buildResponse(includeAudioSinks = false)
        // Act:     val ids = extractServiceIds(bytes)
        // Assert:  assertFalse(ids.contains(5), "Service 5 (media audio) should be absent")
        //          assertFalse(ids.contains(7), "Service 7 (guidance audio) should be absent")
    }

    @Test
    fun `buildResponse includes service IDs 5 and 7 when includeAudioSinks is true`() {
        // Arrange: val bytes = ServiceDiscovery.buildResponse(includeAudioSinks = true)
        // Act:     val ids = extractServiceIds(bytes)
        // Assert:  assertTrue(ids.contains(5))
        //          assertTrue(ids.contains(7))
    }

    @Test
    fun `buildResponse contains service ID 4 (Mic)`() {
        // Arrange: val bytes = ServiceDiscovery.buildResponse()
        // Act:     val ids = extractServiceIds(bytes)
        // Assert:  assertTrue(ids.contains(4))
    }

    @Test
    fun `buildResponse contains service ID 9 (Playback)`() {
        // Arrange: val bytes = ServiceDiscovery.buildResponse()
        // Act:     val ids = extractServiceIds(bytes)
        // Assert:  assertTrue(ids.contains(9))
    }

    @Test
    fun `buildResponse SensorSource service contains all four sensor types`() {
        // Verifies sensors 13, 10, 1, 7 are all declared — drives sensor handling tests.
        //
        // Arrange: val bytes = ServiceDiscovery.buildResponse()
        //          val outerFields = ProtoEncoder.readFields(bytes)
        //
        // Act: find service with id=2, then read its SensorSourceService (field 2),
        //      then collect all Sensor message (field 1) entries and their type (field 1)
        //
        // Assert: sensorTypes.containsAll(listOf(13, 10, 1, 7))
    }

    @Test
    fun `buildResponse HeadUnitInfo make equals configured value`() {
        // Arrange:
        //   val huInfo = ServiceDiscovery.HeadUnitInfo(make = "Tesla", model = "Model 3")
        //   val bytes = ServiceDiscovery.buildResponse(huInfo = huInfo)
        //   val outerFields = ProtoEncoder.readFields(bytes)
        //
        // Act: find field 17 (HeadUnitInfo embedded message), then read field 1 (make)
        //
        // Assert: huFields.first { it.fieldNumber == 1 }.stringValue == "Tesla"
    }

    @Test
    fun `buildResponse VideoConfig width and height encoded in video service`() {
        // Arrange:
        //   val vc = ServiceDiscovery.VideoConfig(width = 1920, height = 1080)
        //   val bytes = ServiceDiscovery.buildResponse(videoConfig = vc)
        //
        // Act: navigate to service 3 → MediaSinkService (field 3) → VideoConfiguration (field 4)
        //      read width_margin (field 3) and height_margin (field 4) and density (field 5)
        //
        // Assert: the codec_resolution field (1) and frame_rate field (2) are also present.
        //         This test documents the expected nesting depth so developers can verify
        //         field numbering without running the full AA protocol.
    }

    @Test
    fun `buildResponse produces non-empty byte array`() {
        // Smoke test: the response is not empty.
        //
        // Arrange: val bytes = ServiceDiscovery.buildResponse()
        // Assert:  assertTrue(bytes.isNotEmpty())
    }

    @Test
    fun `buildResponse is deterministic for the same input`() {
        // Two calls with the same parameters must produce identical bytes.
        //
        // Arrange: val config = ServiceDiscovery.HeadUnitInfo()
        // Act:     val a = ServiceDiscovery.buildResponse(huInfo = config)
        //          val b = ServiceDiscovery.buildResponse(huInfo = config)
        // Assert:  assertArrayEquals(a, b)
    }
}
```

### 2.4 `SensorChannelHandlerTest`

**File:** `androidauto/src/test/java/com/supertesla/aa/androidauto/channels/SensorChannelHandlerTest.kt`

```kotlin
class SensorChannelHandlerTest {

    private val mockMux: ChannelMux = mockk(relaxed = true)
    private lateinit var handler: SensorChannelHandler

    @BeforeEach
    fun setUp() {
        handler = SensorChannelHandler(mockMux)
    }

    // Helper: build a minimal AapFrame for a sensor START_REQUEST
    private fun startRequestFrame(sensorType: Int): AapFramer.AapFrame {
        val body = ProtoEncoder.encode { writeVarint(1, sensorType.toLong()) }
        val payload = ByteArray(2 + body.size)
        payload[0] = (SensorMessageType.START_REQUEST shr 8).toByte()
        payload[1] = (SensorMessageType.START_REQUEST and 0xFF).toByte()
        System.arraycopy(body, 0, payload, 2, body.size)
        return AapFramer.AapFrame(
            channel = ChannelId.SENSOR,
            flags = AapFramer.FLAG_BULK,
            payload = payload
        )
    }

    // --- START_REQUEST handling ---

    @Test
    fun `onFrame START_REQUEST sends StartResponse with status 0`() = runTest {
        // For any sensor type, a START_REQUEST always gets a status=0 response.
        //
        // Arrange: val frame = startRequestFrame(sensorType = 13)
        //
        // Act: handler.onFrame(frame)
        //
        // Assert:
        //   verify {
        //       mockMux.sendEncryptedControl(
        //           ChannelId.SENSOR,
        //           SensorMessageType.START_RESPONSE,
        //           match { bytes ->
        //               val fields = ProtoEncoder.readFields(bytes)
        //               fields.any { it.fieldNumber == 1 && it.varintValue == 0L }
        //           }
        //       )
        //   }
    }

    @Test
    fun `onFrame START_REQUEST for sensorType 11 sends DrivingStatus event`() = runTest {
        // sensorType=11 triggers sendDrivingStatus() immediately.
        // Note: current code uses 11 but the registered sensor type in buildResponse is 13.
        // This test guards the EXISTING behaviour (sensorType==11 branch).
        //
        // Arrange: val frame = startRequestFrame(sensorType = 11)
        //
        // Act: handler.onFrame(frame)
        //
        // Assert:
        //   verify {
        //       mockMux.sendEncrypted(
        //           ChannelId.SENSOR,
        //           SensorMessageType.EVENT_INDICATION,
        //           any()
        //       )
        //   }
    }

    @Test
    fun `onFrame START_REQUEST for sensorType 13 (DRIVING_STATUS) sends DrivingStatus event`() = runTest {
        // RED: sensorType==13 currently does NOT trigger sendDrivingStatus()
        //      because the branch checks == 11. After the fix, 13 should also trigger it.
        //
        // Arrange: val frame = startRequestFrame(sensorType = 13)
        //
        // Act: handler.onFrame(frame)
        //
        // Assert:
        //   verify(exactly = 1) {
        //       mockMux.sendEncrypted(ChannelId.SENSOR, SensorMessageType.EVENT_INDICATION, any())
        //   }
    }

    @Test
    fun `onFrame START_REQUEST for sensorType 7 (PARKING_BRAKE) sends ParkingBrake event`() = runTest {
        // RED: ParkingBrake is never sent currently. Test drives implementation.
        //
        // Arrange: val frame = startRequestFrame(sensorType = 7)
        //
        // Act: handler.onFrame(frame)
        //
        // Assert:
        //   // A second sendEncrypted call with EVENT_INDICATION must occur (the parking brake)
        //   verify(exactly = 1) {
        //       mockMux.sendEncrypted(ChannelId.SENSOR, SensorMessageType.EVENT_INDICATION, any())
        //   }
        //   // Verify the payload contains sensorType=7
        //   val eventPayloadSlot = slot<ByteArray>()
        //   verify {
        //       mockMux.sendEncrypted(ChannelId.SENSOR, SensorMessageType.EVENT_INDICATION, capture(eventPayloadSlot))
        //   }
        //   val outerFields = ProtoEncoder.readFields(eventPayloadSlot.captured)
        //   val eventBytes = outerFields.first { it.fieldNumber == 1 }.bytesValue!!
        //   val eventFields = ProtoEncoder.readFields(eventBytes)
        //   assertEquals(7L, eventFields.first { it.fieldNumber == 1 }.varintValue)
    }

    @Test
    fun `onFrame START_REQUEST for sensorType other than 7 11 13 does not send event`() = runTest {
        // Unknown sensor types get a response but no event indication.
        //
        // Arrange: val frame = startRequestFrame(sensorType = 99)
        //
        // Act: handler.onFrame(frame)
        //
        // Assert:
        //   verify(exactly = 0) { mockMux.sendEncrypted(any(), SensorMessageType.EVENT_INDICATION, any()) }
    }

    // --- sendDrivingStatus ---

    @Test
    fun `sendDrivingStatus calls mux with channel SENSOR and EVENT_INDICATION`() {
        // Arrange: —
        // Act:     handler.sendDrivingStatus(status = 0)
        // Assert:
        //   verify { mockMux.sendEncrypted(ChannelId.SENSOR, SensorMessageType.EVENT_INDICATION, any()) }
    }

    @Test
    fun `sendDrivingStatus payload encodes status 0 correctly`() {
        // Arrange: val payloadSlot = slot<ByteArray>()
        //          every { mockMux.sendEncrypted(any(), any(), capture(payloadSlot)) } just Runs
        //
        // Act: handler.sendDrivingStatus(status = 0)
        //
        // Assert:
        //   val outer = ProtoEncoder.readFields(payloadSlot.captured)
        //   val eventBytes = outer.first { it.fieldNumber == 1 }.bytesValue!!
        //   val eventFields = ProtoEncoder.readFields(eventBytes)
        //   // sensorType=13
        //   assertEquals(13L, eventFields.first { it.fieldNumber == 1 }.varintValue)
        //   // DrivingStatusData.status=0
        //   val dsData = ProtoEncoder.readFields(eventFields.first { it.fieldNumber == 4 }.bytesValue!!)
        //   assertEquals(0L, dsData.first { it.fieldNumber == 1 }.varintValue)
    }

    @Test
    fun `onFrame with unhandled message type does not throw`() = runTest {
        // Resilience: unknown message types must be silently ignored.
        //
        // Arrange: build a frame with msgType = 0xFFFF
        //          val payload = byteArrayOf(0xFF.toByte(), 0xFF.toByte())
        //          val frame = AapFramer.AapFrame(ChannelId.SENSOR, AapFramer.FLAG_BULK, payload)
        //
        // Act+Assert: assertDoesNotThrow { handler.onFrame(frame) }
    }
}
```

### 2.5 `ControlChannelHandlerTest`

**File:** `androidauto/src/test/java/com/supertesla/aa/androidauto/channels/ControlChannelHandlerTest.kt`

```kotlin
class ControlChannelHandlerTest {

    private val mockMux: ChannelMux = mockk(relaxed = true)
    private val sdPayload: ByteArray = ServiceDiscovery.buildResponse()
    private val onChannelOpened: (Int) -> Unit = mockk(relaxed = true)
    private val onShutdown: () -> Unit = mockk(relaxed = true)
    private lateinit var handler: ControlChannelHandler

    @BeforeEach
    fun setUp() {
        handler = ControlChannelHandler(
            mux = mockMux,
            serviceDiscoveryPayload = sdPayload,
            onChannelOpened = onChannelOpened,
            onShutdown = onShutdown
        )
    }

    private fun controlFrame(msgType: Int, body: ByteArray = ByteArray(0)): AapFramer.AapFrame {
        val payload = ByteArray(2 + body.size)
        payload[0] = (msgType shr 8).toByte()
        payload[1] = (msgType and 0xFF).toByte()
        System.arraycopy(body, 0, payload, 2, body.size)
        return AapFramer.AapFrame(
            channel = ChannelId.CONTROL,
            flags = AapFramer.FLAG_BULK,
            payload = payload
        )
    }

    // --- SERVICE_DISCOVERY_REQUEST ---

    @Test
    fun `onFrame SERVICE_DISCOVERY_REQUEST sends the exact serviceDiscoveryPayload`() = runTest {
        // Verifies the payload is forwarded unchanged.
        //
        // Arrange: val frame = controlFrame(MessageType.SERVICE_DISCOVERY_REQUEST)
        //
        // Act: handler.onFrame(frame)
        //
        // Assert:
        //   verify {
        //       mockMux.sendEncrypted(
        //           ChannelId.CONTROL,
        //           MessageType.SERVICE_DISCOVERY_RESPONSE,
        //           sdPayload
        //       )
        //   }
    }

    // --- CHANNEL_OPEN_REQUEST ---

    @Test
    fun `onFrame CHANNEL_OPEN_REQUEST sends ChannelOpenResponse with status 0 on the same channel`() = runTest {
        // The response channel must match the request's frame.channel.
        //
        // Arrange:
        //   val body = ProtoEncoder.encode { writeVarint(1, 3L) }   // serviceId=3
        //   val payload = ByteArray(2 + body.size)
        //   payload[0] = (MessageType.CHANNEL_OPEN_REQUEST shr 8).toByte()
        //   payload[1] = (MessageType.CHANNEL_OPEN_REQUEST and 0xFF).toByte()
        //   System.arraycopy(body, 0, payload, 2, body.size)
        //   val frame = AapFramer.AapFrame(channel = 3, flags = AapFramer.FLAG_BULK, payload = payload)
        //
        // Act: handler.onFrame(frame)
        //
        // Assert:
        //   verify {
        //       mockMux.sendEncryptedControl(
        //           3,    // same channel as request
        //           MessageType.CHANNEL_OPEN_RESPONSE,
        //           match { bytes ->
        //               ProtoEncoder.readFields(bytes).any { it.fieldNumber == 1 && it.varintValue == 0L }
        //           }
        //       )
        //   }
    }

    @Test
    fun `onFrame CHANNEL_OPEN_REQUEST invokes onChannelOpened callback with the channel ID`() = runTest {
        // Arrange: val frame (channel = 6, as above pattern)
        // Act:     handler.onFrame(frame)
        // Assert:  verify { onChannelOpened(6) }
    }

    // --- PING_REQUEST ---

    @Test
    fun `onFrame PING_REQUEST echoes same timestamp in response`() = runTest {
        // Verifies the ping timestamp is reflected back unchanged.
        //
        // Arrange:
        //   val timestamp = 987654321L
        //   val body = ProtoEncoder.encode { writeVarint(1, timestamp) }
        //   val frame = controlFrame(MessageType.PING_REQUEST, body)
        //
        // Act: handler.onFrame(frame)
        //
        // Assert:
        //   val responseSlot = slot<ByteArray>()
        //   verify { mockMux.sendEncrypted(ChannelId.CONTROL, MessageType.PING_RESPONSE, capture(responseSlot)) }
        //   val fields = ProtoEncoder.readFields(responseSlot.captured)
        //   assertEquals(timestamp, fields.first { it.fieldNumber == 1 }.varintValue)
    }

    // --- AUDIO_FOCUS_REQUEST ---

    @Test
    fun `onFrame AUDIO_FOCUS_REQUEST with requestType 4 responds with focusState 4 (duck)`() = runTest {
        // requestType=4 (AUDIO_FOCUS_RELEASE) → focusState=4 (TRANSIENT_CAN_DUCK)
        //
        // Arrange:
        //   val body = ProtoEncoder.encode { writeVarint(1, 4L) }
        //   val frame = controlFrame(MessageType.AUDIO_FOCUS_REQUEST, body)
        //
        // Act: handler.onFrame(frame)
        //
        // Assert:
        //   val responseSlot = slot<ByteArray>()
        //   verify { mockMux.sendEncrypted(ChannelId.CONTROL, MessageType.AUDIO_FOCUS_RESPONSE, capture(responseSlot)) }
        //   val fields = ProtoEncoder.readFields(responseSlot.captured)
        //   assertEquals(4L, fields.first { it.fieldNumber == 1 }.varintValue)
    }

    @Test
    fun `onFrame AUDIO_FOCUS_REQUEST with requestType 1 responds with focusState 1 (gain)`() = runTest {
        // Arrange:
        //   val body = ProtoEncoder.encode { writeVarint(1, 1L) }
        //   val frame = controlFrame(MessageType.AUDIO_FOCUS_REQUEST, body)
        //
        // Act: handler.onFrame(frame)
        //
        // Assert: focusState == 1L in response
    }

    @Test
    fun `onFrame AUDIO_FOCUS_REQUEST with unknown requestType defaults to focusState 1`() = runTest {
        // Any type other than 4 must return GAIN (1).
        //
        // Arrange:
        //   val body = ProtoEncoder.encode { writeVarint(1, 99L) }
        //   val frame = controlFrame(MessageType.AUDIO_FOCUS_REQUEST, body)
        //
        // Act: handler.onFrame(frame)
        //
        // Assert: focusState == 1L
    }

    // --- NAVIGATION_FOCUS_REQUEST ---

    @Test
    fun `onFrame NAVIGATION_FOCUS_REQUEST responds with navFocusType 2`() = runTest {
        // Arrange: val frame = controlFrame(MessageType.NAVIGATION_FOCUS_REQUEST)
        // Act:     handler.onFrame(frame)
        // Assert:
        //   val slot = slot<ByteArray>()
        //   verify { mockMux.sendEncrypted(ChannelId.CONTROL, MessageType.NAVIGATION_FOCUS_RESPONSE, capture(slot)) }
        //   assertEquals(2L, ProtoEncoder.readFields(slot.captured).first { it.fieldNumber == 1 }.varintValue)
    }

    // --- SHUTDOWN_REQUEST ---

    @Test
    fun `onFrame SHUTDOWN_REQUEST sends ShutdownResponse and invokes onShutdown`() = runTest {
        // Arrange: val frame = controlFrame(MessageType.SHUTDOWN_REQUEST)
        //
        // Act: handler.onFrame(frame)
        //
        // Assert:
        //   verify { mockMux.sendEncrypted(ChannelId.CONTROL, MessageType.SHUTDOWN_RESPONSE, ByteArray(0)) }
        //   verify(exactly = 1) { onShutdown() }
    }

    @Test
    fun `onFrame SHUTDOWN_REQUEST does not send any other messages`() = runTest {
        // Arrange: val frame = controlFrame(MessageType.SHUTDOWN_REQUEST)
        // Act:     handler.onFrame(frame)
        // Assert:
        //   // Only SHUTDOWN_RESPONSE is sent, no discovery, ping, focus responses
        //   verify(exactly = 1) { mockMux.sendEncrypted(any(), any(), any()) }
    }

    // --- Unknown message types ---

    @Test
    fun `onFrame with unknown message type does not throw and does not call mux`() = runTest {
        // Arrange: val frame = controlFrame(0x9999)
        // Act+Assert: assertDoesNotThrow { handler.onFrame(frame) }
        //             verify(exactly = 0) { mockMux.sendEncrypted(any(), any(), any()) }
        //             verify(exactly = 0) { mockMux.sendEncryptedControl(any(), any(), any()) }
    }

    @Test
    fun `onFrame PING_RESPONSE does not send any message`() = runTest {
        // PING_RESPONSE is a no-op (AA is alive) — we must not reply to a reply.
        //
        // Arrange: val frame = controlFrame(MessageType.PING_RESPONSE)
        // Act:     handler.onFrame(frame)
        // Assert:  verify(exactly = 0) { mockMux.sendEncrypted(any(), any(), any()) }
    }
}
```

---

## 3. Red Phase

Tests that must FAIL before implementation changes:

1. `ServiceDiscoveryEncodingTest.buildMediaSetupResponse field 1 status is 0` — currently field 1 = 2L, so `assertEquals(0L, ...)` fails. This is the primary bug from doc 04.
2. `ServiceDiscoveryEncodingTest.buildParkingBrakeEvent encodes sensorType 7` — `buildParkingBrakeEvent()` does not exist yet, so the test fails to compile.
3. `SensorChannelHandlerTest.onFrame START_REQUEST for sensorType 13 sends DrivingStatus event` — current code checks `sensorType == 11`, not 13, so no event is sent.
4. `SensorChannelHandlerTest.onFrame START_REQUEST for sensorType 7 sends ParkingBrake event` — no parking brake handling exists.
5. `ProtoEncoderTest.*` — all pass or fail depending on existing encoder correctness; run to establish baseline before any changes.

---

## 4. Green Phase

Minimal changes to make each group pass:

1. **`buildMediaSetupResponse` fix**: change `ProtoEncoder.writeVarintField(out, 1, 2)` to `ProtoEncoder.writeVarintField(out, 1, 0)` in `ServiceDiscovery.kt` → `buildMediaSetupResponse field 1 status is 0` passes.

2. **`buildParkingBrakeEvent` new function**: add to `ServiceDiscovery.kt`:
   ```kotlin
   fun buildParkingBrakeEvent(engaged: Boolean = true): ByteArray {
       val out = ByteArrayOutputStream()
       ProtoEncoder.writeEmbeddedMessage(out, 1) { event ->
           ProtoEncoder.writeVarintField(event, 1, 7)  // SENSOR_PARKING_BRAKE
           ProtoEncoder.writeEmbeddedMessage(event, 7) { pb ->
               ProtoEncoder.writeVarintField(pb, 1, if (engaged) 1L else 0L)
           }
       }
       return out.toByteArray()
   }
   ```
   → `buildParkingBrakeEvent` tests pass.

3. **`SensorChannelHandler` fix for sensorType 13**: change `if (sensorType == 11)` to `if (sensorType == 11 || sensorType == 13)` → `onFrame START_REQUEST for sensorType 13` passes.

4. **`SensorChannelHandler` add parking brake branch**: add `if (sensorType == 7) { sendParkingBrake() }` and the `sendParkingBrake()` function → `onFrame START_REQUEST for sensorType 7` passes.

---

## 5. Refactor Phase

After green:

- Replace the `|| sensorType == 11 || sensorType == 13` numeric literals with a `SensorType` object mirroring `MessageType`:
  ```kotlin
  object SensorType {
      const val LOCATION: Int = 1
      const val PARKING_BRAKE: Int = 7
      const val NIGHT_MODE: Int = 10
      const val DRIVING_STATUS: Int = 13
  }
  ```
  Update both `ServiceDiscovery.kt` and `SensorChannelHandler.kt` to use these constants.

- Replace `if (sensorType == SensorType.DRIVING_STATUS || sensorType == 11)` with a `when` block for all four sensor types, each with a dedicated handler call. This mirrors the `ControlChannelHandler`'s `when (msgType)` pattern and is consistent with the codebase's existing style.

- Add `@ParameterizedTest @MethodSource` variants to `ServiceDiscoveryEncodingTest` covering all five `build*` methods with non-default arguments, to ensure no hardcoded default leaks through.

- Move `extractServiceIds` helper out of `ServiceDiscoveryResponseShapeTest` and into `TestFrameFactory.kt` so `SensorChannelHandlerTest` and `ControlChannelHandlerTest` can reuse it.

- Add a Turbine-based test for the `onChannelOpened` callback being received as a `SharedFlow` event if `ControlChannelHandler` is later refactored to expose state via Flow instead of a lambda.
