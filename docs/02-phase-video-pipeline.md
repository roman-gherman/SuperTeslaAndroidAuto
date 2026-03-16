
# Phase 2: Video Pipeline (AA → NAL → WebSocket)

## Overview

Once the AA protocol handshake is complete (Phase 1), Android Auto starts sending H.264 video frames through the protocol. TaaDa processes these NAL units and relays them directly to the Tesla browser via WebSocket. **No screen capture (MediaProjection) is needed** — AA provides the video.

## What TaaDa Does (Exact Implementation)

### 1. Video Channel Setup

When AA opens Channel 2 (Video), TaaDa responds with capabilities:
```
Service Discovery Response includes:
  Video: 1280x720, 160dpi, 30fps
  Codec: H.264
  Channel: 2
```

After channel open, AA sends:
- `SETUP_REQUEST` → TaaDa responds with media setup
- `START_INDICATION` → Streaming begins
- `MEDIA_WITH_TIMESTAMP` (0x0000) → H.264 frames with 8-byte timestamp
- `MEDIA_INDICATION` (0x0001) → Raw H.264 data

### 2. NalStreamManager (Core Video Processor)

TaaDa has a dedicated `NalStreamManager` that processes H.264 NAL units received from AA:

```java
// Static 8MB buffer for NAL unit assembly
static ByteBuffer nalBuffer = ByteBuffer.allocateDirect(8_388_608);

// Main entry point
void buildNal(byte indicator, byte[] data, int length, MediaMessageId msgId) {
    switch (indicator) {
        case 0:  // Continuation fragment
            nalBuffer.put(data, offset, len);
            break;

        case 1:  // Start of new frame
            nalBuffer.clear();
            if (msgId == MEDIA_MESSAGE_DATA) {
                nalBuffer.put(data, 10, length - 10);  // skip 10-byte header
            } else if (msgId == MEDIA_MESSAGE_CODEC_CONFIG) {
                nalBuffer.put(data, 2, length - 2);    // skip 2-byte header
            }
            break;

        case 2:  // End of frame — append then process
            nalBuffer.put(data, offset, len);
            nalBuffer.flip();
            process(nalBuffer);
            break;

        case 3:  // Complete frame in single message
            if (msgId == MEDIA_MESSAGE_DATA) {
                process(ByteBuffer.wrap(data, 10, length - 10));
            } else if (msgId == MEDIA_MESSAGE_CODEC_CONFIG) {
                process(ByteBuffer.wrap(data, 2, length - 2));
            }
            break;

        case 127:  // Direct process
            process(nalBuffer);
            break;
    }
}
```

### 3. Frame Processing & Relay

```java
void process(ByteBuffer frameData) {
    // Send directly to WebSocket as binary frame
    controlSocketServer.sendVideoFrame(frameData);

    // Track FPS
    serverFpsTracker.onFrame();

    // First frame telemetry
    if (!firstFrameReceived) {
        firstFrameReceived = true;
        logEvent(FIRST_FRAME_RECEIVED);
        logEvent(STREAM_STARTED);
    }
}
```

### 4. Video Focus Management

TaaDa controls when AA sends video via `VideoFocusNotification`:

```java
void toggleVideoFocus(boolean focused) {
    VideoFocusNotification.Builder builder = VideoFocusNotification.newBuilder();
    if (focused) {
        builder.setMode(VIDEO_FOCUS_PROJECTED);  // "send me video"
        builder.setUnsolicited(false);
    } else {
        builder.setMode(VIDEO_FOCUS_NATIVE);     // "stop sending video"
        builder.setUnsolicited(false);
    }
    // Send on channel 0 (control), message type 0x800F (32783)
    sendMessage(0x00, 0x03, 32783, builder.build());
}
```

### 5. Keyframe Requests

