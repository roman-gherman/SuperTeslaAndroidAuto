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
import androidx.compose.ui.unit.sp
import com.supertesla.aa.core.config.AppConfig

@Composable
fun SettingsScreen(onBack: () -> Unit) {
    val context = LocalContext.current
    val prefs = remember { context.getSharedPreferences("settings", Context.MODE_PRIVATE) }

    var virtualIp by remember { mutableStateOf(prefs.getString("virtual_ip", AppConfig.DEFAULT_VIRTUAL_IP) ?: AppConfig.DEFAULT_VIRTUAL_IP) }
    var serverPort by remember { mutableIntStateOf(prefs.getInt("server_port", AppConfig.SERVER_PORT)) }
    var streamingMode by remember { mutableStateOf(prefs.getString("streaming_mode", "auto") ?: "auto") }
    var resolution by remember { mutableStateOf(prefs.getString("resolution", "720p") ?: "720p") }
    var showDebug by remember { mutableStateOf(prefs.getBoolean("show_debug", false)) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
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
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextButton(onClick = onBack) { Text("Back") }
                Spacer(Modifier.weight(1f))
                Text("Settings", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Spacer(Modifier.weight(1f))
                Spacer(Modifier.width(48.dp))
            }

            // Video Section
            SectionHeader("Video")
            DropdownSetting("Resolution", resolution, listOf("720p", "480p", "360p")) {
                resolution = it
                prefs.edit().putString("resolution", it).apply()
            }
            DropdownSetting("Streaming Mode", streamingMode, listOf("auto", "webrtc", "mse", "mjpeg")) {
                streamingMode = it
                prefs.edit().putString("streaming_mode", it).apply()
            }

            Divider(modifier = Modifier.padding(vertical = 8.dp))

            // Network Section
            SectionHeader("Network")
            TextSetting("Virtual IP", virtualIp) {
                virtualIp = it
                prefs.edit().putString("virtual_ip", it).apply()
            }

            Divider(modifier = Modifier.padding(vertical = 8.dp))

            // Advanced Section
            SectionHeader("Advanced")
            SwitchSetting("Show Debug Overlay", showDebug) {
                showDebug = it
                prefs.edit().putBoolean("show_debug", it).apply()
            }
            ActionSetting("Export Logs") {
                exportLogs(context)
            }
            ActionSetting("Re-run Setup Wizard") {
                prefs.edit().putBoolean("wizard_completed", false).apply()
            }

            Divider(modifier = Modifier.padding(vertical = 8.dp))

            // About Section
            SectionHeader("About")
            InfoSetting("Version", "0.1.0")
            InfoSetting("Hostname URL", AppConfig.getServerUrl())
            InfoSetting("Fallback URL", "http://$virtualIp:${AppConfig.SERVER_PORT}")

            Spacer(Modifier.height(32.dp))
        }
    }
}

@Composable
private fun SectionHeader(title: String) {
    Text(
        text = title,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold,
        color = MaterialTheme.colorScheme.primary
    )
}

@Composable
private fun DropdownSetting(label: String, value: String, options: List<String>, onSelect: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = true }
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label)
        Box {
            Text(value, color = MaterialTheme.colorScheme.primary)
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = { onSelect(option); expanded = false }
                    )
                }
            }
        }
    }
}

@Composable
private fun TextSetting(label: String, value: String, onUpdate: (String) -> Unit) {
    var editing by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf(value) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { editing = !editing }
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label)
        if (editing) {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier.width(160.dp),
                singleLine = true,
                trailingIcon = {
                    TextButton(onClick = { onUpdate(text); editing = false }) { Text("OK") }
                }
            )
        } else {
            Text(value, color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f))
        }
    }
}

@Composable
private fun SwitchSetting(label: String, checked: Boolean, onToggle: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label)
        Switch(checked = checked, onCheckedChange = onToggle)
    }
}

@Composable
private fun ActionSetting(label: String, onClick: () -> Unit) {
    Text(
        text = label,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        color = MaterialTheme.colorScheme.primary
    )
}

@Composable
private fun InfoSetting(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label)
        Text(value, color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f))
    }
}

private fun exportLogs(context: Context) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, "SuperTesla AA Logs")
        putExtra(Intent.EXTRA_TEXT, "Log export from SuperTesla AA v0.1.0\n\nAttach logcat output.")
    }
    context.startActivity(Intent.createChooser(intent, "Export Logs").apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK
    })
}
