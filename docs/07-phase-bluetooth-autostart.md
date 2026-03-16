# Phase 7: Bluetooth Auto-Start & Service Lifecycle

## Overview

TaaDa automatically starts the streaming service when a selected Bluetooth device (Tesla) connects, and stops it when the device disconnects. This provides a seamless experience — the user just gets in the car and everything starts.

## What TaaDa Does (Exact Implementation)

### 1. WifiReceiver (BroadcastReceiver)

Registered in AndroidManifest.xml as an exported receiver:

```xml
<receiver android:name="fr.sd.taada.WifiReceiver" android:exported="true">
    <intent-filter>
        <action android:name="android.bluetooth.device.action.ACL_CONNECTED"/>
        <action android:name="android.bluetooth.device.action.ACL_DISCONNECTED"/>
        <action android:name="fr.sd.taada.exit"/>
    </intent-filter>
</receiver>
```

### 2. Bluetooth Connection Handler

```java
// WifiReceiver.onReceive()
@Override
public void onReceive(Context context, Intent intent) {
    String action = intent.getAction();

    if ("android.bluetooth.device.action.ACL_CONNECTED".equals(action)) {
        handleBluetoothConnect(context, intent);
    }
    else if ("android.bluetooth.device.action.ACL_DISCONNECTED".equals(action)) {
        handleBluetoothDisconnect(context, intent);
    }
    else if ("fr.sd.taada.exit".equals(action)) {
        handleExit(context);
    }
}

void handleBluetoothConnect(Context context, Intent intent) {
    // Check BLUETOOTH_CONNECT permission (API 31+)
    if (Build.VERSION.SDK_INT >= 31) {
        if (checkSelfPermission(BLUETOOTH_CONNECT) != GRANTED) return;
    }

    // Get connected device
    BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
    if (device == null) return;

    // Check if device is in user's selected list
    SharedPreferences prefs = context.getSharedPreferences("taada_prefs", MODE_PRIVATE);
    Set<String> selectedDevices = prefs.getStringSet("selected_bluetooth_devices", emptySet());

    String deviceAddress = device.getAddress();
    if (!selectedDevices.contains(deviceAddress)) return;

    // Start the service chain: Subscription check → TransporterService
    Intent serviceIntent = new Intent(context, SubscriptionCheckService.class);
    serviceIntent.putExtra("EXTRA_TRIGGER_SOURCE", "Bluetooth-" + deviceAddress);
    serviceIntent.putExtra("EXTRA_DEVICE_ADDRESS", deviceAddress);
    serviceIntent.putExtra("EXTRA_LAUNCH_SOURCE", "bluetooth");
    context.startForegroundService(serviceIntent);
}

void handleBluetoothDisconnect(Context context, Intent intent) {
    TransporterService.isServiceActive = false;

    // Broadcast state change
    Intent stateIntent = new Intent("fr.sd.taada.ACTION_SERVICE_STATE_CHANGED");
    context.sendBroadcast(stateIntent);
}

void handleExit(Context context) {
    Intent stopIntent = new Intent(context, TransporterService.class);
    context.stopService(stopIntent);

    Intent stateIntent = new Intent("fr.sd.taada.ACTION_SERVICE_STATE_CHANGED");
    context.sendBroadcast(stateIntent);
}
```

### 3. Service Startup Chain

```
Bluetooth ACL_CONNECTED
  → WifiReceiver.handleBluetoothConnect()
    → SubscriptionCheckService (validates subscription)
      → TransporterService.onStartCommand()
        → Start WebSocket servers
        → Start VPN
        → Start ConnectionWaitRunnable (port 5288)
        → Launch Android Auto WirelessStartupActivity
        → Wait for AA to connect
        → Begin streaming
```

### 4. Service State Management

TaaDa uses static flags to track service state:

```java
public class TransporterService extends Service {
    public static boolean isServiceActive = false;
    public static boolean isConnected = false;
    public static boolean isVideoActive = false;

    @Override
    public void onStartCommand(Intent intent, int flags, int startId) {
        // Guard: don't start if already active
        if (isServiceActive && isConnected) {
            return START_STICKY;
        }

        isServiceActive = true;
        // ... startup sequence
    }

    @Override
    public void onDestroy() {
        isServiceActive = false;
        isConnected = false;
        isVideoActive = false;

        // Stop VPN
        VpnServiceManager.stopVpnServices(this);

        // Stop WebSocket servers
        controlServer.stop();
        audioServer.stop();
        voiceServer.stop();

        // Close AA socket
        communicationHandler.disconnect();

        // Release wake locks
        releaseWakeLocks();
    }
}
```

