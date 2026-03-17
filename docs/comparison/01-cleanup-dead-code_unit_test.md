# 01 — Cleanup & Dead Code Removal: Unit Test Plan

## 1. Test Infrastructure Setup

This section is the single source of truth for all test tooling. All four `_unit_test.md` files assume this infrastructure is in place.

### 1.1 Version Catalog additions (`gradle/libs.versions.toml`)

Add the following to the existing `[versions]`, `[libraries]`, and `[plugins]` blocks:

```toml
[versions]
# Testing
junit5 = "5.10.2"
mockk = "1.13.10"
turbine = "1.1.0"
coroutines-test = "1.7.3"   # keep same as coroutines version already declared

[libraries]
# JUnit 5
junit5-api        = { module = "org.junit.jupiter:junit-jupiter-api",    version.ref = "junit5" }
junit5-engine     = { module = "org.junit.jupiter:junit-jupiter-engine", version.ref = "junit5" }
junit5-params     = { module = "org.junit.jupiter:junit-jupiter-params", version.ref = "junit5" }
# MockK (JVM — no Android instrumentation needed)
mockk             = { module = "io.mockk:mockk",                         version.ref = "mockk" }
# Turbine (Flow testing)
turbine           = { module = "app.cash.turbine:turbine",               version.ref = "turbine" }
# Coroutines test support
coroutines-test   = { module = "org.jetbrains.kotlinx:kotlinx-coroutines-test", version.ref = "coroutines-test" }
```

### 1.2 `androidauto/build.gradle.kts` additions

```kotlin
android {
    // ... existing config ...
    testOptions {
        unitTests.all {
            it.useJUnitPlatform()   // enables JUnit 5
        }
    }
}

dependencies {
    // ... existing dependencies ...

    testImplementation(libs.junit5.api)
    testImplementation(libs.junit5.params)
    testRuntimeOnly(libs.junit5.engine)
    testImplementation(libs.mockk)
    testImplementation(libs.turbine)
    testImplementation(libs.coroutines.test)
}
```

### 1.3 `app/build.gradle.kts` additions

Identical block to the one above — add `testOptions { unitTests.all { it.useJUnitPlatform() } }` and the same `testImplementation` / `testRuntimeOnly` lines.

### 1.4 Test directory structure

```
androidauto/
  src/
    test/
      java/
        com/supertesla/aa/androidauto/
          proto/
            ProtoEncoderTest.kt
            ServiceDiscoveryTest.kt
            AapMessagesTest.kt
          protocol/
            AapFramerTest.kt
          channels/
            ControlChannelHandlerTest.kt
            SensorChannelHandlerTest.kt
          launcher/
            AALauncherTest.kt
          util/
            TestFrameFactory.kt       ← shared test helpers (not a test itself)

app/
  src/
    test/
      java/
        com/supertesla/aa/
          service/
            TransporterServiceLifecycleTest.kt
          config/
            AppConfigTest.kt
```

### 1.5 Conventions used throughout all test plans

- **No Android instrumentation**: All tests run on the JVM with `robolectric` only where unavoidable; prefer plain JUnit 5.
- **MockK** for all mocking; prefer `mockk(relaxed = true)` for collaborators, explicit `every { }` stubs for assertions.
- **`TestScope` / `runTest`** from `kotlinx-coroutines-test` for suspend functions and Flow collection.
- **Turbine** `.test {}` extension for `Flow` / `StateFlow` / `SharedFlow` assertions.
- Test naming convention: backtick function names describing the observable behaviour, e.g. `` `returns false when package not found` ``.

---

## 2. Test Classes

| Test Class | File Path | Class Under Test |
|---|---|---|
| `DeadCodeAbsenceTest` | `app/src/test/.../service/DeadCodeAbsenceTest.kt` | Classpath / build artefacts |
| `AppConfigTest` | `app/src/test/.../config/AppConfigTest.kt` | `AppConfig` constants |
| `WakeLockConfigTest` | `app/src/test/.../service/WakeLockConfigTest.kt` | `TransporterService` wake-lock logic (extracted pure function) |

> Note: The primary deliverable of phase 01 is deletion of code, not new feature logic. The tests here act as **guards** that verify the dead code does not re-appear and that the surviving code has the correct configuration values. This prevents regressions during the cleanup itself.

---

## 3. Test Cases

### 3.1 `AppConfigTest`

**File:** `app/src/test/java/com/supertesla/aa/config/AppConfigTest.kt`

```kotlin
class AppConfigTest {

    @Test
    fun `SERVER_PORT_HTTP constant is not declared after cleanup`() {
        // Red phase: AppConfig currently declares SERVER_PORT_HTTP = 80.
        // After cleanup it should not exist, or if the field is retained it
        // must not be referenced anywhere in production code.
        //
        // Arrange: reflect on AppConfig to find the field by name
        // Act:     AppConfig::class.java.getDeclaredField("SERVER_PORT_HTTP")
        // Assert:  throws NoSuchFieldException
        //
        // Expected: NoSuchFieldException thrown → field was deleted
        // Expected (if kept): field exists but no production usage (verified by separate lint rule)
    }

    @Test
    fun `AA_WIRELESS_PORT is 5288`() {
        // Guards the port constant that all launch paths depend on.
        //
        // Arrange: —
        // Act:     val port = AALauncher.AA_WIRELESS_PORT
        // Assert:  assertEquals(5288, port)
    }

    @Test
    fun `AA_DEV_PORT is 5277`() {
        // Guards the dev-mode port constant.
        //
        // Arrange: —
        // Act:     val port = AALauncher.AA_DEV_PORT
        // Assert:  assertEquals(5277, port)
    }
}
```

