package com.supertesla.aa.androidauto.launcher

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import timber.log.Timber
import java.net.Socket

/**
 * Launches Android Auto projection automatically without requiring
 * developer mode or root access.
 *
 * Uses two approaches:
 * 1. WirelessStartupActivity intent (how Taada/TeslAA do it) - tells AA
 *    "there's a wireless head unit at this IP:port, connect to it"
 * 2. Fallback: try starting DeveloperHeadUnitNetworkService directly
 *
 * The WirelessStartupActivity approach bypasses developer mode entirely
 * because it uses the wireless projection path (same as real wireless AA dongles).
 */
object AALauncher {

    private const val AA_PACKAGE = "com.google.android.projection.gearhead"
    private const val WIRELESS_ACTIVITY = "com.google.android.apps.auto.wireless.setup.service.impl.WirelessStartupActivity"
    private const val DEV_HU_SERVICE = "$AA_PACKAGE.companion.DeveloperHeadUnitNetworkService"
    private const val AA_SPLASH = "$AA_PACKAGE.companion.SplashScreenActivity"

    const val AA_WIRELESS_PORT = 5288
    const val AA_DEV_PORT = 5277

    /**
     * Check if AA head unit server is already running by trying to connect.
     */
    fun isHeadUnitServerRunning(port: Int = AA_DEV_PORT): Boolean {
        return try {
            val socket = Socket("127.0.0.1", port)
            socket.close()
            true
        } catch (e: Exception) {
            false
        }
    }

    /**
     * Check if Android Auto app is installed.
     */
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
     * This tells AA to connect to our AAP server as a wireless head unit.
     * No developer mode required.
     *
     * @param context Application context
     * @param serverIp IP address where our AAP server listens (usually 127.0.0.1)
     * @param serverPort Port for the wireless AAP server (default 5288)
     * @return true if the intent was sent successfully
     */
    fun launchWirelessProjection(
        context: Context,
        serverIp: String = "127.0.0.1",
        serverPort: Int = AA_WIRELESS_PORT
    ): Boolean {
        return try {
            val intent = Intent().apply {
                component = ComponentName(AA_PACKAGE, WIRELESS_ACTIVITY)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                putExtra("PARAM_HOST_ADDRESS", serverIp)
                putExtra("PARAM_SERVICE_PORT", serverPort)
            }
            context.startActivity(intent)
            Timber.i("Launched AA WirelessStartupActivity -> $serverIp:$serverPort")
            true
        } catch (e: Exception) {
            Timber.w(e, "WirelessStartupActivity launch failed, trying fallback")
            false
        }
    }

    /**
     * Fallback: try to start the developer head unit network service.
     * This only works if the user has enabled developer mode in AA settings.
     */
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

    /**
     * Try all methods to get AA running, in order of preference.
     * Returns true if any method succeeded.
     */
    fun ensureAndroidAutoRunning(context: Context): Boolean {
        if (!isAndroidAutoInstalled(context)) {
            Timber.w("Android Auto is not installed")
            return false
        }

        // Check if already running
        if (isHeadUnitServerRunning(AA_DEV_PORT)) {
            Timber.i("AA head unit server already running on port $AA_DEV_PORT")
            return true
        }

        // Method 1: Launch wireless projection (no dev mode needed)
        if (launchWirelessProjection(context)) {
            Timber.i("Wireless projection launch attempted")
            return true
        }

        // Method 2: Try dev head unit service (needs dev mode)
        if (tryStartDevHeadUnitServer(context)) {
            return true
        }

        Timber.w("Could not start Android Auto automatically")
        return false
    }
}
