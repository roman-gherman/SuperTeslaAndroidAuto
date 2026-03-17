# 15 — Settings & Configuration: Unit Test Plan

## Overview

Tests for `HeadUnitConfig` data-class construction from persisted
settings and for `ServiceDiscovery.buildResponse` varying its output
based on config fields. Two dimensions are covered:

1. `HeadUnitConfig` reads the correct SharedPreferences keys and applies
   the correct defaults.
2. `ServiceDiscovery.buildResponse` reflects config values (resolution
   index, DPI, driver position) in the serialised protobuf output.

No Android instrumentation is needed — `HeadUnitConfig` is a plain
Kotlin `data class` and `ServiceDiscovery` is a pure `object` with no
Android dependencies.

---

## Test Classes

| Test Class | File Path | Class Under Test |
|---|---|---|
| `HeadUnitConfigTest` | `androidauto/src/test/java/com/supertesla/aa/androidauto/headunit/HeadUnitConfigTest.kt` | `HeadUnitConfig` |
| `HeadUnitConfigFromPrefsTest` | `androidauto/src/test/java/com/supertesla/aa/androidauto/headunit/HeadUnitConfigFromPrefsTest.kt` | `HeadUnitConfig.fromPrefs` (factory to be added) |
| `ServiceDiscoveryConfigTest` | `androidauto/src/test/java/com/supertesla/aa/androidauto/proto/ServiceDiscoveryConfigTest.kt` | `ServiceDiscovery.buildResponse` |

---

## Test Cases

### `HeadUnitConfigTest`

#### `@Test fun `default HeadUnitConfig has width=1280 height=720 density=120``

- **Verifies**: Factory defaults match the TaaDa 720p preset.
- **Arrange / Act**:
  ```kotlin
  val config = HeadUnitConfig()
  ```
- **Assert**:
  ```kotlin
  assertEquals(1280, config.videoWidth)
  assertEquals(720,  config.videoHeight)
  assertEquals(120,  config.videoDensity)
  ```

---

#### `@Test fun `default HeadUnitConfig has rightHandDrive=false``

- **Verifies**: Left-hand drive is the default steering position.
- **Assert**:
  ```kotlin
  assertFalse(config.rightHandDrive)
  ```

---

#### `@Test fun `HeadUnitConfig copy with RHD flag preserves other fields``

- **Verifies**: Kotlin `copy` leaves unrelated fields unchanged.
- **Arrange**:
  ```kotlin
  val base = HeadUnitConfig()
  val rhd  = base.copy(rightHandDrive = true)
  ```
- **Assert**:
  ```kotlin
  assertTrue(rhd.rightHandDrive)
  assertEquals(base.videoWidth,   rhd.videoWidth)
  assertEquals(base.videoDensity, rhd.videoDensity)
  ```

---

#### `@Test fun `resolution preset 0 maps to 800x480``

- **Verifies**: The `resolutionPresets` companion list maps index 0 to
  800×480.
- **Arrange**:
  ```kotlin
  val preset = HeadUnitConfig.RESOLUTION_PRESETS[0]
  ```
- **Assert**:
  ```kotlin
  assertEquals(800,  preset.width)
  assertEquals(480,  preset.height)
  assertEquals(0,    preset.index)
  ```

---

#### `@Test fun `resolution preset 1 maps to 1280x720``

- **Verifies**: Index 1 (TaaDa default) is 1280×720.
- **Assert**:
  ```kotlin
  val preset = HeadUnitConfig.RESOLUTION_PRESETS[1]
  assertEquals(1280, preset.width)
  assertEquals(720,  preset.height)
  ```

---

#### `@Test fun `resolution preset 2 maps to 1920x1080``

- Verifies index 2 → 1920×1080.

---

#### `@Test fun `DPI value below 100 is clamped to 100``

- **Verifies**: `HeadUnitConfig.withDpi` rejects sub-minimum values.
- **Arrange**:
  ```kotlin
  val config = HeadUnitConfig().withDpi(50)
  ```
- **Assert**:
  ```kotlin
  assertEquals(100, config.videoDensity)
  ```

---

#### `@Test fun `DPI value above 300 is clamped to 300``

- **Verifies**: `withDpi` rejects supra-maximum values.
- **Arrange**: `HeadUnitConfig().withDpi(500)`
- **Assert**: `assertEquals(300, config.videoDensity)`

