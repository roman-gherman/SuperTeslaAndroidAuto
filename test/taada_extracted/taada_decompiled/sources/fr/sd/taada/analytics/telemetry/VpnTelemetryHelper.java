package fr.sd.taada.analytics.telemetry;

import android.util.Log;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class VpnTelemetryHelper {
    private static final String TAG = "VpnTelemetryHelper";

    private static void logEvent(FunnelEvent funnelEvent, String str) {
        try {
            if (TelemetryManager.isInitialized() && TelemetryManager.getInstance().isEnabled()) {
                HashMap map = new HashMap();
                map.put("source", str);
                TelemetryManager.getInstance().logAndSync(funnelEvent, map);
            }
        } catch (Exception e) {
            Log.e(TAG, "Error sending telemetry event " + funnelEvent.getEventName() + ": " + e.getMessage(), e);
        }
    }

    public static void logVpnConnected(String str) {
        logEvent(FunnelEvent.VPN_CONNECTED, str);
    }

    public static void logVpnConnectionFailed(String str) {
        logEvent(FunnelEvent.VPN_CONNECTION_FAILED, str);
    }

    public static void logVpnDisconnected(String str) {
        logEvent(FunnelEvent.VPN_DISCONNECTED, str);
    }
}
