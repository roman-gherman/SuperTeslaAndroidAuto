# 16 — SSL/TLS Hardening: Unit Test Plan

## Overview

Tests for `AapCrypto` targeting three orthogonal concerns:

1. **Mutex under concurrent access** — two coroutines calling `encrypt`
   simultaneously must not race on the shared `SSLEngine` state.
2. **TLSv1.3 protocol negotiation** — the engine must attempt TLSv1.3
   first and fall back to TLSv1.2 when unavailable.
3. **BUFFER_OVERFLOW handling in `encrypt` and `decrypt`** — the
   reallocate-and-retry loop must succeed rather than crashing or
   silently truncating data.

Because `SSLEngine` is a JDK class that requires a real `SSLContext` to
produce a functioning instance, most tests use a **real** `SSLEngine`
pair (client + server connected via piped streams) rather than mocks.
Concurrency tests use `kotlinx.coroutines.test` with a real
`Dispatchers.IO` thread pool to expose races.

---

## Test Classes

| Test Class | File Path | Class Under Test |
|---|---|---|
| `AapCryptoProtocolTest` | `androidauto/src/test/java/com/supertesla/aa/androidauto/protocol/AapCryptoProtocolTest.kt` | `AapCrypto.init` |
| `AapCryptoBufferOverflowTest` | `androidauto/src/test/java/com/supertesla/aa/androidauto/protocol/AapCryptoBufferOverflowTest.kt` | `AapCrypto.encrypt` / `AapCrypto.decrypt` |
| `AapCryptoConcurrencyTest` | `androidauto/src/test/java/com/supertesla/aa/androidauto/protocol/AapCryptoConcurrencyTest.kt` | `AapCrypto` mutex |
| `AapCryptoHandshakeTest` | `androidauto/src/test/java/com/supertesla/aa/androidauto/protocol/AapCryptoHandshakeTest.kt` | `AapCrypto.beginHandshake` / `processHandshakeData` |

---

## Test Cases

### `AapCryptoProtocolTest`

---

#### `@Test fun `init without context sets useClientMode=true``

- **Verifies**: The engine is always created in client mode (matching
  TaaDa behaviour).
- **Arrange / Act**:
  ```kotlin
  val crypto = AapCrypto()
  crypto.init(context = null)
  ```
- **Assert** (via reflection on `sslEngine` field, or via a
  `@VisibleForTesting` accessor):
  ```kotlin
  assertTrue(crypto.sslEngineClientMode)
  ```

---

#### `@Test fun `init enables TLSv1.3 when JVM supports it``

- **Verifies**: Enabled protocols contain `"TLSv1.3"` on a JVM that
  supports it (all modern JDKs do).
- **Arrange / Act**:
  ```kotlin
  val crypto = AapCrypto()
  crypto.init(context = null)
  ```
- **Assert**:
  ```kotlin
  val protocols = crypto.enabledProtocols   // @VisibleForTesting accessor
  assertTrue("TLSv1.3" in protocols)
  ```

---

#### `@Test fun `init includes TLSv1.2 as fallback alongside TLSv1.3``

- **Verifies**: Both protocols are enabled, not just the newest.
- **Assert**:
  ```kotlin
  assertTrue("TLSv1.2" in protocols)
  ```

---

#### `@Test fun `init does not throw when TLSv1.3 is unavailable (simulated)``

- **Verifies**: The `try/catch` in `init` swallows `IllegalArgumentException`
  from `enabledProtocols` and falls back gracefully.
- **Arrange**: Use a spy on `AapCrypto` that overrides the internal
  `setProtocols` helper to throw `IllegalArgumentException` on the first
  call.
  ```kotlin
  val crypto = spyk(AapCrypto())
  every { crypto.trySetProtocols(arrayOf("TLSv1.3", "TLSv1.2")) } throws
      IllegalArgumentException("TLSv1.3 not supported")
  ```
- **Act / Assert**:
  ```kotlin
  assertDoesNotThrow { crypto.init(context = null) }
  assertEquals(listOf("TLSv1.2"), crypto.enabledProtocols.toList())
  ```

---

### `AapCryptoBufferOverflowTest`

These tests use a loopback SSL pair:

```kotlin
// Helper — creates a TLS-handshaked client/server AapCrypto pair
fun makeHandshakedPair(): Pair<AapCrypto, AapCrypto> { ... }
```

