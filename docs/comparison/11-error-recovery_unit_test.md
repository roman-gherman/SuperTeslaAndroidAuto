# Unit Test Plan: 11 — Error Handling & Recovery

## Overview

Tests cover five distinct error-handling concerns introduced by doc 11:

1. Per-message error isolation in `ChannelMux.dispatch()` — a throwing handler must not abort the read loop.
2. `NalStreamManager.requestKeyFrame()` fallback — exception during the focus invocation triggers a focus-toggle cycle.
3. Reconnect attempt limit in the service reconnect loop (extracted to `ReconnectPolicy`).
4. Shutdown notification broadcast (extracted to a pure `ShutdownNotifier`).
5. Per-frame error isolation in channel handler `onFrame()` — malformed protobuf skips the frame, does not propagate.

---

## Test Classes

### 1. `ChannelMuxDispatchErrorTest`

**File:** `androidauto/src/test/java/com/supertesla/aa/androidauto/protocol/ChannelMuxDispatchErrorTest.kt`
**Class under test:** `com.supertesla.aa.androidauto.protocol.ChannelMux` (specifically the `dispatch()` private method, exercised via the read loop)

Depends on: JUnit 5, `kotlinx-coroutines-test`, MockK

---

### 2. `NalStreamManagerKeyframeErrorTest`

**File:** `streaming/src/test/java/com/supertesla/aa/streaming/video/NalStreamManagerKeyframeErrorTest.kt`
**Class under test:** `com.supertesla.aa.streaming.video.NalStreamManager`

Depends on: JUnit 5, `kotlinx-coroutines-test`, MockK

---

### 3. `ReconnectPolicyTest`

**File:** `core/src/test/java/com/supertesla/aa/core/util/ReconnectPolicyTest.kt`
**Class under test:** `com.supertesla.aa.core.util.ReconnectPolicy`

Depends on: JUnit 5, `kotlinx-coroutines-test`

---

### 4. `ShutdownNotifierTest`

**File:** `core/src/test/java/com/supertesla/aa/core/util/ShutdownNotifierTest.kt`
**Class under test:** `com.supertesla.aa.core.util.ShutdownNotifier`

Depends on: JUnit 5, MockK, `kotlinx-coroutines-test`

---

### 5. `ChannelHandlerErrorIsolationTest`

**File:** `androidauto/src/test/java/com/supertesla/aa/androidauto/protocol/ChannelHandlerErrorIsolationTest.kt`
**Class under test:** A concrete `ChannelHandler` implementation under test (e.g. a fake `ThrowingChannelHandler` and a representative `SafeChannelHandler` verifying the try-catch wrapper pattern)

Depends on: JUnit 5, `kotlinx-coroutines-test`, MockK

---

## Gradle Dependency Additions

```kotlin
testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
testImplementation("io.mockk:mockk:1.13.10")
```

---

## Test Cases

---

### ChannelMuxDispatchErrorTest

The `ChannelMux.dispatch()` method already has a `try-catch` around `handler.onFrame(frame)`. These tests lock that contract.

#### TC-01 — throwing handler does not propagate exception to the read loop

```
@Test
fun `an exception thrown by a channel handler is caught and the mux continues processing`()
```

Verifies: error in handler on channel N does not terminate processing of channel M frames.

Arrange:
- Fake `InputStream` backed by a `ByteArrayInputStream` that contains two valid frame bytes:
  - Frame A on channel 1 (handler throws `RuntimeException`)
  - Frame B on channel 2 (handler records call)
- `AapFramer` reading from the stream
- `AapCrypto` with `isHandshakeComplete = false` (no decryption)
- `ChannelMux` with:
  - channel 1 handler: `ThrowingHandler(RuntimeException("boom"))`
  - channel 2 handler: `RecordingHandler`

Act:
- Run `mux.readLoop()` until the stream is exhausted (coroutine completes normally)

Assert:
- `RecordingHandler.frameCount == 1` — frame B was still dispatched after the channel 1 exception
- No exception escapes the `readLoop()`

---

#### TC-02 — handler throwing does not corrupt the reassembly buffer for other channels

```
@Test
fun `handler exception does not corrupt multi-frame reassembly on unrelated channels`()
```

