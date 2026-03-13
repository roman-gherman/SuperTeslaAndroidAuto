# Phase 6: WebRTC Streaming (Advanced)

## Goal
Implement WebRTC as the lowest-latency streaming mode (<100ms). WebRTC handles video, audio, and data channels natively with built-in congestion control and jitter buffering. This replaces MSE as the preferred streaming path when the Tesla browser supports it.

---

## Prerequisites
- Phase 5 complete (MSE streaming with audio working)
- Tesla browser WebRTC support confirmed (Chromium ~v143 should support it)

---

## Architecture

```
Phone (WebRTC Peer)                     Tesla Browser (WebRTC Peer)
┌─────────────────────┐                ┌─────────────────────┐
│                     │   Signaling    │                     │
│  PeerConnection     │ <-- SDP/ICE -> │  RTCPeerConnection  │
│                     │   via HTTP     │                     │
│  Video Track:       │                │  Video: <video>     │
│   H.264 encoder     │ == RTP/SRTP ==>│   H.264 decoder     │
│   (passthrough)     │                │                     │
│                     │                │  Audio: speakers     │
│  Audio Track:       │ == RTP/SRTP ==>│   Opus decoder      │
│   Opus encoder      │                │                     │
│                     │                │  Data Channel:      │
│  Data Channel:      │ <== SCTP ====  │   Touch events      │
│   Touch input recv  │                │                     │
└─────────────────────┘                └─────────────────────┘
```

---

## Tasks

### 6.1 Google WebRTC SDK Integration

**File:** `network/build.gradle.kts` + new files

**Dependencies:**
```kotlin
// In libs.versions.toml
[versions]
webrtc = "1.0.+"  # Google WebRTC Android SDK

[libraries]
webrtc = { module = "org.webrtc:google-webrtc", version.ref = "webrtc" }
```

**Steps:**
1. Add WebRTC SDK dependency to `:network` module
2. Initialize `PeerConnectionFactory` with hardware encoder support
3. Configure for H.264 hardware encoding preference
4. Create utility class `WebRtcManager` for lifecycle management
5. Handle WebRTC library initialization (EGL context, logging)

```kotlin
class WebRtcManager(private val context: Context) {

    private lateinit var factory: PeerConnectionFactory
    private var peerConnection: PeerConnection? = null

    fun initialize() {
        PeerConnectionFactory.initialize(
            PeerConnectionFactory.InitializationOptions.builder(context)
                .setFieldTrials("WebRTC-H264HighProfile/Enabled/")
                .createInitializationOptions()
        )

        val encoderFactory = DefaultVideoEncoderFactory(
            EglBase.create().eglBaseContext,
            true,  // enableIntelVp8Encoder
            true   // enableH264HighProfile
        )

        val decoderFactory = DefaultVideoDecoderFactory(
            EglBase.create().eglBaseContext
        )

        factory = PeerConnectionFactory.builder()
            .setVideoEncoderFactory(encoderFactory)
            .setVideoDecoderFactory(decoderFactory)
            .createPeerConnectionFactory()
    }

    fun shutdown() {
        peerConnection?.close()
        factory.dispose()
    }
}
```

**Acceptance criteria:**
- [ ] WebRTC SDK initializes without errors
- [ ] PeerConnectionFactory created with H.264 support
- [ ] No crashes on various Android versions (8.0+)

---

### 6.2 Custom Video Source (H.264 Passthrough)

**File:** `network/src/main/java/com/supertesla/aa/network/webrtc/AaVideoSource.kt`

**Purpose:** Feed pre-encoded H.264 NAL units from Android Auto into WebRTC's video track.

**Challenge:** WebRTC normally controls its own encoder. We need to feed pre-encoded H.264 frames. Two approaches:

