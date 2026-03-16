package fr.sd.taada.helpers.os;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import fr.sd.taada.helpers.CustomOsPermissionHelper;

/* JADX INFO: loaded from: classes2.dex */
public class VivoPermissionHandler implements OsPermissionHandler {
    private static final String TAG = "VivoPermissionHandler";

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
        return "Vivo Funtouch OS";
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0030, code lost:
    
        if (r0.resolveActivity(r5.getPackageManager()) != null) goto L8;
     */
    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.content.Intent getPermissionSettingsIntent(android.content.Context r5) {
        /*
            r4 = this;
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            android.content.ComponentName r1 = new android.content.ComponentName     // Catch: java.lang.Exception -> L33
            java.lang.String r2 = "com.iqoo.secure"
            java.lang.String r3 = "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity"
            r1.<init>(r2, r3)     // Catch: java.lang.Exception -> L33
            r0.setComponent(r1)     // Catch: java.lang.Exception -> L33
            android.content.pm.PackageManager r1 = r5.getPackageManager()     // Catch: java.lang.Exception -> L33
            android.content.ComponentName r1 = r0.resolveActivity(r1)     // Catch: java.lang.Exception -> L33
            if (r1 == 0) goto L1c
            goto L32
        L1c:
            android.content.ComponentName r1 = new android.content.ComponentName     // Catch: java.lang.Exception -> L33
            java.lang.String r2 = "com.vivo.permissionmanager"
            java.lang.String r3 = "com.vivo.permissionmanager.activity.BgStartUpManagerActivity"
            r1.<init>(r2, r3)     // Catch: java.lang.Exception -> L33
            r0.setComponent(r1)     // Catch: java.lang.Exception -> L33
            android.content.pm.PackageManager r1 = r5.getPackageManager()     // Catch: java.lang.Exception -> L33
            android.content.ComponentName r1 = r0.resolveActivity(r1)     // Catch: java.lang.Exception -> L33
            if (r1 == 0) goto L3b
        L32:
            return r0
        L33:
            r0 = move-exception
            java.lang.String r1 = "VivoPermissionHandler"
            java.lang.String r2 = "Error creating Vivo permission intent"
            android.util.Log.e(r1, r2, r0)
        L3b:
            android.content.Intent r5 = fr.sd.taada.helpers.CustomOsPermissionHelper.getStandardAppDetailsIntent(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.sd.taada.helpers.os.VivoPermissionHandler.getPermissionSettingsIntent(android.content.Context):android.content.Intent");
    }

    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    public boolean isDeviceMatch() {
        return Build.MANUFACTURER.toLowerCase().contains("vivo");
    }

    @Override // fr.sd.taada.helpers.os.OsPermissionHandler
    public boolean requiresSpecialBackgroundPermissions() {
        return true;
    }
}
