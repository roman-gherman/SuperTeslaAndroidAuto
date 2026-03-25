package com.supertesla.aa.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.os.IBinder
import android.os.PowerManager
import com.supertesla.aa.MainActivity
import com.supertesla.aa.androidauto.headunit.AAHeadUnitEmulator
import com.supertesla.aa.androidauto.headunit.HeadUnitConfig
import com.supertesla.aa.androidauto.launcher.AALauncher
import com.supertesla.aa.core.config.AppConfig
import com.supertesla.aa.network.hotspot.HotspotManager
import com.supertesla.aa.network.relay.ControlSocketServer
import com.supertesla.aa.network.relay.MediaSocketServer
import com.supertesla.aa.network.vpn.VpnTunnelService
import com.supertesla.aa.network.webserver.WebServer
import com.supertesla.aa.network.webserver.VideoStreamHandler
import com.supertesla.aa.network.websocket.TouchInputRelay
import com.supertesla.aa.streaming.video.NalStreamManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * TransporterService — the core service for AA protocol relay mode.
 *
 * Orchestrates:
 * 1. VPN setup (with AA package exclusion)
 * 2. WebSocket servers for video/audio/voice relay
 * 3. AA protocol: ServerSocket on port 5288, handshake, channel management
 * 4. Video pipeline: AA → NalStreamManager → WebSocket → Tesla browser
 * 5. Touch pipeline: Tesla browser → WebSocket → AA protocol
 * 6. Heartbeat (PingRequest every 2000ms)
 */
class TransporterService : Service() {

    companion object {
        const val ACTION_STOP = "com.supertesla.aa.transporter.STOP"
        const val ACTION_EXIT = "com.supertesla.aa.transporter.EXIT"

        const val EXTRA_TRIGGER_SOURCE = "trigger_source"

        /** Wake lock timeout: 4 hours in milliseconds */
        const val WAKE_LOCK_TIMEOUT_MS = 4L * 60 * 60 * 1000

        private const val NOTIFICATION_CHANNEL_ID = "supertesla_transporter"
        private const val NOTIFICATION_ID = 1002

        /** Delay between AA reconnection attempts. */
        private const val RECONNECT_DELAY_MS = 2_500L

        val isActiveFlow = kotlinx.coroutines.flow.MutableStateFlow(false)
        val isConnectedFlow = kotlinx.coroutines.flow.MutableStateFlow(false)
        val isVideoActiveFlow = kotlinx.coroutines.flow.MutableStateFlow(false)
        val statusText = kotlinx.coroutines.flow.MutableStateFlow("Idle")

        val hotspotStateFlow = kotlinx.coroutines.flow.MutableStateFlow<com.supertesla.aa.core.model.HotspotState>(
            com.supertesla.aa.core.model.HotspotState.Unknown
        )

        var isActive: Boolean
            get() = isActiveFlow.value
            set(v) { isActiveFlow.value = v }
        var isConnected: Boolean
            get() = isConnectedFlow.value
            set(v) { isConnectedFlow.value = v }
        var isVideoActive: Boolean
            get() = isVideoActiveFlow.value
            set(v) { isVideoActiveFlow.value = v }

        fun start(context: Context, triggerSource: String = "manual") {
            val intent = Intent(context, TransporterService::class.java).apply {
                putExtra(EXTRA_TRIGGER_SOURCE, triggerSource)
            }
            context.startForegroundService(intent)
        }

        fun stop(context: Context) {
            val intent = Intent(context, TransporterService::class.java).apply {
                action = ACTION_STOP
            }
            context.startService(intent)
        }
    }

    private val serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private var pipelineJob: Job? = null

    // Core components
    private var emulator: AAHeadUnitEmulator? = null
    private var nalStreamManager: NalStreamManager? = null
    private var hotspotManager: HotspotManager? = null
    private var dnsServer: com.supertesla.aa.network.dns.LocalDnsServer? = null
    private var keepaliveWatchdog: com.supertesla.aa.streaming.video.KeepaliveWatchdog? = null
    private val reconnectPolicy = com.supertesla.aa.core.util.ReconnectPolicy()

    // WebSocket servers (3-port architecture like TaaDa)
    private var controlServer: ControlSocketServer? = null
    private var audioServer: MediaSocketServer? = null
    private var voiceServer: MediaSocketServer? = null
    private var wsBasePort: Int = 0

