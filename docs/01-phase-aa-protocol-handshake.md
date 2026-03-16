# Phase 1: AA Protocol ServerSocket & Handshake

## Overview

TaaDa acts as a **fake Android Auto head unit** by listening on port 5288 for Android Auto (Gearhead) to connect. After a precise handshake sequence, it establishes an encrypted channel over which AA sends video, audio, and control messages.

Our `androidauto/` module already has the full protocol stack. This phase is about **switching from connecting outbound (port 5277)** to **listening inbound (port 5288)** like TaaDa does, and wiring it into a new `TransporterService`.

## What TaaDa Does (Exact Implementation)

### 1. ServerSocket on Port 5288

```
ConnectionWaitRunnable:
  - Creates ServerSocket(5288)
  - Calls serverSocket.accept() (blocking)
  - On connection: passes Socket to CommunicationHandler
  - Closes ServerSocket (single connection only)
```

### 2. Socket Configuration

```java
// CommunicationHandler.configureSocket()
socket.setSoTimeout(10000);              // 10s read timeout
socket.setTcpNoDelay(true);              // Disable Nagle's (low latency)
socket.setKeepAlive(true);               // TCP keepalive
socket.setReuseAddress(true);            // Allow quick restart
socket.setTrafficClass(16);              // IPTOS_LOWDELAY
socket.setReceiveBufferSize(1048576);    // 1MB receive buffer
socket.setSendBufferSize(1048576);       // 1MB send buffer
```

### 3. Handshake Sequence

```
Step 1: Send CAR_HELLO
  Bytes: {0, 3, 0, 6, 0, 1, 0, 1, 0, 6}
  (10 bytes, tells AA "I am a car head unit")

Step 2: Receive PHONE_HELLO
  Read with 2000ms timeout
  (AA responds with its hello, variable length)

Step 3: Send CLEARTEXT message
  Bytes: {0, 3, 0, 4, 0, 4, 8, 0}
  (8 bytes, cleartext setup before SSL)

Step 4: Initialize SSLEngine
  - Protocol: TLSv1.2 (fallback TLSv1.3)
  - Keystore: PKCS12 from R.raw.keystore, password "aa"
  - setNeedClientAuth(true)
  - setUseClientMode(true)

Step 5: SSL Handshake
  Loop while handshakeStatus != FINISHED:
    NEED_UNWRAP: Read from socket, unwrap
    NEED_WRAP: Wrap data, send with 6-byte header:
      {0x00, 0x03, (len+2 high), (len+2 low), 0x00, 0x03, ...encrypted...}
    NEED_TASK: Execute delegated tasks

Step 6: Begin message processing loop
  - Encrypted protobuf messages flow bidirectionally
  - Heartbeat every 2000ms
```

### 4. Launching Android Auto

```java
// TransporterService.onStartCommand()
Intent intent = new Intent();
intent.setClassName(
    "com.google.android.projection.gearhead",
    "com.google.android.apps.auto.wireless.setup.service.impl.WirelessStartupActivity"
);
intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
intent.putExtra("PARAM_HOST_ADDRESS", "127.0.0.1");
intent.putExtra("PARAM_SERVICE_PORT", 5288);
// TaaDa also passes wifi_info and PARAM_SERVICE_WIFI_NETWORK
startActivity(intent);
```

### 5. Heartbeat / Keep-Alive

```
Every 2000ms:
  Send PingRequest protobuf:
    Channel: 0 (control)
    Service: 3
    MessageType: 11 (PING_REQUEST)
    Payload: PingRequest { timestamp: System.currentTimeMillis() }
```

### 6. Message Protocol Format

```
Byte 0:     Channel (0-10)
Byte 1:     Service + flags (SSL=0x08, Extra=0x04)
Bytes 2-3:  Frame size (big-endian, excludes 4-byte header)
Bytes 4-5:  Message type (for service=1 control messages)
Bytes 6+:   Payload (protobuf, encrypted or cleartext)

Max payload: 524288 bytes (512KB)
```

## What We Already Have

| Component | File | Status |
|-----------|------|--------|
| AA Protocol messages | `androidauto/proto/AapMessages.kt` | Complete |
| Frame encoding/decoding | `androidauto/protocol/AapFramer.kt` | Complete |
| TLS handshake | `androidauto/protocol/AapCrypto.kt` | Complete |
| Channel multiplexer | `androidauto/protocol/ChannelMux.kt` | Complete |
| Control handler | `androidauto/channels/ControlChannelHandler.kt` | Complete |
| Service discovery | `androidauto/proto/ServiceDiscovery.kt` | Complete |
| Head unit emulator | `androidauto/headunit/AAHeadUnitEmulator.kt` | Complete |
| AA launcher | `androidauto/launcher/AALauncher.kt` | Complete |

## What Needs to Change

### 1. Switch AAHeadUnitEmulator from Client to Server Mode

Currently `AAHeadUnitEmulator.connect()` does:
```kotlin
// Current: connects outbound to AA HU Server on port 5277
socket = Socket("127.0.0.1", 5277)
```

Must change to TaaDa's approach:
```kotlin
// Target: listen on port 5288 for AA to connect
serverSocket = ServerSocket(5288)
socket = serverSocket.accept()  // blocking
serverSocket.close()            // single connection
```

### 2. Reverse the Handshake Direction

Currently the emulator sends a version request and waits for a response. TaaDa sends `CAR_HELLO` bytes first, receives `PHONE_HELLO`, then sends `CLEARTEXT` before starting SSL.

