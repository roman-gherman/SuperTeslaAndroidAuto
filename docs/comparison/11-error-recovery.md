# 11 — Error Handling & Recovery

## Problem

Our error handling is basic. TaaDa has per-message error catching, graceful degradation, and auto-restart mechanisms.

## TaaDa's Error Strategy

| Error | TaaDa Handling |
|-------|---------------|
| IOException (socket) | Log, skip message, continue loop |
| SSLException | Log, skip message, continue loop |
| ArrayIndexOutOfBounds | Log with data length, skip |
| OutOfMemoryError | Stop service, restart in 3s |
| Fatal Throwable | Log FATAL, stop MicActivity, stop service, rethrow |
| WebSocket disconnect | Auto-disable video focus |
| No browser PING (3s) | Auto-disable video focus |
| Keyframe failure | Toggle focus off → 500ms → on |
| Service destroyed | Schedule restart via AlarmManager |
| Billing failure | Fall back to cached subscription |

## Our Current State

- `ChannelMux.readLoop()`: catches IOException (warning) and Exception (error) per frame — good
- `AAHeadUnitEmulator`: catches CancellationException, IOException, and generic Exception
- `TransporterService`: reconnect loop with 2.5s delay, no retry limit — can loop forever
- No per-message error recovery in channel handlers
- No service auto-restart on crash
- No graceful shutdown notification to WebSocket clients
- No keyframe failure fallback

## Changes Required

### Step 1: Add per-message error catching in channel handlers
```kotlin
// In each handler's onFrame():
override suspend fun onFrame(frame: AapFrame) {
    try {
        // ... handle frame
    } catch (e: Exception) {
        Timber.w(e, "Error processing frame on channel $channelId, msgType=${frame.messageType}")
        // Don't rethrow — let the read loop continue
    }
}
```

### Step 2: Add shutdown notification to WebSocket clients
```kotlin
// In TransporterService.stopPipeline():
controlServer?.broadcast("""{"type":"server_shutdown","reason":"service_stopping"}""")
delay(500) // Give clients time to receive
```

### Step 3: Add keyframe failure fallback
```kotlin
// In NalStreamManager.requestKeyFrame():
fun requestKeyFrame() {
    try {
        onSendVideoFocus?.invoke(true, true) // VIDEO_FOCUS_REQUEST
    } catch (e: Exception) {
        Timber.w(e, "Keyframe request failed, toggling focus")
        toggleVideoFocus(false)
        handler.postDelayed({ toggleVideoFocus(true) }, 500)
    }
}
```

### Step 4: Add service auto-restart
```kotlin
// In TransporterService.onDestroy():
if (shouldRestart) {
    val restartIntent = Intent(this, TransporterService::class.java)
    val pendingIntent = PendingIntent.getService(
        this, 0, restartIntent,
        PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE
    )
    val alarmManager = getSystemService(AlarmManager::class.java)
    alarmManager.setExact(
        AlarmManager.ELAPSED_REALTIME_WAKEUP,
        SystemClock.elapsedRealtime() + 3000,
        pendingIntent
    )
}
```

### Step 5: Add reconnect attempt limit
```kotlin
// In TransporterService reconnect loop:
var reconnectAttempt = 0
val MAX_RECONNECTS = 30

while (isActive && reconnectAttempt < MAX_RECONNECTS) {
    reconnectAttempt++
    // ... existing logic
    if (reconnectAttempt >= MAX_RECONNECTS) {
        Timber.e("Max reconnect attempts reached")
        statusText.value = "Connection failed after $MAX_RECONNECTS attempts"
    }
}
```

### Step 6: Add global uncaught exception handler
```kotlin
// In App.onCreate():
val defaultHandler = Thread.getDefaultUncaughtExceptionHandler()
Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
    Timber.e(throwable, "UNCAUGHT EXCEPTION on ${thread.name}")
    // Flush logs to file
    defaultHandler?.uncaughtException(thread, throwable)
}
```

## Files to Modify
- All channel handlers (add try-catch)
- `app/src/main/java/com/supertesla/aa/service/TransporterService.kt`
- `streaming/src/main/java/.../video/NalStreamManager.kt`
- `app/src/main/java/com/supertesla/aa/App.kt` (uncaught handler)

## Test Plan
- [ ] Malformed protobuf message doesn't crash the service
- [ ] WebSocket clients receive shutdown notification
- [ ] After force-kill, service restarts within 5 seconds
- [ ] Reconnect loop stops after MAX_RECONNECTS
- [ ] Keyframe failure triggers fallback focus toggle
- [ ] Status text shows meaningful error messages
