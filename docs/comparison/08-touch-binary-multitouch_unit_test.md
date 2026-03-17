# 08 — Touch Binary Protocol & Multi-touch: Unit Test Plan

## Overview

Tests cover four areas:

1. **`BinaryTouchDecoder`** (new class) — binary format detection, single-pointer decode,
   multi-pointer decode, edge-case byte values.
2. **`TouchInputRelay`** (existing) — JSON multi-touch action mapping, coordinate clamping,
   pointer-count dispatch.
3. **`InputChannelHandler`** — the new `sendMultiTouchEvent` method and `mapToAaAction` companion
   function.
4. **`ControlSocketServer`** — binary `ByteBuffer` message dispatch to `BinaryTouchDecoder`.

All code is written as compilable Kotlin targeting JUnit 5 and MockK.

---

## Test Classes

| Test Class | File Path | Class Under Test |
|---|---|---|
| `BinaryTouchDecoderTest` | `network/src/test/java/com/supertesla/aa/network/protocol/BinaryTouchDecoderTest.kt` | `BinaryTouchDecoder` (new) |
| `TouchInputRelayMultiTouchTest` | `network/src/test/java/com/supertesla/aa/network/websocket/TouchInputRelayMultiTouchTest.kt` | `TouchInputRelay` |
| `InputChannelHandlerMultiTouchTest` | `androidauto/src/test/java/com/supertesla/aa/androidauto/channels/InputChannelHandlerMultiTouchTest.kt` | `InputChannelHandler` |
| `ControlSocketBinaryTouchTest` | `network/src/test/java/com/supertesla/aa/network/relay/ControlSocketBinaryTouchTest.kt` | `ControlSocketServer` |

---

## Binary format reference

```
Byte 0:         action       (uint8  — 0=DOWN, 1=MOVE, 2=UP, 3=TOUCH)
Byte 1:         touchCount   (uint8  — number of changed pointers)
Per touch:      id(uint16 BE) + x(uint16 BE) + y(uint16 BE)  = 6 bytes each
Byte N:         allTouchCount (uint8 — total currently-down pointers)
Per allTouch:   id(uint16 BE) + x(uint16 BE) + y(uint16 BE)  = 6 bytes each
Last 4 bytes:   timestamp delta (uint32 BE)
```

Detection rule: `data.size >= 8 && action <= 3 && touchCount <= 10`

---

## Shared test helper

File: `network/src/test/java/com/supertesla/aa/network/protocol/BinaryTouchTestUtils.kt`

```kotlin
package com.supertesla.aa.network.protocol

import java.nio.ByteBuffer
import java.nio.ByteOrder

/**
 * Builds a correctly-structured binary touch message.
 *
 * @param action         0=DOWN, 1=MOVE, 2=UP, 3=TOUCH
 * @param touches        changed pointers as list of Triple(id, x, y)
 * @param allTouches     all currently-down pointers as list of Triple(id, x, y)
 * @param timestampDelta uint32 timestamp delta (millis since last event)
 */
fun buildBinaryTouch(
    action: Int,
    touches: List<Triple<Int, Int, Int>>,
    allTouches: List<Triple<Int, Int, Int>>,
    timestampDelta: Long = 0L
): ByteArray {
    val size = 1 + 1 + touches.size * 6 + 1 + allTouches.size * 6 + 4
    val buf  = ByteBuffer.allocate(size).order(ByteOrder.BIG_ENDIAN)
    buf.put(action.toByte())
    buf.put(touches.size.toByte())
    for ((id, x, y) in touches) {
        buf.putShort(id.toShort())
        buf.putShort(x.toShort())
        buf.putShort(y.toShort())
    }
    buf.put(allTouches.size.toByte())
    for ((id, x, y) in allTouches) {
        buf.putShort(id.toShort())
        buf.putShort(x.toShort())
        buf.putShort(y.toShort())
    }
    buf.putInt(timestampDelta.toInt())
    return buf.array()
}
```

---

## BinaryTouchDecoderTest

`BinaryTouchDecoder` does not exist yet.  Expected location:
`network/src/main/java/com/supertesla/aa/network/protocol/BinaryTouchDecoder.kt`

Expected API:

```kotlin
object BinaryTouchDecoder {
    data class TouchPoint(val id: Int, val x: Int, val y: Int)
    data class DecodedTouch(
        val action: Int,
        val touches: List<TouchPoint>,
        val allTouches: List<TouchPoint>
    )
    fun isBinaryFormat(data: ByteArray): Boolean
    fun decode(data: ByteArray): DecodedTouch
}
```

File: `network/src/test/java/com/supertesla/aa/network/protocol/BinaryTouchDecoderTest.kt`

