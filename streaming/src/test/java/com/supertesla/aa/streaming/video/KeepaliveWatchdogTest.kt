package com.supertesla.aa.streaming.video

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class KeepaliveWatchdogTest {

    @Test
    fun `timeout fires after default 3 seconds`() = runTest {
        var fired = false
        val watchdog = KeepaliveWatchdog(
            scope = this,
            timeoutMs = 3000L,
            onTimeout = { fired = true }
        )
        watchdog.start()

        advanceTimeBy(2999)
        assertFalse(fired, "Should not fire before 3000ms")

        advanceTimeBy(2)
        assertTrue(fired, "Should fire at 3000ms")

        watchdog.cancel()
    }

    @Test
    fun `reset defers the timeout`() = runTest {
        var fired = false
        val watchdog = KeepaliveWatchdog(
            scope = this,
            timeoutMs = 3000L,
            onTimeout = { fired = true }
        )
        watchdog.start()

        advanceTimeBy(2500)
        assertFalse(fired)

        watchdog.reset() // restart the timer
        advanceTimeBy(2500) // 2500ms after reset, not yet 3000
        assertFalse(fired, "Should not fire — timer was reset")

        advanceTimeBy(600)
        assertTrue(fired, "Should fire 3000ms after reset")

        watchdog.cancel()
    }

    @Test
    fun `cancel prevents timeout`() = runTest {
        var fired = false
        val watchdog = KeepaliveWatchdog(
            scope = this,
            timeoutMs = 3000L,
            onTimeout = { fired = true }
        )
        watchdog.start()

        advanceTimeBy(1000)
        watchdog.cancel()

        advanceTimeBy(5000)
        assertFalse(fired, "Should never fire after cancel")
    }

    @Test
    fun `fires only once per start`() = runTest {
        var count = 0
        val watchdog = KeepaliveWatchdog(
            scope = this,
            timeoutMs = 1000L,
            onTimeout = { count++ }
        )
        watchdog.start()

        advanceTimeBy(5000)
        assertEquals(1, count, "Should fire exactly once")

        watchdog.cancel()
    }
}
