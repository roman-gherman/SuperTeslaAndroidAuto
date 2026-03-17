package com.supertesla.aa.core.util

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ByteArrayPoolTest {

    @Test
    fun `acquire from empty pool returns new array of correct size`() {
        val pool = ByteArrayPool(maxSize = 4, bufferSize = 1024)
        val buffer = pool.acquire()
        assertEquals(1024, buffer.size)
    }

    @Test
    fun `release then acquire returns same instance`() {
        val pool = ByteArrayPool(maxSize = 4, bufferSize = 1024)
        val buffer = pool.acquire()
        pool.release(buffer)
        val recycled = pool.acquire()
        assertSame(buffer, recycled, "Should return the same array instance")
    }

    @Test
    fun `pool does not exceed maxSize`() {
        val pool = ByteArrayPool(maxSize = 2, bufferSize = 64)
        val a = pool.acquire()
        val b = pool.acquire()
        val c = pool.acquire()
        pool.release(a)
        pool.release(b)
        pool.release(c) // should be rejected (pool full)
        assertEquals(2, pool.size)
    }

    @Test
    fun `wrong-size buffer is rejected`() {
        val pool = ByteArrayPool(maxSize = 4, bufferSize = 1024)
        pool.release(ByteArray(512)) // wrong size
        assertEquals(0, pool.size, "Should reject buffer with wrong size")
    }

    @Test
    fun `concurrent acquire and release is safe`() {
        val pool = ByteArrayPool(maxSize = 10, bufferSize = 64)
        val threads = (1..100).map {
            Thread {
                val buf = pool.acquire()
                Thread.sleep(1)
                pool.release(buf)
            }
        }
        threads.forEach { it.start() }
        threads.forEach { it.join() }
        assertTrue(pool.size <= 10, "Pool should not exceed maxSize")
    }

    @Test
    fun `multiple acquires without release always return new arrays`() {
        val pool = ByteArrayPool(maxSize = 4, bufferSize = 64)
        val a = pool.acquire()
        val b = pool.acquire()
        assertNotSame(a, b, "Should be distinct arrays when pool is empty")
    }
}
