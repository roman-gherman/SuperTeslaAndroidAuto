# 13 — Bluetooth Auto-Start: Unit Test Plan

## Overview

Tests for `TeslaBluetoothReceiver` MAC-address filtering logic and the
SharedPreferences persistence contract for selected Bluetooth devices.
All tests are pure unit tests — no Android instrumentation required —
because the receiver logic under test can be extracted into a plain
Kotlin class (`BluetoothAutoStartLogic`) that the receiver delegates to.

---

## Test Classes

| Test Class | File Path | Class Under Test |
|---|---|---|
| `BluetoothMacFilterTest` | `app/src/test/java/com/supertesla/aa/receiver/BluetoothMacFilterTest.kt` | `BluetoothAutoStartLogic` (to be extracted) |
| `SelectedDevicePrefsTest` | `app/src/test/java/com/supertesla/aa/receiver/SelectedDevicePrefsTest.kt` | `BluetoothAutoStartLogic` / SharedPreferences read path |
| `BluetoothReceiverIntegrationTest` | `app/src/test/java/com/supertesla/aa/receiver/BluetoothReceiverIntegrationTest.kt` | `TeslaBluetoothReceiver` (MockK on Context/Intent) |

---

## Test Cases

### `BluetoothMacFilterTest`

#### `@Test fun `connecting selected device returns StartService action``

- **Verifies**: When the connecting device MAC appears in the stored
  `selected_bluetooth_devices` set, the logic produces a `StartService`
  decision.
- **Arrange**:
  ```
  selectedDevices = setOf("AA:BB:CC:DD:EE:FF", "11:22:33:44:55:66")
  connectingMac   = "AA:BB:CC:DD:EE:FF"
  ```
- **Act**:
  ```kotlin
  val action = BluetoothAutoStartLogic.onConnected(connectingMac, selectedDevices)
  ```
- **Assert**:
  ```kotlin
  assertEquals(BluetoothAutoStartLogic.Action.StartService, action)
  ```
- **Expected inputs/outputs**: MAC in set → `Action.StartService`

---

#### `@Test fun `connecting non-selected device returns NoOp action``

- **Verifies**: A MAC that is not in the persisted set is silently
  ignored.
- **Arrange**:
  ```
  selectedDevices = setOf("AA:BB:CC:DD:EE:FF")
  connectingMac   = "DE:AD:BE:EF:00:01"
  ```
- **Act**:
  ```kotlin
  val action = BluetoothAutoStartLogic.onConnected(connectingMac, selectedDevices)
  ```
- **Assert**:
  ```kotlin
  assertEquals(BluetoothAutoStartLogic.Action.NoOp, action)
  ```
- **Expected inputs/outputs**: MAC not in set → `Action.NoOp`

---

#### `@Test fun `connecting with empty selected set always returns NoOp``

- **Verifies**: When the user has never configured any device, no
  service is started regardless of connecting MAC.
- **Arrange**:
  ```
  selectedDevices = emptySet()
  connectingMac   = "AA:BB:CC:DD:EE:FF"
  ```
- **Act**:
  ```kotlin
  val action = BluetoothAutoStartLogic.onConnected(connectingMac, selectedDevices)
  ```
- **Assert**:
  ```kotlin
  assertEquals(BluetoothAutoStartLogic.Action.NoOp, action)
  ```

---

#### `@Test fun `MAC comparison is case-insensitive``

- **Verifies**: Stored MACs in lower-case still match an upper-case
  broadcast MAC (or vice-versa).
- **Arrange**:
  ```
  selectedDevices = setOf("aa:bb:cc:dd:ee:ff")
  connectingMac   = "AA:BB:CC:DD:EE:FF"
  ```
- **Act**:
  ```kotlin
  val action = BluetoothAutoStartLogic.onConnected(connectingMac, selectedDevices)
  ```
- **Assert**:
  ```kotlin
  assertEquals(BluetoothAutoStartLogic.Action.StartService, action)
  ```

---

#### `@Test fun `disconnecting selected device returns StopService action``

- **Verifies**: When a known device disconnects, the logic signals a
  service stop.
- **Arrange**:
  ```
  selectedDevices = setOf("AA:BB:CC:DD:EE:FF")
  disconnectingMac = "AA:BB:CC:DD:EE:FF"
  ```
- **Act**:
  ```kotlin
  val action = BluetoothAutoStartLogic.onDisconnected(disconnectingMac, selectedDevices)
  ```
- **Assert**:
  ```kotlin
  assertEquals(BluetoothAutoStartLogic.Action.StopService, action)
  ```

---

