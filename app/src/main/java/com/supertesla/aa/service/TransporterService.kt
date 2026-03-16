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
import kotlinx.coroutines.flow.map
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

        private const val NOTIFICATION_CHANNEL_ID = "supertesla_transporter"
        private const val NOTIFICATION_ID = 1002

        val isActiveFlow = kotlinx.coroutines.flow.MutableStateFlow(false)
        val isConnectedFlow = kotlinx.coroutines.flow.MutableStateFlow(false)
        val isVideoActiveFlow = kotlinx.coroutines.flow.MutableStateFlow(false)
        val statusText = kotlinx.coroutines.flow.MutableStateFlow("Idle")

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

                // 2. Skip VPN for now — dummy TUN blocks all traffic
                Timber.i("PIPELINE: Step 2 — VPN skipped (testing)")

                // 3. Start 3 WebSocket servers
                wsBasePort = (8090 + (Math.random() * 1908).toInt())
                Timber.i("PIPELINE: Step 3 — Starting WebSocket servers on ports $wsBasePort, ${wsBasePort+1}, ${wsBasePort+2}")
                updateNotification("Starting WebSocket servers...")
                try {
                    startWebSocketServers(wsBasePort)
                    Timber.i("PIPELINE: WebSocket servers started OK")
                } catch (e: Exception) {
                    Timber.e(e, "PIPELINE: WebSocket servers FAILED")
                }

                // 4. Start Ktor web server (serves HTML player + /ws for testing)
                Timber.i("PIPELINE: Step 4 — Starting Ktor web server on port ${AppConfig.SERVER_PORT}")
                updateNotification("Starting web server...")
                val videoWidth = 1280
                val videoHeight = 720
                val touchRelay = TouchInputRelay(videoWidth, videoHeight)
                val server = WebServer(assets, AppConfig.SERVER_PORT)
                server.videoStreamHandler = VideoStreamHandler(videoWidth, videoHeight, 30)
                server.touchInputRelay = touchRelay
                webServer = server
                try {
                    server.start()
                    Timber.i("PIPELINE: Ktor web server started OK on port ${AppConfig.SERVER_PORT}")
                } catch (e: Exception) {
                    Timber.e(e, "PIPELINE: Ktor web server FAILED to start")
                }

                // 5. Create NalStreamManager
                val nalManager = NalStreamManager()
                nalStreamManager = nalManager

                // Web server is now running — accessible at http://<phone-ip>:8080/
                val serverUrl = AppConfig.getServerUrlFallback()
                updateNotification("Server ready: $serverUrl")
                Timber.i("Web server accessible at $serverUrl")

                // 6. Create AA emulator and set up connection
                updateNotification("Waiting for Android Auto...")
                val config = HeadUnitConfig()
                val emu = AAHeadUnitEmulator(config, this@TransporterService)
                emulator = emu

                // Wire touch from Ktor WebSocket → AA protocol
                touchRelay.setTouchListener(object : TouchInputRelay.TouchListener {
                    override fun onTouch(action: Int, x: Int, y: Int, pointerId: Int) {
                        emu.inputHandler?.sendTouchEvent(action, x, y, pointerId)
                    }
                })

                // Wire video focus control
                nalManager.onSendVideoFocus = { projected, unsolicited ->
                    emu.sendVideoFocus(projected, unsolicited)
                }

                // Wire emulator state changes
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
                            updateNotification("Streaming")
                        }
                        is AAHeadUnitEmulator.State.Error ->
                            updateNotification("Error: ${state.message}")
                        is AAHeadUnitEmulator.State.Disconnected -> {
                            isConnected = false
                            isVideoActive = false
                        }
                        else -> {}
                    }
                }

                // 6. Launch AA and listen for connection
                // Start listening BEFORE launching AA so the socket is ready
                launch {
                    try {
                        emu.listenAndConnect()
                    } catch (e: Exception) {
                        Timber.e(e, "AA emulator failed")
                        updateNotification("AA connection failed: ${e.message}")
                    }
                }

                // Give the server socket a moment to start, then launch AA
                kotlinx.coroutines.delay(500)
                Timber.i("Launching Android Auto...")
                try {
                    AALauncher.launchWirelessProjection(this@TransporterService)
                } catch (e: Exception) {
                    Timber.w(e, "Failed to launch Android Auto")
                    updateNotification("AA launch failed — is AA installed?")
                }

                // 7. Wire video pipeline once connected
                // VideoChannelHandler emits frames → collect and feed to NalStreamManager
                launch {
                    // Wait for emulator to be streaming
                    while (emu.state !is AAHeadUnitEmulator.State.Streaming) {
                        kotlinx.coroutines.delay(100)
                    }

                    // Start heartbeat
                    startHeartbeat(config.heartbeatIntervalMs)
                    Timber.i("Heartbeat started (${config.heartbeatIntervalMs}ms)")

                    // Wire AA video to Ktor web server's video flow (map VideoFrame → ByteArray)
                    emu.videoHandler?.let { handler ->
                        server.videoFlow = handler.videoFrames.map { it.data }
                        Timber.i("Video flow wired to Ktor web server")
                    }

                    // Collect video frames from AA and relay to browser
                    emu.videoHandler?.videoFrames?.collect { frame ->
                        isVideoActive = true
                        // Send to ControlSocketServer (TaaDa-style direct relay)
                        controlServer?.sendVideoFrame(frame.data)
                        // Feed to NalStreamManager for FPS tracking
                        nalManager.feedFrame(frame.data, frame.timestamp)
                    }
                }

                // Wire audio channels → MediaSocketServer
                launch {
                    while (emu.state !is AAHeadUnitEmulator.State.Streaming) {
                        kotlinx.coroutines.delay(100)
                    }
                    // Media audio (channel 6) — buffered
                    emu.audioMediaHandler?.audioFrames?.collect { frame ->
                        audioServer?.sendAudioData(frame.data, shouldBuffer = true)
                    }
                }
                launch {
                    while (emu.state !is AAHeadUnitEmulator.State.Streaming) {
                        kotlinx.coroutines.delay(100)
                    }
                    // Speech audio (channel 4) — immediate
                    emu.audioSpeechHandler?.audioFrames?.collect { frame ->
                        audioServer?.sendAudioData(frame.data, shouldBuffer = false)
                    }
                }
                launch {
                    while (emu.state !is AAHeadUnitEmulator.State.Streaming) {
                        kotlinx.coroutines.delay(100)
                    }
                    // System audio (channel 5) — immediate
                    emu.audioSystemHandler?.audioFrames?.collect { frame ->
                        audioServer?.sendAudioData(frame.data, shouldBuffer = false)
                    }
                }

            } catch (e: Exception) {
                Timber.e(e, "TransporterService pipeline failed")
                updateNotification("Error: ${e.message}")
                isActive = false
            }
        }
    }

    private fun startHeartbeat(intervalMs: Long) {
        stopHeartbeat()
        heartbeatJob = serviceScope.launch(Dispatchers.IO) {
            while (true) {
                try {
                    emulator?.sendHeartbeat()
                } catch (e: Exception) {
                    Timber.w(e, "Heartbeat failed")
                    break
                }
                kotlinx.coroutines.delay(intervalMs)
            }
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
                            kotlinx.coroutines.delay(100)
                            nalStreamManager?.toggleVideoFocus(true)
                        }
                    }
                    "REQUEST_KEYFRAME" -> nalStreamManager?.requestKeyFrame()
                    "PING" -> {
                        serviceScope.launch {
                            kotlinx.coroutines.delay(3000)
                            nalStreamManager?.toggleVideoFocus(true)
                        }
                    }
                    "CONNECTED" -> {
                        // Browser connected — request keyframe when video starts
                        Timber.i("Browser client connected on port $basePort")
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
        ).apply { acquire() }

        val wm = getSystemService(Context.WIFI_SERVICE) as WifiManager
        @Suppress("DEPRECATION")
        wifiLock = wm.createWifiLock(
            WifiManager.WIFI_MODE_FULL_HIGH_PERF,
            "SuperTesla::TransporterWifiLock"
        ).apply { acquire() }

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

        // Stop heartbeat
        stopHeartbeat()

        // Disconnect AA emulator
        emulator?.disconnect()
        emulator = null

        // Reset NAL manager
        nalStreamManager?.reset()
        nalStreamManager = null

        // Stop web server (catch Netty shutdown race condition)
        try { webServer?.stop() } catch (_: Exception) {}
        webServer = null

        // Stop WebSocket servers
        stopWebSocketServers()

        // Stop VPN
        stopService(Intent(this, VpnTunnelService::class.java))

        // Release locks
        releaseLocks()

        // Cancel coroutines
        pipelineJob?.cancel()
        pipelineJob = null
    }

    override fun onDestroy() {
        stopPipeline()
        serviceScope.cancel()
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
