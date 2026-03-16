package fr.sd.taada.helpers.permissions;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.VpnService;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;
import fr.sd.taada.R;
import fr.sd.taada.helpers.CustomOsPermissionHelper;
import fr.sd.taada.helpers.permissions.PermissionItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionStatusManager {
    private static final String KEY_AUTO_START = "auto_start_granted";
    private static final String KEY_MIUI_LOCK_SCREEN = "miui_lock_screen_granted";
    private static final String KEY_MIUI_POPUP = "miui_popup_granted";
    private static final String PREFS_CUSTOM_OS = "custom_os_permissions";
    private final Context context;

    public PermissionStatusManager(@NonNull Context context) {
        this.context = context.getApplicationContext();
    }

    private void addCustomOsPermissions(@NonNull List<PermissionItem> list) {
        SharedPreferences sharedPreferences = this.context.getSharedPreferences(PREFS_CUSTOM_OS, 0);
        boolean zCanDisplayOnLockScreen = CustomOsPermissionHelper.canDisplayOnLockScreen(this.context);
        boolean zContains = sharedPreferences.contains(KEY_MIUI_LOCK_SCREEN);
        if (!zCanDisplayOnLockScreen || zContains) {
            PermissionItem.Status status = zCanDisplayOnLockScreen ? PermissionItem.Status.UNVERIFIABLE : (zContains && sharedPreferences.getBoolean(KEY_MIUI_LOCK_SCREEN, false)) ? PermissionItem.Status.UNVERIFIABLE : PermissionItem.Status.MANUAL_REQUIRED;
            list.add(new PermissionItem(this.context.getString(R.string.permission_lock_screen), status, PermissionItem.PermissionType.CUSTOM_OS_LOCK_SCREEN));
        }
        boolean zCanShowPopupInBackground = CustomOsPermissionHelper.canShowPopupInBackground(this.context);
        boolean zContains2 = sharedPreferences.contains(KEY_MIUI_POPUP);
        if (!zCanShowPopupInBackground || zContains2) {
            PermissionItem.Status status2 = zCanShowPopupInBackground ? PermissionItem.Status.UNVERIFIABLE : (zContains2 && sharedPreferences.getBoolean(KEY_MIUI_POPUP, false)) ? PermissionItem.Status.UNVERIFIABLE : PermissionItem.Status.MANUAL_REQUIRED;
            list.add(new PermissionItem(this.context.getString(R.string.permission_popup_background), status2, PermissionItem.PermissionType.CUSTOM_OS_POPUP));
        }
        boolean zAreBackgroundPermissionsGranted = CustomOsPermissionHelper.areBackgroundPermissionsGranted(this.context);
        boolean zContains3 = sharedPreferences.contains(KEY_AUTO_START);
        if (!zAreBackgroundPermissionsGranted || zContains3) {
            PermissionItem.Status status3 = zAreBackgroundPermissionsGranted ? PermissionItem.Status.UNVERIFIABLE : (zContains3 && sharedPreferences.getBoolean(KEY_AUTO_START, false)) ? PermissionItem.Status.UNVERIFIABLE : PermissionItem.Status.MANUAL_REQUIRED;
            list.add(new PermissionItem(this.context.getString(R.string.permission_auto_start), status3, PermissionItem.PermissionType.CUSTOM_OS_AUTO_START));
        }
    }

    public boolean areAllGranted(@NonNull List<PermissionItem> list) {
        Iterator<PermissionItem> it = list.iterator();
        while (it.hasNext()) {
            if (!it.next().isGranted()) {
                return false;
            }
        }
        return true;
    }

    public int getGrantedCount(@NonNull List<PermissionItem> list) {
        Iterator<PermissionItem> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().isGranted()) {
                i++;
            }
        }
        return i;
    }

    @NonNull
    public List<PermissionItem> getPermissionsList() {
        ArrayList arrayList = new ArrayList();
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            arrayList.add(new PermissionItem(this.context.getString(R.string.permission_bluetooth), ContextCompat.checkSelfPermission(this.context, "android.permission.BLUETOOTH_CONNECT") == 0 ? PermissionItem.Status.GRANTED : PermissionItem.Status.DENIED, PermissionItem.PermissionType.BLUETOOTH));
        }
        arrayList.add(new PermissionItem(this.context.getString(R.string.permission_microphone), ContextCompat.checkSelfPermission(this.context, "android.permission.RECORD_AUDIO") == 0 ? PermissionItem.Status.GRANTED : PermissionItem.Status.DENIED, PermissionItem.PermissionType.MICROPHONE));
        if (i >= 33) {
            arrayList.add(new PermissionItem(this.context.getString(R.string.permission_notifications), ContextCompat.checkSelfPermission(this.context, "android.permission.POST_NOTIFICATIONS") == 0 ? PermissionItem.Status.GRANTED : PermissionItem.Status.DENIED, PermissionItem.PermissionType.NOTIFICATIONS));
        }
        arrayList.add(new PermissionItem(this.context.getString(R.string.permission_overlay), Settings.canDrawOverlays(this.context) ? PermissionItem.Status.GRANTED : PermissionItem.Status.DENIED, PermissionItem.PermissionType.OVERLAY));
        arrayList.add(new PermissionItem(this.context.getString(R.string.permission_write_settings), Settings.System.canWrite(this.context) ? PermissionItem.Status.GRANTED : PermissionItem.Status.DENIED, PermissionItem.PermissionType.WRITE_SETTINGS));
        if (PreferenceManager.getDefaultSharedPreferences(this.context).getBoolean("usevpn", true)) {
            arrayList.add(new PermissionItem(this.context.getString(R.string.permission_vpn), VpnService.prepare(this.context) == null ? PermissionItem.Status.GRANTED : PermissionItem.Status.DENIED, PermissionItem.PermissionType.VPN));
        }
        arrayList.add(new PermissionItem(this.context.getString(R.string.permission_battery), (CustomOsPermissionHelper.isBatteryOptimizationDisabled(this.context) || this.context.getSharedPreferences(PREFS_CUSTOM_OS, 0).getBoolean("battery_optimization_granted", false)) ? PermissionItem.Status.UNVERIFIABLE : PermissionItem.Status.DENIED, PermissionItem.PermissionType.BATTERY_OPTIMIZATION));
        if (CustomOsPermissionHelper.requiresSpecialBackgroundPermissions()) {
            addCustomOsPermissions(arrayList);
        }
        return arrayList;
    }
}
