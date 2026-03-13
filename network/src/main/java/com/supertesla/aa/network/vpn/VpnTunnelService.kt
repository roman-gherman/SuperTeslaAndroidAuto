package com.supertesla.aa.network.vpn

import android.content.Intent
import android.net.VpnService
import android.os.ParcelFileDescriptor
import com.supertesla.aa.core.config.AppConfig
import timber.log.Timber

class VpnTunnelService : VpnService() {

    private var tunInterface: ParcelFileDescriptor? = null
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
            builder.addAddress(virtualIp, 32)
            builder.addRoute(AppConfig.HOTSPOT_SUBNET, AppConfig.HOTSPOT_SUBNET_PREFIX)
            builder.setMtu(1500)
            builder.setBlocking(false)

            tunInterface = builder.establish()
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
        try {
            tunInterface?.close()
        } catch (e: Exception) {
            Timber.w(e, "Error closing TUN interface")
        }
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
    }
}
