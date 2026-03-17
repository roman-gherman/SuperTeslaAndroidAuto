# 06 — Video ACK Flow: Unit Test Plan

## Overview

Tests cover: video session-ID parsing from `START_INDICATION` protobuf; the `sendAck` method
(not yet implemented) that encodes `{field1=sessionId, field2=1}` on `MEDIA_ACK / VIDEO` channel;
`AudioChannelHandler` ACK parity; and `ControlSocketServer` forwarding the `"ACK"` JSON action
to its `onAction` callback.

All code is written as compilable Kotlin targeting JUnit 5, MockK, and `kotlinx-coroutines-test`.

---

## Test Classes

| Test Class | File Path | Class Under Test |
|---|---|---|
| `VideoSessionIdParseTest` | `androidauto/src/test/java/com/supertesla/aa/androidauto/channels/VideoSessionIdParseTest.kt` | `VideoChannelHandler` |
| `VideoAckTest` | `androidauto/src/test/java/com/supertesla/aa/androidauto/channels/VideoAckTest.kt` | `VideoChannelHandler` |
| `AudioAckFormatTest` | `androidauto/src/test/java/com/supertesla/aa/androidauto/channels/AudioAckFormatTest.kt` | `AudioChannelHandler` |
| `ControlSocketAckRoutingTest` | `network/src/test/java/com/supertesla/aa/network/relay/ControlSocketAckRoutingTest.kt` | `ControlSocketServer` |

---

## Shared test helper

Both `VideoSessionIdParseTest` and `VideoAckTest` use the same frame builder.

File: `androidauto/src/test/java/com/supertesla/aa/androidauto/channels/AapFrameTestUtils.kt`

```kotlin
package com.supertesla.aa.androidauto.channels

import com.supertesla.aa.androidauto.protocol.AapFramer

/**
 * Constructs an AapFrame whose payload encodes [msgType] (2 bytes BE) followed by [body].
 * Uses FLAG_BULK (0x03) so isFirst and isLast are both true, making messageType / messageBody
 * computed properties accessible to the handler's onFrame implementation.
 */
internal fun buildAapFrame(msgType: Int, body: ByteArray): AapFramer.AapFrame {
    val payload = ByteArray(2 + body.size)
    payload[0] = (msgType shr 8).toByte()
    payload[1] = (msgType and 0xFF).toByte()
    System.arraycopy(body, 0, payload, 2, body.size)
    return AapFramer.AapFrame(
        channel = 2,
        flags   = AapFramer.FLAG_BULK,   // 0x03
        payload = payload
    )
}
```

---

## VideoSessionIdParseTest

File: `androidauto/src/test/java/com/supertesla/aa/androidauto/channels/VideoSessionIdParseTest.kt`

These tests verify that `onFrame(START_INDICATION)` correctly stores the session ID so that
`sendAck()` (once implemented) encodes the right value in field 1.  The tests trigger `sendAck()`
and inspect the captured `ChannelMux.sendEncrypted` call.

