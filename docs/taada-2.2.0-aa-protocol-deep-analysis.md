# TaaDa 2.2.0 - AA Protocol & Communication Layer Deep Analysis

> Decompiled source at: `test/taada_extracted_2_2_0/sources/`

---

## 1. Architecture Overview

TaaDa acts as a **head unit (HU) emulator** that:

1. Listens on **TCP port 5288** for Android Auto connections
2. Launches AA on the phone via `WirelessStartupActivity` intent (or `WirelessStartupReceiver` broadcast for AA 16.4+)
3. Performs the AA handshake (version exchange, TLS, ServiceDiscovery)
4. Relays video/audio/input over **WebSocket servers** to Tesla's browser

### Key Classes & Their Roles

| Class (obfuscated name) | Role |
|---|---|
| `TransporterService` | Main Android Service, orchestrates everything |
| `ConnectionWaitRunnable` | ServerSocket on port 5288, accepts AA connection |
| `CommunicationHandler` | Manages the AA TCP connection lifecycle |
| `CommunicationHandler.CommunicationRunnable` | Handshake + main message loop thread |
| `MessageHandler` (p048h2) | Raw TCP read/write with framing |
| `SSLHandler` (p066k2) | TLS wrap/unwrap for encrypted AA messages |
| `AbstractSSLHandler` (p066k2) | TLS handshake implementation |
| `SSLHelper` (p066k2) | SSLEngine/SSLContext factory |
| `ProtocolMessage` (p024d2) | AA frame model (channel, service, flags, payload) |
| `MessageProcessor` (p024d2) | Routes messages by channel to handlers |
| `AbstractC0041a` (p003a2) | **ServiceDiscoveryResponse builder** |
| `AbstractC2293a` (p042g2) | Channel 0 handler (control messages) |
| `AbstractC2294b` (p042g2) | Channel 1 handler (input) |
| `AbstractC2295c` (p042g2) | Channel 9 handler (media playback metadata) |
| `AbstractC2296d` (p042g2) | Channels 3,5,6,7 handler (video + audio media) |
| `AbstractC2298f` (p042g2) | Channel 2 handler (sensors) |
| `C2297e` (p042g2) | Channel 4 handler (microphone) |
| `NalStreamManager` | H.264 NAL reassembly + video focus |
| `ControlSocketServer` (p060j2) | WebSocket for video + touch to Tesla browser |
| `MediaSocketServer` (p060j2) | WebSocket for audio to Tesla browser |
| `BinaryTouchDecoder` | Decodes binary touch events from browser |

### Event Bus

TaaDa uses **GreenRobot EventBus** as the central message dispatch mechanism. Outgoing messages are posted as `ProtocolMessage` objects to EventBus. `TransporterService.onMessage()` subscribes and delegates to `MessageSenderRunnable` which encrypts and sends via the TCP socket.

---

## 2. Connection Establishment

### 2.1 AA Launch

In `TransporterService.onStartCommand()`:

```
// Primary method (AA < 16.4):
intent.setClassName("com.google.android.projection.gearhead",
    "com.google.android.apps.auto.wireless.setup.service.impl.WirelessStartupActivity");
intent.putExtra("PARAM_HOST_ADDRESS", "127.0.0.1");
intent.putExtra("PARAM_SERVICE_PORT", 5288);
intent.putExtra("wifi_info", wifiInfo);
intent.putExtra("PARAM_SERVICE_WIFI_NETWORK", network);

// Fallback for AA 16.4+ (SecurityException):
intent.setClassName("com.google.android.projection.gearhead",
    "com.google.android.apps.auto.wireless.setup.receiver.WirelessStartupReceiver");
intent.setAction("com.google.android.apps.auto.wireless.setup.receiver.wirelessstartup.START");
intent.putExtra("ip_address", "127.0.0.1");
intent.putExtra("projection_port", 5288);
```

A **fake Network object** with ID 99999 is created using Mockito to trick AA into thinking it's on a real WiFi network:
```java
network = (Network) Mockito.mock(Network.class, Mockito.withSettings().useConstructor(99999));
```

### 2.2 TCP Server

`ConnectionWaitRunnable` creates a `ServerSocket` on port **5288** and calls `accept()`. On connection, it hands the socket to `CommunicationHandler.setupConnection()`.

