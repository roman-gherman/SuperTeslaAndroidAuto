# Phase 2: Android Auto Protocol

## Goal
Implement the Android Auto Protocol (AAP) client that acts as a head unit emulator. Connect to the AA Head Unit Server on `localhost:5277`, perform TLS handshake, negotiate capabilities, and receive H.264 video frames. Validate by decoding and displaying the AA UI on the phone screen.

---

## Prerequisites
- Phase 1 complete (VPN + server + hotspot working)
- Android Auto app installed on the phone
- Developer mode enabled in Android Auto app (tap version 10 times in settings)
- "Start head unit server" enabled in AA developer settings

---

## Background: Android Auto Protocol (AAP)

AAP is a proprietary protocol reverse-engineered by the community. Key characteristics:
- **Transport:** TCP on `localhost:5277` (head unit server mode)
- **Encryption:** TLS 1.2+ wrapping all channel data
- **Serialization:** Protocol Buffers for structured messages
- **Multiplexing:** Multiple logical channels over single TCP connection
- **Channels:** Video (0), Audio (1-3), Input (4), Sensor (5), Media (6+)

### Message Frame Format
```
┌─────────────┬──────────────┬───────────────┬─────────────┐
│ Channel (1B) │ Flags (1B)   │ Length (2B BE) │ Payload     │
└─────────────┴──────────────┴───────────────┴─────────────┘
```
- Channel: logical channel ID (0-255)
- Flags: 0x01 = first frame, 0x02 = last frame, 0x04 = encrypted
- Length: big-endian uint16 payload length
- Payload: protobuf message or raw media data

---

## Tasks

### 2.1 Protobuf Message Definitions

**Directory:** `androidauto/src/main/proto/`

Define `.proto` files for AAP messages based on community research:

**`aap_common.proto`:**
```protobuf
syntax = "proto2";
package aap;

message MessageHeader {
    required uint32 message_type = 1;
}

enum MessageType {
    VERSION_REQUEST = 1;
    VERSION_RESPONSE = 2;
    SSL_HANDSHAKE = 3;
    AUTH_COMPLETE = 4;
    SERVICE_DISCOVERY_REQUEST = 5;
    SERVICE_DISCOVERY_RESPONSE = 6;
    CHANNEL_OPEN_REQUEST = 7;
    CHANNEL_OPEN_RESPONSE = 8;
    PING_REQUEST = 9;
    PING_RESPONSE = 10;
    NAV_FOCUS_REQUEST = 13;
    NAV_FOCUS_RESPONSE = 14;
    BYEBYE_REQUEST = 15;
    BYEBYE_RESPONSE = 16;
    VOICE_SESSION_REQUEST = 17;
    AUDIO_FOCUS_REQUEST = 18;
    AUDIO_FOCUS_RESPONSE = 19;
}
```

**`aap_media.proto`:**
```protobuf
message VideoConfig {
    required uint32 width = 1;
    required uint32 height = 2;
    required uint32 density = 3;
    optional uint32 framerate = 4;
    optional uint32 codec = 5;   // 1 = H264
}

message AudioConfig {
    required uint32 sample_rate = 1;
    required uint32 channels = 2;
    required uint32 bit_depth = 3;
    optional uint32 codec = 4;   // 1 = PCM
}

message InputEvent {
    required uint32 timestamp = 1;
    repeated TouchEvent touch = 2;
}

message TouchEvent {
    required uint32 action = 1;   // 0=DOWN, 1=UP, 2=MOVE
    required uint32 x = 2;
    required uint32 y = 3;
    optional uint32 pointer_id = 4;
}
```

**`aap_service.proto`:**
```protobuf
message ServiceDiscoveryRequest {}

message ServiceDiscoveryResponse {
    repeated Service services = 1;
}

message Service {
    required uint32 id = 1;
    optional VideoConfig video_config = 2;
    optional AudioConfig audio_config = 3;
    optional InputConfig input_config = 4;
    optional SensorConfig sensor_config = 5;
}

message ChannelOpenRequest {
    required uint32 service_id = 1;
    optional VideoConfig video_config = 2;
    optional AudioConfig audio_config = 3;
}

message ChannelOpenResponse {
    required uint32 status = 1;    // 0 = OK
    required uint32 channel_id = 2;
}
```

**Steps:**
1. Create `.proto` files based on reverse-engineered AAP definitions
2. Configure protobuf Gradle plugin in `:androidauto` module
3. Generate Kotlin protobuf classes
4. Write unit tests verifying serialization/deserialization round-trips