```kotlin
package com.supertesla.aa.androidauto.channels

import com.supertesla.aa.androidauto.proto.AvMessageType
import com.supertesla.aa.androidauto.proto.ChannelId
import com.supertesla.aa.androidauto.proto.ProtoEncoder
import com.supertesla.aa.androidauto.protocol.ChannelMux
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class VideoSessionIdParseTest {

    private val mockMux = mockk<ChannelMux>(relaxed = true)

    // -------------------------------------------------------------------------
    // Helper: sends START_INDICATION with a varint-encoded field1=sessionId,
    // then calls sendAck() and captures the ACK payload.
    // Returns the sessionId decoded from field 1 of the captured protobuf bytes.
    // -------------------------------------------------------------------------
    private suspend fun sessionIdRoundTrip(startBody: ByteArray): Int {
        val handler = VideoChannelHandler(mockMux)
        handler.onFrame(buildAapFrame(AvMessageType.START_INDICATION, startBody))
        handler.sendAck()

        val slot = slot<ByteArray>()
        verify { mockMux.sendEncrypted(ChannelId.VIDEO, AvMessageType.MEDIA_ACK, capture(slot)) }
        return ProtoEncoder.readFields(slot.captured)
            .first { it.fieldNumber == 1 }
            .intValue
    }

    @Test
    fun `START_INDICATION with field 1 = 42 stores sessionId 42`() = runTest {
        // Protobuf encoding: tag = (1 shl 3) or 0 = 0x08, value = 0x2A (42)
        val body = byteArrayOf(0x08, 0x2A)
        assertEquals(42, sessionIdRoundTrip(body))
    }

    @Test
    fun `START_INDICATION with empty body stores sessionId 0`() = runTest {
        assertEquals(0, sessionIdRoundTrip(ByteArray(0)))
    }

    @Test
    fun `START_INDICATION with corrupt varint body defaults to sessionId 0`() = runTest {
        // Incomplete multi-byte varint: tag present but value byte has high bit set with no
        // continuation — ProtoEncoder.readVarint will throw; handler must catch and use 0.
        val corrupt = byteArrayOf(0x08, 0xFF.toByte())
        assertEquals(0, sessionIdRoundTrip(corrupt))
    }

    @Test
    fun `START_INDICATION with proto3 default field 1 = 0 stores sessionId 0`() = runTest {
        // tag=0x08, value=0x00
        val body = byteArrayOf(0x08, 0x00)
        assertEquals(0, sessionIdRoundTrip(body))
    }

    @Test
    fun `START_INDICATION with session ID 65535 stores correctly`() = runTest {
        // 65535 as varint: 0xFF 0xFF 0x03 (LEB128)
        val body = byteArrayOf(0x08, 0xFF.toByte(), 0xFF.toByte(), 0x03)
        assertEquals(65535, sessionIdRoundTrip(body))
    }

    @Test
    fun `second START_INDICATION overwrites the first session ID`() = runTest {
        val handler = VideoChannelHandler(mockMux)
        handler.onFrame(buildAapFrame(AvMessageType.START_INDICATION, byteArrayOf(0x08, 0x01)))
        handler.onFrame(buildAapFrame(AvMessageType.START_INDICATION, byteArrayOf(0x08, 0x09)))

        handler.sendAck()

        val slot = slot<ByteArray>()
        verify { mockMux.sendEncrypted(ChannelId.VIDEO, AvMessageType.MEDIA_ACK, capture(slot)) }
        val sid = ProtoEncoder.readFields(slot.captured).first { it.fieldNumber == 1 }.intValue
        assertEquals(9, sid, "Second START_INDICATION must overwrite the first session ID")
    }
}
```

---

## VideoAckTest

File: `androidauto/src/test/java/com/supertesla/aa/androidauto/channels/VideoAckTest.kt`

`sendAck()` does not yet exist on `VideoChannelHandler`.  All tests here represent the RED state
and define the contract for the implementation.