**Approach A: Custom VideoEncoder (Preferred)**
```kotlin
class PassthroughH264Encoder : VideoEncoder {
    // Pretend to be an H.264 encoder but actually pass through
    // pre-encoded frames from AA

    private var callback: VideoEncoder.Callback? = null
    private val nalQueue = Channel<NalUnit>(Channel.BUFFERED)

    override fun initEncode(settings: VideoEncoder.Settings,
                           callback: VideoEncoder.Callback): VideoCodecStatus {
        this.callback = callback
        return VideoCodecStatus.OK
    }

    override fun encode(frame: VideoFrame,
                       encodeInfo: VideoEncoder.EncodeInfo): VideoCodecStatus {
        // Instead of encoding the frame, dequeue pre-encoded NAL unit
        val nal = nalQueue.tryReceive().getOrNull() ?: return VideoCodecStatus.OK

        val encodedImage = EncodedImage.builder()
            .setBuffer(ByteBuffer.wrap(nal.data))
            .setEncodedWidth(settings.width)
            .setEncodedHeight(settings.height)
            .setCaptureTimeNs(nal.timestamp * 1000)
            .setFrameType(
                if (nal.isKeyframe) EncodedImage.FrameType.VideoFrameKey
                else EncodedImage.FrameType.VideoFrameDelta
            )
            .createEncodedImage()

        callback?.onEncodedFrame(encodedImage, CodecSpecificInfo())
        return VideoCodecStatus.OK
    }

    // Feed NAL units from AA emulator
    fun feedNalUnit(nalUnit: NalUnit) {
        nalQueue.trySend(nalUnit)
    }
}
```

**Approach B: Decode + Re-encode (Fallback)**
If passthrough is too fragile:
1. Decode AA H.264 via MediaCodec to Surface
2. Let WebRTC capture from Surface and re-encode
3. Higher latency and CPU, but more compatible

```kotlin
class SurfaceBridgeVideoSource(
    private val width: Int,
    private val height: Int
) {
    private val surfaceTextureHelper = SurfaceTextureHelper.create(
        "AAVideoSource", EglBase.create().eglBaseContext
    )
    private val videoSource: VideoSource

    // MediaCodec decoder outputs to this surface
    val decoderSurface: Surface get() = Surface(surfaceTextureHelper.surfaceTexture)

    fun startCapture() {
        surfaceTextureHelper.surfaceTexture.setOnFrameAvailableListener {
            // Bridge frame to WebRTC video track
        }
    }
}
```

**Steps:**
1. Implement `PassthroughH264Encoder` (Approach A)
2. Register as custom encoder in `VideoEncoderFactory`
3. Test if Tesla browser decodes the passthrough H.264
4. If Approach A fails, implement Approach B (decode + re-encode)
5. Handle SPS/PPS configuration (send as codec config)
6. Handle keyframe requests from WebRTC (request IDR from AA)

**Acceptance criteria:**
- [ ] Pre-encoded H.264 frames delivered via WebRTC
- [ ] Tesla browser decodes and displays video
- [ ] Keyframe requests handled (no green artifacts)

---

### 6.3 Audio Track

**File:** `network/src/main/java/com/supertesla/aa/network/webrtc/AaAudioSource.kt`

**Purpose:** Feed PCM audio from AA into WebRTC audio track (encoded as Opus by WebRTC).

```kotlin
class AaAudioSource(
    private val sampleRate: Int = 44100,
    private val channelCount: Int = 2
) {
    private lateinit var audioTrack: AudioTrack
    private lateinit var audioSource: AudioSource

    fun createTrack(factory: PeerConnectionFactory): AudioTrack {
        val constraints = MediaConstraints().apply {
            mandatory.add(MediaConstraints.KeyValuePair("googAutoGainControl", "false"))
            mandatory.add(MediaConstraints.KeyValuePair("googNoiseSuppression", "false"))
            mandatory.add(MediaConstraints.KeyValuePair("googHighpassFilter", "false"))
        }

        audioSource = factory.createAudioSource(constraints)
        audioTrack = factory.createAudioTrack("aa-audio", audioSource)
        return audioTrack
    }

    // Feed PCM data from AA audio channel
    // WebRTC will encode to Opus internally
    fun feedPcm(pcmData: ByteArray) {
        // Use JavaAudioDeviceModule custom audio input
        // to inject PCM samples into WebRTC
    }
}
```

**Alternative: Custom AudioDeviceModule**
```kotlin
class AaAudioDeviceModule : AudioDeviceModule {
    // Override audio input to read from AA PCM stream
    // instead of microphone
    // Override audio output to play received audio
    // (for bidirectional call audio)
}
```

