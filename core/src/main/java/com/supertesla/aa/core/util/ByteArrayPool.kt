package com.supertesla.aa.core.util

/**
 * Thread-safe pool of fixed-size byte arrays.
 * Reduces GC pressure during sustained video/audio streaming.
 */
class ByteArrayPool(
    private val maxSize: Int,
    private val bufferSize: Int
) {
    private val pool = ArrayDeque<ByteArray>(maxSize)

    fun acquire(): ByteArray = synchronized(pool) {
        pool.removeLastOrNull() ?: ByteArray(bufferSize)
    }

    fun release(buffer: ByteArray) = synchronized(pool) {
        if (pool.size < maxSize && buffer.size == bufferSize) {
            pool.addLast(buffer)
        }
    }

    val size: Int get() = synchronized(pool) { pool.size }
}
