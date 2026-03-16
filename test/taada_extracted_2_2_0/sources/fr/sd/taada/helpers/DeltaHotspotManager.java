package fr.sd.taada.helpers;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public class DeltaHotspotManager {
    private static final String ACTION_START_HOTSPOT = "dev.shadoe.delta.action.START_SOFT_AP";
    private static final String ACTION_STOP_HOTSPOT = "dev.shadoe.delta.action.STOP_SOFT_AP";
    private static final int ANDROID_16_API_LEVEL = 36;
    private static final String DELTA_PACKAGE_NAME = "dev.shadoe.delta";
    public static final boolean FORCE_DELTA_FOR_TESTING = false;
    private static final String TAG = "DeltaHotspotManager";
    private final Context context;
    private final LogManager logManager;

    public DeltaHotspotManager(Context context) {
        this.context = context.getApplicationContext();
        this.logManager = LogManager.getInstance(context);
    }

    public static boolean isDeltaRequired() {
        return Build.VERSION.SDK_INT >= 36;
    }

    private void showDeltaNotInstalledMessage() {
        this.logManager.logWarning(TAG, "⚠️ Delta est requis pour le contrôle du hotspot sur Android 16+\nGitHub: https://github.com/supershadoe/delta\nL'utilisateur doit:\n1. Installer Delta depuis le Play Store\n2. Configurer Shizuku (requis par Delta)\n3. Activer 'Accept external broadcasts' dans les paramètres de Delta");
    }

    public String getHelpMessage() {
        return "Pour utiliser le hotspot automatique sur Android 16+:\n\n1. Installez l'application Delta depuis le Play Store\n2. Installez et configurez Shizuku (requis par Delta)\n3. Dans les paramètres de Delta, activez:\n   - 'Accept external broadcasts'\n4. Redémarrez TaaDa\n\nGitHub Delta: https://github.com/supershadoe/delta\n\n⚠️ Note de sécurité:\nActiver 'Accept external broadcasts' dans Delta permet à\nn'importe quelle application de contrôler votre hotspot.\nN'activez cette option que si vous comprenez les risques.";
    }

    public boolean isDeltaAvailable() {
        if (!isDeltaInstalled()) {
            return false;
        }
        this.logManager.logInfo(TAG, "⚠️ Delta est installé, mais l'utilisateur doit activer 'Accept external broadcasts' dans les paramètres de Delta");
        return true;
    }

    public boolean isDeltaInstalled() {
        try {
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(DELTA_PACKAGE_NAME, 0);
            this.logManager.logDebug(TAG, "✅ Delta est installé - Version: " + packageInfo.versionName + " (" + packageInfo.versionCode + ")");
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            this.logManager.logWarning(TAG, "❌ Delta n'est pas installé");
            return false;
        }
    }

    public void openDeltaApp() {
        try {
            this.logManager.logInfo(TAG, "🚀 Ouverture de l'application Delta");
            Intent launchIntentForPackage = this.context.getPackageManager().getLaunchIntentForPackage(DELTA_PACKAGE_NAME);
            if (launchIntentForPackage == null) {
                this.logManager.logError(TAG, "❌ Impossible de trouver l'activité de lancement de Delta");
            } else {
                launchIntentForPackage.addFlags(268435456);
                this.context.startActivity(launchIntentForPackage);
            }
        } catch (Exception e) {
            this.logManager.logError(TAG, "❌ Erreur lors de l'ouverture de Delta", e);
        }
    }

    public void openDeltaPlayStorePage() {
        try {
            this.logManager.logInfo(TAG, "📱 Ouverture de la page Play Store de Delta");
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=dev.shadoe.delta"));
            intent.addFlags(268435456);
            this.context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            this.logManager.logWarning(TAG, "Play Store non disponible, ouverture dans le navigateur");
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setData(Uri.parse("https://play.google.com/store/apps/details?id=dev.shadoe.delta"));
                intent2.addFlags(268435456);
                this.context.startActivity(intent2);
            } catch (Exception e) {
                this.logManager.logError(TAG, "❌ Impossible d'ouvrir la page de Delta", e);
            }
        }
    }

    public boolean startHotspot() {
        if (!isDeltaInstalled()) {
            this.logManager.logError(TAG, "❌ Impossible de démarrer le hotspot: Delta n'est pas installé");
            showDeltaNotInstalledMessage();
            return false;
        }
        try {
            this.logManager.logInfo(TAG, "📡 Envoi de la commande START_SOFT_AP à Delta");
            Intent intent = new Intent(ACTION_START_HOTSPOT);
            intent.setPackage(DELTA_PACKAGE_NAME);
            this.context.sendBroadcast(intent);
            this.logManager.logInfo(TAG, "✅ Commande START_SOFT_AP envoyée à Delta");
            return true;
        } catch (Exception e) {
            this.logManager.logError(TAG, "❌ Erreur lors de l'envoi de START_SOFT_AP", e);
            return false;
        }
    }

    public boolean stopHotspot() {
        if (!isDeltaInstalled()) {
            this.logManager.logError(TAG, "❌ Impossible d'arrêter le hotspot: Delta n'est pas installé");
            return false;
        }
        try {
            this.logManager.logInfo(TAG, "📡 Envoi de la commande STOP_SOFT_AP à Delta");
            Intent intent = new Intent(ACTION_STOP_HOTSPOT);
            intent.setPackage(DELTA_PACKAGE_NAME);
            this.context.sendBroadcast(intent);
            this.logManager.logInfo(TAG, "✅ Commande STOP_SOFT_AP envoyée à Delta");
            return true;
        } catch (Exception e) {
            this.logManager.logError(TAG, "❌ Erreur lors de l'envoi de STOP_SOFT_AP", e);
            return false;
        }
    }
}