```kotlin
package com.supertesla.aa.network.protocol

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BinaryTouchDecoderTest {

    // =========================================================================
    // isBinaryFormat
    // =========================================================================

    @Test
    fun `isBinaryFormat returns true for a valid 8-byte DOWN message`() {
        val data = byteArrayOf(
            0x00,                // action = DOWN (0)
            0x01,                // touchCount = 1
            0x00, 0x00,          // id = 0
            0x00, 0x64,          // x = 100
            0x00, 0xC8.toByte()  // y = 200  (8 bytes)
        )
        assertTrue(BinaryTouchDecoder.isBinaryFormat(data))
    }

    @Test
    fun `isBinaryFormat returns false for data shorter than 8 bytes`() {
        val short = byteArrayOf(0x00, 0x01, 0x00, 0x00, 0x00, 0x64, 0x00) // 7 bytes
        assertFalse(BinaryTouchDecoder.isBinaryFormat(short))
    }

    @Test
    fun `isBinaryFormat returns false for empty array`() {
        assertFalse(BinaryTouchDecoder.isBinaryFormat(ByteArray(0)))
    }

    @Test
    fun `isBinaryFormat returns false when action byte is 4 (out of range)`() {
        val data = ByteArray(8)
        data[0] = 0x04   // invalid action
        assertFalse(BinaryTouchDecoder.isBinaryFormat(data))
    }

    @Test
    fun `isBinaryFormat returns false when action byte is 255`() {
        val data = ByteArray(8)
        data[0] = 0xFF.toByte()
        assertFalse(BinaryTouchDecoder.isBinaryFormat(data))
    }

    @Test
    fun `isBinaryFormat returns false when touchCount is 11 (exceeds 10)`() {
        val data = ByteArray(8)
        data[0] = 0x00
        data[1] = 0x0B   // 11
        assertFalse(BinaryTouchDecoder.isBinaryFormat(data))
    }

    @Test
    fun `isBinaryFormat returns true for action=3 (TOUCH) with touchCount=0`() {
        val data = ByteArray(8)
        data[0] = 0x03   // TOUCH
        data[1] = 0x00   // count = 0
        assertTrue(BinaryTouchDecoder.isBinaryFormat(data))
    }

    @Test
    fun `isBinaryFormat returns true for action=2 (UP) with touchCount=10 (max)`() {
        val data = ByteArray(8)
        data[0] = 0x02   // UP
        data[1] = 0x0A   // 10
        assertTrue(BinaryTouchDecoder.isBinaryFormat(data))
    }

    // =========================================================================
    // decode — single pointer
    // =========================================================================

    @Test
    fun `decode parses action from byte 0`() {
        val data = byteArrayOf(
            0x01,                // MOVE
            0x01,
            0x00, 0x00,
            0x00, 0x0A,
            0x00, 0x14,
            0x01,
            0x00, 0x00,
            0x00, 0x0A,
            0x00, 0x14,
            0x00, 0x00, 0x00, 0x00
        )
        assertEquals(1, BinaryTouchDecoder.decode(data).action)
    }

    @Test
    fun `decode single pointer DOWN event — full 19-byte message`() {
        // action=0, touchCount=1, touch=(id=0, x=100, y=200),
        // allTouchCount=1, allTouch=(id=0, x=100, y=200), timestamp=10
        val data = byteArrayOf(
            0x00,                // DOWN
            0x01,                // touchCount = 1
            0x00, 0x00,          // touch id = 0
            0x00, 0x64,          // touch x = 100
            0x00, 0xC8.toByte(), // touch y = 200
            0x01,                // allTouchCount = 1
            0x00, 0x00,          // allTouch id = 0
            0x00, 0x64,          // allTouch x = 100
            0x00, 0xC8.toByte(), // allTouch y = 200
            0x00, 0x00, 0x00, 0x0A // timestamp = 10
        )

        val decoded = BinaryTouchDecoder.decode(data)

        assertEquals(0, decoded.action)
        assertEquals(1, decoded.touches.size)
        assertEquals(0, decoded.touches[0].id)
        assertEquals(100, decoded.touches[0].x)
        assertEquals(200, decoded.touches[0].y)
        assertEquals(1, decoded.allTouches.size)
        assertEquals(100, decoded.allTouches[0].x)
        assertEquals(200, decoded.allTouches[0].y)
    }

    @Test
    fun `decode UP event with zero remaining allTouches`() {
        // action=2, 1 touch, 0 allTouches
        val data = byteArrayOf(
            0x02,                // UP
            0x01,                // touchCount = 1
            0x00, 0x00,          // id = 0
            0x01, 0xF4.toByte(), // x = 500
            0x01, 0x2C,          // y = 300
            0x00,                // allTouchCount = 0
            0x00, 0x00, 0x00, 0x01 // timestamp = 1
        )

        val decoded = BinaryTouchDecoder.decode(data)

        assertEquals(2, decoded.action)
        assertEquals(1, decoded.touches.size)
        assertEquals(0, decoded.allTouches.size)
    }

    // =========================================================================
    // decode — multiple pointers (using buildBinaryTouch helper)
    // =========================================================================

    @Test
    fun `decode MOVE event with two changed pointers`() {
        val data = buildBinaryTouch(
            action     = 1,
            touches    = listOf(Triple(0, 10, 20), Triple(1, 30, 40)),
            allTouches = listOf(Triple(0, 10, 20), Triple(1, 30, 40)),
            timestampDelta = 5L
        )

        val decoded = BinaryTouchDecoder.decode(data)

        assertEquals(1, decoded.action)
        assertEquals(2, decoded.touches.size)
        assertEquals(0, decoded.touches[0].id)
        assertEquals(10, decoded.touches[0].x)
        assertEquals(20, decoded.touches[0].y)
        assertEquals(1, decoded.touches[1].id)
        assertEquals(30, decoded.touches[1].x)
        assertEquals(40, decoded.touches[1].y)
    }

    @Test
    fun `decode 10 simultaneous pointers`() {
        val pointers = (0..9).map { i -> Triple(i, i * 100, i * 50) }
        val data = buildBinaryTouch(
            action     = 1,
            touches    = pointers,
            allTouches = pointers,
            timestampDelta = 100L
        )

        val decoded = BinaryTouchDecoder.decode(data)

        assertEquals(10, decoded.touches.size)
        assertEquals(10, decoded.allTouches.size)
        for (i in 0..9) {
            assertEquals(i,       decoded.touches[i].id,  "id mismatch at index $i")
            assertEquals(i * 100, decoded.touches[i].x,   "x mismatch at index $i")
            assertEquals(i * 50,  decoded.touches[i].y,   "y mismatch at index $i")
        }
    }

    // =========================================================================
    // decode — edge-case values
    // =========================================================================

    @Test
    fun `decode handles maximum uint16 coordinate values (65535)`() {
        val data = byteArrayOf(
            0x00,                          // DOWN
            0x01,
            0x00, 0x00,                    // id = 0
            0xFF.toByte(), 0xFF.toByte(),  // x = 65535
            0xFF.toByte(), 0xFF.toByte(),  // y = 65535
            0x00,                          // allTouchCount = 0
            0x00, 0x00, 0x00, 0x00         // timestamp = 0
        )

        val decoded = BinaryTouchDecoder.decode(data)

        assertEquals(65535, decoded.touches[0].x)
        assertEquals(65535, decoded.touches[0].y)
    }

    @Test
    fun `decode handles pointer id encoded as uint16 big-endian (id=256 = 0x0100)`() {
        val data = buildBinaryTouch(
            action     = 0,
            touches    = listOf(Triple(256, 100, 100)),
            allTouches = listOf(Triple(256, 100, 100))
        )

        assertEquals(256, BinaryTouchDecoder.decode(data).touches[0].id)
    }

    @Test
    fun `decode handles zero-touch zero-allTouch message`() {
        // Minimal: action(1) + touchCount(1)=0 + allTouchCount(1)=0 + timestamp(4)
        val data = byteArrayOf(0x03, 0x00, 0x00, 0x00, 0x00, 0x00)
        // Pad to >= 8 for isBinaryFormat, but decode must work on 6 bytes too
        // (isBinaryFormat check is separate from decode)
        val decoded = BinaryTouchDecoder.decode(data)
        assertEquals(3, decoded.action)
        assertTrue(decoded.touches.isEmpty())
        assertTrue(decoded.allTouches.isEmpty())
    }
}
```

