# Phase 6: Audio Streaming (Media + Voice)

## Overview

TaaDa relays three audio streams from Android Auto to the Tesla browser:
1. **Media audio** (music, podcasts) → MediaSocketServer (Port N+1)
2. **System audio** (navigation prompts, notifications) → Mixed with media
3. **Voice/Mic** (voice commands, phone calls) → VoiceSocketServer (Port N+2)

TaaDa also captures microphone audio from the browser and sends it back to AA for voice commands.

## What TaaDa Does (Exact Implementation)

### 1. Audio Channels in AA Protocol

AA sends audio on three separate channels:
```
Channel 4: Speech audio (navigation, announcements)
Channel 5: System audio (notifications, alerts)
Channel 6: Media audio (music, podcasts)
Channel 7: Microphone input (voice commands)
```

Each channel's audio config (from Service Discovery):
```
Media (Channel 6):  48000 Hz, 16-bit PCM, 2 channels (stereo)
Speech (Channel 4): 16000 Hz, 16-bit PCM, 1 channel (mono)
System (Channel 5): 16000 Hz, 16-bit PCM, 1 channel (mono)
```

### 2. Audio Data Flow (AA → Browser)

```java
// In MessageProcessor, when audio data arrives on Channel 1/6:
case MEDIA_MESSAGE_DATA:
    byte[] audioData = extractAudioPayload(message);
    mediaSocketServer.sendAudioData(audioData, true);  // buffered
    break;

case MEDIA_MESSAGE_CODEC_CONFIG:
    // Audio codec config (usually PCM, no special config needed)
    break;
```

### 3. MediaSocketServer Audio Buffering

```java
// 512KB buffer to batch small audio chunks
ByteBuffer audioBuffer = ByteBuffer.allocate(524288);

void sendAudioData(byte[] data, boolean shouldBuffer) {
    WebSocket client = currentClient;
    if (client == null || !client.isOpen()) return;

    if (!shouldBuffer) {
        client.send(ByteBuffer.wrap(data));
        return;
    }

    synchronized (audioBuffer) {
        if (audioBuffer.position() + data.length < 1048576) {
            audioBuffer.put(data);
        } else {
            // Buffer full, flush
            audioBuffer.flip();
            client.send(audioBuffer);
            audioBuffer.clear();
            audioBuffer.put(data);
        }
    }
}

// Periodic flush (called from timer)
void flushAudioBuffer() {
    synchronized (audioBuffer) {
        if (audioBuffer.position() > 0) {
            audioBuffer.flip();
            currentClient.send(audioBuffer);
            audioBuffer.clear();
        }
    }
}
```

### 4. Microphone Capture (MicActivity)

TaaDa uses a transparent Activity to capture microphone audio:

```java
// MicActivity (transparent, no UI)
AudioRecord audioRecord;

void startRecording() {
    int sampleRate = 16000;
    int format = AudioFormat.ENCODING_PCM_16BIT;
    int channelMask = AudioFormat.CHANNEL_IN_MONO;
    int bufferSize = AudioRecord.getMinBufferSize(sampleRate, channelMask, format);

    audioRecord = new AudioRecord(
        MediaRecorder.AudioSource.VOICE_RECOGNITION,  // Source 9
        sampleRate,
        channelMask,
        format,
        bufferSize
    );
    audioRecord.startRecording();

    // Recording thread (high priority)
    Thread recordThread = new Thread(() -> {
        android.os.Process.setThreadPriority(10);  // High priority
        byte[] buffer = new byte[bufferSize];
        byte[] header = new byte[10];  // 2-byte prefix + 8-byte timestamp
        ByteBuffer sendBuffer = ByteBuffer.allocate(bufferSize + 10);

        while (isRecording) {
            int bytesRead = audioRecord.read(buffer, 0, buffer.length);
            if (bytesRead > 0) {
                sendAudioDataOptimized(buffer, bytesRead, sendBuffer, header);
            }
        }
    });
    recordThread.start();
}

void sendAudioDataOptimized(byte[] data, int len, ByteBuffer buffer, byte[] header) {
    // Header: 2-byte prefix + 8-byte timestamp (nanos)
    long timestamp = System.nanoTime();
    header[0] = 0x00;
    header[1] = 0x00;
    // Pack timestamp into bytes 2-9

    buffer.clear();
    buffer.put(header);
    buffer.put(data, 0, len);
    buffer.flip();

    // Post as ProtocolMessage to EventBus → AA protocol
    ProtocolMessage msg = createAudioMessage(buffer, Channel.MIC);
    eventBus.post(msg);
}
```

