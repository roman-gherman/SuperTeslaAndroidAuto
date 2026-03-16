package fr.sd.taada;

import B2.b;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.VpnService;
import android.net.wifi.WifiInfo;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.Log;
import android.view.CoroutineLiveDataKt;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.os.EnvironmentCompat;
import androidx.preference.PreferenceManager;
import fr.sd.taada.activities.AAVersionErrorActivity;
import fr.sd.taada.analytics.telemetry.FunnelEvent;
import fr.sd.taada.analytics.telemetry.TelemetryManager;
import fr.sd.taada.billing.SubscriptionGuard;
import fr.sd.taada.helpers.LogManager;
import fr.sd.taada.helpers.MemoryHelper;
import fr.sd.taada.helpers.ReviewRequestManager;
import fr.sd.taada.helpers.event.EventHelper;
import fr.sd.taada.helpers.video.NalStreamManager;
import fr.sd.taada.proto.ByeByeReason;
import fr.sd.taada.proto.ByeByeRequest;
import fr.sd.taada.proto.ControlMessageType;
import fr.sd.taada.proto.NightModeData;
import fr.sd.taada.proto.SensorBatch;
import fr.sd.taada.services.MyVpnService;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import net.bytebuddy.utility.JavaConstant;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;
import org.mockito.Mockito;
import p024d2.ProtocolMessage;
import p024d2.ProtocolMessagePool;
import p030e2.AbstractC2147a;
import p036f2.C2188a;
import p054i2.VideoResolutionHelper;
import p060j2.ControlSocketServer;
import p060j2.MediaSocketServer;
import p060j2.WebServerInitializer;
import p072l2.AbstractC2872d;

/* JADX INFO: loaded from: classes2.dex */
public class TransporterService extends Service {
    public static final String EXTRA_LAUNCH_SOURCE = "fr.sd.taada.EXTRA_LAUNCH_SOURCE";
    public static final Object STATIC_FIELDS_LOCK = new Object();
    private static String TAG = "HU-TransportService";
    private static TransporterService instance = null;
    public static boolean isConnected = false;
    public static boolean isServiceActive = true;
    public static boolean isVideoActive = false;
    public static int webServerPort;
    private CommunicationHandler communicationHandler;
    public ControlSocketServer controlAndVideoSocketServer;
    private DemoModeHandler demoModeHandler;
    public PendingIntent exitPendingIntent;
    public Notification foregroundNotification;
    private LogManager logManager;
    public MediaSocketServer mediaAudioSocketServer;
    private ProtocolMessagePool messagePool;
    public NotificationManager notificationManager;
    public MediaSocketServer voiceSocketServer;
    public ParcelFileDescriptor vpnInterface;
    private VpnServiceManager vpnServiceManager;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    public boolean isNightMode = false;
    private final IBinder binder = new BinderC2464d();
    private String sessionId = null;
    private boolean restartServiceOnDestroy = true;
    private boolean isSessionEnded = false;

    public class BinderC2464d extends Binder {
        public BinderC2464d() {
        }
    }

    private String getAndroidAutoVersion() {
        try {
            return getPackageManager().getPackageInfo("com.google.android.projection.gearhead", 0).versionName;
        } catch (Exception unused) {
            return null;
        }
    }

    public static TransporterService getInstance() {
        return instance;
    }

    private void logSessionEnd(String str, Map<String, Object> map) {
        if (this.isSessionEnded) {
            return;
        }
        this.isSessionEnded = true;
        try {
            if (TelemetryManager.isInitialized() && TelemetryManager.getInstance().isEnabled()) {
                HashMap map2 = new HashMap();
                map2.put("reason", str);
                map2.put("was_connected", Boolean.valueOf(isConnected));
                map2.put("was_video_active", Boolean.valueOf(isVideoActive));
                map2.putAll(NalStreamManager.getAllFpsStats());
                NalStreamManager.resetStats();
                if (map != null) {
                    map2.putAll(map);
                }
                TelemetryManager.getInstance().log(FunnelEvent.SESSION_END, map2);
                getLogManager().logDebug(TAG, "📊 Telemetry: SESSION_END logged (" + str + ")");
            }
        } catch (Exception e) {
            getLogManager().logError(TAG, "Error logging SESSION_END", e);
        }
    }

