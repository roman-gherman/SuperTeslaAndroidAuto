# Unit Test Plan: 09 — Browser Keepalive & Video Focus Management

## Overview

Tests cover three concerns introduced by doc 09:

1. The 3-second keepalive watchdog that disables video focus when no PING arrives.
2. `NalStreamManager.toggleVideoFocus()` — focus retry when the video channel is not yet active.
3. `NalStreamManager.requestKeyFrame()` — 2-second debounce already present; tests make it explicit and lock the contract.
4. Binary PING response (5-byte sentinel).
5. Video focus disable on WebSocket `onClose`.

No Android framework dependencies touch the pure logic paths tested here; the watchdog timer logic is extracted into a `KeepaliveWatchdog` class that accepts a `CoroutineScope` + `clock` lambda, making it fully testable without `Handler`/`Looper`.

---

## Test Classes

### 1. `KeepaliveWatchdogTest`

**File:** `network/src/test/java/com/supertesla/aa/network/relay/KeepaliveWatchdogTest.kt`
**Class under test:** `com.supertesla.aa.network.relay.KeepaliveWatchdog`

Depends on: `kotlinx-coroutines-test`, `MockK`

---

### 2. `NalStreamManagerFocusTest`

**File:** `streaming/src/test/java/com/supertesla/aa/streaming/video/NalStreamManagerFocusTest.kt`
**Class under test:** `com.supertesla.aa.streaming.video.NalStreamManager`

Depends on: `kotlinx-coroutines-test`, `MockK`, `Turbine`

---

### 3. `NalStreamManagerKeyframeTest`

**File:** `streaming/src/test/java/com/supertesla/aa/streaming/video/NalStreamManagerKeyframeTest.kt`
**Class under test:** `com.supertesla.aa.streaming.video.NalStreamManager`

Depends on: `kotlinx-coroutines-test`, `MockK`

---

### 4. `PingResponseTest`

**File:** `network/src/test/java/com/supertesla/aa/network/relay/PingResponseTest.kt`
**Class under test:** `com.supertesla.aa.network.relay.ControlSocketServer` (extracted pure helper `buildPingResponse()`)

Depends on: JUnit 5 only (pure byte math)

---

## Gradle Dependency Additions

Add to each module's `build.gradle.kts` `dependencies` block if not already present:

```kotlin
testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
testImplementation("io.mockk:mockk:1.13.10")
testImplementation("app.cash.turbine:turbine:1.1.0")
```

---

## Test Cases

---

### KeepaliveWatchdogTest

#### Design contract for `KeepaliveWatchdog`

```kotlin
// Proposed production interface (KeepaliveWatchdog.kt)
class KeepaliveWatchdog(
    private val scope: CoroutineScope,
    private val timeoutMs: Long = 3_000L,
    private val onTimeout: () -> Unit,
    private val clock: () -> Long = System::currentTimeMillis
)
```

`reset()` cancels the running countdown and starts a fresh one.
`cancel()` cancels without firing `onTimeout`.

---

#### TC-01 — timeout fires after 3 seconds of silence

```
@Test
fun `onTimeout is invoked after timeoutMs of inactivity`()
```

Verifies: `onTimeout` lambda is called exactly once when `reset()` is never called after construction.

Arrange:
- `TestCoroutineScheduler` + `UnconfinedTestDispatcher`
- `onTimeout` records calls via a `MutableList<Unit>`
- Watchdog created with `timeoutMs = 3_000`

Act:
- Advance virtual time by `3_001` ms without calling `reset()`

Assert:
- `onTimeout` invocation count == 1

---

#### TC-02 — PING resets the timer; timeout does not fire if PINGs arrive

```
@Test
fun `repeated reset calls prevent onTimeout from firing`()
```

Verifies: each `reset()` pushes the deadline forward.

Arrange:
- Same scheduler; `timeoutMs = 3_000`
- `onTimeout` records calls

