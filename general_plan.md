# SuperTeslaAndroidAuto - Architecture & Implementation Plan

## Context

Tesla vehicles don't natively support Android Auto. Apps like **Taada**, **TeslAA**, and **TeslaMirror** solve this by running a local web server on the Android phone, connecting the Tesla to the phone's WiFi hotspot, and streaming the Android Auto UI as video to Tesla's built-in Chromium browser. This project replicates and improves upon this approach in Kotlin.

**Problem:** No native Android Auto in Tesla.
**Solution:** Phone acts as both the Android Auto head unit AND a streaming server. Tesla browser is the remote display.

---

## System Architecture

```
                        WiFi Hotspot
  +-----------------+  (phone = gateway)  +------------------+
  |  Android Phone  | <=================> |  Tesla Browser   |
  |                 |                     |  (Chromium ~v143) |
  | [AA Head Unit]  |  -- H.264 video --> |  [Web Frontend]  |
  | [Video Encoder] |  -- Audio stream -> |  [JS Player]     |
  | [Ktor Server]   |  <-- Touch events - |  [Touch Overlay]  |
  | [VPN Service]   |                     +------------------+
  +-----------------+
```

**Key insight:** The app does NOT use `MediaProjection` / screen capture. It receives H.264 directly from Android Auto's head unit protocol, which is a major advantage (no screen capture permission needed).

### Data Flow
1. Phone creates WiFi hotspot; Tesla connects
2. `VpnService` assigns virtual IP `240.3.3.3` (Class E, non-private) to bypass Tesla's browser blocking of RFC 1918 IPs
3. App starts Android Auto Head Unit Server (`localhost:5277`)
4. AA emulator connects via TLS, negotiates video/audio/input channels (AAP protobuf protocol)
5. AA sends H.264 video frames to emulator
6. Ktor web server packages H.264 as fMP4 segments (MSE) or WebRTC
7. Tesla browser navigates to `http://240.3.3.3:8080`, plays video
8. Touch events sent back via WebSocket, translated to AAP input messages

---

## Module Structure

```
:app          -> Main Android app (Hilt DI, Compose UI, foreground service)
:core         -> Shared models, utils, config
:network      -> VpnService, hotspot mgmt, Ktor web server, WebSocket, WebRTC signaling
:androidauto  -> AAP protocol: TLS, channel mux, protobuf messages, head unit emulator
:streaming    -> H.264 NAL parsing, fMP4 muxer, MJPEG fallback, AAC audio encoding
:web          -> Static assets served to Tesla (HTML/JS/CSS)
```

---

## Key Components

| Component | Responsibility | Critical File |
|---|---|---|
| **MainService** | Foreground service orchestrating VPN + hotspot + server + AA | `app/.../service/MainService.kt` |
| **VpnTunnelService** | Assigns virtual IP (240.3.3.3) via TUN interface, no traffic interception | `network/.../vpn/VpnTunnelService.kt` |
| **HotspotManager** | Manages WiFi hotspot, detects Tesla connection | `network/.../hotspot/HotspotManager.kt` |
| **WebServer (Ktor)** | HTTP server on 240.3.3.3:8080 serving frontend + streams | `network/.../webserver/WebServer.kt` |
| **AAHeadUnitEmulator** | Connects to AA service on :5277, TLS handshake, channel negotiation | `androidauto/.../headunit/AAHeadUnitEmulator.kt` |
| **FragmentedMp4Muxer** | Wraps H.264 NAL units into fMP4 segments for MSE playback | `streaming/.../video/FragmentedMp4Muxer.kt` |
| **TouchInputRelay** | WebSocket -> coordinate transform -> AAP InputEvent protobuf | `network/.../websocket/TouchInputRelay.kt` |
| **Web Frontend** | Auto-detects browser caps, plays video, captures touch | `web/assets/player.js, touch.js` |

---

## Video Streaming Pipeline

```
AA Service (H.264 NAL units via AAP, localhost:5277)
  |
  v
AAHeadUnitEmulator (parse NAL: SPS/PPS/IDR/P-frames)
  |
  +---> WebRTC: feed into PeerConnection video track (lowest latency <100ms)
  +---> MSE/fMP4: mux into ftyp+moov init + moof+mdat segments, send via WebSocket (<200ms)
  +---> MJPEG: decode H.264 -> Bitmap -> JPEG, multipart HTTP stream (fallback, <300ms)
```

**Browser auto-detection order:** WebRTC -> MSE (avc1.42E01E) -> MJPEG

---

## Networking: VPN Virtual IP

Tesla browser blocks `192.168.x.x`, `10.x.x.x`, `172.16-31.x.x`. Solution:

```kotlin
// VpnTunnelService
Builder()
  .setSession("SuperTeslaAA")
  .addAddress("240.3.3.3", 32)       // Class E - not blocked by Tesla
  .addRoute("192.168.43.0", 24)      // Hotspot subnet
  .setMtu(1500)
  .establish()
// No traffic interception - just makes 240.3.3.3 a valid local address
```

