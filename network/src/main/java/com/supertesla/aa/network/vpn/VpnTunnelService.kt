package com.supertesla.aa.network.vpn

import android.content.Intent
import android.net.VpnService
import android.os.ParcelFileDescriptor
import com.supertesla.aa.core.config.AppConfig
import timber.log.Timber

class VpnTunnelService : VpnService() {

    private var tunInterface: ParcelFileDescriptor? = null
    private var secondaryTunInterface: ParcelFileDescriptor? = null
    private var currentVirtualIp: String? = null

    val isEstablished: Boolean
        get() = tunInterface != null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val virtualIp = intent?.getStringExtra(EXTRA_VIRTUAL_IP) ?: AppConfig.DEFAULT_VIRTUAL_IP
        if (!isEstablished) {
            establishTunnel(virtualIp)
        }
        return START_STICKY
    }

    fun establishTunnel(virtualIp: String = AppConfig.DEFAULT_VIRTUAL_IP): Boolean {
        return try {
            Timber.d("Establishing VPN tunnel with IP: $virtualIp")
            val builder = Builder()
            builder.setSession("SuperTeslaAA")
            // === TaaDa dual-VPN trick ===
            // VPN 1: Dummy VPN that routes all traffic, excludes AA.
            //         This gets superseded by VPN 2 immediately.
            builder.addAddress(SECONDARY_VPN_IP, 24)
            builder.addRoute("0.0.0.0", 0)
            builder.addDnsServer("8.8.8.8")
            builder.setMtu(1500)
            builder.setBlocking(false)
            try {
                builder.addDisallowedApplication(AA_PACKAGE)
                Timber.d("VPN1: Excluded $AA_PACKAGE")
            } catch (e: Exception) {
                Timber.w(e, "VPN1: Failed to exclude AA")
            }

            tunInterface = builder.establish()
            Timber.i("VPN1 established: $SECONDARY_VPN_IP/24 (dummy, will be superseded)")

            // VPN 2: The ACTIVE VPN with the public IP we want reachable.
            // addAllowedApplication with a non-existent package means no app's
            // traffic goes through this VPN. This cancels VPN1's traffic
            // interception while keeping the public IP on an UP interface.
            try {
                val builder2 = Builder()
                builder2.setSession("SuperTeslaAA_2")
                builder2.addAddress(virtualIp, 24)
                builder2.addRoute("0.0.0.0", 0)
                builder2.addDnsServer("8.8.8.8")
                builder2.setMtu(1500)
                builder2.setBlocking(false)
                builder2.addAllowedApplication("android.net.ConnectivityManager")
                secondaryTunInterface = builder2.establish()
                Timber.i("VPN2 established: $virtualIp/24 (active, routes nothing — internet restored)")
            } catch (e: Exception) {
                Timber.w(e, "VPN2 failed (non-fatal)")
            }
            currentVirtualIp = if (tunInterface != null) virtualIp else null

            if (tunInterface != null) {
                Timber.i("VPN tunnel established on $virtualIp")
                true
            } else {
                Timber.e("Failed to establish VPN tunnel - builder.establish() returned null")
                false
            }
        } catch (e: Exception) {
            Timber.e(e, "Failed to establish VPN tunnel")
            false
        }
    }

    fun teardown() {
        Timber.d("Tearing down VPN tunnel")
        try { secondaryTunInterface?.close() } catch (_: Exception) {}
        secondaryTunInterface = null
        try { tunInterface?.close() } catch (_: Exception) {}
        tunInterface = null
        currentVirtualIp = null
    }

    /**
     * Protect a socket from being routed through the VPN tunnel.
     * Call this on all server sockets to prevent routing loops.
     */
    fun protectSocket(socketFd: Int): Boolean {
        return protect(socketFd)
    }

    override fun onDestroy() {
        teardown()
        super.onDestroy()
    }

    override fun onRevoke() {
        Timber.w("VPN permission revoked by user")
        teardown()
        super.onRevoke()
    }

    companion object {
        const val EXTRA_VIRTUAL_IP = "extra_virtual_ip"
        const val AA_PACKAGE = "com.google.android.projection.gearhead"
        const val SECONDARY_VPN_IP = "89.83.67.208"  // TaaDa's secondary VPN IP

        // No excluded packages list needed — the dual-VPN trick
        // restores internet for all apps automatically.
    }
}
