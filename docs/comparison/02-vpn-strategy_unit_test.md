# 02 — VPN Strategy: Unit Test Plan

## Prerequisites

Test infrastructure defined in `01-cleanup-dead-code_unit_test.md` must be applied first (JUnit 5, MockK, Turbine, coroutines-test added to both modules).

---

## 1. Test Classes

| Test Class | File Path | Class Under Test |
|---|---|---|
| `LocalDnsServerTest` | `app/src/test/.../network/LocalDnsServerTest.kt` | `LocalDnsServer` |
| `VpnConfigTest` | `app/src/test/.../vpn/VpnConfigTest.kt` | `VpnTunnelService` constants / builder config |
| `TransporterServiceVpnOrderTest` | `app/src/test/.../service/TransporterServiceVpnOrderTest.kt` | `TransporterService.startPipeline()` ordering |

> Note: `VpnService.Builder` is a final Android class. All tests that touch it must either (a) test a thin wrapper function that accepts an injectable builder interface, or (b) use reflection inspection of constants only. The test plan below follows strategy (a), which requires a minor refactor of `VpnTunnelService`.

---

## 2. Refactor Prerequisite: Injectable VPN Builder Interface

Before writing tests, extract the builder calls into a testable shape. The intent is described here so the Red phase tests drive the extraction:

```kotlin
// New interface in androidauto or core module
interface VpnBuilderConfig {
    val virtualAddress: String
    val virtualPrefix: Int
    val dnsServer: String
    val excludedPackages: List<String>
}

data class DefaultVpnBuilderConfig(
    override val virtualAddress: String = "240.3.3.3",
    override val virtualPrefix: Int = 24,
    override val dnsServer: String = "8.8.8.8",
    override val excludedPackages: List<String> = listOf("com.google.android.projection.gearhead")
) : VpnBuilderConfig
```

This data class is pure Kotlin with no Android imports — fully unit-testable.

---

## 3. Test Cases

### 3.1 `VpnConfigTest`

**File:** `app/src/test/java/com/supertesla/aa/vpn/VpnConfigTest.kt`

```kotlin
class VpnConfigTest {

    @Test
    fun `default virtual address is 240 dot 3 dot 3 dot 3`() {
        // Guards the virtual IP that the Tesla browser navigates to.
        // Changing this without a corresponding DNS update breaks the whole routing chain.
        //
        // Arrange: val config = DefaultVpnBuilderConfig()
        // Act:     val ip = config.virtualAddress
        // Assert:  assertEquals("240.3.3.3", ip)
    }

    @Test
    fun `default prefix length is 24`() {
        // Arrange: val config = DefaultVpnBuilderConfig()
        // Act:     val prefix = config.virtualPrefix
        // Assert:  assertEquals(24, prefix)
    }

    @Test
    fun `AA package is in excluded packages list`() {
        // Critical: if AA is NOT excluded it routes through the VPN and cannot
        // reach localhost:5288 where our server listens.
        //
        // Arrange: val config = DefaultVpnBuilderConfig()
        // Act:     val excluded = config.excludedPackages
        // Assert:  assertTrue(excluded.contains("com.google.android.projection.gearhead"))
    }

    @Test
    fun `excluded packages list is not empty`() {
        // Guards against accidentally clearing the list.
        //
        // Arrange: val config = DefaultVpnBuilderConfig()
        // Act:     val excluded = config.excludedPackages
        // Assert:  assertTrue(excluded.isNotEmpty())
    }

    @Test
    fun `DNS server is a valid IPv4 address`() {
        // Verifies the DNS server string is well-formed before passing it to
        // the VPN builder, which would throw on an invalid address.
        //
        // Arrange: val config = DefaultVpnBuilderConfig()
        //          val ipv4Regex = Regex("""^\d{1,3}(\.\d{1,3}){3}$""")
        // Act:     val dns = config.dnsServer
        // Assert:  assertTrue(ipv4Regex.matches(dns))
    }

    @Test
    fun `custom config overrides all fields independently`() {
        // Verifies the data class copy semantics work correctly so callers can
        // override individual fields without affecting others.
        //
        // Arrange: val base = DefaultVpnBuilderConfig()
        //          val custom = base.copy(virtualAddress = "10.0.0.1")
        // Act:     —
        // Assert:  assertEquals("10.0.0.1", custom.virtualAddress)
        //          assertEquals(base.virtualPrefix, custom.virtualPrefix)
        //          assertEquals(base.dnsServer, custom.dnsServer)
        //          assertEquals(base.excludedPackages, custom.excludedPackages)
    }
}
```