Arrange:
- Channel 3 sends a three-part fragmented message (FIRST / MIDDLE / LAST)
- Channel 1 throws on the MIDDLE fragment of its own message (interleaved in the stream)

Act:
- `readLoop()` processes all frames in order

Assert:
- Channel 3's handler receives the fully reassembled payload
- `reassemblyBuffers` for channel 3 is cleared after the LAST frame

---

#### TC-03 — IOException from framer ends the read loop cleanly

```
@Test
fun `IOException from AapFramer terminates readLoop without rethrowing`()
```

Verifies: `ChannelMux.readLoop()` exits via the `IOException` catch branch on real network errors.

Arrange:
- `AapFramer` mock throws `IOException("connection reset")` on first call

Act:
- `mux.readLoop()` completes

Assert:
- No exception escapes (no `assertThrows` needed — just `assertDoesNotThrow`)
- Coroutine finishes naturally

---

#### TC-04 — decryption failure skips the frame but continues the loop

```
@Test
fun `decryption exception causes the frame to be skipped without terminating the loop`()
```

Verifies: the `continue` inside the decryption try-catch (line 54 of `ChannelMux.kt`).

Arrange:
- Two frames in the stream, both marked `isEncrypted = true`
- `AapCrypto` mock: throws `Exception("bad record")` on first decrypt, returns valid bytes on second
- `isHandshakeComplete = true` on the mock

Act:
- `readLoop()`

Assert:
- Handler for frame 2 was called once
- Handler for frame 1 was never called

---

### NalStreamManagerKeyframeErrorTest

#### TC-05 — exception in onSendVideoFocus during requestKeyFrame triggers fallback

```
@Test
fun `requestKeyFrame falls back to focus toggle when onSendVideoFocus throws`()
```

Verifies: the catch block in `requestKeyFrame()` calls `toggleVideoFocus(false)` and then schedules `toggleVideoFocus(true)` after 500 ms.

Arrange:
- `TestScope` with `UnconfinedTestDispatcher`
- `manager.onSendVideoFocus` = lambda that:
  - Throws `RuntimeException("keyframe failed")` when `unsolicited == true`
  - Records calls otherwise (for the recovery toggle)
- Manager with injectable `clock` starting at 0

Act:
- `manager.requestKeyFrame()`
- Advance virtual time 0 ms (synchronous part)

Assert at T=0:
- Focus is now `false` (fallback toggle fired)

Advance 500 ms:

Assert at T=500:
- `onSendVideoFocus` called with `(true, false)` — the recovery "focus on" call
- `manager.hasFocus == true`

---

#### TC-06 — no fallback when onSendVideoFocus succeeds

```
@Test
fun `requestKeyFrame does not invoke the fallback toggle path when the callback succeeds`()
```

Arrange:
- `onSendVideoFocus` records calls without throwing
- Manager with `hasFocus = true` before the call

Act:
- `manager.requestKeyFrame()`

Assert:
- `hasFocus` remains `true`
- `onSendVideoFocus` called exactly once with `(true, true)` — the keyframe request only
- No `toggleVideoFocus(false)` call

---

#### TC-07 — null onSendVideoFocus does not cause NPE in requestKeyFrame

```
@Test
fun `requestKeyFrame with null callback does not throw when callback is not set`()
```

Arrange:
- `manager.onSendVideoFocus = null`

Act / Assert:
- `assertDoesNotThrow { manager.requestKeyFrame() }`

---

### ReconnectPolicyTest

#### Design contract for `ReconnectPolicy`

```kotlin
// Extracted from TransporterService reconnect loop
class ReconnectPolicy(
    val maxAttempts: Int = 30,
    private val delayMs: Long = 2_500L,
    private val scope: CoroutineScope
) {
    var currentAttempt: Int = 0
        private set

    val isExhausted: Boolean get() = currentAttempt >= maxAttempts

    // Called before each reconnect attempt; suspends for delayMs.
    // Returns false if attempts are exhausted.
    suspend fun waitForNextAttempt(): Boolean
    fun reset()
}
```

---

#### TC-08 — waitForNextAttempt returns true and increments attempt counter

```
@Test
fun `waitForNextAttempt returns true and increments currentAttempt on each call`()
```

