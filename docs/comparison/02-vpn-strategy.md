# 02 — VPN Strategy: Exclude AA from VPN

## Problem

Our VPN service exists but is **never started** by TransporterService. Without VPN, the virtual IP `240.3.3.3` doesn't work, and Tesla must navigate to the raw hotspot IP.

## TaaDa Approach

Dual VPN services that **exclude AA from VPN** via `addDisallowedApplication()`:
```java
// MyVpnService.java
builder.addDisallowedApplication("com.google.android.projection.gearhead");
builder.addAddress("51.75.29.16", 24);
builder.addDnsServer("8.8.8.8");
builder.addRoute("0.0.0.0", 0);
```

This forces AA to connect to the real network (localhost:5288) while all other traffic goes through the VPN tunnel. The VPN creates a routable virtual IP that Tesla's browser can reach.

## Our Current State

- `VpnTunnelService.kt` exists with correct implementation (excludes AA, creates 240.3.3.3/24)
- `TransporterService.startVpn()` method exists but is **never called** in `startPipeline()`
- `LocalDnsServer` resolves `super.taa` → 240.3.3.3 but VPN not running so IP unreachable
- Tesla browser must use raw hotspot IP fallback

## Changes Required

### Step 1: Call startVpn() in TransporterService pipeline
```kotlin
// In startPipeline(), before starting web server:
startVpn()
delay(1000) // Wait for VPN to establish
```

### Step 2: Verify VPN excludes AA correctly
Our `VpnTunnelService` already has:
```kotlin
addDisallowedApplication("com.google.android.projection.gearhead")
```
Verify this works on target Android versions (API 26+).

### Step 3: Start LocalDnsServer in TransporterService
Currently only MainService (dead code) starts DNS. Add to TransporterService:
```kotlin
val dnsServer = LocalDnsServer(hostname = "super.taa", virtualIp = "240.3.3.3")
dnsServer.start()
```

### Step 4: Update notification URL
After VPN + DNS are running, notification should show `http://super.taa` (not fallback IP).

### Step 5: Handle VPN permission
Check `VpnService.prepare(context)` — if returns non-null, need user to grant VPN permission. The wizard already handles this in page 3.

## TaaDa vs Our Implementation

| Aspect | TaaDa | Ours |
|--------|-------|------|
| VPN address | 51.75.29.16/24 | 240.3.3.3/24 (Class E) |
| AA excluded | Yes | Yes (code exists) |
| DNS server | No (external hosting) | Yes (LocalDnsServer on port 53) |
| Secondary VPN | Yes (NewVpnService) | No |
| VPN actually started | Yes | **No** |

## Files to Modify
- `app/src/main/java/com/supertesla/aa/service/TransporterService.kt` — call `startVpn()`, start DNS server

## Test Plan
- [ ] VPN permission requested during setup wizard
- [ ] `VpnTunnelService` starts when TransporterService starts
- [ ] `adb shell ifconfig` shows tun0 interface with 240.3.3.3
- [ ] `LocalDnsServer` resolves `super.taa` → 240.3.3.3 (test with `nslookup`)
- [ ] Tesla browser can navigate to `http://super.taa:8080`
- [ ] AA still connects to localhost:5288 (not routed through VPN)
