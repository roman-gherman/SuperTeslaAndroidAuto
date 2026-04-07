# v3: Cleanup, UI Polish, and Performance Optimization

## Context
v2 is functional (video, audio, touch, cloud relay, approval flow all working on Tesla). v3 focuses on code quality, removing dead code, polishing UI, and optimizing performance for a production release.

## Phase 1: Dead Code Removal

### Delete unused WebRTC files (3 files, ~400 lines, 0 callers)
- `network/src/main/java/com/supertesla/aa/network/webrtc/WebRtcManager.kt`
- `network/src/main/java/com/supertesla/aa/network/webrtc/AaVideoCapturer.kt`
- `network/src/main/java/com/supertesla/aa/network/webrtc/SignalingHandler.kt`

### Remove WebRTC imports/fields from WebServer.kt
- Remove `import SignalingHandler`, `import WebRtcManager` (lines 28-29)
- Remove `signalingHandler` field and `signalingHandler?.registerRoutes(this)` call
- Remove `diagnosticInfo` field if unused

### Remove VPN permission UI from SetupWizardScreen.kt
- Remove VPN launcher code (contradicts "no VPN needed" text)
- Remove VPN permission check from PermissionsScreen.kt

### Remove legacy WebRTC dependencies from build.gradle
- Check if webrtc dependency exists in gradle files

## Phase 2: UI Polish

### SettingsScreen.kt
- Use `BuildConfig.VERSION_NAME` instead of hardcoded "0.1.0"
- Add "Relay URL" info setting showing the room URL
- Add "Revoke All Sessions" button (calls `relayClient.revokeAllKeys()`)
- Clean up developer mode consistency

### MainScreen.kt
- Already well-polished, minimal changes
- Ensure approval card dismisses reliably
- Add relay connection status indicator (connected/disconnected to cloud)

### SetupWizardScreen.kt
- Remove VPN step, simplify to 3 pages: Welcome → Hotspot → Connect Tesla
- Update Connect Tesla page with cloud relay URL instead of VPN IP

## Phase 3: Performance Optimization

### Fix GlobalScope leak in WebServer.kt
- Replace `GlobalScope.launch` with a proper coroutine scope that cancels on stop

### Player.js video resolution from config
- Use config-driven `codedWidth`/`codedHeight` instead of hardcoded 1280x720
- Apply when CONFIG message received via relay

### Cloud Run cold start mitigation
- Add WebSocket ping/pong keepalive in relay server (every 30s)
- Consider `--min-instances 1` for production (~$10/month)

### Audio optimization
- Current jitter buffer (150ms base, 300ms recovery) is well-tuned
- No changes needed

## Phase 4: Error Handling

### TransporterService.kt
- Log force-stop failures (currently silently swallowed)
- Differentiate network errors (retry) from protocol errors (stop) in reconnect
- Add relay connection status to notification

### CloudRelayClient.kt
- Handle backpressure when Tesla disconnects (video flow keeps emitting)
- Add connection timeout (currently waits indefinitely)

## Phase 5: Test Additions

### Add to dead code absence tests
- Test that WebRtcManager, AaVideoCapturer, SignalingHandler are removed

### Relay server tests
- Room registration / lookup
- Session key validation
- Pairing code create/lookup/expire

## Files to Delete
- `network/.../webrtc/WebRtcManager.kt`
- `network/.../webrtc/AaVideoCapturer.kt`
- `network/.../webrtc/SignalingHandler.kt`

## Files to Modify
- `network/.../webserver/WebServer.kt` — remove WebRTC imports/fields, fix GlobalScope
- `app/.../ui/settings/SettingsScreen.kt` — BuildConfig version, relay URL, revoke button
- `app/.../ui/wizard/SetupWizardScreen.kt` — remove VPN step
- `app/.../ui/PermissionsScreen.kt` — remove VPN permission
- `app/.../service/TransporterService.kt` — improve error handling
- `relay/public/player.js` — config-driven resolution
- `relay/src/server.js` — WebSocket keepalive

## Verification
1. `./gradlew test` — all tests pass
2. `./gradlew assembleDebug` — builds clean
3. Deploy relay, test on laptop browser — video + audio + touch work
4. Test on Tesla — no regressions
