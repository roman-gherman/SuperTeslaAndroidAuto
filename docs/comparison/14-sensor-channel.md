# 14 — Sensor Channel Completeness

## Problem

Our SensorChannelHandler only implements DRIVING_STATUS. TaaDa implements all 4 declared sensors plus GPS/night mode forwarding from the browser.

## TaaDa Sensor Responses

| Sensor | Type ID | Response | Source |
|--------|---------|----------|--------|
| DRIVING_STATUS | 13 | status=0 (UNRESTRICTED) | Immediate |
| PARKING_BRAKE | 7 | parkingBrake=true (always parked) | Immediate |
| NIGHT_MODE | 10 | Forwarded from browser | Browser sends `{"action":"NIGHT","value":true/false}` |
| LOCATION | 1 | Forwarded from browser | Browser sends `{"action":"GPS",...}` |

## Our Current State

- DRIVING_STATUS: Implemented, sends status=0
- PARKING_BRAKE: Declared in SD but never sent
- NIGHT_MODE: Declared in SD but never sent
- LOCATION: Declared in SD but never sent
- `SensorChannelHandler` only handles sensorType=11 → sends DrivingStatus

## Changes Required

### Step 1: Handle all sensor START_REQUEST types
```kotlin
override suspend fun onFrame(frame: AapFrame) {
    when (frame.messageType) {
        0x8001 -> { // START_REQUEST
            // Send StartResponse
            channelMux.sendEncryptedControl(ChannelId.SENSOR, 0x8002, buildStartResponse())

            val sensorType = parseSensorType(frame.messageBody)
            when (sensorType) {
                13 -> sendDrivingStatus(0) // UNRESTRICTED
                7  -> sendParkingBrake(true) // always parked
                10 -> onNightModeRequested?.invoke()
                1  -> onLocationRequested?.invoke()
            }
        }
    }
}
```

### Step 2: Add parking brake sensor
```kotlin
fun sendParkingBrake(engaged: Boolean) {
    val event = ProtoEncoder.encode {
        writeMessage(1) {
            writeVarint(1, 7) // SENSOR_PARKING_BRAKE
            writeMessage(7) {
                writeVarint(1, if (engaged) 1L else 0L)
            }
        }
    }
    scope.launch { channelMux.sendEncrypted(ChannelId.SENSOR, 0x8003, event) }
}
```

### Step 3: Add night mode forwarding
```kotlin
fun sendNightMode(isNight: Boolean) {
    val event = ProtoEncoder.encode {
        writeMessage(1) {
            writeVarint(1, 10) // SENSOR_NIGHT_MODE
            writeMessage(3) {
                writeVarint(1, if (isNight) 1L else 0L)
            }
        }
    }
    scope.launch { channelMux.sendEncrypted(ChannelId.SENSOR, 0x8003, event) }
}
```

### Step 4: Add GPS forwarding
```kotlin
fun sendLocation(lat: Double, lon: Double, accuracy: Float, altitude: Double, heading: Float, speed: Float) {
    val event = ProtoEncoder.encode {
        writeMessage(1) {
            writeVarint(1, 1) // SENSOR_LOCATION
            writeMessage(2) {
                writeVarint(1, (lat * 1e7).toLong())  // latitudeE7
                writeVarint(2, (lon * 1e7).toLong())  // longitudeE7
                writeVarint(3, (accuracy * 1000).toLong()) // accuracyE3
                writeVarint(4, (altitude * 100).toLong())  // altitudeE2
                writeVarint(5, (heading * 1e6).toLong())   // bearingE6
                writeVarint(6, (speed * 100).toLong())     // speedE3
            }
        }
    }
    scope.launch { channelMux.sendEncrypted(ChannelId.SENSOR, 0x8003, event) }
}
```

### Step 5: Wire browser GPS/NIGHT actions
In `ControlSocketServer` and `WebServer`, forward GPS and NIGHT actions to `SensorChannelHandler`.

## Files to Modify
- `androidauto/src/main/java/.../channels/SensorChannelHandler.kt`
- `app/src/main/java/com/supertesla/aa/service/TransporterService.kt` (wiring)
- `network/src/main/java/.../relay/ControlSocketServer.kt` (GPS/NIGHT forwarding)

## Test Plan
- [ ] AA shows unrestricted UI (no driving mode restrictions)
- [ ] GPS action from browser → location data received by AA navigation
- [ ] Night mode toggle from browser → AA switches theme
- [ ] Parking brake sensor sent → AA allows all interactions
