package com.supertesla.aa.core.config

object AppConfig {
    const val DEFAULT_VIRTUAL_IP = "240.3.3.3"
    const val SERVER_PORT = 8080

    const val ARP_POLL_INTERVAL_MS = 2000L

    const val NOTIFICATION_CHANNEL_ID = "supertesla_streaming"
    const val NOTIFICATION_ID = 1001

    /** Dynamic hotspot IP detected at runtime */
    var detectedHotspotIp: String? = null

    fun getServerUrl(): String {
        val ip = detectedHotspotIp ?: DEFAULT_VIRTUAL_IP
        return "http://$ip:$SERVER_PORT"
    }
}
