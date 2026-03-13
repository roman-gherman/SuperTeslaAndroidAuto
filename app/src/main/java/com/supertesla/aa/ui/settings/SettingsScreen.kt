package com.supertesla.aa.ui.settings

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.supertesla.aa.core.config.AppConfig
import com.supertesla.aa.ui.theme.*

@Composable
fun SettingsScreen(onBack: () -> Unit) {
    val context = LocalContext.current
    val prefs = remember { context.getSharedPreferences("settings", Context.MODE_PRIVATE) }

    var streamingMode by remember { mutableStateOf(prefs.getString("streaming_mode", "auto") ?: "auto") }
    var resolution by remember { mutableStateOf(prefs.getString("resolution", "720p") ?: "720p") }
    var showDebug by remember { mutableStateOf(prefs.getBoolean("show_debug", false)) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = TeslaDark
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            // Top bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextButton(
                    onClick = onBack,
                    modifier = Modifier.height(48.dp)
                ) {
                    Text("Back", style = MaterialTheme.typography.bodyLarge, color = TeslaBlue)
                }
                Spacer(Modifier.weight(1f))
                Text(
                    "Settings",
                    style = MaterialTheme.typography.headlineMedium,
                    color = TeslaWhite
                )
                Spacer(Modifier.weight(1f))
                Spacer(Modifier.width(64.dp))
            }

            Spacer(Modifier.height(8.dp))

            // Video
            SectionHeader("Video")
            DropdownSetting("Resolution", resolution, listOf("720p", "480p", "360p")) {
                resolution = it; prefs.edit().putString("resolution", it).apply()
            }
            DropdownSetting("Streaming", streamingMode, listOf("auto", "webrtc", "mse", "mjpeg")) {
                streamingMode = it; prefs.edit().putString("streaming_mode", it).apply()
            }

            Spacer(Modifier.height(16.dp))

            // Advanced
            SectionHeader("Advanced")
            SwitchSetting("Debug Overlay", showDebug) {
                showDebug = it; prefs.edit().putBoolean("show_debug", it).apply()
            }
            ActionSetting("Export Logs") { exportLogs(context) }
            ActionSetting("Re-run Setup Wizard") {
                prefs.edit().putBoolean("wizard_completed", false).apply()
            }

            Spacer(Modifier.height(16.dp))

            // About
            SectionHeader("About")
            InfoSetting("Version", "0.1.0")
            InfoSetting("URL", AppConfig.getServerUrl())
            InfoSetting("Fallback", AppConfig.getServerUrlFallback())

            Spacer(Modifier.height(40.dp))
        }
    }
}

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
