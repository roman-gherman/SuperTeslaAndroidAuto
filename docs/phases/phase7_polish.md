# Phase 7: Polish & Production Readiness

## Goal
Make the app robust, user-friendly, and production-ready. Implement a setup wizard, auto-reconnection, adaptive streaming, battery optimization, comprehensive error handling, and a diagnostics panel.

---

## Prerequisites
- Phases 1-6 complete (all core functionality working)

---

## Tasks

### 7.1 Setup Wizard

**File:** `app/src/main/java/com/supertesla/aa/ui/wizard/SetupWizardScreen.kt`

**Purpose:** Guide first-time users through the multi-step setup process.

**Wizard Steps:**
```
Step 1: Welcome
  "SuperTesla Android Auto turns your Tesla into an Android Auto display"
  [Get Started]

Step 2: Android Auto Setup
  "Open Android Auto app → Settings → tap version 10x → Developer Settings
   → Enable 'Start head unit server'"
  [Check AA Status] → Verify HU server is accessible
  [Next]

Step 3: Hotspot
  "Enable your phone's WiFi hotspot"
  [Open Hotspot Settings] → deep link to hotspot settings
  Status: ● Hotspot detected / ○ Waiting...
  [Next] (enabled when hotspot detected)

Step 4: VPN Permission
  "SuperTesla needs VPN permission to create a local network address.
   No traffic is intercepted or monitored."
  [Grant Permission] → triggers VPN consent dialog
  [Next] (enabled after consent)

Step 5: Connect Tesla
  "On your Tesla:
   1. Connect WiFi to hotspot: [SSID_NAME]
   2. Open browser
   3. Navigate to: http://240.3.3.3:8080"
  Status: ● Tesla connected / ○ Waiting...
  [QR Code] (displays URL as QR for easy input)

Step 6: Ready!
  "Android Auto is now streaming to your Tesla!"
  Preview of current stream
  [Done]
```

**Steps:**
1. Create `SetupWizardScreen` with horizontal pager (step-by-step)
2. Implement each step as a composable with status indicators
3. Add deep links to system settings (hotspot, VPN)
4. Implement AA developer mode detection (check if HU server responds on :5277)
5. Generate QR code for Tesla browser URL
6. Persist wizard completion state (SharedPreferences)
7. Show wizard on first launch, skip on subsequent launches
8. Add "Re-run setup" option in settings

**Acceptance criteria:**
- [ ] Wizard guides user through all steps
- [ ] Status indicators update in real-time
- [ ] Deep links work to system settings
- [ ] QR code scannable and correct
- [ ] Wizard skipped after first completion

---

### 7.2 Auto-Reconnection

**File:** `app/src/main/java/com/supertesla/aa/service/ReconnectionManager.kt`

**Purpose:** Automatically recover from connection drops without user intervention.

**Reconnection scenarios:**
| Scenario | Detection | Recovery |
|---|---|---|
| Tesla browser refreshed | WebSocket close | Send new init segment on reconnect |
| WiFi momentary drop | Socket exception | Retry TCP connect with backoff |
| AA app restart | TCP connection lost to :5277 | Reconnect AA emulator from scratch |
| VPN interface lost | TUN fd invalid | Re-establish VPN |
| Phone screen off | Android doze | Wake lock + foreground service |
| Tesla sleep/wake | Browser disconnect + reconnect | Resume streaming on new WS connect |

```kotlin
class ReconnectionManager(
    private val scope: CoroutineScope
) {
    private val maxRetries = 10
    private val baseDelay = 1000L // 1 second
    private val maxDelay = 30000L // 30 seconds

    fun <T> withReconnection(
        name: String,
        connect: suspend () -> T,
        isConnected: () -> Boolean,
        onDisconnect: () -> Unit
    ) = scope.launch {
        var retries = 0
        while (isActive) {
            try {
                connect()
                retries = 0 // Reset on successful connect
                // Wait for disconnect
                while (isConnected()) delay(1000)
                onDisconnect()
            } catch (e: Exception) {
                retries++
                val delay = (baseDelay * 2.0.pow(retries)).toLong()
                    .coerceAtMost(maxDelay)
                Timber.w("$name reconnecting in ${delay}ms (attempt $retries)")
                delay(delay)
            }
        }
    }
}
```

**Steps:**
1. Implement exponential backoff retry logic
2. Add reconnection for WebSocket clients (Tesla browser)
3. Add reconnection for AA emulator (TCP to :5277)
4. Add VPN health monitoring and re-establishment
5. Handle browser page refresh (re-send init segment)
6. Add reconnection status to UI (show reconnecting indicator)
7. Limit max retries, show error after exhaustion

**Acceptance criteria:**
- [ ] Recovers from browser refresh within 2 seconds
- [ ] Recovers from WiFi blip within 5 seconds
- [ ] Recovers from AA restart within 10 seconds
- [ ] Shows reconnecting status to user
- [ ] Gives up after max retries with clear error

---

### 7.3 Adaptive Bitrate Streaming

**File:** `streaming/src/main/java/com/supertesla/aa/streaming/video/AdaptiveBitrateController.kt`

