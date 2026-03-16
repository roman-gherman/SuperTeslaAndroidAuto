package fr.sd.taada.helpers;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.PowerManager;
import android.util.Log;
import fr.sd.taada.helpers.os.HuaweiPermissionHandler;
import fr.sd.taada.helpers.os.OppoPermissionHandler;
import fr.sd.taada.helpers.os.OsPermissionHandler;
import fr.sd.taada.helpers.os.SamsungPermissionHandler;
import fr.sd.taada.helpers.os.StandardPermissionHandler;
import fr.sd.taada.helpers.os.VivoPermissionHandler;
import fr.sd.taada.helpers.os.XiaomiPermissionHandler;

/* JADX INFO: loaded from: classes2.dex */
public class CustomOsPermissionHelper {
    private static final String TAG = "CustomOsPermissionHelper";
    private static OsPermissionHandler activeHandler;

    public enum CustomOsType {
        XIAOMI_MIUI,
        SAMSUNG_ONE_UI,
        OPPO_COLOR_OS,
        VIVO_FUNTOUCH_OS,
        HUAWEI_EMUI,
        STOCK_ANDROID,
        UNKNOWN
    }

    public static boolean areBackgroundPermissionsGranted(Context context) {
        return getHandler().areBackgroundPermissionsGranted(context);
    }

    public static boolean canDisplayOnLockScreen(Context context) {
        return getHandler().canDisplayOnLockScreen(context);
    }

    public static boolean canShowPopupInBackground(Context context) {
        return getHandler().canShowPopupInBackground(context);
    }

    public static CustomOsType detectCustomOs() {
        OsPermissionHandler handler = getHandler();
        return handler instanceof XiaomiPermissionHandler ? CustomOsType.XIAOMI_MIUI : handler instanceof SamsungPermissionHandler ? CustomOsType.SAMSUNG_ONE_UI : handler instanceof OppoPermissionHandler ? CustomOsType.OPPO_COLOR_OS : handler instanceof VivoPermissionHandler ? CustomOsType.VIVO_FUNTOUCH_OS : handler instanceof HuaweiPermissionHandler ? CustomOsType.HUAWEI_EMUI : CustomOsType.STOCK_ANDROID;
    }

    public static Intent getBatteryOptimizationSettingsIntent(Context context) {
        return getHandler().getBatterySettingsIntent(context);
    }

    public static String getCustomOsDescription() {
        return getHandler().getOsDescription();
    }

    private static synchronized OsPermissionHandler getHandler() {
        try {
            if (activeHandler == null) {
                if (new XiaomiPermissionHandler().isDeviceMatch()) {
                    activeHandler = new XiaomiPermissionHandler();
                } else if (new SamsungPermissionHandler().isDeviceMatch()) {
                    activeHandler = new SamsungPermissionHandler();
                } else if (new OppoPermissionHandler().isDeviceMatch()) {
                    activeHandler = new OppoPermissionHandler();
                } else if (new VivoPermissionHandler().isDeviceMatch()) {
                    activeHandler = new VivoPermissionHandler();
                } else if (new HuaweiPermissionHandler().isDeviceMatch()) {
                    activeHandler = new HuaweiPermissionHandler();
                } else {
                    activeHandler = new StandardPermissionHandler();
                }
                activeHandler.getOsDescription();
            }
        } catch (Throwable th) {
            throw th;
        }
        return activeHandler;
    }

    public static Intent getMiuiPermissionSettingsIntent(Context context) {
        return getHandler().getPermissionSettingsIntent(context);
    }

    public static Intent getPermissionSettingsIntent(Context context) {
        return getHandler().getPermissionSettingsIntent(context);
    }

    public static Intent getSamsungBatterySettingsIntent(Context context) {
        return getHandler().getBatterySettingsIntent(context);
    }

    public static Intent getStandardAppDetailsIntent(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + context.getPackageName()));
        return intent;
    }

    public static Intent getStandardBatteryOptimizationSettingsIntent(Context context) {
        Intent intent = new Intent();
        intent.setAction("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
        intent.setData(Uri.parse("package:" + context.getPackageName()));
        if (intent.resolveActivity(context.getPackageManager()) == null) {
            intent.setAction("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS");
            if (intent.resolveActivity(context.getPackageManager()) == null) {
                return getStandardAppDetailsIntent(context);
            }
        }
        return intent;
    }

    public static boolean isBatteryOptimizationDisabled(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            return powerManager.isIgnoringBatteryOptimizations(context.getPackageName());
        }
        return true;
    }

    public static boolean isSamsungDevice() {
        return getHandler() instanceof SamsungPermissionHandler;
    }

    public static boolean isXiaomiDevice() {
        return getHandler() instanceof XiaomiPermissionHandler;
    }

    public static boolean openBatteryOptimizationSettings(Context context) {
        try {
            Intent standardBatteryOptimizationSettingsIntent = getStandardBatteryOptimizationSettingsIntent(context);
            if (standardBatteryOptimizationSettingsIntent != null && standardBatteryOptimizationSettingsIntent.resolveActivity(context.getPackageManager()) != null) {
                standardBatteryOptimizationSettingsIntent.addFlags(268435456);
                context.startActivity(standardBatteryOptimizationSettingsIntent);
                return true;
            }
            Intent intent = new Intent("android.settings.BATTERY_SAVER_SETTINGS");
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                intent.addFlags(268435456);
                context.startActivity(intent);
                return true;
            }
            Intent standardAppDetailsIntent = getStandardAppDetailsIntent(context);
            standardAppDetailsIntent.addFlags(268435456);
            context.startActivity(standardAppDetailsIntent);
            return true;
        } catch (Exception e) {
            Log.e(TAG, "Failed to open battery optimization settings", e);
            return false;
        }
    }

    public static boolean openPermissionSettings(Context context) {
        return getHandler().openPermissionSettings(context);
    }

    public static boolean requiresSpecialBackgroundPermissions() {
        return getHandler().requiresSpecialBackgroundPermissions();
    }

    public static void resetAllPermissionFlags(Context context) {
        context.getSharedPreferences("custom_os_permissions", 0).edit().clear().apply();
    }

    public static void setCustomOsAutoStartPermissionGranted(Context context, boolean z6) {
        context.getSharedPreferences("custom_os_permissions", 0).edit().putBoolean("auto_start_granted", z6).apply();
    }

    public static void setMiuiLockScreenPermissionGranted(Context context, boolean z6) {
        context.getSharedPreferences("custom_os_permissions", 0).edit().putBoolean("miui_lock_screen_granted", z6).apply();
    }

    public static void setMiuiPopupPermissionGranted(Context context, boolean z6) {
        context.getSharedPreferences("custom_os_permissions", 0).edit().putBoolean("miui_popup_granted", z6).apply();
    }
}
