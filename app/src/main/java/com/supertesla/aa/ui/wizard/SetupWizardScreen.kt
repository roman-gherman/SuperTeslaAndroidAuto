@file:OptIn(androidx.compose.foundation.ExperimentalFoundationApi::class)

package com.supertesla.aa.ui.wizard

import android.content.ComponentName
import android.content.Intent
import android.net.VpnService
import android.provider.Settings
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
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
import com.supertesla.aa.core.config.AppConfig
import com.supertesla.aa.core.model.HotspotState
import com.supertesla.aa.network.hotspot.HotspotManager
import com.supertesla.aa.ui.theme.*
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
    var hotspotAutoAdvanced by remember { mutableStateOf(false) }

    val btPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { }

    LaunchedEffect(Unit) {
        tryStartHeadUnitServer(context)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
            btPermissionLauncher.launch(android.Manifest.permission.BLUETOOTH_CONNECT)
        }
    }

    LaunchedEffect(Unit) {
        hotspotManager.observeHotspotState().collectLatest { state ->
            hotspotOn = state is HotspotState.Enabled || state is HotspotState.ClientConnected
        }
    }

    val currentPage = pagerState.currentPage
    LaunchedEffect(hotspotOn, currentPage) {
        if (hotspotOn && !hotspotAutoAdvanced && currentPage == 1) {
            hotspotAutoAdvanced = true
            kotlinx.coroutines.delay(800)
            pagerState.scrollToPage(2)
        }
    }

    var vpnGranted by remember { mutableStateOf(VpnService.prepare(context) == null) }
    val vpnLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { vpnGranted = true }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = TeslaDark
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            // Page dots
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 56.dp, bottom = 24.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(PAGE_COUNT) { index ->
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                            .size(if (index == pagerState.currentPage) 12.dp else 10.dp)
                            .clip(CircleShape)
                            .background(
                                if (index <= pagerState.currentPage) TeslaBlue
                                else TeslaDimText
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
                    .padding(horizontal = 28.dp, vertical = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (pagerState.currentPage > 0) {
                    OutlinedButton(
                        onClick = { scope.launch { pagerState.animateScrollToPage(pagerState.currentPage - 1) } },
                        modifier = Modifier.height(56.dp),
                        shape = MaterialTheme.shapes.medium,
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = TeslaGray)
                    ) {
                        Text("Back", style = MaterialTheme.typography.bodyLarge)
                    }
                } else {
                    Spacer(Modifier.width(1.dp))
                }

                val isLastPage = pagerState.currentPage == PAGE_COUNT - 1
                Button(
                    onClick = {
                        if (isLastPage) {
                            if (!vpnGranted) {
                                val prepareIntent = VpnService.prepare(context)
                                if (prepareIntent != null) vpnLauncher.launch(prepareIntent)
                                else { vpnGranted = true; onComplete() }
                            } else {
                                onComplete()
                            }
                        } else {
                            scope.launch { pagerState.animateScrollToPage(pagerState.currentPage + 1) }
                        }
                    },
                    modifier = Modifier.height(56.dp).widthIn(min = 140.dp),
                    shape = MaterialTheme.shapes.medium,
                    colors = ButtonDefaults.buttonColors(containerColor = TeslaBlue)
                ) {
                    Text(
                        if (isLastPage) "Start" else "Next",
                        style = MaterialTheme.typography.titleMedium,
                        color = TeslaDark
                    )
                }
            }
        }
    }
}

@Composable
private fun WelcomePage() {
    WizardPage(
        title = "SuperTesla",
        subtitle = "Android Auto for Tesla"
    ) {
        Spacer(Modifier.height(12.dp))
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "SuperTesla logo",
            modifier = Modifier.size(140.dp)
        )
        Spacer(Modifier.height(20.dp))
        Text(
            text = "Use your favourite apps\nright on your Tesla's screen.",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = TeslaWhite.copy(alpha = 0.8f),
            lineHeight = 28.sp
        )
        Spacer(Modifier.height(24.dp))
        Text(
            text = "Google Maps  ·  Spotify  ·  WhatsApp\nand more",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = TeslaGray,
            lineHeight = 26.sp
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = "No extra hardware needed.",
            style = MaterialTheme.typography.bodyMedium,
            color = TeslaBlue
        )
    }
}

@Composable
private fun HotspotPage(context: android.content.Context, hotspotOn: Boolean) {
    WizardPage(
        title = if (hotspotOn) "Hotspot Is On" else "Turn On Hotspot",
        subtitle = "Your Tesla connects through it"
    ) {
        Spacer(Modifier.height(28.dp))
        Text(
            text = if (hotspotOn)
                "Hotspot is active.\nNow connect your Tesla's WiFi to it."
            else
                "Enable your phone's WiFi hotspot,\nthen connect your Tesla's WiFi to it.",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = TeslaWhite.copy(alpha = 0.8f),
            lineHeight = 28.sp
        )
        Spacer(Modifier.height(32.dp))
        if (hotspotOn) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(16.dp)
                        .clip(CircleShape)
                        .background(TeslaGreen)
                )
                Spacer(Modifier.width(12.dp))
                Text(
                    "Hotspot active",
                    style = MaterialTheme.typography.titleMedium,
                    color = TeslaGreen
                )
            }
        } else {
            OutlinedButton(
                onClick = {
                    context.startActivity(Intent(Settings.ACTION_WIRELESS_SETTINGS).apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    })
                },
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(56.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Text("Open WiFi Settings", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}

@Composable
private fun ConnectTeslaPage() {
    val url = AppConfig.getServerUrl()
    val fallback = AppConfig.getServerUrlFallback()

    WizardPage(
        title = "Open in Tesla",
        subtitle = "One last step"
    ) {
        Spacer(Modifier.height(24.dp))
        Text(
            text = "On your Tesla's browser, go to:",
            style = MaterialTheme.typography.bodyLarge,
            color = TeslaWhite.copy(alpha = 0.8f)
        )
        Spacer(Modifier.height(20.dp))
        Card(
            colors = CardDefaults.cardColors(containerColor = TeslaPrimaryContainer),
            shape = MaterialTheme.shapes.large
        ) {
            Text(
                text = url,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 28.dp, vertical = 20.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center,
                color = TeslaBlue
            )
        }
        Spacer(Modifier.height(12.dp))
        Text(
            text = "or: $fallback",
            style = MaterialTheme.typography.labelMedium,
            color = TeslaDimText
        )
        Spacer(Modifier.height(28.dp))
        Text(
            text = "Tap Start when ready.",
            style = MaterialTheme.typography.bodyLarge,
            color = TeslaGray
        )
    }
}

@Composable
private fun WizardPage(
    title: String,
    subtitle: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.displayMedium,
            color = TeslaBlue,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = subtitle,
            style = MaterialTheme.typography.titleMedium,
            color = TeslaGray,
            textAlign = TextAlign.Center
        )
        content()
    }
}

private fun tryStartHeadUnitServer(context: android.content.Context) {
    try {
        val intent = Intent().apply {
            component = ComponentName(
                "com.google.android.projection.gearhead",
                "com.google.android.projection.gearhead.companion.DeveloperHeadUnitNetworkService"
            )
        }
        context.startService(intent)
    } catch (_: Exception) {}
}