---

#### `@Test fun `DPI value 210 is accepted without clamping``

- **Assert**: `assertEquals(210, HeadUnitConfig().withDpi(210).videoDensity)`

---

### `HeadUnitConfigFromPrefsTest`

Uses `mockk<SharedPreferences>` to simulate persisted settings.

---

#### `@Test fun `fromPrefs reads stored_width and stored_height``

- **Verifies**: Factory reads `stored_width` / `stored_height` from prefs.
- **Arrange**:
  ```kotlin
  val prefs = mockk<SharedPreferences>()
  every { prefs.getInt("stored_width",  1280) } returns 1920
  every { prefs.getInt("stored_height", 720)  } returns 1080
  every { prefs.getInt("dpi", 120) } returns 120
  every { prefs.getBoolean("rhd", false) } returns false
  every { prefs.getString("resolution", "1") } returns "1"
  ```
- **Act**:
  ```kotlin
  val config = HeadUnitConfig.fromPrefs(prefs)
  ```
- **Assert**:
  ```kotlin
  assertEquals(1920, config.videoWidth)
  assertEquals(1080, config.videoHeight)
  ```

---

#### `@Test fun `fromPrefs uses default width 1280 when key absent``

- **Verifies**: SharedPreferences default for `stored_width` is 1280.
- **Arrange**:
  ```kotlin
  every { prefs.getInt("stored_width", 1280) } returns 1280  // default returned
  ```
- **Assert**: `assertEquals(1280, config.videoWidth)`

---

#### `@Test fun `fromPrefs reads dpi key``

- **Arrange**:
  ```kotlin
  every { prefs.getInt("dpi", 120) } returns 200
  ```
- **Assert**: `assertEquals(200, config.videoDensity)`

---

#### `@Test fun `fromPrefs reads rhd toggle``

- **Arrange**:
  ```kotlin
  every { prefs.getBoolean("rhd", false) } returns true
  ```
- **Assert**: `assertTrue(config.rightHandDrive)`

---

#### `@Test fun `fromPrefs resolution=2 produces 1920x1080 dimensions``

- **Verifies**: The resolution string key "2" is resolved to the correct
  preset dimensions.
- **Arrange**:
  ```kotlin
  every { prefs.getString("resolution", "1") } returns "2"
  every { prefs.getInt("stored_width",  1280) } returns 1280  // ignored when preset wins
  every { prefs.getInt("stored_height", 720)  } returns 720
  ```
- **Assert**:
  ```kotlin
  assertEquals(1920, config.videoWidth)
  assertEquals(1080, config.videoHeight)
  ```

---

#### `@Test fun `fromPrefs falls back to custom dimensions when resolution key is invalid``

- **Verifies**: An unrecognised resolution string falls back to
  `stored_width` / `stored_height`.
- **Arrange**:
  ```kotlin
  every { prefs.getString("resolution", "1") } returns "99"
  every { prefs.getInt("stored_width",  1280) } returns 1440
  every { prefs.getInt("stored_height", 720)  } returns 900
  ```
- **Assert**:
  ```kotlin
  assertEquals(1440, config.videoWidth)
  assertEquals(900,  config.videoHeight)
  ```

---

### `ServiceDiscoveryConfigTest`

These tests decode the serialised `buildResponse` output and verify that
specific protobuf fields reflect the config values passed in.

---

#### `@Test fun `buildResponse with default config encodes video density=120``

- **Verifies**: Default `VideoConfig` density 120 appears in the
  `VideoConfiguration.density` field (field 5) in service 3.
- **Arrange**:
  ```kotlin
  val bytes = ServiceDiscovery.buildResponse()
  ```
- **Act**: Walk the proto to service 3, MediaSinkService, VideoConfiguration.
  ```kotlin
  val videoConfig = extractVideoConfiguration(bytes)
  ```
  where `extractVideoConfiguration` is a test-local helper using
  `ProtoEncoder.readFields`.
- **Assert**:
  ```kotlin
  assertEquals(120L, videoConfig.first { it.fieldNumber == 5 }.varintValue)
  ```

---

#### `@Test fun `buildResponse with density=200 encodes density=200 in VideoConfiguration``

