package com.supertesla.aa.core.util

import kotlinx.coroutines.delay

/**
 * Notifies WebSocket clients before service shutdown.
 * Matches TaaDa's {"type":"server_shutdown","reason":"service_stopping"} message.
 */
class ShutdownNotifier(
    private val broadcast: (String) -> Unit,
    private val drainDelayMs: Long = 500L
) {
    /**
     * Send shutdown notification and wait for clients to receive it.
     */
    suspend fun notifyAndDrain(reason: String = "service_stopping") {
        try {
            val json = """{"type":"server_shutdown","reason":"$reason","timestamp":${System.currentTimeMillis()}}"""
            broadcast(json)
        } catch (_: Exception) { }
        delay(drainDelayMs)
    }
}