Act:
- Advance 2_000 ms, call `reset()`
- Advance 2_000 ms, call `reset()`
- Advance 2_000 ms, call `reset()`
- Advance 2_999 ms (total virtual time = 8_999 ms past start)

Assert:
- `onTimeout` invocation count == 0

---

#### TC-03 — timeout fires after last PING expires

```
@Test
fun `onTimeout fires 3s after the final reset call`()
```

Verifies: timer restarts from the last reset, not from construction.

Arrange:
- Watchdog with `timeoutMs = 3_000`

Act:
- Call `reset()` at T=0
- Advance 2_000 ms, call `reset()` again
- Advance 3_001 ms

Assert:
- `onTimeout` invocation count == 1

---

#### TC-04 — cancel prevents timeout from firing

```
@Test
fun `cancel stops the timer without invoking onTimeout`()
```

Verifies: `onClose` path uses `cancel()`, not just `reset()`.

Arrange:
- Watchdog with `timeoutMs = 3_000`

Act:
- Advance 1_000 ms
- Call `cancel()`
- Advance 5_000 ms

Assert:
- `onTimeout` invocation count == 0
- Watchdog scope job is cancelled (no active coroutine leaks)

---

#### TC-05 — timeout fires only once even if scheduler advances far past deadline

```
@Test
fun `onTimeout fires exactly once even when time advances far past the deadline`()
```

Verifies: no repeated firings after the first.

Arrange:
- Watchdog with `timeoutMs = 3_000`

Act:
- Advance 30_000 ms without calling `reset()`

Assert:
- `onTimeout` invocation count == 1

---

### NalStreamManagerFocusTest

#### TC-06 — toggleVideoFocus(true) invokes onSendVideoFocus with projected=true

```
@Test
fun `toggleVideoFocus true invokes callback with projected=true and unsolicited=false`()
```

Verifies: the callback contract matches what AA protocol expects for VIDEO_FOCUS_NATIVE vs PROJECTED.

Arrange:
- Fresh `NalStreamManager`
- `onSendVideoFocus` = mockk lambda capturing args

Act:
- `manager.toggleVideoFocus(true)`

Assert:
- Lambda called once with `(projected=true, unsolicited=false)`
- `manager.hasFocus == true`

---

#### TC-07 — toggleVideoFocus(false) invokes callback with projected=false

```
@Test
fun `toggleVideoFocus false invokes callback with projected=false and unsolicited=false`()
```

Arrange:
- Manager with focus already set to `true`

Act:
- `manager.toggleVideoFocus(false)`

Assert:
- Lambda called with `(false, false)`
- `manager.hasFocus == false`

---

#### TC-08 — toggleVideoFocus retry when isVideoActive is false

```
@Test
fun `toggleVideoFocus true retries after 300ms when video channel is not yet active`()
```

Verifies: focus is not lost permanently when the video channel opens slightly after the first focus request.

This test drives a new injectable `isVideoActive: () -> Boolean` parameter added to `NalStreamManager` (or a wrapper shim). Implementation detail: the watchdog pattern from TC-01/TC-02 applies; the retry is a single `delay(300)` + re-invoke inside a coroutine launched in the provided scope.

Arrange:
- `TestCoroutineScheduler` + `UnconfinedTestDispatcher`
- `isVideoActive` returns `false` initially, then `true`
- Lambda recorder

Act:
- `manager.toggleVideoFocus(true)` at T=0
- Advance 0 ms — no callback yet (channel not ready)
- Flip `isVideoActive` to return `true`
- Advance 300 ms

Assert:
- Lambda called once with `(true, false)` at T=300

---

#### TC-09 — no double callback when isVideoActive is already true

```
@Test
fun `toggleVideoFocus true invokes callback immediately when video channel is already active`()
```

Arrange:
- `isVideoActive` returns `true` immediately

Act:
- `manager.toggleVideoFocus(true)`

