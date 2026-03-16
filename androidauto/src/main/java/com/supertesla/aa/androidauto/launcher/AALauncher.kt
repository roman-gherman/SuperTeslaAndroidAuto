package com.supertesla.aa.androidauto.launcher

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import timber.log.Timber
import java.net.Socket

/**
 * Launches Android Auto projection.
 *
 * Tries multiple approaches in order:
 * 1. WirelessStartupReceiver broadcast (AA v16+)
 * 2. WirelessStartupActivity intent (older AA versions, how TaaDa does it)
 * 3. DeveloperHeadUnitNetworkService (requires AA dev mode)
 */
object AALauncher {

    private const val AA_PACKAGE = "com.google.android.projection.gearhead"

    // Newer AA versions (v16+) use a BroadcastReceiver
    private const val WIRELESS_RECEIVER = "com.google.android.apps.auto.wireless.setup.receiver.WirelessStartupReceiver"
    private const val WIRELESS_RECEIVER_ACTION = "com.google.android.apps.auto.wireless.setup.receiver.wirelessstartup.START"

    // Older AA versions use an Activity
    private const val WIRELESS_ACTIVITY = "com.google.android.apps.auto.wireless.setup.service.impl.WirelessStartupActivity"

    private const val DEV_HU_SERVICE = "$AA_PACKAGE.companion.DeveloperHeadUnitNetworkService"

    const val AA_WIRELESS_PORT = 5288
    const val AA_DEV_PORT = 5277

    fun isHeadUnitServerRunning(port: Int = AA_DEV_PORT): Boolean {
        return try {
            val socket = Socket("127.0.0.1", port)
            socket.close()
            true
        } catch (e: Exception) {
            false
        }
    }

    fun isAndroidAutoInstalled(context: Context): Boolean {
        return try {
            context.packageManager.getPackageInfo(AA_PACKAGE, 0)
            true
        } catch (e: Exception) {
            false
        }
    }

    /**
     * Launch Android Auto wireless projection.
     * Tries broadcast first (AA v16+), then activity (older AA).
     */
    fun launchWirelessProjection(
        context: Context,
        serverIp: String = "127.0.0.1",
        serverPort: Int = AA_WIRELESS_PORT
    ): Boolean {
        // Method 1: Start WirelessStartupActivity (works on most AA versions)
        if (launchViaActivity(context, serverIp, serverPort)) return true

        // Method 2: Broadcast to WirelessStartupReceiver (AA v16+)
        if (launchViaBroadcast(context, serverIp, serverPort)) return true

        Timber.w("All wireless projection methods failed")
        return false
    }

    private fun launchViaBroadcast(context: Context, serverIp: String, serverPort: Int): Boolean {
        return try {
            val intent = Intent(WIRELESS_RECEIVER_ACTION).apply {
                component = ComponentName(AA_PACKAGE, WIRELESS_RECEIVER)
                putExtra("PARAM_HOST_ADDRESS", serverIp)
                putExtra("PARAM_SERVICE_PORT", serverPort)
            }
            context.sendBroadcast(intent)
            Timber.i("Sent WirelessStartupReceiver broadcast -> $serverIp:$serverPort")
            true
        } catch (e: Exception) {
            Timber.w(e, "WirelessStartupReceiver broadcast failed")
            false
        }
    }

    private fun launchViaActivity(context: Context, serverIp: String, serverPort: Int): Boolean {
        return try {
            // Get active network (TaaDa passes this to AA)
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = cm.activeNetwork

            // Get WifiInfo from WifiManager (AA needs this to validate the connection)
            val wm = context.applicationContext.getSystemService(Context.WIFI_SERVICE) as? WifiManager
            @Suppress("DEPRECATION")
            val wifiInfo: android.os.Parcelable? = wm?.connectionInfo
            Timber.d("WifiInfo: $wifiInfo, activeNetwork: $activeNetwork")

            val intent = Intent().apply {
                component = ComponentName(AA_PACKAGE, WIRELESS_ACTIVITY)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                putExtra("PARAM_HOST_ADDRESS", serverIp)
                putExtra("PARAM_SERVICE_PORT", serverPort)
                if (wifiInfo != null) putExtra("wifi_info", wifiInfo)
                if (activeNetwork != null) putExtra("PARAM_SERVICE_WIFI_NETWORK", activeNetwork)
            }
            context.startActivity(intent)
            Timber.i("Launched WirelessStartupActivity -> $serverIp:$serverPort (network=$activeNetwork, wifiInfo=$wifiInfo)")
            true
        } catch (e: Exception) {
            Timber.d("WirelessStartupActivity failed: ${e.message}")
            false
        }
    }

    fun tryStartDevHeadUnitServer(context: Context): Boolean {
        return try {
            val intent = Intent().apply {
                component = ComponentName(AA_PACKAGE, DEV_HU_SERVICE)
            }
            context.startService(intent)
            Timber.i("Started DeveloperHeadUnitNetworkService")
            true
        } catch (e: Exception) {
            Timber.d("DeveloperHeadUnitNetworkService not available: ${e.message}")
            false
        }
    }

    fun ensureAndroidAutoRunning(context: Context): Boolean {
        if (!isAndroidAutoInstalled(context)) {
            Timber.w("Android Auto is not installed")
            return false
        }

        if (isHeadUnitServerRunning(AA_DEV_PORT)) {
            Timber.i("AA head unit server already running on port $AA_DEV_PORT")
            return true
        }

        if (launchWirelessProjection(context)) return true
        if (tryStartDevHeadUnitServer(context)) return true

        Timber.w("Could not start Android Auto automatically")
        return false
    }
}
