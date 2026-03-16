package fr.sd.taada.helpers.os;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import fr.sd.taada.helpers.CustomOsPermissionHelper;

/* JADX INFO: loaded from: classes2.dex */
public class XiaomiPermissionHandler implements OsPermissionHandler {
    private static final String TAG = "XiaomiPermissionHandler";

    private String getSystemProperty(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception e) {
            Log.e(TAG, "Error reading system property: " + str, e);
            return null;
        }
    }

    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    public boolean areBackgroundPermissionsGranted(Context context) {
        return canDisplayOnLockScreen(context) && canShowPopupInBackground(context);
    }

    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    public boolean canDisplayOnLockScreen(Context context) {
        try {
            getSystemProperty("ro.miui.ui.version.name");
        } catch (Exception e) {
            Log.e(TAG, "Error checking MIUI version", e);
        }
        return context.getSharedPreferences("custom_os_permissions", 0).getBoolean("miui_lock_screen_granted", false);
    }

    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    public boolean canShowPopupInBackground(Context context) {
        return context.getSharedPreferences("custom_os_permissions", 0).getBoolean("miui_popup_granted", false);
    }

    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    public Intent getBatterySettingsIntent(Context context) {
        return CustomOsPermissionHelper.getStandardBatteryOptimizationSettingsIntent(context);
    }

    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    public String getOsDescription() {
        return "Xiaomi MIUI";
    }

    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    public Intent getPermissionSettingsIntent(Context context) {
        Intent intent = new Intent();
        try {
            intent.setAction("miui.intent.action.APP_PERM_EDITOR");
            intent.putExtra("extra_pkgname", context.getPackageName());
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                return intent;
            }
            Intent intent2 = new Intent("miui.intent.action.APP_PERM_EDITOR");
            intent2.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
            intent2.putExtra("extra_pkgname", context.getPackageName());
            if (intent2.resolveActivity(context.getPackageManager()) != null) {
                return intent2;
            }
            Intent intent3 = new Intent();
            intent3.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"));
            if (intent3.resolveActivity(context.getPackageManager()) != null) {
                return intent3;
            }
        } catch (Exception e) {
            Log.e(TAG, "Error creating MIUI permission intent", e);
        }
        Intent intent4 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent4.setData(Uri.parse("package:" + context.getPackageName()));
        return intent4;
    }

    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    public boolean isDeviceMatch() {
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        String lowerCase2 = Build.BRAND.toLowerCase();
        return lowerCase.contains("xiaomi") || lowerCase2.contains("xiaomi") || lowerCase2.contains("redmi") || lowerCase2.contains("poco");
    }

    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    public boolean requiresSpecialBackgroundPermissions() {
        return true;
    }
}
