package com.supertesla.aa.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.content.ComponentName
import android.os.Binder
import android.os.IBinder
import com.supertesla.aa.MainActivity
import com.supertesla.aa.androidauto.headunit.AAHeadUnitEmulator
import com.supertesla.aa.androidauto.headunit.HeadUnitConfig
import com.supertesla.aa.core.config.AppConfig
import com.supertesla.aa.core.model.AppState
import com.supertesla.aa.core.model.AppStateManager
import com.supertesla.aa.core.model.HotspotState
import com.supertesla.aa.network.hotspot.HotspotManager
import com.supertesla.aa.network.vpn.VpnTunnelService
import com.supertesla.aa.network.webserver.VideoStreamHandler
import com.supertesla.aa.network.webserver.WebServer
import com.supertesla.aa.network.websocket.TouchInputRelay
import com.supertesla.aa.streaming.audio.AacEncoder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
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
    private var aaEmulator: AAHeadUnitEmulator? = null
    private var aacEncoder: AacEncoder? = null
    private var vpnBound = false

    private var vpnService: VpnTunnelService? = null
    private val vpnConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            // VPN service is started via intent, not bound this way for VpnService
        }
        override fun onServiceDisconnected(name: ComponentName?) {
            vpnService = null
        }
    }

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
        when (intent?.action) {
            ACTION_STOP -> {
                stopPipeline()
                stopSelf()
                return START_NOT_STICKY
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
                // Step 1: Wait for hotspot
                appStateManager.transition(AppState.StartingHotspot)
                updateNotification("Waiting for hotspot...")

                Timber.d("Waiting for hotspot to be enabled...")
                hotspotManager.observeHotspotState().first { state ->
                    appStateManager.updateHotspotState(state)
                    state is HotspotState.Enabled || state is HotspotState.ClientConnected
                }
                appStateManager.transition(AppState.HotspotReady("Hotspot"))
                Timber.i("Hotspot detected")

                // Step 2: Start VPN
                appStateManager.transition(AppState.StartingVpn)
                updateNotification("Starting VPN...")

                val vpnIntent = Intent(this@MainService, VpnTunnelService::class.java).apply {
                    putExtra(VpnTunnelService.EXTRA_VIRTUAL_IP, AppConfig.DEFAULT_VIRTUAL_IP)
                }
                startService(vpnIntent)
                appStateManager.transition(AppState.VpnReady(AppConfig.DEFAULT_VIRTUAL_IP))
                Timber.i("VPN service started with IP: ${AppConfig.DEFAULT_VIRTUAL_IP}")

                // Step 3: Start web server
                appStateManager.transition(AppState.StartingServer)
                updateNotification("Starting server...")

                val videoWidth = 1280
                val videoHeight = 720

                val touchRelay = TouchInputRelay(videoWidth, videoHeight)
                val server = WebServer(assets, AppConfig.SERVER_PORT)
                server.videoStreamHandler = VideoStreamHandler(videoWidth, videoHeight, 30)
                server.touchInputRelay = touchRelay
                webServer = server
                server.start()

                val serverUrl = AppConfig.getServerUrl()
                appStateManager.transition(AppState.ServerRunning(serverUrl))
                updateNotification("Running - $serverUrl")
                Timber.i("Server running at $serverUrl")

                // Monitor hotspot for client connections
                launch {
                    hotspotManager.observeHotspotState().collect { state ->
                        appStateManager.updateHotspotState(state)
                    }
                }

                // Step 4: Connect to Android Auto head unit server
                appStateManager.transition(AppState.ConnectingAA)
                updateNotification("Connecting to Android Auto...")

                val emulator = AAHeadUnitEmulator(HeadUnitConfig(
                    videoWidth = videoWidth,
                    videoHeight = videoHeight,
                    videoFps = 30
                ))
                aaEmulator = emulator

                // Wire touch relay -> AA input channel
                touchRelay.setTouchListener(object : TouchInputRelay.TouchListener {
                    override fun onTouch(action: Int, x: Int, y: Int, pointerId: Int) {
                        emulator.inputHandler?.sendTouchEvent(action, x, y, pointerId)
                    }
                })

                emulator.onStateChanged = { state ->
                    Timber.i("AA Emulator state: ${state::class.simpleName}")
                    when (state) {
                        is AAHeadUnitEmulator.State.Streaming -> {
                            appStateManager.transition(AppState.Streaming)
                            updateNotification("Streaming - $serverUrl")
                        }
                        is AAHeadUnitEmulator.State.Error -> {
                            Timber.w("AA Emulator error: ${state.message}")
                            // Don't fail the whole pipeline - server still serves web UI
                        }
                        is AAHeadUnitEmulator.State.Disconnected -> {
                            if (appStateManager.state.value is AppState.Streaming) {
                                appStateManager.transition(AppState.ServerRunning(serverUrl))
                                updateNotification("AA disconnected - $serverUrl")
                            }
                        }
                        else -> {}
                    }
                }

                launch(Dispatchers.IO) {
                    try {
                        emulator.connect()

                        // Wire video flow from AA emulator to web server
                        val videoHandler = emulator.videoHandler
                        if (videoHandler != null) {
                            val videoDataFlow = videoHandler.videoFrames.map { it.data }
                            webServer?.videoFlow = videoDataFlow
                            Timber.i("Video flow wired to web server")
                        }

                        // Wire audio: start AAC encoder and collect media audio
                        val mediaAudio = emulator.audioMediaHandler
                        if (mediaAudio != null) {
                            val encoder = AacEncoder(sampleRate = 48000, channelCount = 2, bitRate = 128_000)
                            aacEncoder = encoder
                            encoder.start()
                            Timber.i("AAC encoder started for media audio")

                            launch {
                                mediaAudio.audioFrames.collect { frame ->
                                    encoder.feedPcm(frame.data, frame.timestamp)
                                }
                            }
                        }
                    } catch (e: Exception) {
                        Timber.w(e, "AA connection failed (server may not be running)")
                        updateNotification("AA not available - $serverUrl")
                    }
                }

            } catch (e: Exception) {
                Timber.e(e, "Pipeline failed")
                appStateManager.transition(AppState.Error(e.message ?: "Unknown error"))
                updateNotification("Error: ${e.message}")
            }
        }
    }

    private fun stopPipeline() {
        Timber.d("Stopping pipeline")
        pipelineJob?.cancel()
        pipelineJob = null

        aacEncoder?.release()
        aacEncoder = null

        aaEmulator?.destroy()
        aaEmulator = null

        webServer?.stop()
        webServer = null

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
            description = "Shows when Android Auto streaming is active"
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
            .addAction(
                Notification.Action.Builder(
                    null, "Stop", stopIntent
                ).build()
            )
            .setOngoing(true)
            .build()
    }

    private fun updateNotification(text: String) {
        val manager = getSystemService(NotificationManager::class.java)
        manager.notify(AppConfig.NOTIFICATION_ID, createNotification(text))
    }

    companion object {
        const val ACTION_STOP = "com.supertesla.aa.STOP"

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
    }
}
