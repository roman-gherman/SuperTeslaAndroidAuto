# Phase 4: WebSocket Relay Servers (3-Port Architecture)

## Overview

TaaDa runs **three separate WebSocket servers** on sequential ports to relay video, audio, and voice data from the AA protocol to the Tesla browser. Each server has a distinct role and message format.

## What TaaDa Does (Exact Implementation)

### 1. Port Assignment

```java
// TransporterService.onStartCommand()
int webServerPort = new Random().nextInt(1908) + 8090;
// Range: 8090 to 9998

ControlSocketServer controlServer = new ControlSocketServer(webServerPort);
MediaSocketServer  audioServer   = new MediaSocketServer(webServerPort + 1);
MediaSocketServer  voiceServer   = new MediaSocketServer(webServerPort + 2);
```

### 2. SSL Configuration (All WebSocket Servers)

All three servers use SSL/TLS via `DefaultSSLWebSocketServerFactory`:
```java
SSLContext sslContext = SSLContext.getInstance("TLS");
KeyStore keyStore = KeyStore.getInstance("PKCS12");
keyStore.load(context.getResources().openRawResource(R.raw.server_pbe), "aa".toCharArray());

KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
kmf.init(keyStore, "aa".toCharArray());
sslContext.init(kmf.getKeyManagers(), trustAllCerts, null);

server.setWebSocketFactory(new DefaultSSLWebSocketServerFactory(sslContext));
```

### 3. ControlSocketServer (Port N — Video + Control)

This is the main server handling both video output and control input.

#### Inbound Messages (Browser → Server)

**JSON Text Messages:**

| Action | Description | Handler |
|--------|-------------|---------|
| `START` | Browser ready for video | `toggleVideoFocus(true)` |
| `STOP` | Browser pausing video | `toggleVideoFocus(false)` |
| `RELOAD` | Browser wants fresh stream | focus OFF → 100ms → focus ON |
| `REQUEST_KEYFRAME` | Request I-frame | `requestKeyFrame()` with 2000ms debounce |
| `PING` | Keep-alive | Respond with 5-byte binary `{0,0,0,0,31}`, schedule focus toggle after 3s |
| `MULTITOUCH_DOWN` | Finger down | `processMultiTouchEvent(ACTION_DOWN, ...)` |
| `MULTITOUCH_MOVE` | Finger move | `processMultiTouchEvent(ACTION_MOVED, ...)` |
| `MULTITOUCH_UP` | Finger up | `processMultiTouchEvent(ACTION_UP, ...)` |
| `MULTITOUCH_CANCEL` | Touch cancelled | `processMultiTouchEvent(ACTION_UP, ...)` |
| `GPS` | Location update | Send LocationData to AA sensor channel |
| `NIGHT` | Night mode | Send NightModeData to AA sensor channel |
| `ACK` | Client ack | Log acknowledgment |

**Binary Messages:**
- Binary touch events via `BinaryTouchDecoder` (see Phase 3)

#### Outbound Messages (Server → Browser)

**Binary frames only:**
- H.264 NAL units from `NalStreamManager.process()`
- Sent as-is via `WebSocket.send(ByteBuffer)`

#### Connection Lifecycle

```java
onOpen(WebSocket ws) {
    Thread.sleep(1000);  // Wait 1 second for client to stabilize
    currentClient = ws;
    toggleVideoFocus(false);  // Reset focus state
}

onClose(WebSocket ws, int code, String reason) {
    toggleVideoFocus(false);  // Stop video when client leaves
    logEvent(STREAM_STOPPED);
}

onError(WebSocket ws, Exception ex) {
    ws.close(1011);  // Internal error
    logEvent(STREAM_ERROR);
}
```

### 4. MediaSocketServer (Port N+1 — Media Audio)

Simpler server that only sends binary audio data:

```java
// Audio data buffering
ByteBuffer audioBuffer = ByteBuffer.allocate(524288);  // 512KB

void sendAudioData(byte[] data, boolean shouldBuffer) {
    if (!shouldBuffer) {
        // Send immediately
        currentClient.send(ByteBuffer.wrap(data));
    } else {
        // Buffer until full or flush requested
        if (audioBuffer.position() + data.length < 1048576) {  // 1MB limit
            audioBuffer.put(data);
        } else {
            audioBuffer.flip();
            currentClient.send(audioBuffer);
            audioBuffer.clear();
        }
    }
}
```