### Green Phase for BinaryTouchDecoder

Minimum implementation:

```kotlin
package com.supertesla.aa.network.protocol

object BinaryTouchDecoder {

    data class TouchPoint(val id: Int, val x: Int, val y: Int)
    data class DecodedTouch(
        val action: Int,
        val touches: List<TouchPoint>,
        val allTouches: List<TouchPoint>
    )

    fun isBinaryFormat(data: ByteArray): Boolean =
        data.size >= 8
            && (data[0].toInt() and 0xFF) <= 3
            && (data[1].toInt() and 0xFF) <= 10

    fun decode(data: ByteArray): DecodedTouch {
        var offset = 0
        val action     = data[offset++].toInt() and 0xFF
        val touchCount = data[offset++].toInt() and 0xFF
        val touches    = readPoints(data, offset, touchCount)
        offset += touchCount * 6
        val allCount   = data[offset++].toInt() and 0xFF
        val allTouches = readPoints(data, offset, allCount)
        return DecodedTouch(action, touches, allTouches)
    }

    private fun readPoints(data: ByteArray, start: Int, count: Int): List<TouchPoint> =
        (0 until count).map { i ->
            val base = start + i * 6
            TouchPoint(
                id = uint16BE(data, base),
                x  = uint16BE(data, base + 2),
                y  = uint16BE(data, base + 4)
            )
        }

    private fun uint16BE(data: ByteArray, offset: Int): Int =
        ((data[offset].toInt() and 0xFF) shl 8) or (data[offset + 1].toInt() and 0xFF)
}
```

---

## TouchInputRelayMultiTouchTest

File: `network/src/test/java/com/supertesla/aa/network/websocket/TouchInputRelayMultiTouchTest.kt`

