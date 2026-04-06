package com.supertesla.aa.core.config

object AppConfig {
    const val SERVER_PORT = 8080

    // Cloud relay for Tesla browser access (bypasses Android 16 per-UID hotspot firewall)
    const val RELAY_WSS_URL = "wss://supertesla-relay-289625450505.europe-west1.run.app"
    const val RELAY_API_URL = "https://supertesla-relay-289625450505.europe-west1.run.app"
    const val PLAYER_BASE_URL = "https://supertesla-relay-289625450505.europe-west1.run.app"

    const val ARP_POLL_INTERVAL_MS = 2000L

    const val NOTIFICATION_CHANNEL_ID = "supertesla_streaming"
    const val NOTIFICATION_ID = 1001

    /** Dynamic hotspot IP detected at runtime */
    var detectedHotspotIp: String? = null
}