```java
void requestKeyFrame() {
    // Debounce: min 2000ms between requests
    if (System.currentTimeMillis() - lastKeyframeRequest < 2000) return;
    lastKeyframeRequest = System.currentTimeMillis();

    VideoFocusNotification.Builder builder = VideoFocusNotification.newBuilder();
    builder.setMode(VIDEO_FOCUS_PROJECTED);
    builder.setUnsolicited(true);  // unsolicited = keyframe request
    sendMessage(0x00, 0x03, 32783, builder.build());
}
```

### 6. Resolution / UI Config

```java
void adjustResolution(int width, int height) {
    UpdateUiConfigRequest.Builder builder = UpdateUiConfigRequest.newBuilder();
    // Set insets/margins based on resolution
    Insets.Builder insets = Insets.newBuilder();
    insets.setLeft(0).setTop(0).setRight(0).setBottom(0);
    builder.setInsets(insets);
    sendMessage(0x00, 0x03, 32777, builder.build());

    // Persist for next session
    prefs.putInt("video_width", width);
    prefs.putInt("video_height", height);
}
```

## What We Already Have

| Component | File | Status |
|-----------|------|--------|
| Video channel handler | `VideoChannelHandler.kt` | Complete — emits `VideoFrame` via SharedFlow |
| NAL unit parser | `streaming/video/NalUnitParser.kt` | Complete — parses NAL types |
| fMP4 muxer | `streaming/video/FragmentedMp4Muxer.kt` | Complete — wraps H.264 in fMP4 |
| Video stream handler | `network/webserver/VideoStreamHandler.kt` | Complete — sends fMP4 via WebSocket |
| Service discovery | `androidauto/proto/ServiceDiscovery.kt` | Complete — advertises video capabilities |

## What Needs to Change

### 1. Create NalStreamManager

New class that sits between `VideoChannelHandler` and the WebSocket servers:

```kotlin
class NalStreamManager(
    private val controlSocketServer: ControlSocketServer
) {
    // 8MB direct buffer for NAL assembly (matches TaaDa)
    private val nalBuffer = ByteBuffer.allocateDirect(8_388_608)
    private var firstFrameReceived = false
    private var lastKeyframeRequestTime = 0L

    // FPS tracking
    private var frameCount = 0
    private var lastFpsLogTime = System.currentTimeMillis()

    fun buildNal(indicator: Byte, data: ByteArray, length: Int, isCodecConfig: Boolean) {
        when (indicator.toInt()) {
            0 -> { /* continuation: append to buffer */ }
            1 -> { /* start: clear buffer, put with offset */ }
            2 -> { /* end: append, flip, process */ }
            3 -> { /* complete: wrap and process directly */ }
            127 -> { /* direct process */ }
        }
    }

    private fun process(frame: ByteBuffer) {
        controlSocketServer.sendVideoFrame(frame)
        trackFps()
    }
}
```

### 2. Wire VideoChannelHandler → NalStreamManager

Currently `VideoChannelHandler` emits frames via `SharedFlow<VideoFrame>`. We need to collect these and feed them to `NalStreamManager`:

```kotlin
// In TransporterService
emulator.videoHandler.videoFrames.collect { frame ->
    nalStreamManager.buildNal(
        indicator = frame.indicator,
        data = frame.data,
        length = frame.data.size,
        isCodecConfig = frame.isCodecConfig
    )
}
```

**Note:** We may need to modify `VideoChannelHandler` to expose the raw indicator byte and codec config flag, not just the processed data.

### 3. Video Focus Integration

Wire the WebSocket server's START/STOP commands to video focus:

```kotlin
// When browser sends "START" via WebSocket
nalStreamManager.toggleVideoFocus(true)

// When browser sends "STOP" or disconnects
nalStreamManager.toggleVideoFocus(false)

// When browser sends "REQUEST_KEYFRAME"
nalStreamManager.requestKeyFrame()
```

### 4. Update VideoChannelHandler to Expose Raw Frame Data

Currently the handler extracts the H.264 payload. For NalStreamManager, we need:
- The **indicator byte** (fragmentation: 0=continue, 1=start, 2=end, 3=complete)
- The **raw payload** (with headers, so NalStreamManager can apply correct offsets)
- Whether it's a **codec config** (SPS/PPS) or **media data**

