package com.supertesla.aa.network.protocol

import java.nio.ByteBuffer
import java.nio.ByteOrder

/**
 * Decodes TaaDa-compatible binary touch events.
 *
 * Wire format (big-endian):
 * ```
 * Byte 0:       action (0=DOWN, 1=MOVE, 2=UP, 3=TOUCH)
 * Byte 1:       touchCount
 * Per touch:    id(uint16) + x(uint16) + y(uint16) = 6 bytes
 * Next byte:    allTouchCount
 * Per allTouch: id(uint16) + x(uint16) + y(uint16) = 6 bytes
 * Last 4 bytes: timestamp delta (uint32)
 * ```
 */
object BinaryTouchDecoder {

    data class TouchPoint(val id: Int, val x: Int, val y: Int)

    data class DecodedTouch(
        val action: Int,
        val touches: List<TouchPoint>,
        val allTouches: List<TouchPoint>,
        val timestampDelta: Long
    )

    /**
     * Detect if data is in binary touch format.
     * Checks: length >= 8, action <= 3, touchCount <= 10.
     */
    fun isBinaryFormat(data: ByteArray): Boolean {
        if (data.size < 8) return false
        val action = data[0].toInt() and 0xFF
        val touchCount = data[1].toInt() and 0xFF
        return action <= 3 && touchCount <= 10
    }

    /**
     * Decode binary touch data into structured form.
     */
    fun decode(data: ByteArray): DecodedTouch {
        val buf = ByteBuffer.wrap(data).order(ByteOrder.BIG_ENDIAN)

        val action = buf.get().toInt() and 0xFF
        val touchCount = buf.get().toInt() and 0xFF

        val touches = (0 until touchCount).map {
            TouchPoint(
                id = buf.short.toInt() and 0xFFFF,
                x = buf.short.toInt() and 0xFFFF,
                y = buf.short.toInt() and 0xFFFF
            )
        }

        val allTouchCount = buf.get().toInt() and 0xFF
        val allTouches = (0 until allTouchCount).map {
            TouchPoint(
                id = buf.short.toInt() and 0xFFFF,
                x = buf.short.toInt() and 0xFFFF,
                y = buf.short.toInt() and 0xFFFF
            )
        }

        val timestampDelta = if (buf.remaining() >= 4) buf.int.toLong() and 0xFFFFFFFFL else 0L

        return DecodedTouch(action, touches, allTouches, timestampDelta)
    }
}
