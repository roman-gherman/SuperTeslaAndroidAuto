package com.supertesla.aa.network.dns

import android.content.Context
import android.net.nsd.NsdManager
import android.net.nsd.NsdServiceInfo
import com.supertesla.aa.core.config.AppConfig
import timber.log.Timber

/**
 * Registers the web server as an mDNS service on the local network.
 * This allows Tesla (or any device on the hotspot) to reach the server
 * at http://supertesla.local:8080 instead of a raw IP address.
 *
 * Uses Android's NsdManager - no root required, works on all Android 4.1+.
 */
class MdnsServiceRegistrar(private val context: Context) {

    private var nsdManager: NsdManager? = null
    private var registered = false

    companion object {
        const val SERVICE_NAME = "SuperTesla"
        const val SERVICE_TYPE = "_http._tcp."
        const val HOSTNAME = "supertesla" // resolves as supertesla.local
    }

    fun register(port: Int = AppConfig.SERVER_PORT) {
        if (registered) return

        try {
            nsdManager = context.getSystemService(Context.NSD_SERVICE) as NsdManager

            val serviceInfo = NsdServiceInfo().apply {
                serviceName = SERVICE_NAME
                serviceType = SERVICE_TYPE
                setPort(port)
            }

            nsdManager?.registerService(
                serviceInfo,
                NsdManager.PROTOCOL_DNS_SD,
                object : NsdManager.RegistrationListener {
                    override fun onRegistrationFailed(serviceInfo: NsdServiceInfo, errorCode: Int) {
                        Timber.w("mDNS registration failed: error $errorCode")
                    }

                    override fun onUnregistrationFailed(serviceInfo: NsdServiceInfo, errorCode: Int) {
                        Timber.w("mDNS unregistration failed: error $errorCode")
                    }

                    override fun onServiceRegistered(serviceInfo: NsdServiceInfo) {
                        registered = true
                        Timber.i("mDNS registered: ${serviceInfo.serviceName} on port $port")
                        Timber.i("Access via: http://supertesla.local:$port")
                    }

                    override fun onServiceUnregistered(serviceInfo: NsdServiceInfo) {
                        registered = false
                        Timber.i("mDNS unregistered")
                    }
                }
            )
        } catch (e: Exception) {
            Timber.w(e, "Failed to register mDNS service")
        }
    }

    fun unregister() {
        if (!registered) return
        try {
            nsdManager?.unregisterService(object : NsdManager.RegistrationListener {
                override fun onRegistrationFailed(si: NsdServiceInfo, e: Int) {}
                override fun onUnregistrationFailed(si: NsdServiceInfo, e: Int) {}
                override fun onServiceRegistered(si: NsdServiceInfo) {}
                override fun onServiceUnregistered(si: NsdServiceInfo) { registered = false }
            })
        } catch (_: Exception) {}
        registered = false
    }
}