**Acceptance criteria:**
- [ ] Protobuf classes generate without errors
- [ ] Round-trip serialization tests pass for all message types

---

### 2.2 AAP Message Framing

**File:** `androidauto/src/main/java/com/supertesla/aa/androidauto/protocol/AapFramer.kt`

**Purpose:** Read/write AAP frames from/to a byte stream.

```kotlin
class AapFramer {

    data class AapFrame(
        val channel: Int,
        val flags: Int,
        val payload: ByteArray
    ) {
        val isFirst: Boolean get() = flags and 0x01 != 0
        val isLast: Boolean get() = flags and 0x02 != 0
        val isEncrypted: Boolean get() = flags and 0x04 != 0
    }

    fun readFrame(input: InputStream): AapFrame {
        val channel = input.read()
        val flags = input.read()
        val lenHi = input.read()
        val lenLo = input.read()
        val length = (lenHi shl 8) or lenLo
        val payload = ByteArray(length)
        input.readFully(payload)
        return AapFrame(channel, flags, payload)
    }

    fun writeFrame(output: OutputStream, frame: AapFrame) {
        output.write(frame.channel)
        output.write(frame.flags)
        output.write(frame.payload.size shr 8)
        output.write(frame.payload.size and 0xFF)
        output.write(frame.payload)
        output.flush()
    }
}
```

**Steps:**
1. Implement frame reader with proper error handling (EOF, malformed frames)
2. Implement frame writer
3. Handle frame reassembly (multi-frame messages using first/last flags)
4. Add frame size validation (max 16KB per frame)
5. Unit test with captured AAP traffic samples

**Acceptance criteria:**
- [ ] Can parse known-good AAP frame byte sequences
- [ ] Can write frames that match expected byte format
- [ ] Multi-frame reassembly works correctly

---

### 2.3 TLS Handshake Layer

**File:** `androidauto/src/main/java/com/supertesla/aa/androidauto/protocol/AapCrypto.kt`

**Purpose:** Establish TLS session with the AA head unit server.

**AAP TLS flow:**
1. Connect to `localhost:5277` via plain TCP
2. Exchange version request/response (unencrypted)
3. Client sends SSL_HANDSHAKE message containing TLS ClientHello
4. Server responds with SSL_HANDSHAKE containing ServerHello + certs
5. Complete TLS handshake via SSL_HANDSHAKE message exchange
6. All subsequent channel data is TLS-encrypted

```kotlin
class AapCrypto {

    private lateinit var sslEngine: SSLEngine

    fun initTls(): SSLEngine {
        val sslContext = SSLContext.getInstance("TLSv1.2")
        // Use a trust-all trust manager (AA server uses self-signed cert)
        val trustManagers = arrayOf(TrustAllManager())
        sslContext.init(null, trustManagers, SecureRandom())
        sslEngine = sslContext.createSSLEngine()
        sslEngine.useClientMode = true
        return sslEngine
    }

    // Wrap plaintext -> TLS record
    fun encrypt(plaintext: ByteArray): ByteArray {
        val outBuf = ByteBuffer.allocate(sslEngine.session.packetBufferSize)
        val result = sslEngine.wrap(ByteBuffer.wrap(plaintext), outBuf)
        outBuf.flip()
        return ByteArray(outBuf.remaining()).also { outBuf.get(it) }
    }

    // Unwrap TLS record -> plaintext
    fun decrypt(ciphertext: ByteArray): ByteArray {
        val outBuf = ByteBuffer.allocate(sslEngine.session.applicationBufferSize)
        val result = sslEngine.unwrap(ByteBuffer.wrap(ciphertext), outBuf)
        outBuf.flip()
        return ByteArray(outBuf.remaining()).also { outBuf.get(it) }
    }
}
```

**Key decisions:**
- Use Java `SSLEngine` (non-blocking API) for manual TLS within AAP framing
- Trust all certificates (AA server is local, uses self-signed)
- TLS handshake messages are exchanged inside AAP frames on channel 0

**Steps:**
1. Implement `SSLEngine`-based TLS with trust-all configuration
2. Implement handshake message exchange loop (wrap/unwrap until FINISHED)
3. Handle TLS records within AAP SSL_HANDSHAKE messages
4. Implement encrypt/decrypt for post-handshake data
5. Handle SSLEngine buffer management (BUFFER_UNDERFLOW, BUFFER_OVERFLOW)
6. Unit test with mock TLS server

**Acceptance criteria:**
- [ ] TLS handshake completes against a test server
- [ ] Can encrypt/decrypt messages after handshake
- [ ] Handles SSLEngine edge cases (buffer states)

---

