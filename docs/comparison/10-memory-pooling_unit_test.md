# Unit Test Plan: 10 — Memory Management & Buffer Pooling

## Overview

Tests cover four distinct units introduced by doc 10:

1. `ByteArrayPool` — acquire/release cycling, size enforcement, capacity cap.
2. `MemoryMonitor` — threshold classification (OK / WARNING / CRITICAL) with an injectable `Runtime` facade.
3. `AapCrypto` — mutex serialisation preventing concurrent encrypt/decrypt calls from racing on `SSLEngine`.
4. OOM recovery scheduling logic extracted from `TransporterService` into a testable `OomRecoveryScheduler`.

---

## Test Classes

### 1. `ByteArrayPoolTest`

**File:** `core/src/test/java/com/supertesla/aa/core/util/ByteArrayPoolTest.kt`
**Class under test:** `com.supertesla.aa.core.util.ByteArrayPool`

Depends on: JUnit 5 only (pure JVM, no Android)

---

### 2. `MemoryMonitorTest`

**File:** `core/src/test/java/com/supertesla/aa/core/util/MemoryMonitorTest.kt`
**Class under test:** `com.supertesla.aa.core.util.MemoryMonitor`

Depends on: JUnit 5, MockK (to stub the `RuntimeInfo` facade)

---

### 3. `AapCryptoMutexTest`

**File:** `androidauto/src/test/java/com/supertesla/aa/androidauto/protocol/AapCryptoMutexTest.kt`
**Class under test:** `com.supertesla.aa.androidauto.protocol.AapCrypto`

Depends on: JUnit 5, `kotlinx-coroutines-test`, MockK

---

### 4. `OomRecoverySchedulerTest`

**File:** `core/src/test/java/com/supertesla/aa/core/util/OomRecoverySchedulerTest.kt`
**Class under test:** `com.supertesla.aa.core.util.OomRecoveryScheduler`

Depends on: JUnit 5, `kotlinx-coroutines-test`

---

## Gradle Dependency Additions

Add to each relevant module's `build.gradle.kts`:

```kotlin
testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
testImplementation("io.mockk:mockk:1.13.10")
```

---

## Test Cases

---

### ByteArrayPoolTest

#### TC-01 — acquire from empty pool allocates a new array of the correct size

```
@Test
fun `acquire from an empty pool returns a new ByteArray of the configured bufferSize`()
```

Verifies: when the pool is cold, allocation falls back to `ByteArray(bufferSize)`.

Arrange:
- `val pool = ByteArrayPool(maxSize = 4, bufferSize = 1024)`

Act:
- `val buf = pool.acquire()`

Assert:
- `buf.size == 1024`

---

#### TC-02 — released buffer is returned by the next acquire (no allocation)

```
@Test
fun `acquire returns a previously released buffer instead of allocating a new one`()
```

Verifies: pool recycles without allocating.

Arrange:
- `pool = ByteArrayPool(maxSize = 4, bufferSize = 1024)`
- `val original = pool.acquire()`
- Write a sentinel byte: `original[0] = 0x42`

Act:
- `pool.release(original)`
- `val recycled = pool.acquire()`

Assert:
- `recycled === original` (same reference — identity check)

---

#### TC-03 — acquire after empty pool following multiple cycles allocates fresh

```
@Test
fun `acquire allocates a fresh array when pool is empty after all buffers have been acquired`()
```

Arrange:
- `pool = ByteArrayPool(maxSize = 2, bufferSize = 512)`
- Acquire two buffers (exhausts pool)

Act:
- `val third = pool.acquire()`

Assert:
- `third.size == 512` (correct size, new allocation)

---

#### TC-04 — release beyond maxSize drops the buffer (pool does not grow unbounded)

```
@Test
fun `releasing more buffers than maxSize does not grow the pool beyond maxSize`()
```

Verifies: the `pool.size < maxSize` guard in `release()`.

