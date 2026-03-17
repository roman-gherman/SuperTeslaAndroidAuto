# Unit Test Plan: 12 — HTTPS Config Endpoint

## Overview

Tests cover three concerns introduced by doc 12:

1. Margin calculation math — `calculateWidthMargin` and `calculateHeightMargin` — pure arithmetic functions that must handle portrait, landscape, and square screen geometries relative to the configured video resolution.
2. `/config` endpoint JSON response — field presence, types, and values derived from `AppConfig` and the margin calculations.
3. Query-parameter parsing — `w`, `h`, and `webcodec` are optional integers/booleans with defined defaults.

No Ktor test client is required for the margin and parameter-parsing tests because the logic is extracted into pure functions. The endpoint integration test uses `ktor-server-test-host` to keep it framework-level without a real socket.

---

## Test Classes

### 1. `MarginCalculatorTest`

**File:** `network/src/test/java/com/supertesla/aa/network/webserver/MarginCalculatorTest.kt`
**Class under test:** `com.supertesla.aa.network.webserver.MarginCalculator`

Depends on: JUnit 5 only (pure math)

---

### 2. `ConfigResponseBuilderTest`

**File:** `network/src/test/java/com/supertesla/aa/network/webserver/ConfigResponseBuilderTest.kt`
**Class under test:** `com.supertesla.aa.network.webserver.ConfigResponseBuilder`

Depends on: JUnit 5, `kotlinx-serialization-json`

---

### 3. `ConfigEndpointIntegrationTest`

**File:** `network/src/test/java/com/supertesla/aa/network/webserver/ConfigEndpointIntegrationTest.kt`
**Class under test:** `com.supertesla.aa.network.webserver.WebServer` (the `/config` route)

Depends on: JUnit 5, `ktor-server-test-host`, `kotlinx-serialization-json`

---

## Gradle Dependency Additions

Add to `network/build.gradle.kts`:

```kotlin
testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
testImplementation("io.ktor:ktor-server-test-host:2.3.7")
testImplementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")
testImplementation("io.mockk:mockk:1.13.10")
```

---

## Design Contracts

### `MarginCalculator`

```kotlin
// network/src/main/java/com/supertesla/aa/network/webserver/MarginCalculator.kt
object MarginCalculator {
    /**
     * Horizontal pixels to crop from the left/right of the video when the screen is
     * taller (narrower) relative to the video aspect ratio.
     *
     * videoWidth * (1 - screenRatio / videoRatio) when screenRatio < videoRatio,
     * else 0.
     */
    fun widthMargin(
        screenWidth: Int,
        screenHeight: Int,
        videoWidth: Int,
        videoHeight: Int
    ): Int

    /**
     * Vertical pixels to crop from the top/bottom of the video when the screen is
     * wider relative to the video aspect ratio.
     *
     * videoHeight * (1 - videoRatio / screenRatio) when screenRatio > videoRatio,
     * else 0.
     */
    fun heightMargin(
        screenWidth: Int,
        screenHeight: Int,
        videoWidth: Int,
        videoHeight: Int
    ): Int
}
```

The math from doc 12 Step 3:

```
screenRatio = screenWidth / screenHeight
videoRatio  = videoWidth / videoHeight

widthMargin  = if (screenRatio <= videoRatio) (videoWidth - videoHeight * screenRatio).toInt() else 0
heightMargin = if (screenRatio > videoRatio)  (videoHeight - videoWidth / screenRatio).toInt() else 0
```

### `ConfigResponseBuilder`

```kotlin
// network/src/main/java/com/supertesla/aa/network/webserver/ConfigResponseBuilder.kt
data class ConfigResponse(
    val width: Int,
    val height: Int,
    val widthMargin: Int,
    val heightMargin: Int,
    val port: Int,
    val resolution: Int,
    val version: Int,
    val usebt: Boolean,
    val debug: Boolean
)

class ConfigResponseBuilder(
    private val videoWidth: Int,
    private val videoHeight: Int,
    private val wsPort: Int,
    private val resolutionIndex: Int,
    private val versionCode: Int,
    private val useBluetooth: Boolean
) {
    fun build(screenWidth: Int, screenHeight: Int): ConfigResponse
}
```