```kotlin
package com.supertesla.aa.network.websocket

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TouchInputRelayMultiTouchTest {

    private lateinit var relay: TouchInputRelay
    private val calls = mutableListOf<IntArray>() // [action, x, y, pointerId]

    @BeforeEach
    fun setUp() {
        relay = TouchInputRelay(displayWidth = 1280, displayHeight = 720)
        calls.clear()
        relay.setTouchListener(object : TouchInputRelay.TouchListener {
            override fun onTouch(action: Int, x: Int, y: Int, pointerId: Int) {
                calls.add(intArrayOf(action, x, y, pointerId))
            }
        })
    }

    // =========================================================================
    // MULTITOUCH action mapping
    // =========================================================================

    @Test
    fun `MULTITOUCH_DOWN triggers ACTION_DOWN (0)`() {
        relay.handleMessage(
            """{"action":"MULTITOUCH_DOWN","touches":[{"id":0,"x":640,"y":360}],""" +
            """"allTouches":[{"id":0,"x":640,"y":360}]}"""
        )
        assertEquals(TouchInputRelay.ACTION_DOWN, calls.single()[0])
    }

    @Test
    fun `MULTITOUCH_UP triggers ACTION_UP (1)`() {
        relay.handleMessage(
            """{"action":"MULTITOUCH_UP","touches":[{"id":0,"x":640,"y":360}],""" +
            """"allTouches":[]}"""
        )
        assertEquals(TouchInputRelay.ACTION_UP, calls.single()[0])
    }

    @Test
    fun `MULTITOUCH_CANCEL maps to ACTION_UP (1)`() {
        relay.handleMessage(
            """{"action":"MULTITOUCH_CANCEL","touches":[{"id":0,"x":0,"y":0}],""" +
            """"allTouches":[]}"""
        )
        assertEquals(TouchInputRelay.ACTION_UP, calls.single()[0])
    }

    @Test
    fun `MULTITOUCH_MOVE triggers ACTION_MOVE (2)`() {
        relay.handleMessage(
            """{"action":"MULTITOUCH_MOVE","touches":[{"id":0,"x":500,"y":300}],""" +
            """"allTouches":[{"id":0,"x":500,"y":300}]}"""
        )
        assertEquals(TouchInputRelay.ACTION_MOVE, calls.single()[0])
    }

    // =========================================================================
    // allTouches preferred over touches when non-empty
    // =========================================================================

    @Test
    fun `allTouches list is dispatched in preference to touches when non-empty`() {
        relay.handleMessage(
            """{"action":"MULTITOUCH_MOVE",""" +
            """"touches":[{"id":0,"x":200,"y":100}],""" +
            """"allTouches":[{"id":0,"x":200,"y":100},{"id":1,"x":400,"y":200}]}"""
        )
        // Two allTouches → two listener calls
        assertEquals(2, calls.size)
        assertEquals(200, calls[0][1])  // first allTouch x
        assertEquals(400, calls[1][1])  // second allTouch x
    }

    @Test
    fun `touches list is used as fallback when allTouches is empty`() {
        relay.handleMessage(
            """{"action":"MULTITOUCH_DOWN",""" +
            """"touches":[{"id":0,"x":100,"y":50}],""" +
            """"allTouches":[]}"""
        )
        assertEquals(1, calls.size)
        assertEquals(100, calls[0][1])
    }

    // =========================================================================
    // Coordinate handling — pixel passthrough
    // =========================================================================

    @Test
    fun `MULTITOUCH pixel coordinates arrive at listener unchanged`() {
        relay.handleMessage(
            """{"action":"MULTITOUCH_DOWN",""" +
            """"touches":[{"id":0,"x":640,"y":360}],""" +
            """"allTouches":[{"id":0,"x":640,"y":360}]}"""
        )
        assertEquals(640, calls.single()[1])
        assertEquals(360, calls.single()[2])
    }

    // =========================================================================
    // Coordinate clamping
    // =========================================================================

    @Test
    fun `x coordinate beyond displayWidth is clamped to displayWidth - 1`() {
        relay.handleMessage(
            """{"action":"MULTITOUCH_DOWN",""" +
            """"touches":[{"id":0,"x":9999,"y":100}],""" +
            """"allTouches":[{"id":0,"x":9999,"y":100}]}"""
        )
        assertEquals(1279, calls.single()[1], "x must be clamped to 1280-1")
    }

    @Test
    fun `y coordinate beyond displayHeight is clamped to displayHeight - 1`() {
        relay.handleMessage(
            """{"action":"MULTITOUCH_DOWN",""" +
            """"touches":[{"id":0,"x":100,"y":9999}],""" +
            """"allTouches":[{"id":0,"x":100,"y":9999}]}"""
        )
        assertEquals(719, calls.single()[2], "y must be clamped to 720-1")
    }

    @Test
    fun `negative x coordinate is clamped to 0`() {
        relay.handleMessage(
            """{"action":"MULTITOUCH_DOWN",""" +
            """"touches":[{"id":0,"x":-100,"y":100}],""" +
            """"allTouches":[{"id":0,"x":-100,"y":100}]}"""
        )
        assertEquals(0, calls.single()[1])
    }

    @Test
    fun `negative y coordinate is clamped to 0`() {
        relay.handleMessage(
            """{"action":"MULTITOUCH_DOWN",""" +
            """"touches":[{"id":0,"x":100,"y":-50}],""" +
            """"allTouches":[{"id":0,"x":100,"y":-50}]}"""
        )
        assertEquals(0, calls.single()[2])
    }

    // =========================================================================
    // Pointer ID forwarding
    // =========================================================================

    @Test
    fun `pointer id is forwarded correctly to listener`() {
        relay.handleMessage(
            """{"action":"MULTITOUCH_DOWN",""" +
            """"touches":[{"id":5,"x":100,"y":100}],""" +
            """"allTouches":[{"id":5,"x":100,"y":100}]}"""
        )
        assertEquals(5, calls.single()[3])
    }

    // =========================================================================
    // handleMessage return value
    // =========================================================================

    @Test
    fun `handleMessage returns true for valid MULTITOUCH_DOWN`() {
        val handled = relay.handleMessage(
            """{"action":"MULTITOUCH_DOWN","touches":[{"id":0,"x":0,"y":0}],"allTouches":[]}"""
        )
        assertTrue(handled)
    }

    @Test
    fun `handleMessage returns false for malformed JSON`() {
        assertFalse(relay.handleMessage("not json at all"))
    }

    @Test
    fun `handleMessage returns false for unknown MULTITOUCH action`() {
        assertFalse(relay.handleMessage(
            """{"action":"MULTITOUCH_PINCH","touches":[],"allTouches":[]}"""
        ))
    }

    @Test
    fun `handleMessage returns false for message with no action field`() {
        assertFalse(relay.handleMessage("""{"x":100,"y":200}"""))
    }

    // =========================================================================
    // Simple touch format (normalised coordinates)
    // =========================================================================

    @Test
    fun `simple touch format with action=down triggers ACTION_DOWN`() {
        relay.handleMessage(
            """{"type":"touch","action":"down","x":0.5,"y":0.5,"pointerId":0}"""
        )
        assertEquals(TouchInputRelay.ACTION_DOWN, calls.single()[0])
    }

    @Test
    fun `simple touch normalised x=0 dot 5 maps to displayWidth divided by 2`() {
        relay.handleMessage(
            """{"type":"touch","action":"down","x":0.5,"y":0.0,"pointerId":0}"""
        )
        // 0.5 * 1280 = 640
        assertEquals(640, calls.single()[1])
    }

    @Test
    fun `simple touch normalised y=1 dot 0 maps to displayHeight - 1 after clamping`() {
        relay.handleMessage(
            """{"type":"touch","action":"down","x":0.0,"y":1.0,"pointerId":0}"""
        )
        // 1.0 * 720 = 720, clamped to 719
        assertEquals(719, calls.single()[2])
    }

    @Test
    fun `simple touch format with action=up triggers ACTION_UP`() {
        relay.handleMessage(
            """{"type":"touch","action":"up","x":0.5,"y":0.5,"pointerId":0}"""
        )
        assertEquals(TouchInputRelay.ACTION_UP, calls.single()[0])
    }

    @Test
    fun `simple touch format with action=move triggers ACTION_MOVE`() {
        relay.handleMessage(
            """{"type":"touch","action":"move","x":0.5,"y":0.5,"pointerId":0}"""
        )
        assertEquals(TouchInputRelay.ACTION_MOVE, calls.single()[0])
    }
}
```