```kotlin
package com.supertesla.aa.androidauto.channels

import com.supertesla.aa.androidauto.proto.AvMessageType
import com.supertesla.aa.androidauto.proto.ChannelId
import com.supertesla.aa.androidauto.proto.ProtoEncoder
import com.supertesla.aa.androidauto.protocol.ChannelMux
import io.mockk.any
import io.mockk.eq
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class VideoAckTest {

    private val mockMux = mockk<ChannelMux>(relaxed = true)

    /** Prepare a handler with a known session ID by replaying START_INDICATION. */
    private suspend fun handlerWithSession(sessionId: Int): VideoChannelHandler {
        val handler = VideoChannelHandler(mockMux)
        // Encode sessionId as protobuf varint field 1
        val body = encodeVarintField1(sessionId)
        handler.onFrame(buildAapFrame(AvMessageType.START_INDICATION, body))
        return handler
    }

    /** Encodes field 1 as a varint protobuf field (handles values 0..127 as 2 bytes). */
    private fun encodeVarintField1(value: Int): ByteArray {
        // For values 0-127: [0x08, value]
        // For larger values the test helpers below use specific encodings.
        return byteArrayOf(0x08, value.toByte())
    }

    // =========================================================================
    // Protobuf field encoding
    // =========================================================================

    @Test
    fun `sendAck encodes field 1 as the session ID`() = runTest {
        val handler = handlerWithSession(7)

        handler.sendAck()

        val slot = slot<ByteArray>()
        verify { mockMux.sendEncrypted(ChannelId.VIDEO, AvMessageType.MEDIA_ACK, capture(slot)) }
        val sid = ProtoEncoder.readFields(slot.captured).first { it.fieldNumber == 1 }.intValue
        assertEquals(7, sid)
    }

    @Test
    fun `sendAck encodes field 2 as literal 1 (ack flag)`() = runTest {
        val handler = handlerWithSession(5)

        handler.sendAck()

        val slot = slot<ByteArray>()
        verify { mockMux.sendEncrypted(any(), any(), capture(slot)) }
        val ack = ProtoEncoder.readFields(slot.captured).first { it.fieldNumber == 2 }.intValue
        assertEquals(1, ack)
    }

    @Test
    fun `sendAck produces exact wire bytes for sessionId=1`() = runTest {
        // field 1 tag=0x08, value=0x01 → [08 01]
        // field 2 tag=0x10, value=0x01 → [10 01]
        val handler = handlerWithSession(1)

        handler.sendAck()

        val slot = slot<ByteArray>()
        verify { mockMux.sendEncrypted(any(), any(), capture(slot)) }
        assertContentEquals(byteArrayOf(0x08, 0x01, 0x10, 0x01), slot.captured)
    }

    @Test
    fun `sendAck produces exact wire bytes for sessionId=0`() = runTest {
        // field 1: [08 00], field 2: [10 01]
        val handler = handlerWithSession(0)

        handler.sendAck()

        val slot = slot<ByteArray>()
        verify { mockMux.sendEncrypted(any(), any(), capture(slot)) }
        assertContentEquals(byteArrayOf(0x08, 0x00, 0x10, 0x01), slot.captured)
    }

    // =========================================================================
    // Routing: channel and message type
    // =========================================================================

    @Test
    fun `sendAck sends on VIDEO channel (ChannelId=3)`() = runTest {
        val handler = handlerWithSession(3)

        handler.sendAck()

        verify { mockMux.sendEncrypted(eq(ChannelId.VIDEO), any(), any()) }
    }

    @Test
    fun `sendAck uses message type MEDIA_ACK (0x8004)`() = runTest {
        val handler = handlerWithSession(1)

        handler.sendAck()

        verify { mockMux.sendEncrypted(any(), eq(AvMessageType.MEDIA_ACK), any()) }
    }

    // =========================================================================
    // Guard: do not send before START_INDICATION
    // =========================================================================

    @Test
    fun `sendAck does not call ChannelMux when called before START_INDICATION`() = runTest {
        // Fresh handler — sessionId is -1 by default (the guard condition)
        val handler = VideoChannelHandler(mockMux)

        handler.sendAck()

        verify(exactly = 0) { mockMux.sendEncrypted(any(), any(), any()) }
    }

    // =========================================================================
    // Multiple calls
    // =========================================================================

    @Test
    fun `sendAck called three times sends exactly three ACK messages`() = runTest {
        val handler = handlerWithSession(2)

        handler.sendAck()
        handler.sendAck()
        handler.sendAck()

        verify(exactly = 3) {
            mockMux.sendEncrypted(ChannelId.VIDEO, AvMessageType.MEDIA_ACK, any())
        }
    }

    @Test
    fun `sendAck uses the most-recently-parsed session ID`() = runTest {
        val handler = VideoChannelHandler(mockMux)
        handler.onFrame(buildAapFrame(AvMessageType.START_INDICATION, byteArrayOf(0x08, 0x01)))
        handler.onFrame(buildAapFrame(AvMessageType.START_INDICATION, byteArrayOf(0x08, 0x7F)))

        handler.sendAck()

        val slot = slot<ByteArray>()
        verify { mockMux.sendEncrypted(any(), any(), capture(slot)) }
        val sid = ProtoEncoder.readFields(slot.captured).first { it.fieldNumber == 1 }.intValue
        assertEquals(0x7F, sid)
    }
}
```

---

## AudioAckFormatTest

File: `androidauto/src/test/java/com/supertesla/aa/androidauto/channels/AudioAckFormatTest.kt`

Verifies that the existing private `sendAck()` in `AudioChannelHandler` uses the identical
protobuf layout that `VideoChannelHandler.sendAck()` must also produce.  These tests are GREEN
against the current code and serve as regression protection.