### 5. SCO Audio (Bluetooth Headset)

TaaDa handles Bluetooth SCO (Synchronous Connection-Oriented) audio:

```java
// Listen for SCO state changes
IntentFilter filter = new IntentFilter(AudioManager.ACTION_SCO_AUDIO_STATE_UPDATED);
registerReceiver(scoReceiver, filter);

// When SCO connects (state == 1), start AudioRecord
// When SCO disconnects (state == 0), stop AudioRecord
```

### 6. Audio Focus Management

TaaDa manages audio focus across streams using priority rules:
```
Priority: CALL > NAVIGATION > MEDIA > SYSTEM

Actions:
- CALL starts → DUCK all others
- NAVIGATION starts → DUCK MEDIA, pause SYSTEM
- MEDIA starts → normal playback
- Any stream ends → restore lower-priority streams
```

## What We Already Have

| Component | File | Status |
|-----------|------|--------|
| Audio channel handler | `AudioChannelHandler.kt` | Complete — emits AudioFrame SharedFlow |
| Audio focus manager | `AudioFocusManager.kt` | Complete — priority state machine |
| Audio stream handler | `AudioStreamHandler.kt` | Stubbed — framework only |
| AAC encoder | `streaming/audio/AacEncoder.kt` | Complete — but for screen mirror path |

## What Needs to Change

### 1. Wire AudioChannelHandler → MediaSocketServer

```kotlin
// In TransporterService
// Media audio (channel 6)
emulator.audioMediaHandler.audioFrames.collect { frame ->
    mediaSocketServer.sendAudioData(frame.data, shouldBuffer = true)
}

// Speech audio (channel 4)
emulator.audioSpeechHandler.audioFrames.collect { frame ->
    // Mix with media or send on separate sub-channel
    mediaSocketServer.sendAudioData(frame.data, shouldBuffer = false)
}

// System audio (channel 5)
emulator.audioSystemHandler.audioFrames.collect { frame ->
    mediaSocketServer.sendAudioData(frame.data, shouldBuffer = false)
}
```

### 2. Implement Browser Audio Playback

```javascript
// Browser-side Web Audio API
const audioContext = new AudioContext({ sampleRate: 48000 });
const audioWs = new WebSocket(`wss://${host}:${audioPort}`);
audioWs.binaryType = 'arraybuffer';

audioWs.onmessage = (event) => {
    const pcmData = new Int16Array(event.data);
    const floatData = new Float32Array(pcmData.length);

    // Convert 16-bit PCM to float32
    for (let i = 0; i < pcmData.length; i++) {
        floatData[i] = pcmData[i] / 32768.0;
    }

    // Create AudioBuffer and play
    const buffer = audioContext.createBuffer(2, floatData.length / 2, 48000);
    buffer.getChannelData(0).set(floatData.filter((_, i) => i % 2 === 0));
    buffer.getChannelData(1).set(floatData.filter((_, i) => i % 2 === 1));

    const source = audioContext.createBufferSource();
    source.buffer = buffer;
    source.connect(audioContext.destination);
    source.start();
};
```

### 3. Implement Microphone Capture (Optional, Phase 6b)

For voice commands (Google Assistant via AA):

```kotlin
class MicCaptureManager(private val context: Context) {
    private var audioRecord: AudioRecord? = null
    private var isRecording = false