Arrange:
- `pool = ByteArrayPool(maxSize = 2, bufferSize = 256)`
- Acquire 4 buffers externally (they were allocated fresh)

Act:
- Release all 4 buffers back to the pool

Assert:
- After the 4 releases, draining the pool (acquire until fresh allocation) yields exactly 2 recycled references before a fresh allocation occurs.

Pseudocode:
```
val bufs = (1..4).map { ByteArray(256) }
bufs.forEach { pool.release(it) }
val r1 = pool.acquire()  // recycled
val r2 = pool.acquire()  // recycled
val r3 = pool.acquire()  // fresh (pool empty)
assertNotSame(r3, bufs[0])
assertNotSame(r3, bufs[1])
assertEquals(256, r3.size)
```

---

#### TC-05 — release ignores buffers of the wrong size

```
@Test
fun `release silently ignores a buffer whose size does not match bufferSize`()
```

Verifies: wrong-size buffers are not pooled (would corrupt callers expecting `bufferSize` bytes).

Arrange:
- `pool = ByteArrayPool(maxSize = 4, bufferSize = 1024)`
- Create `val wrongSize = ByteArray(512)`

Act:
- `pool.release(wrongSize)`
- `val acquired = pool.acquire()`

Assert:
- `acquired !== wrongSize` (wrong-size buffer was not stored)
- `acquired.size == 1024`

---

#### TC-06 — acquire/release is thread-safe under concurrent access

```
@Test
fun `ByteArrayPool acquire and release are safe under concurrent coroutine access`()
```

Verifies: `synchronized(pool)` prevents data races.

Arrange:
- `pool = ByteArrayPool(maxSize = 8, bufferSize = 64)`
- `TestScope` with `UnconfinedTestDispatcher`

Act:
- Launch 100 coroutines; each acquires, writes `0xAB` to `buf[0]`, reads it back, releases.

Assert:
- No `ConcurrentModificationException` thrown
- No `IndexOutOfBoundsException` thrown
- All 100 coroutines complete successfully

---

### MemoryMonitorTest

#### Design contract for `MemoryMonitor`

```kotlin
// Proposed injectable interface (RuntimeInfo.kt)
interface RuntimeInfo {
    val totalMemory: Long
    val freeMemory: Long
    val maxMemory: Long
}

// Default implementation delegates to Runtime.getRuntime()
object SystemRuntimeInfo : RuntimeInfo { ... }

object MemoryMonitor {
    enum class Status { OK, WARNING, CRITICAL }
    fun check(runtime: RuntimeInfo = SystemRuntimeInfo): Status { ... }
}
```

---

#### TC-07 — status is OK when heap usage is below 80 percent

```
@Test
fun `check returns OK when used heap is below 80 percent of max`()
```

Arrange:
- `runtime` stub: `totalMemory=100, freeMemory=30, maxMemory=100`
- Used = 70, ratio = 0.70 → below 0.80

Act:
- `val status = MemoryMonitor.check(runtime)`

Assert:
- `status == MemoryMonitor.Status.OK`

---

#### TC-08 — status is WARNING when heap usage is between 80 and 90 percent

```
@Test
fun `check returns WARNING when used heap is between 80 and 90 percent of max`()
```

Arrange:
- `totalMemory=100, freeMemory=15, maxMemory=100`
- Used = 85, ratio = 0.85

Assert:
- `status == MemoryMonitor.Status.WARNING`

---

#### TC-09 — status is CRITICAL when heap usage exceeds 90 percent

```
@Test
fun `check returns CRITICAL when used heap exceeds 90 percent of max`()
```

Arrange:
- `totalMemory=100, freeMemory=5, maxMemory=100`
- Used = 95, ratio = 0.95

Assert:
- `status == MemoryMonitor.Status.CRITICAL`

---

#### TC-10 — boundary at exactly 80 percent is WARNING not OK

```
@Test
fun `check returns WARNING at exactly 80 percent heap utilisation boundary`()
```

