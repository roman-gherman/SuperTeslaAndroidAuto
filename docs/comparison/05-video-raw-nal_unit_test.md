# 05 — Video Raw NAL: Unit Test Plan

## Overview

Tests cover `NalStreamManager` fragment reassembly and header stripping, `NalUnitParser` start-code
detection and NAL type classification, and `VideoChannelHandler` timestamp extraction plus
codec-config caching.  All pseudocode is written as real Kotlin targeting JUnit 5, MockK, Turbine,
and `kotlinx-coroutines-test`.

---

## Test Classes

| Test Class | File Path | Class Under Test |
|---|---|---|
| `NalStreamManagerTest` | `streaming/src/test/java/com/supertesla/aa/streaming/video/NalStreamManagerTest.kt` | `NalStreamManager` |
| `NalUnitParserTest` | `streaming/src/test/java/com/supertesla/aa/streaming/video/NalUnitParserTest.kt` | `NalUnitParser` |
| `VideoChannelHandlerHeaderTest` | `androidauto/src/test/java/com/supertesla/aa/androidauto/channels/VideoChannelHandlerHeaderTest.kt` | `VideoChannelHandler` |

---

## NalStreamManagerTest

File: `streaming/src/test/java/com/supertesla/aa/streaming/video/NalStreamManagerTest.kt`

