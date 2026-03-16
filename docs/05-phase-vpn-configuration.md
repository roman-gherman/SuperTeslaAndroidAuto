# Phase 5: VPN with AA Package Exclusion

## Overview

TaaDa uses a VPN to control network routing and isolate traffic. Critically, it **excludes the Android Auto package** from the VPN to prevent routing loops — since AA connects to `localhost:5288`, its traffic must go directly to the phone, not through the VPN tunnel.

## What TaaDa Does (Exact Implementation)

### 1. MyVpnService (Primary VPN)

```java
public class MyVpnService extends VpnService {

    void establishVpn() {
        Builder builder = new Builder();
        builder.setSession("MyVPNService");
        builder.addAddress("51.75.29.16", 24);       // Virtual IP
        builder.addDnsServer("8.8.8.8");              // Google DNS
        builder.addRoute("0.0.0.0", 0);              // Route ALL traffic

        // CRITICAL: Exclude Android Auto from VPN
        builder.addDisallowedApplication("com.google.android.projection.gearhead");

        ParcelFileDescriptor fd = builder.establish();
        // VPN interface is now active

        // After primary VPN established, start secondary
        startService(new Intent(this, NewVpnService.class));
    }

    void onDestroy() {
        // CountDownLatch-based shutdown coordination
        latch.countDown();
        thread.join(1000);
        // Close VPN interface
    }
}
```

### 2. NewVpnService (Secondary VPN)

```java
public class NewVpnService extends VpnService {

    void establishVpn() {
        Builder builder = new Builder();
        builder.setSession("MyVPNService_2");
        builder.addAddress("89.83.67.208", 24);       // Different virtual IP
        builder.addDnsServer("8.8.8.8");
        builder.addRoute("0.0.0.0", 0);

        // Only allow ConnectivityManager
        builder.addAllowedApplication("android.net.ConnectivityManager");

        ParcelFileDescriptor fd = builder.establish();

        // Open UDP channel to localhost:8089 (protected from VPN)
        DatagramChannel channel = DatagramChannel.open();
        protect(channel.socket());  // Bypass VPN for this socket
        channel.connect(new InetSocketAddress("127.0.0.1", 8089));
    }
}
```

### 3. VpnServiceManager (Shutdown)

```java
public class VpnServiceManager {

    static void stopVpnServices(Context context) {
        // Stop secondary VPN first
        Intent exitIntent = new Intent("fr.sd.taada.exit");
        context.stopService(new Intent(context, NewVpnService.class));
        context.sendBroadcast(exitIntent);

        // Then stop primary VPN
        context.stopService(new Intent(context, MyVpnService.class));
        context.sendBroadcast(exitIntent);
    }
}
```

### 4. Why Two VPN Services?

TaaDa's dual-VPN setup serves a specific purpose:
1. **MyVpnService** (primary): Routes ALL traffic through VPN, EXCEPT Android Auto
2. **NewVpnService** (secondary): Provides a protected UDP channel back to localhost

The primary purpose is to ensure:
- AA traffic goes directly to localhost (not through VPN)
- Tesla browser traffic goes through the phone's hotspot properly
- No routing loops between AA ↔ VPN ↔ WebSocket servers

## What We Currently Have

| Component | File | Status |
|-----------|------|--------|
| VPN tunnel | `network/vpn/VpnTunnelService.kt` | Complete — but routes everything |

### Current VpnTunnelService Issues

```kotlin
// Current implementation
builder.addAddress("240.3.3.3", 32)      // Virtual IP (unusual range)
builder.addRoute("10.0.0.0", 8)           // Private range
builder.addRoute("192.168.0.0", 16)       // Private range
// NO package exclusion for Android Auto!
```

Problems:
1. No exclusion of `com.google.android.projection.gearhead`
2. Uses IP 240.3.3.3 (class E, experimental range — may cause issues)
3. Only routes private ranges (10.x and 192.168.x)
4. No DNS configuration

## What Needs to Change