- **Verifies**: The DPI setting flows through to the wire format.
- **Arrange**:
  ```kotlin
  val bytes = ServiceDiscovery.buildResponse(
      videoConfig = ServiceDiscovery.VideoConfig(density = 200)
  )
  val videoConfig = extractVideoConfiguration(bytes)
  ```
- **Assert**: `assertEquals(200L, videoConfig.first { it.fieldNumber == 5 }.varintValue)`

---

#### `@Test fun `buildResponse default config omits driver position field (LHD=proto3 default)``

- **Verifies**: Left-hand drive (value 0) is omitted from the serialised
  proto because proto3 drops default values. Field 6 must be absent.
- **Arrange**:
  ```kotlin
  val fields = ProtoEncoder.readFields(ServiceDiscovery.buildResponse())
  ```
- **Assert**:
  ```kotlin
  val driverPosField = fields.firstOrNull { it.fieldNumber == 6 }
  assertNull(driverPosField)
  ```

---

#### `@Test fun `buildResponse with rightHandDrive=true encodes driverPosition=1 in field 6``

- **Verifies**: RHD (value 1) is explicitly written to field 6.
- **Arrange**:
  ```kotlin
  // buildResponse must accept a driverPosition parameter
  val bytes  = ServiceDiscovery.buildResponse(driverPosition = 1)
  val fields = ProtoEncoder.readFields(bytes)
  ```
- **Assert**:
  ```kotlin
  val driverPos = fields.firstOrNull { it.fieldNumber == 6 }
  assertNotNull(driverPos)
  assertEquals(1L, driverPos!!.varintValue)
  ```

---

#### `@Test fun `buildResponse encodes touchscreen width and height from VideoConfig``

- **Verifies**: `InputSourceService.touchscreen` (service 1, field 4,
  sub-field 2, sub-sub-fields 1 and 2) uses the `videoConfig` dimensions.
- **Arrange**:
  ```kotlin
  val bytes = ServiceDiscovery.buildResponse(
      videoConfig = ServiceDiscovery.VideoConfig(width = 1920, height = 1080)
  )
  val touchscreen = extractTouchscreen(bytes)
  ```
- **Assert**:
  ```kotlin
  assertEquals(1920L, touchscreen.first { it.fieldNumber == 1 }.varintValue)
  assertEquals(1080L, touchscreen.first { it.fieldNumber == 2 }.varintValue)
  ```

---

#### `@Test fun `buildResponse with includeAudioSinks=false omits service 7 and 5``

- **Verifies**: When BT audio bypass is on, guidance (7) and media (5)
  audio sink services are absent.
- **Arrange**:
  ```kotlin
  val bytes  = ServiceDiscovery.buildResponse(includeAudioSinks = false)
  val services = extractServiceIds(bytes)
  ```
- **Assert**:
  ```kotlin
  assertFalse(7 in services)
  assertFalse(5 in services)
  ```

---

#### `@Test fun `buildResponse with includeAudioSinks=true includes service ids 5 and 7``

- **Assert**:
  ```kotlin
  assertTrue(7 in services)
  assertTrue(5 in services)
  ```

---

#### `@Test fun `buildResponse always includes service ids 1 2 3 4 6 9``

- **Verifies**: Core services are present regardless of config.
- **Assert**:
  ```kotlin
  for (id in listOf(1, 2, 3, 4, 6, 9)) {
      assertTrue(id in services, "Service $id missing")
  }
  ```

---

#### `@Test fun `HeadUnitConfig converts to ServiceDiscovery VideoConfig correctly``

- **Verifies**: A `HeadUnitConfig.toVideoConfig()` extension produces a
  `ServiceDiscovery.VideoConfig` with matching width, height, density.
- **Arrange**:
  ```kotlin
  val huConfig    = HeadUnitConfig(videoWidth = 1920, videoHeight = 1080, videoDensity = 160)
  val videoConfig = huConfig.toVideoConfig()
  ```
- **Assert**:
  ```kotlin
  assertEquals(1920, videoConfig.width)
  assertEquals(1080, videoConfig.height)
  assertEquals(160,  videoConfig.density)
  ```

---

## Red Phase

Before implementation:

- `HeadUnitConfig` has no `rightHandDrive` field → compilation failure
  in `HeadUnitConfigTest`.
