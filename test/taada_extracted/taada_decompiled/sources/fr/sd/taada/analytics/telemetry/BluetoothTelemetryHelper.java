package fr.sd.taada.analytics.telemetry;

import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import androidx.core.os.EnvironmentCompat;
import fr.sd.taada.helpers.LogManager;
import fr.sd.taada.services.SubscriptionCheckService;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class BluetoothTelemetryHelper {
    private static final String TAG = "BluetoothTelemetryHelper";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.content.Context] */
    private static String getAppStandbyBucket(Context context) {
        if (Build.VERSION.SDK_INT < 28) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
        try {
            UsageStatsManager usageStatsManager = (UsageStatsManager) context.getSystemService("usagestats");
            if (usageStatsManager == null) {
                return EnvironmentCompat.MEDIA_UNKNOWN;
            }
            int appStandbyBucket = usageStatsManager.getAppStandbyBucket();
            if (appStandbyBucket == 10) {
                return "active";
            }
            if (appStandbyBucket == 20) {
                return "working_set";
            }
            if (appStandbyBucket == 30) {
                return "frequent";
            }
            if (appStandbyBucket == 40) {
                return "rare";
            }
            if (appStandbyBucket == 45) {
                return "restricted";
            }
            context = "bucket_" + appStandbyBucket;
            return context;
        } catch (Exception e) {
            LogManager.getInstance(context).logError(TAG, "Failed to get standby bucket", e);
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    private static boolean isBatteryOptimizationDisabled(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            return powerManager.isIgnoringBatteryOptimizations(context.getPackageName());
        }
        return true;
    }

    private static boolean isTelemetryEnabled() {
        return TelemetryManager.isInitialized() && TelemetryManager.getInstance().isEnabled();
    }

    public static void logAutoStartBlocked(Context context, String str, String str2) {
        if (isTelemetryEnabled()) {
            HashMap map = new HashMap();
            map.put("reason", str);
            map.put("details", str2);
            map.put("device_manufacturer", Build.MANUFACTURER);
            map.put("is_battery_optimized", Boolean.valueOf(!isBatteryOptimizationDisabled(context)));
            TelemetryManager.getInstance().log(FunnelEvent.BT_AUTO_START_BLOCKED, map);
        }
    }

    public static void logAutoStartFailed(Context context, Exception exc, String str) {
        if (isTelemetryEnabled()) {
            HashMap map = new HashMap();
            map.put("error_class", exc.getClass().getSimpleName());
            map.put("error_message", exc.getMessage() != null ? exc.getMessage() : "null");
            map.put(SubscriptionCheckService.EXTRA_DEVICE_ADDRESS, str);
            map.put("device_manufacturer", Build.MANUFACTURER);
            map.put("is_battery_optimized", Boolean.valueOf(!isBatteryOptimizationDisabled(context)));
            map.put("android_version", Integer.valueOf(Build.VERSION.SDK_INT));
            TelemetryManager.getInstance().log(FunnelEvent.BT_AUTO_START_FAILED, map);
        }
    }

    public static void logAutoStartSuccess(String str) {
        if (isTelemetryEnabled()) {
            HashMap map = new HashMap();
            map.put(SubscriptionCheckService.EXTRA_DEVICE_ADDRESS, str);
            TelemetryManager.getInstance().log(FunnelEvent.AUTO_START_BLUETOOTH, map);
        }
    }

    public static void logBluetoothDisconnect() {
        if (isTelemetryEnabled()) {
            TelemetryManager.getInstance().log(FunnelEvent.BT_DISCONNECTED);
        }
    }

    public static void logReceiverTriggered(Context context, String str) {
        if (isTelemetryEnabled()) {
            HashMap map = new HashMap();
            map.put("action", str);
            map.put("device_manufacturer", Build.MANUFACTURER);
            map.put("device_model", Build.MODEL);
            map.put("is_battery_optimized", Boolean.valueOf(!isBatteryOptimizationDisabled(context)));
            map.put("app_standby_bucket", getAppStandbyBucket(context));
            map.put("android_version", Integer.valueOf(Build.VERSION.SDK_INT));
            TelemetryManager.getInstance().log(FunnelEvent.BT_RECEIVER_TRIGGERED, map);
        }
    }
}
