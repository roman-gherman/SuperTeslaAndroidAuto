package fr.sd.taada.helpers.os;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import fr.sd.taada.helpers.CustomOsPermissionHelper;

/* JADX INFO: loaded from: classes2.dex */
public class SamsungPermissionHandler implements OsPermissionHandler {
    private static final String TAG = "SamsungPermissionHandler";

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

    /* JADX WARN: Code restructure failed: missing block: B:7:0x002e, code lost:
    
        if (r1.resolveActivity(r5.getPackageManager()) != null) goto L8;
     */
    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.content.Intent getBatterySettingsIntent(android.content.Context r5) {
        /*
            r4 = this;
            java.lang.String r0 = "com.samsung.android.lool"
            android.content.Intent r1 = new android.content.Intent
            r1.<init>()
            android.content.ComponentName r2 = new android.content.ComponentName     // Catch: java.lang.Exception -> L31
            java.lang.String r3 = "com.samsung.android.sm.battery.ui.BatteryActivity"
            r2.<init>(r0, r3)     // Catch: java.lang.Exception -> L31
            r1.setComponent(r2)     // Catch: java.lang.Exception -> L31
            android.content.pm.PackageManager r2 = r5.getPackageManager()     // Catch: java.lang.Exception -> L31
            android.content.ComponentName r2 = r1.resolveActivity(r2)     // Catch: java.lang.Exception -> L31
            if (r2 == 0) goto L1c
            goto L30
        L1c:
            android.content.ComponentName r2 = new android.content.ComponentName     // Catch: java.lang.Exception -> L31
            java.lang.String r3 = "com.samsung.android.sm.ui.dashboard.SmartManagerDashBoardActivity"
            r2.<init>(r0, r3)     // Catch: java.lang.Exception -> L31
            r1.setComponent(r2)     // Catch: java.lang.Exception -> L31
            android.content.pm.PackageManager r0 = r5.getPackageManager()     // Catch: java.lang.Exception -> L31
            android.content.ComponentName r0 = r1.resolveActivity(r0)     // Catch: java.lang.Exception -> L31
            if (r0 == 0) goto L39
        L30:
            return r1
        L31:
            r0 = move-exception
            java.lang.String r1 = "SamsungPermissionHandler"
            java.lang.String r2 = "Error creating Samsung battery intent"
            android.util.Log.e(r1, r2, r0)
        L39:
            android.content.Intent r5 = fr.sd.taada.helpers.CustomOsPermissionHelper.getStandardBatteryOptimizationSettingsIntent(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.sd.taada.helpers.os.SamsungPermissionHandler.getBatterySettingsIntent(android.content.Context):android.content.Intent");
    }

    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    public String getOsDescription() {
        return "Samsung One UI";
    }

    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    public Intent getPermissionSettingsIntent(Context context) {
        return CustomOsPermissionHelper.getStandardAppDetailsIntent(context);
    }

    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    public boolean isDeviceMatch() {
        return Build.MANUFACTURER.toLowerCase().contains("samsung");
    }

    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    public boolean requiresSpecialBackgroundPermissions() {
        return true;
    }
}
