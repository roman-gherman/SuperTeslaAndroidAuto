# TaaDa 2.2.0 - Complete App Analysis & Comparison with SuperTeslaAndroidAuto

> **Purpose**: Deep analysis of TaaDa 2.2.0 (decompiled) to identify architectural differences, protocol details, and stability patterns. Use this as a blueprint to bring SuperTeslaAndroidAuto closer to TaaDa's proven approach, then surpass it.

---

## Table of Contents

1. [Executive Summary & Key Differences](#1-executive-summary--key-differences)
2. [App Architecture & Lifecycle](#2-app-architecture--lifecycle)
3. [AA Protocol & Handshake](#3-aa-protocol--handshake)
4. [Wire Protocol Format](#4-wire-protocol-format)
5. [ServiceDiscovery Response](#5-servicediscovery-response)
6. [Channel Architecture](#6-channel-architecture)
7. [SSL/TLS Implementation](#7-ssltls-implementation)
8. [Video Pipeline (H.264)](#8-video-pipeline-h264)
9. [Audio Pipeline](#9-audio-pipeline)
10. [Touch Input Pipeline](#10-touch-input-pipeline)
11. [WebSocket & HTTP Server Architecture](#11-websocket--http-server-architecture)
12. [VPN Implementation](#12-vpn-implementation)
13. [Bluetooth Auto-Start](#13-bluetooth-auto-start)
14. [Sensor Channel](#14-sensor-channel)
15. [Memory Management & Buffer Pools](#15-memory-management--buffer-pools)
16. [Error Handling & Reconnection](#16-error-handling--reconnection)
17. [Billing & Subscription](#17-billing--subscription)
18. [UI Architecture](#18-ui-architecture)
19. [Telemetry & Analytics](#19-telemetry--analytics)
20. [Comparison: TaaDa vs SuperTeslaAndroidAuto](#20-comparison-taada-vs-superteslaandroidauto)
21. [Action Items: What to Adopt from TaaDa](#21-action-items-what-to-adopt-from-taada)

---

## 1. Executive Summary & Key Differences

TaaDa is a **production-grade AA head unit emulator** that intercepts Android Auto protocol over a local TCP connection and relays video/audio/touch to Tesla's browser via WebSocket. Key architectural decisions:

| Aspect | TaaDa 2.2.0 | SuperTeslaAndroidAuto |
|--------|-------------|----------------------|
| **Language** | Java (decompiled, obfuscated) | Kotlin |
| **Architecture** | Singleton services + EventBus | Multi-module + Hilt DI + Compose UI |
| **AA Connection** | TCP localhost:5288, AA launched via intent | Same approach (port 5288) |
| **Video delivery** | Raw H.264 NAL → WebSocket binary frames | H.264 NAL → fMP4 muxer → WebSocket |
| **Audio routing** | Bluetooth A2DP by default, PCM fallback | Audio channels over AA protocol |
| **Touch format** | JSON + Binary (6 bytes/pointer) | JSON only |
| **HTTP server** | Custom SSLServerSocket (config JSON only) | Ktor (serves HTML+JS player) |
| **HTML player** | Hosted externally (NOT in app) | Embedded in app assets |
| **Video ACK** | Browser-driven (browser sends ACK → AA) | Server-side |
| **State machine** | Static boolean flags + synchronized lock | Explicit FSM (AppStateManager) |
| **Buffer management** | Object pools + tiered buffer pools | Standard allocation |
| **Subscription** | Google Play Billing + demo mode | None |
| **VPN strategy** | Exclude AA from VPN (force loopback) | VPN tunnel with fake gateway |

### TaaDa's Critical Stability Advantages

1. **Raw H.264 passthrough** (no transcoding/muxing overhead)
2. **Browser-driven video ACKs** (`maxUnacked=1`, browser controls flow)
3. **Bluetooth audio bypass** (channels 5,7 omitted from SD, audio via BT A2DP)
4. **Aggressive memory pooling** (object pools, tiered buffer pools, pre-allocation)
5. **3-second browser keepalive** (auto-disable video focus on disconnect)
6. **2-second heartbeat** to AA (keeps connection alive)
7. **Dynamic SSL certificates** (updated from server without app update)

---

## 2. App Architecture & Lifecycle

### Package Structure (fr.sd.taada)

```
fr.sd.taada/
├── TaaDaApplication.java          # Application class, analytics init
├── TransporterService.java        # Main foreground service (singleton)
├── CommunicationHandler.java      # AA TCP connection manager
├── ConnectionWaitRunnable.java    # ServerSocket(5288) accept loop
├── MessageSenderRunnable.java     # Outbound message encryption + send
├── DemoModeHandler.java           # Demo mode timer/expiry
├── VpnServiceManager.java         # VPN start/stop orchestration
├── WifiReceiver.java              # BT ACL_CONNECTED/DISCONNECTED receiver
├── MainActivity.java              # Advanced settings (MainPreferenceFragment)
├── activities/
│   ├── HomeActivity.java          # Main launcher (5-tab BottomNav)
│   ├── BaseLocalizedActivity.java # Locale management
│   ├── LogActivity.java           # Log viewer
│   ├── SubscriptionActivity.java  # Paywall
│   ├── AAVersionErrorActivity.java# AA version error
│   └── MicActivity.java           # Transparent mic recording
├── billing/                       # Google Play Billing
├── config/                        # PaywallConfig
├── core/auth/                     # Telemetry auth
├── fragments/                     # Settings fragments
├── helpers/
│   ├── bluetooth/                 # BT device manager
│   ├── demo/                      # Demo mode manager
│   ├── dialogs/                   # Dialog helpers
│   ├── event/                     # EventBus wrapper
│   ├── input/                     # OptimizedTouchEventHandler
│   ├── os/                        # OS-specific helpers
│   ├── permissions/               # Permission flow
│   ├── resolution/                # Video resolution
│   ├── service/                   # Service helpers
│   ├── subscription/              # Subscription guard
│   ├── video/                     # NalStreamManager, FpsTracker
│   └── zoom/                      # DPI/zoom control
├── proto/                         # Protobuf message builders
├── protocol/                      # BinaryTouchDecoder
├── services/                      # Additional services
├── ssl/                           # SSL certificate manager
├── ui/components/                 # Custom UI components
├── utils/                         # Utilities
└── viewmodels/                    # HomeViewModel, SubscriptionViewModel
```

### Obfuscated Core Packages

| Package | Purpose |
|---------|---------|
| `p003a2` | ServiceDiscoveryResponse builder |
| `p024d2` | ProtocolMessage, ProtocolMessagePool, ProtocolBufferPool |
| `p042g2` | Channel handlers (control, input, sensor, media, mic, metadata) |
| `p048h2` | MessageHandler (raw TCP read/write with framing) |
| `p054i2` | VideoResolutionHelper |
| `p060j2` | WebSocket servers (ControlSocketServer, MediaSocketServer), HttpRequestHandler |
| `p066k2` | SSLHandler, SSLHelper, AbstractSSLHandler |

### Application Startup

1. `TaaDaApplication.attachBaseContext()` → locale init, MultiDex
2. `TaaDaApplication.onCreate()` → LogManager, PreferencesHelper, AuthManager (`https://telemetry.taada.top`), AttributionManager, TelemetryManager, SslUpdateWorker (daily cert check)
3. User opens `HomeActivity` (MAIN/LAUNCHER)
4. User taps Start → `ServiceStartHandler.handleStartStopButtonClick()` → subscription check → `TransporterService` started as foreground

### TransporterService Lifecycle

**onCreate():**
- Singleton instance set
- EventBus registered
- ProtocolMessagePool, CommunicationHandler, DemoModeHandler, VpnServiceManager created
- Foreground notification with "Exit" action
- Video resolution loaded from prefs (default: 1180×860)

**onStartCommand():**
- Subscription verified (stops if invalid)
- Random WebSocket port: `8090 + Random.nextInt(1908)` (range 8090-9997)
- VPN started if enabled
- 3 WebSocket servers created (control+video, media audio, voice)
- HTTPS config server started (port 8081-8085)
- Android Auto launched via intent
- ConnectionWaitRunnable started (port 5288)

**Message flow:**
- EventBus central dispatch (GreenRobot EventBus)
- `TransporterService.onMessage(ProtocolMessage)` → encrypts via SSLHandler → sends via single-thread executor
- All channel handlers post outbound messages to EventBus

**onDestroy():**
1. Notify WebSocket clients: `{"type":"server_shutdown"}`
2. Wait 500ms
3. Close VPN
4. Send ByeByeRequest to AA
5. Stop demo, VPN, WebSocket servers
6. Unregister EventBus
7. Schedule restart if needed
8. Close socket, cancel notifications

### State Management

TaaDa uses **static boolean flags** with a synchronized lock object:
```java
static final Object STATIC_FIELDS_LOCK = new Object();
static boolean isConnected = false;
static boolean isServiceActive = false;
static boolean isVideoActive = false;
```

No FSM — just three booleans guarded by synchronized blocks.

---

## 3. AA Protocol & Handshake

### Connection Flow

```
1. TransporterService.onStartCommand()
   └── Launch AA: intent to WirelessStartupActivity
       ├── PARAM_HOST_ADDRESS = "127.0.0.1"
       ├── PARAM_SERVICE_PORT = 5288
       ├── wifi_info = mocked WifiInfo (reflection)
       └── PARAM_SERVICE_WIFI_NETWORK = Mockito.mock(Network.class, 99999)
   └── ConnectionWaitRunnable: ServerSocket(5288).accept()

2. CommunicationRunnable.run() (handshake):
   Step 1: sendCarHello()
           → {0x00, 0x03, 0x00, 0x06, 0x00, 0x01, 0x00, 0x01, 0x00, 0x06}
           → AA Protocol Version 1.6 (major=1, minor=6)

   Step 2: readPhoneHello() (2s timeout, no validation)

   Step 3: sendCleartextMessage()
           → {0x00, 0x03, 0x00, 0x04, 0x00, 0x04, 0x08, 0x00}
           → AUTH_COMPLETE (field 1 varint = 0)

   Step 4: setupSSL()
           → SSLEngine from R.raw.keystore, password "aa"
           → TLSv1.3 preferred, TLSv1.2 fallback
           → clientMode=true, needClientAuth=true
           → NaiveTrustManager (accepts ALL certs)

   Step 5: performHandshake() via AbstractSSLHandler.doHandshake()
           → NEED_WRAP: encrypt + frame as ENCAPSULATED_SSL (msgType=3)
           → NEED_UNWRAP: read frame, strip 6 bytes, decrypt
           → NEED_TASK: delegated tasks on executor

   Step 6: sendCleartextMessage() AGAIN
           → Same AUTH_COMPLETE bytes (double send)

   Step 7: Initialize SSLHandler, MessageProcessor
           → isConnected = true
           → Start heartbeat (PingRequest every 2000ms)

   Step 8: processMessages() main loop
           → readData() → ProtocolMessage(bytes, ssl) → processMessage()
```

### AA Launch Fallback (AA 16.4+)

When Activity launch fails with SecurityException:
```java
// Fallback: broadcast to WirelessStartupReceiver
intent.setAction("com.google.android.apps.auto.wireless.setup.receiver.wirelessstartup.START");
intent.putExtra("ip_address", "127.0.0.1");
intent.putExtra("projection_port", 5288);
```

### Mock Network Object

```java
network = (Network) Mockito.mock(Network.class,
    Mockito.withSettings().useConstructor(99999));
// Fallback: ConnectivityManager.getActiveNetwork()
```

### Socket Configuration

```java
socket.setSoTimeout(10000);           // 10s read timeout
socket.setTcpNoDelay(true);           // Disable Nagle
socket.setKeepAlive(true);
socket.setReuseAddress(true);
socket.setTrafficClass(16);           // IPTOS_LOWDELAY
socket.setReceiveBufferSize(1048576); // 1MB
socket.setSendBufferSize(1048576);    // 1MB
```

---

## 4. Wire Protocol Format

### Frame Header (4 bytes minimum)

```
Byte 0:     channel (0-10)
Byte 1:     flags = (service & 0x03) | (extraFlag & 0x04) | (sslFlag & 0x08)
Bytes 2-3:  frameSize (big-endian uint16)
```

### Flag Bits (Byte 1)

| Bit | Mask | Name | Values |
|-----|------|------|--------|
| 0-1 | 0x03 | service | 0=continuation, 1=first-fragment, 2=last-fragment, 3=complete |
| 2 | 0x04 | extraFlag | Channel open request/response |
| 3 | 0x08 | sslFlag | Payload is SSL-encrypted |

### Extended Header (service=1)

When service=1 (first fragment), 4 additional bytes follow:
```
Bytes 4-5:  frameType (big-endian uint16)
[Then SSL-encrypted payload at offset 8]
```

### SSL-Encrypted Message Layout

```
[channel:1] [flags:1] [encLen_hi:1] [encLen_lo:1] [SSL ciphertext...]
```

### Cleartext Message Layout

```
[channel:1] [flags:1] [frameSize_hi:1] [frameSize_lo:1] [msgType_hi:1] [msgType_lo:1] [payload...]
```

### Message Type Extraction

After SSL decryption, for service != 0 and != 2:
```java
messageType = (payload[0] << 8) | payload[1];  // first 2 bytes
// Then trimMessageTypeBytes() strips these 2 bytes for protobuf parsing
```

### SSL Handshake Wire Format

**HU sends (NEED_WRAP):**
```
{0x00, 0x03, (len+2)/256, (len+2)%256, 0x00, 0x03, SSL_DATA...}
// Channel=0, service=3, msgType=3 (ENCAPSULATED_SSL)
```

**HU receives (NEED_UNWRAP):**
```
Reads full frame → strips first 6 bytes → feeds to sslEngine.unwrap()
```

---

## 5. ServiceDiscovery Response

Built in `AbstractC0041a.m13031a()`. Triggered by channel=0, service=3, messageType=5.

### HeadUnitInfo

```
Make: "Google"
Model: "Desktop Head Unit"
SoftwareBuild: "HUR"
SoftwareVersion: "1.1"
DriverPosition: LEFT (or RIGHT if rhd=true)
```

### Services Declared

**Service 1 — InputSourceService:**
```
TouchScreen: CAPACITIVE, width=videoWidth, height=videoHeight
Keycodes: [1,2,3,4,5,6,19,20,21,22,23,84,85,87,88]
```

**Service 2 — SensorSourceService:**
```
Sensors: DRIVING_STATUS, NIGHT_MODE, LOCATION, PARKING_BRAKE
```

**Service 3 — MediaSinkService (Video):**
```
AvailableType: MEDIA_CODEC_VIDEO_H264_BP
DisplayType: DISPLAY_TYPE_MAIN
VideoConfig:
  density: dpi (pref, default 120)
  frameRate: VIDEO_FPS_30
  codecResolution: forNumber(resIndex + 1)
  heightMargin: calculated
  widthMargin: calculated
```

**Service 4 — MediaSourceService (Microphone):**
```
AvailableType: MEDIA_CODEC_AUDIO_PCM
AudioConfig: 16bit, 16000Hz, 1ch (mono)
```

**Service 5 — MediaSinkService (Media Audio)** — ONLY if useBT=false:
```
AvailableType: MEDIA_CODEC_AUDIO_PCM
AudioType: AUDIO_STREAM_MEDIA
AudioConfig: 16bit, 48000Hz, 2ch (stereo)
```

**Service 6 — MediaSinkService (System Audio):**
```
AvailableType: MEDIA_CODEC_AUDIO_PCM
AudioType: AUDIO_STREAM_SYSTEM_AUDIO
AudioConfig: 16bit, 16000Hz, 1ch (mono)
```

**Service 7 — MediaSinkService (Guidance)** — ONLY if useBT=false:
```
AvailableType: MEDIA_CODEC_AUDIO_PCM
AudioType: AUDIO_STREAM_GUIDANCE
AudioConfig: 16bit, 16000Hz, 1ch (mono)
```

**Service 9 — MediaPlaybackStatusService:**
```
(empty — just declares presence)
```

### Video Resolution Options

| Index | Width | Height | Orientation |
|-------|-------|--------|-------------|
| 0 | 800 | 480 | Landscape |
| 1 (default) | 1280 | 720 | Landscape |
| 2 | 1920 | 1080 | Landscape |
| 3 | 2560 | 1440 | Landscape |
| 4 | 3840 | 2160 | Landscape |
| 5 | 720 | 1280 | Portrait |
| 6 | 1080 | 1920 | Portrait |
| 7 | 1440 | 2560 | Portrait |

### Margin Calculation

```java
screenRatio = screenWidth / screenHeight;
if (ratio <= videoAspect):
    widthMargin = videoWidth - (videoHeight * screenRatio)
else:
    heightMargin = videoHeight - (videoWidth / screenRatio)
```

Screen defaults: 1180×860 (from `stored_width`/`stored_height` prefs).

---

## 6. Channel Architecture

### Channel/Service ID Mapping

| Channel | Purpose | Handler Class | Direction |
|---------|---------|---------------|-----------|
| 0 | Control | AbstractC2293a | Both |
| 1 | Input (Touch/Key) | AbstractC2294b | HU→Phone |
| 2 | Sensors | AbstractC2298f | HU→Phone |
| 3 | Video (H.264) | AbstractC2296d | Phone→HU |
| 4 | Microphone | C2297e | HU→Phone |
| 5 | Media Audio (PCM) | AbstractC2296d | Phone→HU |
| 6 | System Audio (PCM) | AbstractC2296d | Phone→HU |
| 7 | Guidance Audio (PCM) | AbstractC2296d | Phone→HU |
| 9 | Media Playback Metadata | AbstractC2295c | Phone→HU |
| 10 | Debug/Log | (logged only) | Phone→HU |

### Control Channel (0) Message Types

| ID | Name | Direction |
|----|------|-----------|
| 1 | VERSION_REQUEST | HU→Phone |
| 2 | VERSION_RESPONSE | Phone→HU |
| 3 | ENCAPSULATED_SSL | Both |
| 4 | AUTH_COMPLETE | HU→Phone |
| 5 | SERVICE_DISCOVERY_REQUEST | Phone→HU |
| 6 | SERVICE_DISCOVERY_RESPONSE | HU→Phone |
| 7 | CHANNEL_OPEN_REQUEST | Phone→HU |
| 8 | CHANNEL_OPEN_RESPONSE | HU→Phone |
| 11 | PING_REQUEST | Both |
| 12 | PING_RESPONSE | Both |
| 13 | NAV_FOCUS_REQUEST | Phone→HU |
| 14 | NAV_FOCUS_NOTIFICATION | HU→Phone |
| 15 | BYEBYE_REQUEST | Both |
| 18 | AUDIO_FOCUS_REQUEST | Phone→HU |
| 19 | AUDIO_FOCUS_NOTIFICATION | HU→Phone |

### Media Message Types (Channels 1-9)

| ID | Hex | Name |
|----|-----|------|
| 0 | 0x0000 | MEDIA_MESSAGE_DATA |
| 1 | 0x0001 | MEDIA_MESSAGE_CODEC_CONFIG |
| 32768 | 0x8000 | MEDIA_MESSAGE_SETUP |
| 32769 | 0x8001 | MEDIA_MESSAGE_START |
| 32770 | 0x8002 | MEDIA_MESSAGE_STOP |
| 32771 | 0x8003 | MEDIA_MESSAGE_CONFIG |
| 32772 | 0x8004 | MEDIA_MESSAGE_ACK |
| 32773 | 0x8005 | MICROPHONE_REQUEST |
| 32774 | 0x8006 | MICROPHONE_RESPONSE |
| 32775 | 0x8007 | VIDEO_FOCUS_REQUEST |
| 32776 | 0x8008 | VIDEO_FOCUS_NOTIFICATION |

### Channel Open Handling

**Always responds with STATUS_SUCCESS** regardless of channel ID. Both request and response carry `extraFlag=0x04`.

### Audio Focus Handling

- `AUDIO_FOCUS_RELEASE` → respond with `AUDIO_FOCUS_STATE_LOSS_TRANSIENT_CAN_DUCK`
- Any other request → respond with `AUDIO_FOCUS_STATE_GAIN`
- Always grants focus.

### Nav Focus Handling

Always responds with `NAV_FOCUS_PROJECTED`.

---

## 7. SSL/TLS Implementation

### Certificates

| Resource | Purpose | Password |
|----------|---------|----------|
| `R.raw.keystore` | AA protocol TLS | `"aa"` |
| `R.raw.server_pbe` | WebSocket/HTTPS servers | `"aa"` |

### Dynamic Certificate Support

```java
File file = new File(context.getFilesDir(), "dynamic-server-cert.p12");
if (file.exists()) return new FileInputStream(file);  // dynamic
return context.getResources().openRawResource(resourceId);  // bundled
```

**Update mechanism:** `SslCertificateManager` checks `https://cert.taada.top/health` for SHA-256 fingerprint changes. Downloads new cert from `https://cert.taada.top`. Runs daily via `SslUpdateWorker` (WorkManager).

### Trust Manager (NaiveTrustManager)

Accepts ALL certificates without validation — both client and server certs.

### SSL Engine Configuration

- Protocol: TLSv1.3 preferred, TLSv1.2 fallback
- `clientMode = true` (TaaDa acts as SSL client despite being HU)
- `needClientAuth = true` (mutual TLS)
- Keystore type: PKCS12

### Buffer Sizes

- Initial: 32KB each (×4 buffers)
- Max growth: 64MB
- Growth factor: 2× (doubles on overflow)
- Memory-aware: reduces growth in WARNING/CRITICAL states

---

## 8. Video Pipeline (H.264)

### Overview

TaaDa does **zero transcoding**. Raw H.264 NAL units from AA are reassembled and forwarded directly to the Tesla browser via WebSocket binary frames. The browser decodes using WebCodecs API.

### NAL Reassembly (NalStreamManager.buildNal)

| Service Flag | Meaning | Action |
|--------------|---------|--------|
| 3 | Complete frame | Process immediately |
| 1 | First fragment | Clear 8MB nalBuffer, start accumulating |
| 0 | Continuation | Append to nalBuffer |
| 2 | Last fragment | Append, flip, process |
| 127 | Raw passthrough | Send directly |

### Payload Offsets

- **MEDIA_MESSAGE_DATA (0x0000):** bytes [0-1] = msgType, [2-9] = 8-byte timestamp, [10+] = NAL data
- **MEDIA_MESSAGE_CODEC_CONFIG (0x0001):** bytes [0-1] = msgType, [2+] = NAL data (validated: 00 00 00 01 start code)

### Video Focus Control

```java
// Enable video streaming
VideoFocusNotification(focus=VIDEO_FOCUS_PROJECTED, unsolicited=true)
// Channel=3, service=3, messageType=32776

// Disable
VideoFocusNotification(focus=VIDEO_FOCUS_NATIVE, unsolicited=true)

// Request keyframe
VideoFocusNotification(focus=VIDEO_FOCUS_PROJECTED, unsolicited=true)
// Channel=3, service=3, messageType=32775
// Throttled: max once per 2 seconds

// Fallback keyframe: toggle focus off → 500ms delay → toggle on
```

### Video ACK (Browser-Driven)

```
Browser → {"action":"ACK"} → ControlSocketServer
→ Ack(sessionId=<video_session>, ack=1)
→ Channel=3, service=3, messageType=32772 → AA
```

**Critical:** `maxUnacked=1` in the Config response means AA sends only 1 unACKed frame at a time. The browser MUST send ACK promptly.

### NAL Buffer

`ByteBuffer.allocateDirect(8388608)` — 8MB for frame reassembly.

### FPS Tracking

Two trackers:
- `serverFpsTracker`: frames sent per second (server-side)
- `clientFpsTracker`: FPS reported by browser via PING

---

## 9. Audio Pipeline

### Bluetooth Bypass (Default)

When `useBT=true` (default):
- Channels 5 (media) and 7 (guidance) are **omitted from ServiceDiscovery entirely**
- Audio goes via Bluetooth A2DP directly from phone to car speakers
- Only channel 6 (system audio) is registered

### PCM Audio Channels

| Channel | Type | Rate | Channels | Bits | WebSocket Server |
|---------|------|------|----------|------|-----------------|
| 5 | Media/Music | 48kHz | Stereo | 16-bit | MediaAudioSocketServer (port+1) |
| 6 | System | 16kHz | Mono | 16-bit | VoiceSocketServer (port+2) |
| 7 | Guidance | 16kHz | Mono | 16-bit | VoiceSocketServer (port+2) |

### Audio Data Flow

```
AA → ProtocolMessage(channel=5/6/7, MEDIA_MESSAGE_DATA)
→ AbstractC2296d.m3194a()
→ Strip first 10 bytes (2 msgType + 8 media header)
→ mediaAudioSocketServer.m2580j0(pcmData, false) // or voiceSocketServer
→ WebSocket binary frame → Tesla browser
→ Immediate ACK: Ack(sessionId, ack=1) → back to AA
```

### Audio ACK (Server-Side, Automatic)

Unlike video ACKs (browser-driven), audio ACKs are sent **immediately** by the server after receiving each audio frame. No browser involvement needed.

### Microphone (Channel 4)

- AA sends `MicrophoneRequest(open=true)` on channel 4
- TaaDa launches `MicActivity` (transparent, shows-when-locked)
- AudioRecord: 16kHz, mono, 16-bit, VOICE_COMMUNICATION source
- Thread priority: MAX (10)
- Bluetooth SCO enabled for mic input
- Audio data format: `[0x00, 0x00] + [8-byte timestamp] + [PCM data]`
- Posted as `ProtocolMessage(channel=4, service=3)` via EventBus

---

## 10. Touch Input Pipeline

### Dual Input Formats

**JSON format:**
```json
{"action":"MULTITOUCH_DOWN","touches":[{"id":0,"x":640,"y":360}],"allTouches":[{"id":0,"x":640,"y":360}]}
```

**Binary format (6 bytes per pointer):**
```
Byte 0:       action (0=DOWN, 1=MOVE, 2=UP, 3=TOUCH)
Byte 1:       touchCount
Per touch:    id(uint16 BE) + x(uint16 BE) + y(uint16 BE)
Then:         allTouchCount(uint8)
Per allTouch: id(uint16 BE) + x(uint16 BE) + y(uint16 BE)
Last 4 bytes: timestamp delta (uint32 BE, cumulative)
```

Binary detection: `data.length >= 8 && action <= 3 && touchCount <= 10`.

### Multi-Touch Action Mapping

| Browser Action | Condition | AA PointerAction |
|---------------|-----------|-----------------|
| DOWN | allTouches > 1 | ACTION_POINTER_DOWN (5) |
| DOWN | allTouches ≤ 1 | ACTION_DOWN (0) |
| UP | allTouches > 0 | ACTION_POINTER_UP (6) |
| UP | allTouches = 0 | ACTION_UP (1) |
| MOVE | any | ACTION_MOVED (2) |
| CANCEL | any | ACTION_UP (1) |

### Touch Processing Pipeline

```
Browser → JSON/Binary → ControlSocketServer.onMessage()
→ handleAction() / handleBinaryTouchEvent()
→ processMultiTouchEvent(action, touches, allTouches)
→ Build TouchEvent protobuf (action, actionIndex, pointers[])
→ OptimizedTouchEventHandler.queueTouchEvent()
→ HandlerThread "TouchEventProcessor" (priority -8)
→ AbstractC2294b.m3197b(builder)
→ InputReport(timestamp=uptimeMillis, touchEvent)
→ ProtocolMessage(channel=1, service=3, messageType=32769)
→ EventBus → TransporterService → SSL encrypt → AA
```

### Coordinate System

**No coordinate transformation on Android side.** Browser receives `width`, `height`, `widthMargin`, `heightMargin` from the HTTPS config endpoint and handles all coordinate mapping itself.

### Touch Optimization

- Dedicated `HandlerThread` with priority -8 (high)
- Emergency `LinkedBlockingQueue<TouchEvent.Builder>` (size 32, polled every 5ms)

---

## 11. WebSocket & HTTP Server Architecture

### Server Ports

```
HTTPS Config: 8081-8085 (first available)
WebSocket Base: 8090 + Random.nextInt(1908) = 8090-9997
  Control+Video: base
  Media Audio:   base+1
  Voice Audio:   base+2
```

### HTTPS Config Server

**NOT NanoHTTPD** — raw `SSLServerSocket` with manual HTTP parsing via `StringTokenizer`.

**Protocol:** HTTPS (TLSv1.2) with `R.raw.server_pbe` certificate.

**Request:** `GET /?w=<screen_width>&h=<screen_height>&webcodec=true`

**Response:**
```json
{
  "width": 1920,
  "height": 1080,
  "widthMargin": 0,
  "heightMargin": 0,
  "port": 8453,
  "resolution": 2,
  "buildversion": 42,
  "usebt": true,
  "debug": false,
  "resolutionChanged": true
}
```

On each request, `NalStreamManager.adjustResolution()` recalculates margins and optionally updates AA's video config.

### Key Insight: No HTML/JS Player in App

The video player page is **NOT served by the Android app**. It's hosted externally (likely on taada.top). The HTTPS server only provides a configuration/negotiation API. The `resources/assets/` directory contains only `dexopt/`, `paywall_config.json`, and `supplierconfig.json`.

### ControlSocketServer (WSS)

Dual-purpose: video output (binary) + control input (JSON/binary).

**Video output:** `webSocket.send(byteBuffer)` — raw H.264 NAL binary frames.

**Control actions from browser:**

| Action | Parameters | Effect |
|--------|-----------|--------|
| `START` | — | Enable video focus |
| `STOP` | — | Disable video focus |
| `ACK` | — | Send video ACK to AA |
| `PING` | `{fps: N}` | Keepalive + FPS report, resets 3s timer |
| `REQUEST_KEYFRAME` | — | Request I-frame (throttled: 2s) |
| `RELOAD` | — | Toggle focus off→100ms→on |
| `GPS` | lat,lon,alt,heading,speed,acc | Forward to sensor channel |
| `NIGHT` | `{value: bool}` | Set night mode |
| `MULTITOUCH_DOWN` | touches, allTouches | Touch start |
| `MULTITOUCH_MOVE` | touches, allTouches | Touch move |
| `MULTITOUCH_UP` | touches, allTouches | Touch end |
| `MULTITOUCH_CANCEL` | touches, allTouches | Touch cancel (→UP) |

**PING response:** Binary `{0x00, 0x00, 0x00, 0x00, 0x1F}`

**Video focus timeout:** If no PING within 3000ms → `toogleVideoFocus(false)`

### MediaSocketServer (WSS)

Output-only. Sends PCM audio as binary WebSocket frames. Supports batch mode (accumulate in 512KB buffer, flush at 1MB). No incoming messages expected.

### All Servers Use WSS

`DefaultSSLWebSocketServerFactory` with `R.raw.server_pbe` certificate. `tcpNoDelay=true`.

---

## 12. VPN Implementation

### Purpose

Traffic isolation trick to force AA to connect locally, NOT for privacy/tunneling.

### How It Works

1. `MyVpnService` captures ALL device traffic EXCEPT Android Auto
2. Uses `addDisallowedApplication("com.google.android.projection.gearhead")`
3. AA excluded from VPN → connects directly to localhost:5288
4. VPN address: `51.75.29.16/24`, DNS: `8.8.8.8`, route: `0.0.0.0/0`
5. `NewVpnService` adds secondary VPN: `89.83.67.208/24`, UDP to `127.0.0.1:8089`

### Optional

Controlled by `usevpn` preference (default: true).

---

## 13. Bluetooth Auto-Start

### WifiReceiver (BroadcastReceiver)

Registered in manifest for:
- `android.bluetooth.device.action.ACL_CONNECTED`
- `android.bluetooth.device.action.ACL_DISCONNECTED`
- `fr.sd.taada.exit`

### Connection Flow

```
BT ACL_CONNECTED
→ Check BLUETOOTH_CONNECT permission
→ Load selected_bluetooth_devices StringSet from prefs
→ Match connected device MAC
→ Start SubscriptionCheckService (foreground, dataSync)
→ Verify subscription async
→ Start TransporterService
```

### Disconnection

```
BT ACL_DISCONNECTED
→ TransporterService.isServiceActive = false
→ Broadcast ACTION_SERVICE_STATE_CHANGED
```

---

## 14. Sensor Channel

### Channel 2 Handler (AbstractC2298f)

On `SensorRequest` (messageType=32769):

1. Always sends `SensorResponse(STATUS_SUCCESS)` first
2. Then based on sensor type:

| Sensor | Response |
|--------|----------|
| DRIVING_STATUS | `DrivingStatusData(status=0)` — unrestricted |
| PARKING_BRAKE | `ParkingBrakeData(parkingBrake=true)` — always parked |
| LOCATION | Posts `"gb.xxy.hr.startGPS"` → triggers GPS forwarding from browser |
| SPEED | Posts `"gb.xxy.hr.startSpeed"` |
| NIGHT_MODE | Posts `"gb.xxy.hr.startNight"` |

### GPS from Browser

```json
{"action":"GPS","latitude":51.5,"longitude":-0.1,"accuracy":10,"altitude":0,"heading":0,"speed":0}
```

→ `LocationData(latitudeE7, longitudeE7, accuracyE3, altitudeE2, bearingE6, speedE3)`
→ SensorBatch on channel=2, messageType=32771

---

## 15. Memory Management & Buffer Pools

### Buffer Pool Hierarchy

| Pool | Buffer Sizes | Max Pool | Purpose |
|------|-------------|----------|---------|
| Message Read | 4B / 64B / 1KB / 64KB / 512KB | 8 each | AA message reading |
| Protocol Buffer | 8KB / 16KB | 10 / 20 | SSL encrypt / message framing |
| SSL Buffer | 512B / 2KB / 8KB / 16KB | 6 each | SSL decrypt |
| ProtocolMessage | N/A (object reuse) | 16 | Message instance pool |
| NAL Buffer | 8MB direct | 1 | Video frame reassembly |
| Audio Buffer | 512KB direct | 1 per server | Audio buffering |
| Metadata Buffer | 1MB direct | 1 | Media metadata assembly |

### Pre-allocation

- BufferPool: 2 of each size at startup
- ProtocolMessagePool: 3 messages pre-allocated
- SSL/Protocol pools: Lazy on first use

### Memory Thresholds

- **Warning:** 80% heap
- **Critical:** 90% heap or system `isLowMemory`
- On critical: `MemoryHelper.requestMemoryCleanup(true)`

### Manifest

```xml
android:largeHeap="true"
```

---

## 16. Error Handling & Reconnection

| Error | Handling |
|-------|---------|
| IOException (socket) | 10s timeout, message skipped, loop continues |
| SSLException | Logged, message skipped |
| Parse error (AIOOBE/IAE) | Logged with data length, message skipped |
| OutOfMemoryError | Stop service, toast, schedule restart in 3s |
| Fatal (Throwable) | Log "FATAL", stop MicActivity, stop service, rethrow |
| WebSocket disconnect | Video focus auto-disabled via `onClose()` |
| No browser PING (3s) | Video focus disabled |
| Keyframe failure | Toggle focus off → 500ms → on (fallback) |
| Video focus when !isVideoActive | Retry after 300ms |
| Service destroyed | Schedule restart via AlarmManager if `restartServiceOnDestroy=true` |

---

## 17. Billing & Subscription

### Plans

| Plan | Product ID | Base Plan | Type |
|------|-----------|-----------|------|
| Monthly | `taada_premium_monthly` | `monthly` | subs |
| Annual | `taada_premium_monthly` | `annual` | subs |
| Lifetime | `lifetime` | — | inapp |

### States

```
NO_SUBSCRIPTION → false
FREE_TRIAL      → true  (< 7 days from purchase)
SUBSCRIBED      → true
LIFETIME        → true
EXPIRED_IN_GRACE → true
SUSPENDED       → false
CANCELLED       → false
EXPIRED         → false
```

### Demo Mode

- Duration: 10 minutes
- Available only without subscription
- 1-second rearm cooldown
- On expiry: stops all services, shows subscription screen

---

## 18. UI Architecture

### Activities

| Activity | Purpose |
|----------|---------|
| `HomeActivity` | Main launcher, 5-tab BottomNav (no fragments, visibility toggle) |
| `MainActivity` | Advanced settings (developer mode only) |
| `SubscriptionActivity` | Paywall with 3 plan cards |
| `MicActivity` | Transparent mic recording |
| `LogActivity` | Log viewer |
| `AAVersionErrorActivity` | AA version mismatch |

### Developer Mode

7 taps on version text within 2 seconds → reveals settings button.

### Theme

Forced dark mode (`MODE_NIGHT_YES`). Fullscreen by default.

---

## 19. Telemetry & Analytics

- **Backend:** `https://telemetry.taada.top`
- **Auth:** DeviceRegistration with auth tokens
- **Storage:** Room database (`TelemetryDatabase`)
- **Sync:** `TelemetrySyncWorker` (periodic WorkManager)
- **Events:** APP_OPENED, SESSION_START, SESSION_END, AA_HANDSHAKE_SUCCESS, PURCHASE_*, DEMO_REARMED, etc.
- **Attribution:** MMP tracking for install/purchase attribution
- **Crash:** `LastBreathManager` for last-resort crash data
- **API:** `AnalyticsHttpClient` with `CircuitBreaker` pattern

---

## 20. Comparison: TaaDa vs SuperTeslaAndroidAuto

### Protocol Layer

| Aspect | TaaDa | SuperTeslaAndroidAuto | Winner |
|--------|-------|----------------------|--------|
| Handshake | Proven byte sequences, double AUTH_COMPLETE | TaaDa-style replication | TaaDa (battle-tested) |
| SSL mode | `clientMode=true` | Same | Tie |
| Version | 1.6 | Same | Tie |
| HU identity | "Google Desktop Head Unit" | Same | Tie |
| Channel opens | Always SUCCESS | Same | Tie |
| Heartbeat | 2s PingRequest | Same approach | Tie |
| Message framing | Custom framer with offset handling | AapFramer | Need to verify ours matches exactly |

### Video Pipeline

| Aspect | TaaDa | SuperTeslaAndroidAuto | Winner |
|--------|-------|----------------------|--------|
| Delivery format | Raw H.264 NAL → WebSocket binary | H.264 NAL → fMP4 → WebSocket | **TaaDa** (less overhead) |
| ACK model | Browser-driven (maxUnacked=1) | Server-side | **TaaDa** (flow control) |
| NAL reassembly | 8MB direct buffer, all fragment types | NalStreamManager (similar) | Tie |
| Keyframe request | Throttled 2s, fallback toggle | Direct request | **TaaDa** (throttle protects) |
| Focus timeout | 3s browser keepalive | None | **TaaDa** (prevents zombie streams) |
| Resolution | 8 presets (800×480 to 2560×1440) | Configurable | Tie |

### Audio Pipeline

| Aspect | TaaDa | SuperTeslaAndroidAuto | Winner |
|--------|-------|----------------------|--------|
| Default routing | BT A2DP (channels 5,7 omitted from SD) | All channels via AA | **TaaDa** (simpler, reliable) |
| Format | Raw PCM passthrough | PCM/AAC encoding | **TaaDa** (no encoding overhead) |
| ACK | Immediate server-side | N/A | **TaaDa** |
| Mic | Dedicated MicActivity + BT SCO | Through AA channel | **TaaDa** (dedicated handling) |

### Touch Pipeline

| Aspect | TaaDa | SuperTeslaAndroidAuto | Winner |
|--------|-------|----------------------|--------|
| Format | JSON + Binary (6 bytes/pointer) | JSON only | **TaaDa** (binary = lower latency) |
| Multi-touch | Full support (10 pointers) | Single touch mainly | **TaaDa** |
| Processing | Dedicated high-priority HandlerThread | Relay to AccessibilityService | **TaaDa** (optimized) |
| Coord mapping | Browser-side | Server-side | TaaDa (less work on phone) |

### Architecture

| Aspect | TaaDa | SuperTeslaAndroidAuto | Winner |
|--------|-------|----------------------|--------|
| State management | Static booleans + sync lock | FSM (AppStateManager) | **Ours** (explicit, debuggable) |
| DI | Manual singletons | Hilt | **Ours** (testable, modular) |
| Module structure | Monolithic | Multi-module | **Ours** (separation of concerns) |
| Memory management | Object pools + tiered buffers | Standard allocation | **TaaDa** (less GC pressure) |
| Language | Java | Kotlin | **Ours** (coroutines, null safety) |
| VPN strategy | Exclude AA (simpler) | Fake gateway | **TaaDa** (more elegant) |
| AA launch | Intent + Broadcast fallback + error screen | Intent only | **TaaDa** (more robust) |
| Browser player | External (hosted on web) | Embedded in assets | **Ours** (self-contained) |
| SSL certs | Dynamic update from server | Bundled only | **TaaDa** (no app update needed) |

### Stability Features

| Feature | TaaDa | SuperTeslaAndroidAuto |
|---------|-------|----------------------|
| OOM recovery (3s restart) | Yes | No |
| Memory monitoring (80%/90%) | Yes | No |
| Browser keepalive timeout (3s) | Yes | No |
| Keyframe throttle (2s) | Yes | No |
| Video focus retry (300ms) | Yes | No |
| Service auto-restart | Yes (AlarmManager) | No |
| BT auto-start | Yes (WifiReceiver) | No |
| Subscription guard | Yes | No |
| Demo mode (10min) | Yes | No |

---

## 21. Action Items: What to Adopt from TaaDa

### Priority 1 — Critical for Stability

1. **Switch to raw H.264 NAL passthrough** (drop fMP4 muxer for WebSocket delivery)
   - Send raw NAL units as binary WebSocket frames
   - Browser uses WebCodecs API to decode
   - Eliminates muxing overhead and complexity

2. **Implement browser-driven video ACKs** (maxUnacked=1)
   - Browser must send ACK after processing each frame
   - Prevents buffer bloat and flow control issues
   - Config response: `maxUnacked=1, status=STATUS_READY`

3. **Add 3-second browser keepalive timeout**
   - Browser sends PING every 1-2s
   - If no PING for 3s → disable video focus
   - Prevents zombie streams on browser crash/navigate-away

4. **Implement BT audio bypass**
   - Default: omit channels 5 (media) and 7 (guidance) from ServiceDiscovery
   - Let Bluetooth A2DP handle music/navigation audio
   - Only register channel 6 (system audio) for notifications

5. **Add memory management**
   - Object pool for ProtocolMessage (max 16, pre-allocate 3)
   - Tiered buffer pools (64B, 1KB, 64KB, 512KB)
   - Monitor heap utilization (80% warning, 90% critical)
   - OOM recovery: stop service, restart in 3s

### Priority 2 — Important for Robustness

6. **Add AA launch fallback** (broadcast for AA 16.4+)
   - Try WirelessStartupActivity first
   - Catch SecurityException → try WirelessStartupReceiver broadcast
   - Show error screen with AA version info on failure

7. **Implement keyframe request throttle** (max once per 2s)
   - Fallback: toggle video focus off → 500ms → on

8. **Add video focus retry** when `!isVideoActive` (300ms delay)

9. **Switch VPN strategy** to exclude-AA approach
   - `addDisallowedApplication("com.google.android.projection.gearhead")`
   - Simpler, more reliable than fake gateway

10. **Add binary touch protocol** (6 bytes per pointer)
    - Much lower latency than JSON
    - Support 10-finger multi-touch

### Priority 3 — Nice to Have

11. **Add BT auto-start** via `WifiReceiver` on ACL_CONNECTED
12. **Dynamic SSL certificate updates** from remote server
13. **Service auto-restart** on crash via AlarmManager
14. **Audio ACK on every frame** (immediate server-side, no browser involvement)
15. **Socket optimization**: `IPTOS_LOWDELAY`, 1MB buffers, `TCP_NODELAY`
16. **Double AUTH_COMPLETE** in handshake (before and after TLS)
17. **Mock Network(99999)** via Mockito for AA launch

### What NOT to Adopt

- EventBus (we have coroutines + Flow — better)
- Static boolean state management (our FSM is superior)
- Monolithic architecture (our multi-module is better)
- Java (Kotlin is better)
- Manual DI (Hilt is better)
- External player hosting (our embedded player is more self-contained)

---

*Generated from decompiled TaaDa 2.2.0 sources at `test/taada_extracted_2_2_0/`*
*Comparison with SuperTeslaAndroidAuto codebase as of 2026-03-17*
