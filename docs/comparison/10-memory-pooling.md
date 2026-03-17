# 10 — Memory Management & Buffer Pooling

## Problem

Under sustained video/audio streaming, frequent object allocation causes GC pressure. TaaDa uses aggressive object pooling and tiered buffer management.

## TaaDa's Memory Architecture

### Object Pools
| Pool | Max Size | Pre-alloc | Purpose |
|------|----------|-----------|---------|
| ProtocolMessagePool | 16 | 3 | Reuse message objects |
| BufferPool (read) | 8 each | 2 each | 64B, 1KB, 64KB, 512KB tiers |
| ProtocolBufferPool | 10/20 | Lazy | 8KB (msg) / 16KB (SSL) |
| SSLBufferPool | 6 each | Lazy | 512B, 2KB, 8KB, 16KB |

### Memory Monitoring
- Warning: 80% heap utilization
- Critical: 90% heap or system `isLowMemory`
- OOM handler: stop service, restart in 3 seconds
- `android:largeHeap="true"` in manifest

### Direct Buffers
- NAL reassembly: 8MB `ByteBuffer.allocateDirect`
- Audio buffering: 512KB `ByteBuffer.allocateDirect`
- Metadata: 1MB `ByteBuffer.allocateDirect`

## Our Current State

- NAL buffer: 8MB `ByteBuffer.allocateDirect` (matches TaaDa)
- No object pooling for messages or buffers
- No memory monitoring
- No OOM recovery
- No `android:largeHeap="true"` in manifest
- SharedFlow buffers: `extraBufferCapacity=30` for video, `64` for audio

## Changes Required

### Step 1: Add `largeHeap` to manifest
```xml
<application android:largeHeap="true" ...>
```

### Step 2: Create a simple ByteArray pool
```kotlin
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

### Step 3: Add memory monitoring utility
```kotlin
object MemoryMonitor {
    enum class Status { OK, WARNING, CRITICAL }

    fun check(): Status {
        val runtime = Runtime.getRuntime()
        val used = runtime.totalMemory() - runtime.freeMemory()
        val max = runtime.maxMemory()
        val ratio = used.toDouble() / max
        return when {
            ratio > 0.9 -> Status.CRITICAL
            ratio > 0.8 -> Status.WARNING
            else -> Status.OK
        }
    }
}
```

### Step 4: Add OOM recovery in TransporterService
```kotlin
// In the main pipeline coroutine:
try {
    // ... pipeline logic
} catch (e: OutOfMemoryError) {
    Timber.e("OOM! Stopping service and scheduling restart")
    isActive = false
    isConnected = false
    isVideoActive = false
    stopSelf()
    // Schedule restart after 3 seconds
    Handler(Looper.getMainLooper()).postDelayed({
        start(applicationContext)
    }, 3000)
}
```

### Step 5: Add SSLEngine thread safety
TaaDa's SSLEngine has synchronized access. Our `AapCrypto` encrypt/decrypt can be called from different coroutines:
```kotlin
// Add mutex to AapCrypto:
private val sslMutex = Mutex()

suspend fun encrypt(plaintext: ByteArray): ByteArray = sslMutex.withLock {
    // existing encrypt logic
}

suspend fun decrypt(ciphertext: ByteArray): ByteArray = sslMutex.withLock {
    // existing decrypt logic
}
```

## Files to Modify
- `app/src/main/AndroidManifest.xml` (largeHeap)
- Create `core/src/main/java/.../util/MemoryMonitor.kt`
- Create `core/src/main/java/.../util/ByteArrayPool.kt`
- `androidauto/src/main/java/.../protocol/AapCrypto.kt` (thread safety)
- `app/src/main/java/com/supertesla/aa/service/TransporterService.kt` (OOM recovery)

## Test Plan
- [ ] App survives 30+ minutes of continuous streaming without OOM
- [ ] Memory usage stays stable (not continuously growing)
- [ ] After forced OOM (dev tools), service restarts within 3 seconds
- [ ] SSLEngine never produces corrupted data under concurrent access
- [ ] `adb shell dumpsys meminfo <pid>` shows largeHeap enabled
