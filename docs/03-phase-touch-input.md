# Phase 3: Touch Input (Browser → AA Protocol)

## Overview

When the user touches the Tesla browser screen, those events need to reach Android Auto as native touch input — as if from a real car touchscreen. TaaDa converts browser touch events into AA protocol `SensorBatch` / `TouchEvent` protobuf messages and injects them directly into the AA communication channel.

**This replaces our AccessibilityService approach.** Instead of OS-level gesture injection, we inject into the AA protocol itself, which is cleaner and doesn't require special permissions.

## What TaaDa Does (Exact Implementation)

### 1. Touch Event Reception (WebSocket)

TaaDa accepts touch events in two formats:

#### JSON Format (from browser JavaScript)
```json
{
    "action": "MULTITOUCH_DOWN",
    "touches": [
        {"id": 0, "x": 640, "y": 360}
    ],
    "allTouches": [
        {"id": 0, "x": 640, "y": 360}
    ]
}
```

Actions: `MULTITOUCH_DOWN`, `MULTITOUCH_UP`, `MULTITOUCH_MOVE`, `MULTITOUCH_CANCEL`

#### Binary Format (compact, for high-frequency moves)
```
Byte 0:     action (0=DOWN, 1=MOVE, 2=UP, 3=SINGLE_TOUCH)
Byte 1:     touchCount (number of moved touches)
Bytes 2-N:  touchCount × TouchPoint (6 bytes each)
Byte N+1:   allTouchesCount
Bytes N+2-M: allTouchesCount × TouchPoint (6 bytes each)
Bytes M+1-M+4: timestamp delta (4-byte int, big-endian, cumulative)

TouchPoint: 3 × uint16 (big-endian)
  - id:  2 bytes (& 0xFFFF)
  - x:   2 bytes (& 0xFFFF)
  - y:   2 bytes (& 0xFFFF)
```

### 2. Touch Processing (ControlSocketServer)

```java
void processMultiTouchEvent(PointerAction action,
                            List<TouchPoint> touches,
                            List<TouchPoint> allTouches) {

    // Map to AA pointer actions
    PointerAction mappedAction = action;
    int actionIndex = 0;

    switch (action) {
        case ACTION_DOWN:
            if (allTouches.size() > 1) {
                // Multi-touch: find which pointer is new
                mappedAction = ACTION_POINTER_DOWN;
                actionIndex = findNewPointerIndex(touches, allTouches);
            }
            break;

        case ACTION_UP:
            if (allTouches.size() > 0) {
                mappedAction = ACTION_POINTER_UP;
                // Merge touches + allTouches for full state
            }
            break;

        case ACTION_MOVED:
            // Use allTouches (full current state)
            break;

        case ACTION_TOUCH:  // single touch
            mappedAction = ACTION_DOWN;
            break;
    }

    // Create protobuf TouchEvent
    TouchEvent.Builder touchEvent = TouchEvent.newBuilder();
    touchEvent.setAction(mappedAction.value);
    touchEvent.setActionIndex(actionIndex);

    for (TouchPoint point : allTouches) {
        Pointer.Builder pointer = Pointer.newBuilder();
        pointer.setId(point.id);
        pointer.setX(point.x);
        pointer.setY(point.y);
        touchEvent.addPointers(pointer);
    }

    // Queue for sending via AA protocol
    touchEventHandler.queueTouchEvent(touchEvent.build());
}
```

### 3. PointerAction Enum

```java
enum PointerAction {
    ACTION_DOWN(0),
    ACTION_UP(1),
    ACTION_MOVED(2),
    ACTION_POINTER_DOWN(5),
    ACTION_POINTER_UP(6);
}
```

### 4. Sending Touch via AA Protocol

Touch events are sent as protobuf messages on Channel 3 (Sensors), Service 3:

