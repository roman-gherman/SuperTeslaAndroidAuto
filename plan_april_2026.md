# SuperTesla Android Auto — April 2026 Plan

## Current State (April 6, 2026)

Working end-to-end: Phone → Cloud Run relay → Tesla browser

| Feature | Status |
|---------|--------|
| AA protocol (TLS, channels, handshake) | Working |
| Video streaming (30fps H.264 WebCodecs) | Working |
| Audio streaming (PCM Web Audio API) | Working |
| Touch input (letterbox-aware) | Working |
| Night mode sensor | Working |
| Cloud relay (GCP Cloud Run) | Working |
| Permanent room URL | Working |
| Pairing codes | Backend ready, no UI yet |

**Relay URL**: `https://supertesla-relay-289625450505.europe-west1.run.app`

---

## Priority 1: Tesla Validation

- [ ] Test Cloud Run relay URL on actual Tesla browser
- [ ] Measure latency (video delay, touch responsiveness)
- [ ] Test audio quality and sync
- [ ] Test reconnection (phone lock/unlock, Tesla sleep/wake)
- [ ] Verify WebCodecs works on Tesla's Chromium 109

## Priority 2: Custom Domain

- [ ] Buy domain (e.g., `supertesla.app` or `play.supertesla.com`)
- [ ] Configure Firebase Hosting with custom domain (free SSL)
- [ ] Update `AppConfig.PLAYER_BASE_URL` and relay URLs
- [ ] Result: `play.supertesla.com/r7k3` — short, memorable Tesla bookmark

## Priority 3: App Polish

- [ ] Remove NET-TEST diagnostic code from `App.kt`
- [ ] Add "Tesla URL" card to main screen (copyable, with QR code)
- [ ] Add pairing code UI (generate button, display 4-digit code)
- [ ] Add relay connection status indicator (connected/disconnected/reconnecting)
- [ ] Show notification with Tesla URL when streaming
- [ ] Handle relay disconnect gracefully (auto-reconnect, status message to Tesla)

## Priority 4: Performance Optimization

- [ ] Measure and reduce relay latency (currently phone→GCP→browser adds ~30-50ms)
- [ ] Consider deploying Cloud Run in multiple regions (auto-route to nearest)
- [ ] Optimize video ACK flow (currently server-side ACK on every frame)
- [ ] Reduce audio chunk size for lower latency
- [ ] Add adaptive bitrate based on relay throughput

## Priority 5: Audio Improvements

- [ ] Fix audio focus conflict between Tesla's native Spotify and AA audio
- [ ] Add volume control in browser UI
- [ ] Handle audio codec config changes (sample rate, channels)
- [ ] Test Waze navigation voice prompts through relay

## Priority 6: Reliability

- [ ] Add heartbeat/keepalive between phone and relay (detect stale connections)
- [ ] Handle Cloud Run cold starts (first request after idle takes ~2-5s)
  - Option: set `min-instances=1` ($10/month for always-on)
  - Option: add "connecting..." splash while container warms up
- [ ] Handle phone network changes (WiFi ↔ mobile data) without dropping relay
- [ ] Persist relay connection across AA reconnects
- [ ] Add Sentry/Crashlytics for production error monitoring

## Priority 7: Security Hardening

- [ ] Rate limit room registration (prevent abuse)
- [ ] Add room expiry (delete unused rooms after 30 days)
- [ ] Add WebSocket message size limits on relay
- [ ] Consider end-to-end encryption (relay can't inspect video/audio)
- [ ] Add CORS headers to relay (restrict to player domain only)

## Priority 8: Production Release

- [ ] Create release signing key
- [ ] Set up Play Store listing (screenshots, description)
- [ ] Add privacy policy and terms of service
- [ ] Set up Firebase Analytics
- [ ] Create landing page / marketing site
- [ ] Beta test with 5-10 Tesla owners
- [ ] Submit to Play Store

## Priority 9: Future Features

- [ ] Direct connection mode (bypass relay when on same network — for non-Android 16)
- [ ] Multiple video quality profiles (720p, 480p for slow connections)
- [ ] Screen recording / screenshot from browser
- [ ] Google Assistant integration (mic from Tesla → phone)
- [ ] Steering wheel button support
- [ ] CarPlay support (separate project)

---

## Technical Debt

- [ ] Remove VPN code (dual VPN trick not needed with relay)
- [ ] Remove NativeProxyLauncher (not needed with relay)
- [ ] Remove DuckDNS updater (not needed with relay)
- [ ] Remove legacy 3-port WebSocket servers (ControlSocketServer, MediaSocketServer)
- [ ] Clean up IPv4 proxy code from WebServer.kt
- [ ] Unify player.js (relay/public/ and web/src/main/assets/ are diverging copies)
- [ ] Add proper error handling in CloudRelayClient (distinguish network errors from auth errors)
- [ ] Add unit tests for relay server (room management, pairing codes)
- [ ] Add integration test: phone → relay → browser (automated)

---

## Architecture Notes

### Why Cloud Relay (not direct connection)?
Android 16 (OnePlus, possibly others) blocks inbound TCP connections from hotspot clients to app-UID sockets. Shell-UID sockets (adb nc) work, app-UID sockets don't. This is a per-UID iptables restriction. The relay bypasses this by making both phone and Tesla connect outbound.

### Why not Cloudflare Workers?
Durable Objects pricing ($0.15/M requests) is too expensive for 30fps video streaming (~2.6M msgs/day per user = $24/month per user). Cloud Run's flat pricing (~free for low usage) is much better.

### Key Discovery: Socket Type Matters
`java.net.Socket()` on Android 16 creates IPv6 dual-stack sockets that timeout when IPv6 is unreachable. `HttpsURLConnection` handles IPv4/IPv6 fallback correctly. The relay client uses `HttpsURLConnection.getDefaultSSLSocketFactory()` for reliable connections.

### Binary Protocol
```
0x00 + H.264 NAL = video
0x01 + PCM 48kHz stereo = media audio
0x02 + PCM 16kHz mono = speech audio
0x03 + PCM 16kHz mono = system audio
Text JSON = control/touch (START, STOP, ACK, PING, CONFIG, MULTITOUCH_*)
```