**Fallback IPs to test:** `100.99.9.9` (CGNAT), `198.18.0.1` (benchmark)
**DNS approach:** Resolve a domain (e.g., `app.supertesla.local`) to the virtual IP

---

## Touch Input (Reverse Channel)

```
Tesla Browser (Pointer Events) -> WebSocket JSON -> Ktor handler
  -> coordinate normalize (0.0-1.0 -> AA resolution)
  -> AAP InputEvent protobuf -> AA input channel
```

Touch throttled to 60fps via `requestAnimationFrame` in browser.

---

## Technology Stack

| Layer | Choice |
|---|---|
| Language | Kotlin 1.9+ |
| Build | Gradle Kotlin DSL + version catalogs |
| DI | Hilt |
| UI (phone) | Jetpack Compose |
| Concurrency | Coroutines + Flow |
| Web server | Ktor (embedded Netty) |
| WebRTC | Google WebRTC Android SDK (`org.webrtc`) |
| AA protocol | Custom Kotlin (based on reverse-engineered AAP) |
| Protobuf | protobuf-kotlin-lite |
| Serialization | kotlinx-serialization |
| Logging | Timber |

---

## Implementation Phases

### Phase 1: Foundation (MVP networking)
- Multi-module Gradle project setup with all dependencies
- `VpnTunnelService` with 240.3.3.3 assignment
- `HotspotManager` (manual hotspot for now)
- Basic Ktor server serving hello page
- `MainService` foreground service
- Compose UI: start/stop, status display
- **Verify:** Tesla browser reaches `http://240.3.3.3:8080`

### Phase 2: Android Auto Protocol
- Protobuf message definitions (AAP)
- TLS handshake + AAP message framing (Kotlin SSLSocket)
- Channel multiplexer (video/audio/input/sensor)
- `AAHeadUnitEmulator`: connect, negotiate, receive H.264
- **Verify:** Display AA UI on phone via local MediaCodec decode

### Phase 3: Video Streaming to Browser
- H.264 NAL unit parser
- `FragmentedMp4Muxer` (minimal ISO BMFF)
- MSE streaming via WebSocket binary frames
- MJPEG fallback
- Web frontend with player.js (capability detection + playback)
- **Verify:** Tesla browser shows live Android Auto UI

### Phase 4: Touch Input
- `touch.js` with Pointer Events
- WebSocket touch handler
- Coordinate mapping + AAP InputEvent construction
- **Verify:** Tapping map in Tesla browser triggers navigation

### Phase 5: Audio
- PCM extraction from AA audio channel
- AAC encoding via MediaCodec
- Mux audio into fMP4 stream
- Web Audio API playback
- **Verify:** Spotify playback audible through Tesla browser

### Phase 6: WebRTC (Advanced)
- Google WebRTC SDK integration
- Signaling endpoint + SDP exchange
- H.264 passthrough to WebRTC video track
- Audio via WebRTC Opus
- **Verify:** <100ms latency confirmed

### Phase 7: Polish
- Setup wizard UI
- Auto-reconnection
- Adaptive bitrate
- Battery optimization
- Error handling + diagnostics panel (`/debug`)
- Multi-Android-version testing

---

## Risk Mitigation

| Risk | Impact | Mitigation |
|---|---|---|
| Tesla blocks chosen IP range | High | Test 240.3.3.3, 100.99.9.9, 198.18.0.1; DNS-based fallback |
| AA protocol changes | High | Protocol stable for years; pin AA app version |
| Tesla firmware breaks codecs | Medium | 3 streaming modes (WebRTC/MSE/MJPEG) as fallbacks |
| H.264 into WebRTC difficulty | Medium | MSE works first; WebRTC is Phase 6 enhancement |
| Hotspot API restrictions (Android 13+) | Medium | Use LocalOnlyHotspot API; manual enable fallback |
| Battery drain | Low | Hardware MediaCodec encoding; USB charging while driving |

---

## Verification Plan

1. **Unit tests:** Protobuf serialization, NAL parser, fMP4 muxer, coordinate mapping
2. **Integration test:** End-to-end on physical phone + Tesla (or Tesla browser emulator)
3. **Manual test matrix:** MCU2 (Intel Atom) + MCU3 (AMD Ryzen) x 3 streaming modes
4. **Latency measurement:** Timestamp overlay in AA -> measure in Tesla browser frame
5. **Network resilience:** Test reconnection after WiFi drops, browser refresh

---

## Key References

- [Taada App](https://taada.top/) - Commercial reference implementation
- [TeslaMirror FAQ](https://teslamirror.com/faq.html) - VPN/virtual IP architecture details
- [AACS (Android Auto Server)](https://github.com/tomasz-grobelny/AACS) - Open-source AAP implementation (C++)
- [AAP Protocol Research](https://milek7.pl/.stuff/galdocs/readme.md) - Reverse-engineered protocol docs
- [InCarWeb](https://incarweb.app/) - Tesla browser capabilities reference
- [Android Auto DHU](https://developer.android.com/training/cars/testing/dhu) - Official head unit testing docs