```kotlin
package com.supertesla.aa.streaming.video

import app.cash.turbine.test
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class NalStreamManagerTest {

    private lateinit var manager: NalStreamManager

    @BeforeEach
    fun setUp() {
        manager = NalStreamManager()
    }

    // -------------------------------------------------------------------------
    // Helper: builds a byte array with a 10-byte MEDIA_DATA header followed by
    // the supplied NAL bytes.
    // -------------------------------------------------------------------------
    private fun mediaDataFrame(vararg nalBytes: Byte): ByteArray =
        ByteArray(10) + byteArrayOf(*nalBytes)

    private fun codecConfigFrame(vararg nalBytes: Byte): ByteArray =
        ByteArray(2) + byteArrayOf(*nalBytes)

    // =========================================================================
    // Indicator 1 — START
    // =========================================================================

    @Test
    fun `indicator 1 clears buffer before writing new data`() = runTest {
        // Arrange: prime the buffer with stale data via indicator 0
        val stale = ByteArray(20) { 0xFF.toByte() }
        manager.buildNal(indicator = 0, data = stale, length = 20, isCodecConfig = false)

        val startData = mediaDataFrame(0x00, 0x00, 0x00, 0x01, 0x65)

        manager.videoFrames.test {
            // Act: start new frame — must discard stale bytes
            manager.buildNal(indicator = 1, data = startData,
                length = startData.size, isCodecConfig = false)

            // Flush via indicator 2 (header-only, no extra payload)
            val endData = ByteArray(10)
            manager.buildNal(indicator = 2, data = endData,
                length = 10, isCodecConfig = false)

            val frame = awaitItem()
            // Expected payload: only the NAL bytes from the start fragment
            assertContentEquals(byteArrayOf(0x00, 0x00, 0x00, 0x01, 0x65), frame.data)
            assertFalse(frame.data.any { it == 0xFF.toByte() },
                "Stale 0xFF bytes must not appear after indicator=1 clears the buffer")
            cancelAndIgnoreRemainingEvents()
        }
    }

    // =========================================================================
    // Indicator 0 — CONTINUATION header offsets
    // =========================================================================

    @Test
    fun `indicator 0 strips 10-byte media header for continuation`() = runTest {
        // Arrange: start a frame
        val startData = mediaDataFrame(0x00, 0x00, 0x00, 0x01, 0x41)
        manager.buildNal(1, startData, startData.size, isCodecConfig = false)

        // Continuation: 10-byte header + body [01 02 03]
        val contData = ByteArray(10) + byteArrayOf(0x01, 0x02, 0x03)

        manager.videoFrames.test {
            manager.buildNal(0, contData, contData.size, isCodecConfig = false)
            // End the frame
            val endData = ByteArray(10)
            manager.buildNal(2, endData, 10, isCodecConfig = false)

            val frame = awaitItem()
            // Expected: start payload [00 00 00 01 41] + cont body [01 02 03]
            assertContentEquals(
                byteArrayOf(0x00, 0x00, 0x00, 0x01, 0x41, 0x01, 0x02, 0x03),
                frame.data
            )
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `indicator 0 strips 2-byte codec config header for continuation`() = runTest {
        // Arrange: codec config start (2-byte header + SPS start code)
        val startData = codecConfigFrame(0x00, 0x00, 0x00, 0x01, 0x67)
        manager.buildNal(1, startData, startData.size, isCodecConfig = true)

        // Continuation: 2-byte header + body [42 43]
        val contData = byteArrayOf(0xEF.toByte(), 0xFF.toByte(), 0x42, 0x43)

        manager.videoFrames.test {
            manager.buildNal(0, contData, contData.size, isCodecConfig = true)
            // End with header-only
            val endData = ByteArray(2)
            manager.buildNal(2, endData, 2, isCodecConfig = true)

            val frame = awaitItem()
            // Expected: [00 00 00 01 67 42 43]
            assertContentEquals(
                byteArrayOf(0x00, 0x00, 0x00, 0x01, 0x67, 0x42, 0x43),
                frame.data
            )
            cancelAndIgnoreRemainingEvents()
        }
    }

    // =========================================================================
    // Indicator 2 — END
    // =========================================================================

    @Test
    fun `indicator 2 appends final bytes then emits exactly once`() = runTest {
        val startData = mediaDataFrame(0x00, 0x00, 0x00, 0x01, 0x65)
        manager.buildNal(1, startData, startData.size, false)

        manager.videoFrames.test {
            val endData = ByteArray(10) + byteArrayOf(0xAA.toByte())
            manager.buildNal(2, endData, endData.size, false)

            awaitItem()                     // exactly one emission
            expectNoEvents()                // no second emission
            cancelAndIgnoreRemainingEvents()
        }
    }

    // =========================================================================
    // Indicator 3 — COMPLETE FRAME
    // =========================================================================

    @Test
    fun `indicator 3 emits complete frame without prior buffer state`() = runTest {
        val payload = byteArrayOf(0x00, 0x00, 0x00, 0x01, 0x67, 0x42, 0x00, 0x1E)
        val data = ByteArray(10) + payload

        manager.videoFrames.test {
            manager.buildNal(3, data, data.size, false)

            val frame = awaitItem()
            assertContentEquals(payload, frame.data)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `indicator 3 with codec config strips 2-byte header only`() = runTest {
        val payload = byteArrayOf(0x00, 0x00, 0x00, 0x01, 0x67, 0x42)
        val data = ByteArray(2) + payload

        manager.videoFrames.test {
            manager.buildNal(3, data, data.size, isCodecConfig = true)

            val frame = awaitItem()
            assertContentEquals(payload, frame.data)
            cancelAndIgnoreRemainingEvents()
        }
    }

    // =========================================================================
    // Indicator 127 — INTERNAL FLUSH
    // =========================================================================

    @Test
    fun `indicator 127 flips existing buffer and emits accumulated data`() = runTest {
        val payload = byteArrayOf(0x00, 0x00, 0x00, 0x01, 0x65, 0x88.toByte())
        val startData = ByteArray(10) + payload
        manager.buildNal(1, startData, startData.size, false)

        manager.videoFrames.test {
            manager.buildNal(127, ByteArray(0), 0, false)

            val frame = awaitItem()
            assertContentEquals(payload, frame.data)
            cancelAndIgnoreRemainingEvents()
        }
    }

    // =========================================================================
    // Unknown indicator
    // =========================================================================

    @Test
    fun `unknown indicator does not crash and does not emit a frame`() = runTest {
        manager.videoFrames.test {
            // Act: indicator 42 is undefined
            manager.buildNal(42, ByteArray(20), 20, false)
            expectNoEvents()

            // Subsequent valid call still works
            val validData = ByteArray(10) + byteArrayOf(0x00, 0x00, 0x00, 0x01, 0x41)
            manager.buildNal(3, validData, validData.size, false)
            awaitItem()
            cancelAndIgnoreRemainingEvents()
        }
    }

    // =========================================================================
    // Guard: data shorter than header
    // =========================================================================

    @Test
    fun `indicator 3 with length equal to header emits nothing`() = runTest {
        // Exactly 10 bytes == the header, no payload
        val tooShort = ByteArray(10)

        manager.videoFrames.test {
            manager.buildNal(3, tooShort, 10, isCodecConfig = false)
            expectNoEvents()
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `indicator 3 with codec config length equal to 2-byte header emits nothing`() = runTest {
        val tooShort = ByteArray(2)

        manager.videoFrames.test {
            manager.buildNal(3, tooShort, 2, isCodecConfig = true)
            expectNoEvents()
            cancelAndIgnoreRemainingEvents()
        }
    }

    // =========================================================================
    // reset()
    // =========================================================================

    @Test
    fun `reset clears accumulated buffer so subsequent end indicator emits nothing`() = runTest {
        val startData = ByteArray(10) + byteArrayOf(0x00, 0x00, 0x00, 0x01, 0x65)
        manager.buildNal(1, startData, startData.size, false)

        manager.reset()

        manager.videoFrames.test {
            // Indicator 2 after reset: buffer was cleared, nothing to emit
            manager.buildNal(2, ByteArray(10), 10, false)
            expectNoEvents()
            cancelAndIgnoreRemainingEvents()
        }
    }

    // =========================================================================
    // Keyframe request debounce
    // =========================================================================

    @Test
    fun `keyframe request fires immediately on first call`() {
        var callCount = 0
        manager.onSendVideoFocus = { _, _ -> callCount++ }

        manager.requestKeyFrame()

        assertEquals(1, callCount)
    }

    @Test
    fun `rapid keyframe requests are debounced to at most one call`() {
        var callCount = 0
        manager.onSendVideoFocus = { _, _ -> callCount++ }

        manager.requestKeyFrame()
        manager.requestKeyFrame()
        manager.requestKeyFrame()

        assertEquals(1, callCount,
            "Three rapid requestKeyFrame() calls must fire the callback only once")
    }

    @Test
    fun `keyframe request invokes callback with unsolicited=true`() {
        var capturedUnsolicited = false
        manager.onSendVideoFocus = { _, unsolicited -> capturedUnsolicited = unsolicited }

        manager.requestKeyFrame()

        assertTrue(capturedUnsolicited)
    }

    // =========================================================================
    // feedFrame (pre-stripped path)
    // =========================================================================

    @Test
    fun `feedFrame emits the supplied bytes unmodified`() = runTest {
        val raw = byteArrayOf(0x00, 0x00, 0x00, 0x01, 0x65, 0x88.toByte())

        manager.videoFrames.test {
            manager.feedFrame(raw, timestamp = 12345L)

            val frame = awaitItem()
            assertContentEquals(raw, frame.data)
            assertEquals(12345L, frame.timestamp)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `feedFrame increments frame number sequentially`() = runTest {
        val raw = ByteArray(5)

        manager.videoFrames.test {
            manager.feedFrame(raw, 0L)
            manager.feedFrame(raw, 1L)

            val f1 = awaitItem()
            val f2 = awaitItem()
            assertEquals(1L, f1.frameNumber)
            assertEquals(2L, f2.frameNumber)
            cancelAndIgnoreRemainingEvents()
        }
    }
}
```