Assert:
- Lambda called synchronously (no scheduler advancement needed)
- Invocation count == 1

---

#### TC-10 — hasFocus reflects last toggleVideoFocus call

```
@Test
fun `hasFocus state is consistent with the last toggleVideoFocus argument`()
```

Arrange:
- Fresh manager

Act/Assert sequence:
- `toggleVideoFocus(true)` → `hasFocus == true`
- `toggleVideoFocus(false)` → `hasFocus == false`
- `toggleVideoFocus(true)` → `hasFocus == true`

---

### NalStreamManagerKeyframeTest

#### TC-11 — first keyframe request fires immediately

```
@Test
fun `requestKeyFrame invokes callback when no prior request has been made`()
```

Arrange:
- Fresh manager with mocked `onSendVideoFocus`
- `System.currentTimeMillis()` not yet manipulated (or manager created with clock=0)

Act:
- `manager.requestKeyFrame()`

Assert:
- `onSendVideoFocus` called with `(true, true)` (unsolicited=true = keyframe)

---

#### TC-12 — second keyframe request within 2 seconds is debounced

```
@Test
fun `requestKeyFrame is debounced and does not invoke callback within 2 seconds of the last request`()
```

Verifies: `KEYFRAME_DEBOUNCE_MS = 2000` is enforced.

Arrange:
- Manager with injectable `clock: () -> Long`
- clock starts at 0

Act:
- `requestKeyFrame()` at clock=0 — fires (count=1)
- `requestKeyFrame()` at clock=1_999 — debounced (count still 1)

Assert:
- `onSendVideoFocus` call count == 1

---

#### TC-13 — keyframe request after debounce window is allowed

```
@Test
fun `requestKeyFrame is allowed again after 2000ms have elapsed`()
```

Arrange:
- Same injectable clock

Act:
- `requestKeyFrame()` at clock=0 — fires
- `requestKeyFrame()` at clock=2_001 — fires

Assert:
- `onSendVideoFocus` call count == 2

---

#### TC-14 — requestKeyFrame is a no-op when onSendVideoFocus is null

```
@Test
fun `requestKeyFrame does not throw when onSendVideoFocus callback is not set`()
```

Arrange:
- Fresh manager, `onSendVideoFocus` left null

Act / Assert:
- `assertDoesNotThrow { manager.requestKeyFrame() }`

---

### PingResponseTest

#### TC-15 — PING response is exactly 5 bytes with correct values

```
@Test
fun `buildPingResponse returns a 5-byte array matching TaaDa sentinel`()
```

Verifies: binary response `[0x00, 0x00, 0x00, 0x00, 0x1F]`.

Arrange: N/A (pure function)

Act:
- `val response = buildPingResponse()`

Assert:
- `response.size == 5`
- `response[0] == 0x00.toByte()`
- `response[1] == 0x00.toByte()`
- `response[2] == 0x00.toByte()`
- `response[3] == 0x00.toByte()`
- `response[4] == 0x1F.toByte()`

---

#### TC-16 — buildPingResponse returns a new array on each call (no aliasing)

```
@Test
fun `buildPingResponse returns distinct array instances on repeated calls`()
```

Verifies: callers mutating the returned array cannot corrupt subsequent responses.

Arrange: N/A

Act:
- `val a = buildPingResponse(); val b = buildPingResponse()`

Assert:
- `a !== b`
- Contents are equal: `assertArrayEquals(a, b)`

---

## Red Phase

What fails before any production code is written:

