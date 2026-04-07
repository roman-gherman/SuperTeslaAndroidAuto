package com.supertesla.aa.androidauto.headunit

/**
 * Configuration for the head unit emulator.
 * All fields can be loaded from SharedPreferences via [fromMap].
 */
data class HeadUnitConfig(
    val videoWidth: Int = 1280,
    val videoHeight: Int = 720,
    val videoDensity: Int = 120,
    val videoFps: Int = 30,
    val audioSampleRate: Int = 48000,
    val audioChannels: Int = 2,
    val audioBitDepth: Int = 16,
    val host: String = "127.0.0.1",
    val port: Int = 5288,

    // Socket configuration (matches TaaDa)
    val socketTimeoutMs: Int = 10_000,
    val socketBufferSize: Int = 1_048_576,  // 1MB send/receive buffers

    // Heartbeat
    val heartbeatIntervalMs: Long = 2000L,

    // User preferences
    val useBluetooth: Boolean = true
) {
    companion object {
        const val AA_LISTEN_PORT = 5288
        const val AA_DEV_PORT = 5277
        const val MAX_PAYLOAD_SIZE = 524_288

        val CAR_HELLO = byteArrayOf(0, 3, 0, 6, 0, 1, 0, 1, 0, 6)
        val CLEARTEXT_MSG = byteArrayOf(0, 3, 0, 4, 0, 4, 8, 0)
        val EXIT_MSG = byteArrayOf(0, 15, 8, 1)

        /** Resolution presets. */
        val RESOLUTION_PRESETS = mapOf(
            "480p" to (800 to 480),
            "720p" to (1280 to 720),
            "1080p" to (1920 to 1080)
        )

        /**
         * Create config from a string map (e.g., SharedPreferences-like).
         * Missing keys use defaults.
         */
        fun fromMap(prefs: Map<String, String>): HeadUnitConfig {
            val resolution = prefs["resolution"] ?: "720p"
            val (w, h) = RESOLUTION_PRESETS[resolution] ?: (1280 to 720)

            val dpi = (prefs["dpi"]?.toIntOrNull() ?: 120).coerceIn(100, 300)
            val useBt = prefs["usebt"]?.toBooleanStrictOrNull() ?: true

            return HeadUnitConfig(
                videoWidth = w,
                videoHeight = h,
                videoDensity = dpi,
                useBluetooth = useBt
            )
        }
    }
}