Arrange:
- `policy = ReconnectPolicy(maxAttempts = 30, delayMs = 0, scope = testScope)`

Act:
- Call `waitForNextAttempt()` three times (with 0 delay, no advancement needed)

Assert:
- Returns `true` on all three calls
- `currentAttempt == 3`

---

#### TC-09 — waitForNextAttempt returns false when maxAttempts is reached

```
@Test
fun `waitForNextAttempt returns false when currentAttempt reaches maxAttempts`()
```

Arrange:
- `policy = ReconnectPolicy(maxAttempts = 3, delayMs = 0, scope = testScope)`

Act:
- Call `waitForNextAttempt()` 3 times (all return `true`)
- Call `waitForNextAttempt()` a 4th time

Assert:
- 4th call returns `false`
- `isExhausted == true`

---

#### TC-10 — waitForNextAttempt suspends for delayMs before returning

```
@Test
fun `waitForNextAttempt suspends for delayMs before returning`()
```

Arrange:
- `policy = ReconnectPolicy(maxAttempts = 5, delayMs = 2_500, scope = testScope)`

Act:
- Launch coroutine calling `waitForNextAttempt()`
- Assert: coroutine is still suspended at T=2_499 ms
- Advance to T=2_500 ms

Assert:
- Coroutine completes, `currentAttempt == 1`

---

#### TC-11 — reset restores currentAttempt to zero

```
@Test
fun `reset sets currentAttempt back to zero and clears exhausted state`()
```

Arrange:
- `policy` with `maxAttempts = 2`
- Call `waitForNextAttempt()` twice → `isExhausted == true`

Act:
- `policy.reset()`

Assert:
- `currentAttempt == 0`
- `isExhausted == false`
- Next `waitForNextAttempt()` returns `true`

---

#### TC-12 — exhausted policy does not delay (fast-fail)

```
@Test
fun `waitForNextAttempt on an exhausted policy returns false without delaying`()
```

Verifies: a caller polling in a while loop does not stall indefinitely after exhaustion.

Arrange:
- `policy` with `maxAttempts = 1, delayMs = 10_000`
- Exhaust by calling `waitForNextAttempt()` once

Act:
- `val result = policy.waitForNextAttempt()` (4th call)

Assert:
- `result == false` immediately (virtual time not advanced)

---

### ShutdownNotifierTest

#### Design contract for `ShutdownNotifier`

```kotlin
// Extracted pure logic: formats and dispatches the shutdown JSON
interface ClientBroadcaster {
    suspend fun broadcast(message: String)
}

class ShutdownNotifier(
    private val broadcaster: ClientBroadcaster,
    private val drainDelayMs: Long = 500L,
    private val scope: CoroutineScope
) {
    suspend fun notifyShutdown(reason: String)
}
```

---

#### TC-13 — notifyShutdown broadcasts a JSON message with correct type and reason

```
@Test
fun `notifyShutdown sends a JSON object with type=server_shutdown and the given reason`()
```

Arrange:
- `broadcaster = mockk<ClientBroadcaster>(relaxed = true)`
- `notifier = ShutdownNotifier(broadcaster, drainDelayMs = 0, scope = testScope)`

Act:
- `notifier.notifyShutdown("service_stopping")`

Assert:
- `broadcaster.broadcast()` called once
- Argument contains `"type":"server_shutdown"` and `"reason":"service_stopping"`
- Valid JSON (parse with `org.json.JSONObject` or `kotlinx.serialization`)

---

#### TC-14 — notifyShutdown waits drainDelayMs before returning

```
@Test
fun `notifyShutdown suspends for drainDelayMs to allow clients to receive the message`()
```

Arrange:
- `drainDelayMs = 500`

Act:
- Launch coroutine calling `notifyShutdown("test")`
- Assert: coroutine suspended at T=499 ms
- Advance to T=500 ms

Assert:
- Coroutine completes

---

#### TC-15 — notifyShutdown sends broadcast before the drain delay begins

```
@Test
fun `broadcast is invoked before drainDelayMs delay begins`()
```

Verifies: message is sent first, then we wait (not the other way).