---

## Test Cases

---

### MarginCalculatorTest

#### TC-01 — 16:9 screen with 16:9 video produces zero margins

```
@Test
fun `widthMargin and heightMargin are both zero when screen and video share the same aspect ratio`()
```

Verifies: no letterboxing needed when ratios are identical.

Arrange:
- `screenWidth=1920, screenHeight=1080` (16:9)
- `videoWidth=1920, videoHeight=1080` (16:9)
- `screenRatio = 1920/1080 ≈ 1.7778`
- `videoRatio  = 1920/1080 ≈ 1.7778`

Act:
- `val wm = MarginCalculator.widthMargin(1920, 1080, 1920, 1080)`
- `val hm = MarginCalculator.heightMargin(1920, 1080, 1920, 1080)`

Assert:
- `wm == 0`
- `hm == 0`

---

#### TC-02 — narrow screen (portrait-like 4:3) relative to 16:9 video produces non-zero widthMargin

```
@Test
fun `widthMargin is positive when screen is narrower than the video aspect ratio`()
```

Verifies: pillarboxing case — the sides of the video are cropped.

Arrange:
- `screenWidth=1024, screenHeight=768` (4:3, ratio ≈ 1.333)
- `videoWidth=1920, videoHeight=1080` (16:9, ratio ≈ 1.778)
- `screenRatio (1.333) < videoRatio (1.778)` → `screenRatio <= videoRatio` is true
- Expected: `widthMargin = (1920 - 1080 * (1024.0/768)).toInt() = (1920 - 1440).toInt() = 480`

Act:
- `val wm = MarginCalculator.widthMargin(1024, 768, 1920, 1080)`

Assert:
- `wm == 480`

---

#### TC-03 — narrow screen produces zero heightMargin

```
@Test
fun `heightMargin is zero when screen is narrower than the video aspect ratio`()
```

Arrange: same as TC-02 (4:3 screen, 16:9 video).

Assert:
- `MarginCalculator.heightMargin(1024, 768, 1920, 1080) == 0`

---

#### TC-04 — wide screen (21:9) relative to 16:9 video produces non-zero heightMargin

```
@Test
fun `heightMargin is positive when screen is wider than the video aspect ratio`()
```

Verifies: letterboxing case — top/bottom of the video are cropped.

Arrange:
- `screenWidth=2560, screenHeight=1080` (21.33:9, ratio ≈ 2.370)
- `videoWidth=1920, videoHeight=1080` (16:9, ratio ≈ 1.778)
- `screenRatio (2.370) > videoRatio (1.778)` → condition true
- Expected: `heightMargin = (1080 - 1920 / (2560.0/1080)).toInt() = (1080 - 810).toInt() = 270`

Act:
- `val hm = MarginCalculator.heightMargin(2560, 1080, 1920, 1080)`

Assert:
- `hm == 270`

---

#### TC-05 — wide screen produces zero widthMargin

```
@Test
fun `widthMargin is zero when screen is wider than the video aspect ratio`()
```

Arrange: same as TC-04 (21:9 screen, 16:9 video).

Assert:
- `MarginCalculator.widthMargin(2560, 1080, 1920, 1080) == 0`

---

#### TC-06 — Tesla MCU typical resolution (1920x1200) relative to 16:9 1920x1080 video

```
@Test
fun `Tesla 1920x1200 screen produces correct widthMargin for 1920x1080 video`()
```

Verifies: the most common real-world Tesla screen ratio (1.6 vs 1.778).

Arrange:
- `screenWidth=1920, screenHeight=1200` (ratio = 1.600)
- `videoWidth=1920, videoHeight=1080` (ratio = 1.778)
- `screenRatio (1.600) < videoRatio (1.778)` → widthMargin path
- Expected: `widthMargin = (1920 - 1080 * (1920.0/1200)).toInt() = (1920 - 1728).toInt() = 192`

Act:
- `val wm = MarginCalculator.widthMargin(1920, 1200, 1920, 1080)`

Assert:
- `wm == 192`

---

#### TC-07 — square screen produces widthMargin relative to 16:9 video

