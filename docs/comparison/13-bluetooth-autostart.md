# 13 — Bluetooth Auto-Start

## Problem

TaaDa auto-starts its service when a configured Bluetooth device connects. Our app has a `TeslaBluetoothReceiver` but it's basic.

## TaaDa Approach

1. User selects BT devices in settings (MAC addresses stored in `selected_bluetooth_devices` StringSet)
2. `WifiReceiver` receives `ACL_CONNECTED` broadcast
3. Checks if device MAC is in selected set
4. Starts `SubscriptionCheckService` → verifies subscription → starts `TransporterService`
5. On `ACL_DISCONNECTED`: sets `isServiceActive = false`
6. Logs telemetry for each auto-start attempt

## Our Current State

`TeslaBluetoothReceiver`:
- Listens for `ACL_CONNECTED` / `ACL_DISCONNECTED`
- On connect: checks if device name contains "Tesla", navigates to `tesla_prompt` screen
- On disconnect: stops TransporterService
- No device selection UI
- No MAC address filtering

## Changes Required

### Step 1: Add BT device selection to settings
```kotlin
// In SettingsScreen:
// "Auto-start Devices" section
// Show list of paired BT devices with checkboxes
// Store selected MAC addresses in SharedPreferences
```

### Step 2: Filter by selected devices in receiver
```kotlin
// In TeslaBluetoothReceiver:
val selectedDevices = prefs.getStringSet("selected_bluetooth_devices", emptySet())
val connectedMac = device?.address ?: return
if (connectedMac in selectedDevices) {
    TransporterService.start(context, triggerSource = "bluetooth")
}
```

### Step 3: Auto-start without UI prompt
Skip the `tesla_prompt` screen — just start the service directly:
```kotlin
// Don't navigate to activity, start service in background
val intent = Intent(context, TransporterService::class.java)
ContextCompat.startForegroundService(context, intent)
```

### Step 4: Handle disconnect gracefully
```kotlin
// On ACL_DISCONNECTED:
if (connectedMac in selectedDevices) {
    TransporterService.stop(context)
}
```

### Step 5: Add security to receiver
Currently `exported=true` with no permission guard. Add:
```xml
<receiver android:name=".receiver.TeslaBluetoothReceiver"
    android:exported="true"
    android:permission="android.permission.BLUETOOTH_CONNECT">
```

## Files to Modify
- `app/src/main/java/com/supertesla/aa/receiver/TeslaBluetoothReceiver.kt`
- `app/src/main/java/com/supertesla/aa/ui/settings/SettingsScreen.kt`
- `app/src/main/AndroidManifest.xml` (add permission to receiver)

## Test Plan
- [ ] Selected BT device stored in SharedPreferences
- [ ] Connecting to selected device auto-starts service
- [ ] Connecting to non-selected device does nothing
- [ ] Disconnecting from selected device stops service
- [ ] Service starts as foreground (notification visible)
