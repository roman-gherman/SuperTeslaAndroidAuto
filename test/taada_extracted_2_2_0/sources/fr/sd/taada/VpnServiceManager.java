package fr.sd.taada;

import android.content.Intent;
import fr.sd.taada.helpers.LogManager;
import fr.sd.taada.services.MyVpnService;
import fr.sd.taada.services.NewVpnService;

/* JADX INFO: loaded from: classes2.dex */
public class VpnServiceManager {
    private static final String TAG = "HU-VpnServiceManager";
    private final LogManager logManager;
    private final TransporterService service;

    public VpnServiceManager(TransporterService transporterService) {
        this.service = transporterService;
        this.logManager = transporterService.getLogManager();
    }

    public void stopVpnServices() {
        this.logManager.logDebug(TAG, "Arrêt du service VPN secondaire (NewVpnService)");
        Intent intent = new Intent(this.service, (Class<?>) NewVpnService.class);
        intent.setAction("fr.sd.taada.exit");
        this.service.startService(intent);
        this.service.stopService(intent);
        this.logManager.logDebug(TAG, "NewVpnService shutdown requested");
        this.logManager.logDebug(TAG, "Arrêt du service VPN principal (MyVpnService)");
        Intent intent2 = new Intent(this.service, (Class<?>) MyVpnService.class);
        intent2.setAction("fr.sd.taada.exit");
        this.service.startService(intent2);
        this.service.stopService(intent2);
        this.logManager.logDebug(TAG, "MyVpnService shutdown requested");
        this.logManager.logDebug(TAG, "Tous les services VPN ont reçu le signal d'arrêt");
    }
}
