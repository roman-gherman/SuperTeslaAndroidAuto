# Phase 3: Video Streaming to Browser

## Goal
Stream the H.264 video received from Android Auto to Tesla's Chromium browser in real-time. Implement MSE (MediaSource Extensions) as the primary path and MJPEG as fallback. By the end, Tesla's browser shows the live Android Auto UI.

---

## Prerequisites
- Phase 2 complete (receiving H.264 NAL units from AA)
- Tesla browser reachable at `http://240.3.3.3:8080` (Phase 1 verified)

---

## Architecture

```
H.264 NAL units (from AAHeadUnitEmulator.videoFrames)
       |
       v
  NalUnitParser
  (extract SPS/PPS/IDR/P-frames, track timestamps)
       |
       +---> MSE Path (Primary)
       |     FragmentedMp4Muxer -> fMP4 init segment + media segments
       |     WebSocket binary frames -> Tesla browser MediaSource API
       |
       +---> MJPEG Path (Fallback)
             H264Decoder (MediaCodec) -> Bitmap -> JPEG encode
             Multipart HTTP stream -> Tesla browser <img> tag
```

---

## Tasks

### 3.1 H.264 NAL Unit Parser

**File:** `streaming/src/main/java/com/supertesla/aa/streaming/video/NalUnitParser.kt`

**Purpose:** Parse raw H.264 byte stream into individual NAL units with type classification.

```kotlin
class NalUnitParser {

    enum class NalType(val value: Int) {
        SLICE_NON_IDR(1),    // P-frame
        SLICE_IDR(5),        // I-frame (keyframe)
        SEI(6),              // Supplemental Enhancement Info
        SPS(7),              // Sequence Parameter Set
        PPS(8),              // Picture Parameter Set
        AUD(9),              // Access Unit Delimiter
        UNKNOWN(-1);

        companion object {
            fun fromByte(b: Byte): NalType {
                val type = b.toInt() and 0x1F
                return values().firstOrNull { it.value == type } ?: UNKNOWN
            }
        }
    }

    data class NalUnit(
        val type: NalType,
        val data: ByteArray,          // Full NAL unit with start code
        val dataWithoutStartCode: ByteArray,  // NAL unit without 0x00000001
        val timestamp: Long           // Presentation timestamp in microseconds
    )

    /**
     * Parse Annex B byte stream into NAL units.
     * Looks for 0x00000001 or 0x000001 start codes.
     */
    fun parse(stream: ByteArray): List<NalUnit>

    /**
     * Streaming parser - call with each chunk from AA.
     * Emits complete NAL units via callback.
     */
    fun feed(chunk: ByteArray, onNalUnit: (NalUnit) -> Unit)
}
```