```
@Test
fun `square 1080x1080 screen produces non-zero widthMargin for 16x9 video`()
```

Arrange:
- `screenWidth=1080, screenHeight=1080` (ratio = 1.000)
- `videoWidth=1920, videoHeight=1080`
- `screenRatio (1.000) < videoRatio (1.778)`
- Expected: `widthMargin = (1920 - 1080 * 1.0).toInt() = 840`

Assert:
- `MarginCalculator.widthMargin(1080, 1080, 1920, 1080) == 840`

---

#### TC-08 — margins are never negative

```
@Test
fun `widthMargin and heightMargin are always non-negative regardless of input ratios`()
```

Verifies: no negative margin can be returned (would break touch coordinate mapping).

Arrange / Act / Assert (parametrized via `@MethodSource`):

```
screenWidth=1, screenHeight=1,  videoWidth=1920, videoHeight=1080 → wm>=0, hm>=0
screenWidth=4096, screenHeight=1, videoWidth=1920, videoHeight=1080 → wm>=0, hm>=0
screenWidth=1920, screenHeight=1080, videoWidth=1, videoHeight=1 → wm>=0, hm>=0
```

---

#### TC-09 — widthMargin does not exceed videoWidth

```
@Test
fun `widthMargin never exceeds videoWidth`()
```

Ensures no out-of-bounds touch mapping.

Arrange:
- Most extreme case: `screenWidth=1, screenHeight=1000` (essentially 0:∞ ratio)
- `videoWidth=1920, videoHeight=1080`

Assert:
- `MarginCalculator.widthMargin(1, 1000, 1920, 1080) <= 1920`

---

### ConfigResponseBuilderTest

#### TC-10 — build returns all required JSON fields

```
@Test
fun `build returns a ConfigResponse with all required fields populated`()
```

Verifies: no field is accidentally `null` or missing.

Arrange:
- `builder = ConfigResponseBuilder(videoWidth=1920, videoHeight=1080, wsPort=8080, resolutionIndex=2, versionCode=42, useBluetooth=true)`

Act:
- `val response = builder.build(screenWidth=1920, screenHeight=1080)`

Assert (check each field):
- `response.width == 1920`
- `response.height == 1080`
- `response.widthMargin == 0` (same ratio)
- `response.heightMargin == 0`
- `response.port == 8080`
- `response.resolution == 2`
- `response.version == 42`
- `response.usebt == true`
- `response.debug == false`

---

#### TC-11 — build delegates margin calculation to MarginCalculator

```
@Test
fun `build uses MarginCalculator to populate widthMargin and heightMargin`()
```

Arrange:
- `builder` with `videoWidth=1920, videoHeight=1080`
- 4:3 screen: `screenWidth=1024, screenHeight=768`

Act:
- `val response = builder.build(1024, 768)`

Assert:
- `response.widthMargin == 480` (matches TC-02 expected value)
- `response.heightMargin == 0`

---

#### TC-12 — build for 21:9 screen populates heightMargin correctly

```
@Test
fun `build returns correct heightMargin for a wider-than-video screen`()
```

Arrange:
- 21:9 screen: `screenWidth=2560, screenHeight=1080`

Act:
- `val response = builder.build(2560, 1080)`

Assert:
- `response.heightMargin == 270` (matches TC-04)
- `response.widthMargin == 0`

---

#### TC-13 — serialised JSON has correct field names (camelCase)

```
@Test
fun `ConfigResponse serialises to JSON with camelCase field names matching the TaaDa API spec`()
```

Verifies: `widthMargin` not `width_margin`, `usebt` not `use_bt`, etc.

Arrange:
- `response = ConfigResponse(width=1920, height=1080, widthMargin=0, heightMargin=0, port=8080, resolution=2, version=42, usebt=true, debug=false)`

Act:
- `val json = Json.encodeToString(ConfigResponse.serializer(), response)`

Assert (check JSON string):
- Contains `"width":1920`
- Contains `"height":1080`
- Contains `"widthMargin":0`
- Contains `"heightMargin":0`
- Contains `"port":8080`
- Contains `"resolution":2`
- Contains `"version":42`
- Contains `"usebt":true`
- Contains `"debug":false`

---

