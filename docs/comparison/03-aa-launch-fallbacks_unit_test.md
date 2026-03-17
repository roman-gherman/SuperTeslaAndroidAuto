# 03 — AA Launch & Fallback Strategy: Unit Test Plan

## Prerequisites

Test infrastructure defined in `01-cleanup-dead-code_unit_test.md` must be applied first.

---

## 1. Test Classes

| Test Class | File Path | Class Under Test |
|---|---|---|
| `MockNetworkFactoryTest` | `androidauto/src/test/.../launcher/MockNetworkFactoryTest.kt` | `MockNetworkFactory` (new) |
| `AALauncherTest` | `androidauto/src/test/.../launcher/AALauncherTest.kt` | `AALauncher` |
| `LaunchStrategyOrchestratorTest` | `androidauto/src/test/.../launcher/LaunchStrategyOrchestratorTest.kt` | `LaunchStrategyOrchestrator` (new) |

---

## 2. Refactor Prerequisite: Testability Changes to `AALauncher`

`AALauncher` is currently an `object` with direct calls to `context.startActivity()`, `context.sendBroadcast()`, and system services. These must be abstracted for pure JVM testing:

### 2a. Extract `MockNetworkFactory`

```kotlin
// New file: androidauto/.../launcher/MockNetworkFactory.kt
object MockNetworkFactory {
    fun create(): android.net.Network? = try {
        val constructor = android.net.Network::class.java.getDeclaredConstructor(Int::class.java)
        constructor.isAccessible = true
        constructor.newInstance(99999)
    } catch (e: ReflectiveOperationException) {
        null
    }

    fun isValidMockNetId(network: android.net.Network?): Boolean {
        if (network == null) return false
        return try {
            val field = android.net.Network::class.java.getDeclaredField("netId")
            field.isAccessible = true
            (field.get(network) as? Int) == 99999
        } catch (_: ReflectiveOperationException) {
            false
        }
    }
}
```

### 2b. Extract `LaunchStrategyOrchestrator`

Convert `AALauncher`'s two private launch methods into a strategy pattern driven by an injectable interface, making the fallback logic independently testable:

```kotlin
interface LaunchStrategy {
    fun launch(context: android.content.Context, ip: String, port: Int): LaunchResult
}

sealed class LaunchResult {
    object Success : LaunchResult()
    data class Failure(val reason: String) : LaunchResult()
    object PermissionDenied : LaunchResult()   // SecurityException
}

class LaunchStrategyOrchestrator(
    private val strategies: List<LaunchStrategy>
) {
    fun launch(context: android.content.Context, ip: String, port: Int): LaunchResult {
        for (strategy in strategies) {
            val result = strategy.launch(context, ip, port)
            if (result is LaunchResult.Success) return result
            if (result is LaunchResult.Failure) continue
        }
        return LaunchResult.Failure("All strategies exhausted")
    }
}
```

---

## 3. Test Cases

### 3.1 `MockNetworkFactoryTest`

**File:** `androidauto/src/test/java/com/supertesla/aa/androidauto/launcher/MockNetworkFactoryTest.kt`

```kotlin
class MockNetworkFactoryTest {

    @Test
    fun `create returns non-null Network object`() {
        // AA requires a Network object in the intent extras. If reflection fails,
        // we fall back to null; the important thing is it does not throw.
        //
        // Arrange: —
        // Act:     val network = MockNetworkFactory.create()
        // Assert:  assertNotNull(network)
        //          // If the test runs on a JVM where Network is not in classpath,
        //          // assertNull is also acceptable — test documents the contract.
    }

    @Test
    fun `create does not throw on JVM without Android framework classes`() {
        // Verifies the try/catch absorbs ReflectiveOperationException gracefully.
        // On plain JVM, android.net.Network is not available.
        //
        // Arrange: —
        // Act:     val result = runCatching { MockNetworkFactory.create() }
        // Assert:  assertTrue(result.isSuccess)   // no exception escapes
    }

    @Test
    fun `created network has net ID 99999 when reflection succeeds`() {
        // Guards the mock network ID value used by TaaDa.
        // This test only passes when running on Android (or Robolectric).
        // Mark it with @Tag("requires-android") for selective execution.
        //
        // Arrange: val network = MockNetworkFactory.create() ?: return   // skip if reflection unavailable
        // Act:     val valid = MockNetworkFactory.isValidMockNetId(network)
        // Assert:  assertTrue(valid)
    }

    @Test
    fun `isValidMockNetId returns false for null`() {
        // Arrange: —
        // Act:     val result = MockNetworkFactory.isValidMockNetId(null)
        // Assert:  assertFalse(result)
    }

    @Test
    fun `create called twice returns two independent objects`() {
        // Each launch attempt should get a fresh Network object.
        //
        // Arrange: —
        // Act:     val a = MockNetworkFactory.create()
        //          val b = MockNetworkFactory.create()
        // Assert:  assertNotSame(a, b)   // different instances
    }
}
```