The pair uses a self-signed in-memory cert generated via BouncyCastle or
the standard `KeyPairGenerator` + `KeyStore` approach (same pattern used
in TaaDa's test fixtures).

---

#### `@Test fun `encrypt does not crash on payload larger than initial packetBufferSize``

- **Verifies**: Payloads that exceed `sslEngine.session.packetBufferSize`
  trigger the BUFFER_OVERFLOW retry loop and still produce output bytes.
- **Arrange**:
  ```kotlin
  val (client, _) = makeHandshakedPair()
  val bigPayload  = ByteArray(65_536) { it.toByte() }  // 64 KB
  ```
- **Act**:
  ```kotlin
  val encrypted = client.encrypt(bigPayload)
  ```
- **Assert**:
  ```kotlin
  assertTrue(encrypted.isNotEmpty())
  ```

---

#### `@Test fun `encrypt-decrypt roundtrip produces identical plaintext``

- **Verifies**: Basic functional correctness — what goes in comes out.
- **Arrange**:
  ```kotlin
  val (client, server) = makeHandshakedPair()
  val plaintext = "Hello Android Auto".toByteArray()
  ```
- **Act**:
  ```kotlin
  val ciphertext = client.encrypt(plaintext)
  val recovered  = server.decrypt(ciphertext)
  ```
- **Assert**:
  ```kotlin
  assertArrayEquals(plaintext, recovered)
  ```

---

#### `@Test fun `encrypt-decrypt roundtrip preserves large binary payload``

- **Verifies**: A 128 KB binary payload survives the BUFFER_OVERFLOW
  retry path in both directions.
- **Arrange**:
  ```kotlin
  val payload = ByteArray(131_072) { (it % 256).toByte() }
  ```
- **Act / Assert**: same roundtrip pattern; `assertArrayEquals(payload, recovered)`

---

#### `@Test fun `decrypt handles BUFFER_OVERFLOW by reallocating and retrying``

- **Verifies**: The current `decrypt` implementation's `break` on
  BUFFER_OVERFLOW is replaced by a reallocation loop. This test uses a
  spy that makes the first `unwrap` call return BUFFER_OVERFLOW.
- **Arrange**:
  ```kotlin
  val crypto = spyk(AapCrypto())
  // After init, intercept the first unwrap call to simulate overflow
  val engine = mockk<SSLEngine>()
  val overflowResult = mockk<SSLEngineResult>()
  every { overflowResult.status } returns SSLEngineResult.Status.BUFFER_OVERFLOW
  // Second call returns OK
  val okResult = mockk<SSLEngineResult>()
  every { okResult.status } returns SSLEngineResult.Status.OK
  every { engine.unwrap(any(), any()) } returnsMany listOf(overflowResult, okResult)
  ```
- **Act / Assert**:
  ```kotlin
  // Must not return empty/truncated bytes
  val result = crypto.decrypt(someValidCiphertext)
  assertTrue(result.isNotEmpty())
  ```

---

#### `@Test fun `encrypt retries on BUFFER_OVERFLOW until output buffer is large enough``

- **Verifies**: The retry loop in `encrypt` doubles the buffer on each
  overflow; test uses a spy engine that returns BUFFER_OVERFLOW twice
  then OK.
- **Assert**: output is non-empty and has no truncation.

---

#### `@Test fun `decrypt with empty ciphertext returns empty ByteArray without throwing``

- **Arrange**:
  ```kotlin
  val (client, _) = makeHandshakedPair()
  ```
- **Act / Assert**:
  ```kotlin
  assertDoesNotThrow {
      val result = client.decrypt(ByteArray(0))
      assertEquals(0, result.size)
  }
  ```

---

### `AapCryptoConcurrencyTest`

> Concurrency tests require `@Timeout(5, unit = TimeUnit.SECONDS)` to
> prevent indefinite hangs on deadlock.

---

#### `@Test fun `concurrent encrypt calls do not produce interleaved results``

- **Verifies**: With the `Mutex`, two simultaneous `encrypt` calls each
  produce a complete, independently decodable TLS record — not a jumbled
  mix.
- **Arrange**:
  ```kotlin
  val (client, server) = makeHandshakedPair()
  val payloadA = ByteArray(1024) { 0xAA.toByte() }
  val payloadB = ByteArray(1024) { 0xBB.toByte() }
  ```
- **Act**:
  ```kotlin
  val results = runBlocking(Dispatchers.IO) {
      (1..50).map { i ->
          async {
              val payload = if (i % 2 == 0) payloadA else payloadB
              client.encrypt(payload)
          }
      }.awaitAll()
  }
  ```
- **Assert**:
  ```kotlin
  // Every ciphertext must decrypt successfully to either all-0xAA or all-0xBB
  results.forEach { cipher ->
      val plain = server.decrypt(cipher)
      assertTrue(plain.all { it == 0xAA.toByte() } || plain.all { it == 0xBB.toByte() })
  }
  ```

---

#### `@Test fun `concurrent encrypt and decrypt calls do not deadlock``

- **Verifies**: Mixed concurrent encrypt-from-client and decrypt-from-server
  operations complete within the timeout.
- **Arrange**:
  ```kotlin
  val (client, server) = makeHandshakedPair()
  val smallPayload = ByteArray(64) { it.toByte() }
  ```
- **Act**:
  ```kotlin
  runBlocking(Dispatchers.IO) {
      val encryptJobs = (1..20).map {
          launch { client.encrypt(smallPayload) }
      }
      val decryptJobs = (1..20).map {
          launch {
              val cipher = client.encrypt(smallPayload)
              server.decrypt(cipher)
          }
      }
      (encryptJobs + decryptJobs).joinAll()
  }
  ```
- **Assert**: Test completes within `@Timeout` — no `AssertionError` or
  `TimeoutException`.

---

#### `@Test fun `without mutex concurrent encrypt produces corrupt output (demonstrates the bug)`

- **Verifies**: This is a **regression** test that documents the
  pre-fix behaviour. It uses an `AapCryptoUnsynchronised` variant
  (subclass or wrapper that bypasses the mutex) and asserts that at
  least one result is either corrupt or an exception is thrown.
- **Note**: This test is `@Disabled` after the mutex is added — it
  is retained as documentation of the original defect and marked with a
  `@Tag("regression")` annotation.
- **Arrange / Act**: Same pattern as the concurrent encrypt test above,
  but using `AapCryptoUnsynchronised`.
- **Assert**:
  ```kotlin
  // Expect at least one failure or mismatched plaintext
  val failures = results.count { cipher ->
      runCatching { server.decrypt(cipher) }.isFailure
  }
  assertTrue(failures > 0, "Expected interleaving to cause failures without mutex")
  ```

---

### `AapCryptoHandshakeTest`

---

#### `@Test fun `beginHandshake returns non-empty ClientHello bytes``

- **Verifies**: The first handshake message (ClientHello TLS record) is
  produced by `beginHandshake`.
- **Arrange**:
  ```kotlin
  val crypto = AapCrypto()
  crypto.init(context = null)
  ```
- **Act**:
  ```kotlin
  val hello = crypto.beginHandshake()
  ```
- **Assert**:
  ```kotlin
  assertTrue(hello.isNotEmpty())
  // TLS record type 0x16 = Handshake
  assertEquals(0x16, hello[0].toInt() and 0xFF)
  ```

---

#### `@Test fun `isHandshakeComplete is false before handshake begins``

- **Arrange / Act**:
  ```kotlin
  val crypto = AapCrypto()
  crypto.init(context = null)
  ```
- **Assert**:
  ```kotlin
  assertFalse(crypto.isHandshakeComplete)
  ```

---

#### `@Test fun `full loopback handshake completes and isHandshakeComplete becomes true``

- **Verifies**: A client-server pair can complete the TLS handshake using
  only `beginHandshake` / `processHandshakeData` without a real network
  socket.
- **Arrange**:
  ```kotlin
  val (client, server) = makeHandshakedPair()
  ```
- **Assert**:
  ```kotlin
  assertTrue(client.isHandshakeComplete)
  assertTrue(server.isHandshakeComplete)
  ```

---

#### `@Test fun `processHandshakeData with empty input does not throw``

- **Arrange**:
  ```kotlin
  val crypto = AapCrypto()
  crypto.init(context = null)
  crypto.beginHandshake()
  ```
- **Act / Assert**:
  ```kotlin
  assertDoesNotThrow { crypto.processHandshakeData(ByteArray(0)) }
  ```

---

#### `@Test fun `close does not throw when called before init``

- **Verifies**: Guard on `::sslEngine.isInitialized` prevents NPE.
- **Arrange**: `val crypto = AapCrypto()` (no `init`)
- **Act / Assert**: `assertDoesNotThrow { crypto.close() }`

---

## Red Phase

Before implementation:

- `AapCrypto` has no `Mutex` — the concurrent test will intermittently
  pass or expose data corruption (non-deterministic; CI will eventually
  catch it with enough runs).
- `decrypt` has a `break` on BUFFER_OVERFLOW instead of a reallocation
  loop — `AapCryptoBufferOverflowTest` asserting non-empty output after
  overflow will fail when the spy triggers the overflow path.
- `AapCrypto` has no `@VisibleForTesting` accessor for `enabledProtocols`
  or `sslEngineClientMode` → `AapCryptoProtocolTest` uses reflection or
  fails to compile.
- `AapCryptoUnsynchronised` test subclass does not exist → regression
  test fails to compile.

---

## Green Phase

Minimal changes:

```kotlin
// AapCrypto.kt — add mutex

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class AapCrypto {

    private lateinit var sslEngine: SSLEngine
    private val sslMutex = Mutex()

    // @VisibleForTesting
    val enabledProtocols: Array<String>
        get() = sslEngine.enabledProtocols

    // @VisibleForTesting
    val sslEngineClientMode: Boolean
        get() = sslEngine.useClientMode

    // encrypt — add mutex + BUFFER_OVERFLOW retry
    suspend fun encrypt(plaintext: ByteArray): ByteArray = sslMutex.withLock {
        val inBuf = ByteBuffer.wrap(plaintext)
        var outBuf = ByteBuffer.allocate(sslEngine.session.packetBufferSize + plaintext.size)
        var result = sslEngine.wrap(inBuf, outBuf)
        while (result.status == SSLEngineResult.Status.BUFFER_OVERFLOW) {
            outBuf = ByteBuffer.allocate(outBuf.capacity() * 2)
            inBuf.rewind()
            result = sslEngine.wrap(inBuf, outBuf)
        }
        outBuf.flip()
        val encrypted = ByteArray(outBuf.remaining())
        outBuf.get(encrypted)
        encrypted
    }

    // decrypt — add mutex + BUFFER_OVERFLOW retry (replace break with realloc)
    suspend fun decrypt(ciphertext: ByteArray): ByteArray = sslMutex.withLock {
        val inBuf = ByteBuffer.wrap(ciphertext)
        var outBuf = ByteBuffer.allocate(sslEngine.session.applicationBufferSize + ciphertext.size)
        while (inBuf.hasRemaining()) {
            var result = sslEngine.unwrap(inBuf, outBuf)
            when (result.status) {
                SSLEngineResult.Status.OK             -> {}
                SSLEngineResult.Status.BUFFER_UNDERFLOW -> break
                SSLEngineResult.Status.BUFFER_OVERFLOW  -> {
                    outBuf = ByteBuffer.allocate(outBuf.capacity() * 2)
                    // retry — do not advance inBuf
                }
                SSLEngineResult.Status.CLOSED -> break
                else -> {}
            }
        }
        outBuf.flip()
        val decrypted = ByteArray(outBuf.remaining())
        outBuf.get(decrypted)
        decrypted
    }
}
```

Since `encrypt` and `decrypt` become `suspend` functions, all callers
(`ChannelMux`, `AapProtocolHandler`) must also become coroutine-aware —
the minimal change is to add `runBlocking { }` wrappers in the immediate
callers and update them to `suspend` in the refactor phase.

---

## Refactor Phase

After green:

1. Propagate `suspend` through `ChannelMux.sendEncrypted` and
   `ChannelMux.sendEncryptedControl` so no `runBlocking` bridges remain.
2. Add a `@VisibleForTesting internal` constructor that accepts a
   pre-built `SSLEngine` — eliminates reflection in tests and makes the
   loopback pair helper clean.
3. Extract the BUFFER_OVERFLOW retry into a private `wrapWithRetry` and
   `unwrapWithRetry` pair to remove code duplication between `encrypt`
   and `decrypt`.
4. Replace `AapCryptoUnsynchronised` test subclass with a MockK spy and
   a `@Tag("mutation")` annotation; run it only in the mutation-testing
   CI job.
5. Add a `Flow<String>`-based `negotiatedProtocol` property (populated
   after handshake completes) so higher-level code can log/metric the
   actual negotiated TLS version without parsing log strings.
6. Ensure Detekt `ForbiddenApi` rule flags any future calls to the
   non-suspend `encrypt`/`decrypt` overloads if they are left as
   compatibility shims.
