package com.supertesla.aa.ui

import android.Manifest
import android.content.pm.PackageManager
import android.net.VpnService
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.ui.res.painterResource
import com.supertesla.aa.R
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.supertesla.aa.service.TransporterService
import com.supertesla.aa.ui.theme.*

@Composable
fun MainScreen(viewModel: MainViewModel, onSettings: () -> Unit = {}, onPermissions: () -> Unit = {}) {
    val appState by viewModel.appState.collectAsStateWithLifecycle()
    val hotspotState by viewModel.hotspotState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    // Observe TransporterService state
    val serviceActive by TransporterService.isActiveFlow.collectAsStateWithLifecycle()
    val serviceConnected by TransporterService.isConnectedFlow.collectAsStateWithLifecycle()
    val serviceVideoActive by TransporterService.isVideoActiveFlow.collectAsStateWithLifecycle()
    val serviceStatus by TransporterService.statusText.collectAsStateWithLifecycle()

    val isRunning = serviceActive || appState.isRunning

    var vpnPermissionGranted by remember { mutableStateOf(false) }

    val vpnLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { _ ->
        vpnPermissionGranted = true
        TransporterService.start(context)
    }

    val notifLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { _ ->
        requestVpnAndStart(context, vpnLauncher) { vpnPermissionGranted = true }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
        ) {
            // Settings gear icon - top right
            IconButton(
                onClick = onSettings,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 8.dp, end = 12.dp)
                    .size(48.dp)
            ) {
                Icon(
                    Icons.Default.Settings,
                    contentDescription = "Settings",
                    tint = TeslaGray,
                    modifier = Modifier.size(28.dp)
                )
            }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 28.dp)
                .padding(top = 16.dp, bottom = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo + Header
            Spacer(Modifier.height(16.dp))
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "SuperTesla",
                modifier = Modifier.size(88.dp)
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = "SuperTesla",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(Modifier.height(36.dp))

            // URL card (prominent when running)
            if (isRunning) {
                UrlCard(url = AppConfig.getServerUrlFallback())
                Spacer(Modifier.height(12.dp))
                // Status text from service
                if (serviceActive) {
                    Text(
                        text = serviceStatus,
                        style = MaterialTheme.typography.bodyMedium,
                        color = TeslaGray
                    )
                    Spacer(Modifier.height(12.dp))
                }
            }

            // Status indicators
            StatusCard(
                serviceActive = serviceActive,
                serviceConnected = serviceConnected,
                serviceVideoActive = serviceVideoActive,
                hotspotState = hotspotState
            )

            Spacer(Modifier.height(12.dp))
            OutlinedButton(
                onClick = onPermissions,
                modifier = Modifier.fillMaxWidth().height(48.dp),
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.outlinedButtonColors(contentColor = TeslaBlue)
            ) {
                Text("Check Permissions", style = MaterialTheme.typography.bodyLarge)
            }

            // Error
            if (appState is AppState.Error) {
                Spacer(Modifier.height(20.dp))
                ErrorCard(error = appState as AppState.Error)
            }

            Spacer(Modifier.weight(1f))

            // Loading state
            val isLoading = serviceActive && !serviceConnected

            if (isLoading) {
                val infiniteTransition = rememberInfiniteTransition(label = "loading")
                val rotation by infiniteTransition.animateFloat(
                    initialValue = 0f,
                    targetValue = 360f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(1200, easing = LinearEasing),
                        repeatMode = RepeatMode.Restart
                    ),
                    label = "spin"
                )
                CircularProgressIndicator(
                    modifier = Modifier.size(48.dp),
                    color = TeslaBlue,
                    strokeWidth = 4.dp
                )
                Spacer(Modifier.height(12.dp))
                Text(
                    text = serviceStatus,
                    style = MaterialTheme.typography.bodyLarge,
                    color = TeslaGray
                )
                Spacer(Modifier.height(20.dp))
            }

            // Big START / STOP button
            Button(
                onClick = {
                    if (isRunning) {
                        TransporterService.stop(context)
                    } else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
                            ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS)
                            != PackageManager.PERMISSION_GRANTED
                        ) {
                            notifLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                        } else {
                            requestVpnAndStart(context, vpnLauncher) { vpnPermissionGranted = true }
                        }
                    }
                },
                enabled = !isLoading,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(72.dp),
                shape = MaterialTheme.shapes.large,
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isRunning) TeslaRed else TeslaBlue,
                    disabledContainerColor = TeslaSurfaceVariant
                )
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(28.dp),
                        color = TeslaGray,
                        strokeWidth = 3.dp
                    )
                } else {
                    Text(
                        text = if (isRunning) "STOP" else "START",
                        style = MaterialTheme.typography.headlineMedium,
                        color = if (isRunning) TeslaWhite else TeslaDark
                    )
                }
            }

            Spacer(Modifier.height(24.dp))
        }
        } // close Box
    }
}

@Composable
private fun StatusCard(
    serviceActive: Boolean,
    serviceConnected: Boolean,
    serviceVideoActive: Boolean,
    hotspotState: HotspotState
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = TeslaSurface),
        shape = MaterialTheme.shapes.large
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            StatusRow("Service", serviceActive, if (serviceActive) "Running" else "Stopped")
            Spacer(Modifier.height(16.dp))
            StatusRow("Android Auto", serviceConnected, if (serviceConnected) "Connected" else "Waiting...")
            Spacer(Modifier.height(16.dp))
            StatusRow("Video", serviceVideoActive, if (serviceVideoActive) "Streaming" else "Off")
            Spacer(Modifier.height(16.dp))
            StatusRow(
                label = "Hotspot",
                isActive = hotspotState is HotspotState.Enabled || hotspotState is HotspotState.ClientConnected,
                detail = when (hotspotState) {
                    is HotspotState.ClientConnected -> "${hotspotState.clients.size} client(s)"
                    is HotspotState.Enabled -> "Active"
                    is HotspotState.Disabled -> "Off"
                    is HotspotState.Unknown -> "Off"
                }
            )
        }
    }
}

@Composable
private fun StatusRow(label: String, isActive: Boolean, detail: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(14.dp)
                .clip(CircleShape)
                .background(if (isActive) TeslaGreen else TeslaDimText)
        )
        Spacer(Modifier.width(16.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.width(100.dp)
        )
        Text(
            text = detail,
            style = MaterialTheme.typography.bodyLarge,
            color = if (isActive) TeslaGreen else TeslaGray
        )
    }
}

@Composable
private fun UrlCard(url: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = TeslaPrimaryContainer),
        shape = MaterialTheme.shapes.large
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Open in Tesla Browser",
                style = MaterialTheme.typography.bodyMedium,
                color = TeslaGray
            )
            Spacer(Modifier.height(12.dp))
            Text(
                text = AppConfig.PUBLIC_DOMAIN,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center,
                color = TeslaBlue
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "or: ${AppConfig.getServerUrlFallback()}",
                style = MaterialTheme.typography.labelSmall,
                color = TeslaDimText
            )
        }
    }
}

@Composable
private fun ErrorCard(error: AppState.Error) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = TeslaErrorContainer),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = "Something went wrong",
                style = MaterialTheme.typography.titleMedium,
                color = TeslaRed
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = error.message,
                style = MaterialTheme.typography.bodyMedium,
                color = TeslaWhite.copy(alpha = 0.7f)
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
        TransporterService.start(context)
    }
}
