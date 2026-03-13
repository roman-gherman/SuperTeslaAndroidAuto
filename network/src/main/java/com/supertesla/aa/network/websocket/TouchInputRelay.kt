package com.supertesla.aa.network.websocket

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import timber.log.Timber

/**
 * Receives touch events from the Tesla browser via WebSocket,
 * transforms normalized coordinates to AA display pixels,
 * and forwards them to the AA input channel handler.
 */
class TouchInputRelay(
    private val displayWidth: Int,
    private val displayHeight: Int
) {
    @Serializable
    data class BrowserTouchEvent(
        val type: String,
        val action: String,
        val pointerId: Int,
        val x: Float,
        val y: Float,
        val timestamp: Long = 0
    )

    private val json = Json { ignoreUnknownKeys = true }
    private var touchListener: TouchListener? = null
    private var eventCount = 0L

    interface TouchListener {
        fun onTouch(action: Int, x: Int, y: Int, pointerId: Int)
    }

    fun setTouchListener(listener: TouchListener) {
        touchListener = listener
    }

    /**
     * Process a WebSocket text message that may contain a touch event.
     * Returns true if the message was handled as a touch event.
     */
    fun handleMessage(message: String): Boolean {
        val event = try {
            json.decodeFromString<BrowserTouchEvent>(message)
        } catch (e: Exception) {
            return false
        }

        if (event.type != "touch") return false

        val aaAction = when (event.action) {
            "down" -> ACTION_DOWN
            "move" -> ACTION_MOVE
            "up" -> ACTION_UP
            else -> return false
        }

        // Transform normalized (0.0-1.0) coordinates to AA display pixels
        val aaX = (event.x * displayWidth).toInt().coerceIn(0, displayWidth - 1)
        val aaY = (event.y * displayHeight).toInt().coerceIn(0, displayHeight - 1)

        touchListener?.onTouch(aaAction, aaX, aaY, event.pointerId)

        eventCount++
        if (eventCount % 100 == 0L) {
            Timber.d("Touch relay: $eventCount events processed")
        }

        return true
    }

    companion object {
        const val ACTION_DOWN = 0
        const val ACTION_UP = 1
        const val ACTION_MOVE = 2
    }
}
