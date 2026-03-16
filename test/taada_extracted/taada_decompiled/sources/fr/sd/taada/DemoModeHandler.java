package fr.sd.taada;

import android.os.Handler;
import android.os.Looper;
import fr.sd.taada.helpers.DemoModeManager;
import fr.sd.taada.helpers.LogManager;

/* JADX INFO: loaded from: classes2.dex */
public class DemoModeHandler {
    private static final String TAG = "HU-DemoModeHandler";
    private DemoModeManager.DemoModeListener demoModeListener;
    private DemoModeManager demoModeManager;
    private final LogManager logManager;
    private final TransporterService service;

    public DemoModeHandler(TransporterService transporterService) {
        this.service = transporterService;
        this.logManager = transporterService.getLogManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDemoModeExpired() {
        try {
            this.logManager.logInfo(TAG, "🎮 Début de l'arrêt automatique suite à l'expiration du mode démo");
            synchronized (TransporterService.STATIC_FIELDS_LOCK) {
                TransporterService.isServiceActive = false;
                TransporterService.isConnected = false;
                TransporterService.isVideoActive = false;
            }
            this.service.getVpnServiceManager().stopVpnServices();
            stopSocketServers();
            new Handler(Looper.getMainLooper()).postDelayed(new androidx.constraintlayout.helper.widget.a(this, 11), 1000L);
            this.service.stopSelf();
            this.logManager.logInfo(TAG, "🎮 Arrêt automatique terminé");
        } catch (Exception e) {
            this.logManager.logError(TAG, "Erreur lors de la gestion de l'expiration du mode démo", e);
            this.service.stopSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleDemoModeExpired$0() {
        try {
            this.logManager.logInfo(TAG, "🎮 Affichage de l'écran d'abonnement après expiration du mode démo");
            this.demoModeManager.showSubscriptionActivity();
        } catch (Exception e) {
            this.logManager.logError(TAG, "Erreur lors de l'affichage de l'écran d'abonnement", e);
        }
    }

    private void stopSocketServers() {
        try {
            if (this.service.getControlAndVideoSocketServer() != null) {
                this.service.getControlAndVideoSocketServer().stop();
            }
            if (this.service.getMediaAudioSocketServer() != null) {
                this.service.getMediaAudioSocketServer().stop();
            }
            if (this.service.getVoiceSocketServer() != null) {
                this.service.getVoiceSocketServer().stop();
            }
        } catch (Exception e) {
            this.logManager.logError(TAG, "Erreur lors de l'arrêt des serveurs", e);
        }
    }

    public DemoModeManager getDemoModeManager() {
        return this.demoModeManager;
    }

    public void initializeDemoMode() {
        try {
            this.demoModeManager = DemoModeManager.getInstance(this.service);
            DemoModeManager.DemoModeListener demoModeListener = new DemoModeManager.DemoModeListener() { // from class: fr.sd.taada.DemoModeHandler.1
                @Override // fr.sd.taada.helpers.DemoModeManager.DemoModeListener
                public void onDemoModeExpired() {
                    DemoModeHandler.this.logManager.logWarning(DemoModeHandler.TAG, "🎮 Mode démo expiré - Arrêt automatique des services");
                    DemoModeHandler.this.handleDemoModeExpired();
                }

                @Override // fr.sd.taada.helpers.DemoModeManager.DemoModeListener
                public void onDemoModeReady() {
                    DemoModeHandler.this.logManager.logInfo(DemoModeHandler.TAG, "🎮 Mode démo réarmé et prêt");
                }

                @Override // fr.sd.taada.helpers.DemoModeManager.DemoModeListener
                public void onDemoModeStarted() {
                    DemoModeHandler.this.logManager.logInfo(DemoModeHandler.TAG, "🎮 Mode démo démarré avec les services");
                }
            };
            this.demoModeListener = demoModeListener;
            this.demoModeManager.setDemoModeListener(demoModeListener);
            this.logManager.logDebug(TAG, "🎮 Mode démo initialisé avec callback");
        } catch (Exception e) {
            this.logManager.logError(TAG, "Erreur lors de l'initialisation du mode démo", e);
        }
    }

    public void stopDemoMode() {
        DemoModeManager demoModeManager = this.demoModeManager;
        if (demoModeManager != null) {
            demoModeManager.stopDemoMode();
            this.demoModeManager.setDemoModeListener(null);
            this.logManager.logDebug(TAG, "🎮 Mode démo arrêté");
        }
    }
}