### 2.3 Socket Configuration

```java
socket.setSoTimeout(10000);       // 10s read timeout
socket.setTcpNoDelay(true);       // Disable Nagle
socket.setKeepAlive(true);
socket.setReuseAddress(true);
socket.setTrafficClass(16);       // IPTOS_LOWDELAY
socket.setReceiveBufferSize(1048576);  // 1MB
socket.setSendBufferSize(1048576);     // 1MB
```

---

## 3. AA Wire Protocol (Frame Format)

### 3.1 Frame Header

Every AA message has a **4-byte header** (or 6/8 bytes for certain types):

```
Byte 0: channel
Byte 1: flags (service[1:0] | extraFlag[2] | sslFlag[3])
Byte 2-3: frameSize (big-endian uint16)
```

Flag decomposition of byte 1:
- **Bits 0-1 (mask 0x03)**: `service` field (0=control, 1=first-fragment, 2=middle/continuation, 3=complete)
- **Bit 2 (mask 0x04)**: `extraFlag` - set for channel open requests/responses
- **Bit 3 (mask 0x08)**: `sslFlag` - indicates payload is SSL-encrypted

### 3.2 Service Types (byte 1 & 0x03)

| Value | Meaning | Header Size |
|---|---|---|
| 0 | Raw/control (no messageType in payload) | 4 bytes |
| 1 | First fragment of multi-part message | 8 bytes (extra 4 bytes: 2 for frameType + data starts at offset 8) |
| 2 | Middle fragment | 4 bytes |
| 3 | Complete single message | 4 bytes |

For service=1 (first fragment), bytes 4-5 contain the `frameType` (big-endian uint16).

### 3.3 SSL-Encrypted Messages

When `sslFlag` (bit 3) is set:
- For service==1: SSL payload starts at offset **8**
- For all others: SSL payload starts at offset **4**
- Payload is decrypted via `SSLHandler.doUnwrap(data, offset, frameSize)`

### 3.4 Message Type Extraction

After SSL decryption, for service != 0 and service != 2:
```java
messageType = (payload[0] << 8) | payload[1];  // big-endian uint16
```

The first 2 bytes of the decrypted payload are the message type. When processing, `trimMessageTypeBytes()` strips these 2 bytes to get the protobuf payload.

### 3.5 Constructing Outgoing Messages

For SSL-encrypted messages (`sslFlag == 8`):
```
[channel] [service | 0x08 | extraFlag] [sslEncryptedLength:2] [sslEncryptedData]
```

The `m2560g()` method in SSLHandler:
1. Prepends 2-byte messageType to payload
2. SSL wraps the combined data
3. Writes the encrypted length (2 bytes) + encrypted data to output buffer

For cleartext messages (`sslFlag != 8`):
```
[channel] [service | extraFlag] [(payloadLen+2) >> 8] [(payloadLen+2) & 0xFF] [messageType:2] [payload]
```

---

## 4. Handshake Sequence

The handshake runs in `CommunicationRunnable.run()`:

### Step 1: Car Hello (Version Request)

```java
CAR_HELLO_DATA = {0, 3, 0, 6, 0, 1, 0, 1, 0, 6};
```

Breakdown:
- Channel=0, Flags=0x03 (service=3 = complete message, no SSL)
- FrameSize=6
- MessageType=0x0001 (VERSION_REQUEST=1)
- Payload: `{0, 1, 0, 6}` => version 1, minor 6 (AA protocol version 1.6)

Sent with 500ms offset/delay.

### Step 2: Read Phone Hello (Version Response)

Reads the phone's version response with a 2000ms timeout. No validation is performed on the response content.

### Step 3: Cleartext Message

```java
CLEARTEXT_DATA = {0, 3, 0, 4, 0, 4, 8, 0};
```

Breakdown:
- Channel=0, Flags=0x03
- FrameSize=4
- MessageType=0x0004 (AUTH_COMPLETE=4)
- Payload: `{8, 0}` => protobuf field 1 (varint) = 0

This is the **AUTH_COMPLETE** message, signaling cleartext auth is done.

### Step 4: SSL Setup

