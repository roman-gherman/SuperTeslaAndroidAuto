# Phase 5: Audio Streaming

## Goal
Stream audio from Android Auto to Tesla's browser so that music, navigation voice prompts, and call audio play through Tesla's speakers. Support both in-stream audio (muxed with video in fMP4) and standalone Bluetooth fallback.

---

## Prerequisites
- Phase 3 complete (video streaming via MSE)
- Phase 4 complete (touch input working)
- AA audio channel open and receiving PCM data (Phase 2)

---

## Architecture

```
AA Audio Channel (PCM: 44100Hz, stereo, 16-bit)
       |
       v
  AudioPipeline
       |
       +---> MSE Path: AAC encode (MediaCodec) -> mux into fMP4 -> SourceBuffer
       |
       +---> Standalone Path: Opus encode -> WebSocket binary -> Web Audio API decode
       |
       +---> Bluetooth Fallback: Route to A2DP profile (Tesla pairs separately)
```

---

## Tasks

### 5.1 Audio Channel Handler

**File:** `androidauto/src/main/java/com/supertesla/aa/androidauto/channels/AudioChannelHandler.kt`

**Purpose:** Receive raw PCM audio data from AA audio channel and emit to pipeline.

```kotlin
class AudioChannelHandler : ChannelHandler {

    private val _audioFrames = MutableSharedFlow<AudioFrame>(
        replay = 0,
        extraBufferCapacity = 128
    )
    val audioFrames: SharedFlow<AudioFrame> = _audioFrames

    data class AudioFrame(
        val pcmData: ByteArray,
        val sampleRate: Int = 44100,
        val channels: Int = 2,        // stereo
        val bitDepth: Int = 16,
        val timestamp: Long           // microseconds
    )

    override suspend fun onFrame(frame: AapFrame) {
        // AA sends raw PCM data on audio channel
        // May include a small header (timestamp, stream type)
        val audioData = parseAudioPayload(frame.payload)
        _audioFrames.emit(audioData)
    }

    private fun parseAudioPayload(payload: ByteArray): AudioFrame {
        // AAP audio frame format:
        // - 8 bytes header (timestamp + flags)
        // - Remaining bytes: raw PCM samples (little-endian, interleaved stereo)
        val timestamp = payload.getLong(0)
        val pcm = payload.copyOfRange(8, payload.size)
        return AudioFrame(pcm, timestamp = timestamp)
    }
}
```

**AA audio streams (multiple channels):**
- **Media audio** (music, podcasts): channel for main media output
- **Navigation audio** (turn-by-turn voice): separate channel, may mix
- **Call audio** (phone calls): separate channel

**Steps:**
1. Implement `AudioChannelHandler` for each audio stream type
2. Parse AAP audio frame headers (timestamp, stream ID)
3. Emit PCM frames via SharedFlow
4. Handle audio focus messages (which stream is active)
5. Support multiple simultaneous audio streams (media + nav voice)

**Acceptance criteria:**
- [ ] PCM audio frames received from AA
- [ ] Audio timestamps are monotonically increasing
- [ ] Multiple audio streams distinguished

---

### 5.2 AAC Encoder

**File:** `streaming/src/main/java/com/supertesla/aa/streaming/audio/AacEncoder.kt`

**Purpose:** Encode raw PCM to AAC-LC using hardware MediaCodec for muxing into fMP4.

