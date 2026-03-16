package fr.sd.taada.helpers.os;

import B2.b;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import fr.sd.taada.helpers.CustomOsPermissionHelper;

/* JADX INFO: loaded from: classes2.dex */
public class StandardPermissionHandler implements OsPermissionHandler {
    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    public boolean areBackgroundPermissionsGranted(Context context) {
        return true;
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
        return b.h(new StringBuilder("Android ("), Build.MANUFACTURER, ")");
    }

    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    public Intent getPermissionSettingsIntent(Context context) {
        return CustomOsPermissionHelper.getStandardAppDetailsIntent(context);
    }

    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    public boolean isDeviceMatch() {
        return true;
    }

    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    public boolean requiresSpecialBackgroundPermissions() {
        return false;
    }
}
