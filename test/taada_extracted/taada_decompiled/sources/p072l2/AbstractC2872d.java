package p072l2;

import android.content.Context;
import android.net.wifi.WifiManager;
import fr.sd.taada.helpers.DeltaHotspotManager;
import fr.sd.taada.helpers.LogManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2872d {
    private static final String TAG = "TetheringManager";
    private static Context f8960a;
    private static C2871c f8961b;

    public static class C2873a extends AbstractC2870b {
    }

    public static void m2248b(Context context, boolean z6) {
        f8960a = context;
        LogManager logManager = LogManager.getInstance(context);
        if (DeltaHotspotManager.isDeltaRequired()) {
            logManager.logInfo(TAG, "📱 Delta sera utilisé - Gestion du WiFi par Delta");
            m2249a(z6);
            return;
        }
        logManager.logInfo(TAG, "📱 API native - Gestion manuelle du WiFi");
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (z6 && wifiManager != null) {
            logManager.logDebug(TAG, "📶 Désactivation du WiFi avant démarrage hotspot");
            wifiManager.setWifiEnabled(false);
        }
        m2249a(z6);
    }

    private static void m2249a(boolean z6) {
        if (f8961b == null) {
            f8961b = new C2871c(f8960a);
        }
        if (z6) {
            f8961b.m2251a(new C2873a(), null);
        } else {
            f8961b.m2250b(false);
        }
    }
}