```kotlin
package com.supertesla.aa.androidauto.channels

import com.supertesla.aa.androidauto.proto.AvMessageType
import com.supertesla.aa.androidauto.proto.ProtoEncoder
import com.supertesla.aa.androidauto.protocol.ChannelMux
import io.mockk.any
import io.mockk.eq
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AudioAckFormatTest {

    private val mockMux = mockk<ChannelMux>(relaxed = true)

    /** Sends a START_INDICATION then a minimal MEDIA_WITH_TIMESTAMP to trigger sendAck(). */
    private suspend fun triggerAck(channelId: Int, sessionId: Int): AudioChannelHandler {
        val handler = AudioChannelHandler(
            channelId = channelId,
            channelName = "test",
            mux = mockMux
        )
        val startBody = byteArrayOf(0x08, sessionId.toByte())
        handler.onFrame(buildAapFrame(AvMessageType.START_INDICATION, startBody))

        // MEDIA_WITH_TIMESTAMP: 8-byte timestamp + 1 byte PCM so the frame is not discarded
        val pcmFrame = ByteArray(8) + byteArrayOf(0x01)
        handler.onFrame(buildAapFrame(AvMessageType.MEDIA_WITH_TIMESTAMP, pcmFrame))
        return handler
    }

    // =========================================================================
    // Field encoding
    // =========================================================================

    @Test
    fun `audio ACK encodes field 1 as the session ID received in START_INDICATION`() = runTest {
        triggerAck(channelId = 6, sessionId = 10)

        val slot = slot<ByteArray>()
        verify { mockMux.sendEncrypted(eq(6), eq(AvMessageType.MEDIA_ACK), capture(slot)) }
        val sid = ProtoEncoder.readFields(slot.captured).first { it.fieldNumber == 1 }.intValue
        assertEquals(10, sid)
    }

    @Test
    fun `audio ACK encodes field 2 = 1`() = runTest {
        triggerAck(channelId = 6, sessionId = 1)

        val slot = slot<ByteArray>()
        verify { mockMux.sendEncrypted(any(), any(), capture(slot)) }
        val ack = ProtoEncoder.readFields(slot.captured).first { it.fieldNumber == 2 }.intValue
        assertEquals(1, ack)
    }

    @Test
    fun `audio ACK byte encoding is exactly [08 01 10 01] for sessionId=1`() = runTest {
        triggerAck(channelId = 6, sessionId = 1)

        val slot = slot<ByteArray>()
        verify { mockMux.sendEncrypted(any(), any(), capture(slot)) }
        assertContentEquals(byteArrayOf(0x08, 0x01, 0x10, 0x01), slot.captured)
    }

    // =========================================================================
    // ACK frequency
    // =========================================================================

    @Test
    fun `audio ACK is sent exactly once per MEDIA_WITH_TIMESTAMP frame`() = runTest {
        val handler = AudioChannelHandler(6, "system", mockMux)
        handler.onFrame(buildAapFrame(AvMessageType.START_INDICATION, byteArrayOf(0x08, 0x01)))

        val ts  = ByteArray(8)
        val pcm = ByteArray(32) { 0x01 }
        repeat(5) {
            handler.onFrame(buildAapFrame(AvMessageType.MEDIA_WITH_TIMESTAMP, ts + pcm))
        }

        verify(exactly = 5) { mockMux.sendEncrypted(6, AvMessageType.MEDIA_ACK, any()) }
    }

    @Test
    fun `audio ACK is sent for MEDIA_INDICATION as well`() = runTest {
        val handler = AudioChannelHandler(6, "system", mockMux)
        handler.onFrame(buildAapFrame(AvMessageType.START_INDICATION, byteArrayOf(0x08, 0x02)))
        handler.onFrame(buildAapFrame(AvMessageType.MEDIA_INDICATION, ByteArray(32)))

        verify(exactly = 1) { mockMux.sendEncrypted(6, AvMessageType.MEDIA_ACK, any()) }
    }

    @Test
    fun `MEDIA_WITH_TIMESTAMP with body of 8 bytes or fewer does not trigger ACK`() = runTest {
        val handler = AudioChannelHandler(6, "system", mockMux)
        handler.onFrame(buildAapFrame(AvMessageType.START_INDICATION, byteArrayOf(0x08, 0x01)))
        // body == 8 bytes — guard: body.size <= 8 → return
        handler.onFrame(buildAapFrame(AvMessageType.MEDIA_WITH_TIMESTAMP, ByteArray(8)))

        verify(exactly = 0) { mockMux.sendEncrypted(any(), eq(AvMessageType.MEDIA_ACK), any()) }
    }

    // =========================================================================
    // Channel routing
    // =========================================================================

    @Test
    fun `audio ACK is sent on the handler's own channel ID`() = runTest {
        triggerAck(channelId = 5, sessionId = 1)   // media audio channel

        verify { mockMux.sendEncrypted(eq(5), eq(AvMessageType.MEDIA_ACK), any()) }
    }
}
```

---

## ControlSocketAckRoutingTest

File: `network/src/test/java/com/supertesla/aa/network/relay/ControlSocketAckRoutingTest.kt`

`ControlSocketServer.onMessage(String)` currently handles `"ACK"` with a comment-only branch and
does NOT forward it.  The first test documents the RED state and defines the required behaviour.

```kotlin
package com.supertesla.aa.network.relay

import io.mockk.mockk
import org.java_websocket.WebSocket
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/** Creates a relaxed mock WebSocket without needing an actual server socket. */
private fun fakeSocket(): WebSocket = mockk(relaxed = true)

class ControlSocketAckRoutingTest {

    // =========================================================================
    // ACK forwarding to onAction callback
    // =========================================================================