```kotlin
data class RawVideoFrame(
    val indicator: Byte,
    val data: ByteArray,
    val messageId: MediaMessageId,  // DATA or CODEC_CONFIG
    val timestamp: Long
)
```

### 5. Remove/Bypass MediaProjection Path

For the AA relay mode, we don't need MediaProjection. The video comes from AA itself. We should:
- Keep MediaProjection code for a potential "screen mirror" fallback mode
- Add a mode toggle: `AA_RELAY` vs `SCREEN_MIRROR`
- In `AA_RELAY` mode, skip ScreenCaptureManager entirely

### 6. Browser Player Compatibility

TaaDa sends **raw H.264 NAL units** as binary WebSocket frames. Our current browser player expects **fMP4 segments** (FragmentedMp4Muxer).

Options:
1. **Keep fMP4 muxing** — wrap AA's NAL units in fMP4 before sending to browser (MSE compatible)
2. **Send raw NALs** — requires browser-side H.264 decoder (e.g., Broadway.js or WASM decoder)
3. **Use WebCodecs API** — modern browsers can decode raw H.264 via WebCodecs

**Recommendation:** Keep our fMP4 path. It works with MSE in Tesla's browser. Wire NalStreamManager to output through `FragmentedMp4Muxer` → `VideoStreamHandler` → WebSocket.

## Implementation Tasks

1. [ ] Create `NalStreamManager.kt` in the `streaming/` module
2. [ ] Modify `VideoChannelHandler` to expose raw indicator + messageId
3. [ ] Wire `VideoChannelHandler.videoFrames` → `NalStreamManager` in TransporterService
4. [ ] Implement video focus toggle (PROJECTED/NATIVE) sending via AA protocol
5. [ ] Implement keyframe request with 2000ms debounce
6. [ ] Wire NalStreamManager output → `FragmentedMp4Muxer` → `VideoStreamHandler`
7. [ ] Add video resolution negotiation in Service Discovery response
8. [ ] Add FPS tracking and logging
9. [ ] Add first-frame detection logging
10. [ ] Test: AA sends video → frames appear in WebSocket

## Data Flow

```
Android Auto (Gearhead)
  │ H.264 frames via AA Protocol (encrypted)
  ▼
ChannelMux (decrypt + demux)
  │ Channel 2 frames
  ▼
VideoChannelHandler
  │ Parses MEDIA_WITH_TIMESTAMP / MEDIA_INDICATION
  │ Emits RawVideoFrame via SharedFlow
  ▼
NalStreamManager
  │ Reassembles fragmented NAL units
  │ 8MB direct ByteBuffer
  ▼
FragmentedMp4Muxer
  │ Wraps H.264 in fMP4 segments
  │ Init segment (SPS/PPS) + media segments
  ▼
VideoStreamHandler / ControlSocketServer
  │ Binary WebSocket frames
  ▼
Tesla Browser (MSE player)
```

## Key Constants

```kotlin
const val NAL_BUFFER_SIZE = 8_388_608       // 8MB direct buffer
const val KEYFRAME_DEBOUNCE_MS = 2000L
const val VIDEO_FOCUS_PROJECTED = 1         // "send me video"
const val VIDEO_FOCUS_NATIVE = 2            // "stop video"
const val MSG_VIDEO_FOCUS = 32783           // 0x800F
const val MSG_UPDATE_UI_CONFIG = 32777      // 0x8005
const val MSG_KEYFRAME_REQUEST = 32775      // 0x8007
```

## Open Questions

1. **Frame format from AA**: Are frames always complete NAL units, or can they be fragmented across multiple AA messages? TaaDa's indicator byte system suggests fragmentation is common.
2. **SPS/PPS handling**: Does AA send codec config (SPS/PPS) once at start, or periodically? Our fMP4 muxer needs these for the init segment.
3. **Resolution**: Can we request different resolutions from AA? TaaDa uses 1280x720 — is this the max Tesla browser can handle efficiently?
