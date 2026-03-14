package com.supertesla.aa.network.hotspot

import android.content.Context
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import com.supertesla.aa.core.config.AppConfig
import com.supertesla.aa.core.model.ConnectedClient
import com.supertesla.aa.core.model.HotspotState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import java.io.BufferedReader
import java.io.FileReader
import java.lang.reflect.Method
import java.net.Inet4Address
import java.net.NetworkInterface

class HotspotManager(private val context: Context) {

    private val wifiManager: WifiManager by lazy {
        context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
    }

    fun observeHotspotState(): Flow<HotspotState> = flow {
        while (true) {
            val state = checkHotspotState()
            emit(state)
            delay(AppConfig.ARP_POLL_INTERVAL_MS)
        }
    }.distinctUntilChanged()

    fun observeConnectedClients(): Flow<List<ConnectedClient>> = flow {
        while (true) {
            val clients = readArpTable()
            emit(clients)
            delay(AppConfig.ARP_POLL_INTERVAL_MS)
        }
    }.distinctUntilChanged()

    private fun checkHotspotState(): HotspotState {
        val hotspotEnabled = isHotspotEnabled()

        if (!hotspotEnabled) {
            return HotspotState.Disabled
        }

        val clients = readArpTable()
        return if (clients.isNotEmpty()) {
            HotspotState.ClientConnected(clients)
        } else {
            HotspotState.Enabled
        }
    }

    /**
     * Check if WiFi hotspot/tethering is active.
     * Uses WifiManager reflection as the primary (most reliable) method.
     * Falls back to interface detection only for dedicated AP interfaces.
     */
    private fun isHotspotEnabled(): Boolean {
        // Method 1: WifiManager.isWifiApEnabled() - most reliable
        if (isWifiApEnabledViaReflection()) return true

        // Method 2: Check for dedicated AP interfaces only (NOT wlan0 which is regular WiFi)
        if (hasTetheringInterface()) return true

        return false
    }

    /**
     * Use reflection to call WifiManager.isWifiApEnabled().
     * This hidden API works on most Android versions.
     */
    private fun isWifiApEnabledViaReflection(): Boolean {
        return try {
            val method: Method = wifiManager.javaClass.getDeclaredMethod("isWifiApEnabled")
            method.isAccessible = true
            method.invoke(wifiManager) as Boolean
        } catch (e: Exception) {
            false
        }
    }

    /**
     * Check for common tethering/AP interface names.
     */
    private fun hasTetheringInterface(): Boolean {
        // Only dedicated AP interfaces - NOT wlan0 (regular WiFi)
        val apNames = setOf("ap0", "wlan1", "swlan0", "ap1", "softap0")
        return try {
            NetworkInterface.getNetworkInterfaces()?.asSequence()?.any { iface ->
                iface.isUp && !iface.isLoopback &&
                    iface.name in apNames &&
                    iface.inetAddresses.asSequence().any { it is Inet4Address && !it.isLoopbackAddress }
            } ?: false
        } catch (e: Exception) {
            false
        }
    }


    /**
     * Parse /proc/net/arp to find connected clients.
     * Looks for clients on any private subnet (not just 192.168.43.*).
     */
    private fun readArpTable(): List<ConnectedClient> {
        return try {
            BufferedReader(FileReader("/proc/net/arp")).use { reader ->
                reader.readLines()
                    .drop(1)
                    .mapNotNull { line ->
                        val parts = line.trim().split("\\s+".toRegex())
                        if (parts.size >= 4) {
                            val ip = parts[0]
                            val flags = parts[2]
                            val mac = parts[3]
                            if (flags != "0x0" &&
                                mac != "00:00:00:00:00:00" &&
                                isPrivateIp(ip)
                            ) {
                                ConnectedClient(ipAddress = ip, macAddress = mac)
                            } else null
                        } else null
                    }
            }
        } catch (e: Exception) {
            Timber.w(e, "Failed to read ARP table")
            emptyList()
        }
    }

    private fun isPrivateIp(ip: String): Boolean {
        return ip.startsWith("192.168.") ||
                ip.startsWith("10.") ||
                ip.startsWith("172.16.") || ip.startsWith("172.17.") ||
                ip.startsWith("172.18.") || ip.startsWith("172.19.") ||
                ip.startsWith("172.20.") || ip.startsWith("172.21.") ||
                ip.startsWith("172.22.") || ip.startsWith("172.23.") ||
                ip.startsWith("172.24.") || ip.startsWith("172.25.") ||
                ip.startsWith("172.26.") || ip.startsWith("172.27.") ||
                ip.startsWith("172.28.") || ip.startsWith("172.29.") ||
                ip.startsWith("172.30.") || ip.startsWith("172.31.")
    }

    /**
     * Get the hotspot gateway IP by finding the AP interface.
     * Tries dedicated AP interfaces first, then falls back to any
     * non-loopback, non-VPN, non-primary-WiFi interface.
     */
    fun getGatewayIp(): String? {
        return try {
            val interfaces = NetworkInterface.getNetworkInterfaces()?.toList() ?: return null

            // Method 1: Look for dedicated AP interfaces
            val apNames = setOf("ap0", "wlan1", "swlan0", "ap1", "softap0", "wlan2")
            for (iface in interfaces) {
                if (iface.isUp && iface.name in apNames) {
                    val ip = iface.inetAddresses.asSequence()
                        .filterIsInstance<Inet4Address>()
                        .firstOrNull { !it.isLoopbackAddress }
                        ?.hostAddress
                    if (ip != null) {
                        Timber.d("Hotspot IP found on ${iface.name}: $ip")
                        return ip
                    }
                }
            }

            // Method 2: Find any private IP that's not loopback or VPN (240.x.x.x)
            for (iface in interfaces) {
                if (!iface.isUp || iface.isLoopback || iface.name == "tun0") continue
                val ip = iface.inetAddresses.asSequence()
                    .filterIsInstance<Inet4Address>()
                    .firstOrNull { addr ->
                        !addr.isLoopbackAddress &&
                            addr.hostAddress?.startsWith("240.") != true &&
                            isPrivateIp(addr.hostAddress ?: "")
                    }
                    ?.hostAddress
                if (ip != null) return ip
            }

            null
        } catch (e: Exception) {
            Timber.w(e, "Failed to get gateway IP")
            null
        }
    }
}
