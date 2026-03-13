package com.supertesla.aa.core.config

object AppConfig {
    const val DEFAULT_VIRTUAL_IP = "240.3.3.3"
    const val FALLBACK_VIRTUAL_IP_CGNAT = "100.99.9.9"
    const val FALLBACK_VIRTUAL_IP_BENCHMARK = "198.18.0.1"

    const val SERVER_PORT = 8080
    const val HOTSPOT_SUBNET = "192.168.43.0"
    const val HOTSPOT_SUBNET_PREFIX = 24
    const val HOTSPOT_GATEWAY = "192.168.43.1"

    const val ARP_POLL_INTERVAL_MS = 2000L

    const val NOTIFICATION_CHANNEL_ID = "supertesla_streaming"
    const val NOTIFICATION_ID = 1001

    fun getServerUrl(virtualIp: String = DEFAULT_VIRTUAL_IP): String {
        return "http://$virtualIp:$SERVER_PORT"
    }
}
