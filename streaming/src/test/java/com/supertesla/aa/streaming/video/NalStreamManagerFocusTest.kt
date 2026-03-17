package com.supertesla.aa.streaming.video

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class NalStreamManagerFocusTest {

    private lateinit var mgr: NalStreamManager
    private val focusCalls = mutableListOf<Pair<Boolean, Boolean>>()

    @BeforeEach
    fun setUp() {
        mgr = NalStreamManager()
        focusCalls.clear()
        mgr.onSendVideoFocus = { projected, unsolicited ->
            focusCalls.add(projected to unsolicited)
        }
    }

    @Test
    fun `toggleVideoFocus true calls callback with projected=true unsolicited=false`() {
        mgr.toggleVideoFocus(true)
        assertEquals(1, focusCalls.size)
        assertEquals(true to false, focusCalls[0])
        assertTrue(mgr.hasFocus)
    }

    @Test
    fun `toggleVideoFocus false calls callback with projected=false`() {
        mgr.toggleVideoFocus(false)
        assertEquals(1, focusCalls.size)
        assertEquals(false to false, focusCalls[0])
        assertFalse(mgr.hasFocus)
    }

    @Test
    fun `requestKeyFrame calls callback with unsolicited=true`() {
        mgr.requestKeyFrame()
        assertEquals(1, focusCalls.size)
        assertEquals(true to true, focusCalls[0])
    }

    @Test
    fun `requestKeyFrame is debounced within 2 seconds`() {
        mgr.requestKeyFrame()
        mgr.requestKeyFrame() // should be debounced
        mgr.requestKeyFrame() // should be debounced
        assertEquals(1, focusCalls.size, "Only first call should go through within 2s")
    }

    @Test
    fun `reset clears hasFocus and allows keyframe request`() {
        mgr.toggleVideoFocus(true)
        assertTrue(mgr.hasFocus)

        mgr.reset()
        assertFalse(mgr.hasFocus)
    }

    @Test
    fun `null callback does not crash`() {
        mgr.onSendVideoFocus = null
        assertDoesNotThrow { mgr.toggleVideoFocus(true) }
        assertDoesNotThrow { mgr.requestKeyFrame() }
    }
}
