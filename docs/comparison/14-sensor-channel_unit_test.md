# 14 — Sensor Channel Completeness: Unit Test Plan

## Overview

Tests for `SensorChannelHandler` covering all four sensor types declared
in `ServiceDiscovery`: DRIVING_STATUS (13), PARKING_BRAKE (7),
NIGHT_MODE (10), and LOCATION (1). Tests also verify the protobuf
encoding shape of each sensor event payload, since a malformed proto
byte sequence causes AA to silently drop the event.

All tests run on the JVM with a `MockK`-based fake `ChannelMux` and the
real `ProtoEncoder` / `ServiceDiscovery` production code.

---

## Test Classes

| Test Class | File Path | Class Under Test |
|---|---|---|
| `SensorChannelHandlerTest` | `androidauto/src/test/java/com/supertesla/aa/androidauto/channels/SensorChannelHandlerTest.kt` | `SensorChannelHandler` |
| `SensorEventEncodingTest` | `androidauto/src/test/java/com/supertesla/aa/androidauto/channels/SensorEventEncodingTest.kt` | `ServiceDiscovery` builder functions + `ProtoEncoder` |

---

## Test Cases

### `SensorChannelHandlerTest`

> All tests use a `TestCoroutineScheduler` / `UnconfinedTestDispatcher`
> and MockK `relaxed = true` for `ChannelMux`.

---

#### `@Test fun `START_REQUEST for sensorType 13 sends StartResponse then DrivingStatus event``

- **Verifies**: The handler dispatches `sendEncryptedControl` (response)
  followed by `sendEncrypted` (event) when sensorType = 13.
- **Arrange**:
  ```kotlin
  val mux     = mockk<ChannelMux>(relaxed = true)
  val handler = SensorChannelHandler(mux)

  // Proto body: field 1, varint 13
  val body = ProtoEncoder.encode { writeVarint(1, 13L) }
  val frame = AapFramer.AapFrame(
      channel     = ChannelId.SENSOR,
      messageType = SensorMessageType.START_REQUEST,
      messageBody = body
  )
  ```
- **Act**:
  ```kotlin
  runTest { handler.onFrame(frame) }
  ```
- **Assert**:
  ```kotlin
  verify(exactly = 1) {
      mux.sendEncryptedControl(
          ChannelId.SENSOR,
          SensorMessageType.START_RESPONSE,
          any()
      )
  }
  verify(exactly = 1) {
      mux.sendEncrypted(
          ChannelId.SENSOR,
          SensorMessageType.EVENT_INDICATION,
          any()
      )
  }
  ```

---

#### `@Test fun `START_REQUEST for sensorType 7 sends StartResponse then ParkingBrake event``

- **Verifies**: sensorType = 7 causes a parking-brake event (field 1 =
  7 in outer message, field 1 = 1 in inner message).
- **Arrange**:
  ```kotlin
  val capturedPayloads = mutableListOf<ByteArray>()
  every { mux.sendEncrypted(any(), any(), capture(capturedPayloads)) } just Runs

  val body  = ProtoEncoder.encode { writeVarint(1, 7L) }
  val frame = AapFramer.AapFrame(ChannelId.SENSOR, SensorMessageType.START_REQUEST, body)
  ```
- **Act**:
  ```kotlin
  runTest { handler.onFrame(frame) }
  ```
- **Assert**:
  ```kotlin
  // At least one event payload must decode as parking-brake sensor type = 7
  val eventBytes = capturedPayloads.first()
  val outer = ProtoEncoder.readFields(eventBytes)
  val innerBytes = outer.first { it.fieldNumber == 1 }.bytesValue!!
  val inner = ProtoEncoder.readFields(innerBytes)
  val sensorTypeField = inner.first { it.fieldNumber == 1 }
  assertEquals(7L, sensorTypeField.varintValue)  // PARKING_BRAKE
  ```

---

#### `@Test fun `START_REQUEST for sensorType 7 encodes parkingBrake=true in nested message``

- **Verifies**: The inner field 7 (parking-brake message) contains
  field 1 = 1 (true).
- **Arrange**: same frame as above.
- **Assert** (additional decode step):
  ```kotlin
  val brakeMsg = inner.first { it.fieldNumber == 7 }.bytesValue!!
  val brakeFields = ProtoEncoder.readFields(brakeMsg)
  assertEquals(1L, brakeFields.first { it.fieldNumber == 1 }.varintValue)
  ```

---

#### `@Test fun `START_REQUEST for sensorType 10 sends StartResponse and invokes nightMode callback``