### 3.2 `WakeLockConfigTest`

**File:** `app/src/test/java/com/supertesla/aa/service/WakeLockConfigTest.kt`

Context: `TransporterService` acquires a wake lock inline. The 4-hour timeout change from doc 01 is a pure numeric value. We extract that value into a named constant and test it.

```kotlin
class WakeLockConfigTest {

    @Test
    fun `wake lock timeout is 4 hours in milliseconds`() {
        // Guards against regressing to no-timeout (Long.MAX_VALUE) or a wrong value.
        //
        // Arrange: —
        // Act:     val timeout = TransporterService.WAKE_LOCK_TIMEOUT_MS
        // Assert:  assertEquals(4L * 60 * 60 * 1000, timeout)
        //          // 14_400_000 ms
    }

    @Test
    fun `wake lock timeout does not equal Long MAX_VALUE`() {
        // Explicit guard: a zero-argument acquire() (no timeout) drains battery.
        //
        // Arrange: —
        // Act:     val timeout = TransporterService.WAKE_LOCK_TIMEOUT_MS
        // Assert:  assertNotEquals(Long.MAX_VALUE, timeout)
    }
}
```

### 3.3 `DeadCodeAbsenceTest`

**File:** `app/src/test/java/com/supertesla/aa/service/DeadCodeAbsenceTest.kt`

```kotlin
class DeadCodeAbsenceTest {

    @Test
    fun `MainService class does not exist in classpath`() {
        // Red phase: before deletion, Class.forName succeeds.
        // After deletion it must throw ClassNotFoundException.
        //
        // Arrange: —
        // Act:     Class.forName("com.supertesla.aa.service.MainService")
        // Assert:  throws ClassNotFoundException
    }

    @Test
    fun `BatteryOptimizer class does not exist in classpath`() {
        // Same guard for BatteryOptimizer.
        //
        // Arrange: —
        // Act:     Class.forName("com.supertesla.aa.service.BatteryOptimizer")
        // Assert:  throws ClassNotFoundException
    }

    @Test
    fun `ReconnectionManager class does not exist in classpath`() {
        // Arrange: —
        // Act:     Class.forName("com.supertesla.aa.service.ReconnectionManager")
        // Assert:  throws ClassNotFoundException
    }

    @Test
    fun `TouchInjectionService class does not exist in classpath`() {
        // Arrange: —
        // Act:     Class.forName("com.supertesla.aa.service.TouchInjectionService")
        // Assert:  throws ClassNotFoundException
    }

    @Test
    fun `AudioFocusManager class does not exist in classpath`() {
        // Arrange: —
        // Act:     Class.forName("com.supertesla.aa.androidauto.channels.AudioFocusManager")
        // Assert:  throws ClassNotFoundException
    }
}
```

---

## 4. Red Phase

What must FAIL before the cleanup work is done:

1. `DeadCodeAbsenceTest` — all five `Class.forName` assertions currently PASS (classes exist), but the tests assert `ClassNotFoundException`. So all five tests fail in red.
2. `WakeLockConfigTest.wake lock timeout is 4 hours` — fails because `WAKE_LOCK_TIMEOUT_MS` constant does not yet exist on `TransporterService`.
3. `WakeLockConfigTest.wake lock timeout does not equal Long MAX_VALUE` — same reason.
4. `AppConfigTest.SERVER_PORT_HTTP constant is not declared after cleanup` — fails because the field currently exists.

---

## 5. Green Phase

Minimal changes that make each test pass:

1. Delete `MainService.kt`, `BatteryOptimizer.kt`, `ReconnectionManager.kt`, `TouchInjectionService.kt`, `AudioFocusManager.kt` → `DeadCodeAbsenceTest` passes.
2. Add `companion object { const val WAKE_LOCK_TIMEOUT_MS = 4L * 60 * 60 * 1000 }` to `TransporterService`, then use `acquire(WAKE_LOCK_TIMEOUT_MS)` in the lock acquisition call → `WakeLockConfigTest` passes.
3. Delete or comment out `SERVER_PORT_HTTP` from `AppConfig` → `AppConfigTest.SERVER_PORT_HTTP` passes.

---

## 6. Refactor Phase

After green:

- Extract the `WAKE_LOCK_TIMEOUT_MS` into a module-level `const val` in a `WakeLockConstants.kt` file so `TransporterService` is not the only holder.
- Add a Detekt rule (or custom lint check) that fails the build if any of the deleted class names reappear in `import` statements.
- Verify `testUseJUnitPlatform()` is wired up by running `./gradlew :app:test :androidauto:test` and confirming the JUnit 5 engine is used (look for `[engine:junit-jupiter]` in the output).
- Replace `@Suppress("DEPRECATION")` on the wifi lock mode with the `WIFI_MODE_FULL_LOW_LATENCY` swap documented in step 5 of the cleanup doc, and add an `AppConfigTest` case that confirms the wifi lock level constant equals `WifiManager.WIFI_MODE_FULL_LOW_LATENCY`.