```java
SSLEngine = SSLHelper.createSSLEngine(context, R.raw.keystore, "aa");
```

- Uses **PKCS12** keystore from `R.raw.keystore` with password `"aa"`
- Protocols: TLSv1.3 preferred, TLSv1.2 fallback
- `setNeedClientAuth(true)` - requires mutual TLS
- Trust manager: **NaiveTrustManager** (accepts all certificates)
- SSLEngine set to `clientMode=true` (TaaDa acts as SSL client)

### Step 5: SSL Handshake

The `AbstractSSLHandler.doHandshake()` performs the handshake:

During **NEED_WRAP**: wraps handshake data and sends it framed as:
```
[0x00] [0x03] [encLen+2 >> 8] [encLen+2 & 0xFF] [0x00] [0x03] [SSL data...]
```
Channel=0, service=3, messageType=0x0003 (ENCAPSULATED_SSL).

During **NEED_UNWRAP**: reads framed data, **skips the first 6 bytes** (4-byte header + 2-byte messageType), then feeds the rest to `sslEngine.unwrap()`.

### Step 6: Initialize Components

After SSL handshake:
1. Creates `SSLHandler` wrapper (stores the engine for ongoing encrypt/decrypt)
2. Creates `MessageProcessor` (message routing)
3. Sends another cleartext message (same AUTH_COMPLETE data: `{0, 3, 0, 4, 0, 4, 8, 0}`)

### Step 7: Start Connection

Sets `TransporterService.isConnected = true` and starts **heartbeat** (ping) loop.

---

## 5. Channel Architecture

### 5.1 Channel IDs and Services

| Channel | Service ID | Purpose |
|---|---|---|
| 0 | control (various) | Control channel: ServiceDiscovery, Ping, NavFocus, AudioFocus, ByeBye |
| 1 | InputSourceService | Touch/key input (phone <- HU) |
| 2 | SensorSourceService | Sensors: driving status, night mode, GPS, parking brake |
| 3 | MediaSinkService (video) | H.264 video stream (phone -> HU) |
| 4 | MediaSourceService (mic) | Microphone audio (HU -> phone) |
| 5 | MediaSinkService (media audio) | Media/music audio PCM (phone -> HU) |
| 6 | MediaSinkService (system audio) | System audio PCM (phone -> HU) |
| 7 | MediaSinkService (guidance audio) | Navigation guidance audio PCM (phone -> HU) |
| 9 | MediaPlaybackStatusService | Media metadata (song, artist, album art) |

### 5.2 Channel Open Handling

When a `ChannelOpenRequest` arrives (messageType=7, extraFlag=4):
```java
// MessageProcessor.processMessage():
if (protocolMessage.getMessageType() == 7 && protocolMessage.getExtraFlag() == 4) {
    response = messagePool.createMessage(channel, (byte)3, 8,
        ChannelOpenResponse.newBuilder().setStatus(MessageStatus.STATUS_SUCCESS));
    response.setExtraFlag((byte) 4);
}
```
Always responds with **STATUS_SUCCESS**. The `extraFlag=4` is set on both request and response.

### 5.3 Message Routing (MessageProcessor)

```java
switch (channel) {
    case 0: AbstractC2293a  // Control
    case 1: AbstractC2294b  // Input
    case 2: AbstractC2298f  // Sensors
    case 3,5,6,7: AbstractC2296d  // Media (video + audio)
    case 4: C2297e          // Microphone
    case 9: AbstractC2295c  // Media playback metadata
}
```

---

## 6. ServiceDiscovery Response

Built in `AbstractC0041a.m13031a()`. This is the **most critical message** - it tells AA what the head unit supports.

### HeadUnitInfo

```java
.setHeadUnitMake("Google")
.setHeadUnitModel("Desktop Head Unit")
.setMake("Google")
.setModel("Desktop Head Unit")
.setHeadUnitSoftwareBuild("HUR")
.setHeadUnitSoftwareVersion("1.1")
```

### Driver Position

Configurable via preferences: `DRIVER_POSITION_LEFT` (default) or `DRIVER_POSITION_RIGHT`.

### Services Declared