### 3.2 `AALauncherTest`

**File:** `androidauto/src/test/java/com/supertesla/aa/androidauto/launcher/AALauncherTest.kt`

All `Context` interactions are mocked with MockK.

```kotlin
class AALauncherTest {

    private val mockContext: Context = mockk(relaxed = true)
    private val mockPackageManager: PackageManager = mockk(relaxed = true)

    @BeforeEach
    fun setUp() {
        every { mockContext.packageManager } returns mockPackageManager
    }

    // --- isAndroidAutoInstalled ---

    @Test
    fun `isAndroidAutoInstalled returns true when AA package exists`() {
        // Arrange:
        //   every { mockPackageManager.getPackageInfo("com.google.android.projection.gearhead", 0) }
        //       returns mockk()   // any non-null PackageInfo
        //
        // Act:
        //   val result = AALauncher.isAndroidAutoInstalled(mockContext)
        //
        // Assert:
        //   assertTrue(result)
    }

    @Test
    fun `isAndroidAutoInstalled returns false when AA package not found`() {
        // Arrange:
        //   every { mockPackageManager.getPackageInfo("com.google.android.projection.gearhead", 0) }
        //       throws NameNotFoundException()
        //
        // Act:
        //   val result = AALauncher.isAndroidAutoInstalled(mockContext)
        //
        // Assert:
        //   assertFalse(result)
    }

    @Test
    fun `isAndroidAutoInstalled handles unexpected exception gracefully`() {
        // Arrange:
        //   every { mockPackageManager.getPackageInfo(any(), any<Int>()) }
        //       throws RuntimeException("unexpected")
        //
        // Act:
        //   val result = AALauncher.isAndroidAutoInstalled(mockContext)
        //
        // Assert:
        //   assertFalse(result)   // must not propagate exception to caller
    }

    // --- isHeadUnitServerRunning ---

    @Test
    fun `isHeadUnitServerRunning returns false when port is not open`() {
        // Port 5277 is not open during unit tests — no real socket available.
        //
        // Arrange: —  (no mocking needed; Socket will throw ConnectException)
        // Act:     val running = AALauncher.isHeadUnitServerRunning(5277)
        // Assert:  assertFalse(running)
    }

    // --- launchWirelessProjection: activity-first ordering ---

    @Test
    fun `launchWirelessProjection tries activity strategy before broadcast strategy`() {
        // Guards the order swap described in doc 03 (Activity first, Broadcast fallback).
        //
        // Arrange:
        //   val strategyCallOrder = mutableListOf<String>()
        //   val activityStrategy: LaunchStrategy = mockk()
        //   val broadcastStrategy: LaunchStrategy = mockk()
        //   every { activityStrategy.launch(any(), any(), any()) } answers {
        //       strategyCallOrder.add("activity"); LaunchResult.Success
        //   }
        //   every { broadcastStrategy.launch(any(), any(), any()) } answers {
        //       strategyCallOrder.add("broadcast"); LaunchResult.Success
        //   }
        //   val orchestrator = LaunchStrategyOrchestrator(listOf(activityStrategy, broadcastStrategy))
        //
        // Act:
        //   orchestrator.launch(mockContext, "127.0.0.1", 5288)
        //
        // Assert:
        //   assertEquals("activity", strategyCallOrder.first())
    }

    @Test
    fun `launchWirelessProjection falls back to broadcast when activity throws SecurityException`() {
        // TaaDa comment: "catch SecurityException → try WirelessStartupReceiver broadcast"
        //
        // Arrange:
        //   val activityStrategy: LaunchStrategy = mockk()
        //   val broadcastStrategy: LaunchStrategy = mockk()
        //   every { activityStrategy.launch(any(), any(), any()) } returns LaunchResult.PermissionDenied
        //   every { broadcastStrategy.launch(any(), any(), any()) } returns LaunchResult.Success
        //   val orchestrator = LaunchStrategyOrchestrator(listOf(activityStrategy, broadcastStrategy))
        //
        // Act:
        //   val result = orchestrator.launch(mockContext, "127.0.0.1", 5288)
        //
        // Assert:
        //   assertEquals(LaunchResult.Success, result)
        //   verify(exactly = 1) { broadcastStrategy.launch(any(), any(), any()) }
    }

    @Test
    fun `launchWirelessProjection returns Failure when all strategies fail`() {
        // Arrange:
        //   every { activityStrategy.launch(any(), any(), any()) } returns LaunchResult.Failure("no activity")
        //   every { broadcastStrategy.launch(any(), any(), any()) } returns LaunchResult.Failure("no broadcast")
        //   val orchestrator = LaunchStrategyOrchestrator(listOf(activityStrategy, broadcastStrategy))
        //
        // Act:
        //   val result = orchestrator.launch(mockContext, "127.0.0.1", 5288)
        //
        // Assert:
        //   assertTrue(result is LaunchResult.Failure)
    }

    @Test
    fun `launchWirelessProjection does not invoke second strategy if first succeeds`() {
        // Prevents unnecessary side effects (launching AA twice).
        //
        // Arrange:
        //   every { activityStrategy.launch(any(), any(), any()) } returns LaunchResult.Success
        //   val orchestrator = LaunchStrategyOrchestrator(listOf(activityStrategy, broadcastStrategy))
        //
        // Act:
        //   orchestrator.launch(mockContext, "127.0.0.1", 5288)
        //
        // Assert:
        //   verify(exactly = 0) { broadcastStrategy.launch(any(), any(), any()) }
    }
}
```

