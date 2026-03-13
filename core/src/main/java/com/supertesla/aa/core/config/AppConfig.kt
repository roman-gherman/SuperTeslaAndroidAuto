package com.supertesla.aa.core.config

object AppConfig {
    const val DEFAULT_VIRTUAL_IP = "240.3.3.3"
    const val FALLBACK_VIRTUAL_IP_CGNAT = "100.99.9.9"
    const val FALLBACK_VIRTUAL_IP_BENCHMARK = "198.18.0.1"

    const val HOSTNAME = "super.taa"
    const val SERVER_PORT = 8080
    const val SERVER_PORT_HTTP = 80
    const val DNS_PORT = 53

    const val HOTSPOT_SUBNET = "192.168.43.0"
    const val HOTSPOT_SUBNET_PREFIX = 24
    const val HOTSPOT_GATEWAY = "192.168.43.1"

    const val ARP_POLL_INTERVAL_MS = 2000L

    const val NOTIFICATION_CHANNEL_ID = "supertesla_streaming"
    const val NOTIFICATION_ID = 1001

    /**
     * Get the user-friendly URL using the custom hostname.
     * Falls back to IP:port if DNS isn't available.
     */
    fun getServerUrl(useHostname: Boolean = true): String {
        return if (useHostname) "http://$HOSTNAME" else "http://$DEFAULT_VIRTUAL_IP:$SERVER_PORT"
    }

    fun getServerUrlFallback(): String {
        return "http://$DEFAULT_VIRTUAL_IP:$SERVER_PORT"
    }
}
