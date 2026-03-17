package com.supertesla.aa.core.util

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MemoryMonitorTest {

    @Test
    fun `check returns a valid status`() {
        val status = MemoryMonitor.check()
        assertTrue(status in MemoryMonitor.Status.values())
    }

    @Test
    fun `check under normal conditions returns OK`() {
        // Under test conditions, heap utilization should be well under 80%
        val status = MemoryMonitor.check()
        assertEquals(MemoryMonitor.Status.OK, status, "Under test conditions should be OK")
    }

    @Test
    fun `Status enum has three values`() {
        assertEquals(3, MemoryMonitor.Status.values().size)
        assertNotNull(MemoryMonitor.Status.OK)
        assertNotNull(MemoryMonitor.Status.WARNING)
        assertNotNull(MemoryMonitor.Status.CRITICAL)
    }
}