### 3.3 `LaunchStrategyOrchestratorTest`

**File:** `androidauto/src/test/java/com/supertesla/aa/androidauto/launcher/LaunchStrategyOrchestratorTest.kt`

Tests the pure orchestration logic with no Android framework dependencies.

```kotlin
class LaunchStrategyOrchestratorTest {

    private val mockContext: Context = mockk(relaxed = true)

    @Test
    fun `returns Success immediately on first successful strategy`() {
        // Arrange:
        //   val s1: LaunchStrategy = mockk { every { launch(any(), any(), any()) } returns LaunchResult.Success }
        //   val s2: LaunchStrategy = mockk(relaxed = true)
        //   val orchestrator = LaunchStrategyOrchestrator(listOf(s1, s2))
        //
        // Act: orchestrator.launch(mockContext, "127.0.0.1", 5288)
        //
        // Assert:
        //   verify(exactly = 0) { s2.launch(any(), any(), any()) }
    }

    @Test
    fun `skips PermissionDenied result and continues to next strategy`() {
        // Arrange:
        //   val s1: LaunchStrategy = mockk { every { launch(any(), any(), any()) } returns LaunchResult.PermissionDenied }
        //   val s2: LaunchStrategy = mockk { every { launch(any(), any(), any()) } returns LaunchResult.Success }
        //
        // Act: val result = orchestrator.launch(mockContext, "127.0.0.1", 5288)
        //
        // Assert:
        //   assertEquals(LaunchResult.Success, result)
    }

    @Test
    fun `returns Failure with message when strategy list is empty`() {
        // Edge case: no strategies registered.
        //
        // Arrange: val orchestrator = LaunchStrategyOrchestrator(emptyList())
        //
        // Act: val result = orchestrator.launch(mockContext, "127.0.0.1", 5288)
        //
        // Assert:
        //   assertTrue(result is LaunchResult.Failure)
        //   assertTrue((result as LaunchResult.Failure).reason.isNotBlank())
    }

    @Test
    fun `passes ip and port unchanged to each strategy`() {
        // Verifies the orchestrator does not mutate the connection parameters.
        //
        // Arrange:
        //   val capturedIp = slot<String>()
        //   val capturedPort = slot<Int>()
        //   val strategy: LaunchStrategy = mockk()
        //   every { strategy.launch(any(), capture(capturedIp), capture(capturedPort)) } returns LaunchResult.Success
        //
        // Act: orchestrator.launch(mockContext, "192.168.1.1", 5288)
        //
        // Assert:
        //   assertEquals("192.168.1.1", capturedIp.captured)
        //   assertEquals(5288, capturedPort.captured)
    }

    @Test
    fun `all strategies are attempted in order before returning final failure`() {
        // Arrange:
        //   val order = mutableListOf<Int>()
        //   val strategies = (1..3).map { i ->
        //       mockk<LaunchStrategy> {
        //           every { launch(any(), any(), any()) } answers {
        //               order.add(i); LaunchResult.Failure("s$i")
        //           }
        //       }
        //   }
        //
        // Act: orchestrator.launch(mockContext, "127.0.0.1", 5288)
        //
        // Assert:
        //   assertEquals(listOf(1, 2, 3), order)
    }

    @Test
    fun `ensureAndroidAutoRunning returns false when AA is not installed`() {
        // Guards the early-exit path in ensureAndroidAutoRunning.
        //
        // Arrange:
        //   val mockPm: PackageManager = mockk()
        //   every { mockContext.packageManager } returns mockPm
        //   every { mockPm.getPackageInfo("com.google.android.projection.gearhead", 0) }
        //       throws PackageManager.NameNotFoundException()
        //
        // Act:
        //   val result = AALauncher.ensureAndroidAutoRunning(mockContext)
        //
        // Assert:
        //   assertFalse(result)
        //   // Verify no intent was sent (launch was short-circuited)
        //   verify(exactly = 0) { mockContext.startActivity(any()) }
        //   verify(exactly = 0) { mockContext.sendBroadcast(any()) }
    }
}
```

