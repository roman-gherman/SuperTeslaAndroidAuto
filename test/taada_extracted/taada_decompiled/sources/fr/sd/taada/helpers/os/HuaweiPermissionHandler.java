package fr.sd.taada.helpers.os;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import fr.sd.taada.helpers.CustomOsPermissionHelper;

/* JADX INFO: loaded from: classes2.dex */
public class HuaweiPermissionHandler implements OsPermissionHandler {
    private static final String TAG = "HuaweiPermissionHandler";

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

    private boolean tryHuaweiHonorStartupSettings(Context context) {
        String[][] strArr = {new String[]{"com.hihonor.systemmanager", "com.hihonor.systemmanager.startupmgr.ui.StartupNormalAppListActivity"}, new String[]{"com.hihonor.systemmanager", "com.hihonor.systemmanager.optimize.process.ProtectActivity"}, new String[]{"com.hihonor.systemmanager", "com.hihonor.systemmanager.appcontrol.activity.StartupAppControlActivity"}, new String[]{"com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity"}, new String[]{"com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity"}, new String[]{"com.huawei.systemmanager", "com.huawei.systemmanager.appcontrol.activity.StartupAppControlActivity"}};
        for (int i = 0; i < 6; i++) {
            String[] strArr2 = strArr[i];
            if (tryComponentIntent(context, strArr2[0], strArr2[1])) {
                return true;
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
        return Build.MANUFACTURER.toLowerCase().contains("honor") ? "Honor MagicOS" : "Huawei EMUI";
    }

    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    @Deprecated
    public Intent getPermissionSettingsIntent(Context context) {
        return CustomOsPermissionHelper.getStandardAppDetailsIntent(context);
    }

    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    public boolean isDeviceMatch() {
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        return lowerCase.contains("huawei") || lowerCase.contains("honor");
    }

    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    public boolean openPermissionSettings(Context context) {
        if (tryHuaweiHonorStartupSettings(context)) {
            return true;
        }
        return tryOpenAppDetails(context);
    }

    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    public boolean requiresSpecialBackgroundPermissions() {
        return true;
    }
}