**Steps:**
1. Implement Annex B start code detection (0x00000001 and 0x000001)
2. Implement streaming parser with internal buffer for partial NAL units
3. Classify NAL types from first byte after start code
4. Extract SPS and PPS and cache them (needed for decoder init and fMP4 init segment)
5. Track timestamps (derive from frame count * frame duration if AA doesn't provide PTS)
6. Unit test with sample H.264 streams

**Acceptance criteria:**
- [ ] Correctly splits byte stream into NAL units
- [ ] Identifies SPS, PPS, IDR, and non-IDR frames
- [ ] Handles partial chunks correctly (streaming mode)
- [ ] Handles both 3-byte and 4-byte start codes

---

### 3.2 Fragmented MP4 Muxer

**File:** `streaming/src/main/java/com/supertesla/aa/streaming/video/FragmentedMp4Muxer.kt`

**Purpose:** Package H.264 NAL units into ISO BMFF (MP4) fragments playable via MediaSource Extensions.

**fMP4 structure:**
```
Init Segment (sent once):
  ftyp box: brand=isom, compatible=isom,iso2,avc1,mp41
  moov box:
    mvhd box: timescale=90000, duration=0
    trak box:
      tkhd box: width, height
      mdia box:
        mdhd box: timescale=90000
        hdlr box: type=vide
        minf box:
          vmhd box
          dinf box
          stbl box:
            stsd box:
              avc1 box:
                avcC box: SPS + PPS
            stts box (empty)
            stsc box (empty)
            stsz box (empty)
            stco box (empty)
    mvex box:
      trex box: default sample description

Media Segments (sent per frame or per GOP):
  moof box:
    mfhd box: sequence_number++
    traf box:
      tfhd box: track_id=1
      tfdt box: base_decode_time
      trun box:
        sample_count, data_offset
        per-sample: duration, size, flags, composition_time_offset
  mdat box:
    raw H.264 data (NAL units in AVCC format: length-prefixed, not Annex B)
```

```kotlin
class FragmentedMp4Muxer(
    private val width: Int,
    private val height: Int,
    private val frameRate: Int
) {
    private var sequenceNumber = 1
    private var baseDecodeTime = 0L
    private val timescale = 90000

    /**
     * Generate init segment from SPS/PPS.
     * Must be sent to browser before any media segments.
     */
    fun createInitSegment(sps: ByteArray, pps: ByteArray): ByteArray

    /**
     * Create media segment for one or more frames.
     * NAL units must be in AVCC format (length-prefixed).
     */
    fun createMediaSegment(frames: List<VideoFrame>): ByteArray

    data class VideoFrame(
        val nalUnits: List<ByteArray>,  // AVCC format (no start codes)
        val isKeyframe: Boolean,
        val duration: Int = timescale / frameRate,
        val compositionTimeOffset: Int = 0
    )

    // Convert Annex B NAL unit to AVCC format
    fun annexBToAvcc(annexB: ByteArray): ByteArray
}
```

**Steps:**
1. Implement MP4 box writer utility (type + size + content)
2. Implement `ftyp` box generation
3. Implement `moov` box with `avc1`/`avcC` sample entry (embed SPS/PPS)
4. Implement `moof` + `mdat` segment generation
5. Handle Annex B to AVCC conversion (replace start codes with 4-byte length prefix)
6. Implement `trun` box with per-sample entries
7. Set correct sample flags (IDR = sync sample)
8. Increment sequence numbers and decode timestamps
9. Unit test: generate fMP4, verify playable with ffprobe/browser

**Acceptance criteria:**
- [ ] Init segment is valid ISO BMFF (verifiable with mp4dump/ffprobe)
- [ ] Media segments play correctly when appended to MSE SourceBuffer
- [ ] Keyframe detection works correctly (sync sample flag)
- [ ] Timestamps are monotonically increasing

---

### 3.3 MSE WebSocket Streaming Server

**File:** `network/src/main/java/com/supertesla/aa/network/webserver/VideoStreamHandler.kt`

**Purpose:** Stream fMP4 segments to Tesla browser via WebSocket binary frames.

```kotlin
class VideoStreamHandler(
    private val muxer: FragmentedMp4Muxer,
    private val nalParser: NalUnitParser,
    private val videoFlow: SharedFlow<ByteArray>
) {
    // Track connected clients
    private val clients = ConcurrentHashMap<String, WebSocketSession>()

    suspend fun handleNewClient(session: WebSocketSession) {
        val clientId = UUID.randomUUID().toString()
        clients[clientId] = session

        // Send init segment first
        val initSegment = muxer.createInitSegment(cachedSps!!, cachedPps!!)
        session.send(Frame.Binary(true, initSegment))

        // Then stream media segments
        videoFlow.collect { rawH264 ->
            nalParser.feed(rawH264) { nalUnit ->
                when (nalUnit.type) {
                    NalType.SPS -> cachedSps = nalUnit.dataWithoutStartCode
                    NalType.PPS -> cachedPps = nalUnit.dataWithoutStartCode
                    NalType.SLICE_IDR, NalType.SLICE_NON_IDR -> {
                        val frame = VideoFrame(
                            nalUnits = listOf(muxer.annexBToAvcc(nalUnit.data)),
                            isKeyframe = nalUnit.type == NalType.SLICE_IDR
                        )
                        val segment = muxer.createMediaSegment(listOf(frame))
                        session.send(Frame.Binary(true, segment))
                    }
                }
            }
        }
    }
}
```

**Ktor route integration:**
```kotlin
webSocket("/ws/video") {
    videoStreamHandler.handleNewClient(this)
}
```

**Steps:**
1. Implement client connection management
2. Send init segment to each new client
3. Buffer frames until SPS/PPS are available
4. Stream media segments per-frame or batched per GOP
5. Handle client disconnection gracefully
6. Add backpressure: drop frames if client can't keep up
7. Log streaming statistics (FPS, bandwidth, dropped frames)

**Acceptance criteria:**
- [ ] WebSocket accepts connections
- [ ] Init segment sent on connect
- [ ] Media segments stream continuously
- [ ] Multiple clients supported simultaneously
- [ ] Backpressure prevents OOM on slow clients

---

### 3.4 MJPEG Fallback Stream

**File:** `streaming/src/main/java/com/supertesla/aa/streaming/video/MjpegStreamEncoder.kt`

**Purpose:** Decode H.264 to bitmaps, encode as JPEG, serve as multipart HTTP stream.

```kotlin
class MjpegStreamEncoder(
    private val width: Int,
    private val height: Int,
    private val quality: Int = 80
) {
    private val decoder = MediaCodec.createDecoderByType("video/avc")
    private val imageReader = ImageReader.newInstance(width, height, ImageFormat.YUV_420_888, 3)

    fun start(videoFlow: SharedFlow<ByteArray>): Flow<ByteArray> = flow {
        // Configure decoder to output to ImageReader surface
        decoder.configure(format, imageReader.surface, null, 0)
        decoder.start()

        videoFlow.collect { nalData ->
            // Feed H.264 to decoder
            feedDecoder(nalData)

            // Read decoded frame
            val image = imageReader.acquireLatestImage() ?: return@collect
            val bitmap = imageToBitmap(image)
            image.close()

            // Encode to JPEG
            val jpegData = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, jpegData)
            emit(jpegData.toByteArray())
        }
    }
}
```

**Ktor route:**
```kotlin
get("/stream.mjpeg") {
    call.respondOutputStream(ContentType.parse("multipart/x-mixed-replace; boundary=frame")) {
        mjpegEncoder.start(videoFlow).collect { jpeg ->
            write("--frame\r\n".toByteArray())
            write("Content-Type: image/jpeg\r\n".toByteArray())
            write("Content-Length: ${jpeg.size}\r\n\r\n".toByteArray())
            write(jpeg)
            write("\r\n".toByteArray())
            flush()
        }
    }
}
```

**Steps:**
1. Implement H.264 decoder using MediaCodec + ImageReader
2. Implement YUV to Bitmap conversion
3. Implement JPEG encoding with configurable quality
4. Implement multipart HTTP response streaming
5. Add frame rate limiting (cap at 30fps for MJPEG)
6. Handle decoder errors and recovery

**Acceptance criteria:**
- [ ] MJPEG stream accessible at `/stream.mjpeg`
- [ ] Plays in browser via `<img src="/stream.mjpeg">`
- [ ] Frame rate is stable (~30fps)
- [ ] JPEG quality is acceptable for text readability

---

### 3.5 Web Frontend Video Player

**File:** `web/src/main/assets/player.js`

**Purpose:** Auto-detect browser capabilities and play video using the best available method.

```javascript
class VideoPlayer {
    constructor() {
        this.mode = null;
        this.video = document.getElementById('player');
        this.ws = null;
    }

    async init() {
        // Detect capabilities
        if (this.supportsMediaSource()) {
            this.mode = 'mse';
            await this.initMSE();
        } else {
            this.mode = 'mjpeg';
            this.initMJPEG();
        }
        this.updateStatus(`Playing: ${this.mode} mode`);
    }

    supportsMediaSource() {
        return window.MediaSource &&
            MediaSource.isTypeSupported('video/mp4; codecs="avc1.42E01E"');
    }

    async initMSE() {
        const mediaSource = new MediaSource();
        this.video.src = URL.createObjectURL(mediaSource);

        await new Promise(resolve => {
            mediaSource.addEventListener('sourceopen', resolve, { once: true });
        });

        const sourceBuffer = mediaSource.addSourceBuffer(
            'video/mp4; codecs="avc1.42E01E"'
        );

        // Connect WebSocket for binary fMP4 segments
        this.ws = new WebSocket(`ws://${location.host}/ws/video`);
        this.ws.binaryType = 'arraybuffer';

        const queue = [];
        let appending = false;

        sourceBuffer.addEventListener('updateend', () => {
            appending = false;
            // Remove old buffered data to prevent memory growth
            if (sourceBuffer.buffered.length > 0) {
                const end = sourceBuffer.buffered.end(0);
                const start = sourceBuffer.buffered.start(0);
                if (end - start > 10) {
                    sourceBuffer.remove(start, end - 5);
                    return;
                }
            }
            if (queue.length > 0) {
                appendNext();
            }
        });

        function appendNext() {
            if (queue.length === 0 || appending) return;
            appending = true;
            sourceBuffer.appendBuffer(queue.shift());
        }

        this.ws.onmessage = (event) => {
            queue.push(new Uint8Array(event.data));
            if (!appending) appendNext();
        };

        // Keep playback near live edge
        setInterval(() => {
            if (this.video.buffered.length > 0) {
                const liveEdge = this.video.buffered.end(0);
                if (liveEdge - this.video.currentTime > 1.0) {
                    this.video.currentTime = liveEdge - 0.1;
                }
            }
        }, 1000);
    }

    initMJPEG() {
        // Replace video element with img
        const img = document.createElement('img');
        img.id = 'player';
        img.src = `/stream.mjpeg`;
        img.style.width = '100%';
        img.style.height = '100%';
        img.style.objectFit = 'contain';
        this.video.replaceWith(img);
    }
}
```

**Steps:**
1. Implement capability detection (MSE support, codec support)
2. Implement MSE player with WebSocket binary receiver
3. Implement buffer management (remove old data, prevent QuotaExceededError)
4. Implement live edge tracking (skip to latest frame if behind)
5. Implement MJPEG fallback player
6. Add connection status indicator
7. Add reconnection logic (WebSocket close -> retry after 1s)
8. Style for fullscreen display on Tesla's widescreen

**Acceptance criteria:**
- [ ] Auto-detects MSE support in Tesla browser
- [ ] MSE mode plays smooth video with <200ms latency
- [ ] MJPEG fallback works when MSE is unavailable
- [ ] Buffer doesn't grow unbounded (memory stable)
- [ ] Automatically reconnects on connection loss

---

### 3.6 Web Frontend Layout (Tesla Optimized)

**File:** `web/src/main/assets/index.html` and `web/src/main/assets/style.css`

**Purpose:** Full-screen layout optimized for Tesla's landscape display.

```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
    <title>SuperTesla AA</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        html, body { width: 100%; height: 100%; overflow: hidden; background: #000; }
        #player {
            width: 100%; height: 100%;
            object-fit: contain;
            background: #000;
        }
        #touchpad {
            position: absolute; top: 0; left: 0;
            width: 100%; height: 100%;
            z-index: 10;
            touch-action: none;
        }
        #status {
            position: absolute; top: 8px; right: 8px;
            z-index: 20;
            width: 12px; height: 12px;
            border-radius: 50%;
            background: #f00;
            transition: background 0.3s;
        }
        #status.connected { background: #0f0; }
        #status.buffering { background: #ff0; }
    </style>
