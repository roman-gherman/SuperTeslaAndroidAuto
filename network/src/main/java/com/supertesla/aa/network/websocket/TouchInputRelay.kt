package com.supertesla.aa.network.websocket

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import timber.log.Timber

/**
 * Receives touch events from the Tesla browser via WebSocket,
 * transforms coordinates and forwards them to AA protocol.
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
    private var multiTouchListener: MultiTouchListener? = null
    private var eventCount = 0L

    interface TouchListener {
        fun onTouch(action: Int, x: Int, y: Int, pointerId: Int)
    }

    /**
     * Listener for batched multi-touch events.
     * action: AA action (0=DOWN, 1=UP, 2=MOVE, 5=POINTER_DOWN, 6=POINTER_UP)
     * actionIndex: index of the pointer that triggered POINTER_DOWN/POINTER_UP
     * pointers: all currently active pointers
     */
    interface MultiTouchListener {
        fun onMultiTouch(action: Int, actionIndex: Int, pointers: List<TouchPoint>)
    }

    fun setTouchListener(listener: TouchListener) {
        touchListener = listener
    }

    fun setMultiTouchListener(listener: MultiTouchListener) {
        multiTouchListener = listener
    }

    /**
     * Process a WebSocket text message that may contain a touch event.
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
                action.startsWith("MULTITOUCH_") -> handleMultiTouchMessage(action, obj)
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

        if (multiTouchListener != null) {
            multiTouchListener?.onMultiTouch(aaAction, 0, listOf(TouchPoint(event.pointerId, aaX, aaY)))
        } else {
            touchListener?.onTouch(aaAction, aaX, aaY, event.pointerId)
        }
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
        val browserAction = when (action) {
            "MULTITOUCH_DOWN" -> BROWSER_DOWN
            "MULTITOUCH_MOVE" -> BROWSER_MOVE
            "MULTITOUCH_UP" -> BROWSER_UP
            "MULTITOUCH_CANCEL" -> BROWSER_UP
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

        // Clamp coordinates
        val clampedAll = allTouches.map { p ->
            TouchPoint(p.id, p.x.coerceIn(0, displayWidth - 1), p.y.coerceIn(0, displayHeight - 1))
        }
        val clampedChanged = touches.map { p ->
            TouchPoint(p.id, p.x.coerceIn(0, displayWidth - 1), p.y.coerceIn(0, displayHeight - 1))
        }

        if (multiTouchListener != null) {
            // Map to proper AA action with multi-touch awareness
            val aaAction = mapToAaAction(browserAction, allTouches.size)

            // For POINTER_DOWN/POINTER_UP, find the index of the changed pointer in allTouches
            val actionIndex = if (aaAction == ACTION_POINTER_DOWN || aaAction == ACTION_POINTER_UP) {
                val changedId = clampedChanged.firstOrNull()?.id ?: 0
                clampedAll.indexOfFirst { it.id == changedId }.coerceAtLeast(0)
            } else {
                0
            }

            // Send all pointers as a batch. For UP/CANCEL, include the releasing pointer too
            val pointers = if (browserAction == BROWSER_UP && clampedAll.isEmpty()) {
                clampedChanged // On final UP, allTouches is empty; send the released pointer
            } else {
                clampedAll.ifEmpty { clampedChanged }
            }

            multiTouchListener?.onMultiTouch(aaAction, actionIndex, pointers)
        } else {
            // Legacy single-pointer fallback
            val aaAction = when (browserAction) {
                BROWSER_DOWN -> ACTION_DOWN
                BROWSER_MOVE -> ACTION_MOVE
                BROWSER_UP -> ACTION_UP
                else -> ACTION_DOWN
            }
            val pointsToSend = if (clampedAll.isNotEmpty()) clampedAll else clampedChanged
            for (point in pointsToSend) {
                touchListener?.onTouch(aaAction, point.x, point.y, point.id)
            }
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
        const val ACTION_POINTER_DOWN = 5
        const val ACTION_POINTER_UP = 6

        private const val BROWSER_DOWN = 0
        private const val BROWSER_MOVE = 1
        private const val BROWSER_UP = 2

        /**
         * Map browser touch action to AA PointerAction, accounting for multi-touch.
         */
        fun mapToAaAction(browserAction: Int, allTouchCount: Int): Int {
            return when (browserAction) {
                BROWSER_DOWN -> if (allTouchCount > 1) ACTION_POINTER_DOWN else ACTION_DOWN
                BROWSER_UP -> if (allTouchCount > 0) ACTION_POINTER_UP else ACTION_UP
                BROWSER_MOVE -> ACTION_MOVE
                else -> ACTION_DOWN
            }
        }
    }
}