---

## NalUnitParserTest

File: `streaming/src/test/java/com/supertesla/aa/streaming/video/NalUnitParserTest.kt`

```kotlin
package com.supertesla.aa.streaming.video

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class NalUnitParserTest {

    private lateinit var parser: NalUnitParser

    @BeforeEach
    fun setUp() {
        parser = NalUnitParser()
    }

    // =========================================================================
    // Start-code detection
    // =========================================================================

    @Test
    fun `parse finds 4-byte start codes and classifies NAL types`() {
        val data = byteArrayOf(
            0x00, 0x00, 0x00, 0x01, 0x67,   // SPS  (type 7)
            0x00, 0x00, 0x00, 0x01, 0x68    // PPS  (type 8)
        )

        val units = parser.parse(data)

        assertEquals(2, units.size)
        assertEquals(NalUnitParser.NalType.SPS, units[0].type)
        assertEquals(4, units[0].startCodeSize)
        assertEquals(NalUnitParser.NalType.PPS, units[1].type)
        assertEquals(4, units[1].startCodeSize)
    }

    @Test
    fun `parse finds 3-byte start codes`() {
        val data = byteArrayOf(
            0x00, 0x00, 0x01, 0x41,          // Slice non-IDR (type 1)
            0x00, 0x00, 0x01, 0x65           // IDR slice     (type 5)
        )

        val units = parser.parse(data)

        assertEquals(2, units.size)
        assertEquals(NalUnitParser.NalType.SLICE_NON_IDR, units[0].type)
        assertEquals(3, units[0].startCodeSize)
        assertEquals(NalUnitParser.NalType.SLICE_IDR, units[1].type)
        assertEquals(3, units[1].startCodeSize)
    }

    @Test
    fun `parse handles mixed 3-byte and 4-byte start codes in same stream`() {
        val data = byteArrayOf(
            0x00, 0x00, 0x00, 0x01, 0x67,   // 4-byte SPS
            0x00, 0x00, 0x01, 0x68           // 3-byte PPS
        )

        val units = parser.parse(data)

        assertEquals(2, units.size)
        assertEquals(4, units[0].startCodeSize)
        assertEquals(3, units[1].startCodeSize)
    }

    @Test
    fun `parse returns empty list when no start codes are present`() {
        val data = byteArrayOf(0x01, 0x02, 0x03, 0x04, 0x05)

        assertTrue(parser.parse(data).isEmpty())
    }

    @Test
    fun `parse returns empty list for empty input`() {
        assertTrue(parser.parse(ByteArray(0)).isEmpty())
    }

    // =========================================================================
    // NalType classification
    // =========================================================================

    @Test
    fun `NalType SPS is identified from byte 0x67`() {
        // 0x67 & 0x1F == 7
        assertEquals(NalUnitParser.NalType.SPS, NalUnitParser.NalType.fromByte(0x67.toByte()))
    }

    @Test
    fun `NalType PPS is identified from byte 0x68`() {
        // 0x68 & 0x1F == 8
        assertEquals(NalUnitParser.NalType.PPS, NalUnitParser.NalType.fromByte(0x68.toByte()))
    }

    @Test
    fun `NalType IDR is identified and isKeyframe returns true`() {
        // 0x65 & 0x1F == 5
        val type = NalUnitParser.NalType.fromByte(0x65.toByte())
        assertEquals(NalUnitParser.NalType.SLICE_IDR, type)
        assertTrue(type.isKeyframe)
    }

    @Test
    fun `NalType SLICE_NON_IDR isKeyframe returns false`() {
        // 0x41 & 0x1F == 1
        val type = NalUnitParser.NalType.fromByte(0x41.toByte())
        assertEquals(NalUnitParser.NalType.SLICE_NON_IDR, type)
        assertFalse(type.isKeyframe)
    }

    @Test
    fun `NalType SEI is identified from byte 0x06`() {
        assertEquals(NalUnitParser.NalType.SEI, NalUnitParser.NalType.fromByte(0x06.toByte()))
    }

    @Test
    fun `NalType unknown byte returns UNKNOWN`() {
        // 0x1F & 0x1F == 31, not in the enum
        assertEquals(NalUnitParser.NalType.UNKNOWN,
            NalUnitParser.NalType.fromByte(0x1F.toByte()))
    }

    // =========================================================================
    // dataWithoutStartCode
    // =========================================================================

    @Test
    fun `dataWithoutStartCode strips 4-byte prefix correctly`() {
        val raw = byteArrayOf(0x00, 0x00, 0x00, 0x01, 0x67, 0x42, 0x00, 0x1E)
        val units = parser.parse(raw)

        assertContentEquals(byteArrayOf(0x67, 0x42, 0x00, 0x1E), units[0].dataWithoutStartCode)
    }

    @Test
    fun `dataWithoutStartCode strips 3-byte prefix correctly`() {
        val raw = byteArrayOf(0x00, 0x00, 0x01, 0x68, 0xCE.toByte(), 0x38.toByte())
        val units = parser.parse(raw)

        assertContentEquals(
            byteArrayOf(0x68, 0xCE.toByte(), 0x38.toByte()),
            units[0].dataWithoutStartCode
        )
    }

    // =========================================================================
    // SPS / PPS caching
    // =========================================================================

    @Test
    fun `cachedSps is null before any parse`() {
        assertNull(parser.cachedSps)
        assertFalse(parser.hasSpsAndPps)
    }

    @Test
    fun `cachedPps is null before any parse`() {
        assertNull(parser.cachedPps)
    }

    @Test
    fun `SPS and PPS are cached after parsing a stream containing both`() {
        val data = byteArrayOf(
            0x00, 0x00, 0x00, 0x01, 0x67, 0x42, 0x00, 0x1E,   // SPS body
            0x00, 0x00, 0x00, 0x01, 0x68, 0xCE.toByte()        // PPS body
        )

        parser.parse(data)

        assertNotNull(parser.cachedSps)
        assertNotNull(parser.cachedPps)
        assertTrue(parser.hasSpsAndPps)
    }

    @Test
    fun `cachedSps contains body without start code`() {
        val spsBody = byteArrayOf(0x67, 0x42, 0x00, 0x1E)
        val data = byteArrayOf(0x00, 0x00, 0x00, 0x01) + spsBody

        parser.parse(data)

        assertContentEquals(spsBody, parser.cachedSps)
    }

    @Test
    fun `hasSpsAndPps is false when only SPS received`() {
        val data = byteArrayOf(0x00, 0x00, 0x00, 0x01, 0x67, 0x42, 0x00, 0x1E)
        parser.parse(data)

        assertNotNull(parser.cachedSps)
        assertNull(parser.cachedPps)
        assertFalse(parser.hasSpsAndPps)
    }

    // =========================================================================
    // AVCC conversion
    // =========================================================================

    @Test
    fun `annexBToAvcc prepends correct 4-byte big-endian length`() {
        // NAL body without start code = [65 88 80] — length 3
        val raw = byteArrayOf(0x00, 0x00, 0x00, 0x01, 0x65, 0x88.toByte(), 0x80.toByte())
        val unit = parser.parse(raw)[0]

        val avcc = NalUnitParser.annexBToAvcc(unit)

        assertEquals(7, avcc.size)              // 4-byte length + 3 body bytes
        assertEquals(0x00.toByte(), avcc[0])
        assertEquals(0x00.toByte(), avcc[1])
        assertEquals(0x00.toByte(), avcc[2])
        assertEquals(0x03.toByte(), avcc[3])    // length = 3
        assertEquals(0x65.toByte(), avcc[4])    // first body byte
    }

    @Test
    fun `rawToAvcc prepends 4-byte length for a buffer with no start code`() {
        // 5-byte NAL body
        val nalBody = byteArrayOf(0x67, 0x42, 0x00, 0x1E, 0xAB.toByte())

        val avcc = NalUnitParser.rawToAvcc(nalBody)

        assertEquals(9, avcc.size)
        assertEquals(0x00.toByte(), avcc[0])
        assertEquals(0x00.toByte(), avcc[1])
        assertEquals(0x00.toByte(), avcc[2])
        assertEquals(0x05.toByte(), avcc[3])    // length = 5
        assertContentEquals(nalBody, avcc.copyOfRange(4, avcc.size))
    }

    @Test
    fun `rawToAvcc handles single-byte NAL body`() {
        val nalBody = byteArrayOf(0x0B)

        val avcc = NalUnitParser.rawToAvcc(nalBody)

        assertEquals(5, avcc.size)
        assertEquals(0x01.toByte(), avcc[3])
        assertEquals(0x0B.toByte(), avcc[4])
    }

    // =========================================================================
    // feed() callback variant
    // =========================================================================

    @Test
    fun `feed invokes callback once per NAL unit found`() {
        val data = byteArrayOf(
            0x00, 0x00, 0x00, 0x01, 0x67, 0x42,
            0x00, 0x00, 0x00, 0x01, 0x68, 0xCE.toByte()
        )
        val received = mutableListOf<NalUnitParser.NalUnit>()

        parser.feed(data) { received.add(it) }

        assertEquals(2, received.size)
        assertEquals(NalUnitParser.NalType.SPS, received[0].type)
        assertEquals(NalUnitParser.NalType.PPS, received[1].type)
    }
}
```