---

## InputChannelHandlerMultiTouchTest

File: `androidauto/src/test/java/com/supertesla/aa/androidauto/channels/InputChannelHandlerMultiTouchTest.kt`

`sendMultiTouchEvent`, `TouchPointer`, and `mapToAaAction` do not yet exist.  All tests are RED
until the implementation is added.

```kotlin
package com.supertesla.aa.androidauto.channels

import com.supertesla.aa.androidauto.proto.ChannelId
import com.supertesla.aa.androidauto.proto.InputMessageType
import com.supertesla.aa.androidauto.proto.ProtoEncoder
import com.supertesla.aa.androidauto.protocol.ChannelMux
import io.mockk.any
import io.mockk.eq
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class InputChannelHandlerMultiTouchTest {

    private val mockMux = mockk<ChannelMux>(relaxed = true)
    private val handler = InputChannelHandler(mockMux, displayWidth = 1280, displayHeight = 720)

    // -------------------------------------------------------------------------
    // Helpers: decode captured protobuf from ChannelMux.sendEncrypted
    // -------------------------------------------------------------------------

    private fun capturePayload(): ByteArray {
        val slot = slot<ByteArray>()
        verify { mockMux.sendEncrypted(any(), any(), capture(slot)) }
        return slot.captured
    }

    private fun touchEventBytes(payload: ByteArray): ByteArray {
        val topFields = ProtoEncoder.readFields(payload)
        return topFields.first { it.fieldNumber == 3 && it.wireType == 2 }.bytesValue!!
    }

    private fun pointerDataBytes(touchEvent: ByteArray, index: Int): ByteArray {
        val fields = ProtoEncoder.readFields(touchEvent)
        val allPointers = fields.filter { it.fieldNumber == 1 && it.wireType == 2 }
        return allPointers[index].bytesValue!!
    }

    // =========================================================================
    // Top-level InputReport fields
    // =========================================================================

    @Test
    fun `sendMultiTouchEvent encodes a positive nanosecond timestamp in field 1`() {
        handler.sendMultiTouchEvent(
            action      = 0,
            actionIndex = 0,
            pointers    = listOf(InputChannelHandler.TouchPointer(0, 0, 0))
        )

        val payload = capturePayload()
        val ts = ProtoEncoder.readFields(payload).first { it.fieldNumber == 1 }.varintValue
        assertTrue(ts > 0L, "Timestamp must be a positive nanosecond value, got $ts")
    }

    @Test
    fun `sendMultiTouchEvent encodes disp_channel_id = VIDEO (3) in field 2`() {
        handler.sendMultiTouchEvent(0, 0,
            listOf(InputChannelHandler.TouchPointer(0, 0, 0)))

        val payload  = capturePayload()
        val chanId   = ProtoEncoder.readFields(payload).first { it.fieldNumber == 2 }.intValue
        assertEquals(ChannelId.VIDEO, chanId)
    }

    // =========================================================================
    // Pointer data inside touch_event (field 3)
    // =========================================================================

    @Test
    fun `sendMultiTouchEvent encodes a single pointer in touch_event field 3`() {
        handler.sendMultiTouchEvent(0, 0,
            listOf(InputChannelHandler.TouchPointer(id = 3, x = 750, y = 400)))

        val touchEvent = touchEventBytes(capturePayload())
        val pointers   = ProtoEncoder.readFields(touchEvent)
            .filter { it.fieldNumber == 1 && it.wireType == 2 }
        assertEquals(1, pointers.size)
    }

    @Test
    fun `sendMultiTouchEvent encodes two pointers in touch_event`() {
        handler.sendMultiTouchEvent(2, 0, listOf(
            InputChannelHandler.TouchPointer(0, 100, 200),
            InputChannelHandler.TouchPointer(1, 300, 400)
        ))

        val touchEvent = touchEventBytes(capturePayload())
        val pointers   = ProtoEncoder.readFields(touchEvent)
            .filter { it.fieldNumber == 1 && it.wireType == 2 }
        assertEquals(2, pointers.size)
    }

    @Test
    fun `sendMultiTouchEvent encodes pointer x in pointer_data field 1`() {
        handler.sendMultiTouchEvent(0, 0,
            listOf(InputChannelHandler.TouchPointer(id = 0, x = 750, y = 400)))

        val te = touchEventBytes(capturePayload())
        val pd = pointerDataBytes(te, 0)
        val x  = ProtoEncoder.readFields(pd).first { it.fieldNumber == 1 }.intValue
        assertEquals(750, x)
    }

    @Test
    fun `sendMultiTouchEvent encodes pointer y in pointer_data field 2`() {
        handler.sendMultiTouchEvent(0, 0,
            listOf(InputChannelHandler.TouchPointer(id = 0, x = 750, y = 400)))

        val te = touchEventBytes(capturePayload())
        val pd = pointerDataBytes(te, 0)
        val y  = ProtoEncoder.readFields(pd).first { it.fieldNumber == 2 }.intValue
        assertEquals(400, y)
    }

    @Test
    fun `sendMultiTouchEvent encodes pointer id in pointer_data field 3`() {
        handler.sendMultiTouchEvent(0, 0,
            listOf(InputChannelHandler.TouchPointer(id = 3, x = 0, y = 0)))

        val te = touchEventBytes(capturePayload())
        val pd = pointerDataBytes(te, 0)
        val id = ProtoEncoder.readFields(pd).first { it.fieldNumber == 3 }.intValue
        assertEquals(3, id)
    }

    @Test
    fun `sendMultiTouchEvent encodes action in touch_event field 3`() {
        handler.sendMultiTouchEvent(2, 0,  // action = MOVE
            listOf(InputChannelHandler.TouchPointer(0, 0, 0)))

        val te     = touchEventBytes(capturePayload())
        val action = ProtoEncoder.readFields(te).first { it.fieldNumber == 3 }.intValue
        assertEquals(2, action)
    }

    @Test
    fun `sendMultiTouchEvent encodes actionIndex in touch_event field 4`() {
        handler.sendMultiTouchEvent(
            action      = 5,    // ACTION_POINTER_DOWN
            actionIndex = 1,    // second pointer is the active one
            pointers    = listOf(
                InputChannelHandler.TouchPointer(0, 0, 0),
                InputChannelHandler.TouchPointer(1, 100, 100)
            )
        )

        val te          = touchEventBytes(capturePayload())
        val actionIndex = ProtoEncoder.readFields(te).first { it.fieldNumber == 4 }.intValue
        assertEquals(1, actionIndex)
    }

    // =========================================================================
    // Channel / message type routing
    // =========================================================================

    @Test
    fun `sendMultiTouchEvent sends on INPUT channel`() {
        handler.sendMultiTouchEvent(0, 0,
            listOf(InputChannelHandler.TouchPointer(0, 0, 0)))

        verify { mockMux.sendEncrypted(eq(ChannelId.INPUT), any(), any()) }
    }

    @Test
    fun `sendMultiTouchEvent uses message type INPUT_EVENT (0x8001)`() {
        handler.sendMultiTouchEvent(0, 0,
            listOf(InputChannelHandler.TouchPointer(0, 0, 0)))

        verify { mockMux.sendEncrypted(any(), eq(InputMessageType.INPUT_EVENT), any()) }
    }

    // =========================================================================
    // mapToAaAction — pure function tests
    // =========================================================================

    @Test
    fun `mapToAaAction DOWN with allTouchCount=1 returns ACTION_DOWN (0)`() {
        assertEquals(0, InputChannelHandler.mapToAaAction(browserAction = 0, allTouchCount = 1))
    }

    @Test
    fun `mapToAaAction DOWN with allTouchCount=2 returns ACTION_POINTER_DOWN (5)`() {
        assertEquals(5, InputChannelHandler.mapToAaAction(browserAction = 0, allTouchCount = 2))
    }

    @Test
    fun `mapToAaAction DOWN with allTouchCount=10 returns ACTION_POINTER_DOWN (5)`() {
        assertEquals(5, InputChannelHandler.mapToAaAction(browserAction = 0, allTouchCount = 10))
    }

    @Test
    fun `mapToAaAction UP with allTouchCount=1 returns ACTION_POINTER_UP (6)`() {
        assertEquals(6, InputChannelHandler.mapToAaAction(browserAction = 2, allTouchCount = 1))
    }

    @Test
    fun `mapToAaAction UP with allTouchCount=0 returns ACTION_UP (1)`() {
        assertEquals(1, InputChannelHandler.mapToAaAction(browserAction = 2, allTouchCount = 0))
    }

    @Test
    fun `mapToAaAction MOVE returns ACTION_MOVED (2) regardless of pointer count`() {
        assertEquals(2, InputChannelHandler.mapToAaAction(browserAction = 1, allTouchCount = 1))
        assertEquals(2, InputChannelHandler.mapToAaAction(browserAction = 1, allTouchCount = 5))
    }

    @Test
    fun `mapToAaAction CANCEL (3) returns ACTION_UP (1)`() {
        assertEquals(1, InputChannelHandler.mapToAaAction(browserAction = 3, allTouchCount = 0))
    }

    @Test
    fun `mapToAaAction CANCEL with remaining pointers still returns ACTION_UP`() {
        assertEquals(1, InputChannelHandler.mapToAaAction(browserAction = 3, allTouchCount = 3))
    }
}
```