    private void logSessionStart(String str) {
        try {
            this.isSessionEnded = false;
            if (TelemetryManager.isInitialized() && TelemetryManager.getInstance().isEnabled()) {
                HashMap map = new HashMap();
                map.put(NotificationCompat.CATEGORY_SERVICE, "TransporterService");
                map.put("source", str);
                TelemetryManager.getInstance().log(FunnelEvent.SESSION_START, map);
                getLogManager().logDebug(TAG, "📊 Telemetry: SESSION_START logged (source: " + str + ")");
            }
        } catch (Exception e) {
            getLogManager().logError(TAG, "Error logging SESSION_START", e);
        }
    }

    private void logSessionStartAttempt(String str) {
        try {
            if (TelemetryManager.isInitialized() && TelemetryManager.getInstance().isEnabled()) {
                HashMap map = new HashMap();
                map.put("source", str);
                TelemetryManager.getInstance().log(FunnelEvent.SESSION_START_ATTEMPT, map);
            }
        } catch (Exception e) {
            getLogManager().logError(TAG, "Error logging SESSION_START_ATTEMPT", e);
        }
    }

    private void notifyClientsBeforeShutdown() {
        getLogManager().logInfo(TAG, "Notifying WebSocket clients of shutdown");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "server_shutdown");
            jSONObject.put("reason", "service_stopping");
            jSONObject.put("timestamp", System.currentTimeMillis());
            String string = jSONObject.toString();
            ControlSocketServer controlSocketServer = this.controlAndVideoSocketServer;
            if (controlSocketServer != null) {
                try {
                    controlSocketServer.broadcast(string);
                    getLogManager().logDebug(TAG, "Shutdown message sent to control clients");
                } catch (Exception e) {
                    getLogManager().logError(TAG, "Error sending to control clients", e);
                }
            }
            MediaSocketServer mediaSocketServer = this.mediaAudioSocketServer;
            if (mediaSocketServer != null) {
                try {
                    mediaSocketServer.broadcast(string);
                    getLogManager().logDebug(TAG, "Shutdown message sent to audio clients");
                } catch (Exception e6) {
                    getLogManager().logError(TAG, "Error sending to audio clients", e6);
                }
            }
            MediaSocketServer mediaSocketServer2 = this.voiceSocketServer;
            if (mediaSocketServer2 != null) {
                try {
                    mediaSocketServer2.broadcast(string);
                    getLogManager().logDebug(TAG, "Shutdown message sent to voice clients");
                } catch (Exception e7) {
                    getLogManager().logError(TAG, "Error sending to voice clients", e7);
                }
            }
        } catch (JSONException e8) {
            getLogManager().logError(TAG, "Error creating shutdown message", e8);
        }
    }

    private void startConnectionWaitThread(String str) {
        new Thread(new ConnectionWaitRunnable(this)).start();
    }

    public CommunicationHandler getCommunicationHandler() {
        return this.communicationHandler;
    }

    public ControlSocketServer getControlAndVideoSocketServer() {
        return this.controlAndVideoSocketServer;
    }

    public LogManager getLogManager() {
        if (this.logManager == null) {
            this.logManager = LogManager.getInstance(this);
        }
        return this.logManager;
    }

    public MediaSocketServer getMediaAudioSocketServer() {
        return this.mediaAudioSocketServer;
    }

    public ProtocolMessagePool getMessagePool() {
        return this.messagePool;
    }

    public MediaSocketServer getVoiceSocketServer() {
        return this.voiceSocketServer;
    }

    public VpnServiceManager getVpnServiceManager() {
        return this.vpnServiceManager;
    }

    public void m2650s(boolean z6) {
        this.isNightMode = z6;
        SensorBatch.Builder builderNewBuilder = SensorBatch.newBuilder();
        builderNewBuilder.addNightModeData(NightModeData.newBuilder().setNightMode(z6).build());
        EventHelper.getEventBus().post(this.messagePool.createMessage((byte) 2, (byte) 3, 32771, builderNewBuilder));
    }

    public void m2652q(String str, CharSequence charSequence, String str2) {
        NotificationChannel notificationChannel = new NotificationChannel(str, charSequence, 2);
        notificationChannel.setDescription(str2);
        notificationChannel.setShowBadge(false);
        notificationChannel.setLockscreenVisibility(1);
        this.notificationManager.createNotificationChannel(notificationChannel);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        getLogManager().logDebug(TAG, "Service binder called");
        return this.binder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        instance = this;
        TAG = b.h(new StringBuilder(), TAG, JavaConstant.Dynamic.DEFAULT_NAME);
        this.notificationManager = (NotificationManager) getSystemService("notification");
        getLogManager().logDebug(TAG, "Service created!: ");
        getLogManager().logInfo(TAG, "🧠 Memory diagnostic before service initialization...");
        try {
            MemoryHelper.logMemoryState(this, TAG);
            MemoryHelper.MemoryStatus memoryStatusCheckMemoryStatus = MemoryHelper.checkMemoryStatus(this);
            getLogManager().logInfo(TAG, "Initial service memory status: " + memoryStatusCheckMemoryStatus);
            if (memoryStatusCheckMemoryStatus == MemoryHelper.MemoryStatus.CRITICAL) {
                getLogManager().logWarning(TAG, "⚠️ CRITICAL MEMORY at service start - performing cleanup");
                MemoryHelper.requestMemoryCleanup(true);
            }
        } catch (Exception e) {
            getLogManager().logError(TAG, "Error during service memory diagnostic", e);
        }
        EventHelper.getEventBus().register(this);
        this.messagePool = ProtocolMessagePool.getInstance();
        this.communicationHandler = new CommunicationHandler(this);
        this.demoModeHandler = new DemoModeHandler(this);
        this.vpnServiceManager = new VpnServiceManager(this);
        this.demoModeHandler.initializeDemoMode();
        getLogManager().logDebug(TAG, "TransporterService initialized with extracted components");
        m2652q("main_notification", "TaaDa Service", "TaaDa");
        Intent intent = new Intent(this, (Class<?>) WifiReceiver.class);
        intent.setAction("fr.sd.taada.exit");
        intent.putExtra(NotificationCompat.EXTRA_NOTIFICATION_ID, 0);
        this.exitPendingIntent = PendingIntent.getBroadcast(this, 0, intent, Build.VERSION.SDK_INT >= 31 ? 201326592 : 134217728);
        Notification notificationBuild = new NotificationCompat.Builder(this, "main_notification").setContentTitle("TaaDa").setContentText("Web interface for AA").setSmallIcon(R.drawable.ic_launcher_foreground).setPriority(1).setAutoCancel(false).addAction(new NotificationCompat.Action.Builder(R.drawable.ic_exit, getString(R.string.exit), this.exitPendingIntent).build()).build();
        this.foregroundNotification = notificationBuild;
        startForeground(1, notificationBuild);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        VideoResolutionHelper.setScreenDimensions(defaultSharedPreferences.getInt("stored_width", 1180), defaultSharedPreferences.getInt("stored_height", 860));
    }

    @Override // android.app.Service
    public void onDestroy() {
        String stackTraceString = Log.getStackTraceString(new Throwable("DIAGNOSTIC: onDestroy caller trace"));
        getLogManager().logWarning(TAG, "⚠️ onDestroy called - isConnected=" + isConnected + ", isVideoActive=" + isVideoActive + ", isServiceActive=" + isServiceActive);
        LogManager logManager = getLogManager();
        String str = TAG;
        StringBuilder sb = new StringBuilder("🔍 DIAGNOSTIC STACK TRACE:\n");
        sb.append(stackTraceString);
        logManager.logWarning(str, sb.toString());
        logSessionEnd("service_killed_unexpected");
        try {
            notifyClientsBeforeShutdown();
        } catch (Exception e) {
            getLogManager().logError(TAG, "Error notifying clients before shutdown", e);
        }
        try {
            Thread.sleep(500L);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        ParcelFileDescriptor parcelFileDescriptor = this.vpnInterface;
        try {
            if (parcelFileDescriptor != null) {
                try {
                    parcelFileDescriptor.close();
                } catch (IOException e6) {
                    getLogManager().logError(TAG, "Failed to close VPN interface", e6);
                }
            }
            EventHelper.getEventBus().post(this.messagePool.createMessage((byte) 0, (byte) 3, 15, ByeByeRequest.newBuilder().setReason(ByeByeReason.USER_SELECTION)));
            synchronized (STATIC_FIELDS_LOCK) {
                try {
                    if (isConnected || isVideoActive) {
                        ReviewRequestManager.getInstance(this).onSessionEnded(true);
                    }
                    isServiceActive = false;
                    isConnected = false;
                } catch (Throwable th) {
                    throw th;
                }
            }
            DemoModeHandler demoModeHandler = this.demoModeHandler;
            if (demoModeHandler != null) {
                demoModeHandler.stopDemoMode();
            }
            VpnServiceManager vpnServiceManager = this.vpnServiceManager;
            if (vpnServiceManager != null) {
                vpnServiceManager.stopVpnServices();
            }
            try {
                this.controlAndVideoSocketServer.stop();
                this.mediaAudioSocketServer.stop();
                this.voiceSocketServer.stop();
            } catch (Exception e7) {
                e7.printStackTrace();
            }
            EventHelper.getEventBus().unregister(this);
            if (this.restartServiceOnDestroy) {
                AbstractC2872d.m2248b(this, false);
            }
            getLogManager().logDebug(TAG, "On Destroyed has been called, cleaning up...");
            try {
                AbstractC2147a.m3527a();
            } catch (Exception unused2) {
            }
            CommunicationHandler communicationHandler = this.communicationHandler;
            if (communicationHandler != null) {
                communicationHandler.closeResources();
            }
            ((NotificationManager) getSystemService("notification")).cancelAll();
            stopForeground(true);
            instance = null;
            super.onDestroy();
        } finally {
            this.vpnInterface = null;
        }
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onMessage(ProtocolMessage protocolMessage) {
        String string;
        if (getLogManager().isDebugEnabled(TAG)) {
            String hexString = Integer.toHexString(protocolMessage.getMessageType());
            if (protocolMessage.getMessageType() >= 32768) {
                string = "Media_" + Integer.toHexString(protocolMessage.getMessageType()).toUpperCase(Locale.ROOT);
            } else {
                ControlMessageType controlMessageTypeForNumber = ControlMessageType.forNumber(protocolMessage.getMessageType());
                string = controlMessageTypeForNumber != null ? controlMessageTypeForNumber.toString() : EnvironmentCompat.MEDIA_UNKNOWN;
            }
            LogManager logManager = getLogManager();
            String str = TAG;
            StringBuilder sb = new StringBuilder("Message received via EventBus: Channel=");
            sb.append((int) protocolMessage.getChannel());
            sb.append(", Service=");
            sb.append((int) protocolMessage.getService());
            sb.append(", MessageType=0x");
            sb.append(hexString);
            sb.append(", TypeName=");
            sb.append(string);
            sb.append(", PayloadLength=");
            sb.append(protocolMessage.getPayload() != null ? protocolMessage.getPayload().length : 0);
            logManager.logDebug(str, sb.toString());
        }
        if (isConnected) {
            this.executorService.execute(new MessageSenderRunnable(this, protocolMessage, this.communicationHandler.getMessageHandler(), this.communicationHandler.getSslHandler()));
        }
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        getLogManager().logDebug(TAG, "Service re-binded!");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i3) {
        String stringExtra;
        Network network;
        Parcelable activeNetwork;
        LogManager logManager = getLogManager();
        String str = TAG;
        StringBuilder sb = new StringBuilder("🚀 onStartCommand - intent=");
        sb.append(intent != null ? intent.getAction() : "null");
        sb.append(", flags=");
        sb.append(i);
        sb.append(", startId=");
        sb.append(i3);
        sb.append(", isConnected=");
        sb.append(isConnected);
        sb.append(", isServiceActive=");
        sb.append(isServiceActive);
        logManager.logWarning(str, sb.toString());
        if (intent != null) {
            stringExtra = intent.getStringExtra(EXTRA_LAUNCH_SOURCE);
            if (stringExtra == null) {
                stringExtra = EnvironmentCompat.MEDIA_UNKNOWN;
            }
        } else {
            stringExtra = "system_restart";
        }
        getLogManager().logDebug(TAG, "🔍 Launch source: ".concat(stringExtra));
        if (!SubscriptionGuard.canAccessServicesSync(this, "TransporterService")) {
            getLogManager().logWarning(TAG, "❌ TransporterService start blocked - No active subscription");
            SubscriptionGuard.logAccessAttempt(this, "TransporterService", false, "Service Start Command");
            HashMap map = new HashMap();
            map.put("source", stringExtra);
            logSessionEnd("no_subscription", map);
            stopSelf();
            return 2;
        }
        getLogManager().logDebug(TAG, "✅ Subscription verified - Starting TransporterService");
        SubscriptionGuard.logAccessAttempt(this, "TransporterService", true, "Service Start Command");
        super.onStartCommand(intent, i, i3);
        synchronized (STATIC_FIELDS_LOCK) {
            isServiceActive = true;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (intent != null && "fr.sd.taada.exit".equals(intent.getAction())) {
            getLogManager().logWarning(TAG, "🔍 DIAGNOSTIC: EXIT intent received - stopping service");
            logSessionEnd("user_stopped");
            stopForeground(true);
            stopSelf();
            return 2;
        }
        if (isConnected) {
            getLogManager().logWarning(TAG, "🔍 DIAGNOSTIC: Already connected - returning START_STICKY without reinit");
            return 1;
        }
        logSessionStartAttempt(stringExtra);
        webServerPort = new Random().nextInt(1908) + 8090;
        getLogManager().logDebug(TAG, "Use VPN: " + defaultSharedPreferences.getBoolean("usevpn", true));
        if (defaultSharedPreferences.getBoolean("usevpn", true)) {
            VpnService.prepare(getApplicationContext());
            startService(new Intent(this, (Class<?>) MyVpnService.class));
        }
        getLogManager().logInfo(TAG, "[TIMING] Creating WebSocket servers on ports " + webServerPort + "-" + (webServerPort + 2));
        this.controlAndVideoSocketServer = new ControlSocketServer(new InetSocketAddress(webServerPort), getApplicationContext());
        this.mediaAudioSocketServer = new MediaSocketServer(new InetSocketAddress(webServerPort + 1), getApplicationContext());
        this.voiceSocketServer = new MediaSocketServer(new InetSocketAddress(webServerPort + 2), getApplicationContext());
        getLogManager().logInfo(TAG, "[TIMING] WebSocket servers created successfully");
        getLogManager().logInfo(TAG, "[TIMING] Initializing HTTPS server");
        new WebServerInitializer(getApplicationContext());
        getLogManager().logInfo(TAG, "[TIMING] Starting WebSocket servers (will begin listening for connections)");
        this.controlAndVideoSocketServer.start();
        getLogManager().logInfo(TAG, "[TIMING] ControlSocketServer.start() called - server should now be listening on port " + webServerPort);
        this.mediaAudioSocketServer.start();
        getLogManager().logInfo(TAG, "[TIMING] MediaAudioSocketServer.start() called - server listening on port " + (webServerPort + 1));
        this.voiceSocketServer.start();
        getLogManager().logInfo(TAG, "[TIMING] VoiceSocketServer.start() called - server listening on port " + (webServerPort + 2));
        AbstractC2872d.m2248b(getApplicationContext(), true);
        getLogManager().logInfo(TAG, "[TIMING] Starting Android Auto connection wait thread (port 5288)");
        Parcelable parcelable = null;
        startConnectionWaitThread(null);
        getLogManager().logInfo(TAG, "[TIMING] Connection wait thread started - waiting for Android Auto to connect");
        try {
            network = (Network) Mockito.mock(Network.class, Mockito.withSettings().useConstructor(99999));
        } catch (Exception unused) {
            network = null;
        }
        if (network != null) {
            Parcel parcelObtain = Parcel.obtain();
            network.writeToParcel(parcelObtain, 0);
            parcelObtain.setDataPosition(0);
            activeNetwork = (Network) Network.CREATOR.createFromParcel(parcelObtain);
        } else {
            activeNetwork = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetwork();
        }
        Intent intent2 = new Intent();
        try {
            parcelable = (WifiInfo) Class.forName("android.net.wifi.WifiInfo").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        getLogManager().logDebug(TAG, "Wifi info: " + parcelable);
        intent2.setClassName("com.google.android.projection.gearhead", "com.google.android.apps.auto.wireless.setup.service.impl.WirelessStartupActivity");
        intent2.addFlags(268435456);
        intent2.putExtra("PARAM_HOST_ADDRESS", "127.0.0.1").putExtra("PARAM_SERVICE_PORT", 5288).putExtra("wifi_info", parcelable).putExtra("PARAM_SERVICE_WIFI_NETWORK", activeNetwork);
        try {
            startActivity(intent2);
            Integer.parseInt(defaultSharedPreferences.getString("car_type", "0"));
        } catch (SecurityException e6) {
            Log.w(TAG, "[AA-LAUNCH] ❌ SecurityException: Activity not exported (AA 16.4+ détecté): " + e6.getMessage());
            try {
                Intent intent3 = new Intent();
                intent3.setClassName("com.google.android.projection.gearhead", "com.google.android.apps.auto.wireless.setup.receiver.WirelessStartupReceiver");
                intent3.setAction("com.google.android.apps.auto.wireless.setup.receiver.wirelessstartup.START");
                intent3.putExtra("ip_address", "127.0.0.1");
                intent3.putExtra("projection_port", 5288);
                sendBroadcast(intent3);
                Integer.parseInt(defaultSharedPreferences.getString("car_type", "0"));
            } catch (Exception e7) {
                Log.w(TAG, "[AA-LAUNCH] Broadcast WirelessStartupReceiver échoué: " + e7.getMessage());
                String androidAutoVersion = getAndroidAutoVersion();
                Intent intent4 = new Intent(this, (Class<?>) AAVersionErrorActivity.class);
                intent4.addFlags(268435456);
                intent4.putExtra(AAVersionErrorActivity.EXTRA_AA_VERSION, androidAutoVersion);
                startActivity(intent4);
                HashMap map2 = new HashMap();
                map2.put("error", "SecurityException_exported_false");
                if (androidAutoVersion == null) {
                    androidAutoVersion = EnvironmentCompat.MEDIA_UNKNOWN;
                }
                map2.put("aa_version", androidAutoVersion);
                map2.put("broadcast_fallback", "failed");
                logSessionEnd("auto_start_failed_aa_blocked", map2);
                logSessionStart(stringExtra);
                stopSelf();
                return 2;
            }
        } catch (Exception e8) {
            Log.e(TAG, "[AA-LAUNCH] ❌ Échec du lancement Android Auto: " + e8.getMessage(), e8);
            Toast.makeText(this, getText(R.string.noaa), 1).show();
            HashMap map3 = new HashMap();
            map3.put("error", e8.getMessage());
            logSessionEnd("auto_start_failed", map3);
            logSessionStart(stringExtra);
            stopSelf();
            return 2;
        }
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        getLogManager().logDebug(TAG, "onTaskRemoved called - App swiped/Task removed");
        try {
            if (TelemetryManager.isInitialized() && TelemetryManager.getInstance().isEnabled()) {
                TelemetryManager.getInstance().log(FunnelEvent.APP_QUIT);
            }
        } catch (Exception e) {
            getLogManager().logError(TAG, "Error logging APP_QUIT", e);
        }
        getLogManager().logInfo(TAG, "Service persisting in background despite task removal");
    }

    public void onTimeout(int i, int i3) {
        getLogManager().logWarning(TAG, "⚠️ Service timeout reached for dataSync service (6 hours limit)");
        logSessionEnd("datasync_timeout");
        getLogManager().logInfo(TAG, androidx.constraintlayout.core.motion.a.n("Service will be stopped gracefully - startId: ", i, ", fgsType: ", i3));
        try {
            try {
                ControlSocketServer controlSocketServer = this.controlAndVideoSocketServer;
                if (controlSocketServer != null) {
                    controlSocketServer.stop();
                }
                MediaSocketServer mediaSocketServer = this.mediaAudioSocketServer;
                if (mediaSocketServer != null) {
                    mediaSocketServer.stop();
                }
                MediaSocketServer mediaSocketServer2 = this.voiceSocketServer;
                if (mediaSocketServer2 != null) {
                    mediaSocketServer2.stop();
                }
                VpnServiceManager vpnServiceManager = this.vpnServiceManager;
                if (vpnServiceManager != null) {
                    vpnServiceManager.stopVpnServices();
                }
                synchronized (STATIC_FIELDS_LOCK) {
                    isServiceActive = false;
                    isConnected = false;
                    isVideoActive = false;
                }
                getLogManager().logInfo(TAG, "Service components stopped gracefully due to timeout");
                stopSelf();
                getLogManager().logInfo(TAG, "Service stopped due to dataSync timeout");
            } catch (Exception e) {
                getLogManager().logError(TAG, "Error during timeout shutdown", e);
                stopSelf();
                getLogManager().logInfo(TAG, "Service stopped due to dataSync timeout");
            }
        } catch (Throwable th) {
            stopSelf();
            getLogManager().logInfo(TAG, "Service stopped due to dataSync timeout");
            throw th;
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        getLogManager().logDebug(TAG, "Service unbided, no more clients");
        return true;
    }

    public void setRestartServiceOnDestroy(boolean z6) {
        this.restartServiceOnDestroy = z6;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(C2188a c2188a) {
        this.restartServiceOnDestroy = false;
        ((AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM)).set(0, SystemClock.elapsedRealtime() + CoroutineLiveDataKt.DEFAULT_TIMEOUT, PendingIntent.getService(this, 1, new Intent(getApplicationContext(), (Class<?>) TransporterService.class), 1140850688));
        logSessionEnd("service_restart");
        stopForeground(true);
        stopSelf();
    }

    private void logSessionEnd(String str) {
        logSessionEnd(str, null);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(String str) {
        str.getClass();
        if (str.equals("gb.xxy.hr.startNight")) {
            this.sessionId = getResources().getString(R.string.daynight);
            m2650s(!r2.equalsIgnoreCase("day"));
        }
    }
}
