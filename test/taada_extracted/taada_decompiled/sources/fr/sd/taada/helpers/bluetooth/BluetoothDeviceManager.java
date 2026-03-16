package fr.sd.taada.helpers.bluetooth;

import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import f0.C0440b;
import fr.sd.taada.R;
import fr.sd.taada.helpers.LogManager;
import fr.sd.taada.helpers.bluetooth.BluetoothDeviceManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class BluetoothDeviceManager {
    private static final int BLUETOOTH_CONNECT_REQUEST_CODE = 1001;
    private static final String TAG = "BluetoothDeviceManager";
    private final Activity activity;
    private final BluetoothDeviceCallback callback;
    private final LogManager logManager;

    public interface BluetoothDeviceCallback {
        List<String> getSelectedDeviceAddresses();

        void onDevicesSelected(Set<String> set);
    }

    public BluetoothDeviceManager(@NonNull Activity activity, @NonNull LogManager logManager, @NonNull BluetoothDeviceCallback bluetoothDeviceCallback) {
        this.activity = activity;
        this.logManager = logManager;
        this.callback = bluetoothDeviceCallback;
    }

    private boolean[] createCheckedItemsArray(List<BluetoothDevice> list) {
        List<String> selectedDeviceAddresses = this.callback.getSelectedDeviceAddresses();
        boolean[] zArr = new boolean[list.size()];
        for (int i = 0; i < list.size(); i++) {
            zArr[i] = selectedDeviceAddresses.contains(list.get(i).getAddress());
        }
        return zArr;
    }

    private String[] createDeviceNamesArray(List<BluetoothDevice> list) {
        String[] strArr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            try {
                BluetoothDevice bluetoothDevice = list.get(i);
                strArr[i] = (bluetoothDevice.getName() == null || bluetoothDevice.getName().isEmpty()) ? this.activity.getString(R.string.select_device) : bluetoothDevice.getName();
            } catch (SecurityException e) {
                this.logManager.logError(TAG, "Security exception when getting device name", e);
                strArr[i] = this.activity.getString(R.string.select_device);
            }
        }
        return strArr;
    }

    private boolean hasPairedDevices() {
        try {
            if (BluetoothAdapter.getDefaultAdapter().getBondedDevices().size() != 0) {
                return true;
            }
            Toast.makeText(this.activity, R.string.no_paired_devices, 0).show();
            return false;
        } catch (SecurityException e) {
            this.logManager.logError(TAG, "Security exception when checking paired devices", e);
            Toast.makeText(this.activity, "Permission denied to access Bluetooth devices", 0).show();
            return false;
        }
    }

    private boolean isBluetoothAdapterAvailable() {
        if (BluetoothAdapter.getDefaultAdapter() != null) {
            return true;
        }
        Toast.makeText(this.activity, R.string.nobt, 0).show();
        return false;
    }

    private boolean isBluetoothEnabled() {
        if (BluetoothAdapter.getDefaultAdapter().isEnabled()) {
            return true;
        }
        if (shouldRequestBluetoothConnectPermission()) {
            requestBluetoothConnectPermission();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showDeviceSelectionDialog$0(boolean[] zArr, DialogInterface dialogInterface, int i, boolean z6) {
        zArr[i] = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDeviceSelectionDialog$1(List list, boolean[] zArr, DialogInterface dialogInterface, int i) {
        saveSelectedDevices(list, zArr);
    }

    private void requestBluetoothConnectPermission() {
        ActivityCompat.requestPermissions(this.activity, new String[]{"android.permission.BLUETOOTH_CONNECT"}, 1001);
    }

    private void requestBluetoothEnable() {
        try {
            this.activity.startActivity(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"));
        } catch (SecurityException e) {
            this.logManager.logError(TAG, "Security exception when requesting Bluetooth enable", e);
            Toast.makeText(this.activity, "Permission denied to enable Bluetooth", 0).show();
        }
    }

    private void saveSelectedDevices(List<BluetoothDevice> list, boolean[] zArr) {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < list.size(); i++) {
            if (zArr[i]) {
                hashSet.add(list.get(i).getAddress());
            }
        }
        this.callback.onDevicesSelected(hashSet);
    }

    private boolean shouldRequestBluetoothConnectPermission() {
        return Build.VERSION.SDK_INT >= 31 && ContextCompat.checkSelfPermission(this.activity, "android.permission.BLUETOOTH_CONNECT") != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [b1.b] */
    /* JADX WARN: Type inference failed for: r4v2, types: [b1.a] */
    private void showDeviceSelectionDialog() {
        try {
            final ArrayList arrayList = new ArrayList(BluetoothAdapter.getDefaultAdapter().getBondedDevices());
            String[] strArrCreateDeviceNamesArray = createDeviceNamesArray(arrayList);
            final boolean[] zArrCreateCheckedItemsArray = createCheckedItemsArray(arrayList);
            new C0440b(this.activity).i(R.string.bluetooth_devices).d(strArrCreateDeviceNamesArray, zArrCreateCheckedItemsArray, new DialogInterface.OnMultiChoiceClickListener() { // from class: b1.a
                @Override // android.content.DialogInterface.OnMultiChoiceClickListener
                public final void onClick(DialogInterface dialogInterface, int i, boolean z6) {
                    BluetoothDeviceManager.lambda$showDeviceSelectionDialog$0(zArrCreateCheckedItemsArray, dialogInterface, i, z6);
                }
            }).h(new DialogInterface.OnClickListener() { // from class: b1.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f1696a.lambda$showDeviceSelectionDialog$1(arrayList, zArrCreateCheckedItemsArray, dialogInterface, i);
                }
            }).e(R.string.cancel, null).show();
        } catch (SecurityException e) {
            this.logManager.logError(TAG, "Security exception when showing device selection dialog", e);
            Toast.makeText(this.activity, "Permission denied to access Bluetooth devices", 0).show();
        }
    }

    public void showBluetoothDeviceSelection() {
        if (isBluetoothAdapterAvailable()) {
            if (!isBluetoothEnabled()) {
                requestBluetoothEnable();
            } else if (hasPairedDevices()) {
                showDeviceSelectionDialog();
            }
        }
    }

    public void showBluetoothInfoDialog() {
        new AlertDialog.Builder(this.activity, R.style.AppDialogTheme).setTitle(R.string.bluetooth_info).setMessage(R.string.bluetooth_info_message).setPositiveButton(R.string.understood, (DialogInterface.OnClickListener) null).setIcon(R.drawable.ic_bluetooth_24).show();
    }
}