### Green Phase for InputChannelHandler

Add inside `InputChannelHandler`:

```kotlin
data class TouchPointer(val id: Int, val x: Int, val y: Int)

fun sendMultiTouchEvent(action: Int, actionIndex: Int, pointers: List<TouchPointer>) {
    val timestamp = android.os.SystemClock.elapsedRealtime() * 1_000_000L
    val out = ByteArrayOutputStream()
    ProtoEncoder.writeVarintField(out, 1, timestamp)
    ProtoEncoder.writeVarintField(out, 2, ChannelId.VIDEO.toLong())
    ProtoEncoder.writeEmbeddedMessage(out, 3) { te ->
        for (p in pointers) {
            ProtoEncoder.writeEmbeddedMessage(te, 1) { pd ->
                ProtoEncoder.writeVarintField(pd, 1, p.x.toLong())
                ProtoEncoder.writeVarintField(pd, 2, p.y.toLong())
                ProtoEncoder.writeVarintField(pd, 3, p.id.toLong())
            }
        }
        ProtoEncoder.writeVarintField(te, 3, action.toLong())
        ProtoEncoder.writeVarintField(te, 4, actionIndex.toLong())
    }
    mux.sendEncrypted(ChannelId.INPUT, InputMessageType.INPUT_EVENT, out.toByteArray())
}

companion object {
    const val ACTION_DOWN         = 0
    const val ACTION_UP           = 1
    const val ACTION_MOVE         = 2
    const val ACTION_POINTER_DOWN = 5
    const val ACTION_POINTER_UP   = 6

    fun mapToAaAction(browserAction: Int, allTouchCount: Int): Int = when (browserAction) {
        0    -> if (allTouchCount > 1) ACTION_POINTER_DOWN else ACTION_DOWN
        1    -> ACTION_MOVE
        2    -> if (allTouchCount > 0) ACTION_POINTER_UP   else ACTION_UP
        else -> ACTION_UP   // CANCEL (3) and unknown
    }
}
```