---

## 4. Red Phase

Tests that must FAIL before implementation changes:

1. `MockNetworkFactoryTest.create returns non-null Network object` — `MockNetworkFactory` does not exist yet.
2. `AALauncherTest.launchWirelessProjection tries activity strategy before broadcast strategy` — current `AALauncher.launchWirelessProjection()` calls `launchViaActivity` first (code says "Method 1: Start WirelessStartupActivity"), so this specific ordering test may already pass. However the `LaunchResult` sealed class and `LaunchStrategyOrchestrator` do not exist, so the test cannot compile → fails.
3. `AALauncherTest.launchWirelessProjection falls back to broadcast when activity throws SecurityException` — current code catches all `Exception` types, not specifically `SecurityException`. The `PermissionDenied` path is not modelled → fails.
4. `LaunchStrategyOrchestratorTest.*` — all fail because `LaunchStrategyOrchestrator` does not exist.

---

## 5. Green Phase

Minimal changes:

1. Create `MockNetworkFactory.kt` with `create()` and `isValidMockNetId()` → `MockNetworkFactoryTest` passes.
2. Create `LaunchResult` sealed class → compile errors resolve.
3. Create `LaunchStrategyOrchestrator` with the strategy list iteration logic → orchestrator tests pass.
4. Create `ActivityLaunchStrategy` that catches `SecurityException` specifically and returns `LaunchResult.PermissionDenied` (all other exceptions return `LaunchResult.Failure`) → fallback test passes.
5. Create `BroadcastLaunchStrategy` → second-strategy tests pass.
6. Rewire `AALauncher.launchWirelessProjection()` to use `LaunchStrategyOrchestrator(listOf(ActivityLaunchStrategy(), BroadcastLaunchStrategy()))`.

---

## 6. Refactor Phase

After green:

- The `ActivityLaunchStrategy` constructor should accept an injectable `NetworkProvider` that wraps `MockNetworkFactory.create()`, allowing the mock network to be replaced in tests without reflection.
- Add a `@Parameterized` (JUnit 5 `@MethodSource`) test to `MockNetworkFactoryTest` covering multiple calls, verifying each returns a distinct instance.
- Extract the `am force-stop` exec call from `TransporterService` into a `ProcessLauncher` interface so it can be mocked: `ProcessLauncher.exec(command: String)`. Add a test verifying it is called with the exact AA package name before the launch strategies are invoked.
- Update `AALauncher.ensureAndroidAutoRunning()` to accept the `LaunchStrategyOrchestrator` via constructor (convert `object` to `class`) so the full flow can be tested with injected mocks rather than relying on Android system services.