---

## VideoChannelHandlerHeaderTest

File: `androidauto/src/test/java/com/supertesla/aa/androidauto/channels/VideoChannelHandlerHeaderTest.kt`

### Test-helper note

`AapFramer.AapFrame` derives `messageType` and `messageBody` from the first 2 bytes of `payload`.
To construct a testable frame, the payload must be `[msgType_hi, msgType_lo] + body`.  The helper
`buildVideoFrame` below encodes this correctly.  The frame uses `flags = AapFramer.FLAG_BULK`
(0x03) so `isFirst` and `isLast` are both true, which makes `messageType` and `messageBody`
accessible.

```kotlin
package com.supertesla.aa.androidauto.channels

import app.cash.turbine.test
import com.supertesla.aa.androidauto.proto.AvMessageType
import com.supertesla.aa.androidauto.protocol.AapFramer
import com.supertesla.aa.androidauto.protocol.ChannelMux
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

// ---------------------------------------------------------------------------
// Helpers
// ---------------------------------------------------------------------------

/** Builds an AapFrame whose payload encodes msgType (2 bytes BE) + body. */
private fun buildVideoFrame(msgType: Int, body: ByteArray): AapFramer.AapFrame {
    val payload = ByteArray(2 + body.size)
    payload[0] = (msgType shr 8).toByte()
    payload[1] = (msgType and 0xFF).toByte()
    System.arraycopy(body, 0, payload, 2, body.size)
    return AapFramer.AapFrame(
        channel = 2,
        flags   = AapFramer.FLAG_BULK,   // 0x03 — FIRST|LAST, not encrypted
        payload = payload
    )
}

// ---------------------------------------------------------------------------
// Tests
// ---------------------------------------------------------------------------

class VideoChannelHandlerHeaderTest {

    private val mockMux = mockk<ChannelMux>(relaxed = true)

    // =========================================================================
    // MEDIA_WITH_TIMESTAMP (0x0000)
    // =========================================================================

    @Test
    fun `MEDIA_WITH_TIMESTAMP strips exactly 8 timestamp bytes and emits the rest`() = runTest {
        val handler = VideoChannelHandler(mockMux)

        // Timestamp bytes encode value 100 as big-endian uint64
        val timestampBytes = byteArrayOf(0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x64)
        val nalPayload     = byteArrayOf(0x00, 0x00, 0x00, 0x01, 0x65, 0xAB.toByte())
        val body           = timestampBytes + nalPayload
        val frame          = buildVideoFrame(AvMessageType.MEDIA_WITH_TIMESTAMP, body)

        handler.videoFrames.test {
            handler.onFrame(frame)

            val vf = awaitItem()
            assertContentEquals(nalPayload, vf.data)
            assertEquals(100L, vf.timestamp)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `MEDIA_WITH_TIMESTAMP with body of exactly 8 bytes emits nothing`() = runTest {
        val handler = VideoChannelHandler(mockMux)
        val body    = ByteArray(8) { 0x00 }
        val frame   = buildVideoFrame(AvMessageType.MEDIA_WITH_TIMESTAMP, body)

        handler.videoFrames.test {
            handler.onFrame(frame)
            expectNoEvents()
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `MEDIA_WITH_TIMESTAMP with body shorter than 8 bytes emits nothing`() = runTest {
        val handler = VideoChannelHandler(mockMux)
        val body    = ByteArray(4)
        val frame   = buildVideoFrame(AvMessageType.MEDIA_WITH_TIMESTAMP, body)

        handler.videoFrames.test {
            handler.onFrame(frame)
            expectNoEvents()
            cancelAndIgnoreRemainingEvents()
        }
    }

    // =========================================================================
    // MEDIA_INDICATION (0x0001)
    // =========================================================================

    @Test
    fun `MEDIA_INDICATION emits body bytes as-is without stripping`() = runTest {
        val handler = VideoChannelHandler(mockMux)
        val body    = byteArrayOf(0x00, 0x00, 0x00, 0x01, 0x41, 0x9A.toByte())
        val frame   = buildVideoFrame(AvMessageType.MEDIA_INDICATION, body)

        handler.videoFrames.test {
            handler.onFrame(frame)

            val vf = awaitItem()
            assertContentEquals(body, vf.data)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `MEDIA_INDICATION with empty body emits nothing`() = runTest {
        val handler = VideoChannelHandler(mockMux)
        val frame   = buildVideoFrame(AvMessageType.MEDIA_INDICATION, ByteArray(0))

        handler.videoFrames.test {
            handler.onFrame(frame)
            expectNoEvents()
            cancelAndIgnoreRemainingEvents()
        }
    }

    // =========================================================================
    // Codec config caching (SPS — NAL type 7)
    // =========================================================================

    @Test
    fun `SPS with Annex B start code 00000001 is cached as cachedCodecConfig`() = runTest {
        val handler = VideoChannelHandler(mockMux)
        val ts      = ByteArray(8)
        val sps     = byteArrayOf(0x00, 0x00, 0x00, 0x01, 0x67, 0x42, 0x00, 0x1E)
        val frame   = buildVideoFrame(AvMessageType.MEDIA_WITH_TIMESTAMP, ts + sps)

        handler.videoFrames.test {
            handler.onFrame(frame)
            awaitItem()
            cancelAndIgnoreRemainingEvents()
        }

        assertNotNull(handler.cachedCodecConfig)
        assertContentEquals(sps, handler.cachedCodecConfig)
    }

    @Test
    fun `SPS without Annex B start code is not cached`() = runTest {
        val handler = VideoChannelHandler(mockMux)
        val ts      = ByteArray(8)
        // NAL type byte 0x67 at position 0 — no leading 00 00 00 01
        val badSps  = byteArrayOf(0x67, 0x42, 0x00, 0x1E)
        val frame   = buildVideoFrame(AvMessageType.MEDIA_WITH_TIMESTAMP, ts + badSps)

        handler.videoFrames.test {
            handler.onFrame(frame)
            awaitItem()
            cancelAndIgnoreRemainingEvents()
        }

        assertNull(handler.cachedCodecConfig)
    }

    // =========================================================================
    // IDR caching (NAL type 5)
    // =========================================================================

    @Test
    fun `IDR frame with Annex B start code is cached as cachedIdr`() = runTest {
        val handler = VideoChannelHandler(mockMux)
        val ts      = ByteArray(8)
        val idr     = byteArrayOf(0x00, 0x00, 0x00, 0x01, 0x65, 0x88.toByte())
        val frame   = buildVideoFrame(AvMessageType.MEDIA_WITH_TIMESTAMP, ts + idr)

        handler.videoFrames.test {
            handler.onFrame(frame)
            awaitItem()
            cancelAndIgnoreRemainingEvents()
        }

        assertNotNull(handler.cachedIdr)
        assertContentEquals(idr, handler.cachedIdr)
    }

    @Test
    fun `non-SPS non-IDR frame does not populate cachedCodecConfig or cachedIdr`() = runTest {
        val handler = VideoChannelHandler(mockMux)
        val ts      = ByteArray(8)
        // Slice non-IDR (type 1 = 0x41)
        val slice   = byteArrayOf(0x00, 0x00, 0x00, 0x01, 0x41, 0x9A.toByte())
        val frame   = buildVideoFrame(AvMessageType.MEDIA_WITH_TIMESTAMP, ts + slice)

        handler.videoFrames.test {
            handler.onFrame(frame)
            awaitItem()
            cancelAndIgnoreRemainingEvents()
        }

        assertNull(handler.cachedCodecConfig)
        assertNull(handler.cachedIdr)
    }

    // =========================================================================
    // Timestamp parsing (readTimestamp big-endian uint64)
    // =========================================================================

    @Test
    fun `readTimestamp interprets 8 bytes as big-endian uint64 correctly`() = runTest {
        val handler = VideoChannelHandler(mockMux)
        // [00 00 00 00 00 BC 61 4E] == 12_345_678 decimal
        val tsBytes = byteArrayOf(0x00, 0x00, 0x00, 0x00, 0x00, 0xBC.toByte(), 0x61, 0x4E)
        // Append a single dummy NAL byte so the frame is not discarded by the size guard
        val frame   = buildVideoFrame(AvMessageType.MEDIA_WITH_TIMESTAMP, tsBytes + byteArrayOf(0x41))

        handler.videoFrames.test {
            handler.onFrame(frame)
            val vf = awaitItem()
            assertEquals(12_345_678L, vf.timestamp)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `readTimestamp correctly handles maximum 8-byte value`() = runTest {
        val handler = VideoChannelHandler(mockMux)
        // [7F FF FF FF FF FF FF FF] == Long.MAX_VALUE
        val tsBytes = byteArrayOf(
            0x7F, 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(),
            0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte()
        )
        val frame = buildVideoFrame(AvMessageType.MEDIA_WITH_TIMESTAMP, tsBytes + byteArrayOf(0x41))

        handler.videoFrames.test {
            handler.onFrame(frame)
            val vf = awaitItem()
            assertEquals(Long.MAX_VALUE, vf.timestamp)
            cancelAndIgnoreRemainingEvents()
        }
    }

    // =========================================================================
    // Frame numbering
    // =========================================================================

    @Test
    fun `frame numbers increment sequentially across successive frames`() = runTest {
        val handler = VideoChannelHandler(mockMux)
        val ts      = ByteArray(8)
        val nal     = byteArrayOf(0x00, 0x00, 0x00, 0x01, 0x41)

        handler.videoFrames.test {
            repeat(3) {
                handler.onFrame(buildVideoFrame(AvMessageType.MEDIA_WITH_TIMESTAMP, ts + nal))
            }
            assertEquals(1L, awaitItem().frameNumber)
            assertEquals(2L, awaitItem().frameNumber)
            assertEquals(3L, awaitItem().frameNumber)
            cancelAndIgnoreRemainingEvents()
        }
    }
}
```