### 5. Foreground Notification

```java
// TransporterService
Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
    .setContentTitle("TaaDa")
    .setContentText("Streaming to Tesla")
    .setSmallIcon(R.drawable.ic_notification)
    .setOngoing(true)
    .addAction(R.drawable.ic_stop, "Stop", stopPendingIntent)
    .build();

startForeground(NOTIFICATION_ID, notification);
```

### 6. Bluetooth Device Selection (HomeActivity)

Users configure which Bluetooth devices trigger auto-start:

```java
// HomeActivity
void showBluetoothDeviceSelector() {
    Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();

    // Show dialog with paired devices
    // User selects Tesla from list
    // Store selected device addresses in SharedPreferences

    prefs.edit()
        .putStringSet("selected_bluetooth_devices", selectedAddresses)
        .apply();
}
```

## What We Already Have

| Component | File | Status |
|-----------|------|--------|
| Bluetooth receiver | `receiver/TeslaBluetoothReceiver.kt` | Exists — needs verification |
| Main service | `service/MainService.kt` | Complete — current screen mirror approach |
| Battery optimizer | `service/BatteryOptimizer.kt` | Complete |
| Reconnection manager | `service/ReconnectionManager.kt` | Complete |

## What Needs to Change

### 1. Update TeslaBluetoothReceiver

```kotlin
class TeslaBluetoothReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action) {
            BluetoothDevice.ACTION_ACL_CONNECTED -> {
                handleConnect(context, intent)
            }
            BluetoothDevice.ACTION_ACL_DISCONNECTED -> {
                handleDisconnect(context, intent)
            }
        }
    }

    private fun handleConnect(context: Context, intent: Intent) {
        // Check BT permission (API 31+)
        if (Build.VERSION.SDK_INT >= 31) {
            if (context.checkSelfPermission(BLUETOOTH_CONNECT) != GRANTED) return
        }

        val device = intent.getParcelableExtra<BluetoothDevice>(
            BluetoothDevice.EXTRA_DEVICE
        ) ?: return

        // Check if device is in selected list
        val prefs = context.getSharedPreferences("supertesla_prefs", MODE_PRIVATE)
        val selectedDevices = prefs.getStringSet("selected_bluetooth_devices", emptySet())

        if (device.address !in selectedDevices.orEmpty()) return

        // Start TransporterService
        val serviceIntent = Intent(context, TransporterService::class.java).apply {
            putExtra("TRIGGER_SOURCE", "bluetooth")
            putExtra("DEVICE_ADDRESS", device.address)
        }
        context.startForegroundService(serviceIntent)
    }

    private fun handleDisconnect(context: Context, intent: Intent) {
        TransporterService.isActive = false
        context.stopService(Intent(context, TransporterService::class.java))
    }
}
```

### 2. Register Receiver in AndroidManifest.xml

```xml
<receiver
    android:name=".receiver.TeslaBluetoothReceiver"
    android:exported="true">
    <intent-filter>
        <action android:name="android.bluetooth.device.action.ACL_CONNECTED"/>
        <action android:name="android.bluetooth.device.action.ACL_DISCONNECTED"/>
        <action android:name="com.supertesla.aa.exit"/>
    </intent-filter>
</receiver>
```

### 3. Add Bluetooth Device Selection UI

In Settings screen, add a Bluetooth device picker:

```kotlin
// SettingsScreen.kt
@Composable
fun BluetoothDeviceSelector() {
    val pairedDevices = remember { bluetoothAdapter.bondedDevices.toList() }
    val selectedDevices = remember { mutableStateListOf<String>() }

    Column {
        Text("Auto-start when connected to:")
        pairedDevices.forEach { device ->
            Row {
                Checkbox(
                    checked = device.address in selectedDevices,
                    onCheckedChange = { checked ->
                        if (checked) selectedDevices.add(device.address)
                        else selectedDevices.remove(device.address)
                        saveSelectedDevices(selectedDevices)
                    }
                )
                Text(device.name ?: device.address)
            }
        }
    }
}
```

### 4. TransporterService Lifecycle

