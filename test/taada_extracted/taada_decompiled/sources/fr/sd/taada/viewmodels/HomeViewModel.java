package fr.sd.taada.viewmodels;

import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.net.VpnService;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import android.view.LiveData;
import android.view.MutableLiveData;
import android.view.ViewModel;
import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;
import fr.sd.taada.TransporterService;
import fr.sd.taada.helpers.CustomOsPermissionHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class HomeViewModel extends ViewModel {
    public static final String ACTION_SERVICE_STATE_CHANGED = "fr.sd.taada.ACTION_SERVICE_STATE_CHANGED";
    private static final String TAG = "HomeViewModel";
    private final MutableLiveData<Boolean> allPermissionsGranted;
    private boolean batteryOptimizationRequired;
    private boolean customOsAutoStartPermissionRequired;
    private boolean customOsLockScreenPermissionRequired;
    private boolean customOsPopupPermissionRequired;
    private final List<String> missingRuntimePermissions;
    private boolean overlayPermissionRequired;
    private final List<String> selectedDeviceAddresses;
    private final MutableLiveData<List<String>> selectedDeviceNames;
    private final MutableLiveData<Boolean> serviceRunning;
    private boolean vpnPermissionRequired;
    private boolean writeSettingsPermissionRequired;

    public HomeViewModel() {
        Boolean bool = Boolean.FALSE;
        this.serviceRunning = new MutableLiveData<>(bool);
        this.allPermissionsGranted = new MutableLiveData<>(bool);
        this.selectedDeviceNames = new MutableLiveData<>(new ArrayList());
        this.overlayPermissionRequired = false;
        this.writeSettingsPermissionRequired = false;
        this.vpnPermissionRequired = false;
        this.batteryOptimizationRequired = false;
        this.customOsLockScreenPermissionRequired = false;
        this.customOsPopupPermissionRequired = false;
        this.customOsAutoStartPermissionRequired = false;
        this.missingRuntimePermissions = new ArrayList();
        this.selectedDeviceAddresses = new ArrayList();
    }

    public boolean areAllPermissionsGranted() {
        return this.allPermissionsGranted.getValue() != null && this.allPermissionsGranted.getValue().booleanValue();
    }

    public void checkAllPermissions(Context context) {
        boolean z6;
        this.missingRuntimePermissions.clear();
        this.overlayPermissionRequired = false;
        this.writeSettingsPermissionRequired = false;
        this.vpnPermissionRequired = false;
        this.batteryOptimizationRequired = false;
        this.customOsLockScreenPermissionRequired = false;
        this.customOsPopupPermissionRequired = false;
        this.customOsAutoStartPermissionRequired = false;
        int i = Build.VERSION.SDK_INT;
        if (i < 31 || ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH_CONNECT") == 0) {
            z6 = true;
        } else {
            this.missingRuntimePermissions.add("android.permission.BLUETOOTH_CONNECT");
            z6 = false;
        }
        if (ContextCompat.checkSelfPermission(context, "android.permission.RECORD_AUDIO") != 0) {
            this.missingRuntimePermissions.add("android.permission.RECORD_AUDIO");
            z6 = false;
        }
        if (i >= 33 && ContextCompat.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") != 0) {
            this.missingRuntimePermissions.add("android.permission.POST_NOTIFICATIONS");
            z6 = false;
        }
        if (!Settings.canDrawOverlays(context)) {
            this.overlayPermissionRequired = true;
            z6 = false;
        }
        if (!Settings.System.canWrite(context)) {
            this.writeSettingsPermissionRequired = true;
            z6 = false;
        }
        if (PreferenceManager.getDefaultSharedPreferences(context).getBoolean("usevpn", true) && VpnService.prepare(context) != null) {
            this.vpnPermissionRequired = true;
            z6 = false;
        }
        boolean z7 = context.getSharedPreferences("custom_os_permissions", 0).getBoolean("battery_optimization_granted", false);
        if (!CustomOsPermissionHelper.isBatteryOptimizationDisabled(context) && !z7) {
            this.batteryOptimizationRequired = true;
        }
        if (CustomOsPermissionHelper.requiresSpecialBackgroundPermissions()) {
            CustomOsPermissionHelper.getCustomOsDescription();
            if (!CustomOsPermissionHelper.canDisplayOnLockScreen(context)) {
                this.customOsLockScreenPermissionRequired = true;
            }
            if (!CustomOsPermissionHelper.canShowPopupInBackground(context)) {
                this.customOsPopupPermissionRequired = true;
            }
            if (!CustomOsPermissionHelper.areBackgroundPermissionsGranted(context)) {
                this.customOsAutoStartPermissionRequired = true;
            }
        }
        this.allPermissionsGranted.postValue(Boolean.valueOf(z6));
    }

    public void checkServiceState(Context context) {
        boolean z6;
        Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (TransporterService.class.getName().equals(it.next().service.getClassName())) {
                z6 = TransporterService.isServiceActive;
            }
        }
        this.serviceRunning.postValue(Boolean.valueOf(z6));
    }

    public LiveData<Boolean> getAllPermissionsGranted() {
        return this.allPermissionsGranted;
    }

    public List<String> getMissingRuntimePermissions() {
        return new ArrayList(this.missingRuntimePermissions);
    }

    public List<String> getSelectedDeviceAddresses() {
        return new ArrayList(this.selectedDeviceAddresses);
    }

    public LiveData<List<String>> getSelectedDeviceNames() {
        return this.selectedDeviceNames;
    }

    public LiveData<Boolean> getServiceRunning() {
        return this.serviceRunning;
    }

    public boolean isBatteryOptimizationRequired() {
        return this.batteryOptimizationRequired;
    }

    public boolean isCustomOsAutoStartPermissionRequired() {
        return this.customOsAutoStartPermissionRequired;
    }

    public boolean isCustomOsLockScreenPermissionRequired() {
        return this.customOsLockScreenPermissionRequired;
    }

    public boolean isCustomOsPopupPermissionRequired() {
        return this.customOsPopupPermissionRequired;
    }

    public boolean isOverlayPermissionRequired() {
        return this.overlayPermissionRequired;
    }

    public boolean isServiceRunning() {
        return this.serviceRunning.getValue() != null && this.serviceRunning.getValue().booleanValue();
    }

    public boolean isVpnPermissionRequired() {
        return this.vpnPermissionRequired;
    }

    public boolean isWriteSettingsPermissionRequired() {
        return this.writeSettingsPermissionRequired;
    }

    public void loadSelectedBluetoothDevices(Context context) {
        Set<String> stringSet = PreferenceManager.getDefaultSharedPreferences(context).getStringSet("selected_bluetooth_devices", new HashSet());
        if (stringSet == null) {
            this.selectedDeviceAddresses.clear();
            this.selectedDeviceNames.postValue(new ArrayList());
            return;
        }
        this.selectedDeviceAddresses.clear();
        this.selectedDeviceAddresses.addAll(stringSet);
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        ArrayList arrayList = new ArrayList();
        boolean z6 = Build.VERSION.SDK_INT < 31 || ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH_CONNECT") == 0;
        if (defaultAdapter != null && defaultAdapter.isEnabled() && z6) {
            try {
                Set<BluetoothDevice> bondedDevices = defaultAdapter.getBondedDevices();
                HashMap map = new HashMap();
                for (BluetoothDevice bluetoothDevice : bondedDevices) {
                    if (bluetoothDevice.getName() != null && !bluetoothDevice.getName().isEmpty()) {
                        map.put(bluetoothDevice.getAddress(), bluetoothDevice.getName());
                    }
                }
                for (String str : stringSet) {
                    if (map.containsKey(str)) {
                        arrayList.add((String) map.get(str));
                    } else {
                        arrayList.add(str);
                    }
                }
            } catch (SecurityException e) {
                Log.e(TAG, "Security exception accessing Bluetooth devices", e);
                arrayList.addAll(stringSet);
            }
        } else {
            arrayList.addAll(stringSet);
        }
        this.selectedDeviceNames.postValue(arrayList);
    }

    public void saveSelectedBluetoothDevices(Context context, Set<String> set) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putStringSet("selected_bluetooth_devices", set).apply();
        loadSelectedBluetoothDevices(context);
    }

    public void startService(Context context) {
        Intent intent = new Intent(context, (Class<?>) TransporterService.class);
        intent.putExtra(TransporterService.EXTRA_LAUNCH_SOURCE, "manual");
        context.startForegroundService(intent);
        this.serviceRunning.postValue(Boolean.TRUE);
        Intent intent2 = new Intent(ACTION_SERVICE_STATE_CHANGED);
        intent2.setPackage(context.getPackageName());
        context.sendBroadcast(intent2);
    }

    public void stopService(Context context) {
        Intent intent = new Intent(context, (Class<?>) TransporterService.class);
        intent.setAction("fr.sd.taada.exit");
        context.startService(intent);
        context.stopService(new Intent(context, (Class<?>) TransporterService.class));
        this.serviceRunning.postValue(Boolean.FALSE);
        Intent intent2 = new Intent(ACTION_SERVICE_STATE_CHANGED);
        intent2.setPackage(context.getPackageName());
        context.sendBroadcast(intent2);
    }
}