```kotlin
class AacEncoder(
    private val sampleRate: Int = 44100,
    private val channelCount: Int = 2,
    private val bitRate: Int = 128_000    // 128kbps
) {
    private lateinit var codec: MediaCodec
    private val outputFormat: MediaFormat

    fun start(): Flow<EncodedAudioFrame> = callbackFlow {
        val format = MediaFormat.createAudioFormat(
            MediaFormat.MIMETYPE_AUDIO_AAC,
            sampleRate,
            channelCount
        ).apply {
            setInteger(MediaFormat.KEY_BIT_RATE, bitRate)
            setInteger(MediaFormat.KEY_AAC_PROFILE,
                MediaCodecInfo.CodecProfileLevel.AACObjectLC)
            setInteger(MediaFormat.KEY_MAX_INPUT_SIZE, 16384)
        }

        codec = MediaCodec.createEncoderByType(MediaFormat.MIMETYPE_AUDIO_AAC)
        codec.setCallback(object : MediaCodec.Callback() {
            override fun onInputBufferAvailable(mc: MediaCodec, index: Int) {
                // Feed PCM data from queue
            }

            override fun onOutputBufferAvailable(
                mc: MediaCodec, index: Int, info: MediaCodec.BufferInfo
            ) {
                val buffer = mc.getOutputBuffer(index) ?: return
                val data = ByteArray(info.size)
                buffer.get(data)
                mc.releaseOutputBuffer(index, false)

                trySend(EncodedAudioFrame(
                    data = data,
                    timestamp = info.presentationTimeUs,
                    isConfig = info.flags and MediaCodec.BUFFER_FLAG_CODEC_CONFIG != 0
                ))
            }

            override fun onError(mc: MediaCodec, e: MediaCodec.CodecException) {
                close(e)
            }

            override fun onOutputFormatChanged(mc: MediaCodec, format: MediaFormat) {
                outputFormat = format
            }
        })

        codec.configure(format, null, null, MediaCodec.CONFIGURE_FLAG_ENCODE)
        codec.start()
        awaitClose { codec.stop(); codec.release() }
    }

    fun feedPcm(pcmData: ByteArray, timestamp: Long) {
        // Queue PCM data for encoding
    }

    data class EncodedAudioFrame(
        val data: ByteArray,
        val timestamp: Long,
        val isConfig: Boolean
    )
}
```

**Steps:**
1. Create MediaCodec AAC-LC encoder
2. Configure for 44100Hz stereo at 128kbps
3. Implement async callback-based encoding pipeline
4. Feed PCM frames from `AudioChannelHandler`
5. Emit encoded AAC frames with timestamps
6. Extract AudioSpecificConfig for fMP4 init segment
7. Handle encoder lifecycle (start, stop, release, error recovery)

**Acceptance criteria:**
- [ ] PCM -> AAC encoding works in real-time
- [ ] AAC frames have correct timestamps
- [ ] AudioSpecificConfig available for fMP4 esds box
- [ ] Encoder runs without dropping frames at 44100Hz stereo

---

### 5.3 Audio-Video Muxing in fMP4

**File:** Update `streaming/.../video/FragmentedMp4Muxer.kt`

**Purpose:** Add audio track alongside video in the fMP4 stream.

**Updated init segment structure:**
```
moov:
  trak[0] (video):
    tkhd: track_id=1
    mdia -> stbl -> stsd -> avc1 (H.264)
  trak[1] (audio):
    tkhd: track_id=2
    mdia -> stbl -> stsd -> mp4a:
      esds: AudioSpecificConfig (AAC-LC, 44100Hz, stereo)
  mvex:
    trex[0]: track_id=1
    trex[1]: track_id=2
```

**Updated media segments:**
```
moof:
  mfhd: sequence_number
  traf[0] (video): tfhd, tfdt, trun + video samples
  traf[1] (audio): tfhd, tfdt, trun + audio samples
mdat:
  [video NAL units] [AAC frames]
```

**Steps:**
1. Add audio track to moov box in init segment
2. Create `mp4a` sample entry with `esds` box containing AudioSpecificConfig
3. Generate media segments with both video and audio traf boxes
4. Align audio and video timestamps (common timescale or per-track timescale)
5. Handle segments where only video or only audio is present
6. Test A/V sync with timestamp verification

**Acceptance criteria:**
- [ ] Init segment contains both video and audio tracks
- [ ] Media segments carry interleaved audio and video
- [ ] ffprobe validates the fMP4 structure
- [ ] Audio and video play in sync in browser

---

### 5.4 Browser Audio Playback

**File:** `web/src/main/assets/audio.js`

**Purpose:** Handle audio playback in Tesla's browser.

```javascript
class AudioHandler {
    constructor() {
        this.video = document.getElementById('player');
        this.audioContext = null;
        this.unmuted = false;
    }

    init() {
        // Audio requires user gesture to start in most browsers
        document.addEventListener('pointerdown', () => {
            if (!this.unmuted) {
                this.unmute();
            }
        }, { once: true });
    }

    unmute() {
        // For MSE mode: audio is muxed in the video element
        this.video.muted = false;
        this.video.volume = 1.0;
        this.unmuted = true;

        // Create AudioContext for potential future use
        this.audioContext = new (window.AudioContext || window.webkitAudioContext)();
        if (this.audioContext.state === 'suspended') {
            this.audioContext.resume();
        }

        this.showVolumeControl();
    }

    showVolumeControl() {
        // Add discrete volume slider overlay
        const slider = document.createElement('input');
        slider.type = 'range';
        slider.min = 0;
        slider.max = 100;
        slider.value = 100;
        slider.id = 'volume-slider';
        slider.addEventListener('input', (e) => {
            this.video.volume = e.target.value / 100;
        });
        document.body.appendChild(slider);

        // Auto-hide after 3 seconds
        setTimeout(() => slider.classList.add('hidden'), 3000);
    }
}
```