**Purpose:** Dynamically adjust video quality based on network conditions.

```kotlin
class AdaptiveBitrateController {

    data class QualityLevel(
        val width: Int,
        val height: Int,
        val fps: Int,
        val label: String
    )

    val qualityLevels = listOf(
        QualityLevel(1280, 720, 60, "720p60 (Best)"),    // MCU3
        QualityLevel(1280, 720, 30, "720p30"),
        QualityLevel(854, 480, 30, "480p30"),
        QualityLevel(640, 360, 30, "360p30"),
        QualityLevel(640, 360, 15, "360p15 (Lowest)")
    )

    private var currentLevel = 0

    fun onNetworkStats(stats: NetworkStats) {
        // Measure: round-trip time, bandwidth, dropped frames, buffer level
        when {
            stats.rtt > 200 || stats.droppedFrames > 5 -> decreaseQuality()
            stats.rtt < 50 && stats.bufferLevel < 0.5 -> increaseQuality()
        }
    }

    fun onBrowserReport(report: BrowserStats) {
        // Browser sends periodic stats via WebSocket/DataChannel
        // - frames decoded, frames dropped, buffer length, decode time
    }

    data class NetworkStats(
        val rtt: Long,
        val bandwidth: Long,
        val droppedFrames: Int,
        val bufferLevel: Double
    )
}
```

**Steps:**
1. Define quality levels (resolution + framerate combinations)
2. Implement network quality measurement (RTT via WebSocket ping)
3. Implement browser-reported stats collection (dropped frames, decode time)
4. Implement quality level switching logic
5. Request AA resolution change when switching levels
6. Handle quality level transitions smoothly (request IDR on switch)
7. Add manual quality override in settings

**Acceptance criteria:**
- [ ] Quality degrades gracefully on poor WiFi
- [ ] Quality improves when conditions improve
- [ ] No visual glitches during quality switches
- [ ] Manual override works

---

### 7.4 Battery Optimization

**File:** `app/src/main/java/com/supertesla/aa/service/BatteryManager.kt`

**Steps:**
1. Acquire partial wake lock (prevent CPU sleep during streaming)
2. Acquire WiFi lock (keep WiFi active during streaming)
3. Monitor battery level, warn user at <20%
4. Reduce quality automatically when on battery (not charging)
5. Detect USB charging (Tesla provides USB power)
6. Request battery optimization exemption (via system dialog)
7. Release all locks on service stop

```kotlin
class BatteryOptimizer(private val context: Context) {

    private var wakeLock: PowerManager.WakeLock? = null
    private var wifiLock: WifiManager.WifiLock? = null

    fun acquireLocks() {
        val pm = context.getSystemService<PowerManager>()
        wakeLock = pm.newWakeLock(
            PowerManager.PARTIAL_WAKE_LOCK,
            "SuperTeslaAA::Streaming"
        ).apply { acquire() }

        val wm = context.getSystemService<WifiManager>()
        wifiLock = wm.createWifiLock(
            WifiManager.WIFI_MODE_FULL_HIGH_PERF,
            "SuperTeslaAA::Hotspot"
        ).apply { acquire() }
    }

    fun releaseLocks() {
        wakeLock?.release()
        wifiLock?.release()
    }

    fun observeBatteryState(): Flow<BatteryState>
}
```

**Acceptance criteria:**
- [ ] Streaming doesn't stop when phone screen turns off
- [ ] WiFi hotspot remains stable during streaming
- [ ] Battery warning shown at low levels
- [ ] Quality reduces on battery to save power

---

### 7.5 Error Handling & User Messaging

**Purpose:** Replace cryptic errors with user-friendly messages and recovery actions.

**Error → Message mapping:**
| Error | User Message | Action |
|---|---|---|
| AA HU server not responding | "Android Auto head unit server not running. Enable it in AA Developer Settings." | [Open AA Settings] |
| VPN permission denied | "VPN permission required for Tesla connection." | [Grant Permission] |
| Hotspot not enabled | "Please enable your WiFi hotspot." | [Open Settings] |
| Tesla not connected | "Waiting for Tesla to connect to your hotspot..." | Show SSID + password |
| TLS handshake failed | "Connection to Android Auto failed. Restart AA app and try again." | [Retry] |
| Browser disconnected | "Tesla browser disconnected. Reconnecting..." | Auto-retry |
| Video encoding failed | "Video encoding error. Switching to lower quality." | Auto-switch |

**Steps:**
1. Map all exceptions to user-friendly error states
2. Implement `ErrorScreen` composable with message + action button
3. Add toast/snackbar notifications for transient errors
4. Log detailed errors to file for diagnostics
5. Implement "Report Bug" button that shares log file

**Acceptance criteria:**
- [ ] No raw exception messages shown to user
- [ ] Every error has a clear message and recovery action
- [ ] Transient errors auto-recover silently
- [ ] Persistent errors show actionable UI

---

### 7.6 Settings Screen

**File:** `app/src/main/java/com/supertesla/aa/ui/settings/SettingsScreen.kt`