**Steps:**
1. Create custom `AudioDeviceModule` or use `JavaAudioDeviceModule` with custom input
2. Feed AA PCM audio into WebRTC's audio pipeline
3. WebRTC encodes to Opus and transmits via SRTP
4. Disable audio processing (AGC, noise suppression) since AA audio is already processed
5. Handle sample rate conversion if needed (AA: 44100Hz, Opus: 48000Hz)
6. Test audio quality and latency

**Acceptance criteria:**
- [ ] Audio plays through WebRTC in Tesla browser
- [ ] No audio processing artifacts (echo, gain changes)
- [ ] Audio latency <100ms
- [ ] Audio/video in sync

---

### 6.4 WebRTC Signaling Server

**File:** `network/src/main/java/com/supertesla/aa/network/webrtc/SignalingHandler.kt`

**Purpose:** HTTP-based signaling for SDP offer/answer and ICE candidate exchange.

```kotlin
class SignalingHandler(
    private val webRtcManager: WebRtcManager
) {
    // POST /webrtc/offer
    suspend fun handleOffer(call: ApplicationCall) {
        val offerSdp = call.receive<SdpMessage>()

        // Set remote description (browser's offer)
        webRtcManager.setRemoteDescription(
            SessionDescription(SessionDescription.Type.OFFER, offerSdp.sdp)
        )

        // Create answer
        val answer = webRtcManager.createAnswer()

        // Return answer SDP
        call.respond(SdpMessage(
            type = "answer",
            sdp = answer.description
        ))
    }

    // POST /webrtc/ice
    suspend fun handleIceCandidate(call: ApplicationCall) {
        val candidate = call.receive<IceCandidateMessage>()
        webRtcManager.addIceCandidate(
            IceCandidate(candidate.sdpMid, candidate.sdpMLineIndex, candidate.candidate)
        )
        call.respond(HttpStatusCode.OK)
    }

    // GET /webrtc/ice (server's ICE candidates)
    suspend fun getIceCandidates(call: ApplicationCall) {
        call.respond(webRtcManager.getLocalIceCandidates())
    }

    @Serializable
    data class SdpMessage(val type: String, val sdp: String)

    @Serializable
    data class IceCandidateMessage(
        val candidate: String,
        val sdpMid: String,
        val sdpMLineIndex: Int
    )
}
```

**Ktor routes:**
```kotlin
route("/webrtc") {
    post("/offer") { signalingHandler.handleOffer(call) }
    post("/ice") { signalingHandler.handleIceCandidate(call) }
    get("/ice") { signalingHandler.getIceCandidates(call) }
}
```

**Steps:**
1. Implement SDP offer/answer exchange via HTTP POST
2. Implement ICE candidate exchange
3. Configure ICE servers (none needed for local network, but add STUN as fallback)
4. Handle renegotiation (if resolution changes)
5. Add timeout handling for signaling

**Acceptance criteria:**
- [ ] SDP exchange completes successfully
- [ ] ICE connection established over local WiFi
- [ ] No STUN/TURN needed on local hotspot network

---

### 6.5 Data Channel for Touch Events

**Purpose:** Replace WebSocket touch events with WebRTC DataChannel for lower latency.

```kotlin
// Server side
val dataChannel = peerConnection.createDataChannel("touch",
    DataChannel.Init().apply {
        ordered = true
        maxRetransmitTimeMs = 100
    }
)

dataChannel.registerObserver(object : DataChannel.Observer {
    override fun onMessage(buffer: DataChannel.Buffer) {
        val json = String(buffer.data.array())
        touchInputRelay.handleWebSocketMessage(json)
    }
    // ...
})
```

```javascript
// Browser side
const dc = peerConnection.createDataChannel('touch', {
    ordered: true,
    maxRetransmitTimeMs: 100
});

dc.onopen = () => {
    touchHandler.setTransport(dc);  // Switch from WebSocket to DataChannel
};
```

