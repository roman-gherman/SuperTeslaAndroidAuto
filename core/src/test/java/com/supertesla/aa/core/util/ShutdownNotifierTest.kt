package com.supertesla.aa.core.util

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ShutdownNotifierTest {

    @Test
    fun `notifyAndDrain sends JSON with type server_shutdown`() = runTest {
        var sent: String? = null
        val notifier = ShutdownNotifier(broadcast = { sent = it })
        notifier.notifyAndDrain()
        assertNotNull(sent)
        assertTrue(sent!!.contains("server_shutdown"))
        assertTrue(sent!!.contains("service_stopping"))
    }

    @Test
    fun `notifyAndDrain custom reason`() = runTest {
        var sent: String? = null
        val notifier = ShutdownNotifier(broadcast = { sent = it })
        notifier.notifyAndDrain("oom_recovery")
        assertTrue(sent!!.contains("oom_recovery"))
    }

    @Test
    fun `notifyAndDrain broadcasts before delay completes`() = runTest {
        var broadcastCalled = false
        val notifier = ShutdownNotifier(
            broadcast = { broadcastCalled = true },
            drainDelayMs = 500L
        )
        notifier.notifyAndDrain()
        assertTrue(broadcastCalled, "Broadcast should have been called")
    }

    @Test
    fun `throwing broadcaster does not crash`() = runTest {
        val notifier = ShutdownNotifier(broadcast = { throw RuntimeException("dead") })
        notifier.notifyAndDrain() // should not throw
    }
}