### 1. Add AA Package Exclusion

```kotlin
// Critical change in VpnTunnelService
builder.addDisallowedApplication("com.google.android.projection.gearhead")
```

This single line prevents AA's localhost connection from being caught by the VPN.

### 2. Update VPN Configuration to Match TaaDa

```kotlin
class VpnTunnelService : VpnService() {

    private fun establishVpn(): ParcelFileDescriptor? {
        val builder = Builder()
        builder.setSession("SuperTeslaVPN")
        builder.addAddress("51.75.29.16", 24)     // Match TaaDa's IP
        builder.addDnsServer("8.8.8.8")
        builder.addRoute("0.0.0.0", 0)            // Route all traffic

        // Exclude Android Auto
        builder.addDisallowedApplication(
            "com.google.android.projection.gearhead"
        )

        return builder.establish()
    }
}
```

### 3. Socket Protection for WebSocket Servers

Our WebSocket servers need to be protected from the VPN (so browser clients can reach them):

```kotlin
// In TransporterService, after VPN is up
vpnService.protect(controlServer.socket)
vpnService.protect(audioServer.socket)
vpnService.protect(voiceServer.socket)
vpnService.protect(webServer.socket)
```

### 4. Consider Single vs Dual VPN

TaaDa uses two VPN services, but we may only need one. The secondary VPN's purpose is unclear (possibly for ConnectivityManager isolation). Start with a single VPN with AA exclusion.

### 5. VPN Lifecycle Management

```kotlin
class VpnServiceManager {
    companion object {
        fun startVpn(context: Context) {
            val intent = Intent(context, VpnTunnelService::class.java)
            context.startForegroundService(intent)
        }

        fun stopVpn(context: Context) {
            val intent = Intent(context, VpnTunnelService::class.java)
            context.stopService(intent)
        }
    }
}
```

### 6. VPN Permission Flow

VPN requires user consent via `VpnService.prepare()`:

```kotlin
// In Activity, before starting VPN
val vpnIntent = VpnService.prepare(this)
if (vpnIntent != null) {
    startActivityForResult(vpnIntent, VPN_REQUEST_CODE)
} else {
    // VPN already authorized, start service
    VpnServiceManager.startVpn(this)
}
```

## Implementation Tasks

1. [ ] Add `addDisallowedApplication("com.google.android.projection.gearhead")` to VPN builder
2. [ ] Update virtual IP from 240.3.3.3 to standard private range (51.75.29.16/24 or similar)
3. [ ] Add DNS server (8.8.8.8) to VPN configuration
4. [ ] Change route to 0.0.0.0/0 (all traffic)
5. [ ] Add socket protection for WebSocket server sockets
6. [ ] Update VPN permission flow in setup wizard
7. [ ] Create `VpnServiceManager` utility class
8. [ ] Add VPN startup to TransporterService sequence
9. [ ] Add graceful VPN shutdown on service stop
10. [ ] Test: AA connects while VPN is active, no routing loops

## Startup Order

```
1. User enables hotspot
2. Start VPN (with AA exclusion)
3. Start WebSocket servers
4. Protect WebSocket sockets from VPN
5. Launch Android Auto (connects to localhost:5288, bypasses VPN)
6. AA ↔ phone communication works
7. Tesla browser connects via hotspot to WebSocket servers
```

## AndroidManifest.xml Requirements

```xml
<service
    android:name=".service.VpnTunnelService"
    android:permission="android.permission.BIND_VPN_SERVICE"
    android:exported="true">
    <intent-filter>
        <action android:name="android.net.VpnService"/>
    </intent-filter>
</service>
```

## Risks

1. **VPN consent popup**: User must approve VPN once. If they deny, AA relay won't work properly.
2. **Battery drain**: VPN processing adds CPU overhead. Minimize by excluding AA and using efficient routing.
3. **Other apps affected**: With 0.0.0.0/0 route, all non-AA traffic goes through VPN. This may break other apps' connectivity. Consider only routing specific ranges if issues arise.
