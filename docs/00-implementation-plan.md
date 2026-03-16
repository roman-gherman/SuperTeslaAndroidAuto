# SuperTeslaAndroidAuto — Implementation Plan

## Goal

Replicate TaaDa's architecture: act as a **fake Android Auto head unit**, receive AA's native video/audio/input streams, and relay them to Tesla's browser via WebSocket. This gives us car-optimized Waze/Maps/media UI for free — Android Auto does all the rendering.

## Architecture Overview

```
┌──────────────────────────────────────────────────────────┐
│                    Android Phone                          │
│                                                          │
│  ┌─────────────┐    ┌──────────────────────────────────┐ │
│  │ Android Auto │───▶│ SuperTesla TransporterService    │ │
│  │ (Gearhead)  │    │                                  │ │
│  │             │◀───│  Port 5288 (ServerSocket)        │ │
│  │  Renders:   │    │  ┌───────────────────────────┐   │ │
│  │  - Waze     │    │  │ AA Protocol Handler       │   │ │
│  │  - Maps     │    │  │ - SSL/TLS Handshake       │   │ │
│  │  - Media    │    │  │ - Service Discovery       │   │ │
│  │  - Phone    │    │  │ - Channel Mux/Demux       │   │ │
│  └─────────────┘    │  └───────────┬───────────────┘   │ │
│                     │              │                    │ │
│                     │  ┌───────────▼───────────────┐   │ │
│                     │  │ NalStreamManager          │   │ │
│                     │  │ (H.264 NAL processing)    │   │ │
│                     │  └───────────┬───────────────┘   │ │
│                     │              │                    │ │
│                     │  ┌───────────▼───────────────┐   │ │
│                     │  │ 3x WebSocket Servers      │   │ │
│                     │  │ Port N  : Video + Control  │   │ │
│                     │  │ Port N+1: Media Audio      │   │ │
│                     │  │ Port N+2: Voice Audio      │   │ │
│                     │  └───────────┬───────────────┘   │ │
│                     └──────────────┼────────────────────┘ │
│                                    │                      │
│  ┌─────────────┐    ┌─────────────▼─────────┐            │
│  │ VPN Service │    │ HTTPS WebServer       │            │
│  │ (excludes   │    │ Port 8081             │            │
│  │  AA pkg)    │    │ Serves HTML/JS player │            │
│  └─────────────┘    └───────────────────────┘            │
└──────────────────────────────────────────────────────────┘
          │ WiFi Hotspot
          ▼
┌──────────────────┐
│  Tesla Browser   │
│  - Connects to   │
│    phone hotspot  │
│  - Opens URL     │
│  - Receives H.264│
│    via WebSocket  │
│  - Sends touch   │
│    events back    │
└──────────────────┘
```

## Phases

| Phase | Description | Priority | Dependency |
|-------|-------------|----------|------------|
| **Phase 1** | AA Protocol ServerSocket & Handshake | Critical | None |
| **Phase 2** | Video Pipeline (AA → NAL → WebSocket) | Critical | Phase 1 |
| **Phase 3** | Touch Input (Browser → AA Protocol) | Critical | Phase 1 |
| **Phase 4** | WebSocket Relay Servers (3-port architecture) | Critical | Phase 2 |
| **Phase 5** | VPN with AA Package Exclusion | High | Phase 1 |
| **Phase 6** | Audio Streaming (Media + Voice) | Medium | Phase 1, 4 |
| **Phase 7** | Bluetooth Auto-Start & Service Lifecycle | Medium | Phase 1 |

## Current State

Our `androidauto/` module already has a **complete AAP protocol stack**:
- `AapMessages.kt` — all message types + ProtoEncoder (100%)
- `AapFramer.kt` — frame encoding/decoding (100%)
- `AapCrypto.kt` — TLS 1.2 handshake (100%)
- `ChannelMux.kt` — multiplexer with fragmentation (100%)
- All channel handlers — Control, Video, Audio, Input, Sensor (100%)
- `AAHeadUnitEmulator.kt` — handshake state machine (100%)
- `AALauncher.kt` — wireless projection launch (100%)

**The protocol layer is done. What's missing is the integration: wiring it into a TransporterService, adding the WebSocket relay, and connecting touch/video pipelines.**

## Key Differences from Current Approach

| Current (Screen Mirror) | Target (AA Protocol Relay) |
|--------------------------|---------------------------|
| MediaProjection captures phone screen | AA sends its own H.264 video |
| AccessibilityService injects touch | Touch events sent via AA protocol |
| Shows whatever is on phone screen | Shows AA car-optimized UI |
| Single WebSocket for everything | 3 WebSocket servers (video/audio/voice) |
| No AA protocol involvement | Full AA protocol handshake & relay |
| VPN routes everything | VPN excludes AA package |

## File Reference

- [Phase 1: AA Protocol & Handshake](./01-phase-aa-protocol-handshake.md)
- [Phase 2: Video Pipeline](./02-phase-video-pipeline.md)
- [Phase 3: Touch Input](./03-phase-touch-input.md)
- [Phase 4: WebSocket Relay Servers](./04-phase-websocket-servers.md)
- [Phase 5: VPN Configuration](./05-phase-vpn-configuration.md)
- [Phase 6: Audio Streaming](./06-phase-audio-streaming.md)
- [Phase 7: Bluetooth Auto-Start](./07-phase-bluetooth-autostart.md)