#### Connection Lifecycle

```java
onOpen(WebSocket ws) {
    Thread.sleep(1000);
    currentClient = ws;
}
onMessage(String) { /* unexpected, log warning */ }
onMessage(ByteBuffer) { /* unexpected, log warning */ }
onClose(WebSocket ws, int code, String reason) { /* log */ }
```

### 5. VoiceSocketServer (Port N+2 — Voice/Mic Audio)

Identical to MediaSocketServer, used for voice/microphone data:
- Receives mic audio from browser (future)
- Sends voice recognition audio to browser (future)

### 6. HTTPS Web Server (Port 8081)

TaaDa also runs an HTTPS server that serves the HTML/JS player:

```java
// WebServerInitializer
// Tries ports: 8081, 8082, 8083, 8084, 8085
SSLServerSocket serverSocket = sslContext.getServerSocketFactory()
    .createServerSocket(port);
```

Serves the web UI that connects to the WebSocket servers.

## What We Already Have

| Component | File | Status |
|-----------|------|--------|
| Web server | `network/webserver/WebServer.kt` | Complete — Ktor on port 8080 |
| Video WebSocket | `WebServer.kt` `/ws` route | Complete — unified WS |
| Touch WebSocket | `websocket/TouchInputRelay.kt` | Complete — in same WS |
| Video handler | `webserver/VideoStreamHandler.kt` | Complete — fMP4 streaming |
| Audio handler | `webserver/AudioStreamHandler.kt` | Stubbed |

## What Needs to Change

### 1. Create ControlSocketServer

New dedicated WebSocket server for video + control:

```kotlin
class ControlSocketServer(
    private val port: Int,
    private val sslContext: SSLContext,
    private val nalStreamManager: NalStreamManager,
    private val touchHandler: (TouchEvent) -> Unit,
    private val sensorHandler: (SensorEvent) -> Unit
) {
    private var server: WebSocketServer? = null
    private var currentClient: WebSocket? = null

    fun start() {
        server = object : WebSocketServer(InetSocketAddress(port)) {
            // SSL factory
            // onOpen, onClose, onMessage, onError handlers
        }
        server?.start()
    }

    fun sendVideoFrame(frame: ByteBuffer) {
        currentClient?.send(frame)
    }

    private fun handleAction(action: String, json: JSONObject) {
        when (action) {
            "START" -> nalStreamManager.toggleVideoFocus(true)
            "STOP" -> nalStreamManager.toggleVideoFocus(false)
            "RELOAD" -> { /* focus off, delay, focus on */ }
            "REQUEST_KEYFRAME" -> nalStreamManager.requestKeyFrame()
            "PING" -> sendPingResponse()
            "MULTITOUCH_DOWN" -> processTouch(ACTION_DOWN, json)
            "MULTITOUCH_MOVE" -> processTouch(ACTION_MOVED, json)
            "MULTITOUCH_UP" -> processTouch(ACTION_UP, json)
            "GPS" -> forwardGps(json)
            "NIGHT" -> forwardNightMode(json)
        }
    }
}
```

### 2. Create MediaSocketServer

```kotlin
class MediaSocketServer(
    private val port: Int,
    private val sslContext: SSLContext
) {
    private var currentClient: WebSocket? = null
    private val audioBuffer = ByteBuffer.allocate(524_288)  // 512KB

    fun sendAudioData(data: ByteArray, shouldBuffer: Boolean) {
        val client = currentClient ?: return
        if (!shouldBuffer) {
            client.send(ByteBuffer.wrap(data))
        } else {
            synchronized(audioBuffer) {
                if (audioBuffer.position() + data.size < 1_048_576) {
                    audioBuffer.put(data)
                } else {
                    audioBuffer.flip()
                    client.send(audioBuffer)
                    audioBuffer.clear()
                }
            }
        }
    }
}
```

### 3. Add Java-WebSocket Dependency

TaaDa uses the `org.java-websocket` library (WebSocketServer class). We need to add it:

```kotlin
// build.gradle.kts
implementation("org.java-websocket:Java-WebSocket:1.5.6")
```