    @Test
    fun `ACK JSON message forwards action string ACK to onAction callback`() {
        // RED: current implementation does NOT forward — this test will fail until
        // the "ACK" branch is changed to: onAction("ACK", json)
        var receivedAction: String? = null
        val server = ControlSocketServer(
            port     = 0,
            onAction = { action, _ -> receivedAction = action },
            onTouch  = { _, _, _, _ -> }
        )

        server.onMessage(fakeSocket(), """{"action":"ACK"}""")

        assertEquals("ACK", receivedAction,
            "ACK message must be forwarded to the onAction callback")
    }

    @Test
    fun `ACK message does not invoke onTouch`() {
        var touchCalled = false
        val server = ControlSocketServer(
            port    = 0,
            onTouch = { _, _, _, _ -> touchCalled = true }
        )

        server.onMessage(fakeSocket(), """{"action":"ACK"}""")

        assertFalse(touchCalled)
    }

    @Test
    fun `ACK message does not throw when onAction is the default no-op`() {
        val server = ControlSocketServer(port = 0)

        assertDoesNotThrow {
            server.onMessage(fakeSocket(), """{"action":"ACK"}""")
        }
    }

    @Test
    fun `ACK message with extra JSON fields is still forwarded`() {
        var receivedAction: String? = null
        val server = ControlSocketServer(
            port     = 0,
            onAction = { action, _ -> receivedAction = action }
        )

        server.onMessage(fakeSocket(), """{"action":"ACK","frameId":42,"ts":1000}""")

        assertEquals("ACK", receivedAction)
    }

    // =========================================================================
    // Regression: other actions still route correctly after the ACK fix
    // =========================================================================

    @Test
    fun `REQUEST_KEYFRAME is still forwarded after ACK fix`() {
        var receivedAction: String? = null
        val server = ControlSocketServer(
            port     = 0,
            onAction = { action, _ -> receivedAction = action }
        )

        server.onMessage(fakeSocket(), """{"action":"REQUEST_KEYFRAME"}""")

        assertEquals("REQUEST_KEYFRAME", receivedAction)
    }

    @Test
    fun `START is still forwarded after ACK fix`() {
        var receivedAction: String? = null
        val server = ControlSocketServer(
            port     = 0,
            onAction = { action, _ -> receivedAction = action }
        )

        server.onMessage(fakeSocket(), """{"action":"START"}""")

        assertEquals("START", receivedAction)
    }
}
```

---

## Red / Green / Refactor

### Red Phase

**`VideoSessionIdParseTest`**: Currently, `VideoChannelHandler` parses the session ID in its
`START_INDICATION` branch, but `sendAck()` does not exist yet.  Every test calling
`handler.sendAck()` will fail with `Unresolved reference: sendAck`.

**`VideoAckTest`**: Same compilation failure — `sendAck` is missing.

**`AudioAckFormatTest`**: GREEN immediately against current code; serves as regression baseline.

**`ControlSocketAckRoutingTest`**: `ACK forwarding` test will fail because
`receivedAction` remains null (the branch is `"ACK" -> { /* log only */ }`).

### Green Phase

**`VideoChannelHandler`** — add:
```kotlin
private var sessionId: Int = -1   // -1 = not yet received

fun sendAck() {
    if (sessionId < 0) return
    val out = ByteArrayOutputStream()
    ProtoEncoder.writeVarintField(out, 1, sessionId.toLong())
    ProtoEncoder.writeVarintField(out, 2, 1L)
    mux.sendEncrypted(ChannelId.VIDEO, AvMessageType.MEDIA_ACK, out.toByteArray())
}
```

Update the `START_INDICATION` branch to set `sessionId`:
```kotlin
AvMessageType.START_INDICATION -> {
    sessionId = try {
        val fields = ProtoEncoder.readFields(body)
        fields.firstOrNull { it.fieldNumber == 1 }?.intValue ?: 0
    } catch (_: Exception) { 0 }
}
```

**`ControlSocketServer`** — change the `"ACK"` branch:
```kotlin
"ACK" -> onAction("ACK", json)
```

### Refactor Phase

- Extract a shared `AckPayload.encode(sessionId: Int): ByteArray` object so both
  `VideoChannelHandler` and `AudioChannelHandler` use identical encoding logic.
- Launch `sendAck()` inside an injected `CoroutineScope` to keep `VideoChannelHandler` coroutine-
  first and avoid fire-and-forget on the calling thread.
- Replace `ControlSocketServer`'s stringly-typed action dispatch with a sealed class
  `ControlAction` to make new actions type-safe and eliminate the raw `when (action)` string
  ladder.
