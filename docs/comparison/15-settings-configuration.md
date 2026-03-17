# 15 — Settings & Configuration

## Problem

Our settings screen is minimal. TaaDa has comprehensive settings including resolution, DPI, steering wheel position, BT device selection, VPN toggle, and developer mode.

## TaaDa Settings

| Setting | Key | Default | Options |
|---------|-----|---------|---------|
| VPN enabled | `usevpn` | true | Toggle |
| Fullscreen | `hidetatusbar` | true | Toggle |
| BT devices | `selected_bluetooth_devices` | none | Multi-select |
| Screen width | `stored_width` | 1180 | Int |
| Screen height | `stored_height` | 860 | Int |
| Steering wheel | `rhd` | false (LHD) | Toggle |
| Resolution | `resolution` | "1" (720p) | 0-7 |
| DPI | `dpi` | 120 | 100-300 step 10 |
| Language | `app_language` | system | Dropdown |
| Developer mode | `developer_mode_enabled` | false | Hidden (7 taps) |
| Log collection | `log_collection_enabled` | false | Toggle (dev) |

## Our Settings

| Setting | Key | Default | Options |
|---------|-----|---------|---------|
| Resolution | `resolution` | "720p" | 720p, 480p, 360p |
| Streaming mode | `streaming_mode` | "auto" | auto, webrtc, mse, mjpeg |
| Debug overlay | `show_debug` | false | Toggle |
| Re-run wizard | - | - | Button |

## Changes Required

### Step 1: Add video resolution settings (match TaaDa presets)
```kotlin
val resolutions = listOf(
    "800x480" to 0, "1280x720" to 1, "1920x1080" to 2,
    "2560x1440" to 3, "720x1280 (Portrait)" to 5,
    "1080x1920 (Portrait)" to 6
)
```

### Step 2: Add DPI/zoom control
```kotlin
// Slider: 100-300, step 10, default 120
// Affects AA virtual display density
// Changing DPI requires service restart (with 2s debounce)
```

### Step 3: Add steering wheel position
```kotlin
// Toggle: LHD (default) / RHD
// Affects DriverPosition in ServiceDiscovery
```

### Step 4: Add VPN toggle
```kotlin
// Toggle: Use VPN (default: true)
// When disabled, skip VPN setup in pipeline
```

### Step 5: Add BT audio bypass toggle
```kotlin
// Toggle: Use Bluetooth for audio (default: true)
// When true: omit media/guidance audio channels from SD
```

### Step 6: Add BT device selection
```kotlin
// Multi-select dialog showing paired Bluetooth devices
// Selected device addresses stored for auto-start
```

### Step 7: Add Tesla screen dimensions
```kotlin
// Width/Height input fields
// Default: 1920x1080 (Model S/X/3/Y landscape)
// Used for margin calculation in ServiceDiscovery
```

### Step 8: Add developer mode (hidden)
```kotlin
// 7 taps on version text → reveals advanced settings
// Advanced: log toggle, export logs, memory diagnostics
```

## Files to Modify
- `app/src/main/java/com/supertesla/aa/ui/settings/SettingsScreen.kt` (complete rewrite)
- `androidauto/src/main/java/.../headunit/HeadUnitConfig.kt` (add configurable fields)
- `androidauto/src/main/java/.../proto/ServiceDiscovery.kt` (use config values)
- `app/src/main/java/com/supertesla/aa/service/TransporterService.kt` (read settings)

## Test Plan
- [ ] Each setting persists across app restart
- [ ] Resolution change takes effect after service restart
- [ ] DPI change visible in AA display
- [ ] RHD toggle changes driver position in SD response
- [ ] VPN toggle enables/disables VPN service
- [ ] Developer mode activated by 7 taps