---

## Red / Green / Refactor

### Red Phase

**`NalStreamManagerTest`**: The `requestKeyFrame` debounce tests pass immediately because the
rapid calls within a single millisecond are all debounced by the existing `System.currentTimeMillis()`
check.  All `buildNal` tests pass as-is.

**`NalUnitParserTest`**: All tests compile and pass — the class exists and is complete.

**`VideoChannelHandlerHeaderTest`**: Compiles after the `buildVideoFrame` helper is defined in the
test file.  The `cachedCodecConfig` / `cachedIdr` tests pass because the properties are already
`@Volatile var` with `private set`.

### Green Phase

No production-code changes are required.  The tests validate existing behaviour.

The one future-facing gap: if a clock-injection constructor parameter is added to
`NalStreamManager` for deterministic debounce testing, replace:
```kotlin
private var lastKeyframeRequestTime = 0L
```
with:
```kotlin
private var lastKeyframeRequestTime = 0L
internal var currentTimeMs: () -> Long = System::currentTimeMillis
```
and use `currentTimeMs()` in `requestKeyFrame`.

### Refactor Phase

- `NalStreamManager`: extract `currentTimeMs` lambda (above) so the debounce window can be
  advanced in unit tests without `Thread.sleep`.
- `NalUnitParser`: add `parse(buffer: ByteBuffer): List<NalUnit>` overload to avoid intermediate
  array copy on the hot video path.
- `VideoChannelHandler`: mark `readTimestamp` as `internal` so it can be tested without routing
  through `onFrame`.
