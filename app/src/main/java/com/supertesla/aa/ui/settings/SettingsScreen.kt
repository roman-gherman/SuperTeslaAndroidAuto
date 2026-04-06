package com.supertesla.aa.ui.settings

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.supertesla.aa.androidauto.headunit.HeadUnitConfig
import com.supertesla.aa.ui.theme.*

@Composable
fun SettingsScreen(onBack: () -> Unit) {
    val context = LocalContext.current
    val prefs = remember { context.getSharedPreferences("settings", Context.MODE_PRIVATE) }

    // Video
    var resolution by remember { mutableStateOf(prefs.getString("resolution", "720p") ?: "720p") }
    var dpi by remember { mutableIntStateOf(prefs.getInt("dpi", 120)) }
    var streamingMode by remember { mutableStateOf(prefs.getString("streaming_mode", "auto") ?: "auto") }

    // Driving
    var rightHandDrive by remember { mutableStateOf(prefs.getBoolean("rhd", false)) }

    // Audio
    var useBluetooth by remember { mutableStateOf(prefs.getBoolean("usebt", true)) }

    // Advanced
    var showDebug by remember { mutableStateOf(prefs.getBoolean("show_debug", false)) }
    var developerMode by remember { mutableStateOf(prefs.getBoolean("developer_mode_enabled", false)) }

    // Developer mode activation
    var versionTapCount by remember { mutableIntStateOf(0) }
    var lastTapTime by remember { mutableLongStateOf(0L) }

    fun saveAndNotifyRestart(key: String, value: Any) {
        val editor = prefs.edit()
        when (value) {
            is String -> editor.putString(key, value)
            is Boolean -> editor.putBoolean(key, value)
            is Int -> editor.putInt(key, value)
        }
        editor.apply()
        Toast.makeText(context, "Restart service to apply changes", Toast.LENGTH_SHORT).show()
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = TeslaDark
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
                .verticalScroll(rememberScrollState())
        ) {
            // Top bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = onBack,
                    modifier = Modifier.height(48.dp),
                    shape = MaterialTheme.shapes.medium,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = TeslaSurfaceVariant,
                        contentColor = TeslaBlue
                    )
                ) {
                    Text("\u2190  Back", style = MaterialTheme.typography.bodyLarge)
                }
                Spacer(Modifier.weight(1f))
                Text("Settings", style = MaterialTheme.typography.headlineMedium, color = TeslaWhite)
                Spacer(Modifier.weight(1f))
                Spacer(Modifier.width(88.dp))
            }

            Spacer(Modifier.height(8.dp))

            // ===== Video =====
            SectionHeader("Video")
            DropdownSetting(
                "Resolution",
                resolution,
                HeadUnitConfig.RESOLUTION_PRESETS.keys.toList()
            ) {
                resolution = it
                saveAndNotifyRestart("resolution", it)
            }

            SliderSetting(
                label = "Display Density (DPI)",
                value = dpi.toFloat(),
                valueRange = 100f..300f,
                steps = 19, // (300-100)/10 - 1 = 19 steps for increments of 10
                valueLabel = "$dpi",
                onValueChange = {
                    dpi = (it / 10).toInt() * 10 // snap to 10s
                },
                onValueChangeFinished = {
                    saveAndNotifyRestart("dpi", dpi)
                }
            )

            DropdownSetting("Streaming Mode", streamingMode, listOf("auto", "webrtc", "mse", "mjpeg")) {
                streamingMode = it; prefs.edit().putString("streaming_mode", it).apply()
            }

            Spacer(Modifier.height(16.dp))

            // ===== Driving =====
            SectionHeader("Driving")
            SwitchSetting("Right-Hand Drive", rightHandDrive) {
                rightHandDrive = it
                saveAndNotifyRestart("rhd", it)
            }

            Spacer(Modifier.height(16.dp))

            // ===== Audio =====
            SectionHeader("Audio")
            SwitchSetting("Bluetooth Audio (skip AA audio channels)", useBluetooth) {
                useBluetooth = it
                saveAndNotifyRestart("usebt", it)
            }
            ActionSetting("Bluetooth Settings") {
                context.startActivity(
                    Intent(android.provider.Settings.ACTION_BLUETOOTH_SETTINGS).apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    }
                )
            }

            Spacer(Modifier.height(16.dp))

            // ===== Advanced =====
            SectionHeader("Advanced")
            if (developerMode) {
                SwitchSetting("Debug Overlay", showDebug) {
                    showDebug = it; prefs.edit().putBoolean("show_debug", it).apply()
                }
                ActionSetting("Export Logs") { exportLogs(context) }
            }
            ActionSetting("Re-run Setup Wizard") {
                prefs.edit().putBoolean("wizard_completed", false).apply()
                Toast.makeText(context, "Wizard will show on next launch", Toast.LENGTH_SHORT).show()
            }

            Spacer(Modifier.height(16.dp))

            // ===== About =====
            SectionHeader("About")
            // 7-tap developer mode activation
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        val now = System.currentTimeMillis()
                        if (now - lastTapTime > 2000) versionTapCount = 0
                        lastTapTime = now
                        versionTapCount++
                        if (versionTapCount >= 7 && !developerMode) {
                            developerMode = true
                            prefs.edit().putBoolean("developer_mode_enabled", true).apply()
                            Toast.makeText(context, "Developer mode enabled!", Toast.LENGTH_SHORT).show()
                        } else if (versionTapCount >= 4 && !developerMode) {
                            val remaining = 7 - versionTapCount
                            Toast.makeText(context, "$remaining taps to developer mode", Toast.LENGTH_SHORT).show()
                        }
                    }
                    .padding(horizontal = 24.dp, vertical = 14.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Version", style = MaterialTheme.typography.bodyLarge, color = TeslaWhite)
                Text("0.1.0", style = MaterialTheme.typography.bodyMedium, color = TeslaGray)
            }
            InfoSetting("Hotspot IP", com.supertesla.aa.core.config.AppConfig.detectedHotspotIp ?: "Not detected")

            Spacer(Modifier.height(40.dp))
        }
    }
}