Arrange:
- `totalMemory=100, freeMemory=20, maxMemory=100`
- Used = 80, ratio = 0.80 (not strictly `> 0.8`)

Assert:
- `status == MemoryMonitor.Status.WARNING`

Note: production code uses `ratio > 0.8` so 0.80 exactly falls into OK. This test locks the boundary semantics. If the boundary should be inclusive (`>=`), this test will fail and drive a code change.

Expected input/output:
- Input ratio: 0.80 exactly
- Expected: `OK` (using strict `>` comparison)

---

#### TC-11 — boundary at exactly 90 percent is CRITICAL not WARNING

```
@Test
fun `check returns CRITICAL at exactly 90 percent heap utilisation boundary`()
```

Arrange:
- ratio = 0.90 exactly

Assert:
- `status == MemoryMonitor.Status.CRITICAL`

Same boundary-locking rationale as TC-10. Locks that `> 0.9` makes 0.90 exactly fall into WARNING; if the intent is `>= 0.9`, this drives a correction.

Expected: `WARNING` (with `>` semantics) — adjust assertion to match the chosen boundary semantic.

---

#### TC-12 — freeMemory == 0 does not crash (all memory allocated)

```
@Test
fun `check does not throw when freeMemory is zero`()
```

Arrange:
- `totalMemory=100, freeMemory=0, maxMemory=100`

Assert:
- `assertDoesNotThrow { MemoryMonitor.check(runtime) }`
- Returns `CRITICAL`

---

### AapCryptoMutexTest

These tests verify that `AapCrypto.encrypt()` and `AapCrypto.decrypt()` are wrapped in a `Mutex` so concurrent coroutine callers are serialised rather than racing on the non-thread-safe `SSLEngine`.

Because `SSLEngine` is a heavyweight object requiring a real TLS context, the production `AapCrypto` is refactored to accept an injectable `EncryptionEngine` interface for testing:

```kotlin
// Proposed abstraction
interface EncryptionEngine {
    fun encrypt(plaintext: ByteArray): ByteArray
    fun decrypt(ciphertext: ByteArray): ByteArray
}
```

The real `SSLEngine` wrapper implements this; a `FakeEncryptionEngine` is used in tests.

---

#### TC-13 — concurrent encrypt calls are serialised, not interleaved

```
@Test
fun `concurrent encrypt calls are serialised by the mutex`()
```

Verifies: two coroutines calling `encrypt()` concurrently produce outputs in the order they each acquired the lock; the `FakeEncryptionEngine` tracks entry/exit to detect overlap.

Arrange:
- `FakeEncryptionEngine` that:
  - Records a `start` and `end` event with coroutine identity
  - Uses `delay(50)` inside `encrypt()` to widen the race window
- `AapCrypto` injected with the fake engine
- `TestScope` with `UnconfinedTestDispatcher`

Act:
- Launch coroutine A: `crypto.encrypt(byteArrayOf(1))`
- Launch coroutine B: `crypto.encrypt(byteArrayOf(2))`
- Run to completion

Assert:
- Events list looks like `[startA, endA, startB, endB]` or `[startB, endB, startA, endA]`
- Never `[startA, startB, ...]` (concurrent overlap would mean `startA` and `startB` both appear before either `endA` or `endB`)

---

#### TC-14 — concurrent decrypt calls are serialised

```
@Test
fun `concurrent decrypt calls are serialised by the mutex`()
```

Same structure as TC-13 but exercises `decrypt()`. Confirms the single `Mutex` guards both operations.

---

#### TC-15 — encrypt and decrypt cannot run concurrently

```
@Test
fun `encrypt and decrypt cannot execute concurrently`()
```

Verifies: the mutex is shared between `encrypt` and `decrypt`, not per-operation.

Arrange:
- Coroutine A calls `encrypt()` (long-running fake)
- Coroutine B calls `decrypt()` simultaneously

Assert:
- No `[startA, startB]` overlap in the event log

---