**Settings options:**
```
Video
  ├── Resolution: Auto / 720p / 480p / 360p
  ├── Frame Rate: Auto / 60fps / 30fps / 15fps
  ├── Streaming Mode: Auto / WebRTC / MSE / MJPEG
  └── Quality: Auto / High / Medium / Low

Audio
  ├── Audio Mode: Browser / Bluetooth / Disabled
  └── Volume Boost: Off / +3dB / +6dB

Network
  ├── Virtual IP: 240.3.3.3 (editable for troubleshooting)
  ├── Server Port: 8080
  └── Use HTTPS: On / Off

Advanced
  ├── Show Debug Overlay: On / Off
  ├── Log Level: Error / Warn / Info / Debug
  ├── Export Logs: [Share]
  └── Reset Settings: [Reset]

About
  ├── Version
  ├── Open Source Licenses
  └── Report Bug
```

**Steps:**
1. Create `SettingsScreen` with sections
2. Use `DataStore<Preferences>` for persistence
3. Apply settings changes in real-time where possible
4. Restart streaming pipeline when resolution/codec changes
5. Add "Export Logs" functionality (share log file via intent)

**Acceptance criteria:**
- [ ] All settings persist across app restarts
- [ ] Settings changes take effect immediately or after restart
- [ ] Log export works

---

### 7.7 Diagnostics Panel (Web)

**File:** `web/src/main/assets/debug.html`

**Purpose:** Web-accessible diagnostics at `http://240.3.3.3:8080/debug`

**Dashboard content:**
- Connection status (WebSocket/WebRTC state)
- Streaming mode (WebRTC / MSE / MJPEG)
- Video stats (resolution, FPS, bitrate, dropped frames)
- Audio stats (sample rate, latency)
- Network stats (RTT, bandwidth estimate)
- Touch event log (last 10 events)
- AA protocol state
- Phone battery level
- Memory usage

**Steps:**
1. Create `debug.html` with auto-refreshing stats
2. Add `/api/stats` JSON endpoint to Ktor server
3. Collect stats from all subsystems
4. Display in readable dashboard format
5. Add WebSocket subscription for real-time stat updates

**Acceptance criteria:**
- [ ] Diagnostics page loads at `/debug`
- [ ] Stats update in real-time
- [ ] All subsystem health visible

---

### 7.8 Multi-Android Version Testing

**Test matrix:**
| Android Version | API Level | Key Concerns |
|---|---|---|
| 8.0 (Oreo) | 26 | Minimum SDK, LocalOnlyHotspot API |
| 9.0 (Pie) | 28 | Background restrictions |
| 10 (Q) | 29 | Scoped storage, background activity |
| 11 (R) | 30 | Package visibility |
| 12 (S) | 31 | Foreground service type requirement |
| 13 (T) | 33 | Per-app language, notification permission |
| 14 (U) | 34 | Foreground service types stricter |
| 15 | 35 | TBD |

**Steps:**
1. Test on emulators for each major version
2. Test on physical devices (minimum 2 different manufacturers)
3. Fix any version-specific issues (permissions, APIs)
4. Add version-specific code paths where needed
5. Verify foreground service type declarations for Android 14+

**Acceptance criteria:**
- [ ] App works on Android 8.0+
- [ ] No crashes on any supported version
- [ ] Permissions handled correctly per version

---

### 7.9 Tesla Firmware Compatibility

**Test across:**
- MCU2 (Intel Atom) - older, slower browser
- MCU3 (AMD Ryzen) - newer, faster browser
- Different Tesla software versions (2024.x, 2025.x)

**Steps:**
1. Test all three streaming modes on MCU2 and MCU3
2. Verify H.264 codec support on current Tesla firmware
3. Test browser memory stability over long sessions
4. Document any firmware-specific workarounds
5. Add user-agent detection for Tesla browser version

**Acceptance criteria:**
- [ ] Works on both MCU2 and MCU3
- [ ] Appropriate quality defaults per MCU type
- [ ] Stable over 1+ hour sessions

---

## Phase 7 Verification Checklist

1. [ ] Setup wizard completes successfully for new user
2. [ ] Auto-reconnection works for all disconnection scenarios
3. [ ] Adaptive bitrate adjusts smoothly
4. [ ] Battery optimization keeps streaming during screen off
5. [ ] All errors show user-friendly messages
6. [ ] Settings persist and take effect
7. [ ] Diagnostics panel shows accurate info
8. [ ] Works on Android 8.0 through 15
9. [ ] Works on MCU2 and MCU3 Tesla hardware
10. [ ] Stable 1+ hour session without memory leaks or crashes

---

## Estimated Effort
- Setup wizard: 2 days
- Auto-reconnection: 2 days
- Adaptive bitrate: 1.5 days
- Battery optimization: 0.5 day
- Error handling: 1 day
- Settings screen: 1 day
- Diagnostics panel: 1 day
- Multi-version testing: 2 days
- Tesla compatibility testing: 2 days
- Bug fixes & polish: 3 days
- **Total: ~16 days**
