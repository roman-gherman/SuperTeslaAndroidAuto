package com.supertesla.aa.service

import android.app.Activity
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import com.supertesla.aa.MainActivity
import com.supertesla.aa.core.config.AppConfig
import com.supertesla.aa.core.model.AppState
import com.supertesla.aa.core.model.AppStateManager
import com.supertesla.aa.core.model.HotspotState
import com.supertesla.aa.network.dns.MdnsServiceRegistrar
import com.supertesla.aa.network.hotspot.HotspotManager
import com.supertesla.aa.network.vpn.VpnTunnelService
import com.supertesla.aa.network.webrtc.SignalingHandler
import com.supertesla.aa.network.webrtc.WebRtcManager
import com.supertesla.aa.network.webserver.VideoStreamHandler
import com.supertesla.aa.network.webserver.WebServer
import com.supertesla.aa.network.websocket.TouchInputRelay
import com.supertesla.aa.streaming.capture.ScreenCaptureManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainService : Service() {

    @Inject lateinit var appStateManager: AppStateManager
    @Inject lateinit var hotspotManager: HotspotManager

    private val serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
    private var pipelineJob: Job? = null
    private var webServer: WebServer? = null
    private var mdnsRegistrar: MdnsServiceRegistrar? = null
    private var screenCapture: ScreenCaptureManager? = null
    private var webRtcManager: WebRtcManager? = null
    private var batteryOptimizer: BatteryOptimizer? = null
    private var reconnectionManager: ReconnectionManager? = null

    inner class LocalBinder : Binder() {
        val service: MainService get() = this@MainService
    }

    private val binder = LocalBinder()

    override fun onBind(intent: Intent?): IBinder = binder

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        android.util.Log.i("SuperTeslaAA", "onStartCommand action=${intent?.action}")
        when (intent?.action) {
            ACTION_STOP -> {
                stopPipeline()
                stopSelf()
                return START_NOT_STICKY
            }
            ACTION_START_CAPTURE -> {
                // Start screen capture with the permission result
                val resultCode = intent.getIntExtra(EXTRA_RESULT_CODE, Activity.RESULT_CANCELED)
                val data = intent.getParcelableExtra<Intent>(EXTRA_DATA)
                if (resultCode == Activity.RESULT_OK && data != null) {
                    startScreenCapture(resultCode, data)
                }
                return START_STICKY
            }
        }

        startForeground(AppConfig.NOTIFICATION_ID, createNotification("Starting..."))
        startPipeline()
        return START_STICKY
    }

    private fun startPipeline() {
        if (pipelineJob?.isActive == true) return

        pipelineJob = serviceScope.launch {
            try {
                // Acquire wake/WiFi locks to keep streaming stable
                val optimizer = BatteryOptimizer(this@MainService)
                batteryOptimizer = optimizer
                optimizer.acquireLocks()

                // Step 1: Wait for hotspot
                appStateManager.transition(AppState.StartingHotspot)
                updateNotification("Waiting for hotspot...")

                hotspotManager.observeHotspotState().first { state ->
                    appStateManager.updateHotspotState(state)
                    state is HotspotState.Enabled || state is HotspotState.ClientConnected
                }
                appStateManager.transition(AppState.HotspotReady("Hotspot"))

                // Step 2: Start VPN
                appStateManager.transition(AppState.StartingVpn)
                updateNotification("Setting up network...")

                val vpnIntent = Intent(this@MainService, VpnTunnelService::class.java).apply {
                    putExtra(VpnTunnelService.EXTRA_VIRTUAL_IP, AppConfig.DEFAULT_VIRTUAL_IP)
                }
                startService(vpnIntent)
                appStateManager.transition(AppState.VpnReady(AppConfig.DEFAULT_VIRTUAL_IP))

                // Step 3: Start web server
                appStateManager.transition(AppState.StartingServer)
                updateNotification("Starting server...")

                val videoWidth = 1280
                val videoHeight = 720

                val touchRelay = TouchInputRelay(videoWidth, videoHeight)

                // Wire touch events to AccessibilityService for injection
                touchRelay.setTouchListener(object : TouchInputRelay.TouchListener {
                    override fun onTouch(action: Int, x: Int, y: Int, pointerId: Int) {
                        val injector = TouchInjectionService.instance
                        if (injector == null) {
                            Timber.w("Touch event ignored — AccessibilityService not enabled")
                            return
                        }
                        val fx = x.toFloat()
                        val fy = y.toFloat()
                        when (action) {
                            TouchInputRelay.ACTION_DOWN -> injector.onTouchDown(pointerId, fx, fy)
                            TouchInputRelay.ACTION_MOVE -> injector.onTouchMove(pointerId, fx, fy)
                            TouchInputRelay.ACTION_UP -> injector.onTouchUp(pointerId, fx, fy)
                        }
                    }
                })

                val server = WebServer(assets, AppConfig.SERVER_PORT)
                server.videoStreamHandler = VideoStreamHandler(videoWidth, videoHeight, 30)
                server.touchInputRelay = touchRelay

                // Wire WebRTC signaling (lazy init — no native libs loaded until first offer)
                try {
                    val rtcManager = WebRtcManager(this@MainService)
                    rtcManager.setTouchRelay(touchRelay)
                    server.signalingHandler = SignalingHandler(rtcManager)
                    webRtcManager = rtcManager

                    // Pass MediaProjection if screen capture already started
                    screenCapture?.mediaProjection?.let { rtcManager.setMediaProjection(it) }
                } catch (e: Exception) {
                    Timber.w(e, "WebRTC setup skipped (not available)")
                }

                // Diagnostic endpoint
                server.diagnosticInfo = {
                    val cap = screenCapture
                    """{"capturing":${cap?.isCapturing},"encoderFrames":${cap?.totalFramesEncoded ?: 0},"videoFlowWired":${server.videoFlow != null},"webRtcInit":${webRtcManager?.isInitialized},"webRtcConnected":${webRtcManager?.isConnected}}"""
                }

                // Request keyframe when a new browser client connects (ensures fast first frame)
                server.onClientConnected = {
                    screenCapture?.requestKeyframe()
                    Timber.d("New client connected — keyframe requested")
                }

                webServer = server
                server.start()

                // Register mDNS
                val mdns = MdnsServiceRegistrar(this@MainService)
                mdnsRegistrar = mdns
                mdns.register(AppConfig.SERVER_PORT)

                // Detect hotspot IP
                val hotspotIp = hotspotManager.getGatewayIp()
                if (hotspotIp != null) {
                    AppConfig.detectedHotspotIp = hotspotIp
                }

                val serverUrl = AppConfig.getServerUrl()
                appStateManager.transition(AppState.ServerRunning(serverUrl))
                updateNotification("Ready - $serverUrl")

                // Monitor hotspot state and handle disconnects
                val reconManager = ReconnectionManager(this)
                reconnectionManager = reconManager

                reconManager.monitor(
                    name = "hotspot",
                    connect = {
                        // Wait for hotspot to come back
                        hotspotManager.observeHotspotState().first { state ->
                            state is HotspotState.Enabled || state is HotspotState.ClientConnected
                        }
                    },
                    isConnected = {
                        val state = appStateManager.hotspotState.value
                        state is HotspotState.Enabled || state is HotspotState.ClientConnected
                    },
                    onDisconnect = {
                        Timber.w("Hotspot disconnected — waiting for reconnect...")
                        updateNotification("Hotspot lost - reconnecting...")
                    }
                )

                // Continuously monitor hotspot state
                launch {
                    hotspotManager.observeHotspotState().collect { state ->
                        appStateManager.updateHotspotState(state)

                        // Request keyframe when Tesla reconnects
                        if (state is HotspotState.ClientConnected) {
                            screenCapture?.requestKeyframe()
                            updateNotification("Streaming - $serverUrl")
                        }
                    }
                }

                // Monitor battery and warn on low levels
                launch {
                    optimizer.observeBatteryState().collect { battery ->
                        if (battery.isLow && !battery.isCharging) {
                            Timber.w("Low battery: ${battery.level}% — consider charging")
                            updateNotification("Streaming - Battery ${battery.level}%")
                        }
                    }
                }

                // Wire screen capture video to web server if already capturing
                screenCapture?.let { capture ->
                    server.videoFlow = capture.videoFrames
                    if (capture.isCapturing) {
                        appStateManager.transition(AppState.Streaming)
                        updateNotification("Streaming - $serverUrl")
                    }
                }

            } catch (e: Exception) {
                Timber.e(e, "Pipeline failed")
                appStateManager.transition(AppState.Error(e.message ?: "Unknown error"))
                updateNotification("Error: ${e.message}")
            }
        }
    }

    /**
     * Start screen capture after permission is granted.
     * Called from MainActivity with the MediaProjection permission result.
     */
    private fun startScreenCapture(resultCode: Int, data: Intent) {
        android.util.Log.i("SuperTeslaAA", "startScreenCapture called, resultCode=$resultCode")
        val capture = ScreenCaptureManager(
            width = 1280, height = 720, fps = 30
        )
        screenCapture = capture
        capture.startCapture(this, resultCode, data)
        android.util.Log.i("SuperTeslaAA", "Screen capture started, isCapturing=${capture.isCapturing}")

        // Wire video to web server (fMP4/WebSocket path)
        webServer?.videoFlow = capture.videoFrames
        android.util.Log.i("SuperTeslaAA", "Video flow wired to webServer, webServer=${webServer != null}")

        // Pass MediaProjection to WebRTC so it can create its own VirtualDisplay
        capture.mediaProjection?.let { mp ->
            webRtcManager?.setMediaProjection(mp)
            android.util.Log.i("SuperTeslaAA", "MediaProjection passed to WebRTC")
        }

        val serverUrl = AppConfig.getServerUrl()
        appStateManager.transition(AppState.Streaming)
        updateNotification("Streaming - $serverUrl")
        Timber.i("Screen capture streaming started")
    }

    private fun stopPipeline() {
        Timber.d("Stopping pipeline")
        pipelineJob?.cancel()
        pipelineJob = null

        reconnectionManager?.cancelAll()
        reconnectionManager = null

        batteryOptimizer?.releaseLocks()
        batteryOptimizer = null

        webRtcManager?.shutdown()
        webRtcManager = null

        screenCapture?.stopCapture()
        screenCapture = null

        webServer?.stop()
        webServer = null

        mdnsRegistrar?.unregister()
        mdnsRegistrar = null

        stopService(Intent(this, VpnTunnelService::class.java))

        appStateManager.reset()
    }

    override fun onDestroy() {
        stopPipeline()
        serviceScope.cancel()
        super.onDestroy()
    }

    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            AppConfig.NOTIFICATION_CHANNEL_ID,
            "Streaming Service",
            NotificationManager.IMPORTANCE_LOW
        ).apply {
            description = "Shows when screen streaming is active"
            setShowBadge(false)
        }
        val manager = getSystemService(NotificationManager::class.java)
        manager.createNotificationChannel(channel)
    }

    private fun createNotification(text: String): Notification {
        val pendingIntent = PendingIntent.getActivity(
            this, 0,
            Intent(this, MainActivity::class.java),
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val stopIntent = PendingIntent.getService(
            this, 1,
            Intent(this, MainService::class.java).apply { action = ACTION_STOP },
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        return Notification.Builder(this, AppConfig.NOTIFICATION_CHANNEL_ID)
            .setContentTitle("SuperTesla AA")
            .setContentText(text)
            .setSmallIcon(android.R.drawable.ic_media_play)
            .setContentIntent(pendingIntent)
            .addAction(Notification.Action.Builder(null, "Stop", stopIntent).build())
            .setOngoing(true)
            .build()
    }

    private fun updateNotification(text: String) {
        val manager = getSystemService(NotificationManager::class.java)
        manager.notify(AppConfig.NOTIFICATION_ID, createNotification(text))
    }

    companion object {
        const val ACTION_STOP = "com.supertesla.aa.STOP"
        const val ACTION_START_CAPTURE = "com.supertesla.aa.START_CAPTURE"
        const val EXTRA_RESULT_CODE = "result_code"
        const val EXTRA_DATA = "data"

        fun start(context: Context) {
            val intent = Intent(context, MainService::class.java)
            context.startForegroundService(intent)
        }

        fun stop(context: Context) {
            val intent = Intent(context, MainService::class.java).apply {
                action = ACTION_STOP
            }
            context.startService(intent)
        }

        fun startCapture(context: Context, resultCode: Int, data: Intent) {
            val intent = Intent(context, MainService::class.java).apply {
                action = ACTION_START_CAPTURE
                putExtra(EXTRA_RESULT_CODE, resultCode)
                putExtra(EXTRA_DATA, data)
            }
            context.startService(intent)
        }
    }
}