#### TC-16 — encrypt returns the engine output unchanged

```
@Test
fun `encrypt returns the exact bytes produced by the underlying EncryptionEngine`()
```

Verifies: `AapCrypto` does not mutate the output of its engine.

Arrange:
- `FakeEncryptionEngine.encrypt` returns `byteArrayOf(0xDE.toByte(), 0xAD.toByte())`

Act:
- `val result = crypto.encrypt(byteArrayOf(0x01))`

Assert:
- `result contentEquals byteArrayOf(0xDE.toByte(), 0xAD.toByte())`

---

### OomRecoverySchedulerTest

#### Design contract for `OomRecoveryScheduler`

```kotlin
// Extracted from TransporterService for testability
class OomRecoveryScheduler(
    private val scope: CoroutineScope,
    private val restartDelayMs: Long = 3_000L,
    private val onStop: () -> Unit,
    private val onRestart: () -> Unit
)
// scheduleRestart() stops the service immediately and schedules onRestart() after restartDelayMs
```

---

#### TC-17 — onStop is called immediately when scheduleRestart is invoked

```
@Test
fun `scheduleRestart invokes onStop synchronously before the delay`()
```

Arrange:
- `TestScope`, `restartDelayMs = 3_000`
- `onStop` and `onRestart` record call order

Act:
- `scheduler.scheduleRestart()`
- Advance virtual time 0 ms

Assert:
- `onStop` called exactly once
- `onRestart` not yet called

---

#### TC-18 — onRestart is called after restartDelayMs

```
@Test
fun `scheduleRestart invokes onRestart after restartDelayMs`()
```

Arrange:
- `restartDelayMs = 3_000`

Act:
- `scheduler.scheduleRestart()`
- Advance 3_001 ms

Assert:
- `onRestart` called exactly once

---

#### TC-19 — onRestart is not called before the delay elapses

```
@Test
fun `scheduleRestart does not call onRestart before restartDelayMs have elapsed`()
```

Arrange:
- `restartDelayMs = 3_000`

Act:
- `scheduler.scheduleRestart()`
- Advance 2_999 ms

Assert:
- `onRestart` call count == 0
- `onStop` call count == 1

---

#### TC-20 — second scheduleRestart call does not double-restart

```
@Test
fun `calling scheduleRestart twice does not schedule two restart callbacks`()
```

Verifies: guard against a rapid sequence of OOM events causing multiple service starts.

Arrange:
- `restartDelayMs = 3_000`

Act:
- `scheduler.scheduleRestart()` at T=0
- `scheduler.scheduleRestart()` at T=500 (second OOM)
- Advance 5_000 ms

Assert:
- `onRestart` called exactly once (second call is a no-op because restart is already pending)

---

## Red Phase

What fails before any production code is written:

- `ByteArrayPoolTest` — `ByteArrayPool` does not exist; all 6 tests throw `ClassNotFoundException`.
- `MemoryMonitorTest` — `MemoryMonitor.check()` currently has no `RuntimeInfo` parameter; TC-07 through TC-12 fail because the real `Runtime` cannot be controlled in a unit test environment.
- `AapCryptoMutexTest` — `AapCrypto` has no `Mutex` and no injectable `EncryptionEngine`; TC-13 through TC-15 are flaky (may pass by timing accident). TC-16 requires the injectable facade that does not exist.
- `OomRecoverySchedulerTest` — `OomRecoveryScheduler` does not exist; all 4 tests throw `ClassNotFoundException`.

---

## Green Phase

Minimal changes per test class:

### 1. Create `ByteArrayPool`

```kotlin
// core/src/main/java/com/supertesla/aa/core/util/ByteArrayPool.kt
class ByteArrayPool(private val maxSize: Int, private val bufferSize: Int) {
    private val pool = ArrayDeque<ByteArray>(maxSize)

    fun acquire(): ByteArray = synchronized(pool) {
        pool.removeLastOrNull() ?: ByteArray(bufferSize)
    }

    fun release(buffer: ByteArray) = synchronized(pool) {
        if (pool.size < maxSize && buffer.size == bufferSize) {
            pool.addLast(buffer)
        }
    }
}
```