```kotlin
class TransporterService : Service() {
    companion object {
        @Volatile var isActive = false
        @Volatile var isConnected = false
        @Volatile var isVideoActive = false
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (isActive && isConnected) {
            return START_STICKY
        }

        isActive = true
        showForegroundNotification()

        serviceScope.launch {
            try {
                // 1. Start VPN (with AA exclusion)
                startVpn()

                // 2. Start 3 WebSocket servers
                startWebSocketServers()

                // 3. Start HTTPS web server
                startWebServer()

                // 4. Listen on port 5288 for AA
                listenForAndroidAuto()

                // 5. Launch Android Auto
                launchAndroidAuto()

                // 6. Wait for connection + handshake
                waitForConnection()

                // 7. Begin streaming
                isConnected = true
                startHeartbeat()
                startMessageProcessingLoop()

            } catch (e: Exception) {
                Logger.e("TransporterService", "Startup failed", e)
                stopSelf()
            }
        }

        return START_STICKY
    }

    override fun onDestroy() {
        isActive = false
        isConnected = false
        isVideoActive = false

        // Cleanup in reverse order
        stopHeartbeat()
        disconnectAA()
        stopWebSocketServers()
        stopWebServer()
        stopVpn()
        releaseWakeLocks()
    }
}
```

### 5. Wake Lock & WiFi Lock

```kotlin
private fun acquireLocks() {
    val pm = getSystemService(Context.POWER_SERVICE) as PowerManager
    wakeLock = pm.newWakeLock(
        PowerManager.PARTIAL_WAKE_LOCK,
        "SuperTesla::StreamingWakeLock"
    ).apply { acquire() }

    val wm = getSystemService(Context.WIFI_SERVICE) as WifiManager
    wifiLock = wm.createWifiLock(
        WifiManager.WIFI_MODE_FULL_HIGH_PERF,
        "SuperTesla::StreamingWifiLock"
    ).apply { acquire() }
}
```

## Implementation Tasks

1. [ ] Update `TeslaBluetoothReceiver` with device filtering and service launch
2. [ ] Register receiver in AndroidManifest.xml with correct intent filters
3. [ ] Add Bluetooth device selection UI in Settings
4. [ ] Store selected devices in SharedPreferences
5. [ ] Create `TransporterService` with full lifecycle management
6. [ ] Add foreground notification with stop action
7. [ ] Implement wake lock + WiFi lock acquisition
8. [ ] Add service state tracking (isActive, isConnected, isVideoActive)
9. [ ] Add exit broadcast handling
10. [ ] Test: pair Tesla BT → enable hotspot → BT connects → service auto-starts → streaming begins

## Required Permissions

```xml
<uses-permission android:name="android.permission.BLUETOOTH"/>
<uses-permission android:name="android.permission.BLUETOOTH_ADMIN"/>
<uses-permission android:name="android.permission.BLUETOOTH_CONNECT"/>
<uses-permission android:name="android.permission.BLUETOOTH_SCAN"
    android:usesPermissionFlags="neverForLocation"/>
<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED"/>
<uses-permission android:name="android.permission.WAKE_LOCK"/>
<uses-permission android:name="android.permission.FOREGROUND_SERVICE"/>
<uses-permission android:name="android.permission.FOREGROUND_SERVICE_CONNECTED_DEVICE"/>
```

## Complete Service Startup Sequence

```
┌──────────────────┐
│ User gets in car  │
└────────┬─────────┘
         │ Bluetooth ACL_CONNECTED
         ▼
┌──────────────────┐
│ BT Receiver      │ Check: is device in selected list?
└────────┬─────────┘
         │ Yes
         ▼
┌──────────────────┐
│ TransporterService│
│ onStartCommand() │
└────────┬─────────┘
         │
         ├─ 1. Acquire wake/WiFi locks
         ├─ 2. Show foreground notification
         ├─ 3. Start VPN (exclude AA)
         ├─ 4. Start WebSocket servers (3 ports)
         ├─ 5. Start HTTPS web server
         ├─ 6. Listen on port 5288
         ├─ 7. Launch AA WirelessStartupActivity
         │     (AA connects to 127.0.0.1:5288)
         ├─ 8. Handshake: CAR_HELLO → PHONE_HELLO → SSL
         ├─ 9. Service discovery (advertise HU capabilities)
         ├─ 10. Channel open (video, audio, input, sensor)
         ├─ 11. Start heartbeat (2000ms)
         └─ 12. Begin message relay loop
                (Video → ControlSocketServer)
                (Audio → MediaSocketServer)
                (Touch ← ControlSocketServer → AA)
```
