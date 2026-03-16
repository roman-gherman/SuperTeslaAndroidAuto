package com.supertesla.aa.receiver

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.NotificationCompat
import com.supertesla.aa.MainActivity
import com.supertesla.aa.service.MainService
import com.supertesla.aa.service.TransporterService
import timber.log.Timber

/**
 * Monitors Bluetooth connections for Tesla devices.
 *
 * Behavior depends on user configuration:
 * - If the device is in the "selected_bluetooth_devices" set → auto-start TransporterService
 * - If the device name contains "Tesla" → show notification offering to start
 */
class TeslaBluetoothReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action) {
            BluetoothDevice.ACTION_ACL_CONNECTED -> handleConnect(context, intent)
            BluetoothDevice.ACTION_ACL_DISCONNECTED -> handleDisconnect(context, intent)
        }
    }

    private fun handleConnect(context: Context, intent: Intent) {
        // Check BLUETOOTH_CONNECT permission on Android 12+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
            context.checkSelfPermission(android.Manifest.permission.BLUETOOTH_CONNECT)
            != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }

        val device = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE, BluetoothDevice::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)
        } ?: return

        val deviceName = try { device.name } catch (_: SecurityException) { null }
        val deviceAddress = device.address

        Timber.d("Bluetooth connected: $deviceName ($deviceAddress)")

        // Check if device is in user's selected auto-start list
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val selectedDevices = prefs.getStringSet(KEY_SELECTED_DEVICES, emptySet()) ?: emptySet()

        if (deviceAddress in selectedDevices) {
            // Auto-start TransporterService
            Timber.i("Auto-starting TransporterService for selected device: $deviceName ($deviceAddress)")
            TransporterService.start(context, "bluetooth-$deviceAddress")
            return
        }

        // Fallback: show notification for Tesla-named devices
        if (deviceName != null && isTeslaDevice(deviceName)) {
            Timber.i("Tesla detected via Bluetooth: $deviceName")
            showTeslaNotification(context, deviceName)
        }
    }

    private fun handleDisconnect(context: Context, intent: Intent) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
            context.checkSelfPermission(android.Manifest.permission.BLUETOOTH_CONNECT)
            != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }

        val device = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE, BluetoothDevice::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)
        } ?: return

        val deviceAddress = device.address
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val selectedDevices = prefs.getStringSet(KEY_SELECTED_DEVICES, emptySet()) ?: emptySet()

        if (deviceAddress in selectedDevices && TransporterService.isActive) {
            Timber.i("Selected BT device disconnected ($deviceAddress) — stopping TransporterService")
            TransporterService.stop(context)
        }
    }

    private fun isTeslaDevice(name: String): Boolean {
        val lower = name.lowercase()
        return lower.contains("tesla")
    }

    private fun showTeslaNotification(context: Context, deviceName: String) {
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Create channel
        val channel = NotificationChannel(
            CHANNEL_ID,
            "Tesla Detection",
            NotificationManager.IMPORTANCE_HIGH
        ).apply {
            description = "Notifies when Tesla is connected via Bluetooth"
        }
        manager.createNotificationChannel(channel)

        // Intent to open the app with auto-start flag
        val openIntent = PendingIntent.getActivity(
            context, 0,
            Intent(context, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                putExtra(EXTRA_TESLA_DETECTED, true)
            },
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        // "Start" action: open app with auto-start (will prompt for hotspot if needed)
        val startIntent = PendingIntent.getActivity(
            context, 2,
            Intent(context, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                putExtra(EXTRA_TESLA_DETECTED, true)
                putExtra(EXTRA_AUTO_START, true)
            },
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(android.R.drawable.ic_media_play)
            .setContentTitle("Tesla connected")
            .setContentText("$deviceName detected. Start Android Auto?")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .setContentIntent(openIntent)
            .addAction(
                android.R.drawable.ic_media_play,
                "Start",
                startIntent
            )
            .build()

        manager.notify(NOTIFICATION_ID, notification)
    }

    companion object {
        const val CHANNEL_ID = "tesla_detection"
        const val NOTIFICATION_ID = 2001
        const val EXTRA_TESLA_DETECTED = "tesla_detected"
        const val EXTRA_AUTO_START = "auto_start"
        const val PREFS_NAME = "supertesla_prefs"
        const val KEY_SELECTED_DEVICES = "selected_bluetooth_devices"
    }
}