### 2.4 Channel Multiplexer

**File:** `androidauto/src/main/java/com/supertesla/aa/androidauto/protocol/ChannelMux.kt`

**Purpose:** Demux incoming AAP frames to appropriate channel handlers, mux outgoing messages to the transport.

```kotlin
class ChannelMux(
    private val framer: AapFramer,
    private val crypto: AapCrypto,
    private val input: InputStream,
    private val output: OutputStream
) {
    private val channelHandlers = mutableMapOf<Int, ChannelHandler>()

    fun registerHandler(channelId: Int, handler: ChannelHandler) {
        channelHandlers[channelId] = handler
    }

    // Read loop (runs on IO dispatcher)
    suspend fun readLoop() {
        while (isActive) {
            val frame = framer.readFrame(input)
            val decrypted = if (frame.isEncrypted) {
                frame.copy(payload = crypto.decrypt(frame.payload))
            } else frame

            channelHandlers[decrypted.channel]?.onFrame(decrypted)
        }
    }

    // Send a frame (thread-safe via mutex)
    suspend fun send(channelId: Int, payload: ByteArray, encrypt: Boolean = true) {
        val data = if (encrypt) crypto.encrypt(payload) else payload
        val frame = AapFrame(channelId, flags = 0x07, payload = data)
        mutex.withLock { framer.writeFrame(output, frame) }
    }
}

interface ChannelHandler {
    suspend fun onFrame(frame: AapFrame)
}
```

**Steps:**
1. Implement `ChannelMux` with handler registration
2. Implement read loop on `Dispatchers.IO`
3. Implement thread-safe send with Mutex
4. Handle frame reassembly for multi-frame messages
5. Add logging for all frame traffic (debug mode)
6. Create concrete handlers: `VideoChannelHandler`, `AudioChannelHandler`, `InputChannelHandler`, `SensorChannelHandler`

**Acceptance criteria:**
- [ ] Frames are correctly routed to registered handlers
- [ ] Multi-frame messages are reassembled before delivery
- [ ] Concurrent sends don't corrupt the stream

---

### 2.5 AA Head Unit Emulator

**File:** `androidauto/src/main/java/com/supertesla/aa/androidauto/headunit/AAHeadUnitEmulator.kt`

**Purpose:** Main orchestrator that connects to AA, negotiates session, and manages channels.

**Connection sequence:**
```
Phone App                              AA Head Unit Server
   |                                        |
   | ---- TCP connect localhost:5277 -----> |
   |                                        |
   | ---- VERSION_REQUEST (v1.7) ---------> |
   | <--- VERSION_RESPONSE (v1.7) --------- |
   |                                        |
   | ---- SSL_HANDSHAKE (ClientHello) ----> |
   | <--- SSL_HANDSHAKE (ServerHello) ----- |
   | ---- SSL_HANDSHAKE (Finished) -------> |
   | <--- SSL_HANDSHAKE (Finished) -------- |
   |        [TLS Established]               |
   |                                        |
   | ---- SERVICE_DISCOVERY_REQUEST ------> |
   | <--- SERVICE_DISCOVERY_RESPONSE ------- |
   |        [Lists available services]      |
   |                                        |
   | ---- CHANNEL_OPEN_REQUEST (video) ---> |
   |       width=1280, height=720,          |
   |       density=160, fps=60, H264       |
   | <--- CHANNEL_OPEN_RESPONSE (ch=1) ---- |
   |                                        |
   | ---- CHANNEL_OPEN_REQUEST (audio) ---> |
   |       44100Hz, stereo, 16bit, PCM     |
   | <--- CHANNEL_OPEN_RESPONSE (ch=2) ---- |
   |                                        |
   | ---- CHANNEL_OPEN_REQUEST (input) ---> |
   | <--- CHANNEL_OPEN_RESPONSE (ch=3) ---- |
   |                                        |
   |        [Streaming begins]              |
   | <--- Video frames (H.264 NALUs) ------ |
   | <--- Audio frames (PCM) -------------- |
   | ---- Input events (touch) -----------> |
   | ---- Sensor data (GPS) -------------> |
```

**Implementation:**

