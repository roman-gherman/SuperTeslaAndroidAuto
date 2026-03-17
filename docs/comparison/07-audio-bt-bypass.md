# 07 — Audio: Bluetooth Bypass

## Problem

TaaDa defaults to routing music/navigation audio via Bluetooth A2DP, omitting those channels from ServiceDiscovery entirely. Our app always registers all audio channels, adding complexity and potentially conflicting with BT audio.

## TaaDa Approach

When `useBT=true` (default):
- Channels 5 (media, 48kHz stereo) and 7 (guidance, 16kHz mono) **omitted from ServiceDiscovery**
- Only channel 6 (system audio, 16kHz mono) registered
- Music/navigation audio goes directly via phone's Bluetooth → car speakers
- Much simpler, no audio encoding/streaming needed for those channels

When `useBT=false`:
- All 3 audio sink channels registered
- Raw PCM streamed via separate WebSocket servers

## Our Current State

- `ServiceDiscovery.kt`: `includeAudioSinks` defaults to `false` (so channels 5,7 already skipped)
- But we always register channel 6 (system audio) — correct
- `AudioChannelHandler` instantiated 3 times (media, system, speech) in `AAHeadUnitEmulator`
- All 3 audio flows wired to same `audioServer` WebSocket
- Voice server (port+2) started but **never receives data**
- No user preference to toggle BT bypass

## Changes Required

### Step 1: Verify ServiceDiscovery omits channels 5,7 by default
Check that `buildResponse(includeAudioSinks = false)` actually produces a response without media/guidance audio services. The `includeAudioSinks` parameter controls this.

### Step 2: Only register audio handlers for declared services
If channels 5,7 are omitted from SD, don't create AudioChannelHandlers for them:
```kotlin
// In AAHeadUnitEmulator:
channelMux.registerHandler(ChannelId.AUDIO_SYSTEM, audioSystemHandler)
if (config.includeAudioSinks) {
    channelMux.registerHandler(ChannelId.AUDIO_MEDIA, audioMediaHandler)
    channelMux.registerHandler(ChannelId.AUDIO_SPEECH, audioSpeechHandler)
}
```

### Step 3: Route system audio to voice WebSocket server
TaaDa routes channels 6,7 to `voiceSocketServer` (port+2) and channel 5 to `mediaAudioSocketServer` (port+1). Currently we send everything to `audioServer`. Fix:
```kotlin
// System audio (ch6) and guidance (ch7) → voiceServer
emulator.audioSystemHandler.audioFrames.collect { frame ->
    voiceServer?.sendAudioData(frame.data, shouldBuffer = false)
}
// Media audio (ch5) → audioServer (only if BT disabled)
if (config.includeAudioSinks) {
    emulator.audioMediaHandler.audioFrames.collect { frame ->
        audioServer?.sendAudioData(frame.data, shouldBuffer = true)
    }
}
```

### Step 4: Add user preference for BT audio bypass
Add to settings screen:
```kotlin
// "Use Bluetooth for music/navigation audio" toggle
// Default: true (matches TaaDa)
// When true: omit channels 5,7 from SD
// When false: register all audio channels
```

### Step 5: Stop voice server if not needed
If BT bypass is on and no system audio is being sent, don't start the voice server.

## Files to Modify
- `androidauto/src/main/java/.../proto/ServiceDiscovery.kt` (verify)
- `androidauto/src/main/java/.../headunit/AAHeadUnitEmulator.kt` (conditional handler registration)
- `app/src/main/java/com/supertesla/aa/service/TransporterService.kt` (audio routing)
- `app/src/main/java/com/supertesla/aa/ui/settings/SettingsScreen.kt` (BT toggle)

## Test Plan
- [ ] With BT bypass on: only channel 6 in ServiceDiscovery
- [ ] Music plays through car speakers via Bluetooth (not WebSocket)
- [ ] System sounds (notifications) come through WebSocket
- [ ] With BT bypass off: channels 5,6,7 all in ServiceDiscovery
- [ ] Media audio streams to audioServer WebSocket
