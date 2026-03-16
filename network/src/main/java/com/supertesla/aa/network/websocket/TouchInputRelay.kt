package com.supertesla.aa.network.websocket

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import timber.log.Timber

/**
 * Receives touch events from the Tesla browser via WebSocket,
 * transforms normalized coordinates to AA display pixels,
 * and forwards them to either:
 * - AA protocol (InputChannelHandler) in relay mode
 * - AccessibilityService (TouchInjectionService) in screen mirror mode
 *
 * Supports two touch event formats:
 * 1. Simple: {"type":"touch", "action":"down", "x":0.5, "y":0.5, "pointerId":0}
 * 2. TaaDa-style: {"action":"MULTITOUCH_DOWN", "touches":[...], "allTouches":[...]}
 */
class TouchInputRelay(
    private val displayWidth: Int,
    private val displayHeight: Int
) {
    @Serializable
    data class BrowserTouchEvent(
        val type: String = "",
        val action: String,
        val pointerId: Int = 0,
        val x: Float = 0f,
        val y: Float = 0f,
        val timestamp: Long = 0
    )

    @Serializable
    data class TouchPoint(
        val id: Int = 0,
        val x: Int = 0,
        val y: Int = 0
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
     * Supports both simple format and TaaDa MULTITOUCH format.
     * Returns true if the message was handled as a touch event.
     */
    fun handleMessage(message: String): Boolean {
        return try {
            val jsonObj = json.parseToJsonElement(message)
            val obj = jsonObj as? kotlinx.serialization.json.JsonObject ?: return false
            val action = obj["action"]?.let {
                (it as? kotlinx.serialization.json.JsonPrimitive)?.content
            } ?: return false

            when {
                // TaaDa MULTITOUCH format
                action.startsWith("MULTITOUCH_") -> handleMultiTouchMessage(action, obj)
                // Simple touch format
                else -> handleSimpleTouchMessage(message)
            }
        } catch (e: Exception) {
            false
        }
    }

    private fun handleSimpleTouchMessage(message: String): Boolean {
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

        val aaX = (event.x * displayWidth).toInt().coerceIn(0, displayWidth - 1)
        val aaY = (event.y * displayHeight).toInt().coerceIn(0, displayHeight - 1)

        touchListener?.onTouch(aaAction, aaX, aaY, event.pointerId)
        trackEvent()
        return true
    }

    /**
     * Handle TaaDa-style MULTITOUCH events:
     * {"action":"MULTITOUCH_DOWN", "touches":[{"id":0,"x":640,"y":360}], "allTouches":[...]}
     */
    private fun handleMultiTouchMessage(
        action: String,
        obj: kotlinx.serialization.json.JsonObject
    ): Boolean {
        val aaAction = when (action) {
            "MULTITOUCH_DOWN" -> ACTION_DOWN
            "MULTITOUCH_MOVE" -> ACTION_MOVE
            "MULTITOUCH_UP" -> ACTION_UP
            "MULTITOUCH_CANCEL" -> ACTION_UP
            else -> return false
        }

        // Parse touches array (the pointers that changed)
        val touchesArray = obj["touches"] as? kotlinx.serialization.json.JsonArray
        val touches = touchesArray?.map { elem ->
            json.decodeFromJsonElement(TouchPoint.serializer(), elem)
        } ?: emptyList()

        // Parse allTouches array (all current pointers)
        val allTouchesArray = obj["allTouches"] as? kotlinx.serialization.json.JsonArray
        val allTouches = allTouchesArray?.map { elem ->
            json.decodeFromJsonElement(TouchPoint.serializer(), elem)
        } ?: touches

        // Send each touch point. For multi-touch, use the allTouches list.
        val pointsToSend = if (allTouches.isNotEmpty()) allTouches else touches
        for (point in pointsToSend) {
            val x = point.x.coerceIn(0, displayWidth - 1)
            val y = point.y.coerceIn(0, displayHeight - 1)
            touchListener?.onTouch(aaAction, x, y, point.id)
        }

        // If no points, send at least the first touch
        if (pointsToSend.isEmpty() && touches.isNotEmpty()) {
            val point = touches.first()
            touchListener?.onTouch(aaAction, point.x, point.y, point.id)
        }

        trackEvent()
        return true
    }

    private fun trackEvent() {
        eventCount++
        if (eventCount % 100 == 0L) {
            Timber.d("Touch relay: $eventCount events processed")
        }
    }

    companion object {
        const val ACTION_DOWN = 0
        const val ACTION_UP = 1
        const val ACTION_MOVE = 2
    }
}