</head>
<body>
    <video id="player" autoplay playsinline muted></video>
    <div id="touchpad"></div>
    <div id="status"></div>
    <script src="player.js"></script>
    <script src="touch.js"></script>
    <script src="app.js"></script>
</body>
</html>
```

**Steps:**
1. Create fullscreen black layout
2. Add video element and touch overlay
3. Add status indicator (red/yellow/green dot)
4. Ensure no scrollbars, no zoom, no browser chrome interference
5. Test on Tesla browser dimensions (landscape, ~1920x1080 or variant)

**Acceptance criteria:**
- [ ] Full-screen video with no borders or chrome
- [ ] Status indicator visible but unobtrusive
- [ ] Touch overlay covers entire viewport
- [ ] No scroll, zoom, or unexpected browser behavior

---

## Phase 3 Verification Checklist

1. [ ] NAL unit parser correctly splits H.264 stream
2. [ ] fMP4 init segment is valid (ffprobe verification)
3. [ ] fMP4 media segments play in desktop Chrome MSE test
4. [ ] WebSocket streams fMP4 segments continuously
5. [ ] Tesla browser displays live Android Auto UI via MSE
6. [ ] MJPEG fallback stream works in browser
7. [ ] Video latency is <200ms (MSE) or <300ms (MJPEG)
8. [ ] Memory usage is stable over 30+ minutes
9. [ ] Reconnection works after browser refresh
10. [ ] Multiple streaming modes coexist (can switch)

---

## Estimated Effort
- NAL parser: 1 day
- fMP4 muxer: 3 days (most complex, many MP4 box types)
- MSE WebSocket handler: 1 day
- MJPEG fallback: 1 day
- Web frontend player: 2 days
- Layout & styling: 0.5 day
- Testing & debugging: 2.5 days
- **Total: ~11 days**