---

## ControlSocketBinaryTouchTest

File: `network/src/test/java/com/supertesla/aa/network/relay/ControlSocketBinaryTouchTest.kt`

The `onMessage(ByteBuffer)` override currently contains only a `TODO` comment.

```kotlin
package com.supertesla.aa.network.relay

import com.supertesla.aa.network.protocol.buildBinaryTouch
import io.mockk.mockk
import org.java_websocket.WebSocket
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.nio.ByteBuffer

private fun fakeSocket(): WebSocket = mockk(relaxed = true)

class ControlSocketBinaryTouchTest {

    // =========================================================================
    // Valid binary messages are decoded and dispatched to onTouch
    // =========================================================================

    @Test
    fun `valid DOWN binary message calls onTouch with decoded action and coordinates`() {
        var capturedAction = -1
        var capturedX      = -1
        var capturedY      = -1
        val server = ControlSocketServer(
            port     = 0,
            onAction = { _, _ -> },
            onTouch  = { action, x, y, _ ->
                capturedAction = action
                capturedX = x
                capturedY = y
            }
        )
        // DOWN, 1 touch at (320, 240), allTouches same
        val data = buildBinaryTouch(
            action     = 0,
            touches    = listOf(Triple(0, 320, 240)),
            allTouches = listOf(Triple(0, 320, 240))
        )

        server.onMessage(fakeSocket(), ByteBuffer.wrap(data))

        assertEquals(0,   capturedAction, "action must be DOWN (0)")
        assertEquals(320, capturedX,      "x must be 320")
        assertEquals(240, capturedY,      "y must be 240")
    }

    @Test
    fun `allTouches coordinates are preferred over touches for dispatch`() {
        val received = mutableListOf<Pair<Int, Int>>() // x, y
        val server = ControlSocketServer(
            port    = 0,
            onTouch = { _, x, y, _ -> received.add(x to y) }
        )
        // 1 changed touch + 2 allTouches
        val data = buildBinaryTouch(
            action     = 1,
            touches    = listOf(Triple(0, 100, 100)),
            allTouches = listOf(Triple(0, 100, 100), Triple(1, 200, 200))
        )

        server.onMessage(fakeSocket(), ByteBuffer.wrap(data))

        assertEquals(2, received.size, "Two allTouch points must produce two onTouch calls")
        assertEquals(100, received[0].first)
        assertEquals(200, received[1].first)
    }

    @Test
    fun `MOVE binary message dispatches with action 1`() {
        var capturedAction = -1
        val server = ControlSocketServer(
            port    = 0,
            onTouch = { action, _, _, _ -> capturedAction = action }
        )
        val data = buildBinaryTouch(
            action     = 1,
            touches    = listOf(Triple(0, 500, 300)),
            allTouches = listOf(Triple(0, 500, 300))
        )

        server.onMessage(fakeSocket(), ByteBuffer.wrap(data))

        assertEquals(1, capturedAction)
    }

    // =========================================================================
    // Invalid binary messages are silently ignored
    // =========================================================================

    @Test
    fun `binary message with action byte 15 (invalid) does not call onTouch`() {
        var touched = false
        val server = ControlSocketServer(
            port    = 0,
            onTouch = { _, _, _, _ -> touched = true }
        )
        val invalid = ByteArray(8)
        invalid[0] = 0x0F   // action = 15

        server.onMessage(fakeSocket(), ByteBuffer.wrap(invalid))

        assertFalse(touched)
    }

    @Test
    fun `binary message shorter than 8 bytes does not call onTouch`() {
        var touched = false
        val server = ControlSocketServer(
            port    = 0,
            onTouch = { _, _, _, _ -> touched = true }
        )

        server.onMessage(fakeSocket(), ByteBuffer.wrap(ByteArray(5)))

        assertFalse(touched)
    }

    @Test
    fun `binary message with touchCount=11 (exceeds max) does not call onTouch`() {
        var touched = false
        val server = ControlSocketServer(
            port    = 0,
            onTouch = { _, _, _, _ -> touched = true }
        )
        val invalid = ByteArray(8)
        invalid[0] = 0x00
        invalid[1] = 0x0B   // touchCount = 11

        server.onMessage(fakeSocket(), ByteBuffer.wrap(invalid))

        assertFalse(touched)
    }

    @Test
    fun `empty ByteBuffer does not throw and does not call onTouch`() {
        var touched = false
        val server = ControlSocketServer(
            port    = 0,
            onTouch = { _, _, _, _ -> touched = true }
        )

        assertDoesNotThrow {
            server.onMessage(fakeSocket(), ByteBuffer.wrap(ByteArray(0)))
        }
        assertFalse(touched)
    }
}
```

