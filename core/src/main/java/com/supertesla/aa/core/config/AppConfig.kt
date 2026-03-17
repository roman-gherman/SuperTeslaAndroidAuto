package com.supertesla.aa.core.config

object AppConfig {
    const val DEFAULT_VIRTUAL_IP = "240.3.3.3"
    const val SERVER_PORT = 8080

    /**
     * Public domain that resolves to DEFAULT_VIRTUAL_IP via DNS A record.
     * Set this to your own domain after adding: A record → 240.3.3.3
     * Users type this URL in Tesla's browser instead of an IP address.
     */
    const val PUBLIC_DOMAIN = "supertesla.duckdns.org"
    const val DUCKDNS_SUBDOMAIN = "supertesla"

    const val ARP_POLL_INTERVAL_MS = 2000L

    const val NOTIFICATION_CHANNEL_ID = "supertesla_streaming"
    const val NOTIFICATION_ID = 1001

    /** Dynamic hotspot IP detected at runtime */
    var detectedHotspotIp: String? = null

    fun getServerUrl(): String {
        // Prefer the friendly domain if configured
        return "http://$PUBLIC_DOMAIN"
    }

    fun getServerUrlFallback(): String {
        val ip = detectedHotspotIp ?: DEFAULT_VIRTUAL_IP
        return "http://$ip:$SERVER_PORT"
    }
}