- `KeepaliveWatchdogTest` — `KeepaliveWatchdog` class does not exist. All tests in TC-01 through TC-05 fail with `ClassNotFoundException`.
- `NalStreamManagerFocusTest` TC-08, TC-09 — `NalStreamManager` does not accept an `isVideoActive` parameter and has no retry path. TC-08 times out waiting for the callback; TC-09 passes trivially but for the wrong reason.
- `NalStreamManagerKeyframeTest` TC-12, TC-13 — `NalStreamManager.requestKeyFrame()` calls `System.currentTimeMillis()` directly; the clock cannot be injected. Tests are non-deterministic and will flake.
- `PingResponseTest` — `buildPingResponse()` top-level function does not exist. TC-15 and TC-16 fail with `UnresolvedReference`.

---

## Green Phase

Minimal changes to make each test class green, in order:

### 1. Add `KeepaliveWatchdog`

```kotlin
// network/src/main/java/com/supertesla/aa/network/relay/KeepaliveWatchdog.kt
class KeepaliveWatchdog(
    private val scope: CoroutineScope,
    private val timeoutMs: Long = 3_000L,
    private val onTimeout: () -> Unit
) {
    private var job: Job? = null

    fun reset() {
        job?.cancel()
        job = scope.launch {
            delay(timeoutMs)
            onTimeout()
        }
    }

    fun cancel() {
        job?.cancel()
        job = null
    }
}
```

No clock injection is needed at this stage because `TestCoroutineScheduler` controls `delay()` in tests. All TC-01 through TC-05 go green.

### 2. Add `isVideoActive` injection to `NalStreamManager.toggleVideoFocus`

```kotlin
// Minimal change: add a nullable functional property
var isVideoActive: (() -> Boolean)? = null

fun toggleVideoFocus(focused: Boolean) {
    if (focused && isVideoActive?.invoke() == false) {
        focusScope.launch {
            delay(300)
            toggleVideoFocus(true)
        }
        return
    }
    hasFocus = focused
    onSendVideoFocus?.invoke(focused, false)
}
```

`focusScope` is a `CoroutineScope` constructor parameter defaulting to `GlobalScope` for production; tests inject a `TestScope`. TC-08 and TC-09 go green.

### 3. Inject clock into `requestKeyFrame`

```kotlin
// Add internal-visible property for testing:
internal var clock: () -> Long = System::currentTimeMillis

fun requestKeyFrame() {
    val now = clock()
    if (now - lastKeyframeRequestTime < KEYFRAME_DEBOUNCE_MS) return
    lastKeyframeRequestTime = now
    onSendVideoFocus?.invoke(true, true)
}
```

TC-11 through TC-14 go green.

### 4. Add `buildPingResponse` top-level function

```kotlin
// network/src/main/java/com/supertesla/aa/network/relay/PingResponse.kt
fun buildPingResponse(): ByteArray = byteArrayOf(0, 0, 0, 0, 0x1F)
```

TC-15 and TC-16 go green.

---

## Refactor Phase

After all tests are green:

1. **`KeepaliveWatchdog` scope safety**: replace `GlobalScope.launch` pattern in production caller (`ControlSocketServer`) with a properly supervised `CoroutineScope(SupervisorJob() + Dispatchers.Default)` stored as a member and cancelled in `onClose`. No test changes needed.

2. **`NalStreamManager` scope parameter**: remove `GlobalScope` default from `toggleVideoFocus`; require callers to pass a `CoroutineScope` via constructor. Update TC-08 to construct with an explicit `TestScope`.

3. **Clock extraction**: move the `clock` property from `internal` to a constructor parameter with a default:
   ```kotlin
   class NalStreamManager(
       private val clock: () -> Long = System::currentTimeMillis
   )
   ```
   This removes the `internal` modifier needed for test access and aligns with the constructor-injection idiom used elsewhere.

4. **`buildPingResponse` visibility**: keep the function `internal` to the `:network` module; expose it through `ControlSocketServer` only. PingResponseTest resides in the same module so `internal` is visible.

5. **Merge `NalStreamManagerFocusTest` and `NalStreamManagerKeyframeTest`** into a single `NalStreamManagerTest` file once both are stable, grouped by nested `@Nested` classes for focus and keyframe concerns.
