package fr.sd.taada.helpers.os;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public interface OsPermissionHandler {
    boolean areBackgroundPermissionsGranted(Context context);

    boolean canDisplayOnLockScreen(Context context);

    boolean canShowPopupInBackground(Context context);

    Intent getBatterySettingsIntent(Context context);

    String getOsDescription();

    @Deprecated
    Intent getPermissionSettingsIntent(Context context);

    boolean isDeviceMatch();

    default boolean openPermissionSettings(Context context) {
        try {
            Intent permissionSettingsIntent = getPermissionSettingsIntent(context);
            permissionSettingsIntent.addFlags(268435456);
            context.startActivity(permissionSettingsIntent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    boolean requiresSpecialBackgroundPermissions();
}