// ===== Reusable Setting Components =====

@Composable
private fun SectionHeader(title: String) {
    Text(
        text = title,
        modifier = Modifier.padding(horizontal = 24.dp, vertical = 12.dp),
        style = MaterialTheme.typography.labelLarge,
        color = TeslaBlue
    )
}

@Composable
private fun TextFieldSetting(
    label: String,
    value: String,
    placeholder: String = "",
    onValueChange: (String) -> Unit
) {
    Column(modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp)) {
        Text(label, style = MaterialTheme.typography.bodyLarge, color = TeslaWhite)
        Spacer(Modifier.height(4.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(placeholder, color = TeslaGray) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = TeslaWhite,
                unfocusedTextColor = TeslaWhite,
                focusedBorderColor = TeslaBlue,
                unfocusedBorderColor = TeslaSurfaceVariant,
                cursorColor = TeslaBlue
            )
        )
    }
}

@Composable
private fun DropdownSetting(label: String, value: String, options: List<String>, onSelect: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = true }
            .padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label, style = MaterialTheme.typography.bodyLarge, color = TeslaWhite)
        Box {
            Text(value, style = MaterialTheme.typography.bodyLarge, color = TeslaBlue)
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option, style = MaterialTheme.typography.bodyLarge) },
                        onClick = { onSelect(option); expanded = false }
                    )
                }
            }
        }
    }
}

@Composable
private fun SliderSetting(
    label: String,
    value: Float,
    valueRange: ClosedFloatingPointRange<Float>,
    steps: Int,
    valueLabel: String,
    onValueChange: (Float) -> Unit,
    onValueChangeFinished: () -> Unit
) {
    Column(modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(label, style = MaterialTheme.typography.bodyLarge, color = TeslaWhite)
            Text(valueLabel, style = MaterialTheme.typography.bodyLarge, color = TeslaBlue, fontWeight = FontWeight.Bold)
        }
        Slider(
            value = value,
            onValueChange = onValueChange,
            onValueChangeFinished = onValueChangeFinished,
            valueRange = valueRange,
            steps = steps,
            colors = SliderDefaults.colors(
                thumbColor = TeslaBlue,
                activeTrackColor = TeslaBlue,
                inactiveTrackColor = TeslaSurfaceVariant
            )
        )
    }
}

@Composable
private fun SwitchSetting(label: String, checked: Boolean, onToggle: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label, style = MaterialTheme.typography.bodyLarge, color = TeslaWhite)
        Switch(
            checked = checked,
            onCheckedChange = onToggle,
            colors = SwitchDefaults.colors(
                checkedTrackColor = TeslaBlue,
                checkedThumbColor = TeslaWhite
            )
        )
    }
}

@Composable
private fun ActionSetting(label: String, onClick: () -> Unit) {
    Text(
        text = label,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 24.dp, vertical = 16.dp),
        style = MaterialTheme.typography.bodyLarge,
        color = TeslaBlue
    )
}

@Composable
private fun InfoSetting(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 14.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, style = MaterialTheme.typography.bodyLarge, color = TeslaWhite)
        Text(value, style = MaterialTheme.typography.bodyMedium, color = TeslaGray)
    }
}

private fun exportLogs(context: Context) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, "SuperTesla AA Logs")
        putExtra(Intent.EXTRA_TEXT, "Log export from SuperTesla AA v0.1.0")
    }
    context.startActivity(Intent.createChooser(intent, "Export Logs").apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK
    })
}
