package com.supertesla.aa.cleanup

import com.supertesla.aa.service.TransporterService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Verifies TransporterService wake lock configuration constants.
 * The wake lock MUST have a timeout to prevent indefinite battery drain.
 */
class WakeLockConfigTest {

    @Test
    fun `wake lock timeout should be 4 hours`() {
        assertEquals(4L * 60 * 60 * 1000, TransporterService.WAKE_LOCK_TIMEOUT_MS)
    }
}
