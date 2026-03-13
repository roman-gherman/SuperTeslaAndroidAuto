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
import timber.log.Timber

/**
 * Monitors Bluetooth connections for Tesla devices.
 * When a Tesla is detected, shows a notification offering to start streaming.
 *
 * Tesla Bluetooth names typically contain "Tesla" (e.g. "Tesla Model 3").
 */
class TeslaBluetoothReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action != BluetoothDevice.ACTION_ACL_CONNECTED) return

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

        val deviceName = try {
            device.name
        } catch (e: SecurityException) {
            null
        } ?: return

        Timber.d("Bluetooth connected: $deviceName (${device.address})")

        if (isTeslaDevice(deviceName)) {
            Timber.i("Tesla detected via Bluetooth: $deviceName")
            showTeslaNotification(context, deviceName)
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
    }
}