**Service ID 1 - InputSourceService:**
- Touchscreen: CAPACITIVE, dimensions match video resolution
- Keycodes: `[1, 2, 3, 4, 5, 6, 19, 20, 21, 22, 23, 84, 85, 87, 88]`

**Service ID 2 - SensorSourceService:**
- SENSOR_DRIVING_STATUS_DATA
- SENSOR_NIGHT_MODE
- SENSOR_LOCATION
- SENSOR_PARKING_BRAKE

**Service ID 3 - MediaSinkService (Video):**
- Codec: `MEDIA_CODEC_VIDEO_H264_BP` (H.264 Baseline Profile)
- Display: `DISPLAY_TYPE_MAIN`
- VideoConfig: DPI from prefs (default 120), 30fps, resolution from prefs with margin offsets

**Service ID 6 - MediaSinkService (System Audio):**
- Codec: `MEDIA_CODEC_AUDIO_PCM`
- AudioType: `AUDIO_STREAM_SYSTEM_AUDIO`
- Config: 16-bit, 16000 Hz, mono

**Service ID 7 - MediaSinkService (Guidance Audio)** (only if Bluetooth disabled):
- Codec: `MEDIA_CODEC_AUDIO_PCM`
- AudioType: `AUDIO_STREAM_GUIDANCE`
- Config: 16-bit, 16000 Hz, mono

**Service ID 5 - MediaSinkService (Media Audio)** (only if Bluetooth disabled):
- Codec: `MEDIA_CODEC_AUDIO_PCM`
- AudioType: `AUDIO_STREAM_MEDIA`
- Config: 16-bit, **48000 Hz**, **stereo** (2 channels)

**Service ID 4 - MediaSourceService (Microphone):**
- Codec: `MEDIA_CODEC_AUDIO_PCM`
- Config: 16-bit, 16000 Hz, mono

**Service ID 9 - MediaPlaybackStatusService:**
- Empty builder (just declares availability)

### Message Construction

```java
return new ProtocolMessage((byte) 0, (byte) 3, 6, builderNewBuilder);
// Channel=0, service=3 (complete), messageType=6 (SERVICE_DISCOVERY_RESPONSE)
```

### Video Resolution Options

| Index | Width | Height | Notes |
|---|---|---|---|
| 0 | 800 | 480 | WVGA |
| 1 | 1280 | 720 | HD (default) |
| 2 | 1920 | 1080 | FHD |
| 3 | 2560 | 1440 | QHD |
| 4 | 3840 | 2160 | 4K |
| 5 | 720 | 1280 | Portrait HD |
| 6 | 1080 | 1920 | Portrait FHD |
| 7 | 1440 | 2560 | Portrait QHD |

`VideoCodecResolutionType` is `forNumber(index + 1)`.

---

## 7. Control Channel (Channel 0) Message Handling

### ServiceDiscoveryRequest (type=5)

Only handled when `service == 3`. Returns the full ServiceDiscoveryResponse.

### AudioFocusRequest (type=18)

```java
if (request == AUDIO_FOCUS_RELEASE) {
    response.setFocusState(AUDIO_FOCUS_STATE_LOSS_TRANSIENT_CAN_DUCK);
} else {
    response.setFocusState(AUDIO_FOCUS_STATE_GAIN);
}
```
Response: messageType=19 (AUDIO_FOCUS_NOTIFICATION).

### NavFocusRequest (type=13)

Always responds with `NAV_FOCUS_PROJECTED`.
Response: messageType=14 (NAV_FOCUS_NOTIFICATION).

### PingRequest (type=11)

Echoes back the timestamp from the request.
Response: messageType=12 (PING_RESPONSE).

---

## 8. Heartbeat / Ping

`CommunicationHandler.sendHeartbeat()`:
```java
PingRequest.newBuilder().setTimestamp(System.currentTimeMillis());
// Channel=0, service=3, messageType=11
```

Posted to EventBus, then schedules next heartbeat in **2000ms** via `Handler.postDelayed()`.

---

## 9. Media Channel Handling (Channels 3, 5, 6, 7)

### MEDIA_MESSAGE_SETUP (0x8000 = 32768)

Response is `Config` protobuf on messageType=32771 (MEDIA_MESSAGE_CONFIG):
```java
Config.newBuilder()
    .setMaxUnacked(1)
    .setStatus(Config.Status.STATUS_READY)
    // For video (channel 3) only:
    .addConfigurationIndices(0)  // selects first video config
```

