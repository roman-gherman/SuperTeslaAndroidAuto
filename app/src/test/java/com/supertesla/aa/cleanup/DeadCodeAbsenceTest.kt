package com.supertesla.aa.cleanup

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

/**
 * These tests PASS only when dead code has been deleted.
 * Each test uses Class.forName to verify a class no longer exists on the classpath.
 */
class DeadCodeAbsenceTest {

    @Test
    fun `MainService should not exist`() {
        assertThrows<ClassNotFoundException> {
            Class.forName("com.supertesla.aa.service.MainService")
        }
    }

    @Test
    fun `TouchInjectionService should not exist`() {
        assertThrows<ClassNotFoundException> {
            Class.forName("com.supertesla.aa.service.TouchInjectionService")
        }
    }

    @Test
    fun `BatteryOptimizer should not exist`() {
        assertThrows<ClassNotFoundException> {
            Class.forName("com.supertesla.aa.service.BatteryOptimizer")
        }
    }

    @Test
    fun `ReconnectionManager should not exist`() {
        assertThrows<ClassNotFoundException> {
            Class.forName("com.supertesla.aa.service.ReconnectionManager")
        }
    }

    @Test
    fun `AudioFocusManager should not exist`() {
        assertThrows<ClassNotFoundException> {
            Class.forName("com.supertesla.aa.androidauto.channels.AudioFocusManager")
        }
    }
}