```java
// Create InputReport protobuf
InputReport.Builder report = InputReport.newBuilder();
report.setTimestamp(System.nanoTime());        // nanoseconds
report.setDisplayChannel(2);                    // video channel
report.setTouchEvent(touchEvent);

// Wrap in ProtocolMessage
ProtocolMessage msg = messagePool.create(
    channel: 0x03,    // sensor channel
    service: 0x03,
    messageType: /* touch event type */,
    payload: report.build().toByteArray()
);

// Queue for sending (SSL encrypted)
eventBus.post(msg);
```

### 5. Touch Event Optimization

TaaDa uses an `OptimizedTouchEventHandler` that:
- Coalesces rapid MOVE events (only sends latest position)
- Ensures DOWN and UP events are never dropped
- Limits send rate to prevent overwhelming the protocol

### 6. GPS / Location Data

TaaDa also forwards GPS data from the browser as sensor messages:

```json
{"action": "GPS", "latitude": 48.8566, "longitude": 2.3522}
```

Converted to protobuf:
```java
LocationData.Builder location = LocationData.newBuilder();
location.setLatitude((long)(lat * 1e7));    // microdegrees
location.setLongitude((long)(lon * 1e7));
location.setAltitude((long)(alt * 100));    // centimeters
location.setAccuracy((int)(acc * 1000));    // millimeters
location.setHeading((long)(heading * 1e6)); // microdegrees
location.setSpeed((long)(speed * 100));     // cm/s
```

### 7. Night Mode

```json
{"action": "NIGHT", "value": true}
```

Sent as `NightModeData` protobuf on sensor channel.

## What We Already Have

| Component | File | Status |
|-----------|------|--------|
| Input channel handler | `InputChannelHandler.kt` | Complete — has `sendTouchEvent()` |
| Sensor channel handler | `SensorChannelHandler.kt` | Complete — sends driving status |
| Touch relay (WebSocket) | `network/websocket/TouchInputRelay.kt` | Complete — parses JSON touches |
| Touch injection service | `service/TouchInjectionService.kt` | Complete — AccessibilityService approach |

## What Needs to Change

### 1. Route Touch Events to AA Protocol Instead of AccessibilityService

Current flow:
```
Browser → WebSocket → TouchInputRelay → TouchInjectionService (AccessibilityService)
```

New flow:
```
Browser → WebSocket → TouchInputRelay → InputChannelHandler.sendTouchEvent()
```

### 2. Update TouchInputRelay Coordinate Mapping

Current relay sends normalized (0.0-1.0) coordinates. AA protocol expects **pixel coordinates** matching the advertised video resolution (1280×720).

```kotlin
// Current: normalized
val x = jsonObj.getDouble("x")  // 0.0 to 1.0
val y = jsonObj.getDouble("y")  // 0.0 to 1.0

// Needed: pixel coordinates
val pixelX = (x * 1280).toInt()
val pixelY = (y * 720).toInt()
```

### 3. Support Multi-Touch

Current relay only handles single touch. Need to support TaaDa's format:
- `touches` array (changed pointers)
- `allTouches` array (all current pointers)
- Pointer DOWN/UP with actionIndex for multi-touch

### 4. Add Binary Touch Protocol

For high-frequency move events, the binary format is much more efficient than JSON. Implement `BinaryTouchDecoder`:

```kotlin
class BinaryTouchDecoder {
    private var lastTimestamp: Long = 0

    fun decode(buffer: ByteBuffer): TouchEvent {
        val action = buffer.get().toInt()  // 0-3
        val touchCount = buffer.get().toInt()

        val touches = (0 until touchCount).map {
            TouchPoint(
                id = buffer.short.toInt() and 0xFFFF,
                x = buffer.short.toInt() and 0xFFFF,
                y = buffer.short.toInt() and 0xFFFF
            )
        }

        val allCount = buffer.get().toInt()
        val allTouches = (0 until allCount).map {
            TouchPoint(
                id = buffer.short.toInt() and 0xFFFF,
                x = buffer.short.toInt() and 0xFFFF,
                y = buffer.short.toInt() and 0xFFFF
            )
        }

        val delta = buffer.int
        lastTimestamp += delta

        return TouchEvent(action, touches, allTouches, lastTimestamp)
    }
}
```