Arrange:
- `drainDelayMs = 500`
- `broadcaster` records call time using the test scheduler's `currentTime`

Act:
- Launch `notifyShutdown("stopping")`
- Advance 0 ms (synchronous send)

Assert:
- `broadcaster.broadcast()` call count == 1 at T=0
- Coroutine still suspended (drain not complete)

---

#### TC-16 — broadcaster exception does not prevent function from returning

```
@Test
fun `notifyShutdown does not propagate an exception thrown by the broadcaster`()
```

Verifies: graceful shutdown path does not itself crash.

Arrange:
- `broadcaster` throws `Exception("ws closed")` on `broadcast()`

Act / Assert:
- `assertDoesNotThrow { runTest { notifier.notifyShutdown("stopping") } }`

---

### ChannelHandlerErrorIsolationTest

These tests verify the `try-catch` wrapper in `onFrame()` for a concrete handler. The test uses a `FakeVideoChannelHandler` that delegates to a configurable inner `processFrame` lambda — making throw/no-throw behaviour injectable.

#### TC-17 — onFrame catching an exception does not rethrow

```
@Test
fun `onFrame catches exceptions from inner processing and does not rethrow them`()
```

Verifies: the channel handler wrapper pattern from doc 11 Step 1.

Arrange:
- `handler = SafeChannelHandler { throw RuntimeException("malformed protobuf") }`
- `frame = AapFrame(channel=1, messageType=0x01, payload=ByteArray(0), flags=0x0B)`

Act / Assert:
- `assertDoesNotThrow { runTest { handler.onFrame(frame) } }`

---

#### TC-18 — onFrame with an exception still processes subsequent frames

```
@Test
fun `onFrame exception on one frame does not prevent processing of the next frame`()
```

Arrange:
- `callCount = AtomicInt(0)`
- Handler: throws on first `onFrame()` call, increments `callCount` on second

Act:
- Call `handler.onFrame(frame1)` — throws internally
- Call `handler.onFrame(frame2)` — succeeds

Assert:
- `callCount.get() == 1`

---

#### TC-19 — CancellationException is not swallowed by the handler catch block

```
@Test
fun `CancellationException is not caught by the per-frame error handler`()
```

Verifies: structured concurrency is not broken by overly broad catch clauses.

Arrange:
- Handler inner block throws `CancellationException`

Act / Assert:
- `assertThrows<CancellationException> { runTest { handler.onFrame(frame) } }`

This test will fail if the production catch block uses `catch (e: Exception)` without re-throwing `CancellationException`. The green phase requires the catch to become:

```kotlin
} catch (e: CancellationException) {
    throw e  // never swallow cancellation
} catch (e: Exception) {
    Timber.w(e, "Error processing frame ...")
}
```

---

## Red Phase

What fails before any production code is written:

- `ChannelMuxDispatchErrorTest` TC-01 / TC-02: `ChannelMux.dispatch()` already has a `try-catch`, so TC-01 likely passes. TC-02 fails only if the reassembly buffer lookup crosses channel IDs (which it doesn't in the current code). These tests are primarily regression guards. TC-04 fails because the `continue` exists but the test infrastructure (fake `AapFramer`) does not yet exist.
- `NalStreamManagerKeyframeErrorTest` TC-05: `NalStreamManager.requestKeyFrame()` does not have a `try-catch` around `onSendVideoFocus?.invoke()` and no fallback toggle logic. TC-05 fails because an exception in the lambda propagates to the test.
- `ReconnectPolicyTest` TC-08 through TC-12: `ReconnectPolicy` does not exist; all tests throw `ClassNotFoundException`.
- `ShutdownNotifierTest` TC-13 through TC-16: `ShutdownNotifier` does not exist; all tests fail.
- `ChannelHandlerErrorIsolationTest` TC-19: existing channel handlers use bare `catch (e: Exception)` which swallows `CancellationException`. TC-19 throws `AssertionFailedError` because no `CancellationException` escapes.

---

## Green Phase

### 1. Regression-lock `ChannelMux.dispatch()` error handling

No code changes needed for TC-01 and TC-02 — they are regression tests for behaviour that already exists. TC-03 requires a fake `AapFramer` factory; provide it in `androidauto/src/test/`. TC-04 requires:

```kotlin
// AapCrypto mock helper in test:
val mockCrypto = mockk<AapCrypto> {
    every { isHandshakeComplete } returns true
    every { decrypt(any()) } throws Exception("bad record") andThen byteArrayOf(0x01)
}
```

No production code changes for TC-01 through TC-04.

### 2. Add keyframe fallback to `NalStreamManager.requestKeyFrame()`

```kotlin
fun requestKeyFrame() {
    val now = clock()
    if (now - lastKeyframeRequestTime < KEYFRAME_DEBOUNCE_MS) return
    lastKeyframeRequestTime = now
    try {
        onSendVideoFocus?.invoke(true, true)
    } catch (e: Exception) {
        Timber.w(e, "$TAG: Keyframe request failed, toggling focus")
        toggleVideoFocus(false)
        focusScope.launch {
            delay(500)
            toggleVideoFocus(true)
        }
    }
}
```

TC-05 and TC-06 go green.

### 3. Create `ReconnectPolicy`

```kotlin
class ReconnectPolicy(
    val maxAttempts: Int = 30,
    private val delayMs: Long = 2_500L,
    private val scope: CoroutineScope
) {
    var currentAttempt: Int = 0
        private set

    val isExhausted: Boolean get() = currentAttempt >= maxAttempts

    suspend fun waitForNextAttempt(): Boolean {
        if (isExhausted) return false
        currentAttempt++
        delay(delayMs)
        return true
    }

    fun reset() { currentAttempt = 0 }
}
```

TC-08 through TC-12 go green.

### 4. Create `ShutdownNotifier`

```kotlin
class ShutdownNotifier(
    private val broadcaster: ClientBroadcaster,
    private val drainDelayMs: Long = 500L,
    private val scope: CoroutineScope
) {
    suspend fun notifyShutdown(reason: String) {
        try {
            broadcaster.broadcast("""{"type":"server_shutdown","reason":"$reason"}""")
        } catch (e: Exception) {
            Timber.w(e, "ShutdownNotifier: broadcast failed")
        }
        delay(drainDelayMs)
    }
}
```

TC-13 through TC-16 go green.

### 5. Fix `CancellationException` swallowing in channel handlers

For every `ChannelHandler.onFrame()` implementation:

```kotlin
override suspend fun onFrame(frame: AapFramer.AapFrame) {
    try {
        processFrameInternal(frame)
    } catch (e: CancellationException) {
        throw e
    } catch (e: Exception) {
        Timber.w(e, "Error processing frame on channel $channelId, msgType=${frame.messageType}")
    }
}
```

TC-17, TC-18, TC-19 all go green.

---

## Refactor Phase

After all tests are green:

1. **`ReconnectPolicy` scope**: the `scope` parameter is only used indirectly (the `delay` suspends the caller's coroutine, not a launched child). Remove the `scope` constructor parameter; `waitForNextAttempt` is a `suspend fun` and respects the caller's cancellation automatically. Update TC-08 through TC-12 to remove `scope` from construction.

2. **`ShutdownNotifier` JSON safety**: replace string interpolation `"reason":"$reason"` with `kotlinx.serialization` or `JSONObject` to handle characters that would break JSON (e.g. a reason containing a double-quote). Add TC-20:
   ```
   @Test
   fun `notifyShutdown escapes special characters in the reason string`()
   ```

3. **`ChannelMux` handler registration null safety**: `handlers` map allows null lookups silently. After TC-01 through TC-04 are locked, extract `dispatch()` into its own tested class `FrameDispatcher` with a cleaner interface — making the dispatch test independent of the full `readLoop()` infrastructure.

4. **`NalStreamManager` `focusScope` parameter**: TC-05 injects a `TestScope` for `focusScope`. Once the refactor from doc 09 (TC-08) and this doc are merged, ensure a single `focusScope` constructor parameter covers both retry and fallback use cases. One scope, one lifecycle — avoids leak vectors.

5. **Extract `buildShutdownMessage` pure function**: the JSON string in `ShutdownNotifier.notifyShutdown()` becomes a top-level `internal fun buildShutdownMessage(reason: String): String`. Add a TC that verifies the output is valid JSON independently of the broadcaster mock.