### ConfigEndpointIntegrationTest

Uses `testApplication { }` from `ktor-server-test-host`.

#### TC-14 — GET /config without query params returns 200 with JSON body

```
@Test
fun `GET slash config returns HTTP 200 with a JSON body`()
```

Arrange:
- `testApplication` with a minimal routing module that installs the `/config` route
- `builder = ConfigResponseBuilder(...)` with known values injected

Act:
- `val response = client.get("/config")`

Assert:
- `response.status == HttpStatusCode.OK`
- `response.contentType()` is `application/json`
- Body is a valid JSON object (parseable without exception)

---

#### TC-15 — GET /config uses w and h query params for margin calculation

```
@Test
fun `GET slash config with w and h params uses them for margin calculation`()
```

Arrange:
- Test server configured with `videoWidth=1920, videoHeight=1080`

Act:
- `client.get("/config?w=1024&h=768")`

Assert:
- Parsed JSON `widthMargin == 480`
- Parsed JSON `heightMargin == 0`

---

#### TC-16 — GET /config with missing w and h defaults to 1920x1080

```
@Test
fun `GET slash config without w and h parameters defaults screen dimensions to 1920 and 1080`()
```

Verifies: the `?: 1920` and `?: 1080` fallbacks in the route handler.

Arrange:
- `videoWidth=1920, videoHeight=1080` (same as default screen)

Act:
- `client.get("/config")`

Assert:
- `widthMargin == 0`
- `heightMargin == 0`

---

#### TC-17 — GET /config includes the correct WebSocket port

```
@Test
fun `GET slash config includes the configured wsPort in the port field`()
```

Arrange:
- Test server configured with `wsPort = 8453`

Act:
- `client.get("/config?w=1920&h=1080")`

Assert:
- Parsed JSON `port == 8453`

---

#### TC-18 — GET /config includes the correct versionCode

```
@Test
fun `GET slash config returns versionCode in the version field`()
```

Arrange:
- `versionCode = 42`

Act:
- `client.get("/config")`

Assert:
- Parsed JSON `version == 42`

---

#### TC-19 — GET /config with non-integer w param returns defaults rather than 400

```
@Test
fun `GET slash config with non-numeric w parameter falls back to default screen width`()
```

Verifies: `?.toIntOrNull() ?: 1920` — malformed input does not cause a 500.

Arrange:
- `videoWidth=1920, videoHeight=1080`

Act:
- `client.get("/config?w=abc&h=def")`

Assert:
- `response.status == HttpStatusCode.OK`
- Body is valid JSON
- `width == 1920, height == 1080` (video dimensions, not screen)
- `widthMargin == 0, heightMargin == 0` (defaults used for screen)

---

#### TC-20 — GET /config returns debug=false in production mode

```
@Test
fun `GET slash config always returns debug=false in the current configuration`()
```

Arrange: no special setup.

Act:
- `client.get("/config")`

Assert:
- Parsed JSON `debug == false`

---

## Red Phase

What fails before any production code is written:

- `MarginCalculatorTest` TC-01 through TC-09: `MarginCalculator` object does not exist; all tests throw `ClassNotFoundException`.
- `ConfigResponseBuilderTest` TC-10 through TC-13: `ConfigResponseBuilder` and `ConfigResponse` do not exist; all tests fail.
- `ConfigEndpointIntegrationTest` TC-14 through TC-20: `WebServer` has no `/config` route; `client.get("/config")` returns `404 Not Found`, causing all status and JSON assertions to fail.

---

## Green Phase

### 1. Create `MarginCalculator`

```kotlin
// network/src/main/java/com/supertesla/aa/network/webserver/MarginCalculator.kt
object MarginCalculator {

    fun widthMargin(
        screenWidth: Int,
        screenHeight: Int,
        videoWidth: Int,
        videoHeight: Int
    ): Int {
        val screenRatio = screenWidth.toFloat() / screenHeight
        val videoRatio  = videoWidth.toFloat()  / videoHeight
        return if (screenRatio <= videoRatio) {
            (videoWidth - videoHeight * screenRatio).toInt().coerceAtLeast(0)
        } else {
            0
        }
    }

    fun heightMargin(
        screenWidth: Int,
        screenHeight: Int,
        videoWidth: Int,
        videoHeight: Int
    ): Int {
        val screenRatio = screenWidth.toFloat() / screenHeight
        val videoRatio  = videoWidth.toFloat()  / videoHeight
        return if (screenRatio > videoRatio) {
            (videoHeight - videoWidth / screenRatio).toInt().coerceAtLeast(0)
        } else {
            0
        }
    }
}
```

