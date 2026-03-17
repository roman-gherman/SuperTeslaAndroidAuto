# 01 — Cleanup & Dead Code Removal

## Problem

The codebase has two parallel service architectures that don't share code, causing confusion and wasted complexity.

## TaaDa Approach

Single `TransporterService` — one service, one pipeline, clear ownership. No dead code.

## Our Current State

| Component | Status | Issue |
|-----------|--------|-------|
| `MainService.kt` | **Dead code** | Not declared in AndroidManifest.xml — cannot be started |
| `TouchInjectionService` | Unused | Only referenced by dead MainService |
| `BatteryOptimizer` | Unused | Only referenced by dead MainService |
| `ReconnectionManager` | Unused | Only referenced by dead MainService |
| `AppStateManager` | Partially dead | Used by dead MainService; TransporterService uses its own companion flows |
| `AppModule.kt` (Hilt) | Mostly wasted | Provides singletons only MainService uses |
| `AudioFocusManager` | Dead code | Instantiated nowhere |
| `:web` module | Empty | Zero dependencies, contributes nothing |
| `AppConfig.SERVER_PORT_HTTP` | Unused | Declared but never referenced |

## Changes Required

### Step 1: Remove dead services and their dependencies
- Delete `MainService.kt`
- Delete `TouchInjectionService.kt` (accessibility service)
- Delete `BatteryOptimizer.kt`
- Delete `ReconnectionManager.kt`
- Delete `AudioFocusManager.kt` from androidauto module
- Remove `TouchInjectionService` from AndroidManifest.xml
- Remove `FOREGROUND_SERVICE_DATA_SYNC` permission (unused)

### Step 2: Consolidate state management
- Remove `AppStateManager` OR migrate TransporterService to use it
- Recommendation: Keep `AppState` sealed class but make TransporterService the single source of truth
- Remove duplicate `HotspotManager` creation (TransporterService creates its own vs Hilt providing one)

### Step 3: Clean up Hilt
- Either make TransporterService use `@AndroidEntryPoint` + Hilt
- Or remove Hilt entirely and use manual DI (simpler, like TaaDa)
- TaaDa uses singleton pattern — works fine for this use case

### Step 4: Clean up modules
- Remove `:web` module OR move HTML/JS assets there from `web/src/main/assets`
- Remove unused `AppConfig.SERVER_PORT_HTTP = 80`

### Step 5: Move wake/wifi lock into TransporterService properly
- TransporterService already does inline lock acquisition
- Add 4-hour timeout to wake lock (currently no timeout = battery drain)
- Replace deprecated `WIFI_MODE_FULL_HIGH_PERF` with `WIFI_MODE_FULL_LOW_LATENCY`

## Files to Modify
- `app/src/main/AndroidManifest.xml`
- `app/src/main/java/com/supertesla/aa/service/TransporterService.kt`
- `app/src/main/java/com/supertesla/aa/di/AppModule.kt`
- `app/build.gradle.kts` (remove unused deps)
- `settings.gradle.kts` (remove `:web` if emptying)

## Files to Delete
- `app/src/main/java/com/supertesla/aa/service/MainService.kt`
- `app/src/main/java/com/supertesla/aa/service/TouchInjectionService.kt`
- `app/src/main/java/com/supertesla/aa/service/BatteryOptimizer.kt`
- `app/src/main/java/com/supertesla/aa/service/ReconnectionManager.kt`
- `androidauto/src/main/java/.../channels/AudioFocusManager.kt`

## Test Plan
- [ ] App compiles without errors after cleanup
- [ ] TransporterService starts and runs (start button works)
- [ ] Wake lock acquired with 4-hour timeout (check via `adb shell dumpsys power`)
- [ ] No accessibility service prompt on fresh install
- [ ] Hilt injection works or is cleanly removed