### 3.2 `LocalDnsServerTest`

**File:** `app/src/test/java/com/supertesla/aa/network/LocalDnsServerTest.kt`

`LocalDnsServer` resolves a hostname to a virtual IP. The resolution logic is pure (no socket required for the lookup table itself). The test exercises the resolver logic in isolation.

```kotlin
class LocalDnsServerTest {

    @Test
    fun `resolves configured hostname to configured virtual IP`() {
        // The core contract: "super.taa" → "240.3.3.3"
        //
        // Arrange: val dns = LocalDnsServer(hostname = "super.taa", virtualIp = "240.3.3.3")
        // Act:     val resolved = dns.resolve("super.taa")
        // Assert:  assertEquals("240.3.3.3", resolved)
        //
        // Note: this drives extracting a resolve(hostname: String): String? pure function
        // out of LocalDnsServer so it can be called without binding to a socket.
    }

    @Test
    fun `returns null for unknown hostname`() {
        // Unknown hostnames must NOT be answered (pass-through to upstream).
        //
        // Arrange: val dns = LocalDnsServer(hostname = "super.taa", virtualIp = "240.3.3.3")
        // Act:     val resolved = dns.resolve("unknown.host")
        // Assert:  assertNull(resolved)
    }

    @Test
    fun `resolve is case-insensitive for hostname`() {
        // DNS is case-insensitive; the resolver should normalise before comparing.
        //
        // Arrange: val dns = LocalDnsServer(hostname = "super.taa", virtualIp = "240.3.3.3")
        // Act:     val upper = dns.resolve("SUPER.TAA")
        //          val mixed = dns.resolve("Super.Taa")
        // Assert:  assertEquals("240.3.3.3", upper)
        //          assertEquals("240.3.3.3", mixed)
    }

    @Test
    fun `resolve handles trailing dot (FQDN format)`() {
        // Many DNS clients append a trailing dot for FQDN; the resolver must strip it.
        //
        // Arrange: val dns = LocalDnsServer(hostname = "super.taa", virtualIp = "240.3.3.3")
        // Act:     val resolved = dns.resolve("super.taa.")
        // Assert:  assertEquals("240.3.3.3", resolved)
    }

    @Test
    fun `virtual IP returned is a valid IPv4 address string`() {
        // Guards against a misconfigured virtual IP that would crash the VPN builder.
        //
        // Arrange: val dns = LocalDnsServer(hostname = "super.taa", virtualIp = "240.3.3.3")
        //          val ipv4Regex = Regex("""^\d{1,3}(\.\d{1,3}){3}$""")
        // Act:     val resolved = dns.resolve("super.taa")!!
        // Assert:  assertTrue(ipv4Regex.matches(resolved))
    }

    @Test
    fun `DNS server supports multiple hostname-to-IP mappings`() {
        // Future-proofing: the server may need to resolve more than one name.
        // Drives the API to accept a Map rather than a single pair.
        //
        // Arrange: val dns = LocalDnsServer(
        //              mappings = mapOf("super.taa" to "240.3.3.3", "app.taa" to "240.3.3.4")
        //          )
        // Act:     val a = dns.resolve("super.taa")
        //          val b = dns.resolve("app.taa")
        // Assert:  assertEquals("240.3.3.3", a)
        //          assertEquals("240.3.3.4", b)
    }
}
```

### 3.3 `TransporterServiceVpnOrderTest`

**File:** `app/src/test/java/com/supertesla/aa/service/TransporterServiceVpnOrderTest.kt`

This test verifies that `startVpn()` and the DNS server startup are called **before** the web server in `startPipeline()`. It uses MockK to track call order.

