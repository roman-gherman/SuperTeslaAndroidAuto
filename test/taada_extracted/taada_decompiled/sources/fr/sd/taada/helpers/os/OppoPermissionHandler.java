package fr.sd.taada.helpers.os;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import fr.sd.taada.helpers.CustomOsPermissionHelper;

/* JADX INFO: loaded from: classes2.dex */
public class OppoPermissionHandler implements OsPermissionHandler {
    private static final String TAG = "OppoPermissionHandler";

    private boolean tryColorOsAutoStartSettings(Context context) {
        String[][] strArr = {new String[]{"com.oplus.safecenter", "com.oplus.safecenter.permission.startup.StartupAppListActivity"}, new String[]{"com.oplus.safecenter", "com.oplus.safecenter.startupapp.StartupAppListActivity"}, new String[]{"com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity"}, new String[]{"com.coloros.safecenter", "com.coloros.safecenter.startupapp.StartupAppListActivity"}, new String[]{"com.oppo.safe", "com.oppo.safe.permission.startup.StartupAppListActivity"}};
        for (int i = 0; i < 5; i++) {
            String[] strArr2 = strArr[i];
            if (tryComponentIntent(context, strArr2[0], strArr2[1])) {
                return true;
            }
        }
        return false;
    }

    private boolean tryColorOsBatterySettings(Context context) {
        String[][] strArr = {new String[]{"com.oplus.battery", "com.oplus.battery.ui.AppPowerUsageActivity"}, new String[]{"com.oplus.battery", "com.oplus.battery.ui.AppDetailsBatteryActivity"}, new String[]{"com.oplus.battery", "com.oplus.battery.BatteryOptimizationActivity"}, new String[]{"com.oplus.athena", "com.oplus.athena.startup.StartupActivity"}, new String[]{"com.oplus.safecenter", "com.oplus.safecenter.permission.PermissionTopActivity"}};
        for (int i = 0; i < 5; i++) {
            String[] strArr2 = strArr[i];
            if (tryComponentIntent(context, strArr2[0], strArr2[1])) {
                return true;
            }
        }
        String[][] strArr3 = {new String[]{"com.coloros.oppoguardelf", "com.coloros.powermanager.fuelgaue.PowerUsageModelActivity"}, new String[]{"com.coloros.oppoguardelf", "com.coloros.powermanager.fuelgaue.PowerAppsBgSetting"}, new String[]{"com.coloros.oppoguardelf", "com.coloros.powermanager.fuelgaue.PowerSaverModeActivity"}, new String[]{"com.coloros.safecenter", "com.coloros.safecenter.permission.PermissionAppAllPermissionActivity"}};
        for (int i3 = 0; i3 < 4; i3++) {
            String[] strArr4 = strArr3[i3];
            if (tryComponentIntent(context, strArr4[0], strArr4[1])) {
                return true;
            }
        }
        String[][] strArr5 = {new String[]{"com.oppo.safe", "com.oppo.safe.permission.startup.StartupAppListActivity"}, new String[]{"com.oppo.safe", "com.oppo.safe.permission.floatwindow.FloatWindowListActivity"}};
        for (int i4 = 0; i4 < 2; i4++) {
            String[] strArr6 = strArr5[i4];
            if (tryComponentIntent(context, strArr6[0], strArr6[1])) {
                return true;
            }
        }
        return false;
    }

    private boolean tryComponentIntent(Context context, String str, String str2) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(str, str2));
            intent.addFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean tryGenericActions(Context context) {
        String[] strArr = {"coloros.intent.action.STARTUP_MANAGER", "oppo.intent.action.STARTUP_APP_LIST"};
        for (int i = 0; i < 2; i++) {
            try {
                Intent intent = new Intent(strArr[i]);
                intent.addFlags(268435456);
                context.startActivity(intent);
                return true;
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return false;
    }

    private boolean tryOpenAppDetails(Context context) {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            intent.addFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            Log.e(TAG, "FAILED: Could not open app details: " + e.getMessage());
            return false;
        }
    }

    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    public boolean areBackgroundPermissionsGranted(Context context) {
        return context.getSharedPreferences("custom_os_permissions", 0).getBoolean("auto_start_granted", false);
    }

    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    public boolean canDisplayOnLockScreen(Context context) {
        return true;
    }

    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    public boolean canShowPopupInBackground(Context context) {
        return true;
    }

    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    public Intent getBatterySettingsIntent(Context context) {
        return CustomOsPermissionHelper.getStandardBatteryOptimizationSettingsIntent(context);
    }

    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    public String getOsDescription() {
        return "Oppo ColorOS / Realme UI";
    }

    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    @Deprecated
    public Intent getPermissionSettingsIntent(Context context) {
        return CustomOsPermissionHelper.getStandardAppDetailsIntent(context);
    }

    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    public boolean isDeviceMatch() {
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        String lowerCase2 = Build.BRAND.toLowerCase();
        return lowerCase.contains("oppo") || lowerCase2.contains("oppo") || lowerCase2.contains("realme") || lowerCase2.contains("oneplus");
    }

    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    public boolean openPermissionSettings(Context context) {
        if (tryColorOsBatterySettings(context) || tryColorOsAutoStartSettings(context) || tryGenericActions(context)) {
            return true;
        }
        Log.w(TAG, "All ColorOS-specific intents failed. Opening app details as fallback.");
        return tryOpenAppDetails(context);
    }

    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    public boolean requiresSpecialBackgroundPermissions() {
        return true;
    }
}
