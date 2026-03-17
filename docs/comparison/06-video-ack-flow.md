# 06 — Video ACK & Flow Control

## Problem

Our app never sends video ACKs to AA. TaaDa uses `maxUnacked=1` and requires the browser to send ACK after each frame. Without ACKs, AA may throttle or stop sending video.

## TaaDa Flow
```
AA sends video frame → TaaDa forwards to browser
Browser processes frame → sends {"action":"ACK"} via WebSocket
TaaDa receives ACK → builds Ack protobuf (sessionId, ack=1)
→ sends on channel=3, service=3, messageType=0x8004 → AA
AA sends next frame
```

## Our Current State

- `VideoChannelHandler` receives frames but **never sends ACK**
- `AudioChannelHandler` sends ACK after every frame (correct)
- `ControlSocketServer` logs "ACK" action but doesn't forward it to AA
- Browser `player.js` does NOT send ACK messages

## Changes Required

### Step 1: Track video session ID
```kotlin
// In VideoChannelHandler, on START_INDICATION (0x8001):
private var sessionId: Int = -1

// Parse session ID from Start protobuf field 1
val fields = ProtoEncoder.readFields(frame.messageBody)
sessionId = fields.firstOrNull { it.fieldNumber == 1 }?.value?.toInt() ?: 0
```

### Step 2: Add sendAck method to VideoChannelHandler
```kotlin
fun sendAck() {
    if (sessionId < 0) return
    val ackData = ProtoEncoder.encode {
        writeVarint(1, sessionId.toLong())
        writeVarint(2, 1L) // ack = 1
    }
    scope.launch {
        channelMux.sendEncrypted(ChannelId.VIDEO, 0x8004, ackData)
    }
}
```

### Step 3: Add ACK to browser player.js
After successfully processing each video frame:
```javascript
// In processBinaryFrame(), after successful decode/append:
if (ws && ws.readyState === WebSocket.OPEN) {
    ws.send(JSON.stringify({action: "ACK"}));
}
```

### Step 4: Wire ACK from ControlSocketServer to VideoChannelHandler
```kotlin
// In TransporterService, ControlSocketServer action handler:
"ACK" -> emulator?.videoHandler?.sendAck()
```

### Step 5: Wire ACK from Ktor WebSocket to VideoChannelHandler
```kotlin
// In WebServer /ws incoming message handler:
if (action == "ACK") {
    // Forward to AA protocol
    onAckReceived?.invoke()
}
```

### Step 6: Add ACK to audio channels (verify existing)
Our `AudioChannelHandler` already sends ACK. Verify format matches TaaDa:
```
Ack { field1=sessionId, field2=1 }
messageType = 0x8004
```

## TaaDa's ACK Architecture

| Channel | ACK Source | Timing |
|---------|-----------|--------|
| 3 (Video) | Browser sends ACK → forwarded to AA | After frame processed |
| 5 (Media Audio) | Server sends immediately | After each frame received |
| 6 (System Audio) | Server sends immediately | After each frame received |
| 7 (Guidance Audio) | Server sends immediately | After each frame received |

The asymmetry is important: video ACKs require browser participation (flow control), while audio ACKs are automatic (prevents audio stalls).

## Files to Modify
- `androidauto/src/main/java/.../channels/VideoChannelHandler.kt`
- `app/src/main/java/com/supertesla/aa/service/TransporterService.kt`
- `network/src/main/java/.../relay/ControlSocketServer.kt`
- `network/src/main/java/.../webserver/WebServer.kt`
- `web/src/main/assets/player.js`

## Test Plan
- [ ] Video session ID correctly parsed from START_INDICATION
- [ ] Browser sends ACK after each frame (check Network tab in browser DevTools)
- [ ] ACK received by ControlSocketServer (check Timber logs)
- [ ] ACK forwarded to AA via VideoChannelHandler.sendAck()
- [ ] Video stream is smooth (AA not throttling due to missing ACKs)
- [ ] Compare frame rate with/without ACK implementation
