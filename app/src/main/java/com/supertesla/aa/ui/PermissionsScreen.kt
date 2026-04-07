package com.supertesla.aa.ui

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.PowerManager
import android.provider.Settings
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.supertesla.aa.ui.theme.*

data class PermissionItem(
    val name: String,
    val isGranted: () -> Boolean,
    val request: (() -> Unit)? = null,
    val isOptional: Boolean = false
)

@Composable
fun PermissionsScreen(onBack: () -> Unit = {}, onAllGranted: () -> Unit = {}) {
    val context = LocalContext.current
    var refreshKey by remember { mutableIntStateOf(0) }

    // Permission launchers
    val btLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { refreshKey++ }

    val locationLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { refreshKey++ }

    val micLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { refreshKey++ }

    val notifLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { refreshKey++ }

    // Force recomposition on refresh
    val permissions = remember(refreshKey) {
        buildPermissionList(context, btLauncher, locationLauncher, micLauncher, notifLauncher)
    }

    val allRequired = permissions.filter { !it.isOptional }
    val allGranted = allRequired.all { it.isGranted() }

    LaunchedEffect(allGranted) {
        if (allGranted) onAllGranted()
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 16.dp)
        ) {
            TextButton(onClick = onBack) {
                Text("< Back", color = TeslaBlue, style = MaterialTheme.typography.bodyLarge)
            }
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Permissions Status",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = if (allGranted) "All permissions granted" else "Some permissions required",
                style = MaterialTheme.typography.bodyMedium,
                color = if (allGranted) TeslaGreen else TeslaRed.copy(alpha = 0.8f)
            )

            Spacer(Modifier.height(16.dp))

            permissions.forEach { perm ->
                val granted = perm.isGranted()
                PermissionRow(
                    name = perm.name,
                    isGranted = granted,
                    isOptional = perm.isOptional,
                    onRequest = { perm.request?.invoke(); refreshKey++ }
                )
                Spacer(Modifier.height(8.dp))
            }

            Spacer(Modifier.height(16.dp))

            // Grant all button
            Button(
                onClick = {
                    permissions.filter { !it.isGranted() && it.request != null }.forEach {
                        it.request?.invoke()
                    }
                    refreshKey++
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = MaterialTheme.shapes.large,
                colors = ButtonDefaults.buttonColors(containerColor = TeslaBlue),
                enabled = !allGranted
            ) {
                Text(
                    if (allGranted) "All Granted" else "Grant Permissions",
                    style = MaterialTheme.typography.titleMedium,
                    color = TeslaDark
                )
            }

            Spacer(Modifier.height(8.dp))

            // Refresh button
            OutlinedButton(
                onClick = { refreshKey++ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Text("Refresh Status")
            }
        }
    }
}

@Composable
private fun PermissionRow(
    name: String,
    isGranted: Boolean,
    isOptional: Boolean,
    onRequest: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(14.dp)
                .clip(CircleShape)
                .background(
                    when {
                        isGranted -> TeslaGreen
                        isOptional -> TeslaAmber
                        else -> TeslaRed
                    }
                )
        )
        Spacer(Modifier.width(16.dp))
        Text(
            text = name,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        if (!isGranted) {
            IconButton(onClick = onRequest) {
                Text("  >  ", color = TeslaBlue)
            }
        }
    }
}

private fun buildPermissionList(
    context: Context,
    btLauncher: androidx.activity.result.ActivityResultLauncher<String>,
    locationLauncher: androidx.activity.result.ActivityResultLauncher<String>,
    micLauncher: androidx.activity.result.ActivityResultLauncher<String>,
    notifLauncher: androidx.activity.result.ActivityResultLauncher<String>
): List<PermissionItem> {
    val items = mutableListOf<PermissionItem>()

    // Bluetooth
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        items += PermissionItem(
            name = "Bluetooth",
            isGranted = { ContextCompat.checkSelfPermission(context, Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED },
            request = { btLauncher.launch(Manifest.permission.BLUETOOTH_CONNECT) }
        )
    }

    // Location
    items += PermissionItem(
        name = "Location",
        isGranted = { ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED },
        request = { locationLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION) }
    )

    // Microphone
    items += PermissionItem(
        name = "Microphone",
        isGranted = { ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED },
        request = { micLauncher.launch(Manifest.permission.RECORD_AUDIO) }
    )

    // Notifications
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        items += PermissionItem(
            name = "Notifications",
            isGranted = { ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED },
            request = { notifLauncher.launch(Manifest.permission.POST_NOTIFICATIONS) }
        )
    }

    // Battery optimization
    items += PermissionItem(
        name = "Battery optimization (unrestricted)",
        isGranted = {
            val pm = context.getSystemService(Context.POWER_SERVICE) as PowerManager
            pm.isIgnoringBatteryOptimizations(context.packageName)
        },
        request = {
            try {
                context.startActivity(Intent(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS, Uri.parse("package:${context.packageName}")).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                })
            } catch (_: Exception) {
                // Fallback to general battery settings
                try {
                    context.startActivity(Intent(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS).apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    })
                } catch (_: Exception) {
                    context.startActivity(Intent(Settings.ACTION_BATTERY_SAVER_SETTINGS).apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    })
                }
            }
        }
    )

    // Android Auto installed (check both package name forms)
    items += PermissionItem(
        name = "Android Auto",
        isGranted = {
            try {
                context.packageManager.getPackageInfo("com.google.android.projection.gearhead", 0)
                true
            } catch (_: Exception) {
                // Try resolving the activity directly
                try {
                    val intent = Intent().apply {
                        component = android.content.ComponentName(
                            "com.google.android.projection.gearhead",
                            "com.google.android.apps.auto.wireless.setup.service.impl.WirelessStartupActivity"
                        )
                    }
                    context.packageManager.resolveActivity(intent, 0) != null
                } catch (_: Exception) { false }
            }
        },
        request = null,
        isOptional = true
    )

    return items
}
