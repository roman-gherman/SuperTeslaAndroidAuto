package com.supertesla.aa.service

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.graphics.Path
import android.os.Build
import android.view.accessibility.AccessibilityEvent
import timber.log.Timber

/**
 * AccessibilityService that injects touch gestures on behalf of the Tesla browser.
 * Uses dispatchGesture() (Android 7.0+) to simulate taps, drags, and swipes.
 *
 * The user must manually enable this service in Settings > Accessibility.
 */
class TouchInjectionService : AccessibilityService() {

    override fun onServiceConnected() {
        super.onServiceConnected()
        instance = this
        Timber.i("TouchInjectionService connected")
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        // We don't need to process accessibility events — only inject gestures
    }

    override fun onInterrupt() {
        Timber.w("TouchInjectionService interrupted")
    }

    override fun onDestroy() {
        instance = null
        Timber.i("TouchInjectionService destroyed")
        super.onDestroy()
    }

    /**
     * Inject a tap at the given screen coordinates.
     */
    fun injectTap(x: Float, y: Float) {
        val path = Path().apply { moveTo(x, y) }
        val stroke = GestureDescription.StrokeDescription(path, 0, TAP_DURATION_MS)
        val gesture = GestureDescription.Builder().addStroke(stroke).build()
        dispatchGesture(gesture, null, null)
    }

    /**
     * Inject a swipe/drag from (x1,y1) to (x2,y2).
     */
    fun injectSwipe(x1: Float, y1: Float, x2: Float, y2: Float, durationMs: Long = SWIPE_DURATION_MS) {
        val path = Path().apply {
            moveTo(x1, y1)
            lineTo(x2, y2)
        }
        val stroke = GestureDescription.StrokeDescription(path, 0, durationMs)
        val gesture = GestureDescription.Builder().addStroke(stroke).build()
        dispatchGesture(gesture, null, null)
    }

    /**
     * Stateful gesture tracking for continuous touch sequences (down → move → up).
     * Accumulates move events and dispatches as a single swipe on ACTION_UP.
     */
    private data class ActiveGesture(
        val startX: Float,
        val startY: Float,
        var lastX: Float,
        var lastY: Float,
        val startTime: Long = System.currentTimeMillis()
    )

    private val activeGestures = mutableMapOf<Int, ActiveGesture>()

    fun onTouchDown(pointerId: Int, x: Float, y: Float) {
        activeGestures[pointerId] = ActiveGesture(x, y, x, y)
    }

    fun onTouchMove(pointerId: Int, x: Float, y: Float) {
        activeGestures[pointerId]?.let {
            it.lastX = x
            it.lastY = y
        }
    }

    fun onTouchUp(pointerId: Int, x: Float, y: Float) {
        val gesture = activeGestures.remove(pointerId) ?: return
        val dx = x - gesture.startX
        val dy = y - gesture.startY
        val distance = Math.sqrt((dx * dx + dy * dy).toDouble())

        if (distance < TAP_THRESHOLD) {
            // Small movement = tap
            injectTap(gesture.startX, gesture.startY)
        } else {
            // Significant movement = swipe
            val elapsed = System.currentTimeMillis() - gesture.startTime
            val duration = elapsed.coerceIn(50, 1000)
            injectSwipe(gesture.startX, gesture.startY, x, y, duration)
        }
    }

    companion object {
        @Volatile
        var instance: TouchInjectionService? = null
            private set

        const val TAP_DURATION_MS = 50L
        const val SWIPE_DURATION_MS = 300L
        const val TAP_THRESHOLD = 20f // pixels — below this, treat as tap

        fun isEnabled(): Boolean = instance != null
    }
}
