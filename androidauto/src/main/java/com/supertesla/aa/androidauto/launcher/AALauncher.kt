package com.supertesla.aa.androidauto.launcher

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Network
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
        // Method 1: Broadcast to WirelessStartupReceiver (AA v16+)
        // Broadcast doesn't require a Network object — simpler and works on newer AA
        if (launchViaBroadcast(context, serverIp, serverPort)) return true

        // Method 2: Start WirelessStartupActivity (older AA, needs Network)
        if (launchViaActivity(context, serverIp, serverPort)) return true

        Timber.w("All wireless projection methods failed")
        return false
    }

    private fun launchViaBroadcast(context: Context, serverIp: String, serverPort: Int): Boolean {
        return try {
            val intent = Intent(WIRELESS_RECEIVER_ACTION).apply {
                component = ComponentName(AA_PACKAGE, WIRELESS_RECEIVER)
                putExtra("ip_address", serverIp)
                putExtra("projection_port", serverPort)
                // Also try TaaDa's param names
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

    /**
     * Create a mock Network with ID 99999 (TaaDa's trick).
     * AA uses this Network to bind its socket. With a fake Network,
     * AA falls back to default routing — which the VPN directs to localhost.
     *
     * Tries multiple approaches for different Android versions:
     * 1. Network(int) constructor (Android < 14)
     * 2. Network.fromNetworkHandle(long) static method (Android 6+)
     */
    private fun createMockNetwork(): Network? {
        // Method 1: Direct constructor Network(int netId) — works on older Android
        try {
            val constructor = Network::class.java.getDeclaredConstructor(Int::class.javaPrimitiveType)
            constructor.isAccessible = true
            return constructor.newInstance(99999) as Network
        } catch (_: Exception) {}

        // Method 2: fromNetworkHandle — converts a long handle to a Network
        // The handle encoding is: (netId.toLong() shl 32) | 0xFCAFE (magic)
        // But simpler: netId * 1L works on some versions
        try {
            val method = Network::class.java.getDeclaredMethod("fromNetworkHandle", Long::class.javaPrimitiveType)
            // Network handle = netId << 32 on most Android versions
            val handle = 99999L shl 32
            return method.invoke(null, handle) as Network
        } catch (_: Exception) {}

        Timber.w("Could not create mock Network — AA will use real network (may fail to connect)")
        return null
    }

    private fun launchViaActivity(context: Context, serverIp: String, serverPort: Int): Boolean {
        return try {
            // Create mock Network(99999) — TaaDa's key trick.
            // With a fake network, AA can't bind to a real interface,
            // so it falls back to default routing → localhost via VPN.
            val mockNetwork = createMockNetwork()
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val network = mockNetwork ?: cm.activeNetwork

            // Get WifiInfo from WifiManager (AA needs this to validate the connection)
            val wm = context.applicationContext.getSystemService(Context.WIFI_SERVICE) as? WifiManager
            @Suppress("DEPRECATION")
            val wifiInfo: android.os.Parcelable? = wm?.connectionInfo
            Timber.d("WifiInfo: $wifiInfo, network: $network (mock=${mockNetwork != null})")

            val intent = Intent().apply {
                component = ComponentName(AA_PACKAGE, WIRELESS_ACTIVITY)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                putExtra("PARAM_HOST_ADDRESS", serverIp)
                putExtra("PARAM_SERVICE_PORT", serverPort)
                if (wifiInfo != null) putExtra("wifi_info", wifiInfo)
                if (network != null) putExtra("PARAM_SERVICE_WIFI_NETWORK", network)
            }
            context.startActivity(intent)
            Timber.i("Launched WirelessStartupActivity -> $serverIp:$serverPort (network=$network, mock=${mockNetwork != null})")
            true
        } catch (e: SecurityException) {
            // AA v16.4+ may not export the Activity — fall back to broadcast
            Timber.d("WirelessStartupActivity not exported: ${e.message}")
            false
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