Or alternatively, keep using Ktor's WebSocket support but run 3 separate instances.

### 4. Update Web Server to Serve Player UI

The HTTPS server needs to:
1. Serve `index.html` with the video player
2. Provide the WebSocket port numbers to the player JS
3. Handle CORS for the WebSocket connections

```kotlin
// Web server serves player with port config
get("/") {
    call.respondText(
        playerHtml.replace("{{WS_PORT}}", controlPort.toString())
            .replace("{{AUDIO_PORT}}", audioPort.toString())
            .replace("{{VOICE_PORT}}", voicePort.toString()),
        ContentType.Text.Html
    )
}
```

### 5. Update Browser JavaScript Player

Browser needs to connect to 3 WebSocket servers:

```javascript
// Video + Control
const controlWs = new WebSocket(`wss://${host}:${controlPort}`);
controlWs.binaryType = 'arraybuffer';
controlWs.onmessage = (e) => {
    if (e.data instanceof ArrayBuffer) {
        // H.264 frame → decode and display
        feedVideoFrame(e.data);
    }
};

// Audio
const audioWs = new WebSocket(`wss://${host}:${audioPort}`);
audioWs.binaryType = 'arraybuffer';
audioWs.onmessage = (e) => {
    // PCM audio → play via Web Audio API
    playAudio(e.data);
};

// Voice (optional)
const voiceWs = new WebSocket(`wss://${host}:${voicePort}`);
```

### 6. SSL Certificate for WebSocket Servers

Generate a self-signed PKCS12 certificate:

```bash
# Generate keystore for WebSocket SSL
keytool -genkeypair -alias taada \
    -keyalg RSA -keysize 2048 \
    -validity 3650 \
    -storetype PKCS12 \
    -keystore server_pbe.p12 \
    -storepass aa -keypass aa \
    -dname "CN=localhost"
```

Place as `res/raw/server_pbe.p12`.

## Implementation Tasks

1. [ ] Add `org.java-websocket:Java-WebSocket` dependency (or use Ktor multi-instance)
2. [ ] Create `ControlSocketServer.kt` with all action handlers
3. [ ] Create `MediaSocketServer.kt` with audio buffering
4. [ ] Generate self-signed PKCS12 keystore for WSS
5. [ ] Wire ControlSocketServer to NalStreamManager for video output
6. [ ] Wire ControlSocketServer touch events to InputChannelHandler
7. [ ] Wire MediaSocketServer to AudioChannelHandler output
8. [ ] Update/create browser HTML/JS player for 3-WebSocket architecture
9. [ ] Add port number serving via HTTPS server
10. [ ] Update TransporterService to create and start all 3 servers
11. [ ] Test: browser connects to all 3 WebSockets, receives video, sends touch

## Port Architecture

```
Phone (Hotspot IP, e.g., 192.168.43.1)
  │
  ├── Port 8081-8085: HTTPS Web Server (serves player UI)
  │
  ├── Port N (8090-9998): ControlSocketServer (WSS)
  │   ├── OUT: Binary H.264 video frames
  │   └── IN:  JSON/Binary touch + control commands
  │
  ├── Port N+1: MediaAudioServer (WSS)
  │   └── OUT: Binary PCM audio (music/media)
  │
  └── Port N+2: VoiceServer (WSS)
      ├── OUT: Binary voice audio
      └── IN:  Binary mic audio (future)
```

## Ping Protocol

```
Browser sends: {"action": "PING"}

Server responds: 5-byte binary {0x00, 0x00, 0x00, 0x00, 0x1F}
  (0x1F = 31 decimal)

Then schedules: toggleVideoFocus(true) after 3000ms delay
```

## Decision: Ktor vs Java-WebSocket

| | Ktor WebSocket | Java-WebSocket |
|---|---|---|
| Already in project | Yes | No (new dependency) |
| Multiple instances | Possible (multiple embedded servers) | Native support |
| SSL support | Via Ktor TLS plugin | Via DefaultSSLWebSocketServerFactory |
| Binary frames | Supported | Supported |
| TaaDa uses | — | Yes (org.java-websocket) |

**Recommendation:** Use `Java-WebSocket` library to match TaaDa's architecture exactly. It's lightweight and purpose-built for this. Keep Ktor for the HTTPS web server that serves the player UI.