```kotlin
class AAHeadUnitEmulator(
    private val config: HeadUnitConfig
) {
    data class HeadUnitConfig(
        val videoWidth: Int = 1280,
        val videoHeight: Int = 720,
        val videoDensity: Int = 160,
        val videoFps: Int = 60,
        val audioSampleRate: Int = 44100,
        val audioChannels: Int = 2,
        val audioBitDepth: Int = 16
    )

    private lateinit var channelMux: ChannelMux
    val videoFrames: SharedFlow<ByteArray>  // H.264 NAL units
    val audioFrames: SharedFlow<ByteArray>  // PCM data

    suspend fun connect() {
        // 1. TCP connect
        val socket = Socket("127.0.0.1", 5277)

        // 2. Version exchange
        exchangeVersion(socket)

        // 3. TLS handshake
        val crypto = AapCrypto()
        performTlsHandshake(socket, crypto)

        // 4. Service discovery
        val services = discoverServices()

        // 5. Open channels
        openVideoChannel(services)
        openAudioChannel(services)
        openInputChannel(services)

        // 6. Start read loop
        channelMux.readLoop()
    }

    suspend fun sendTouchEvent(event: InputEvent) {
        channelMux.send(inputChannelId, event.toByteArray())
    }

    suspend fun sendSensorData(location: Location) {
        channelMux.send(sensorChannelId, buildSensorMessage(location))
    }

    fun disconnect() {
        // Send BYEBYE_REQUEST, close socket
    }
}
```

**Steps:**
1. Implement TCP connection to `localhost:5277`
2. Implement version exchange (protocol v1.7)
3. Integrate TLS handshake via `AapCrypto`
4. Implement service discovery request/response
5. Implement channel open negotiation for video, audio, input
6. Create `VideoChannelHandler` that emits H.264 NAL units to `SharedFlow`
7. Create `AudioChannelHandler` that emits PCM data to `SharedFlow`
8. Create `InputChannelHandler` for sending touch events
9. Create `SensorChannelHandler` for sending GPS data
10. Implement keepalive (PING_REQUEST/RESPONSE)
11. Implement graceful disconnection (BYEBYE)
12. Handle AA head unit server not running (user-friendly error)

**Acceptance criteria:**
- [ ] Successfully connects to AA head unit server
- [ ] TLS handshake completes
- [ ] Service discovery returns available services
- [ ] Video channel opens and receives H.264 data
- [ ] Audio channel opens and receives PCM data

---

### 2.6 Local Video Validation (Phone Display)

**File:** `app/src/main/java/com/supertesla/aa/ui/DebugVideoView.kt`

**Purpose:** Decode and display received H.264 video on the phone screen to validate Phase 2.

```kotlin
@Composable
fun DebugVideoView(videoFlow: SharedFlow<ByteArray>) {
    AndroidView(factory = { context ->
        SurfaceView(context).also { surfaceView ->
            val decoder = MediaCodec.createDecoderByType("video/avc")
            // Configure decoder with SPS/PPS from first NAL units
            // Feed NAL units from videoFlow into decoder input buffers
            // Render to SurfaceView surface
        }
    })
}
```

**Steps:**
1. Create `H264Decoder` wrapper around `MediaCodec`
2. Parse SPS/PPS NAL units to configure decoder
3. Feed IDR and P-frame NAL units to decoder
4. Render decoded frames to `SurfaceView`
5. Add debug overlay showing FPS, bitrate, resolution

**Acceptance criteria:**
- [ ] Android Auto UI is visible on phone screen
- [ ] Video plays smoothly at expected framerate
- [ ] Resolution matches configured video config

---

## Phase 2 Verification Checklist

1. [ ] Protobuf classes generate and serialize correctly
2. [ ] Can connect TCP to `localhost:5277` when AA head unit server is running
3. [ ] TLS handshake completes successfully
4. [ ] Service discovery returns valid services
5. [ ] Video channel negotiation succeeds (H.264, configured resolution)
6. [ ] H.264 NAL units received continuously
7. [ ] Audio PCM data received continuously
8. [ ] Phone displays the Android Auto UI via local decode
9. [ ] Video FPS matches configured value
10. [ ] Keepalive (PING) works without disconnection
11. [ ] Graceful disconnect works

---

## Estimated Effort
- Protobuf definitions: 1 day
- Frame parsing: 1 day
- TLS handshake: 2 days (most complex part)
- Channel multiplexer: 1 day
- Head unit emulator: 2 days
- Local video validation: 1 day
- Testing & protocol debugging: 3 days
- **Total: ~11 days**

---

## Key References
- [AAP Protocol Research](https://milek7.pl/.stuff/galdocs/readme.md)
- [AACS Source Code](https://github.com/tomasz-grobelny/AACS)
- [OpenAuto](https://github.com/niclas/openauto) - C++ AAP implementation
- [android-auto-headunit](https://github.com/niclas/node-WirelessAndroidAutoServer) - Node.js reference
- AA Developer Settings: Enable "Start head unit server" in Android Auto developer options
