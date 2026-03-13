package com.supertesla.aa.ui

import android.Manifest
import android.content.pm.PackageManager
import android.net.VpnService
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.supertesla.aa.core.config.AppConfig
import com.supertesla.aa.core.model.AppState
import com.supertesla.aa.core.model.HotspotState
import com.supertesla.aa.service.MainService

@Composable
fun MainScreen(viewModel: MainViewModel) {
    val appState by viewModel.appState.collectAsStateWithLifecycle()
    val hotspotState by viewModel.hotspotState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    var vpnPermissionGranted by remember { mutableStateOf(false) }

    val vpnLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        vpnPermissionGranted = true
        MainService.start(context)
    }

    val notificationPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { granted ->
        // Proceed regardless - notification permission is not strictly required
        requestVpnAndStart(context, vpnLauncher) { vpnPermissionGranted = true }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(32.dp))

            Text(
                text = "SuperTesla",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "Android Auto",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
            )

            Spacer(Modifier.height(32.dp))

            // Status card
            StatusCard(appState = appState, hotspotState = hotspotState)

            Spacer(Modifier.height(24.dp))

            // URL display (when server is running)
            if (appState is AppState.ServerRunning || appState is AppState.Streaming) {
                UrlCard(url = AppConfig.getServerUrl())
                Spacer(Modifier.height(24.dp))
            }

            // Error display
            if (appState is AppState.Error) {
                ErrorCard(error = appState as AppState.Error)
                Spacer(Modifier.height(24.dp))
            }

            Spacer(Modifier.weight(1f))

            // Start/Stop button
            Button(
                onClick = {
                    if (appState.isRunning) {
                        MainService.stop(context)
                    } else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
                            ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS)
                            != PackageManager.PERMISSION_GRANTED
                        ) {
                            notificationPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                        } else {
                            requestVpnAndStart(context, vpnLauncher) { vpnPermissionGranted = true }
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (appState.isRunning)
                        MaterialTheme.colorScheme.error
                    else
                        MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    text = if (appState.isRunning) "STOP" else "START",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(Modifier.height(24.dp))
        }
    }
}

@Composable
private fun StatusCard(appState: AppState, hotspotState: HotspotState) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Status",
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
            Spacer(Modifier.height(12.dp))

            StatusRow(
                label = "Hotspot",
                isActive = hotspotState is HotspotState.Enabled || hotspotState is HotspotState.ClientConnected,
                detail = when (hotspotState) {
                    is HotspotState.ClientConnected -> "${hotspotState.clients.size} client(s)"
                    is HotspotState.Enabled -> "No clients"
                    is HotspotState.Disabled -> "Disabled"
                    is HotspotState.Unknown -> "Unknown"
                }
            )
            StatusRow(
                label = "VPN",
                isActive = appState is AppState.VpnReady || appState is AppState.StartingServer ||
                        appState is AppState.ServerRunning || appState is AppState.Streaming,
                detail = if (appState is AppState.VpnReady) appState.virtualIp
                else if (appState is AppState.ServerRunning || appState is AppState.Streaming) AppConfig.DEFAULT_VIRTUAL_IP
                else "Inactive"
            )
            StatusRow(
                label = "Server",
                isActive = appState is AppState.ServerRunning || appState is AppState.Streaming,
                detail = if (appState is AppState.ServerRunning) "Port ${AppConfig.SERVER_PORT}"
                else "Stopped"
            )
            StatusRow(
                label = "Tesla",
                isActive = hotspotState is HotspotState.ClientConnected,
                detail = when (hotspotState) {
                    is HotspotState.ClientConnected ->
                        hotspotState.clients.firstOrNull()?.ipAddress ?: "Connected"
                    else -> "Waiting..."
                }
            )
        }
    }
}

@Composable
private fun StatusRow(label: String, isActive: Boolean, detail: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .clip(CircleShape)
                .background(if (isActive) Color(0xFF4CAF50) else Color(0xFF757575))
        )
        Spacer(Modifier.width(12.dp))
        Text(
            text = label,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.width(80.dp)
        )
        Text(
            text = detail,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
            fontSize = 14.sp
        )
    }
}

@Composable
private fun UrlCard(url: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Open in Tesla Browser:",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = url,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}

@Composable
private fun ErrorCard(error: AppState.Error) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.errorContainer
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Error",
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onErrorContainer
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = error.message,
                color = MaterialTheme.colorScheme.onErrorContainer.copy(alpha = 0.8f),
                fontSize = 14.sp
            )
        }
    }
}

private fun requestVpnAndStart(
    context: android.content.Context,
    vpnLauncher: androidx.activity.result.ActivityResultLauncher<android.content.Intent>,
    onAlreadyGranted: () -> Unit
) {
    val prepareIntent = VpnService.prepare(context)
    if (prepareIntent != null) {
        vpnLauncher.launch(prepareIntent)
    } else {
        onAlreadyGranted()
        MainService.start(context)
    }
}
