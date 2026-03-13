# Phase 1: Foundation (MVP Networking)

## Goal
Establish project scaffolding, VPN networking, hotspot detection, embedded web server, and a basic phone UI. By the end, Tesla's browser can navigate to the phone's virtual IP and see a served web page.

---

## Prerequisites
- Android Studio Hedgehog+ installed
- Physical Android device (Android 8.0+) for testing
- Tesla vehicle (any model with web browser) OR Chrome on laptop connected to phone hotspot for initial dev

---

## Tasks

### 1.1 Project Scaffolding

**Create multi-module Gradle project (Kotlin DSL)**

```
SuperTeslaAndroidAuto/
├── settings.gradle.kts
├── build.gradle.kts                  # Root build file
├── gradle/
│   └── libs.versions.toml            # Version catalog
├── app/                              # :app module
│   ├── build.gradle.kts
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── java/com/supertesla/aa/
│       │   ├── App.kt                # Application class (Hilt)
│       │   ├── MainActivity.kt       # Compose entry point
│       │   ├── di/                   # Hilt modules
│       │   ├── ui/                   # Compose screens
│       │   │   ├── MainScreen.kt
│       │   │   └── theme/
│       │   └── service/
│       │       └── MainService.kt    # Foreground service
│       └── res/
├── core/                             # :core module
│   ├── build.gradle.kts
│   └── src/main/java/com/supertesla/aa/core/
│       ├── model/
│       │   └── AppState.kt           # Sealed class state machine
│       ├── util/
│       │   └── Logger.kt             # Timber wrapper
│       └── config/
│           └── AppConfig.kt          # Constants (IPs, ports)
├── network/                          # :network module
│   ├── build.gradle.kts
│   └── src/main/java/com/supertesla/aa/network/
│       ├── vpn/
│       │   └── VpnTunnelService.kt
│       ├── hotspot/
│       │   └── HotspotManager.kt
│       └── webserver/
│           └── WebServer.kt
├── androidauto/                      # :androidauto module (stub)
│   └── build.gradle.kts
├── streaming/                        # :streaming module (stub)
│   └── build.gradle.kts
└── web/                              # :web module
    ├── build.gradle.kts
    └── src/main/assets/
        ├── index.html
        ├── style.css
        └── app.js
```

**Steps:**
1. Create `settings.gradle.kts` including all 6 modules
2. Create `libs.versions.toml` with all dependency versions:
   - Kotlin 1.9.22+, AGP 8.2+
   - Ktor 2.3.7+ (server-core, server-netty, server-websockets, server-content-negotiation)
   - Hilt 2.50+, Compose BOM 2024.01+
   - Coroutines 1.7.3+, kotlinx-serialization 1.6.2+
   - Timber 5.0+, protobuf-kotlin-lite 3.25+
3. Configure each module's `build.gradle.kts` with appropriate plugins and dependencies
4. Set `minSdk = 26`, `targetSdk = 34`, `compileSdk = 34`
5. Configure proguard rules for Ktor, protobuf

**Acceptance criteria:**
- [ ] Project syncs and compiles with `./gradlew assembleDebug`
- [ ] All 6 modules resolve dependencies correctly

---

### 1.2 App State Machine

**File:** `core/src/main/java/com/supertesla/aa/core/model/AppState.kt`

```kotlin
sealed class AppState {
    object Idle : AppState()
    object StartingHotspot : AppState()
    data class HotspotReady(val ssid: String, val password: String) : AppState()
    object StartingVpn : AppState()
    data class VpnReady(val virtualIp: String) : AppState()
    object StartingServer : AppState()
    data class ServerRunning(val url: String) : AppState()
    object ConnectingAA : AppState()
    object Streaming : AppState()
    data class Error(val message: String, val recoverable: Boolean) : AppState()
}
```

