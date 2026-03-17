# Network Architecture — How Tesla Connects to the Phone

## Current Setup (Option 3: DuckDNS)

### Prerequisites
1. Phone has WiFi hotspot enabled
2. Tesla is connected to the phone's WiFi hotspot
3. DuckDNS token is set in Settings → Network

### Flow
```
┌──────────┐     WiFi Hotspot      ┌──────────────┐
│  Tesla   │ ◄──────────────────► │    Phone     │
│ Browser  │  192.168.43.x        │ (gateway)    │
└────┬─────┘                      │ 192.168.43.1 │
     │                            └──────┬───────┘
     │ DNS: supertesla.duckdns.org       │
     │ → 192.168.43.1 (updated on start) │
     │                                   │
     │ HTTP GET                          │
     │ supertesla.duckdns.org:8080 ──────► Ktor WebServer (:8080)
     │   ◄── index.html + player.js      │   serves HTML player
     │                                   │
     │ WebSocket                         │
     │ ws://192.168.43.1:8080/ws ────────► WebSocket endpoint
     │   ◄── H.264 video frames          │   raw Annex B NALs
     │   ──► touch events (JSON)         │
     │                                   │
     │                    ┌──────────────┤
     │                    │ AA Emulator  │
     │                    │ port 5288    │
     │                    │ (localhost)  │
     │                    └──────────────┘
```

### Step-by-Step
1. User taps START in SuperTesla app
2. Pipeline detects hotspot gateway IP (e.g., `192.168.43.1`)
3. DuckDNS API called: `supertesla.duckdns.org → 192.168.43.1`
4. VPN started (excludes AA package)
5. WebSocket servers + Ktor web server started on port 8080
6. Android Auto launched via broadcast → connects to localhost:5288
7. User opens `http://supertesla.duckdns.org:8080` in Tesla browser
8. Browser loads player, connects WebSocket, video streams

### Limitations
- DuckDNS update takes a few seconds to propagate
- TTL is 60s so DNS caches may serve stale IP briefly
- If hotspot IP changes, need to restart service
- Phone must be the WiFi hotspot (Tesla connects to it)

---

## Future Setup (Option 4: External Hosted Player — TaaDa Architecture)

### How TaaDa Does It
TaaDa hosts their video player on `app.taada.top` (a regular web server / CDN).
The phone does NOT serve HTML — it only runs:
- HTTPS config API on port 8081 (returns JSON with WebSocket port)
- WSS WebSocket servers on random ports (8090-9998) for video/audio/touch

### Flow
```
┌──────────┐                        ┌───────────────┐
│  Tesla   │ ── HTTPS ──────────► │  CDN / Server  │
│ Browser  │    app.taada.top      │ (static HTML)  │
└────┬─────┘                        └───────────────┘
     │                                     │
     │ ◄── index.html + player.js ─────────┘
     │     (hosted externally)
     │
     │  WiFi Hotspot
     │ ◄──────────────────────────► ┌──────────────┐
     │                              │    Phone     │
     │ HTTPS GET                    │ (gateway)    │
     │ https://<gateway>:8081 ──────► Config API    │
     │   ◄── {"port":8453,...}      │              │
     │                              │              │
     │ WSS                          │              │
     │ wss://<gateway>:8453 ────────► ControlSocket │
     │   ◄── H.264 video            │              │
     │   ──► touch events           │              │
     │                              └──────────────┘
```

### Key Differences from Option 3
| Aspect | Option 3 (DuckDNS) | Option 4 (External Host) |
|--------|-------------------|-------------------------|
| HTML served by | Phone (Ktor :8080) | External CDN/server |
| Domain points to | Phone's hotspot IP | CDN (e.g., Vercel, GitHub Pages) |
| DNS update needed | Yes (DuckDNS API on each start) | No |
| WebSocket connects to | Same host as HTML | Phone's gateway IP (auto-discovered) |
| SSL certs | None (HTTP) | Needed for WSS (dynamic cert from server) |
| Phone gateway discovery | Not needed (same host) | JS discovers via gateway probe or ?ip= param |

### Implementation Plan for Option 4

#### Phase 1: Static hosting
1. Host player files on Vercel/Netlify/GitHub Pages at `app.supertesla.dev` (or similar)
2. Player JS auto-discovers phone gateway IP (already implemented via `getServerHost()`)
3. No changes needed on phone side — Ktor web server still works as fallback

#### Phase 2: HTTPS config endpoint (TaaDa-style)
1. Add HTTPS server on port 8081 with self-signed or dynamic cert
2. Config endpoint returns: `{width, height, port, resolution, usebt}`
3. Player fetches config to get the WebSocket port
4. Dynamic SSL certs downloaded from a cert server (like TaaDa's cert.taada.top)

#### Phase 3: WSS (Secure WebSocket)
1. WebSocket servers use WSS instead of WS
2. Use `DefaultSSLWebSocketServerFactory` from java-websocket library
3. Certificate shared between HTTPS config server and WSS servers
4. Browser trusts the cert (either public CA or user-accepted self-signed)

#### Phase 4: Production domain
1. Register domain (e.g., `supertesla.app`)
2. Host player on CDN with the domain
3. HTTPS everywhere (Let's Encrypt for CDN, dynamic certs for phone)
4. No DuckDNS, no IP configuration, no user setup

### Gateway IP Auto-Discovery (already implemented)
The player JS (`player.js`) discovers the phone's IP via:
1. `?ip=` URL parameter (explicit)
2. `location.host` if served from phone (same-origin)
3. Default `192.168.43.1` (Android hotspot default)

For production (Option 4), add:
4. Probe common gateway IPs: `192.168.43.1`, `192.168.1.1`, `172.20.10.1` (iOS)
5. Use WebRTC STUN to discover local IP
6. mDNS: `supertesla.local` (already registered)
