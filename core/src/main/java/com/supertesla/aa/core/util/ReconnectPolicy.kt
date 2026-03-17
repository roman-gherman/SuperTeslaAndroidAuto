package com.supertesla.aa.core.util

/**
 * Reconnection policy with max attempts and configurable delay.
 * Extracted from TransporterService's reconnect loop for testability.
 */
class ReconnectPolicy(
    val maxAttempts: Int = 30,
    val delayMs: Long = 2500L
) {
    var attempts: Int = 0
        private set

    val isExhausted: Boolean get() = attempts >= maxAttempts

    fun recordAttempt() {
        attempts++
    }

    fun reset() {
        attempts = 0
    }
}