**Steps:**
1. Define `AppState` sealed class with all states
2. Define `AppEvent` sealed class for state transitions
3. Create `AppStateManager` class using `MutableStateFlow<AppState>`
4. Wire state transitions with validation (e.g., can't start server before VPN is ready)

**Acceptance criteria:**
- [ ] State machine compiles, unit tests pass for valid/invalid transitions

---

### 1.3 VPN Tunnel Service

**File:** `network/src/main/java/com/supertesla/aa/network/vpn/VpnTunnelService.kt`

**Purpose:** Assign a virtual IP address (240.3.3.3) to the phone so Tesla's browser can reach it (Tesla blocks standard private IPs).

**Implementation details:**

```kotlin
class VpnTunnelService : VpnService() {

    private var tunInterface: ParcelFileDescriptor? = null

    fun establishTunnel(virtualIp: String = "240.3.3.3"): Boolean {
        val builder = Builder()
        builder.setSession("SuperTeslaAA")
        builder.addAddress(virtualIp, 32)
        builder.addRoute("192.168.43.0", 24)  // Android hotspot default subnet
        builder.setMtu(1500)
        builder.setBlocking(false)
        // Do NOT add DNS servers or default route
        // Do NOT add addRoute("0.0.0.0", 0) - we don't want to capture traffic
        tunInterface = builder.establish()
        return tunInterface != null
    }

    fun teardown() {
        tunInterface?.close()
        tunInterface = null
    }
}
```

**Key decisions:**
- Use `240.3.3.3` (Class E reserved) as primary virtual IP
- Support configurable IP for fallback testing (`100.99.9.9`, `198.18.0.1`)
- The TUN file descriptor is NOT read/written - we only use VpnService for IP assignment
- Call `protect(fd)` on all Ktor server sockets to prevent routing loops

**Manifest permissions:**
```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.FOREGROUND_SERVICE" />
<uses-permission android:name="android.permission.FOREGROUND_SERVICE_SPECIAL_USE" />

<service
    android:name=".network.vpn.VpnTunnelService"
    android:permission="android.permission.BIND_VPN_SERVICE">
    <intent-filter>
        <action android:name="android.net.VpnService" />
    </intent-filter>
</service>
```

**Steps:**
1. Implement `VpnTunnelService` extending `android.net.VpnService`
2. Add VPN permission request flow in UI (system dialog)
3. Handle VPN consent via `VpnService.prepare(context)` -> `startActivityForResult`
4. Implement `establish()` and `teardown()` methods
5. Bind service to `MainService` lifecycle
6. Add configurable virtual IP in `AppConfig`
7. Verify IP is reachable from connected WiFi client

**Acceptance criteria:**
- [ ] VPN service starts without errors
- [ ] `ip addr` on phone shows `240.3.3.3` on tun interface
- [ ] Device connected to phone's hotspot can `ping 240.3.3.3`

---

### 1.4 Hotspot Manager

**File:** `network/src/main/java/com/supertesla/aa/network/hotspot/HotspotManager.kt`

**Purpose:** Detect hotspot state, monitor connected clients, provide network info.

**Implementation details:**

```kotlin
class HotspotManager(private val context: Context) {

    // Monitor hotspot state
    fun observeHotspotState(): Flow<HotspotState>

    // Read connected clients from /proc/net/arp
    fun observeConnectedClients(): Flow<List<ConnectedClient>>

    // Get hotspot gateway IP (typically 192.168.43.1)
    fun getGatewayIp(): String?

    data class ConnectedClient(
        val ipAddress: String,
        val macAddress: String,
        val isReachable: Boolean
    )

    sealed class HotspotState {
        object Disabled : HotspotState()
        object Enabled : HotspotState()
        data class ClientConnected(val client: ConnectedClient) : HotspotState()
    }
}
```

**Key decisions:**
- Phase 1 uses manual hotspot activation (user enables it in settings)
- Poll `/proc/net/arp` every 2 seconds to detect Tesla connection
- Future: programmatic hotspot via `WifiManager.startLocalOnlyHotspot()` (has limitations)
- Emit `Flow<HotspotState>` for reactive UI updates

**Steps:**
1. Implement ARP table parser to detect connected clients
2. Create polling coroutine with `flow { while(true) { ... delay(2000) } }`
3. Add WiFi state broadcast receiver for hotspot on/off detection
4. Expose `StateFlow<HotspotState>` to MainService
5. Show connected client IP/MAC in UI

**Acceptance criteria:**
- [ ] App detects when hotspot is enabled/disabled
- [ ] App detects when Tesla connects to hotspot (shows IP + MAC)

---

### 1.5 Ktor Embedded Web Server

**File:** `network/src/main/java/com/supertesla/aa/network/webserver/WebServer.kt`

**Purpose:** Serve web frontend and handle WebSocket connections to Tesla's browser.

**Implementation details:**

```kotlin
class WebServer(
    private val assetManager: AssetManager,
    private val port: Int = 8080
) {
    private var server: ApplicationEngine? = null

    fun start(bindAddress: String = "0.0.0.0") {
        server = embeddedServer(Netty, port = port, host = bindAddress) {
            install(WebSockets) {
                pingPeriod = Duration.ofSeconds(15)
                timeout = Duration.ofSeconds(30)
                maxFrameSize = Long.MAX_VALUE
            }
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
            routing {
                // Serve web frontend
                get("/") {
                    val html = assetManager.open("index.html").bufferedReader().readText()
                    call.respondText(html, ContentType.Text.Html)
                }
                get("/style.css") { /* serve CSS */ }
                get("/app.js") { /* serve JS */ }

                // Health check
                get("/health") {
                    call.respondText("ok")
                }

                // WebSocket for touch events (Phase 4)
                webSocket("/ws") {
                    // Stub for now
                }

                // Stream endpoints (Phase 3)
                // get("/stream.mp4") { }
                // get("/stream.mjpeg") { }
            }
        }.start(wait = false)
    }

    fun stop() {
        server?.stop(1000, 2000)
        server = null
    }
}
```

**Web assets (Phase 1 - basic):**

`web/src/main/assets/index.html`:
```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <title>SuperTesla AA</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div id="status">
        <h1>SuperTesla Android Auto</h1>
        <p id="connection-status">Connecting...</p>
        <div id="video-container"></div>
    </div>
    <script src="app.js"></script>
</body>
</html>
```

**Steps:**
1. Add Ktor dependencies to `:network` module
2. Implement `WebServer` class with start/stop lifecycle
3. Serve static assets from `:web` module's assets directory
4. Add `/health` endpoint for connectivity testing
5. Stub WebSocket endpoint at `/ws`
6. Protect server sockets via `VpnService.protect()` to avoid routing loops
7. Add CORS headers (allow all origins for local network)

**Acceptance criteria:**
- [ ] Server starts on `0.0.0.0:8080`
- [ ] Browser on laptop connected to phone hotspot can reach `http://240.3.3.3:8080`
- [ ] `index.html` renders correctly
- [ ] `/health` returns "ok"

---

### 1.6 Main Foreground Service

**File:** `app/src/main/java/com/supertesla/aa/service/MainService.kt`

**Purpose:** Orchestrate all subsystems, manage lifecycle, show persistent notification.

**Implementation details:**

```kotlin
@AndroidEntryPoint
class MainService : Service() {

    @Inject lateinit var appStateManager: AppStateManager
    @Inject lateinit var hotspotManager: HotspotManager

    private var vpnService: VpnTunnelService? = null
    private var webServer: WebServer? = null

    private val notification = createNotification()

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startForeground(NOTIFICATION_ID, notification)
        startPipeline()
        return START_STICKY
    }

    private fun startPipeline() {
        serviceScope.launch {
            // Step 1: Check hotspot
            appStateManager.transition(AppState.StartingHotspot)
            hotspotManager.observeHotspotState()
                .first { it is HotspotState.Enabled }

            // Step 2: Start VPN
            appStateManager.transition(AppState.StartingVpn)
            vpnService = VpnTunnelService()
            vpnService!!.establishTunnel()

            // Step 3: Start web server
            appStateManager.transition(AppState.StartingServer)
            webServer = WebServer(assets)
            webServer!!.start()

            appStateManager.transition(
                AppState.ServerRunning("http://240.3.3.3:8080")
            )

            // Phase 2+: Start AA emulator
        }
    }
}
```

**Steps:**
1. Create foreground service with notification channel
2. Implement sequential startup pipeline (hotspot -> VPN -> server)
3. Handle each step failure with error state and user notification
4. Implement graceful shutdown (stop server -> teardown VPN -> stop service)
5. Add Hilt injection for dependencies
6. Register service in AndroidManifest with proper foreground service type

**Acceptance criteria:**
- [ ] Service starts with persistent notification
- [ ] Pipeline executes in order: hotspot check -> VPN -> server
- [ ] Service stops cleanly without leaking resources

---

### 1.7 Compose UI (Phone Dashboard)

**File:** `app/src/main/java/com/supertesla/aa/ui/MainScreen.kt`

**Purpose:** Simple phone UI to start/stop the service and show connection status.

**UI Layout:**
```
┌──────────────────────────┐
│   SuperTesla Android Auto │
├──────────────────────────┤
│                          │
│  Status: ● Server Running│
│  URL: http://240.3.3.3   │
│                          │
│  Hotspot: ✓ Enabled      │
│  VPN: ✓ Active (240.3.3.3│
│  Server: ✓ Running :8080 │
│  Tesla: ✓ Connected      │
│                          │
│  ┌────────────────────┐  │
│  │    START / STOP    │  │
│  └────────────────────┘  │
│                          │
│  Settings ⚙              │
└──────────────────────────┘
```

**Steps:**
1. Create `MainScreen` composable observing `AppState` via `collectAsStateWithLifecycle`
2. Show status indicators for each subsystem (hotspot, VPN, server, Tesla connection)
3. Big start/stop button to control `MainService`
4. Show the URL Tesla should navigate to
5. Show error messages with retry action
6. Settings link (Phase 7 - stub for now)

**Acceptance criteria:**
- [ ] UI reflects real-time state changes
- [ ] Start button triggers service, stop button kills it
- [ ] URL displayed correctly for user to type in Tesla browser

---

## Phase 1 Verification Checklist

1. [ ] `./gradlew assembleDebug` succeeds
2. [ ] App installs on physical device
3. [ ] VPN permission dialog appears and can be granted
4. [ ] VPN creates TUN interface with `240.3.3.3`
5. [ ] Hotspot detection works (shows enabled/disabled)
6. [ ] Client connection detection works (shows Tesla IP/MAC)
7. [ ] Ktor server starts on port 8080
8. [ ] Tesla browser (or laptop browser on hotspot) reaches `http://240.3.3.3:8080`
9. [ ] `index.html` loads and renders
10. [ ] `/health` endpoint responds
11. [ ] Service runs in background with notification
12. [ ] Service stops cleanly
13. [ ] UI shows correct state at each step

---

## Estimated Effort
- Project scaffolding: 1 day
- State machine: 0.5 day
- VPN service: 1 day
- Hotspot manager: 0.5 day
- Ktor web server: 1 day
- Foreground service: 0.5 day
- Compose UI: 1 day
- Testing & debugging: 1.5 days
- **Total: ~7 days**
