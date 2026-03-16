package fr.sd.taada;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.preference.PreferenceManager;
import fr.sd.taada.analytics.telemetry.BluetoothTelemetryHelper;
import fr.sd.taada.billing.SubscriptionGuard;
import fr.sd.taada.helpers.LogManager;
import fr.sd.taada.services.SubscriptionCheckService;
import fr.sd.taada.viewmodels.HomeViewModel;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class WifiReceiver extends BroadcastReceiver {
    private static final String BLUETOOTH_TRIGGER_PREFIX = "Bluetooth-";
    private static final String TAG = "HU-WifiReceiver";

    private void handleBluetoothConnected(Context context, BluetoothDevice bluetoothDevice, Intent intent) {
        LogManager.getInstance(context).logDebug(TAG, "Bluetooth connected - Delegating to SubscriptionCheckService: " + bluetoothDevice.getAddress());
        Intent intent2 = new Intent(context, (Class<?>) SubscriptionCheckService.class);
        intent2.putExtra(SubscriptionCheckService.EXTRA_TRIGGER_SOURCE, BLUETOOTH_TRIGGER_PREFIX + bluetoothDevice.getAddress());
        intent2.putExtra(SubscriptionCheckService.EXTRA_DEVICE_ADDRESS, bluetoothDevice.getAddress());
        intent2.putExtra(TransporterService.EXTRA_LAUNCH_SOURCE, "bluetooth");
        try {
            context.startForegroundService(intent2);
            LogManager.getInstance(context).logDebug(TAG, "✅ SubscriptionCheckService started for: " + bluetoothDevice.getAddress());
            BluetoothTelemetryHelper.logAutoStartSuccess(bluetoothDevice.getAddress());
        } catch (Exception e) {
            LogManager.getInstance(context).logError(TAG, "❌ Failed to start SubscriptionCheckService", e);
            LogManager.getInstance(context).logWarning(TAG, "Fallback to direct subscription check");
            BluetoothTelemetryHelper.logAutoStartFailed(context, e, bluetoothDevice.getAddress());
            if (!SubscriptionGuard.canAutoStartServices(context, BLUETOOTH_TRIGGER_PREFIX + bluetoothDevice.getAddress())) {
                LogManager.getInstance(context).logWarning(TAG, "❌ Service start blocked - No active subscription");
                BluetoothTelemetryHelper.logAutoStartBlocked(context, "subscription_required", "No active subscription for auto-start");
                SubscriptionGuard.showSubscriptionRequiredDialog(context, BLUETOOTH_TRIGGER_PREFIX + bluetoothDevice.getAddress());
                return;
            }
            intent.putExtra(TransporterService.EXTRA_LAUNCH_SOURCE, "bluetooth");
            context.startForegroundService(intent);
        }
        sendStateChangeBroadcast(context);
    }

    private void handleBluetoothDisconnected(Context context) {
        LogManager.getInstance(context).logDebug(TAG, "Bluetooth disconnected - Setting service inactive");
        BluetoothTelemetryHelper.logBluetoothDisconnect();
        TransporterService.isServiceActive = false;
        sendStateChangeBroadcast(context);
    }

    private void handleExitAction(Context context, Intent intent) {
        LogManager.getInstance(context).logDebug(TAG, "Exit action received - Starting service shutdown sequence");
        context.stopService(intent);
        sendStateChangeBroadcast(context);
        LogManager.getInstance(context).logDebug(TAG, "Exit sequence completed and state change broadcast sent");
    }

    private boolean hasBluetoothPermission(Context context) {
        return Build.VERSION.SDK_INT < 31 || context.checkSelfPermission("android.permission.BLUETOOTH_CONNECT") == 0;
    }

    private boolean isBluetoothEvent(String str) {
        if (str != null) {
            return "android.bluetooth.device.action.ACL_CONNECTED".equals(str) || "android.bluetooth.device.action.ACL_DISCONNECTED".equals(str);
        }
        return false;
    }

    private boolean isDeviceSelected(BluetoothDevice bluetoothDevice, Set<String> set) {
        return (bluetoothDevice == null || set == null || !set.contains(bluetoothDevice.getAddress())) ? false : true;
    }

    private void sendStateChangeBroadcast(Context context) {
        Intent intent = new Intent(HomeViewModel.ACTION_SERVICE_STATE_CHANGED);
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        LogManager.getInstance(context).logDebug(TAG, "Receiver fired with action: " + intent.getAction());
        Intent intent2 = new Intent(context, (Class<?>) TransporterService.class);
        if ("fr.sd.taada.exit".equalsIgnoreCase(intent.getAction())) {
            handleExitAction(context, intent2);
            return;
        }
        if (isBluetoothEvent(intent.getAction())) {
            BluetoothTelemetryHelper.logReceiverTriggered(context, intent.getAction());
            if (!hasBluetoothPermission(context)) {
                LogManager.getInstance(context).logDebug(TAG, "Missing BLUETOOTH_CONNECT permission, can't process Bluetooth events");
                BluetoothTelemetryHelper.logAutoStartBlocked(context, "permission_denied", "BLUETOOTH_CONNECT permission not granted");
                return;
            }
            Set<String> stringSet = PreferenceManager.getDefaultSharedPreferences(context).getStringSet("selected_bluetooth_devices", null);
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (!isDeviceSelected(bluetoothDevice, stringSet)) {
                LogManager.getInstance(context).logDebug(TAG, "Bluetooth device not matched or null");
                BluetoothTelemetryHelper.logAutoStartBlocked(context, "device_not_selected", bluetoothDevice != null ? "Device not in selected list" : "Device is null");
                return;
            }
            String action = intent.getAction();
            if ("android.bluetooth.device.action.ACL_CONNECTED".equals(action)) {
                handleBluetoothConnected(context, bluetoothDevice, intent2);
            } else if ("android.bluetooth.device.action.ACL_DISCONNECTED".equals(action)) {
                handleBluetoothDisconnected(context);
            }
        }
    }
}
