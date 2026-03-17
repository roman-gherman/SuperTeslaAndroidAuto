package com.supertesla.aa.network.webserver

/**
 * Calculates margin offsets when video resolution aspect ratio doesn't match screen.
 * Matches TaaDa's margin calculation logic.
 */
object MarginCalculator {

    /**
     * Calculate horizontal (pillarbox) margin when screen is narrower than video.
     * @return width margin in pixels, always >= 0
     */
    fun calculateWidthMargin(
        videoWidth: Int, videoHeight: Int,
        screenWidth: Int, screenHeight: Int
    ): Int {
        if (screenHeight == 0 || videoHeight == 0) return 0
        val screenRatio = screenWidth.toFloat() / screenHeight
        val videoRatio = videoWidth.toFloat() / videoHeight
        return if (screenRatio <= videoRatio) {
            (videoWidth - (videoHeight * screenRatio)).toInt().coerceAtLeast(0)
        } else 0
    }

    /**
     * Calculate vertical (letterbox) margin when screen is wider than video.
     * @return height margin in pixels, always >= 0
     */
    fun calculateHeightMargin(
        videoWidth: Int, videoHeight: Int,
        screenWidth: Int, screenHeight: Int
    ): Int {
        if (screenWidth == 0 || screenHeight == 0 || videoHeight == 0) return 0
        val screenRatio = screenWidth.toFloat() / screenHeight
        val videoRatio = videoWidth.toFloat() / videoHeight
        return if (screenRatio > videoRatio) {
            (videoHeight - (videoWidth / screenRatio)).toInt().coerceAtLeast(0)
        } else 0
    }
}
