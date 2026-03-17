# 09 — Browser Keepalive & Video Focus Management

## Problem

No timeout mechanism exists when the browser disconnects or crashes. TaaDa auto-disables video focus after 3 seconds of no PING, preventing zombie streams.

## TaaDa Approach

```
Browser sends {"action":"PING","fps":N} every 1-2s
→ Server resets 3-second timer
→ Server responds with binary {0x00,0x00,0x00,0x00,0x1F}

If no PING for 3 seconds:
→ NalStreamManager.toogleVideoFocus(false)
→ Sends VIDEO_FOCUS_NATIVE to AA
→ AA stops sending video frames
```

Additionally:
- Video focus retry: if `isVideoActive=false` when focus requested, retry after 300ms
- Keyframe throttle: max once per 2 seconds
- Video focus off on WebSocket disconnect (`onClose`)

## Our Current State

- `ControlSocketServer` handles "PING" action but response is just a log
- No timeout mechanism — if browser disconnects, video keeps streaming to nowhere
- `NalStreamManager.requestKeyFrame()` has 2-second debounce (good!)
- No video focus retry on `isVideoActive=false`
- No `onClose` video focus disable

## Changes Required

### Step 1: Add 3-second keepalive timeout
```kotlin
// In ControlSocketServer or TransporterService:
private var keepaliveHandler = Handler(Looper.getMainLooper())
private val videoFocusTimeout = Runnable {
    Timber.w("Browser keepalive timeout — disabling video focus")
    nalStreamManager?.toggleVideoFocus(false)
}

// On PING received:
keepaliveHandler.removeCallbacks(videoFocusTimeout)
keepaliveHandler.postDelayed(videoFocusTimeout, 3000L)

// On WebSocket disconnect:
keepaliveHandler.removeCallbacks(videoFocusTimeout)
nalStreamManager?.toggleVideoFocus(false)
```

### Step 2: Add PING to browser player.js
```javascript
// Send PING every 2 seconds
setInterval(() => {
    if (ws && ws.readyState === WebSocket.OPEN) {
        ws.send(JSON.stringify({
            action: "PING",
            fps: currentFps || 0
        }));
    }
}, 2000);
```

### Step 3: Add binary PING response
When server receives PING, respond with 5-byte binary (TaaDa compat):
```kotlin
// Response to PING:
conn.send(byteArrayOf(0, 0, 0, 0, 0x1F))
```

### Step 4: Add video focus retry
```kotlin
// In NalStreamManager.toggleVideoFocus():
fun toggleVideoFocus(focused: Boolean) {
    if (focused && !TransporterService.isVideoActive) {
        // Video channel not ready yet, retry after 300ms
        handler.postDelayed({ toggleVideoFocus(true) }, 300)
        return
    }
    // ... existing logic
}
```

### Step 5: Disable video focus on WebSocket close
```kotlin
// In ControlSocketServer.onClose():
override fun onClose(conn: WebSocket, code: Int, reason: String, remote: Boolean) {
    nalStreamManager?.toggleVideoFocus(false)
    keepaliveHandler.removeCallbacks(videoFocusTimeout)
}
```

### Step 6: Track client FPS from PING
```kotlin
// Parse FPS from PING JSON:
val fps = json.optInt("fps", 0)
nalStreamManager?.updateClientFps(fps)
```

## Files to Modify
- `network/src/main/java/.../relay/ControlSocketServer.kt`
- `streaming/src/main/java/.../video/NalStreamManager.kt`
- `app/src/main/java/com/supertesla/aa/service/TransporterService.kt`
- `web/src/main/assets/player.js`

## Test Plan
- [ ] Browser sends PING every 2 seconds (check Network tab)
- [ ] Server responds with 5-byte binary
- [ ] Close Tesla browser tab → video focus disabled within 3 seconds
- [ ] Reopen browser → video focus re-enabled on START
- [ ] Keyframe requested max once per 2 seconds
- [ ] No zombie video streams consuming bandwidth
