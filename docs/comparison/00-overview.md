# Comparison Overview: TaaDa 2.2.0 vs SuperTeslaAndroidAuto

## Document Index

Each document below is an isolated, testable implementation task. Work through them in order — each builds on the previous but can be tested independently.

| # | Document | Area | Priority | Effort |
|---|----------|------|----------|--------|
| 01 | [Cleanup & Dead Code](01-cleanup-dead-code.md) | Architecture | Critical | Small |
| 02 | [VPN Strategy](02-vpn-strategy.md) | Network | Critical | Medium |
| 03 | [AA Launch & Fallbacks](03-aa-launch-fallbacks.md) | Protocol | Critical | Small |
| 04 | [ServiceDiscovery Response](04-service-discovery.md) | Protocol | Critical | Medium |
| 05 | [Video Pipeline: Raw NAL](05-video-raw-nal.md) | Streaming | Critical | Large |
| 06 | [Video ACK & Flow Control](06-video-ack-flow.md) | Protocol | Critical | Medium |
| 07 | [Audio: BT Bypass](07-audio-bt-bypass.md) | Audio | High | Medium |
| 08 | [Touch: Binary Protocol & Multi-touch](08-touch-binary-multitouch.md) | Input | High | Medium |
| 09 | [Browser Keepalive & Video Focus](09-keepalive-video-focus.md) | Stability | High | Small |
| 10 | [Memory Management & Pooling](10-memory-pooling.md) | Performance | High | Large |
| 11 | [Error Handling & Recovery](11-error-recovery.md) | Stability | High | Medium |
| 12 | [HTTPS Config Endpoint](12-https-config-endpoint.md) | Network | Medium | Medium |
| 13 | [Bluetooth Auto-Start](13-bluetooth-autostart.md) | UX | Medium | Medium |
| 14 | [Sensor Channel](14-sensor-channel.md) | Protocol | Medium | Small |
| 15 | [Settings & Configuration](15-settings-configuration.md) | UI | Medium | Medium |
| 16 | [SSL/TLS Hardening](16-ssl-tls.md) | Security | Medium | Medium |

## Current State Summary

### What Works in Our App
- AA headunit emulator on port 5288 (handshake, TLS, channel mux)
- Video receive via VideoChannelHandler with SharedFlow
- Audio receive (3 channels: media, system, speech)
- Ktor web server serving HTML/JS player
- WebSocket video delivery (raw Annex B H.264)
- Touch relay (JSON format, TaaDa MULTITOUCH format)
- Hotspot detection and monitoring
- VPN tunnel service (exists but never called)
- Tesla Bluetooth detection receiver
- Setup wizard UI (Compose)

### Critical Issues Found
1. **MainService is dead code** — not in AndroidManifest, entire screen-capture pipeline unreachable
2. **VPN never started** by TransporterService — `startVpn()` exists but is never called
3. **No video ACKs** sent to AA — AA may throttle/stop sending video
4. **Audio channels 5,7 always registered** — should be omittable when BT audio active
5. **No browser keepalive timeout** — zombie streams possible
6. **No memory pooling** — GC pressure under load
7. **SSLEngine not thread-safe** — encrypt/decrypt called from different coroutines
8. **MediaSetupResponse field 1 = 2** — possibly wrong (should be 0 for STATUS_OK)
9. **No keyframe throttle** — could flood AA with requests
10. **Voice WebSocket server started but never fed data**