#### `@Test fun `disconnecting non-selected device returns NoOp``

- **Verifies**: A device that was never selected does not trigger a stop.
- **Arrange**:
  ```
  selectedDevices = setOf("AA:BB:CC:DD:EE:FF")
  disconnectingMac = "DE:AD:BE:EF:00:01"
  ```
- **Act**:
  ```kotlin
  val action = BluetoothAutoStartLogic.onDisconnected(disconnectingMac, selectedDevices)
  ```
- **Assert**:
  ```kotlin
  assertEquals(BluetoothAutoStartLogic.Action.NoOp, action)
  ```

---

#### `@Test fun `null MAC address returns NoOp without throwing``

- **Verifies**: Graceful handling when `BluetoothDevice.getAddress()`
  returns `null` (e.g., missing permission).
- **Arrange**:
  ```
  selectedDevices = setOf("AA:BB:CC:DD:EE:FF")
  connectingMac   = null
  ```
- **Act / Assert**:
  ```kotlin
  assertDoesNotThrow {
      val action = BluetoothAutoStartLogic.onConnected(connectingMac, selectedDevices)
      assertEquals(BluetoothAutoStartLogic.Action.NoOp, action)
  }
  ```

---

### `SelectedDevicePrefsTest`

#### `@Test fun `selected MAC set is read from correct SharedPreferences key``

- **Verifies**: The logic reads from the key
  `"selected_bluetooth_devices"` and not any other key.
- **Arrange**:
  ```kotlin
  val prefs = mockk<SharedPreferences>()
  every {
      prefs.getStringSet("selected_bluetooth_devices", emptySet())
  } returns setOf("AA:BB:CC:DD:EE:FF")
  ```
- **Act**:
  ```kotlin
  val set = BluetoothAutoStartLogic.loadSelectedDevices(prefs)
  ```
- **Assert**:
  ```kotlin
  verify(exactly = 1) {
      prefs.getStringSet("selected_bluetooth_devices", emptySet())
  }
  assertEquals(setOf("AA:BB:CC:DD:EE:FF"), set)
  ```

---

#### `@Test fun `storing a new device MAC persists via editor commit``

- **Verifies**: Adding a device writes through `putStringSet` and calls
  `apply()` on the editor.
- **Arrange**:
  ```kotlin
  val editor = mockk<SharedPreferences.Editor>(relaxed = true)
  val prefs  = mockk<SharedPreferences>()
  every { prefs.edit() } returns editor
  every { prefs.getStringSet(any(), any()) } returns emptySet()
  every { editor.putStringSet(any(), any()) } returns editor
  ```
- **Act**:
  ```kotlin
  BluetoothAutoStartLogic.addDevice("AA:BB:CC:DD:EE:FF", prefs)
  ```
- **Assert**:
  ```kotlin
  verify { editor.putStringSet("selected_bluetooth_devices", setOf("AA:BB:CC:DD:EE:FF")) }
  verify { editor.apply() }
  ```

---

#### `@Test fun `removing a device MAC updates the persisted set``

- **Verifies**: Removing a device writes the set minus that MAC.
- **Arrange**:
  ```kotlin
  val existing = mutableSetOf("AA:BB:CC:DD:EE:FF", "11:22:33:44:55:66")
  val editor = mockk<SharedPreferences.Editor>(relaxed = true)
  val prefs  = mockk<SharedPreferences>()
  every { prefs.edit() } returns editor
  every { prefs.getStringSet(any(), any()) } returns existing
  every { editor.putStringSet(any(), any()) } returns editor
  ```
- **Act**:
  ```kotlin
  BluetoothAutoStartLogic.removeDevice("AA:BB:CC:DD:EE:FF", prefs)
  ```
- **Assert**:
  ```kotlin
  verify {
      editor.putStringSet(
          "selected_bluetooth_devices",
          setOf("11:22:33:44:55:66")
      )
  }
  ```

---

### `BluetoothReceiverIntegrationTest`

#### `@Test fun `ACL_CONNECTED broadcast for selected device starts TransporterService``

- **Verifies**: The receiver calls `ContextCompat.startForegroundService`
  when the connecting MAC is selected.
- **Arrange**:
  ```kotlin
  val context = mockk<Context>(relaxed = true)
  val prefs   = mockk<SharedPreferences>()
  val intent  = mockk<Intent>()
  val device  = mockk<BluetoothDevice>()

  every { device.address } returns "AA:BB:CC:DD:EE:FF"
  every { intent.action } returns BluetoothDevice.ACTION_ACL_CONNECTED
  every { intent.getParcelableExtra<BluetoothDevice>(BluetoothDevice.EXTRA_DEVICE) } returns device
  every { context.getSharedPreferences(any(), any()) } returns prefs
  every { prefs.getStringSet("selected_bluetooth_devices", emptySet()) } returns
      setOf("AA:BB:CC:DD:EE:FF")
  ```
