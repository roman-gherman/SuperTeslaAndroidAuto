package com.supertesla.aa.core.util

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ReconnectPolicyTest {

    @Test
    fun `initial state has 0 attempts`() {
        val policy = ReconnectPolicy()
        assertEquals(0, policy.attempts)
        assertFalse(policy.isExhausted)
    }

    @Test
    fun `recordAttempt increments counter`() {
        val policy = ReconnectPolicy()
        policy.recordAttempt()
        assertEquals(1, policy.attempts)
        policy.recordAttempt()
        assertEquals(2, policy.attempts)
    }

    @Test
    fun `isExhausted after max attempts`() {
        val policy = ReconnectPolicy(maxAttempts = 3)
        repeat(3) { policy.recordAttempt() }
        assertTrue(policy.isExhausted)
    }

    @Test
    fun `not exhausted before max`() {
        val policy = ReconnectPolicy(maxAttempts = 30)
        repeat(29) { policy.recordAttempt() }
        assertFalse(policy.isExhausted)
    }

    @Test
    fun `reset clears attempts`() {
        val policy = ReconnectPolicy(maxAttempts = 5)
        repeat(5) { policy.recordAttempt() }
        assertTrue(policy.isExhausted)
        policy.reset()
        assertEquals(0, policy.attempts)
        assertFalse(policy.isExhausted)
    }

    @Test
    fun `default maxAttempts is 30`() {
        assertEquals(30, ReconnectPolicy().maxAttempts)
    }

    @Test
    fun `default delay is 2500ms`() {
        assertEquals(2500L, ReconnectPolicy().delayMs)
    }
}
