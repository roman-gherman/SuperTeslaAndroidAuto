package fr.sd.taada.services;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.os.EnvironmentCompat;
import fr.sd.taada.TransporterService;
import fr.sd.taada.activities.SubscriptionActivity;
import fr.sd.taada.billing.SubscriptionManager;
import fr.sd.taada.helpers.DemoModeManager;
import fr.sd.taada.helpers.LogManager;
import fr.sd.taada.viewmodels.HomeViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class SubscriptionCheckService extends Service {
    private static final String CHANNEL_ID = "subscription_check_channel";
    public static final String EXTRA_DEVICE_ADDRESS = "device_address";
    public static final String EXTRA_TRIGGER_SOURCE = "trigger_source";
    private static final int NOTIFICATION_ID = 9001;
    private static final String TAG = "SubscriptionCheckService";
    private LogManager logManager;
    private SubscriptionManager subscriptionManager;

    private void checkSubscriptionAndStartServices(final String str, final String str2) {
        this.logManager.logDebug(TAG, "🔄 Lancement de la vérification avec cache intelligent...");
        this.subscriptionManager.isSubscribed(new SubscriptionManager.SubscriptionCheckListener() { // from class: fr.sd.taada.services.SubscriptionCheckService.1
            @Override // fr.sd.taada.billing.SubscriptionManager.SubscriptionCheckListener
            public void onResult(boolean z6) {
                SubscriptionCheckService.this.logManager.logInfo(SubscriptionCheckService.TAG, "📊 Résultat de la vérification: ".concat(z6 ? "✅ AUTORISÉ" : "❌ REFUSÉ"));
                if (z6) {
                    SubscriptionCheckService.this.logManager.logInfo(SubscriptionCheckService.TAG, "🚀 Abonnement vérifié - Démarrage du TransporterService");
                    try {
                        SubscriptionCheckService.this.startForegroundService(new Intent(SubscriptionCheckService.this, (Class<?>) TransporterService.class));
                        SubscriptionCheckService.this.logManager.logInfo(SubscriptionCheckService.TAG, "✅ TransporterService démarré avec succès");
                        SubscriptionCheckService.this.logManager.logInfo(SubscriptionCheckService.TAG, "📝 AUDIT: Service autorisé - Source: " + str + ", Appareil: " + str2);
                        SubscriptionCheckService.this.sendServiceStateChangeBroadcast();
                    } catch (Exception e) {
                        SubscriptionCheckService.this.logManager.logError(SubscriptionCheckService.TAG, "❌ Erreur lors du démarrage du TransporterService", e);
                    }
                } else {
                    SubscriptionCheckService.this.logManager.logInfo(SubscriptionCheckService.TAG, "🎮 Vérification du mode démo pour: " + str);
                    DemoModeManager demoModeManager = DemoModeManager.getInstance(SubscriptionCheckService.this);
                    if (demoModeManager.canUseDemoMode()) {
                        SubscriptionCheckService.this.logManager.logInfo(SubscriptionCheckService.TAG, "🎮 Mode démo disponible - Démarrage des services");
                        demoModeManager.startDemoMode();
                        try {
                            SubscriptionCheckService.this.startForegroundService(new Intent(SubscriptionCheckService.this, (Class<?>) TransporterService.class));
                            SubscriptionCheckService.this.logManager.logInfo(SubscriptionCheckService.TAG, "✅ TransporterService démarré en mode démo");
                            SubscriptionCheckService.this.logManager.logInfo(SubscriptionCheckService.TAG, "📝 AUDIT: Service autorisé via mode démo - Source: " + str + ", Appareil: " + str2);
                            SubscriptionCheckService.this.sendServiceStateChangeBroadcast();
                        } catch (Exception e6) {
                            SubscriptionCheckService.this.logManager.logError(SubscriptionCheckService.TAG, "❌ Erreur lors du démarrage du TransporterService en mode démo", e6);
                        }
                    } else {
                        SubscriptionCheckService.this.logManager.logWarning(SubscriptionCheckService.TAG, "🚫 Aucun abonnement actif et mode démo non disponible - Service non autorisé");
                        SubscriptionCheckService.this.logManager.logInfo(SubscriptionCheckService.TAG, "📝 AUDIT: Service refusé - Source: " + str + ", Appareil: " + str2);
                        SubscriptionCheckService.this.showSubscriptionRequired(str);
                    }
                }
                SubscriptionCheckService.this.logManager.logDebug(SubscriptionCheckService.TAG, "🏁 Vérification terminée - Arrêt du service");
                SubscriptionCheckService.this.stopSelf();
            }
        });
    }

    private Notification createNotification() {
        return new NotificationCompat.Builder(this, CHANNEL_ID).setContentTitle("TaaDa").setContentText("Vérification de l'abonnement...").setSmallIcon(R.drawable.ic_dialog_info).setPriority(-1).setCategory(NotificationCompat.CATEGORY_SERVICE).setOngoing(true).setShowWhen(false).build();
    }

    private void createNotificationChannel() {
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (notificationManager != null) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "Vérification Abonnement", 2);
            notificationChannel.setDescription("Canal pour la vérification des abonnements en arrière-plan");
            notificationChannel.setShowBadge(false);
            notificationManager.createNotificationChannel(notificationChannel);
            this.logManager.logDebug(TAG, "📱 Canal de notification créé: subscription_check_channel");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendServiceStateChangeBroadcast() {
        try {
            Intent intent = new Intent(HomeViewModel.ACTION_SERVICE_STATE_CHANGED);
            intent.setPackage(getPackageName());
            sendBroadcast(intent);
            this.logManager.logDebug(TAG, "📡 Broadcast de changement d'état envoyé");
        } catch (Exception e) {
            this.logManager.logError(TAG, "❌ Erreur lors de l'envoi du broadcast", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSubscriptionRequired(String str) {
        try {
            Intent intent = new Intent(this, (Class<?>) SubscriptionActivity.class);
            intent.setFlags(335544320);
            intent.putExtra("service_type", str);
            intent.putExtra("auto_triggered", true);
            startActivity(intent);
            this.logManager.logInfo(TAG, "📱 Écran d'abonnement lancé pour: " + str);
        } catch (Exception e) {
            this.logManager.logError(TAG, "❌ Erreur lors de l'affichage de l'écran d'abonnement", e);
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        LogManager logManager = LogManager.getInstance(this);
        this.logManager = logManager;
        logManager.logDebug(TAG, "🚀 SubscriptionCheckService créé");
        this.subscriptionManager = SubscriptionManager.getInstance(getApplicationContext());
        createNotificationChannel();
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.logManager.logDebug(TAG, "🗑️ SubscriptionCheckService détruit");
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i3) {
        String stringExtra;
        LogManager logManager = this.logManager;
        StringBuilder sb = new StringBuilder("📨 Service démarré avec intent: ");
        sb.append(intent != null ? intent.toString() : "null");
        logManager.logDebug(TAG, sb.toString());
        startForeground(NOTIFICATION_ID, createNotification());
        String str = EnvironmentCompat.MEDIA_UNKNOWN;
        if (intent != null) {
            String stringExtra2 = intent.getStringExtra(EXTRA_TRIGGER_SOURCE);
            stringExtra = intent.getStringExtra(EXTRA_DEVICE_ADDRESS);
            if (stringExtra2 == null) {
                stringExtra2 = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            if (stringExtra == null) {
                stringExtra = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            str = stringExtra2;
        } else {
            stringExtra = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        this.logManager.logInfo(TAG, "🔍 Début de la vérification d'abonnement");
        this.logManager.logInfo(TAG, "   📍 Source: ".concat(str));
        this.logManager.logInfo(TAG, "   📱 Appareil: ".concat(stringExtra));
        checkSubscriptionAndStartServices(str, stringExtra);
        return 2;
    }
}
