# 12 — HTTPS Config Endpoint

## Problem

TaaDa serves a JSON config endpoint over HTTPS that tells the browser which WebSocket port to connect to, the video resolution, and margin offsets. Our Ktor server serves HTML directly but doesn't have this config negotiation.

## TaaDa Approach

**HTTPS server on port 8081-8085** (separate from WebSocket servers):
```
GET /?w=<screen_width>&h=<screen_height>&webcodec=true

Response:
{
  "width": 1920, "height": 1080,
  "widthMargin": 0, "heightMargin": 0,
  "port": 8453,
  "resolution": 2,
  "buildversion": 42,
  "usebt": true,
  "debug": false,
  "resolutionChanged": true
}
```

The browser uses this to:
1. Know which WebSocket port to connect to
2. Know the video resolution for touch coordinate mapping
3. Know the margin offsets for letterboxing
4. Detect resolution changes

## Our Current State

- Ktor server on port 8080 serves HTML + WebSocket on same port
- No separate config endpoint
- Browser hardcodes `DISPLAY_W=1280, DISPLAY_H=720` in touch.js
- No margin calculation
- WebSocket port is always `:8080/ws` (same as HTTP)

## Changes Required

### Step 1: Add /config endpoint to Ktor server
```kotlin
get("/config") {
    val screenWidth = call.parameters["w"]?.toIntOrNull() ?: 1920
    val screenHeight = call.parameters["h"]?.toIntOrNull() ?: 1080
    val webcodec = call.parameters["webcodec"]?.toBooleanStrictOrNull() ?: true

    call.respond(mapOf(
        "width" to config.videoWidth,
        "height" to config.videoHeight,
        "widthMargin" to calculateWidthMargin(screenWidth, screenHeight),
        "heightMargin" to calculateHeightMargin(screenWidth, screenHeight),
        "port" to controlServerPort,  // WebSocket base port
        "resolution" to resolutionIndex,
        "version" to BuildConfig.VERSION_CODE,
        "usebt" to useBluetooth,
        "debug" to false
    ))
}
```

### Step 2: Browser fetches config on load
```javascript
// In player.js, before connecting WebSocket:
async function fetchConfig() {
    const resp = await fetch('/config?w=' + screen.width + '&h=' + screen.height + '&webcodec=' + (typeof VideoDecoder === 'function'));
    const config = await resp.json();
    DISPLAY_W = config.width;
    DISPLAY_H = config.height;
    // Use config.port for WebSocket if different from HTTP
}
```

### Step 3: Add margin calculation
```kotlin
fun calculateWidthMargin(screenWidth: Int, screenHeight: Int): Int {
    val screenRatio = screenWidth.toFloat() / screenHeight
    val videoRatio = videoWidth.toFloat() / videoHeight
    return if (screenRatio <= videoRatio) {
        (videoWidth - (videoHeight * screenRatio)).toInt()
    } else 0
}
```

### Step 4: Dynamic resolution update
When Tesla's screen dimensions change, recalculate margins and optionally send UpdateUiConfigRequest to AA.

## Files to Modify
- `network/src/main/java/.../webserver/WebServer.kt` (add /config route)
- `web/src/main/assets/player.js` (fetch config)
- `web/src/main/assets/touch.js` (use dynamic DISPLAY_W/H)

## Test Plan
- [ ] `/config` returns correct JSON
- [ ] Browser uses dynamic resolution for touch mapping
- [ ] Margin offsets calculated correctly for 16:9 vs other aspect ratios
- [ ] Touch coordinates accurate after config fetch
