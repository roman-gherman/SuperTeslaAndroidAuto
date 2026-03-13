package com.supertesla.aa.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.BatteryManager
import android.os.PowerManager
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import timber.log.Timber

/**
 * Manages wake locks, WiFi locks, and battery monitoring
 * to keep streaming stable during screen-off and low-battery scenarios.
 */
class BatteryOptimizer(private val context: Context) {

    private var wakeLock: PowerManager.WakeLock? = null
    private var wifiLock: WifiManager.WifiLock? = null

    data class BatteryState(
        val level: Int,        // 0-100
        val isCharging: Boolean,
        val isUsbCharging: Boolean,
        val isLow: Boolean     // <20%
    )

    fun acquireLocks() {
        val pm = context.getSystemService(Context.POWER_SERVICE) as PowerManager
        wakeLock = pm.newWakeLock(
            PowerManager.PARTIAL_WAKE_LOCK,
            "SuperTeslaAA::Streaming"
        ).apply {
            acquire(4 * 60 * 60 * 1000L) // 4 hours max
        }
        Timber.i("Wake lock acquired")

        val wm = context.getSystemService(Context.WIFI_SERVICE) as WifiManager
        @Suppress("DEPRECATION")
        wifiLock = wm.createWifiLock(
            WifiManager.WIFI_MODE_FULL_HIGH_PERF,
            "SuperTeslaAA::Hotspot"
        ).apply { acquire() }
        Timber.i("WiFi lock acquired")
    }

    fun releaseLocks() {
        try {
            if (wakeLock?.isHeld == true) wakeLock?.release()
        } catch (_: Exception) {}
        wakeLock = null

        try {
            if (wifiLock?.isHeld == true) wifiLock?.release()
        } catch (_: Exception) {}
        wifiLock = null

        Timber.i("Locks released")
    }

    /**
     * Observe battery state changes.
     */
    fun observeBatteryState(): Flow<BatteryState> = callbackFlow {
        val receiver = object : BroadcastReceiver() {
            override fun onReceive(ctx: Context, intent: Intent) {
                val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
                val scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 100)
                val pct = if (scale > 0) (level * 100) / scale else 0
                val plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0)
                val isCharging = plugged != 0
                val isUsb = plugged == BatteryManager.BATTERY_PLUGGED_USB

                trySend(BatteryState(
                    level = pct,
                    isCharging = isCharging,
                    isUsbCharging = isUsb,
                    isLow = pct < 20
                ))
            }
        }

        context.registerReceiver(receiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
        awaitClose { context.unregisterReceiver(receiver) }
    }

    /**
     * Get current battery level synchronously.
     */
    fun getCurrentBatteryLevel(): Int {
        val bm = context.getSystemService(Context.BATTERY_SERVICE) as BatteryManager
        return bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
    }

    fun isCharging(): Boolean {
        val bm = context.getSystemService(Context.BATTERY_SERVICE) as BatteryManager
        return bm.isCharging
    }
}