For channel 3: sets `TransporterService.isVideoActive = true`.

### MEDIA_MESSAGE_START (0x8001 = 32769)

Stores the `sessionId` from the Start protobuf into `AbstractC2147a.f7665c` map keyed by channel byte:
```java
sessionIds = {(byte)5: -1, (byte)6: -1, (byte)7: -1, (byte)3: -1}
```

### MEDIA_MESSAGE_STOP (0x8002 = 32770)

Ignored for non-video channels (channel != 3). For channel 3, returns null (no response).

### MEDIA_MESSAGE_DATA (0x0000 = 0)

**Video (channel 3):** Forwarded to `NalStreamManager.buildNal()` for H.264 reassembly.

**Audio (channel 5 - media):** Raw PCM extracted from offset 10 onward, sent to `mediaAudioSocketServer`. ACK returned:
```java
Ack.newBuilder().setSessionId(sessionIds.get((byte)5)).setAck(1);
// Channel=5, service=3, messageType=32772 (MEDIA_MESSAGE_ACK)
```

**Audio (channels 6,7 - system/guidance):** Same pattern, sent to `voiceSocketServer`.

### MEDIA_MESSAGE_CODEC_CONFIG (0x0001 = 1)

Same handling as DATA but payload starts at offset 2 instead of 10.

---

## 10. Video Pipeline (H.264 NAL Reassembly)

`NalStreamManager.buildNal(service, payload, frameType, mediaMessageId)`:

| Service | Meaning | Action |
|---|---|---|
| 3 (complete) | Complete NAL unit | Process immediately via `process()` |
| 1 (first fragment) | First fragment | Clear nalBuffer, append from offset 10 (DATA) or 2 (CODEC_CONFIG) |
| 0 | Continuation | Append to nalBuffer |
| 2 | Last fragment | Append to nalBuffer, flip, process |
| 127 | Special complete | Process raw payload |

For MEDIA_MESSAGE_DATA: data offset is 10 (skips 2-byte msgType + 8 bytes media header).
For MEDIA_MESSAGE_CODEC_CONFIG: data offset is 2 (skips 2-byte msgType), and validates NAL start code `00 00 00 01` at bytes 2-5.

`process()` sends the ByteBuffer directly to `ControlSocketServer.m2579j0()` which sends it as a binary WebSocket message to Tesla's browser.

NAL buffer size: **8 MB** (`ByteBuffer.allocateDirect(8388608)`).

### Video Focus

`NalStreamManager.toogleVideoFocus(boolean focus)`:
```java
VideoFocusNotification.newBuilder()
    .setFocus(focus ? VIDEO_FOCUS_PROJECTED : VIDEO_FOCUS_NATIVE)
    .setUnsolicited(true);
// Channel=3, service=3, messageType=32776 (VIDEO_FOCUS_NOTIFICATION)
```

Keyframe requests use messageType=32775 (VIDEO_FOCUS_REQUEST) with `VIDEO_FOCUS_PROJECTED` + `unsolicited=true`.

---

## 11. Sensor Channel (Channel 2) Handling

### SensorRequest (type=32769 = 0x8001)

First sends a SensorResponse with STATUS_SUCCESS (type=32770), then:

| SensorType | Response |
|---|---|
| SENSOR_DRIVING_STATUS_DATA | SensorBatch with DrivingStatusData(status=0) |
| SENSOR_PARKING_BRAKE | SensorBatch with ParkingBrakeData(parkingBrake=true) |
| SENSOR_LOCATION | Posts `"gb.xxy.hr.startGPS"` to EventBus |
| SENSOR_SPEED | Posts `"gb.xxy.hr.startSpeed"` to EventBus |
| SENSOR_NIGHT_MODE | Posts `"gb.xxy.hr.startNight"` to EventBus |

SensorBatch responses use channel=2, service=3, messageType=32771 (MEDIA_MESSAGE_CONFIG).