- **Act**:
  ```kotlin
  val receiver = TeslaBluetoothReceiver()
  receiver.onReceive(context, intent)
  ```
- **Assert**:
  ```kotlin
  verify {
      context.startForegroundService(match {
          it.component?.className?.contains("TransporterService") == true
      })
  }
  ```

---

#### `@Test fun `ACL_CONNECTED broadcast for non-selected device does not start service``

- **Verifies**: No service start for an unrecognised MAC.
- **Arrange**: same as above but `prefs` returns `setOf("11:22:33:44:55:66")`
  while device MAC is `"AA:BB:CC:DD:EE:FF"`.
- **Assert**:
  ```kotlin
  verify(exactly = 0) { context.startForegroundService(any()) }
  ```

---

#### `@Test fun `ACL_DISCONNECTED broadcast for selected device stops TransporterService``

- **Verifies**: Disconnect triggers a stop intent.
- **Arrange**: intent action = `BluetoothDevice.ACTION_ACL_DISCONNECTED`,
  device MAC in selected set.
- **Act**: `receiver.onReceive(context, intent)`
- **Assert**:
  ```kotlin
  verify { context.stopService(match { it.component?.className?.contains("TransporterService") == true }) }
  ```

---

## Red Phase

Before implementation the following will fail:

- `BluetoothAutoStartLogic` class does not exist → all `BluetoothMacFilterTest`
  and `SelectedDevicePrefsTest` cases fail with `ClassNotFoundException`.
- `TeslaBluetoothReceiver.onReceive` still contains name-based logic
  (`device.name.contains("Tesla")`) rather than MAC filtering → receiver
  integration tests fail on verify counts.
- `BluetoothAutoStartLogic.Action` sealed class is missing → compilation
  failure.

---

## Green Phase

Minimal code to make all tests pass:

```kotlin
// BluetoothAutoStartLogic.kt (new file)
object BluetoothAutoStartLogic {

    sealed class Action {
        object StartService : Action()
        object StopService  : Action()
        object NoOp         : Action()
    }

    fun onConnected(mac: String?, selectedDevices: Set<String>): Action =
        if (mac != null && selectedDevices.any { it.equals(mac, ignoreCase = true) })
            Action.StartService
        else
            Action.NoOp

    fun onDisconnected(mac: String?, selectedDevices: Set<String>): Action =
        if (mac != null && selectedDevices.any { it.equals(mac, ignoreCase = true) })
            Action.StopService
        else
            Action.NoOp

    fun loadSelectedDevices(prefs: SharedPreferences): Set<String> =
        prefs.getStringSet("selected_bluetooth_devices", emptySet()) ?: emptySet()

    fun addDevice(mac: String, prefs: SharedPreferences) {
        val current = loadSelectedDevices(prefs).toMutableSet()
        current.add(mac)
        prefs.edit().putStringSet("selected_bluetooth_devices", current).apply()
    }

    fun removeDevice(mac: String, prefs: SharedPreferences) {
        val current = loadSelectedDevices(prefs).toMutableSet()
        current.remove(mac)
        prefs.edit().putStringSet("selected_bluetooth_devices", current).apply()
    }
}
```

Minimal receiver change — replace name-check branch with:

```kotlin
val mac = device?.address
val selected = BluetoothAutoStartLogic.loadSelectedDevices(
    context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
)
when (BluetoothAutoStartLogic.onConnected(mac, selected)) {
    BluetoothAutoStartLogic.Action.StartService ->
        ContextCompat.startForegroundService(context, Intent(context, TransporterService::class.java))
    else -> Unit
}
```

---

## Refactor Phase

After green:

1. Replace `object BluetoothAutoStartLogic` with an interface +
   `DefaultBluetoothAutoStartLogic` implementation so it can be injected
   into the receiver for testing without static coupling.
2. Move the SharedPreferences key `"selected_bluetooth_devices"` to a
   `PreferenceKeys` constants object shared with `SettingsScreen`.
3. Add a `@VisibleForTesting` annotation on the logic class and make the
   receiver constructor accept an optional logic parameter (default to
   the real implementation).
4. Introduce `BluetoothAutoStartLogicTest` using property-based testing
   (`kotest` Arb generators) to fuzz MAC string formats.
5. Remove Timber from the logic layer — logging belongs only in the
   receiver boundary.
