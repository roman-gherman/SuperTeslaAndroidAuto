package com.supertesla.aa.network.hotspot

import android.content.Context
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
import java.net.Inet4Address
import java.net.NetworkInterface

class HotspotManager(private val context: Context) {

    private val wifiManager: WifiManager by lazy {
        context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
    }

    /**
     * Observe hotspot state by polling network interfaces and ARP table.
     * Emits [HotspotState] changes.
     */
    fun observeHotspotState(): Flow<HotspotState> = flow {
        while (true) {
            val state = checkHotspotState()
            emit(state)
            delay(AppConfig.ARP_POLL_INTERVAL_MS)
        }
    }.distinctUntilChanged()

    /**
     * Observe connected clients by polling ARP table.
     */
    fun observeConnectedClients(): Flow<List<ConnectedClient>> = flow {
        while (true) {
            val clients = readArpTable()
            emit(clients)
            delay(AppConfig.ARP_POLL_INTERVAL_MS)
        }
    }.distinctUntilChanged()

    private fun checkHotspotState(): HotspotState {
        // Check if hotspot interface exists (usually "wlan0" or "ap0" or "swlan0")
        val hasHotspotInterface = try {
            NetworkInterface.getNetworkInterfaces()?.asSequence()?.any { iface ->
                iface.isUp && !iface.isLoopback && iface.inetAddresses.asSequence().any { addr ->
                    addr is Inet4Address && addr.hostAddress?.startsWith("192.168.43.") == true
                }
            } ?: false
        } catch (e: Exception) {
            false
        }

        if (!hasHotspotInterface) {
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
     * Parse /proc/net/arp to find connected clients on the hotspot subnet.
     * Format: IP address, HW type, Flags, HW address, Mask, Device
     */
    private fun readArpTable(): List<ConnectedClient> {
        return try {
            BufferedReader(FileReader("/proc/net/arp")).use { reader ->
                reader.readLines()
                    .drop(1) // skip header
                    .mapNotNull { line ->
                        val parts = line.trim().split("\\s+".toRegex())
                        if (parts.size >= 4) {
                            val ip = parts[0]
                            val flags = parts[2]
                            val mac = parts[3]
                            // Filter: only hotspot subnet, valid flags (0x2 = complete)
                            if (ip.startsWith("192.168.43.") &&
                                flags != "0x0" &&
                                mac != "00:00:00:00:00:00"
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

    /**
     * Get the gateway IP of the hotspot (our phone's IP on the hotspot interface).
     */
    fun getGatewayIp(): String? {
        return try {
            NetworkInterface.getNetworkInterfaces()?.asSequence()
                ?.flatMap { it.inetAddresses.asSequence() }
                ?.firstOrNull { addr ->
                    addr is Inet4Address && addr.hostAddress?.startsWith("192.168.43.") == true
                }
                ?.hostAddress
        } catch (e: Exception) {
            Timber.w(e, "Failed to get gateway IP")
            null
        }
    }
}