GPS data from browser is sent as:
```java
LocationData.newBuilder()
    .setLatitudeE7((int)(lat * 1e7))
    .setLongitudeE7((int)(lng * 1e7))
    .setAltitudeE2((int)(alt * 100))
    .setBearingE6((int)(heading * 1e6))
    .setSpeedE3((int)(speed * 100))
    .setAccuracyE3((int)(accuracy * 1000));
```

---

## 12. Input Channel (Channel 1) Handling

### KeyBindingRequest (type=32770 = 0x8002)

Response: `KeyBindingResponse` with status=0, sent on same channel, type=32771.

### Sending Touch Events

```java
InputReport.newBuilder()
    .setTimestamp(SystemClock.uptimeMillis())
    .setTouchEvent(touchEvent)  // or .setTouchpadEvent() if touchpad mode
    // or .setKeyEvent() / .setRelativeEvent()
// Channel=1, service=3, messageType=32769 (MEDIA_MESSAGE_START)
```

Touch events support multi-touch with pointer actions:
- ACTION_DOWN, ACTION_UP, ACTION_MOVED
- ACTION_POINTER_DOWN (2nd+ finger), ACTION_POINTER_UP (finger lifted but others remain)

Each pointer has: `x`, `y`, `pointerId`.

---

## 13. Microphone Channel (Channel 4) Handling

### MicrophoneRequest (type=32773 = 0x8005)

If `open == true`:
- Launches `MicActivity`
- Responds with `MicrophoneResponse(sessionId=0, status=0)` on type=32774

If `open == false`:
- Sends STOP action to MicActivity
- No response

---

## 14. SSL/TLS Details

### Certificate Management

- **AA connection**: Uses `R.raw.keystore` (PKCS12, password `"aa"`)
- **WebSocket servers**: Use `R.raw.server_pbe` (PKCS12, password `"aa"`)
- **Dynamic certificate**: Can be downloaded from `https://cert.taada.top` and stored as `dynamic-server-cert.p12` in app files directory
- Certificate updates checked via `/health` endpoint which returns `certificate_fingerprint`

### Trust Manager

`C2779c` (NaiveTrustManager) accepts **all** client and server certificates without validation.

### TLS Protocol

- Context: `TLSv1.2`
- Enabled protocols: `TLSv1.3, TLSv1.2` (fallback to TLSv1.2 only)
- `setNeedClientAuth(true)` for SSLEngine
- SSLEngine operates in **client mode** (`setUseClientMode(true)`)

### SSL Handshake Framing

During TLS handshake, wrapped data is sent as:
```
[0x00] [0x03] [len_hi] [len_lo] [0x00] [0x03] [encrypted_data...]
```
Where len = encrypted_data.length + 2 (includes the `00 03` message type bytes).

Incoming handshake data has the first **6 bytes stripped** (4-byte frame header + 2-byte messageType) before being fed to `SSLEngine.unwrap()`.

---

## 15. WebSocket Server Architecture

Three WSS servers on consecutive random ports (base: 8090-9998):

| Server | Port Offset | Purpose |
|---|---|---|
| ControlSocketServer | base+0 | Video binary stream + touch/control JSON |
| MediaAudioSocketServer | base+1 | Media audio PCM |
| VoiceSocketServer | base+2 | System/guidance audio PCM |

All use SSL via `DefaultSSLWebSocketServerFactory` with the `server_pbe` certificate.

### ControlSocketServer Actions (JSON)

| Action | Description |
|---|---|
| `START` | Enable video focus |
| `STOP` | Disable video focus |
| `ACK` | Video frame ACK (sends MEDIA_ACK on channel 3) |
| `PING` | Keepalive, updates client FPS, responds with `{0,0,0,0,31}` binary |
| `REQUEST_KEYFRAME` | Requests I-frame (throttled to 2s intervals) |
| `RELOAD` | Toggle video focus off then on |
| `GPS` | Forward GPS coordinates as SensorBatch |
| `NIGHT` | Set night mode sensor |
| `MULTITOUCH_DOWN/MOVE/UP/CANCEL` | Touch events with `{touches, allTouches}` arrays |

### Video Focus Timeout

If no PING received within 3000ms, video focus is automatically disabled via `toogleVideoFocus(false)`.

### Binary Touch Protocol

The ControlSocketServer accepts binary WebSocket messages for touch input:

```
Byte 0: action (0=DOWN, 1=MOVE, 2=UP, 3=TOUCH)
Byte 1: touchCount
For each touch:
  2 bytes: id (uint16 BE)
  2 bytes: x (uint16 BE)
  2 bytes: y (uint16 BE)
Byte N: allTouchesCount
For each allTouch:
  2 bytes: id (uint16 BE)
  2 bytes: x (uint16 BE)
  2 bytes: y (uint16 BE)
4 bytes: timestamp delta (uint32 BE, added to lastTimestamp)
```

Minimum message size: 8 bytes. Validation: `action <= 3 && touchCount <= 10`.

---

## 16. Exit / Shutdown

### ByeBye Message

```java
EXIT_MESSAGE_DATA = {0, 15, 8, 1};
// messageType=15 (BYEBYE_REQUEST), payload={8, 1} => reason=USER_SELECTION
```

Sent SSL-encrypted on channel=0, service=3.

### Shutdown Sequence

1. `onDestroy()` notifies WebSocket clients with `{"type":"server_shutdown"}`
2. Sends ByeBye to AA
3. Closes VPN interfaces
4. Stops WebSocket servers
5. Unregisters EventBus
6. Closes communication socket
7. Optionally schedules service restart via AlarmManager

---

## 17. Key Constants Summary

### Frame Constants

| Constant | Value | Usage |
|---|---|---|
| CAR_HELLO_DATA | `00 03 00 06 00 01 00 01 00 06` | Version 1.6 handshake |
| CLEARTEXT_DATA | `00 03 00 04 00 04 08 00` | AUTH_COMPLETE |
| EXIT_MESSAGE_DATA | `00 0F 08 01` | ByeBye (reason=1) |
| PING binary response | `00 00 00 00 1F` | WebSocket pong |

### Protocol Version

- **AA Protocol Version**: 1.6 (major=1, minor=6)

### SSL Flag

- `sslFlag = 0x08` (bit 3 set) = encrypted
- `extraFlag = 0x04` (bit 2 set) = channel open request/response

### Buffer Sizes

| Buffer | Size |
|---|---|
| SSL/Message initial buffers | 32 KB |
| Max SSL buffer | 64 MB |
| NAL reassembly buffer | 8 MB |
| Media audio WS buffer | 512 KB |
| MediaPlayback metadata buffer | 1 MB |
| Max message read size | 512 KB |
| Socket send/recv buffers | 1 MB |

---

## 18. Differences from Standard AA Protocol

1. **No USB/AOA**: TaaDa only uses WiFi (TCP localhost). No USB accessory handling at all.

2. **Simplified Auth**: Sends AUTH_COMPLETE immediately without proper authentication exchange. Uses a naive trust manager.

3. **Always accepts channels**: ChannelOpenRequest always gets STATUS_SUCCESS regardless of channel ID.

4. **Fixed sensor responses**: Parking brake always true, driving status always 0 (unrestricted).

5. **No Bluetooth audio routing**: When `useBT=true` (default), channels 5 and 7 (media + guidance audio) are omitted from ServiceDiscovery, presumably handled via Bluetooth A2DP directly.

6. **Single video config**: Only one VideoConfiguration offered per resolution setting (no multiple options for AA to choose from).

7. **HU identity**: Pretends to be "Google Desktop Head Unit" with software version "1.1" and build "HUR".

8. **Audio ACK on every frame**: Sends MEDIA_ACK after every audio data message on channels 5, 6, 7 (with `maxUnacked=1`).

9. **Dynamic certificate system**: Can download updated SSL certificates from `cert.taada.top` for the HTTPS/WSS server, checked via fingerprint comparison.

---

## 19. Error Handling & Reconnection

- **Socket timeout**: 10s (SOTimeout), handled as IOException
- **OOM recovery**: On OutOfMemoryError, stops service and schedules restart in 3 seconds
- **Fatal errors**: Sends STOP intent to MicActivity, stops service
- **Service restart**: Uses AlarmManager to restart TransporterService after shutdown
- **WebSocket disconnect**: Video focus disabled automatically on close
- **Keyframe throttling**: Max one keyframe request every 2 seconds
- **Video focus retry**: If `isVideoActive` is false when focus is requested, retries after 300ms