**Steps:**
1. Create DataChannel named "touch" in PeerConnection setup
2. Use same JSON format as WebSocket touch events
3. Update browser touch handler to prefer DataChannel over WebSocket
4. Fall back to WebSocket if DataChannel not available
5. Measure latency improvement vs WebSocket

**Acceptance criteria:**
- [ ] Touch events flow through DataChannel
- [ ] Latency lower than WebSocket path
- [ ] Fallback to WebSocket works

---

### 6.6 Browser WebRTC Client

**File:** Update `web/src/main/assets/player.js`

```javascript
class WebRtcPlayer {
    constructor() {
        this.pc = null;
        this.dataChannel = null;
    }

    async connect() {
        this.pc = new RTCPeerConnection({
            iceServers: [] // Local network, no STUN needed
        });

        // Handle incoming tracks
        this.pc.ontrack = (event) => {
            const video = document.getElementById('player');
            video.srcObject = event.streams[0];
            video.play();
        };

        // Handle data channel
        this.pc.ondatachannel = (event) => {
            this.dataChannel = event.channel;
            this.dataChannel.onopen = () => {
                console.log('DataChannel open');
                touchHandler.setTransport(this.dataChannel);
            };
        };

        // Create offer
        const offer = await this.pc.createOffer({
            offerToReceiveVideo: true,
            offerToReceiveAudio: true
        });
        await this.pc.setLocalDescription(offer);

        // Wait for ICE gathering
        await this.waitForIceGathering();

        // Send offer to server
        const response = await fetch('/webrtc/offer', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                type: 'offer',
                sdp: this.pc.localDescription.sdp
            })
        });

        const answer = await response.json();
        await this.pc.setRemoteDescription(
            new RTCSessionDescription(answer)
        );
    }

    async waitForIceGathering() {
        return new Promise(resolve => {
            if (this.pc.iceGatheringState === 'complete') {
                resolve();
            } else {
                this.pc.addEventListener('icegatheringstatechange', () => {
                    if (this.pc.iceGatheringState === 'complete') resolve();
                });
            }
            // Timeout fallback
            setTimeout(resolve, 3000);
        });
    }
}
```

**Updated capability detection in player.js:**
```javascript
async init() {
    if (window.RTCPeerConnection) {
        try {
            await this.webrtcPlayer.connect();
            this.mode = 'webrtc';
            return;
        } catch (e) {
            console.warn('WebRTC failed, falling back to MSE:', e);
        }
    }
    if (this.supportsMediaSource()) {
        this.mode = 'mse';
        await this.initMSE();
    } else {
        this.mode = 'mjpeg';
        this.initMJPEG();
    }
}
```

**Steps:**
1. Implement WebRTC client in browser
2. Create offer, exchange SDP with server
3. Handle ICE candidates
4. Attach incoming media stream to video element
5. Set up DataChannel for touch events
6. Add fallback chain: WebRTC -> MSE -> MJPEG
7. Handle WebRTC connection failures gracefully

**Acceptance criteria:**
- [ ] WebRTC connection establishes on Tesla browser
- [ ] Video plays with <100ms latency
- [ ] Audio plays through WebRTC
- [ ] DataChannel carries touch events
- [ ] Fallback to MSE works when WebRTC fails

---

## Phase 6 Verification Checklist

1. [ ] WebRTC SDK initializes on Android 8.0+
2. [ ] H.264 passthrough works (or decode+re-encode fallback)
3. [ ] Audio feeds into WebRTC without artifacts
4. [ ] Signaling exchange completes over HTTP
5. [ ] ICE connection established on local hotspot network
6. [ ] Video latency <100ms (measure with visual timestamp)
7. [ ] Audio latency <100ms
8. [ ] Audio/video in sync
9. [ ] DataChannel carries touch events
10. [ ] Fallback to MSE works seamlessly
11. [ ] WebRTC reconnects after brief disconnection
12. [ ] No memory leaks over extended session

---

## Estimated Effort
- WebRTC SDK integration: 1 day
- H.264 passthrough encoder: 3 days (complex, may need fallback approach)
- Audio source: 2 days
- Signaling server: 1 day
- DataChannel: 0.5 day
- Browser WebRTC client: 1.5 days
- Testing & latency optimization: 3 days
- **Total: ~12 days**
