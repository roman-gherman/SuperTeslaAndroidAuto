package com.supertesla.aa.service

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import timber.log.Timber
import kotlin.math.pow

/**
 * Manages automatic reconnection with exponential backoff for all connection types.
 */
class ReconnectionManager(private val scope: CoroutineScope) {

    private val jobs = mutableMapOf<String, Job>()

    companion object {
        const val MAX_RETRIES = 15
        const val BASE_DELAY_MS = 1000L
        const val MAX_DELAY_MS = 30000L
    }

    data class ReconnectionState(
        val name: String,
        var retries: Int = 0,
        var isConnected: Boolean = false,
        var lastError: String? = null
    )

    private val states = mutableMapOf<String, ReconnectionState>()
    var onStateChanged: ((ReconnectionState) -> Unit)? = null

    /**
     * Start monitoring a connection and auto-reconnect on failure.
     */
    fun monitor(
        name: String,
        connect: suspend () -> Unit,
        isConnected: () -> Boolean,
        onDisconnect: (() -> Unit)? = null
    ) {
        cancel(name)
        val state = ReconnectionState(name)
        states[name] = state

        jobs[name] = scope.launch {
            var retries = 0

            while (isActive && retries < MAX_RETRIES) {
                try {
                    Timber.d("[$name] Connecting (attempt ${retries + 1})...")
                    connect()
                    retries = 0
                    state.retries = 0
                    state.isConnected = true
                    state.lastError = null
                    onStateChanged?.invoke(state)

                    // Poll connection health
                    while (isActive && isConnected()) {
                        delay(2000)
                    }

                    // Connection lost
                    state.isConnected = false
                    onStateChanged?.invoke(state)
                    onDisconnect?.invoke()
                    Timber.w("[$name] Connection lost, will reconnect...")

                } catch (e: Exception) {
                    retries++
                    state.retries = retries
                    state.isConnected = false
                    state.lastError = e.message
                    onStateChanged?.invoke(state)

                    if (retries >= MAX_RETRIES) {
                        Timber.e("[$name] Max retries ($MAX_RETRIES) exceeded")
                        break
                    }

                    val delayMs = (BASE_DELAY_MS * 2.0.pow(retries.coerceAtMost(10)))
                        .toLong().coerceAtMost(MAX_DELAY_MS)
                    Timber.w("[$name] Reconnecting in ${delayMs}ms (attempt $retries): ${e.message}")
                    delay(delayMs)
                }
            }
        }
    }

    fun cancel(name: String) {
        jobs[name]?.cancel()
        jobs.remove(name)
        states.remove(name)
    }

    fun cancelAll() {
        jobs.values.forEach { it.cancel() }
        jobs.clear()
        states.clear()
    }

    fun getState(name: String): ReconnectionState? = states[name]
    fun isConnected(name: String): Boolean = states[name]?.isConnected ?: false
}