- **Verifies**: sensorType = 10 triggers the `onNightModeRequested`
  lambda instead of sending a fixed payload directly (the handler does
  not know the current night-mode state).
- **Arrange**:
  ```kotlin
  var nightModeCallbackInvoked = false
  handler.onNightModeRequested = { nightModeCallbackInvoked = true }

  val body  = ProtoEncoder.encode { writeVarint(1, 10L) }
  val frame = AapFramer.AapFrame(ChannelId.SENSOR, SensorMessageType.START_REQUEST, body)
  ```
- **Act**:
  ```kotlin
  runTest { handler.onFrame(frame) }
  ```
- **Assert**:
  ```kotlin
  assertTrue(nightModeCallbackInvoked)
  verify(exactly = 1) {
      mux.sendEncryptedControl(ChannelId.SENSOR, SensorMessageType.START_RESPONSE, any())
  }
  ```

---

#### `@Test fun `START_REQUEST for sensorType 1 invokes locationRequested callback``

- **Verifies**: sensorType = 1 triggers `onLocationRequested`.
- **Arrange**:
  ```kotlin
  var locationCallbackInvoked = false
  handler.onLocationRequested = { locationCallbackInvoked = true }

  val body  = ProtoEncoder.encode { writeVarint(1, 1L) }
  val frame = AapFramer.AapFrame(ChannelId.SENSOR, SensorMessageType.START_REQUEST, body)
  ```
- **Act**:
  ```kotlin
  runTest { handler.onFrame(frame) }
  ```
- **Assert**:
  ```kotlin
  assertTrue(locationCallbackInvoked)
  ```

---

#### `@Test fun `unknown message type is silently ignored without throwing``

- **Verifies**: An unrecognised `messageType` does not crash the handler.
- **Arrange**:
  ```kotlin
  val frame = AapFramer.AapFrame(ChannelId.SENSOR, 0xDEAD, ByteArray(0))
  ```
- **Act / Assert**:
  ```kotlin
  assertDoesNotThrow { runTest { handler.onFrame(frame) } }
  verify(exactly = 0) { mux.sendEncrypted(any(), any(), any()) }
  verify(exactly = 0) { mux.sendEncryptedControl(any(), any(), any()) }
  ```

---

#### `@Test fun `sendNightMode true encodes isNight=1 with sensorType 10``

- **Verifies**: The public `sendNightMode(true)` API produces a proto
  payload with outer sensorType = 10 and inner field 1 = 1.
- **Arrange**:
  ```kotlin
  val capturedPayloads = slot<ByteArray>()
  every { mux.sendEncrypted(any(), any(), capture(capturedPayloads)) } just Runs
  ```
- **Act**:
  ```kotlin
  runTest { handler.sendNightMode(true) }
  ```
- **Assert**:
  ```kotlin
  val outer = ProtoEncoder.readFields(capturedPayloads.captured)
  val eventMsg = outer.first { it.fieldNumber == 1 }.bytesValue!!
  val eventFields = ProtoEncoder.readFields(eventMsg)
  assertEquals(10L, eventFields.first { it.fieldNumber == 1 }.varintValue) // sensorType
  val nightMsg = eventFields.first { it.fieldNumber == 3 }.bytesValue!!
  val nightFields = ProtoEncoder.readFields(nightMsg)
  assertEquals(1L, nightFields.first { it.fieldNumber == 1 }.varintValue)  // isNight=true
  ```

---

#### `@Test fun `sendNightMode false encodes isNight=0``

- **Verifies**: `sendNightMode(false)` emits field 1 = 0 in the inner
  night-mode message.
- Mirrors the true test above; inner night field 1 must equal `0L`.

---

### `SensorEventEncodingTest`

These tests verify the exact protobuf wire format independently of the
handler so that encoding bugs are caught at the lowest level.

---

#### `@Test fun `buildDrivingStatusEvent status=0 encodes outer sensorType=13 and inner status=0``

- **Verifies**: `ServiceDiscovery.buildDrivingStatusEvent(0)` produces a
  proto where field 1 is a message containing field 1 = 13 (DRIVING_STATUS)
  and field 4 = message with field 1 = 0.
- **Arrange**:
  ```kotlin
  val bytes = ServiceDiscovery.buildDrivingStatusEvent(0)
  ```
- **Act**:
  ```kotlin
  val outer = ProtoEncoder.readFields(bytes)
  val event = ProtoEncoder.readFields(outer.first { it.fieldNumber == 1 }.bytesValue!!)
  ```
