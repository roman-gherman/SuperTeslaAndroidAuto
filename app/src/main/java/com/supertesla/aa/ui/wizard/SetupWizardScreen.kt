@file:OptIn(androidx.compose.foundation.ExperimentalFoundationApi::class)

package com.supertesla.aa.ui.wizard

import android.content.ComponentName
import android.content.Intent
import android.net.VpnService
import android.provider.Settings
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import com.supertesla.aa.core.config.AppConfig
import com.supertesla.aa.core.model.HotspotState
import com.supertesla.aa.network.hotspot.HotspotManager
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

private const val PAGE_COUNT = 3

@Composable
fun SetupWizardScreen(onComplete: () -> Unit) {
    val pagerState = rememberPagerState(pageCount = { PAGE_COUNT })
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    val hotspotManager = remember { HotspotManager(context) }
    var hotspotOn by remember { mutableStateOf(false) }

    // Try to start AA head unit server silently on launch
    LaunchedEffect(Unit) {
        tryStartHeadUnitServer(context)
    }

    // Observe hotspot state
    LaunchedEffect(Unit) {
        hotspotManager.observeHotspotState().collectLatest { state ->
            val wasOff = !hotspotOn
            hotspotOn = state is HotspotState.Enabled || state is HotspotState.ClientConnected
            // Auto-advance from hotspot page when it turns on
            if (hotspotOn && wasOff && pagerState.currentPage == 1) {
                pagerState.animateScrollToPage(2)
            }
        }
    }

    // VPN permission handling - requested inline when user taps Start
    var vpnGranted by remember { mutableStateOf(VpnService.prepare(context) == null) }
    val vpnLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { vpnGranted = true }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            // Page indicators
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 48.dp, bottom = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(PAGE_COUNT) { index ->
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .size(if (index == pagerState.currentPage) 10.dp else 8.dp)
                            .clip(CircleShape)
                            .background(
                                if (index <= pagerState.currentPage)
                                    MaterialTheme.colorScheme.primary
                                else
                                    MaterialTheme.colorScheme.onBackground.copy(alpha = 0.3f)
                            )
                    )
                }
            }

            HorizontalPager(
                state = pagerState,
                modifier = Modifier.weight(1f),
                userScrollEnabled = false
            ) { page ->
                when (page) {
                    0 -> WelcomePage()
                    1 -> HotspotPage(context, hotspotOn)
                    2 -> ConnectTeslaPage()
                }
            }

            // Navigation
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (pagerState.currentPage > 0) {
                    OutlinedButton(onClick = {
                        scope.launch { pagerState.animateScrollToPage(pagerState.currentPage - 1) }
                    }) { Text("Back") }
                } else {
                    Spacer(Modifier.width(1.dp))
                }

                val isLastPage = pagerState.currentPage == PAGE_COUNT - 1
                Button(
                    onClick = {
                        if (isLastPage) {
                            // Request VPN permission if not yet granted, then complete
                            if (!vpnGranted) {
                                val prepareIntent = VpnService.prepare(context)
                                if (prepareIntent != null) {
                                    vpnLauncher.launch(prepareIntent)
                                } else {
                                    vpnGranted = true
                                    onComplete()
                                }
                            } else {
                                onComplete()
                            }
                        } else {
                            scope.launch { pagerState.animateScrollToPage(pagerState.currentPage + 1) }
                        }
                    }
                ) {
                    Text(if (isLastPage) "Start" else "Next")
                }
            }
        }
    }
}

@Composable
private fun WelcomePage() {
    WizardPage(
        title = "SuperTesla",
        subtitle = "Android Auto for Tesla",
        description = "Use your favourite Android Auto apps\n" +
                "right on your Tesla's screen.\n\n" +
                "Google Maps, Spotify, WhatsApp\n" +
                "and more - no extra hardware needed."
    )
}

@Composable
private fun HotspotPage(context: android.content.Context, hotspotOn: Boolean) {
    WizardPage(
        title = if (hotspotOn) "Hotspot Is On" else "Turn On Hotspot",
        subtitle = "Your Tesla connects through it",
        description = if (hotspotOn)
            "Hotspot is active.\nNow connect your Tesla's WiFi to it."
        else
            "Enable your phone's WiFi hotspot,\nthen connect your Tesla's WiFi to it."
    ) {
        Spacer(Modifier.height(24.dp))
        if (hotspotOn) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF4CAF50))
                )
                Spacer(Modifier.width(8.dp))
                Text("Hotspot active", color = Color(0xFF4CAF50), fontWeight = FontWeight.Medium)
            }
        } else {
            OutlinedButton(onClick = {
                context.startActivity(Intent(Settings.ACTION_WIRELESS_SETTINGS).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                })
            }) { Text("Open WiFi Settings") }
        }
    }
}

@Composable
private fun ConnectTeslaPage() {
    val url = AppConfig.getServerUrl()
    val fallback = AppConfig.getServerUrlFallback()

    WizardPage(
        title = "Open in Tesla",
        subtitle = "One last step",
        description = "On your Tesla's browser, go to:"
    ) {
        Spacer(Modifier.height(20.dp))
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Text(
                text = url,
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
        Spacer(Modifier.height(12.dp))
        Text(
            text = "or: $fallback",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.4f)
        )
        Spacer(Modifier.height(24.dp))
        Text(
            text = "Tap Start below when ready.\nAndroid Auto will appear on your Tesla.",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            lineHeight = 20.sp,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
        )
    }
}

@Composable
private fun WizardPage(
    title: String,
    subtitle: String,
    description: String,
    extra: @Composable ColumnScope.() -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(title, fontSize = 28.sp, fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary)
        Spacer(Modifier.height(4.dp))
        Text(subtitle, fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f))
        Spacer(Modifier.height(24.dp))
        Text(description, fontSize = 15.sp, textAlign = TextAlign.Center,
            lineHeight = 22.sp,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f))
        extra()
    }
}

/**
 * Try to start the Android Auto head unit server programmatically.
 * This eliminates the need for users to enable developer settings manually.
 */
private fun tryStartHeadUnitServer(context: android.content.Context) {
    try {
        val intent = Intent().apply {
            component = ComponentName(
                "com.google.android.projection.gearhead",
                "com.google.android.projection.gearhead.companion.DeveloperHeadUnitNetworkService"
            )
        }
        context.startService(intent)
    } catch (_: Exception) {
        // Silently fail - service may not be available or permission denied.
        // The AA emulator will handle connection failure gracefully.
    }
}