TC-01 through TC-09 go green. The `.coerceAtLeast(0)` handles TC-08 without a separate branch.

### 2. Create `ConfigResponse` and `ConfigResponseBuilder`

```kotlin
// network/src/main/java/com/supertesla/aa/network/webserver/ConfigResponseBuilder.kt
@Serializable
data class ConfigResponse(
    val width: Int,
    val height: Int,
    val widthMargin: Int,
    val heightMargin: Int,
    val port: Int,
    val resolution: Int,
    val version: Int,
    val usebt: Boolean,
    val debug: Boolean
)

class ConfigResponseBuilder(
    private val videoWidth: Int,
    private val videoHeight: Int,
    private val wsPort: Int,
    private val resolutionIndex: Int,
    private val versionCode: Int,
    private val useBluetooth: Boolean
) {
    fun build(screenWidth: Int, screenHeight: Int): ConfigResponse = ConfigResponse(
        width        = videoWidth,
        height       = videoHeight,
        widthMargin  = MarginCalculator.widthMargin(screenWidth, screenHeight, videoWidth, videoHeight),
        heightMargin = MarginCalculator.heightMargin(screenWidth, screenHeight, videoWidth, videoHeight),
        port         = wsPort,
        resolution   = resolutionIndex,
        version      = versionCode,
        usebt        = useBluetooth,
        debug        = false
    )
}
```

TC-10 through TC-13 go green.

### 3. Add `/config` route to `WebServer`

```kotlin
// Inside WebServer.start() routing block:
get("/config") {
    val w = call.parameters["w"]?.toIntOrNull() ?: 1920
    val h = call.parameters["h"]?.toIntOrNull() ?: 1080
    val response = configBuilder.build(w, h)
    call.respond(response)
}
```

`configBuilder` is a `ConfigResponseBuilder` constructed when the `WebServer` is started, drawing values from `AppConfig` and service state. TC-14 through TC-20 go green.

---

## Refactor Phase

After all tests are green:

1. **`MarginCalculator` integer truncation**: `(videoWidth - videoHeight * screenRatio).toInt()` truncates towards zero. Decide whether to round half-up for pixel accuracy. Add TC-21 with a case where the computed margin has a non-zero fractional part and assert the rounding direction. Document in KDoc.

2. **`ConfigResponse` field `usebt` naming**: the field name `usebt` is taken directly from TaaDa's API spec. This violates Kotlin naming conventions (`useBt` would be idiomatic). If the JSON serialisation uses `@SerialName("usebt")` on a property named `useBt`, update TC-13 to assert the JSON key is lowercase `usebt` while the Kotlin property is `useBt`.

3. **`WebServer` constructor injection**: `WebServer` currently takes `assetManager` and `port` as constructor parameters. Adding `configBuilder: ConfigResponseBuilder` makes it a third constructor parameter. Consider wrapping all configuration state into a `WebServerConfig` data class to keep the constructor stable when future fields are added.

4. **Integration test scope**: `ConfigEndpointIntegrationTest` starts a test application engine on each test. Promote the `testApplication` setup to a `@BeforeEach` block with shared `client` to reduce boilerplate across TC-14 through TC-20. This is a test-side refactor only.

5. **Dynamic `resolutionChanged` field**: doc 12 mentions a `resolutionChanged` boolean in TaaDa's response. Once the resolution-change detection is implemented, add:
   - `TC-22`: `build()` returns `resolutionChanged=true` when the video dimensions changed since the last call.
   - `TC-23`: `build()` returns `resolutionChanged=false` on the second consecutive call with the same dimensions.
   This will drive adding mutable state to `ConfigResponseBuilder`, which should be extracted into a separate `ResolutionChangeTracker` and tested independently.