- **Assert**:
  ```kotlin
  assertEquals(13L, event.first { it.fieldNumber == 1 }.varintValue)
  val dsMsg = ProtoEncoder.readFields(event.first { it.fieldNumber == 4 }.bytesValue!!)
  assertEquals(0L, dsMsg.first { it.fieldNumber == 1 }.varintValue)
  ```

---

#### `@Test fun `parking brake event encodes latitudeE7 with 1e7 scale factor``

- **Verifies**: `sendLocation` converts lat=37.4220 to
  `(37.4220 * 1e7).toLong() = 374220000` in field 1 of the location message.
- **Arrange**:
  ```kotlin
  val lat = 37.4220
  val lon = -122.0840
  val accuracy = 5.0f
  val altitude = 10.0
  val heading = 90.0f
  val speed = 13.8f
  val bytes = buildLocationEventBytes(lat, lon, accuracy, altitude, heading, speed)
  ```
  where `buildLocationEventBytes` is the standalone encoding helper
  extracted from `SensorChannelHandler.sendLocation`.
- **Act**:
  ```kotlin
  val outer = ProtoEncoder.readFields(bytes)
  val eventMsg = ProtoEncoder.readFields(outer.first { it.fieldNumber == 1 }.bytesValue!!)
  val locMsg   = ProtoEncoder.readFields(eventMsg.first { it.fieldNumber == 2 }.bytesValue!!)
  ```
- **Assert**:
  ```kotlin
  assertEquals((lat * 1e7).toLong(), locMsg.first { it.fieldNumber == 1 }.varintValue)
  assertEquals((lon * 1e7).toLong(), locMsg.first { it.fieldNumber == 2 }.varintValue)
  ```

---

#### `@Test fun `location event encodes longitudeE7 with correct sign``

- **Verifies**: Negative longitude (western hemisphere) encodes as a
  negative Long in the varint field.
- **Arrange**: lon = -122.0840
- **Assert**:
  ```kotlin
  val encodedLon = locMsg.first { it.fieldNumber == 2 }.varintValue
  assertTrue(encodedLon < 0L)
  assertEquals((-122.0840 * 1e7).toLong(), encodedLon)
  ```

---

#### `@Test fun `location event encodes accuracyE3 speed and altitude with correct scale``

- **Verifies**: accuracy × 1000, altitude × 100, speed × 100 match
  field 3, 4, 6 respectively.
- **Assert**:
  ```kotlin
  assertEquals((accuracy * 1000).toLong(), locMsg.first { it.fieldNumber == 3 }.varintValue)
  assertEquals((altitude * 100).toLong(),  locMsg.first { it.fieldNumber == 4 }.varintValue)
  assertEquals((speed * 100).toLong(),     locMsg.first { it.fieldNumber == 6 }.varintValue)
  ```

---

#### `@Test fun `location event encodes bearingE6 in field 5``

- **Verifies**: heading × 1e6 appears in proto field 5.
- **Assert**:
  ```kotlin
  assertEquals((heading * 1e6).toLong(), locMsg.first { it.fieldNumber == 5 }.varintValue)
  ```

---

#### `@Test fun `location event outer sensorType field equals 1``

- **Verifies**: The wrapper event correctly marks sensorType = 1
  (LOCATION).
- **Assert**:
  ```kotlin
  assertEquals(1L, eventMsg.first { it.fieldNumber == 1 }.varintValue)
  ```

---

#### `@Test fun `parking brake event encodes sensorType=7 and engaged=true (value 1)``

- **Verifies**: The parking-brake payload has outer field 1 = 7 and inner
  field 1 = 1 inside field 7 of the event message.
- **Arrange**:
  ```kotlin
  val bytes = buildParkingBrakeEventBytes(engaged = true)
  val outer = ProtoEncoder.readFields(bytes)
  val eventMsg = ProtoEncoder.readFields(outer.first { it.fieldNumber == 1 }.bytesValue!!)
  ```
- **Assert**:
  ```kotlin
  assertEquals(7L, eventMsg.first { it.fieldNumber == 1 }.varintValue)
  val brakeMsg = ProtoEncoder.readFields(eventMsg.first { it.fieldNumber == 7 }.bytesValue!!)
  assertEquals(1L, brakeMsg.first { it.fieldNumber == 1 }.varintValue)
  ```

---

#### `@Test fun `parking brake disengaged encodes value 0``

- **Verifies**: `buildParkingBrakeEventBytes(engaged = false)` produces
  field 1 = 0 inside the parking-brake message. (Proto3 may omit the
  field entirely for default 0 — test must accept both 0 or absent.)
