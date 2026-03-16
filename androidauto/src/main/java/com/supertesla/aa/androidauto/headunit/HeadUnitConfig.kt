package com.supertesla.aa.androidauto.headunit

/**
 * Configuration for the head unit emulator.
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
    val heartbeatIntervalMs: Long = 2000L
) {
    companion object {
        const val AA_LISTEN_PORT = 5288
        const val AA_DEV_PORT = 5277
        const val MAX_PAYLOAD_SIZE = 524_288

        val CAR_HELLO = byteArrayOf(0, 3, 0, 6, 0, 1, 0, 1, 0, 6)
        val CLEARTEXT_MSG = byteArrayOf(0, 3, 0, 4, 0, 4, 8, 0)
        val EXIT_MSG = byteArrayOf(0, 15, 8, 1)
    }
}
