# Phase 4: Touch Input

## Goal
Enable bidirectional interaction by capturing touch events in Tesla's browser and relaying them back to Android Auto. By the end, tapping on the map, pressing buttons, and scrolling in the Tesla browser controls the Android Auto UI.

---

## Prerequisites
- Phase 3 complete (video streaming to Tesla browser working)
- WebSocket connection established between browser and server

---

## Architecture

```
Tesla Browser                    Phone Server                  Android Auto
┌─────────────┐                 ┌──────────────┐              ┌──────────┐
│ Touch Overlay│ --pointerdown-->│ WebSocket    │              │          │
│ (touchpad)   │ --pointermove-->│ Handler      │--InputEvent->│ AA Input │
│              │ --pointerup---->│              │  (protobuf)  │ Channel  │
│              │                 │ Coordinate   │              │          │
│              │                 │ Transform    │              │          │
└─────────────┘                 └──────────────┘              └──────────┘
```

---

## Tasks

### 4.1 Browser Touch Capture (touch.js)

**File:** `web/src/main/assets/touch.js`

**Purpose:** Capture all touch/pointer events on the overlay div and send via WebSocket.

```javascript
class TouchHandler {
    constructor(webSocket) {
        this.ws = webSocket;
        this.touchpad = document.getElementById('touchpad');
        this.videoElement = document.getElementById('player');
        this.activePointers = new Map();
        this.bindEvents();
    }

    bindEvents() {
        // Use Pointer Events API (supports multi-touch)
        this.touchpad.addEventListener('pointerdown', (e) => this.onPointerDown(e));
        this.touchpad.addEventListener('pointermove', (e) => this.onPointerMove(e));
        this.touchpad.addEventListener('pointerup', (e) => this.onPointerUp(e));
        this.touchpad.addEventListener('pointercancel', (e) => this.onPointerUp(e));

        // Prevent default to avoid browser gestures
        this.touchpad.addEventListener('touchstart', (e) => e.preventDefault());
        this.touchpad.addEventListener('contextmenu', (e) => e.preventDefault());

        // Long press handling (for AA context menus)
        this.longPressTimer = null;
    }

    normalizeCoordinates(event) {
        // Get video element bounding rect (accounts for letterboxing)
        const rect = this.videoElement.getBoundingClientRect();

        // Calculate position relative to video content (not viewport)
        const x = (event.clientX - rect.left) / rect.width;
        const y = (event.clientY - rect.top) / rect.height;

        // Clamp to 0.0 - 1.0
        return {
            x: Math.max(0, Math.min(1, x)),
            y: Math.max(0, Math.min(1, y))
        };
    }

    onPointerDown(event) {
        event.preventDefault();
        this.touchpad.setPointerCapture(event.pointerId);
        const coords = this.normalizeCoordinates(event);
        this.activePointers.set(event.pointerId, coords);
        this.send('down', event.pointerId, coords);
    }

    onPointerMove(event) {
        if (!this.activePointers.has(event.pointerId)) return;
        const coords = this.normalizeCoordinates(event);
        this.activePointers.set(event.pointerId, coords);
        this.send('move', event.pointerId, coords);
    }

    onPointerUp(event) {
        if (!this.activePointers.has(event.pointerId)) return;
        const coords = this.normalizeCoordinates(event);
        this.activePointers.delete(event.pointerId);
        this.send('up', event.pointerId, coords);
    }

    send(action, pointerId, coords) {
        if (this.ws.readyState !== WebSocket.OPEN) return;
        this.ws.send(JSON.stringify({
            type: 'touch',
            action: action,
            pointerId: pointerId,
            x: coords.x,
            y: coords.y,
            timestamp: Date.now()
        }));
    }
}
```

**Steps:**
1. Implement Pointer Events listeners on `#touchpad` div
2. Implement coordinate normalization (viewport -> 0.0-1.0 range)
3. Account for video letterboxing (object-fit: contain creates black bars)
4. Handle pointer capture (so moves outside element still tracked)
5. Implement multi-touch support (multiple pointerId tracking)
6. Add move event throttling via requestAnimationFrame (~60fps)
7. Prevent default browser gestures (zoom, scroll, back navigation)
8. Handle pointer cancel (e.g., system gesture interrupts)