- **Assert**:
  ```kotlin
  val value = brakeMsg.firstOrNull { it.fieldNumber == 1 }?.varintValue ?: 0L
  assertEquals(0L, value)
  ```

---

## Red Phase

Before implementation:

- `SensorChannelHandler` lacks `onNightModeRequested`, `onLocationRequested`
  properties, `sendNightMode`, `sendParkingBrake`, `sendLocation` methods
  → compilation failures in `SensorChannelHandlerTest`.
- `when (sensorType)` in `onFrame` only handles `sensorType == 11`
  (wrong — should be 13 per protocol) and ignores 7, 10, 1 → tests
  asserting callbacks invoked will fail.
- `ServiceDiscovery` has no `buildParkingBrakeEvent`, `buildNightModeEvent`,
  or `buildLocationEvent` helpers → `SensorEventEncodingTest` fails to compile.
- The extracted `buildLocationEventBytes` standalone helper does not exist.

---

## Green Phase

Minimal additions to pass all tests:

```kotlin
// In SensorChannelHandler:
var onNightModeRequested: (() -> Unit)? = null
var onLocationRequested:  (() -> Unit)? = null

override suspend fun onFrame(frame: AapFramer.AapFrame) {
    when (frame.messageType) {
        SensorMessageType.START_REQUEST -> {
            val fields     = ProtoEncoder.readFields(frame.messageBody)
            val sensorType = fields.firstOrNull { it.fieldNumber == 1 }?.intValue ?: -1
            mux.sendEncryptedControl(
                ChannelId.SENSOR, SensorMessageType.START_RESPONSE,
                ServiceDiscovery.buildSensorStartResponse(status = 0)
            )
            when (sensorType) {
                13 -> sendDrivingStatus(0)
                7  -> sendParkingBrake(true)
                10 -> onNightModeRequested?.invoke()
                1  -> onLocationRequested?.invoke()
            }
        }
    }
}

fun sendParkingBrake(engaged: Boolean) {
    val payload = ProtoEncoder.encode {
        writeMessage(1) {
            writeVarint(1, 7L)
            writeMessage(7) { writeVarint(1, if (engaged) 1L else 0L) }
        }
    }
    mux.sendEncrypted(ChannelId.SENSOR, SensorMessageType.EVENT_INDICATION, payload)
}

fun sendNightMode(isNight: Boolean) {
    val payload = ProtoEncoder.encode {
        writeMessage(1) {
            writeVarint(1, 10L)
            writeMessage(3) { writeVarint(1, if (isNight) 1L else 0L) }
        }
    }
    mux.sendEncrypted(ChannelId.SENSOR, SensorMessageType.EVENT_INDICATION, payload)
}

fun sendLocation(
    lat: Double, lon: Double,
    accuracy: Float, altitude: Double,
    heading: Float, speed: Float
) {
    val payload = ProtoEncoder.encode {
        writeMessage(1) {
            writeVarint(1, 1L)
            writeMessage(2) {
                writeVarint(1, (lat * 1e7).toLong())
                writeVarint(2, (lon * 1e7).toLong())
                writeVarint(3, (accuracy * 1000).toLong())
                writeVarint(4, (altitude * 100).toLong())
                writeVarint(5, (heading * 1e6).toLong())
                writeVarint(6, (speed * 100).toLong())
            }
        }
    }
    mux.sendEncrypted(ChannelId.SENSOR, SensorMessageType.EVENT_INDICATION, payload)
}
```

---

## Refactor Phase

After green:

1. Extract a `SensorEventBuilder` object parallel to `ServiceDiscovery`
   that owns `buildParkingBrakeEvent`, `buildNightModeEvent`,
   `buildLocationEvent` — keeps `SensorChannelHandler` thin and makes
   `SensorEventEncodingTest` independent of the handler.
2. Replace the `var` callbacks with `StateFlow<Boolean>` for night mode
   and `SharedFlow<Location>` for GPS to fit the reactive coroutine
   architecture used elsewhere in the project.
3. Change `sensorType == 11` guard on driving-status to `sensorType == 13`
   (the correct AA protocol value) and add a regression test.
4. Add `@VisibleForTesting` on `sendParkingBrake`, `sendNightMode`, and
   `sendLocation` if they remain internal; otherwise expose them as part
   of a `SensorEventEmitter` interface for injection.
5. Replace `mux.sendEncrypted` direct calls inside `sendX` helpers with
   `scope.launch { mux.sendEncrypted(...) }` to avoid blocking the
   caller's coroutine; update tests to use `advanceUntilIdle()`.
