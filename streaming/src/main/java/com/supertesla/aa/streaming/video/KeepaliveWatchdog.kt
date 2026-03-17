package com.supertesla.aa.streaming.video

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Timer that fires [onTimeout] if [reset] is not called within [timeoutMs].
 * Used to detect browser disconnect — if no PING arrives within 3 seconds,
 * video focus is automatically disabled.
 */
class KeepaliveWatchdog(
    private val scope: CoroutineScope,
    private val timeoutMs: Long = 3000L,
    private val onTimeout: () -> Unit
) {
    private var job: Job? = null

    fun start() {
        job?.cancel()
        job = scope.launch {
            delay(timeoutMs)
            onTimeout()
        }
    }

    fun reset() {
        start() // cancel old, start new
    }

    fun cancel() {
        job?.cancel()
        job = null
    }
}
