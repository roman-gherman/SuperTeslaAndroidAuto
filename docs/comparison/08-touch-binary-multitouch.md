# 08 — Touch: Binary Protocol & Full Multi-touch

## Problem

Our touch handling is JSON-only and supports limited multi-touch. TaaDa uses an efficient binary protocol (6 bytes per pointer) and full 10-finger multi-touch.

## TaaDa Binary Touch Format

```
Byte 0:       action (0=DOWN, 1=MOVE, 2=UP, 3=TOUCH)
Byte 1:       touchCount
Per touch:    id(uint16 BE) + x(uint16 BE) + y(uint16 BE) = 6 bytes
Then:         allTouchCount(uint8)
Per allTouch: id(uint16 BE) + x(uint16 BE) + y(uint16 BE) = 6 bytes
Last 4 bytes: timestamp delta (uint32 BE)
```

Detection: `data.length >= 8 && action <= 3 && touchCount <= 10`

## Our Current State

**Browser (touch.js):** Sends JSON MULTITOUCH format (correct, matches TaaDa JSON):
```json
{"action":"MULTITOUCH_DOWN","touches":[{"id":0,"x":640,"y":360}],"allTouches":[...]}
```

**Server (ControlSocketServer):** Handles MULTITOUCH JSON + simple touch format. Binary touch marked as `TODO Phase 3.2`.

**AA Protocol (InputChannelHandler):** Only sends single-pointer events:
```kotlin
fun sendTouchEvent(action: Int, x: Int, y: Int, pointerId: Int = 0)
// Only one pointer_data per InputReport
```

## Changes Required

### Step 1: Add binary touch support to browser (touch.js)
Add binary encoding option that sends touch data as ArrayBuffer instead of JSON:
```javascript
function encodeBinaryTouch(action, touches, allTouches) {
    const buf = new ArrayBuffer(1 + 1 + touches.length*6 + 1 + allTouches.length*6 + 4);
    const view = new DataView(buf);
    let offset = 0;
    view.setUint8(offset++, action);
    view.setUint8(offset++, touches.length);
    for (const t of touches) {
        view.setUint16(offset, t.id); offset += 2;
        view.setUint16(offset, t.x); offset += 2;
        view.setUint16(offset, t.y); offset += 2;
    }
    view.setUint8(offset++, allTouches.length);
    for (const t of allTouches) {
        view.setUint16(offset, t.id); offset += 2;
        view.setUint16(offset, t.x); offset += 2;
        view.setUint16(offset, t.y); offset += 2;
    }
    view.setUint32(offset, performance.now() & 0xFFFFFFFF);
    return buf;
}
```

### Step 2: Add BinaryTouchDecoder to server
Create `BinaryTouchDecoder.kt` matching TaaDa's format:
```kotlin
object BinaryTouchDecoder {
    fun isBinaryFormat(data: ByteArray): Boolean =
        data.size >= 8 && (data[0].toInt() and 0xFF) <= 3 && (data[1].toInt() and 0xFF) <= 10

    data class TouchPoint(val id: Int, val x: Int, val y: Int)
    data class DecodedTouch(val action: Int, val touches: List<TouchPoint>, val allTouches: List<TouchPoint>)

    fun decode(data: ByteArray): DecodedTouch { /* ... */ }
}
```

### Step 3: Add multi-touch to InputChannelHandler
```kotlin
fun sendMultiTouchEvent(
    action: Int,
    actionIndex: Int,
    pointers: List<TouchPointer>
) {
    val report = ProtoEncoder.encode {
        writeVarint(1, SystemClock.elapsedRealtime() * 1_000_000L)
        writeVarint(2, ChannelId.VIDEO.toLong())
        writeMessage(3) { // touch_event
            for (pointer in pointers) {
                writeMessage(1) { // pointer_data
                    writeVarint(1, pointer.x.toLong())
                    writeVarint(2, pointer.y.toLong())
                    writeVarint(3, pointer.id.toLong())
                }
            }
            writeVarint(3, action.toLong())
            writeVarint(4, actionIndex.toLong())
        }
    }
    channelMux.sendEncrypted(ChannelId.INPUT, 0x8001, report)
}
```

### Step 4: Map browser multi-touch actions to AA PointerActions
```
Browser DOWN + allTouches > 1 → AA ACTION_POINTER_DOWN (5)
Browser DOWN + allTouches ≤ 1 → AA ACTION_DOWN (0)
Browser UP + allTouches > 0   → AA ACTION_POINTER_UP (6)
Browser UP + allTouches = 0   → AA ACTION_UP (1)
Browser MOVE                  → AA ACTION_MOVED (2)
Browser CANCEL                → AA ACTION_UP (1)
```

### Step 5: Add optimized touch handler thread
TaaDa uses a dedicated `HandlerThread("TouchEventProcessor", priority=-8)` with a backup `LinkedBlockingQueue(32)`. Consider using a coroutine dispatcher with high priority.

## Files to Modify
- `web/src/main/assets/touch.js` (binary encoding)
- Create `network/src/main/java/.../protocol/BinaryTouchDecoder.kt`
- `network/src/main/java/.../relay/ControlSocketServer.kt` (binary touch handling)
- `androidauto/src/main/java/.../channels/InputChannelHandler.kt` (multi-touch)
- `app/src/main/java/com/supertesla/aa/service/TransporterService.kt` (wiring)

## Test Plan
- [ ] Single tap works (browser → AA)
- [ ] Tap and drag works (swipe gestures in AA maps)
- [ ] Pinch-to-zoom works (two-finger gesture)
- [ ] Binary touch messages smaller than JSON equivalents
- [ ] Touch latency acceptable (< 50ms browser → AA response)
- [ ] No touch events lost under rapid input
