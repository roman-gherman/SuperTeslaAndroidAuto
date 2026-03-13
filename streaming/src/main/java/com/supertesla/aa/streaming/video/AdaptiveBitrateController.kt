package com.supertesla.aa.streaming.video

import timber.log.Timber

/**
 * Monitors network conditions and adjusts video quality dynamically.
 * Quality levels range from 720p60 (best) to 360p15 (minimum viable).
 */
class AdaptiveBitrateController {

    data class QualityLevel(
        val width: Int,
        val height: Int,
        val fps: Int,
        val label: String
    )

    data class NetworkStats(
        val rttMs: Long = 0,
        val droppedFrames: Int = 0,
        val bufferLevelSec: Double = 0.0,
        val bandwidthKbps: Long = 0
    )

    val qualityLevels = listOf(
        QualityLevel(1280, 720, 60, "720p60"),
        QualityLevel(1280, 720, 30, "720p30"),
        QualityLevel(854, 480, 30, "480p30"),
        QualityLevel(640, 360, 30, "360p30"),
        QualityLevel(640, 360, 15, "360p15")
    )

    var currentLevelIndex = 1 // Start at 720p30
        private set

    val currentLevel: QualityLevel get() = qualityLevels[currentLevelIndex]

    var onQualityChanged: ((QualityLevel) -> Unit)? = null
    var manualOverride: Int? = null // null = auto, 0-4 = fixed level

    /**
     * Process network stats and adjust quality if needed.
     */
    fun onNetworkStats(stats: NetworkStats) {
        if (manualOverride != null) return

        val previousIndex = currentLevelIndex

        when {
            // Degrade: high latency or many drops
            stats.rttMs > 200 || stats.droppedFrames > 5 -> {
                increaseIndex() // lower quality = higher index
            }
            stats.rttMs > 100 || stats.droppedFrames > 2 -> {
                // Mild degradation - only step down if not already low
                if (currentLevelIndex < 2) increaseIndex()
            }
            // Improve: low latency, no drops, buffer healthy
            stats.rttMs < 50 && stats.droppedFrames == 0 && stats.bufferLevelSec < 0.5 -> {
                decreaseIndex() // higher quality = lower index
            }
        }

        if (currentLevelIndex != previousIndex) {
            Timber.i("Quality: ${qualityLevels[previousIndex].label} -> ${currentLevel.label}")
            onQualityChanged?.invoke(currentLevel)
        }
    }

    /**
     * Process stats reported by the browser.
     */
    fun onBrowserStats(decodedFrames: Int, droppedFrames: Int, bufferLength: Double) {
        onNetworkStats(NetworkStats(
            droppedFrames = droppedFrames,
            bufferLevelSec = bufferLength
        ))
    }

    fun setManualLevel(index: Int?) {
        manualOverride = index
        if (index != null && index in qualityLevels.indices) {
            currentLevelIndex = index
            onQualityChanged?.invoke(currentLevel)
        }
    }

    private fun increaseIndex() {
        if (currentLevelIndex < qualityLevels.size - 1) currentLevelIndex++
    }

    private fun decreaseIndex() {
        if (currentLevelIndex > 0) currentLevelIndex--
    }
}