### 5. Add Touch Event Optimization

```kotlin
class OptimizedTouchEventHandler(
    private val sendCallback: (TouchEvent) -> Unit
) {
    private var pendingMove: TouchEvent? = null
    private val handler = Handler(Looper.getMainLooper())

    fun queueTouchEvent(event: TouchEvent) {
        when (event.action) {
            ACTION_DOWN, ACTION_UP, ACTION_POINTER_DOWN, ACTION_POINTER_UP -> {
                // Always send immediately (never drop)
                flushPendingMove()
                sendCallback(event)
            }
            ACTION_MOVED -> {
                // Coalesce: replace pending move with latest
                pendingMove = event
                handler.removeCallbacksAndMessages(null)
                handler.postDelayed({ flushPendingMove() }, 8) // ~120Hz max
            }
        }
    }

    private fun flushPendingMove() {
        pendingMove?.let { sendCallback(it) }
        pendingMove = null
    }
}
```

### 6. Add GPS Forwarding

Add GPS/location support to the touch relay:

```kotlin
// In WebSocket message handler
when (action) {
    "GPS" -> {
        val lat = json.getDouble("latitude")
        val lon = json.getDouble("longitude")
        sensorHandler.sendLocation(lat, lon)
    }
    "NIGHT" -> {
        val isNight = json.getBoolean("value")
        sensorHandler.sendNightMode(isNight)
    }
}
```

### 7. Update Browser JavaScript

The browser-side touch handler needs to send events matching AA's expected format:

```javascript
// Current: single touch, normalized
ws.send(JSON.stringify({
    type: "touch",
    action: "down",
    x: 0.5,
    y: 0.5
}));

// New: multi-touch, pixel coordinates matching video resolution
ws.send(JSON.stringify({
    action: "MULTITOUCH_DOWN",
    touches: [{id: 0, x: 640, y: 360}],
    allTouches: [{id: 0, x: 640, y: 360}]
}));
```

## Implementation Tasks

1. [ ] Update `TouchInputRelay` to route events to `InputChannelHandler.sendTouchEvent()` instead of `TouchInjectionService`
2. [ ] Update coordinate mapping: normalized → pixel (1280×720)
3. [ ] Add multi-touch support (`touches` + `allTouches` arrays)
4. [ ] Add `PointerAction` enum matching TaaDa's values
5. [ ] Implement `BinaryTouchDecoder` for compact binary format
6. [ ] Implement `OptimizedTouchEventHandler` for move coalescing
7. [ ] Add GPS location forwarding via sensor channel
8. [ ] Add night mode forwarding
9. [ ] Update browser JavaScript touch handler
10. [ ] Test: touch in browser → AA receives input → UI responds

## Data Flow

```
Tesla Browser
  │ Touch events (JSON or Binary via WebSocket)
  ▼
ControlSocketServer (WebSocket)
  │ Parses JSON/Binary format
  ▼
BinaryTouchDecoder / JSON Parser
  │ Produces TouchEvent with pixel coords
  ▼
OptimizedTouchEventHandler
  │ Coalesces moves, never drops DOWN/UP
  ▼
InputChannelHandler.sendTouchEvent()
  │ Encodes as InputReport protobuf
  │ Encrypts via AapCrypto
  ▼
ChannelMux → Socket → Android Auto
  │ AA processes touch as if from real car screen
  ▼
Android Auto UI responds
  (Waze scrolls, buttons click, etc.)
```

## Coordinate System

```
┌──────────────────────────────────────┐
│ (0,0)                       (1279,0) │
│                                      │
│            AA Display                │
│           1280 × 720                 │
│                                      │
│ (0,719)                   (1279,719) │
└──────────────────────────────────────┘

Browser sends:  pixel coords (0-1279, 0-719)
  or normalized (0.0-1.0) → multiply by 1280/720
AA expects:     pixel coords matching video resolution
```