**Key challenge: Autoplay policy**
- Tesla's browser (like Chrome) blocks unmuted autoplay
- Video starts muted, first touch event unmutes
- This works naturally since user must touch the screen to interact with AA

**Steps:**
1. Start video muted to comply with autoplay policy
2. Unmute on first user interaction (pointerdown)
3. Verify audio plays through Tesla speakers (via browser audio output)
4. Add volume control overlay (auto-hiding)
5. Handle audio focus (nav voice should interrupt music)
6. Test with various audio sources (Spotify, Google Maps voice, phone calls)

**Acceptance criteria:**
- [ ] Audio plays after first touch interaction
- [ ] Music from Spotify/YouTube Music is audible on Tesla speakers
- [ ] Navigation voice prompts are audible
- [ ] Volume control works
- [ ] Audio/video remain in sync over extended playback

---

### 5.5 Audio Focus & Stream Mixing

**File:** `androidauto/src/main/java/com/supertesla/aa/androidauto/channels/AudioFocusManager.kt`

**Purpose:** Handle AA audio focus requests (media vs navigation vs call audio).

```kotlin
class AudioFocusManager {

    enum class AudioStreamType {
        MEDIA,       // Music, podcasts
        NAVIGATION,  // Turn-by-turn voice
        CALL,        // Phone calls
        NOTIFICATION // Alerts
    }

    data class AudioFocusState(
        val activeStreams: Set<AudioStreamType>,
        val primaryStream: AudioStreamType
    )

    fun handleAudioFocusRequest(request: AudioFocusRequest): AudioFocusResponse {
        // When nav voice starts: duck media volume or pause
        // When call starts: pause media, route call audio
        // When notification: brief duck of media
    }
}
```

**Steps:**
1. Handle `AUDIO_FOCUS_REQUEST` AAP messages
2. Respond with appropriate `AUDIO_FOCUS_RESPONSE`
3. Manage stream priority (call > nav > media)
4. Implement ducking (reduce media volume during nav prompts)
5. Support concurrent streams (nav voice over quiet music)

**Acceptance criteria:**
- [ ] Nav voice prompts play over music
- [ ] Music volume ducks during nav prompts
- [ ] Phone calls mute music
- [ ] Focus returns to music after nav prompt ends

---

### 5.6 Bluetooth Audio Fallback

**Purpose:** For MJPEG mode or when browser audio fails, route audio via Bluetooth A2DP.

**Steps:**
1. Detect if browser audio is working (WebSocket heartbeat)
2. If MJPEG mode: instruct user to pair phone Bluetooth to Tesla
3. Route AA audio to default Bluetooth A2DP output
4. Handle A2DP connection/disconnection events
5. Show audio routing status in UI

**Acceptance criteria:**
- [ ] Audio plays via Bluetooth when browser audio unavailable
- [ ] Smooth transition between audio routes
- [ ] User informed of audio routing status

---

## Phase 5 Verification Checklist

1. [ ] Audio PCM data received from AA audio channel
2. [ ] AAC encoding works in real-time without drops
3. [ ] fMP4 init segment contains valid audio track
4. [ ] Audio muxed correctly in media segments
5. [ ] Browser plays audio after first touch
6. [ ] Spotify music audible through Tesla speakers
7. [ ] Google Maps nav voice prompts audible
8. [ ] Audio/video in sync (no drift over 10+ minutes)
9. [ ] Volume control works
10. [ ] Audio focus transitions work (nav over music)
11. [ ] Bluetooth fallback works in MJPEG mode

---

## Estimated Effort
- Audio channel handler: 0.5 day
- AAC encoder: 1 day
- fMP4 audio muxing: 2 days
- Browser audio playback: 1 day
- Audio focus management: 1 day
- Bluetooth fallback: 0.5 day
- A/V sync testing & debugging: 2 days
- **Total: ~8 days**
