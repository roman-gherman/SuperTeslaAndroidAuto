package com.supertesla.aa.core.config

object AppConfig {
    /**
     * VPN virtual IP — must be a routable non-RFC1918 address.
     * Tesla's browser blocks all private IPs (192.168.x.x, 10.x.x.x, 172.16-31.x.x)
     * and Class E (240.x.x.x). TaaDa uses 51.75.29.16 (OVH range).
     * This IP is only used locally on the VPN interface — it doesn't actually
     * route to the internet, so using "someone else's" IP is harmless.
     */
    const val DEFAULT_VIRTUAL_IP = "51.75.29.16"
    const val SERVER_PORT = 8080

    /**
     * Public domain that resolves to DEFAULT_VIRTUAL_IP via DNS A record.
     * Users type this URL in Tesla's browser instead of an IP address.
     */
    const val PUBLIC_DOMAIN = "supertesla.duckdns.org"
    const val DUCKDNS_SUBDOMAIN = "supertesla"

    // Cloud relay for Tesla browser access (bypasses Android 16 per-UID hotspot firewall)
    // TODO: Update these after deploying to Cloud Run
    const val RELAY_WSS_URL = "wss://supertesla-relay-XXXXX.run.app"
    const val RELAY_API_URL = "https://supertesla-relay-XXXXX.run.app"
    const val PLAYER_BASE_URL = "https://play.supertesla.com"

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