    // Ktor web server (serves HTML player + /ws for video relay)
    private var webServer: WebServer? = null

    // Locks
    private var wakeLock: PowerManager.WakeLock? = null
    private var wifiLock: WifiManager.WifiLock? = null

    // Heartbeat
    private var heartbeatJob: Job? = null

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Timber.i("TransporterService.onStartCommand action=${intent?.action}")

        when (intent?.action) {
            ACTION_STOP, ACTION_EXIT -> {
                stopPipeline()
                stopSelf()
                return START_NOT_STICKY
            }
        }

        // Guard: don't start if already active and connected
        if (isActive && isConnected) {
            Timber.i("TransporterService already active and connected, ignoring start")
            return START_STICKY
        }

        val triggerSource = intent?.getStringExtra(EXTRA_TRIGGER_SOURCE) ?: "unknown"
        Timber.i("TransporterService starting (trigger: $triggerSource)")

        startForeground(NOTIFICATION_ID, createNotification("Starting..."))
        isActive = true

        startPipeline()
        return START_STICKY
    }

    private fun startPipeline() {
        if (pipelineJob?.isActive == true) {
            Timber.w("PIPELINE: Already active, ignoring start")
            return
        }

        Timber.i("PIPELINE: ========== STARTING PIPELINE ==========")

        pipelineJob = serviceScope.launch {
            try {
                // 1. Acquire wake/WiFi locks
                Timber.i("PIPELINE: Step 1 — Acquiring locks")
                acquireLocks()
                updateNotification("Acquiring locks...")

                // 1b. Read config from SharedPreferences
                val settingsPrefs = getSharedPreferences("settings", Context.MODE_PRIVATE)
                val configMap = mapOf(
                    "resolution" to (settingsPrefs.getString("resolution", "720p") ?: "720p"),
                    "dpi" to settingsPrefs.getInt("dpi", 120).toString(),
                    "rhd" to settingsPrefs.getBoolean("rhd", false).toString(),
                    "usebt" to settingsPrefs.getBoolean("usebt", false).toString(),
                    "usevpn" to settingsPrefs.getBoolean("usevpn", true).toString()
                )
                val config = HeadUnitConfig.fromMap(configMap)
                Timber.i("PIPELINE: Config — ${config.videoWidth}x${config.videoHeight} @ ${config.videoDensity}dpi, rhd=${config.rightHandDrive}, bt=${config.useBluetooth}, vpn=${config.useVpn}")

                // 2. Force-kill any lingering AA car process from previous session
                Timber.i("PIPELINE: Step 2 — Cleaning up old AA sessions")
                try {
                    Runtime.getRuntime().exec(arrayOf("am", "force-stop", "com.google.android.projection.gearhead"))
                    delay(500)
                } catch (_: Exception) {}

                // 2b. Start hotspot monitoring
                try {
                    val hm = HotspotManager(this@TransporterService)
                    hotspotManager = hm
                    launch {
                        hm.observeHotspotState().collect { state ->
                            hotspotStateFlow.value = state
                            Timber.d("Hotspot: $state")
                        }
                    }
                } catch (e: Exception) {
                    Timber.w(e, "Hotspot monitoring failed")
                }

                // 2b2. Detect IP and update DuckDNS BEFORE VPN (VPN breaks external DNS)
                try {
                    val hm = hotspotManager
                    var phoneIp = hm?.getGatewayIp()
                    if (phoneIp != null) {
                        Timber.i("PIPELINE: Hotspot gateway IP: $phoneIp")
                    } else {
                        val wm = getSystemService(Context.WIFI_SERVICE) as? android.net.wifi.WifiManager
                        @Suppress("DEPRECATION")
                        val wifiIp = wm?.connectionInfo?.ipAddress
                        if (wifiIp != null && wifiIp != 0) {
                            phoneIp = "${wifiIp and 0xFF}.${(wifiIp shr 8) and 0xFF}.${(wifiIp shr 16) and 0xFF}.${(wifiIp shr 24) and 0xFF}"
                            Timber.i("PIPELINE: WiFi IP (no hotspot): $phoneIp")
                        }
                    }
                    if (phoneIp != null) {
                        AppConfig.detectedHotspotIp = phoneIp
                        val duckDnsToken = settingsPrefs.getString("duckdns_token", null)
                        if (duckDnsToken != null && duckDnsToken.isNotBlank()) {
                            // Run synchronously BEFORE VPN starts (VPN breaks DNS)
                            val ok = com.supertesla.aa.network.dns.DuckDnsUpdater.update(
                                domain = AppConfig.DUCKDNS_SUBDOMAIN,
                                token = duckDnsToken,
                                ip = phoneIp
                            )
                            if (ok) {
                                updateNotification("DNS: ${AppConfig.PUBLIC_DOMAIN} → $phoneIp")
                                Timber.i("PIPELINE: DuckDNS updated: ${AppConfig.PUBLIC_DOMAIN} -> $phoneIp")
                            } else {
                                Timber.w("PIPELINE: DuckDNS update FAILED")
                            }
                        }
                    }
                } catch (e: Exception) {
                    Timber.w(e, "PIPELINE: DuckDNS update failed")
                }

                // 2c. Start VPN tunnel (creates 240.3.3.3 interface, excludes AA)
                if (config.useVpn) {
                    Timber.i("PIPELINE: Step 2c — Starting VPN tunnel")
                    updateNotification("Starting VPN...")
                    try {
                        startVpn()
                        delay(1000)
                        Timber.i("PIPELINE: VPN started")
                    } catch (e: Exception) {
                        Timber.w(e, "PIPELINE: VPN failed (non-fatal, continuing)")
                    }
                } else {
                    Timber.i("PIPELINE: VPN disabled by config")
                }

                // 2d. Start local DNS server
                Timber.i("PIPELINE: Step 2d — Starting DNS server")
                try {
                    dnsServer = com.supertesla.aa.network.dns.LocalDnsServer(
                        hostname = "super.taa",
                        virtualIp = AppConfig.DEFAULT_VIRTUAL_IP
                    )
                    dnsServer?.start()
                    Timber.i("PIPELINE: DNS server started (super.taa -> ${AppConfig.DEFAULT_VIRTUAL_IP})")
                } catch (e: Exception) {
                    Timber.w(e, "PIPELINE: DNS server failed (non-fatal)")
                }

                // 3. Start 3 WebSocket servers
                // Create keepalive watchdog (3s timeout, disables video focus on browser disconnect)
                keepaliveWatchdog = com.supertesla.aa.streaming.video.KeepaliveWatchdog(
                    scope = serviceScope,
                    timeoutMs = 5000L, // 5s timeout (browser PINGs every 2s)
                    onTimeout = {
                        // DISABLED FOR NOW — keepalive was killing video focus prematurely
                        // before browser PING could arrive. Re-enable after video works.
                        Timber.w("Browser keepalive timeout (IGNORED for now)")
                    }
                )

                wsBasePort = (8090 + (Math.random() * 1908).toInt())
                Timber.i("PIPELINE: Step 3 — Starting WebSocket servers on ports $wsBasePort, ${wsBasePort+1}, ${wsBasePort+2}")
                updateNotification("Starting WebSocket servers...")
                try {
                    startWebSocketServers(wsBasePort)
                    Timber.i("PIPELINE: WebSocket servers started OK")
                } catch (e: Exception) {
                    Timber.e(e, "PIPELINE: WebSocket servers FAILED")
                }

                // 4. Create core components FIRST (before any server starts accepting connections)
                Timber.i("PIPELINE: Step 4 — Creating NalStreamManager + AA Emulator")
                updateNotification("Initializing AA protocol...")
                val videoWidth = config.videoWidth
                val videoHeight = config.videoHeight

                val nalManager = NalStreamManager()
                nalStreamManager = nalManager
                Timber.i("PIPELINE: NalStreamManager created")

                val emu = AAHeadUnitEmulator(config, this@TransporterService)
                emulator = emu
                Timber.i("PIPELINE: AA Emulator created")

                // Wire video focus: NalStreamManager → AA Emulator
                nalManager.onSendVideoFocus = { projected, unsolicited ->
                    emu.sendVideoFocus(projected, unsolicited)
                }

                // Wire emulator state changes — also used by reconnect loop to stop heartbeat
                emu.onStateChanged = { state ->
                    Timber.i("AA Emulator state: ${state::class.simpleName}")
                    when (state) {
                        is AAHeadUnitEmulator.State.Listening ->
                            updateNotification("Waiting for Android Auto...")
                        is AAHeadUnitEmulator.State.Handshake ->
                            updateNotification("Handshaking with Android Auto...")
                        is AAHeadUnitEmulator.State.Connected ->
                            updateNotification("Connected to Android Auto")
                        is AAHeadUnitEmulator.State.Streaming -> {
                            isConnected = true
                            reconnectPolicy.reset()
                            updateNotification("Streaming")
                        }
                        is AAHeadUnitEmulator.State.Error -> {
                            // Connection dropped — stop heartbeat immediately so it
                            // does not keep hammering a dead socket.
                            stopHeartbeat()
                            isConnected = false
                            isVideoActive = false
                            updateNotification("Reconnecting... (${state.message})")
                        }
                        is AAHeadUnitEmulator.State.Disconnected -> {
                            stopHeartbeat()
                            isConnected = false
                            isVideoActive = false
                        }
                        else -> {}
                    }
                }

                // 5. Start Ktor web server (AFTER core components are created)
                Timber.i("PIPELINE: Step 5 — Starting Ktor web server on port ${AppConfig.SERVER_PORT}")
                updateNotification("Starting web server...")
                val touchRelay = TouchInputRelay(videoWidth, videoHeight)
                val server = WebServer(assets, AppConfig.SERVER_PORT)
                server.videoStreamHandler = VideoStreamHandler(videoWidth, videoHeight, 30)
                server.touchInputRelay = touchRelay
                server.configVideoWidth = videoWidth
                server.configVideoHeight = videoHeight
                server.configUseBt = config.useBluetooth
                server.onAction = { action, _ ->
                    when (action) {
                        "START" -> {
                            Timber.i("Ktor WS: START → enabling video focus")
                            keepaliveWatchdog?.start()
                            nalStreamManager?.toggleVideoFocus(true)
                            // Request keyframe so browser gets a decodable frame
                            nalStreamManager?.requestKeyFrame()
                        }
                        "STOP" -> {
                            keepaliveWatchdog?.cancel()
                            nalStreamManager?.toggleVideoFocus(false)
                        }
                        "ACK" -> emulator?.videoHandler?.sendAck()
                        "PING" -> keepaliveWatchdog?.reset()
                        "REQUEST_KEYFRAME" -> nalStreamManager?.requestKeyFrame()
                        "RELOAD" -> {
                            nalStreamManager?.toggleVideoFocus(false)
                            serviceScope.launch { delay(100); nalStreamManager?.toggleVideoFocus(true) }
                        }
                    }
                }
                // Wire touch → AA protocol
                touchRelay.setTouchListener(object : TouchInputRelay.TouchListener {
                    override fun onTouch(action: Int, x: Int, y: Int, pointerId: Int) {
                        emu.inputHandler?.sendTouchEvent(action, x, y, pointerId)
                    }
                })
                webServer = server
                try {
                    server.start()
                    Timber.i("PIPELINE: Ktor web server started OK")
                } catch (e: Exception) {
                    Timber.e(e, "PIPELINE: Ktor web server FAILED to start")
                }

                val serverUrl = AppConfig.getServerUrlFallback()
                updateNotification("Server ready: $serverUrl")
                Timber.i("Web server accessible at $serverUrl")

                // Give the server socket a moment to start, then launch AA once.
                delay(500)
                Timber.i("PIPELINE: Launching Android Auto for initial connection...")
                try {
                    AALauncher.launchWirelessProjection(this@TransporterService)
                } catch (e: Exception) {
                    Timber.w(e, "Failed to launch Android Auto")
                    updateNotification("AA launch failed — is AA installed?")
                }

                // 7. Reconnect loop — runs for the lifetime of the pipeline coroutine.
                //    Each iteration:
                //      a. Spin up per-session coroutines for heartbeat + media flows.
                //      b. Call listenAndConnect() — suspends until the read loop exits.
                //      c. Cancel per-session coroutines, wait RECONNECT_DELAY_MS, retry.
                reconnectPolicy.reset()
                while (isActive && !reconnectPolicy.isExhausted) {
                    reconnectPolicy.recordAttempt()
                    if (reconnectPolicy.attempts > 1) {
                        Timber.i("RECONNECT: Attempt #${reconnectPolicy.attempts}/${reconnectPolicy.maxAttempts} — waiting ${reconnectPolicy.delayMs}ms")
                        updateNotification("Reconnecting (${reconnectPolicy.attempts}/${reconnectPolicy.maxAttempts})...")
                        delay(reconnectPolicy.delayMs)
                        if (!isActive) break

                        // Re-launch AA so the phone re-initiates the TCP connection.
                        Timber.i("RECONNECT: Re-launching Android Auto...")
                        try {
                            AALauncher.launchWirelessProjection(this@TransporterService)
                        } catch (e: Exception) {
                            Timber.w(e, "RECONNECT: Failed to re-launch Android Auto")
                        }
                        delay(500)
                        if (!isActive) break
                    }

                    // Per-session child jobs: heartbeat + all media flow collectors.
                    // These are cancelled as soon as listenAndConnect() returns so that
                    // dead-socket sends and stale-handler collects stop immediately.
                    val sessionJob = launch {
                        // Wait until the emulator reports Streaming before starting flows.
                        while (emu.state !is AAHeadUnitEmulator.State.Streaming) {
                            delay(50)
                            if (!isActive) return@launch
                        }

                        // Heartbeat
                        startHeartbeat(config.heartbeatIntervalMs)
                        Timber.i("SESSION: Heartbeat started (${config.heartbeatIntervalMs}ms)")

                        // Wire AA video to Ktor web server
                        launch {
                            emu.videoHandler?.let { handler ->
                                // Set videoFlow — the setter pipes into videoSharedFlow
                                server.videoFlow = handler.videoFrames.map { it.data }
                                Timber.i("SESSION: Video flow wired to Ktor web server")

                                server.onClientConnected = {
                                    // Forward cached codec config + IDR so late-joining
                                    // browsers can configure WebCodecs and decode immediately.
                                    handler.cachedCodecConfig?.let { config ->
                                        server.videoStreamHandler?.cachedCodecConfig = config
                                    }
                                    handler.cachedIdr?.let { idr ->
                                        server.videoStreamHandler?.cachedIdr = idr
                                    }
                                    Timber.d("Browser client connected (keyframe will be requested on START)")
                                }
                            }

                            emu.videoHandler?.videoFrames?.collect { frame ->
                                isVideoActive = true
                                // Keep the web server's codec config + IDR cache up to date
                                emu.videoHandler?.let { vh ->
                                    vh.cachedCodecConfig?.let { server.videoStreamHandler?.cachedCodecConfig = it }
                                    vh.cachedIdr?.let { server.videoStreamHandler?.cachedIdr = it }
                                }
                                controlServer?.sendVideoFrame(frame.data)
                                nalManager.feedFrame(frame.data, frame.timestamp)
                            }
                        }

                        // Wire audio channels → legacy MediaSocketServer + Ktor WebServer
                        launch {
                            emu.audioMediaHandler?.audioFrames?.collect { frame ->
                                audioServer?.sendAudioData(frame.data, shouldBuffer = true)
                                server.audioMediaFlow.emit(frame.data)
                            }
                        }
                        launch {
                            emu.audioSpeechHandler?.audioFrames?.collect { frame ->
                                audioServer?.sendAudioData(frame.data, shouldBuffer = false)
                                server.audioSpeechFlow.emit(frame.data)
                            }
                        }
                        launch {
                            emu.audioSystemHandler?.audioFrames?.collect { frame ->
                                audioServer?.sendAudioData(frame.data, shouldBuffer = false)
                                server.audioSystemFlow.emit(frame.data)
                            }
                        }
                    }

                    // Block until the AA session ends (EOF / IOException / explicit cancel).
                    Timber.i("RECONNECT: Calling listenAndConnect() (attempt #${reconnectPolicy.attempts})")
                    try {
                        emu.listenAndConnect()
                        Timber.i("RECONNECT: listenAndConnect() returned — session ended")
                    } catch (e: Exception) {
                        Timber.e(e, "RECONNECT: listenAndConnect() threw unexpectedly")
                        updateNotification("AA connection error: ${e.message}")
                    }

                    // Session is over — cancel per-session work and stop heartbeat.
                    sessionJob.cancel()
                    stopHeartbeat()
                    isConnected = false
                    isVideoActive = false

                    if (!isActive) {
                        Timber.i("RECONNECT: Pipeline cancelled — not retrying")
                        break
                    }

                    Timber.i("RECONNECT: Session ended, will retry in ${reconnectPolicy.delayMs}ms")
                }

                // Exhausted all reconnect attempts
                if (reconnectPolicy.isExhausted && isActive) {
                    Timber.e("RECONNECT: Exhausted ${reconnectPolicy.maxAttempts} attempts — stopping")
                    statusText.value = "Connection failed after ${reconnectPolicy.maxAttempts} attempts"
                    updateNotification("Connection failed")
                }

            } catch (e: OutOfMemoryError) {
                Timber.e("OOM in TransporterService pipeline! Scheduling restart...")
                Companion.isActive = false
                Companion.isConnected = false
                Companion.isVideoActive = false
                statusText.value = "Out of memory — restarting..."
                // Schedule restart after 3 seconds
                android.os.Handler(android.os.Looper.getMainLooper()).postDelayed({
                    try { start(this@TransporterService) } catch (_: Exception) {}
                }, 3000)
                stopSelf()
            } catch (e: Exception) {
                Timber.e(e, "TransporterService pipeline failed")
                updateNotification("Error: ${e.message}")
                Companion.isActive = false
            }
        }
    }

    private fun startHeartbeat(intervalMs: Long) {
        stopHeartbeat()
        Timber.i("HEARTBEAT: Starting (interval=${intervalMs}ms)")
        heartbeatJob = serviceScope.launch(Dispatchers.IO) {
            while (isActive) {
                val emu = emulator
                if (emu == null) {
                    Timber.w("HEARTBEAT: No emulator — stopping heartbeat")
                    break
                }
                val sent = try {
                    emu.sendHeartbeat()
                } catch (e: Exception) {
                    Timber.w(e, "HEARTBEAT: Exception — stopping heartbeat")
                    false
                }
                if (!sent) {
                    // sendHeartbeat() returned false → not connected; no point continuing.
                    Timber.w("HEARTBEAT: sendHeartbeat() returned false — stopping heartbeat loop")
                    break
                }
                delay(intervalMs)
            }
            Timber.i("HEARTBEAT: Loop exited")
        }
    }

    private fun stopHeartbeat() {
        heartbeatJob?.cancel()
        heartbeatJob = null
    }

    private fun startWebSocketServers(basePort: Int) {
        val ctrl = ControlSocketServer(
            port = basePort,
            onAction = { action, json ->
                when (action) {
                    "START" -> nalStreamManager?.toggleVideoFocus(true)
                    "STOP", "DISCONNECTED" -> nalStreamManager?.toggleVideoFocus(false)
                    "RELOAD" -> {
                        nalStreamManager?.toggleVideoFocus(false)
                        serviceScope.launch {
                            delay(100)
                            nalStreamManager?.toggleVideoFocus(true)
                        }
                    }
                    "REQUEST_KEYFRAME" -> nalStreamManager?.requestKeyFrame()
                    "PING" -> {
                        // Reset keepalive watchdog on each PING
                        keepaliveWatchdog?.reset()
                    }
                    "ACK" -> {
                        // Forward video ACK to AA protocol
                        emulator?.videoHandler?.sendAck()
                    }
                    "CONNECTED" -> {
                        // Browser connected — start keepalive watchdog
                        Timber.i("Browser client connected on port $basePort")
                        keepaliveWatchdog?.start()
                    }
                }
            },
            onTouch = { action, x, y, pointerId ->
                // Forward touch events directly to AA protocol
                emulator?.inputHandler?.sendTouchEvent(action, x, y, pointerId)
            }
        )
        ctrl.isReuseAddr = true
        ctrl.start()
        controlServer = ctrl
        Timber.i("ControlSocketServer started on port $basePort")

        val audio = MediaSocketServer(basePort + 1, "AudioSocket")
        audio.isReuseAddr = true
        audio.start()
        audioServer = audio
        Timber.i("AudioSocketServer started on port ${basePort + 1}")

        val voice = MediaSocketServer(basePort + 2, "VoiceSocket")
        voice.isReuseAddr = true
        voice.start()
        voiceServer = voice
        Timber.i("VoiceSocketServer started on port ${basePort + 2}")
    }

    private fun stopWebSocketServers() {
        try { controlServer?.stop(1000) } catch (_: Exception) {}
        controlServer = null
        try { audioServer?.stop(1000) } catch (_: Exception) {}
        audioServer = null
        try { voiceServer?.stop(1000) } catch (_: Exception) {}
        voiceServer = null
    }

    private fun startVpn() {
        val vpnIntent = Intent(this, VpnTunnelService::class.java).apply {
            putExtra(VpnTunnelService.EXTRA_VIRTUAL_IP, AppConfig.DEFAULT_VIRTUAL_IP)
        }
        startService(vpnIntent)
    }

    private fun acquireLocks() {
        val pm = getSystemService(Context.POWER_SERVICE) as PowerManager
        wakeLock = pm.newWakeLock(
            PowerManager.PARTIAL_WAKE_LOCK,
            "SuperTesla::TransporterWakeLock"
        ).apply { acquire(WAKE_LOCK_TIMEOUT_MS) }

        val wm = getSystemService(Context.WIFI_SERVICE) as WifiManager
        @Suppress("DEPRECATION")
        wifiLock = wm.createWifiLock(
            WifiManager.WIFI_MODE_FULL_HIGH_PERF,
            "SuperTesla::TransporterWifiLock"
        ).apply { acquire() } // WiFi lock has no timeout API

        Timber.d("Wake and WiFi locks acquired")
    }

    private fun releaseLocks() {
        wakeLock?.let { if (it.isHeld) it.release() }
        wakeLock = null
        wifiLock?.let { if (it.isHeld) it.release() }
        wifiLock = null
        Timber.d("Locks released")
    }

    private fun stopPipeline() {
        Timber.i("Stopping TransporterService pipeline")
        isActive = false
        isConnected = false
        isVideoActive = false
        statusText.value = "Stopping..."

        // Cancel coroutines first to stop all background work
        pipelineJob?.cancel()
        pipelineJob = null

        // Stop heartbeat
        try { stopHeartbeat() } catch (_: Exception) {}

        // Disconnect AA emulator
        try {
            emulator?.disconnect()
        } catch (_: Exception) {}
        emulator = null

        // Reset NAL manager
        try { nalStreamManager?.reset() } catch (_: Exception) {}
        nalStreamManager = null

        // Stop web server in background to avoid Netty crash
        val ws = webServer
        webServer = null
        if (ws != null) {
            Thread {
                try { ws.stop() } catch (_: Exception) {}
            }.start()
        }

        // Notify WebSocket clients of shutdown (TaaDa sends server_shutdown JSON)
        try {
            val ctrl = controlServer
            if (ctrl != null) {
                val notifier = com.supertesla.aa.core.util.ShutdownNotifier(
                    broadcast = { msg -> ctrl.broadcast(msg) }
                )
                kotlinx.coroutines.runBlocking { notifier.notifyAndDrain() }
            }
        } catch (_: Exception) {}

        // Stop WebSocket servers
        try { stopWebSocketServers() } catch (_: Exception) {}

        // Cancel keepalive watchdog
        try { keepaliveWatchdog?.cancel() } catch (_: Exception) {}
        keepaliveWatchdog = null

        // Stop DNS server
        try { dnsServer?.stop() } catch (_: Exception) {}
        dnsServer = null

        // Stop VPN
        try {
            stopService(Intent(this, VpnTunnelService::class.java))
        } catch (_: Exception) {}

        // Release locks
        try { releaseLocks() } catch (_: Exception) {}

        statusText.value = "Idle"
    }

    override fun onDestroy() {
        try { stopPipeline() } catch (_: Exception) {}
        try { serviceScope.cancel() } catch (_: Exception) {}
        super.onDestroy()
    }

    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            NOTIFICATION_CHANNEL_ID,
            "AA Transporter Service",
            NotificationManager.IMPORTANCE_LOW
        ).apply {
            description = "Shows when Android Auto relay is active"
            setShowBadge(false)
        }
        getSystemService(NotificationManager::class.java).createNotificationChannel(channel)
    }

    private fun createNotification(text: String): Notification {
        val pendingIntent = PendingIntent.getActivity(
            this, 0,
            Intent(this, MainActivity::class.java),
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val stopIntent = PendingIntent.getService(
            this, 1,
            Intent(this, TransporterService::class.java).apply { action = ACTION_STOP },
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        return Notification.Builder(this, NOTIFICATION_CHANNEL_ID)
            .setContentTitle("SuperTesla AA Relay")
            .setContentText(text)
            .setSmallIcon(android.R.drawable.ic_media_play)
            .setContentIntent(pendingIntent)
            .addAction(Notification.Action.Builder(null, "Stop", stopIntent).build())
            .setOngoing(true)
            .build()
    }

    private fun updateNotification(text: String) {
        statusText.value = text
        try {
            getSystemService(NotificationManager::class.java)
                .notify(NOTIFICATION_ID, createNotification(text))
        } catch (e: Exception) {
            Timber.w(e, "Failed to update notification")
        }
    }
}
