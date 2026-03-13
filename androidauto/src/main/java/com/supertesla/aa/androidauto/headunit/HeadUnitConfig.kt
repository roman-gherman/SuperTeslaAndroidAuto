package com.supertesla.aa.androidauto.headunit

/**
 * Configuration for the head unit emulator.
 */
data class HeadUnitConfig(
    val videoWidth: Int = 1280,
    val videoHeight: Int = 720,
    val videoDensity: Int = 160,
    val videoFps: Int = 30,
    val audioSampleRate: Int = 48000,
    val audioChannels: Int = 2,
    val audioBitDepth: Int = 16,
    val host: String = "127.0.0.1",
    val port: Int = 5277
)
