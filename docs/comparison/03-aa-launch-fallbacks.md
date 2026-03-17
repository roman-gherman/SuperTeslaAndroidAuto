# 03 — AA Launch & Fallback Strategy

## Problem

Our AA launch only tries broadcast first, then activity. TaaDa has a more robust 2-tier fallback with error handling and a mock Network object.

## TaaDa Approach

```
1. Try WirelessStartupActivity intent with:
   - PARAM_HOST_ADDRESS = "127.0.0.1"
   - PARAM_SERVICE_PORT = 5288
   - wifi_info = mocked WifiInfo (reflection)
   - PARAM_SERVICE_WIFI_NETWORK = Mockito.mock(Network.class, 99999)
2. Catch SecurityException → try WirelessStartupReceiver broadcast
3. On total failure → show AAVersionErrorActivity with:
   - AA version info
   - "Open Play Store" button
   - "Contact Support" email button
```

## Our Current State (`AALauncher.kt`)

```
1. Try WirelessStartupReceiver broadcast (AA v16+)
2. Try WirelessStartupActivity intent with:
   - PARAM_HOST_ADDRESS, PARAM_SERVICE_PORT
   - wifi_info = WifiManager.getConnectionInfo() (real, not mocked)
   - PARAM_SERVICE_WIFI_NETWORK = ConnectivityManager.getActiveNetwork() (real)
3. Try DeveloperHeadUnitNetworkService (dev mode only)
```

## Key Differences

| Aspect | TaaDa | Ours |
|--------|-------|------|
| Primary method | Activity first | Broadcast first |
| Mock Network | Mockito.mock(Network, 99999) | Real activeNetwork |
| Mock WifiInfo | Reflection-created instance | Real WifiManager info |
| Error screen | Dedicated AAVersionErrorActivity | No error screen |
| AA version check | Yes (getPackageInfo) | Yes (isAndroidAutoInstalled) |
| Dev HU fallback | No | Yes (port 5277) |

## Changes Required

### Step 1: Add Mock Network object
TaaDa uses Mockito to create a fake Network with ID 99999. We should do the same:
```kotlin
private fun createMockNetwork(): Network? = try {
    val constructor = Network::class.java.getDeclaredConstructor(Int::class.java)
    constructor.isAccessible = true
    constructor.newInstance(99999)
} catch (e: Exception) {
    Timber.w(e, "Failed to create mock Network, using active network")
    null
}
```

### Step 2: Swap launch order (Activity first, Broadcast fallback)
TaaDa's order works better because the Activity intent carries more extras (wifi_info, network). Only fall back to broadcast when SecurityException occurs (AA 16.4+).

### Step 3: Add error screen
Create a simple Compose screen or dialog showing:
- AA version detected
- "Update Android Auto" button → Play Store
- "Try Again" button

### Step 4: Add `am force-stop` before launch
TaaDa doesn't do this but our TransporterService already does:
```kotlin
Runtime.getRuntime().exec("am force-stop com.google.android.projection.gearhead")
```
Keep this — it clears stale AA state.

## Files to Modify
- `androidauto/src/main/java/.../launcher/AALauncher.kt`
- `app/src/main/java/com/supertesla/aa/ui/` (add error screen)

## Test Plan
- [ ] AA launches successfully on first attempt
- [ ] If Activity method fails, broadcast fallback works
- [ ] Error screen shown when AA is not installed
- [ ] Error screen shown when AA version is incompatible
- [ ] Mock Network(99999) created without crash
