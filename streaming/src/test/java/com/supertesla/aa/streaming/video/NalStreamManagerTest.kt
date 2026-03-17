package com.supertesla.aa.streaming.video

import app.cash.turbine.test
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class NalStreamManagerTest {

    private lateinit var mgr: NalStreamManager

    @BeforeEach
    fun setUp() {
        mgr = NalStreamManager()
    }

    @Test
    fun `indicator 3 (complete) emits frame immediately`() = runTest {
        mgr.videoFrames.test {
            val header = ByteArray(10)
            val nalData = byteArrayOf(0, 0, 0, 1, 0x65.toByte())
            val data = header + nalData

            mgr.buildNal(3, data, data.size, false)

            val frame = awaitItem()
            assertArrayEquals(nalData, frame.data)
        }
    }

    @Test
    fun `indicator 3 codec config skips 2-byte header`() = runTest {
        mgr.videoFrames.test {
            val header = byteArrayOf(0, 0)
            val nalData = byteArrayOf(0, 0, 0, 1, 0x67.toByte())
            val data = header + nalData

            mgr.buildNal(3, data, data.size, true)

            val frame = awaitItem()
            assertArrayEquals(nalData, frame.data)
        }
    }

    @Test
    fun `indicator 1-0-2 reassembles fragments`() = runTest {
        mgr.videoFrames.test {
            // Start (indicator=1): 10-byte header + part1
            val part1 = byteArrayOf(1, 2, 3)
            val startData = ByteArray(10) + part1
            mgr.buildNal(1, startData, startData.size, false)

            // Continuation (indicator=0): raw, no header skip for continuation
            // Note: indicator 0 still applies the header offset
            val part2Header = ByteArray(10) + byteArrayOf(4, 5, 6)
            mgr.buildNal(0, part2Header, part2Header.size, false)

            // End (indicator=2): raw with header
            val part3Header = ByteArray(10) + byteArrayOf(7, 8, 9)
            mgr.buildNal(2, part3Header, part3Header.size, false)

            val frame = awaitItem()
            assertArrayEquals(byteArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9), frame.data)
        }
    }

    @Test
    fun `reset clears buffer and frame count`() {
        mgr.reset()
        assertFalse(mgr.hasFocus)
    }

    @Test
    fun `unknown indicator does not crash`() {
        assertDoesNotThrow {
            mgr.buildNal(99, ByteArray(20), 20, false)
        }
    }

    @Test
    fun `feedFrame emits via videoFrames`() = runTest {
        mgr.videoFrames.test {
            val data = byteArrayOf(0, 0, 0, 1, 5)
            mgr.feedFrame(data, 12345L)

            val frame = awaitItem()
            assertArrayEquals(data, frame.data)
            assertEquals(12345L, frame.timestamp)
        }
    }
}