- `HeadUnitConfig.RESOLUTION_PRESETS` companion list does not exist.
- `HeadUnitConfig.fromPrefs` factory method does not exist →
  `HeadUnitConfigFromPrefsTest` fails to compile.
- `HeadUnitConfig.withDpi` function does not exist.
- `ServiceDiscovery.buildResponse` has no `driverPosition` parameter →
  RHD tests fail.
- `HeadUnitConfig.toVideoConfig()` extension does not exist.

---

## Green Phase

Minimal additions:

```kotlin
// HeadUnitConfig.kt additions:
data class HeadUnitConfig(
    val videoWidth:     Int     = 1280,
    val videoHeight:    Int     = 720,
    val videoDensity:   Int     = 120,
    val videoFps:       Int     = 30,
    val rightHandDrive: Boolean = false,
    // ... existing fields unchanged
) {
    fun withDpi(dpi: Int): HeadUnitConfig = copy(videoDensity = dpi.coerceIn(100, 300))

    fun toVideoConfig(): ServiceDiscovery.VideoConfig = ServiceDiscovery.VideoConfig(
        width   = videoWidth,
        height  = videoHeight,
        density = videoDensity,
        fps     = videoFps
    )

    companion object {
        data class ResolutionPreset(val index: Int, val width: Int, val height: Int)

        val RESOLUTION_PRESETS = listOf(
            ResolutionPreset(0, 800,  480),
            ResolutionPreset(1, 1280, 720),
            ResolutionPreset(2, 1920, 1080),
            ResolutionPreset(3, 2560, 1440),
            ResolutionPreset(5, 720,  1280),
            ResolutionPreset(6, 1080, 1920)
        )

        fun fromPrefs(prefs: SharedPreferences): HeadUnitConfig {
            val resolutionKey = prefs.getString("resolution", "1") ?: "1"
            val preset = RESOLUTION_PRESETS.firstOrNull { it.index == resolutionKey.toIntOrNull() }
            val width  = preset?.width  ?: prefs.getInt("stored_width",  1280)
            val height = preset?.height ?: prefs.getInt("stored_height", 720)
            return HeadUnitConfig(
                videoWidth     = width,
                videoHeight    = height,
                videoDensity   = prefs.getInt("dpi", 120).coerceIn(100, 300),
                rightHandDrive = prefs.getBoolean("rhd", false)
            )
        }
    }
}
```

```kotlin
// ServiceDiscovery.buildResponse signature change:
fun buildResponse(
    huInfo:           HeadUnitInfo  = HeadUnitInfo(),
    videoConfig:      VideoConfig   = VideoConfig(),
    mediaAudio:       AudioConfig   = AudioConfig(sampleRate = 48000, channelCount = 2),
    speechAudio:      AudioConfig   = AudioConfig(sampleRate = 16000, bitDepth = 16, channelCount = 1),
    systemAudio:      AudioConfig   = AudioConfig(sampleRate = 16000, bitDepth = 16, channelCount = 1),
    includeAudioSinks: Boolean      = false,
    driverPosition:   Int           = 0   // 0=LHD (default/omitted), 1=RHD
): ByteArray {
    // ... existing build logic
    // After HeadUnitInfo block, add:
    if (driverPosition != 0) {
        ProtoEncoder.writeVarintField(out, 6, driverPosition.toLong())
    }
    // rest unchanged
}
```

---

## Refactor Phase

After green:

1. Move `RESOLUTION_PRESETS` to a dedicated `ResolutionPreset.kt` value
   class in a `settings` package so both `HeadUnitConfig` and
   `SettingsScreen` share the same canonical list.
2. Replace raw `SharedPreferences` in `fromPrefs` with a `SettingsRepository`
   interface backed by `DataStore<Preferences>` to enable reactive updates
   (Flow-based) and easier testing.
3. Add a `HeadUnitConfigRepositoryTest` using Turbine to verify that
   changing a preference emits an updated `HeadUnitConfig` through the
   exposed `Flow`.
4. Introduce `@IntRange(from = 100, to = 300)` annotation on
   `videoDensity` and enforce it via a `require` guard in `init {}` to
   catch misconfiguration at construction time.
5. Add `ServiceDiscoverySnapshotTest` that serialises a known config to
   bytes and asserts a stable hex snapshot, catching unintended encoding
   regressions.