**Move event throttling:**
```javascript
// Batch move events to avoid flooding WebSocket
let pendingMoves = new Map();
let rafScheduled = false;

onPointerMove(event) {
    const coords = this.normalizeCoordinates(event);
    pendingMoves.set(event.pointerId, { coords, pointerId: event.pointerId });

    if (!rafScheduled) {
        rafScheduled = true;
        requestAnimationFrame(() => {
            pendingMoves.forEach(({ coords, pointerId }) => {
                this.send('move', pointerId, coords);
            });
            pendingMoves.clear();
            rafScheduled = false;
        });
    }
}
```

**Acceptance criteria:**
- [ ] Touch down/move/up events captured reliably
- [ ] Coordinates normalized to 0.0-1.0 range
- [ ] Multi-touch works (two-finger gestures)
- [ ] No browser default gestures interfere
- [ ] Move events throttled to ~60fps max

---

### 4.2 WebSocket Touch Event Handler (Server)

**File:** `network/src/main/java/com/supertesla/aa/network/websocket/TouchInputRelay.kt`

**Purpose:** Receive touch events from browser WebSocket, transform coordinates, emit as AAP input events.

```kotlin
class TouchInputRelay(
    private val displayWidth: Int,    // AA display width (e.g., 1280)
    private val displayHeight: Int    // AA display height (e.g., 720)
) {
    @Serializable
    data class BrowserTouchEvent(
        val type: String,           // "touch"
        val action: String,         // "down", "move", "up"
        val pointerId: Int,
        val x: Float,              // 0.0 - 1.0
        val y: Float,              // 0.0 - 1.0
        val timestamp: Long
    )

    private val _inputEvents = MutableSharedFlow<InputEvent>(
        replay = 0,
        extraBufferCapacity = 64
    )
    val inputEvents: SharedFlow<InputEvent> = _inputEvents

    suspend fun handleWebSocketMessage(message: String) {
        val event = Json.decodeFromString<BrowserTouchEvent>(message)
        if (event.type != "touch") return

        val aaAction = when (event.action) {
            "down" -> TouchAction.ACTION_DOWN
            "move" -> TouchAction.ACTION_MOVE
            "up" -> TouchAction.ACTION_UP
            else -> return
        }

        // Transform normalized coords to AA display coords
        val aaX = (event.x * displayWidth).toInt().coerceIn(0, displayWidth - 1)
        val aaY = (event.y * displayHeight).toInt().coerceIn(0, displayHeight - 1)

        val inputEvent = InputEvent.newBuilder()
            .setTimestamp(System.currentTimeMillis().toInt())
            .addTouch(
                TouchEvent.newBuilder()
                    .setAction(aaAction.value)
                    .setX(aaX)
                    .setY(aaY)
                    .setPointerId(event.pointerId)
                    .build()
            )
            .build()

        _inputEvents.emit(inputEvent)
    }
}
```

**Steps:**
1. Define `BrowserTouchEvent` data class with kotlinx-serialization
2. Implement JSON deserialization of WebSocket text frames
3. Implement coordinate transformation (normalized -> AA display pixels)
4. Build AAP `InputEvent` protobuf messages
5. Emit to `SharedFlow` consumed by `AAHeadUnitEmulator`
6. Handle invalid/malformed messages gracefully
7. Add logging for touch events (debug mode only, with rate limiting)

**Acceptance criteria:**
- [ ] Correctly deserializes browser touch events
- [ ] Coordinate mapping is accurate (corners, center, edges)
- [ ] Produces valid AAP InputEvent protobufs
- [ ] Handles rapid event streams without dropping

---

### 4.3 Integrate Touch with WebSocket Server

**File:** Update `network/.../webserver/WebServer.kt`

**Purpose:** Wire the WebSocket endpoint to handle both video streaming and touch events.

