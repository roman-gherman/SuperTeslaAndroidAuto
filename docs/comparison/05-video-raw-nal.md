# 05 — Video Pipeline: Raw H.264 NAL Passthrough

## Problem

TaaDa sends raw H.264 NAL units directly to the browser via WebSocket. Our app has an fMP4 muxer in the pipeline that adds unnecessary overhead and complexity. However, our browser player.js already supports raw NAL decoding via WebCodecs.

## TaaDa Video Path
```
AA → ProtocolMessage → NalStreamManager.buildNal() → reassemble fragments
→ Strip 10-byte header → raw NAL ByteBuffer
→ ControlSocketServer.send(byteBuffer) → WebSocket binary frame
→ Browser: WebCodecs VideoDecoder (no muxing needed)
```

## Our Video Path
```
AA → VideoChannelHandler → Strip 8-byte timestamp + NAL data
→ SharedFlow<VideoFrame> → WebServer collects
→ VideoStreamHandler.handleClient() → WebSocket binary frame (raw Annex B)
→ Browser: player.js parses NAL units
  → WebCodecs path: raw NAL → VideoDecoder → Canvas
  → MSE path: JS fMP4 muxer → SourceBuffer → <video>
```

## Key Insight

**Our pipeline is actually already close to TaaDa's!** The `VideoStreamHandler` sends raw Annex B H.264 directly. The server-side `FragmentedMp4Muxer.kt` exists but is not in the active video path — it's only used if someone explicitly constructs it. The browser's `player.js` already handles both WebCodecs (raw NAL) and MSE (client-side fMP4 muxing).

## Differences That Matter

| Aspect | TaaDa | Ours |
|--------|-------|------|
| NAL reassembly buffer | 8MB direct ByteBuffer | 8MB direct ByteBuffer (same!) |
| Fragment indicators | 0/1/2/3/127 | 0/1/2/3/127 (same!) |
| Header stripping | DATA: 10 bytes, CONFIG: 2 bytes | DATA: 8 bytes (timestamp), CONFIG: raw |
| Video ACK | Browser sends ACK → forwarded to AA | **No ACK sent** |
| Keyframe throttle | Max once per 2 seconds | **No throttle** |
| SPS/PPS caching | Not explicit | Caches last SPS+PPS + last IDR |
| FPS tracking | Server + client FPS | Server FPS only (5s interval) |

## Changes Required

### Step 1: Verify header stripping matches TaaDa
TaaDa strips 10 bytes from MEDIA_DATA (2 msgType + 8 media header) and 2 bytes from CODEC_CONFIG.
Our `VideoChannelHandler` strips 8 bytes (timestamp) from MEDIA_WITH_TIMESTAMP. Need to verify the 2-byte msgType is already stripped by the framer.

Check: Does our `AapFramer.messageBody` already strip the 2-byte message type? If yes, then our 8-byte strip + framer's 2-byte strip = 10 bytes total, matching TaaDa.

### Step 2: Add codec config NAL start code validation
TaaDa validates codec config starts with `00 00 00 01`:
```kotlin
// In VideoChannelHandler, when handling MEDIA_INDICATION (0x0001):
if (body.size >= 4 && body[0] == 0.toByte() && body[1] == 0.toByte()
    && body[2] == 0.toByte() && body[3] == 1.toByte()) {
    // Valid NAL start code, emit
}
```

### Step 3: Wire video to ControlSocketServer (TaaDa-compatible path)
Currently video goes through Ktor WebServer. TaaDa uses ControlSocketServer (java-websocket). We have both — ensure the ControlSocketServer path works for video:
```kotlin
// In TransporterService wiring:
emulator.videoHandler.videoFrames.collect { frame ->
    controlServer?.sendVideoFrame(frame.data)  // java-websocket path
    webServer?.videoSharedFlow?.tryEmit(frame.data)  // Ktor path
}
```

### Step 4: Remove unused server-side FragmentedMp4Muxer from active pipeline
The `FragmentedMp4Muxer.kt` is not in the active path but keep it for potential future use. Just ensure it's not accidentally instantiated.

## Files to Modify
- `androidauto/src/main/java/.../channels/VideoChannelHandler.kt` (verify header stripping)
- `app/src/main/java/com/supertesla/aa/service/TransporterService.kt` (verify video wiring)

## Test Plan
- [ ] Video appears in Tesla browser when navigating to player URL
- [ ] WebCodecs mode activates (check `SuperTeslaPlayer.getMode()` in browser console)
- [ ] SPS/PPS received and cached (check browser console logs)
- [ ] IDR frame received (check for keyframe in video)
- [ ] No black screen or decoder errors in browser console
- [ ] FPS counter shows reasonable frame rate (25-30fps)