    fun startCapture(onAudioData: (ByteArray, Int) -> Unit) {
        val sampleRate = 16000
        val channelConfig = AudioFormat.CHANNEL_IN_MONO
        val format = AudioFormat.ENCODING_PCM_16BIT
        val bufferSize = AudioRecord.getMinBufferSize(sampleRate, channelConfig, format)

        audioRecord = AudioRecord(
            MediaRecorder.AudioSource.VOICE_RECOGNITION,
            sampleRate,
            channelConfig,
            format,
            bufferSize
        )

        isRecording = true
        audioRecord?.startRecording()

        thread(priority = Thread.MAX_PRIORITY) {
            val buffer = ByteArray(bufferSize)
            while (isRecording) {
                val bytesRead = audioRecord?.read(buffer, 0, buffer.size) ?: break
                if (bytesRead > 0) {
                    onAudioData(buffer, bytesRead)
                }
            }
        }
    }

    fun stopCapture() {
        isRecording = false
        audioRecord?.stop()
        audioRecord?.release()
        audioRecord = null
    }
}
```

### 4. Audio Focus Handling in TransporterService

```kotlin
// Wire audio focus changes to volume control
emulator.controlHandler.audioFocusRequests.collect { request ->
    audioFocusManager.handleFocusRequest(request)
}

audioFocusManager.onVolumeChange = { streamType, focusState ->
    when (focusState) {
        FocusState.DUCK -> mediaSocketServer.setVolume(0.3f)
        FocusState.LOSS -> mediaSocketServer.setVolume(0.0f)
        FocusState.GAIN -> mediaSocketServer.setVolume(1.0f)
    }
}
```

## Implementation Tasks

1. [ ] Wire `AudioChannelHandler` (×3) → `MediaSocketServer` for audio relay
2. [ ] Add audio buffering in MediaSocketServer (512KB buffer, flush logic)
3. [ ] Implement browser-side Web Audio API player for PCM playback
4. [ ] Add audio format negotiation (48kHz stereo for media, 16kHz mono for speech)
5. [ ] Implement `MicCaptureManager` for voice input (optional)
6. [ ] Wire microphone data → AA protocol mic channel (channel 7)
7. [ ] Integrate `AudioFocusManager` with TransporterService
8. [ ] Add volume ducking support in browser player
9. [ ] Handle Bluetooth SCO state for voice calls
10. [ ] Test: music plays in browser, navigation prompts are audible

## Audio Data Flow

```
┌─────────────┐     ┌──────────────────┐     ┌───────────────┐
│ Android Auto │────▶│ AudioChannel     │────▶│ MediaSocket   │
│  Media Ch 6  │     │ Handler (×3)     │     │ Server        │
│  Speech Ch 4 │     │ SharedFlow<>     │     │ Port N+1      │
│  System Ch 5 │     └──────────────────┘     │ Binary WS     │
└─────────────┘                               └───────┬───────┘
                                                      │
                                              ┌───────▼───────┐
                                              │ Tesla Browser  │
                                              │ Web Audio API  │
                                              │ PCM → Speaker  │
                                              └───────┬───────┘
                                                      │
                                              ┌───────▼───────┐
                                              │ Browser Mic    │────▶ VoiceSocket
                                              │ getUserMedia() │      Server N+2
                                              └───────────────┘      → AA Ch 7
```

## Audio Format Reference

| Stream | Sample Rate | Bits | Channels | Encoding |
|--------|------------|------|----------|----------|
| Media | 48000 Hz | 16 | 2 (stereo) | PCM |
| Speech | 16000 Hz | 16 | 1 (mono) | PCM |
| System | 16000 Hz | 16 | 1 (mono) | PCM |
| Mic Input | 16000 Hz | 16 | 1 (mono) | PCM |