```kotlin
class TransporterServiceVpnOrderTest {

    private val mockVpnStarter: VpnStarter = mockk(relaxed = true)
    private val mockDnsStarter: DnsStarter = mockk(relaxed = true)
    private val mockWebServerStarter: WebServerStarter = mockk(relaxed = true)

    // VpnStarter, DnsStarter, WebServerStarter are thin interfaces extracted for DI
    // Each has a single suspend fun start(): Unit

    @Test
    fun `VPN is started before web server in pipeline`() = runTest {
        // Regression guard: doc 02 states startVpn() must be called before the web server.
        //
        // Arrange:
        //   val callOrder = mutableListOf<String>()
        //   every { mockVpnStarter.start() } answers { callOrder.add("vpn") }
        //   every { mockWebServerStarter.start() } answers { callOrder.add("web") }
        //   val pipeline = PipelineOrchestrator(mockVpnStarter, mockDnsStarter, mockWebServerStarter)
        //
        // Act:
        //   pipeline.startPipeline()
        //
        // Assert:
        //   val vpnIndex = callOrder.indexOf("vpn")
        //   val webIndex = callOrder.indexOf("web")
        //   assertTrue(vpnIndex < webIndex, "VPN ($vpnIndex) must start before web ($webIndex)")
    }

    @Test
    fun `DNS server is started before web server in pipeline`() = runTest {
        // Same ordering guard for DNS startup.
        //
        // Arrange: (same mock setup as above, also track "dns")
        // Act:     pipeline.startPipeline()
        // Assert:  dnsIndex < webIndex
    }

    @Test
    fun `VPN permission check is performed before VPN start`() = runTest {
        // VpnService.prepare(context) must return null (permission already granted)
        // before calling startVpn(); otherwise the activity intent must be sent.
        //
        // Arrange:
        //   val mockVpnPermissionChecker: VpnPermissionChecker = mockk()
        //   every { mockVpnPermissionChecker.isPrepared() } returns true
        //   // no permission-request side effect expected
        //
        // Act:     pipeline.startPipeline()
        //
        // Assert:  verify(exactly = 1) { mockVpnPermissionChecker.isPrepared() }
        //          verify(exactly = 1) { mockVpnStarter.start() }
    }

    @Test
    fun `VPN is not started when permission is not granted`() = runTest {
        // When isPrepared() returns false, the pipeline must NOT call start() on VPN.
        //
        // Arrange:
        //   every { mockVpnPermissionChecker.isPrepared() } returns false
        //
        // Act:     pipeline.startPipeline()
        //
        // Assert:  verify(exactly = 0) { mockVpnStarter.start() }
    }
}
```

---

## 4. Red Phase

Tests that must FAIL before implementation:

1. `VpnConfigTest` — all tests fail because `DefaultVpnBuilderConfig` does not yet exist.
2. `LocalDnsServerTest.resolves configured hostname to configured virtual IP` — fails because `LocalDnsServer.resolve(String)` pure function does not yet exist (only socket-bound methods exist, if any).
3. `LocalDnsServerTest.resolve is case-insensitive` — fails if current implementation does a case-sensitive string compare.
4. `TransporterServiceVpnOrderTest.VPN is started before web server` — fails because `startVpn()` is never called in `startPipeline()` (confirmed in doc 02: "never called").
5. `TransporterServiceVpnOrderTest.DNS server is started before web server` — fails because DNS startup is only in the dead `MainService`.

---

## 5. Green Phase

Minimal changes to make each group pass:

1. Create `DefaultVpnBuilderConfig` data class with the four fields → `VpnConfigTest` passes.
2. Extract `fun resolve(hostname: String): String?` from `LocalDnsServer` that does a case-normalised lookup of an internal map → `LocalDnsServerTest` passes.
3. Add `startVpn()` call (and a 1 000 ms delay) in `startPipeline()` before the web server start, and add DNS server start similarly → `TransporterServiceVpnOrderTest` passes.
4. Wrap the VPN start behind a `VpnPermissionChecker.isPrepared()` call that delegates to `VpnService.prepare(context) == null` → permission tests pass.

---

## 6. Refactor Phase

After green:

- Replace the `delay(1000)` placeholder in `startPipeline()` with a `Flow`-based readiness signal: `VpnTunnelService` emits a `VpnState.Connected` event; the pipeline collects the first such event with a timeout via `withTimeout(5_000) { vpnStateFlow.first { it == VpnState.Connected } }`.
- Add a `VpnStateFlowTest` that exercises the `StateFlow` transitions using Turbine.
- Move `DefaultVpnBuilderConfig` into the `core` module so both `:app` and `:androidauto` can reference the constants.
- Delete the `delay` import from `TransporterService` once the flow-based approach is in place.
