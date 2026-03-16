package p072l2;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Handler;
import fr.sd.taada.helpers.DeltaHotspotManager;
import fr.sd.taada.helpers.LogManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class C2871c {
    private static final String f8958b = "HotspotManager";
    private DeltaHotspotManager deltaManager;
    private final Context f8959a;
    private LogManager logManager;

    public C2871c(Context context) {
        this.f8959a = context;
        this.deltaManager = new DeltaHotspotManager(context);
    }

    private LogManager getLogManager() {
        if (this.logManager == null) {
            this.logManager = LogManager.getInstance(this.f8959a);
        }
        return this.logManager;
    }

    private void startHotspotViaDelta(AbstractC2870b abstractC2870b) {
        getLogManager().logInfo(f8958b, "📱 Android 16+ : Démarrage du hotspot via Delta");
        if (!this.deltaManager.isDeltaInstalled()) {
            getLogManager().logError(f8958b, "❌ Delta n'est pas installé mais est requis pour Android 16+");
            getLogManager().logInfo(f8958b, this.deltaManager.getHelpMessage());
            return;
        }
        getLogManager().logInfo(f8958b, "✅ Delta détecté, envoi de START_SOFT_AP");
        if (this.deltaManager.startHotspot()) {
            getLogManager().logInfo(f8958b, "✅ Commande START_SOFT_AP envoyée avec succès");
        } else {
            getLogManager().logError(f8958b, "❌ Échec de l'envoi de START_SOFT_AP");
        }
    }

    private void startHotspotViaNativeAPI(AbstractC2870b abstractC2870b, Handler handler) {
        Object objNewInstance;
        Class cls = Integer.TYPE;
        getLogManager().logInfo(f8958b, "📱 Android < 16 : Démarrage du hotspot via API native");
        Class<?> cls2 = null;
        try {
            objNewInstance = new C2869a(this.f8959a, abstractC2870b).m2252b().getDeclaredConstructor(cls).newInstance(0);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            getLogManager().logError(f8958b, "Erreur lors de la création du callback", e);
            e.printStackTrace();
            objNewInstance = null;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f8959a.getApplicationContext().getSystemService(ConnectivityManager.class);
        try {
            try {
                cls2 = Class.forName("android.net.ConnectivityManager$OnStartTetheringCallback");
            } catch (ClassNotFoundException e6) {
                getLogManager().logError(f8958b, "Classe OnStartTetheringCallback non trouvée", e6);
                e6.printStackTrace();
            }
            Method declaredMethod = connectivityManager.getClass().getDeclaredMethod("startTethering", cls, Boolean.TYPE, cls2, Handler.class);
            if (declaredMethod == null) {
                getLogManager().logError(f8958b, "❌ startTetheringMethod est null");
            } else {
                declaredMethod.invoke(connectivityManager, 0, Boolean.FALSE, objNewInstance, handler);
                getLogManager().logInfo(f8958b, "✅ Hotspot démarré via l'API native");
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e7) {
            getLogManager().logError(f8958b, "❌ Erreur lors du démarrage du hotspot", e7);
            e7.printStackTrace();
        }
    }

    private void stopHotspotViaDelta(boolean z6) {
        getLogManager().logInfo(f8958b, "📱 Android 16+ : Arrêt du hotspot via Delta");
        if (!this.deltaManager.isDeltaInstalled()) {
            getLogManager().logWarning(f8958b, "⚠️ Delta n'est pas installé, impossible d'arrêter le hotspot via Delta");
            stopHotspotViaNativeAPI(z6);
            return;
        }
        getLogManager().logInfo(f8958b, "✅ Delta détecté, envoi de STOP_SOFT_AP");
        if (this.deltaManager.stopHotspot()) {
            getLogManager().logInfo(f8958b, "✅ Commande STOP_SOFT_AP envoyée avec succès");
        } else {
            getLogManager().logError(f8958b, "❌ Échec de l'envoi de STOP_SOFT_AP");
        }
        if (z6) {
            ((WifiManager) this.f8959a.getApplicationContext().getSystemService("wifi")).setWifiEnabled(true);
            getLogManager().logInfo(f8958b, "📶 WiFi réactivé");
        }
    }

    private void stopHotspotViaNativeAPI(boolean z6) {
        getLogManager().logInfo(f8958b, "📱 Android < 16 : Arrêt du hotspot via API native");
        ((WifiManager) this.f8959a.getApplicationContext().getSystemService("wifi")).setWifiEnabled(z6);
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f8959a.getApplicationContext().getSystemService(ConnectivityManager.class);
        try {
            Method declaredMethod = connectivityManager.getClass().getDeclaredMethod("stopTethering", Integer.TYPE);
            if (declaredMethod == null) {
                getLogManager().logError(f8958b, "❌ stopTetheringMethod est null");
            } else {
                declaredMethod.invoke(connectivityManager, 0);
                getLogManager().logInfo(f8958b, "✅ Hotspot arrêté via l'API native");
            }
        } catch (IllegalAccessException e) {
            e = e;
            getLogManager().logError(f8958b, "❌ Erreur lors de l'arrêt du hotspot", e);
            e.printStackTrace();
        } catch (NoSuchMethodException e6) {
            e = e6;
            getLogManager().logError(f8958b, "❌ Erreur lors de l'arrêt du hotspot", e);
            e.printStackTrace();
        } catch (InvocationTargetException e7) {
            e = e7;
            getLogManager().logError(f8958b, "❌ Erreur lors de l'arrêt du hotspot", e);
            e.printStackTrace();
        }
    }

    public void m2250b(boolean z6) {
        if (DeltaHotspotManager.isDeltaRequired()) {
            stopHotspotViaDelta(z6);
        } else {
            stopHotspotViaNativeAPI(z6);
        }
    }

    public void m2251a(AbstractC2870b abstractC2870b, Handler handler) {
        if (DeltaHotspotManager.isDeltaRequired()) {
            startHotspotViaDelta(abstractC2870b);
        } else {
            startHotspotViaNativeAPI(abstractC2870b, handler);
        }
    }
}