### Green Phase for ControlSocketServer

Replace the TODO body in `onMessage(conn: WebSocket, message: ByteBuffer)`:

```kotlin
override fun onMessage(conn: WebSocket, message: ByteBuffer) {
    val data = ByteArray(message.remaining())
    message.get(data)
    if (!BinaryTouchDecoder.isBinaryFormat(data)) return
    val decoded = BinaryTouchDecoder.decode(data)
    val points  = if (decoded.allTouches.isNotEmpty()) decoded.allTouches else decoded.touches
    for (p in points) {
        onTouch(decoded.action, p.x, p.y, p.id)
    }
}
```

---

## Red / Green / Refactor (all four classes)

### Red Phase

| Test class | Expected failures before implementation |
|---|---|
| `BinaryTouchDecoderTest` | All tests — `ClassNotFoundException` / unresolved reference |
| `TouchInputRelayMultiTouchTest` | Passes immediately (class exists); clamping tests may reveal missing `coerceIn` on the `touches`-only fallback path |
| `InputChannelHandlerMultiTouchTest` | All tests — `sendMultiTouchEvent`, `TouchPointer`, `mapToAaAction` do not exist |
| `ControlSocketBinaryTouchTest` | All tests — `onMessage(ByteBuffer)` currently has no implementation |

### Refactor Phase

- **`BinaryTouchDecoder`**: replace manual `uint16BE` with `ByteBuffer.order(BIG_ENDIAN).getShort()` to eliminate custom bit-shifting; add `require(data.size >= minSize)` bounds check with a descriptive message.
- **`InputChannelHandler`**: inject `timestampProvider: () -> Long = { SystemClock.elapsedRealtime() * 1_000_000L }` as a constructor parameter so `sendMultiTouchEvent` timestamp tests do not depend on wall time.
- **`TouchInputRelay`**: replace the `TouchListener` callback interface with `MutableSharedFlow<TouchEvent>` to align with the codebase's coroutine-first design.
- **`ControlSocketServer`**: emit decoded touches into a `Flow<DecodedTouch>` rather than calling `onTouch` inline to decouple the WebSocket receive thread from the AA protocol send path.