```kotlin
// In WebServer routing
webSocket("/ws") {
    // Unified WebSocket: receives touch events, sends video/control
    val clientId = UUID.randomUUID().toString()

    // Start video streaming to this client
    val videoJob = launch {
        videoStreamHandler.streamToClient(this@webSocket)
    }

    // Handle incoming messages (touch events)
    for (frame in incoming) {
        when (frame) {
            is Frame.Text -> {
                touchInputRelay.handleWebSocketMessage(frame.readText())
            }
            is Frame.Close -> break
            else -> {} // ignore binary frames from browser
        }
    }

    videoJob.cancel()
}
```

**Steps:**
1. Merge video streaming and touch handling into single `/ws` endpoint
2. Bidirectional: server sends binary (video), client sends text (touch)
3. Handle concurrent reads and writes
4. Clean up resources on disconnect
5. Update web frontend to use single WebSocket connection for both

**Acceptance criteria:**
- [ ] Single WebSocket handles both video output and touch input
- [ ] No interference between binary video frames and text touch events

---

### 4.4 Wire Touch Events to AAP Input Channel

**File:** Update `androidauto/.../headunit/AAHeadUnitEmulator.kt`

**Purpose:** Forward touch events from `TouchInputRelay` to AA via the input channel.

```kotlin
// In AAHeadUnitEmulator
private fun startTouchForwarding() {
    scope.launch {
        touchInputRelay.inputEvents.collect { inputEvent ->
            channelMux.send(
                channelId = inputChannelId,
                payload = inputEvent.toByteArray(),
                encrypt = true
            )
        }
    }
}
```

**Steps:**
1. Collect from `TouchInputRelay.inputEvents` flow
2. Serialize protobuf and send on input channel
3. Ensure low latency (no batching delay)
4. Handle backpressure (drop oldest if channel is congested)

**Acceptance criteria:**
- [ ] Touch events reach Android Auto within <50ms of browser event
- [ ] AA UI responds to taps (buttons highlight, map pans)

---

### 4.5 Advanced Touch Gestures

**Purpose:** Handle Android Auto-specific gestures beyond simple taps.

**Gesture mapping:**
| Browser Gesture | AA Action |
|---|---|
| Single tap | Touch down + up |
| Long press (>500ms) | Touch down, hold, up |
| Drag/swipe | Touch down + moves + up |
| Two-finger pinch | Multi-touch events (map zoom) |
| Scroll (wheel) | Convert to swipe gesture |

**Steps:**
1. Test basic tap works end-to-end (Phase 4.1-4.4)
2. Test drag/swipe (list scrolling, map panning)
3. Implement long press detection (timer-based in browser)
4. Test two-finger zoom on Google Maps
5. Handle mouse scroll wheel for laptop testing (convert to swipe)

**Acceptance criteria:**
- [ ] Tap on buttons works (media controls, navigation)
- [ ] Swipe to scroll lists works
- [ ] Drag to pan map works
- [ ] Long press opens context menus
- [ ] Pinch-to-zoom works on maps (if supported)

---

## Phase 4 Verification Checklist

1. [ ] Browser captures touch events without interfering with video
2. [ ] Coordinates map correctly (tap center of button = button activates)
3. [ ] Touch down/move/up sequence is complete (no stuck states)
4. [ ] Multi-touch tracked correctly
5. [ ] End-to-end latency: touch -> visual response < 150ms
6. [ ] Scroll/drag gestures work in AA lists and maps
7. [ ] Long press works for AA context actions
8. [ ] No ghost touches or coordinate drift
9. [ ] Works with both finger touch and mouse (for dev testing)
10. [ ] Browser gestures (back, zoom) are suppressed

---

## Estimated Effort
- Touch capture JS: 1 day
- Touch relay server: 0.5 day
- WebSocket integration: 0.5 day
- AAP input channel wiring: 0.5 day
- Advanced gestures: 1 day
- Testing & coordinate calibration: 1.5 days
- **Total: ~5 days**