All 6 `ByteArrayPoolTest` cases go green.

### 2. Add `RuntimeInfo` interface and update `MemoryMonitor`

```kotlin
// core/src/main/java/com/supertesla/aa/core/util/MemoryMonitor.kt
interface RuntimeInfo {
    val totalMemory: Long
    val freeMemory: Long
    val maxMemory: Long
}

object SystemRuntimeInfo : RuntimeInfo {
    override val totalMemory get() = Runtime.getRuntime().totalMemory()
    override val freeMemory  get() = Runtime.getRuntime().freeMemory()
    override val maxMemory   get() = Runtime.getRuntime().maxMemory()
}

object MemoryMonitor {
    enum class Status { OK, WARNING, CRITICAL }

    fun check(runtime: RuntimeInfo = SystemRuntimeInfo): Status {
        val used  = runtime.totalMemory - runtime.freeMemory
        val ratio = used.toDouble() / runtime.maxMemory
        return when {
            ratio > 0.9 -> Status.CRITICAL
            ratio > 0.8 -> Status.WARNING
            else        -> Status.OK
        }
    }
}
```

TC-07 through TC-12 go green.

### 3. Add `Mutex` and injectable `EncryptionEngine` to `AapCrypto`

```kotlin
// Minimal addition to AapCrypto.kt:
private val sslMutex = Mutex()

suspend fun encrypt(plaintext: ByteArray): ByteArray = sslMutex.withLock {
    engine.encrypt(plaintext)
}

suspend fun decrypt(ciphertext: ByteArray): ByteArray = sslMutex.withLock {
    engine.decrypt(ciphertext)
}
```

`engine` is the `EncryptionEngine` interface; the existing `SSLEngine`-based logic is wrapped in a `SslEncryptionEngine` implementation. TC-13 through TC-16 go green.

### 4. Create `OomRecoveryScheduler`

```kotlin
// core/src/main/java/com/supertesla/aa/core/util/OomRecoveryScheduler.kt
class OomRecoveryScheduler(
    private val scope: CoroutineScope,
    private val restartDelayMs: Long = 3_000L,
    private val onStop: () -> Unit,
    private val onRestart: () -> Unit
) {
    private var pending: Job? = null

    fun scheduleRestart() {
        if (pending?.isActive == true) return
        onStop()
        pending = scope.launch {
            delay(restartDelayMs)
            onRestart()
        }
    }
}
```

TC-17 through TC-20 go green.

---

## Refactor Phase

After all tests are green:

1. **`ByteArrayPool` KDoc**: add `@param`, `@throws` (none — `release` is silent). Mark class as `@ThreadSafe`.

2. **`MemoryMonitor` boundary semantics**: after team agrees on inclusive vs. exclusive thresholds, update TC-10 and TC-11 assertions to match. The test documents the decision permanently.

3. **`AapCrypto` make `encrypt`/`decrypt` suspend-only**: the non-suspending versions called from `sendEncrypted` in `ChannelMux.kt` must also route through `runBlocking` or be called from a coroutine context. Update `ChannelMux.sendEncrypted` to be `suspend fun`. Adjust `ChannelMuxTest` (doc 11) accordingly.

4. **`OomRecoveryScheduler` `onStop` threading**: production usage calls `stopSelf()` which must happen on the main thread. Document this requirement in KDoc; the test uses `UnconfinedTestDispatcher` which sidesteps it. Add a `Dispatchers.Main` assertion comment so reviewers are aware.

5. **Pool pre-allocation**: once tests are stable, add an `init` block that pre-populates the pool with `minOf(preAllocCount, maxSize)` buffers. Add a TC-21 verifying that `acquire()` on a pre-allocated pool returns an existing buffer (identity check) without any `release()` call.