**Changes needed in AAHeadUnitEmulator:**
- Replace version exchange with CAR_HELLO/PHONE_HELLO byte sequence
- Add CLEARTEXT message before SSL handshake
- Keep existing SSL handshake logic (AapCrypto is correct)
- Add 2000ms timeout on PHONE_HELLO read

### 3. Add Embedded SSL Keystore

TaaDa ships `R.raw.keystore` (PKCS12, password "aa"). We need to either:
- Extract TaaDa's keystore and include it (legally questionable)
- Generate our own self-signed PKCS12 keystore with password "aa"
- Determine if AA validates the certificate or just accepts any TLS

**Investigation needed:** Does Android Auto validate the server certificate, or does it accept any TLS connection? If it validates, we need the exact keystore format AA expects.

### 4. Create TransporterService

New foreground service that replaces/augments `MainService`:

```kotlin
class TransporterService : Service() {
    // Lifecycle
    private var serverSocket: ServerSocket? = null
    private var aaSocket: Socket? = null
    private var emulator: AAHeadUnitEmulator? = null

    // WebSocket servers (Phase 4)
    private var controlServer: ControlSocketServer? = null
    private var audioServer: MediaSocketServer? = null
    private var voiceServer: MediaSocketServer? = null

    fun onStartCommand() {
        // 1. Pick random WebSocket port (8090-9998)
        // 2. Start VPN (Phase 5)
        // 3. Create 3 WebSocket servers (Phase 4)
        // 4. Start ConnectionWaitRunnable on port 5288
        // 5. Launch Android Auto WirelessStartupActivity
        // 6. On AA connection: setup handshake
        // 7. Begin message processing loop
        // 8. Start heartbeat (2000ms interval)
    }
}
```

### 5. Add Socket Configuration

Apply TaaDa's exact socket settings:
```kotlin
fun configureSocket(socket: Socket) {
    socket.soTimeout = 10_000
    socket.tcpNoDelay = true
    socket.keepAlive = true
    socket.reuseAddress = true
    socket.trafficClass = 16  // IPTOS_LOWDELAY
    socket.receiveBufferSize = 1_048_576  // 1MB
    socket.sendBufferSize = 1_048_576     // 1MB
}
```

### 6. Add Heartbeat Mechanism

```kotlin
private val heartbeatHandler = Handler(Looper.getMainLooper())
private val heartbeatRunnable = object : Runnable {
    override fun run() {
        sendPingRequest(System.currentTimeMillis())
        heartbeatHandler.postDelayed(this, 2000L)
    }
}
```

## Implementation Tasks

1. [ ] Modify `AAHeadUnitEmulator` to support server mode (listen on 5288)
2. [ ] Implement CAR_HELLO → PHONE_HELLO → CLEARTEXT handshake sequence
3. [ ] Generate/obtain PKCS12 keystore for SSL (password "aa")
4. [ ] Add keystore as `R.raw.keystore` resource
5. [ ] Create `TransporterService` foreground service
6. [ ] Add socket configuration (timeouts, buffers, TCP_NODELAY)
7. [ ] Implement heartbeat mechanism (PingRequest every 2000ms)
8. [ ] Wire `AALauncher.launchWirelessProjection()` to start AA
9. [ ] Add foreground notification for the service
10. [ ] Test: AA connects, handshake completes, service discovery works

## Key Constants

```kotlin
const val AA_LISTEN_PORT = 5288
const val AA_PACKAGE = "com.google.android.projection.gearhead"
const val AA_WIRELESS_ACTIVITY = "com.google.android.apps.auto.wireless.setup.service.impl.WirelessStartupActivity"
const val HEARTBEAT_INTERVAL_MS = 2000L
const val SOCKET_TIMEOUT_MS = 10_000
const val SOCKET_BUFFER_SIZE = 1_048_576
const val MAX_PAYLOAD_SIZE = 524_288

val CAR_HELLO = byteArrayOf(0, 3, 0, 6, 0, 1, 0, 1, 0, 6)
val CLEARTEXT_MSG = byteArrayOf(0, 3, 0, 4, 0, 4, 8, 0)
val EXIT_MSG = byteArrayOf(0, 15, 8, 1)
```

## Buffer Pool Configuration (TaaDa Reference)

```kotlin
// SSL buffers
const val SSL_BUFFER_SIZE = 16384
const val MESSAGE_BUFFER_SIZE = 8192
const val MAX_SSL_POOL_SIZE = 10
const val MAX_MESSAGE_POOL_SIZE = 20

// SSLHandler buffer tiers
const val SMALL_SSL_SIZE = 512    // max 6 pooled
const val MEDIUM_SSL_SIZE = 2048  // max 6 pooled
const val LARGE_SSL_SIZE = 8192   // max 6 pooled
const val XLARGE_SSL_SIZE = 16384 // max 6 pooled
```

## Risks & Open Questions

1. **SSL Keystore**: Does AA validate the certificate? If yes, we need to reverse-engineer the expected cert format. If no, a self-signed cert works.
2. **AA Version Compatibility**: TaaDa targets AA version 1.1 in the version exchange. Different AA versions may have different handshake requirements.
3. **Port 5288 Conflicts**: If another app is using this port, the ServerSocket will fail. Need error handling.
4. **Hotspot Timing**: AA needs to connect via the WiFi network. The hotspot must be active before launching AA.
