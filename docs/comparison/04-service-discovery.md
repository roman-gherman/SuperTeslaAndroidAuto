# 04 — ServiceDiscovery Response Fixes

## Problem

Our ServiceDiscovery response has several issues that may cause AA to behave incorrectly or refuse channels.

## TaaDa vs Ours: Side-by-Side

### MediaSetupResponse Status
| | TaaDa | Ours |
|-|-------|------|
| Field 1 (status) | Not explicitly shown but AA expects 0 | **2** (possibly wrong) |
| maxUnacked | 1 | 1 |

**Issue:** Our `buildMediaSetupResponse` sets `field1 = 2`. In AA protocol, MediaSetupResponse field 1 is the status enum where 0 = OK. Value 2 could mean "error" and cause AA to abort channel setup.

### Audio Sinks
| | TaaDa (useBT=true) | Ours (default) |
|-|---------------------|----------------|
| Channel 5 (Media 48kHz stereo) | **Omitted** | Always included (includeAudioSinks=false, but field exists) |
| Channel 6 (System 16kHz mono) | Included | Included |
| Channel 7 (Guidance 16kHz mono) | **Omitted** | Always included |

**Issue:** Our `includeAudioSinks` defaults to `false`, which correctly omits 5 and 7. But we need to verify this is actually working.

### Sensor Types
| | TaaDa | Ours |
|-|-------|------|
| DRIVING_STATUS (13) | Sends status=0 | Sends status=0 |
| PARKING_BRAKE (7) | Sends parkingBrake=true | **Never sent** |
| NIGHT_MODE (10) | Forwarded from browser | **Never sent** |
| LOCATION (1) | Forwarded from browser | **Never sent** |

### Missing Channel Handlers
| Channel | TaaDa | Ours |
|---------|-------|------|
| 4 (Mic) | Full handler + MicActivity | **No handler** |
| 9 (Playback) | Full handler + metadata parse | **No handler** |

## Changes Required

### Step 1: Fix MediaSetupResponse status
```kotlin
// In ServiceDiscovery.kt buildMediaSetupResponse():
// Change field 1 from 2 to 0 (STATUS_OK)
fun buildMediaSetupResponse(configIndex: Int = 0, maxUnacked: Int = 1): ByteArray {
    return ProtoEncoder.encode {
        writeVarint(1, 0L)  // status = OK (was 2, possibly wrong)
        writeVarint(2, maxUnacked.toLong())
        writeVarint(3, configIndex.toLong())
    }
}
```

### Step 2: Send Parking Brake sensor
After sending DrivingStatus, also send ParkingBrake:
```kotlin
// In SensorChannelHandler, when sensorType == 7 (PARKING_BRAKE):
fun sendParkingBrake(engaged: Boolean = true) {
    val event = ProtoEncoder.encode {
        writeMessage(1) {
            writeVarint(1, 7) // SENSOR_PARKING_BRAKE
            writeMessage(7) {
                writeVarint(1, if (engaged) 1L else 0L)
            }
        }
    }
    channelMux.sendEncrypted(ChannelId.SENSOR, 0x8003, event)
}
```

### Step 3: Add stub handlers for Mic (ch4) and Playback (ch9)
Even if we don't fully implement mic/playback, we need handlers that respond to SETUP_REQUEST so AA doesn't get stuck:
```kotlin
// MicChannelHandler - responds to MIC_REQUEST with MIC_RESPONSE
// PlaybackStatusHandler - accepts metadata silently
```

### Step 4: Handle all sensor START_REQUEST types
Current code only handles sensorType=11 (which maps to DRIVING_STATUS). Need to also handle:
- sensorType=10 (NIGHT_MODE) — store callback for browser GPS/night data
- sensorType=1 (LOCATION) — store callback
- sensorType=7 (PARKING_BRAKE) — send immediately

## Files to Modify
- `androidauto/src/main/java/.../proto/ServiceDiscovery.kt`
- `androidauto/src/main/java/.../channels/SensorChannelHandler.kt`
- Create `androidauto/src/main/java/.../channels/MicChannelHandler.kt`
- Create `androidauto/src/main/java/.../channels/PlaybackStatusHandler.kt`
- `androidauto/src/main/java/.../headunit/AAHeadUnitEmulator.kt` (register new handlers)

## Test Plan
- [ ] AA completes ServiceDiscovery without errors
- [ ] AA opens video channel (ch3) successfully
- [ ] AA opens system audio channel (ch6) successfully
- [ ] AA opens mic channel (ch4) without hanging
- [ ] Parking brake sensor sent (check AA shows unrestricted UI)
- [ ] `adb logcat | grep "SETUP_REQUEST"` shows proper responses
