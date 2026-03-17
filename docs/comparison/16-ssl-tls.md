# 16 — SSL/TLS Hardening

## Problem

Our TLS implementation has thread-safety issues and lacks dynamic certificate support. TaaDa has dynamic cert updates from a remote server.

## TaaDa's SSL Architecture

| Aspect | TaaDa |
|--------|-------|
| AA protocol TLS | PKCS12 keystore, password "aa", clientMode=true |
| WebSocket TLS | Separate PKCS12 cert (`server_pbe`), WSS |
| Trust manager | Accepts ALL certs (NaiveTrustManager) |
| Dynamic certs | Downloads from `https://cert.taada.top`, SHA-256 fingerprint check |
| Cert update | Daily via SslUpdateWorker (WorkManager) |
| SSL client mode | True (TaaDa acts as SSL client despite being HU) |
| Protocols | TLSv1.3 preferred, TLSv1.2 fallback |

## Our Current State

| Aspect | Ours |
|--------|------|
| AA protocol TLS | PKCS12 keystore, password "aa", clientMode=true |
| WebSocket TLS | **None** (plain WS, not WSS) |
| Trust manager | Accepts ALL certs (TrustAllManager) |
| Dynamic certs | None |
| SSL client mode | True (same as TaaDa) |
| Protocols | TLSv1.2 only (no TLSv1.3 attempt) |
| Thread safety | **SSLEngine not synchronized** |

## Changes Required

### Step 1: Add mutex to AapCrypto
```kotlin
private val sslMutex = Mutex()

suspend fun encrypt(plaintext: ByteArray): ByteArray = sslMutex.withLock {
    // ... existing logic
}

suspend fun decrypt(ciphertext: ByteArray): ByteArray = sslMutex.withLock {
    // ... existing logic
}
```

### Step 2: Try TLSv1.3 first
```kotlin
// In AapCrypto.init():
try {
    sslEngine.enabledProtocols = arrayOf("TLSv1.3", "TLSv1.2")
} catch (e: IllegalArgumentException) {
    sslEngine.enabledProtocols = arrayOf("TLSv1.2")
}
```

### Step 3: Handle BUFFER_OVERFLOW in encrypt
```kotlin
fun encrypt(plaintext: ByteArray): ByteArray {
    var outBuf = ByteBuffer.allocate(sslEngine.session.packetBufferSize + plaintext.size)
    val inBuf = ByteBuffer.wrap(plaintext)
    var result = sslEngine.wrap(inBuf, outBuf)
    while (result.status == SSLEngineResult.Status.BUFFER_OVERFLOW) {
        outBuf = ByteBuffer.allocate(outBuf.capacity() * 2)
        inBuf.rewind()
        result = sslEngine.wrap(inBuf, outBuf)
    }
    // ...
}
```

### Step 4: Add WSS to WebSocket servers (future)
For Tesla browser communication, consider adding TLS to the java-websocket servers using `DefaultSSLWebSocketServerFactory` like TaaDa does. This requires a server certificate.

### Step 5: Add decrypt BUFFER_OVERFLOW handling
Currently breaks on BUFFER_OVERFLOW — should reallocate and retry:
```kotlin
while (result.status == SSLEngineResult.Status.BUFFER_OVERFLOW) {
    appBuf = ByteBuffer.allocate(appBuf.capacity() * 2)
    result = sslEngine.unwrap(netBuf, appBuf)
}
```

## Files to Modify
- `androidauto/src/main/java/.../protocol/AapCrypto.kt`

## Test Plan
- [ ] TLS handshake completes without errors
- [ ] Video streams smoothly under concurrent encrypt/decrypt
- [ ] Large payloads don't cause BUFFER_OVERFLOW crashes
- [ ] `adb logcat | grep SSL` shows TLSv1.3 or TLSv1.2 negotiated
