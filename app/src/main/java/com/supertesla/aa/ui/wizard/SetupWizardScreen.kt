@file:OptIn(androidx.compose.foundation.ExperimentalFoundationApi::class)

package com.supertesla.aa.ui.wizard

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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import kotlinx.coroutines.launch

@Composable
fun SetupWizardScreen(
    onComplete: () -> Unit
) {
    val pagerState = rememberPagerState(pageCount = { 5 })
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

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
                repeat(5) { index ->
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
                    1 -> AndroidAutoPage()
                    2 -> HotspotPage(context)
                    3 -> VpnPage(vpnGranted) {
                        val prepareIntent = VpnService.prepare(context)
                        if (prepareIntent != null) vpnLauncher.launch(prepareIntent)
                        else vpnGranted = true
                    }
                    4 -> ReadyPage(onComplete)
                }
            }

            // Navigation buttons
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

                val isLastPage = pagerState.currentPage == 4
                Button(
                    onClick = {
                        if (isLastPage) onComplete()
                        else scope.launch { pagerState.animateScrollToPage(pagerState.currentPage + 1) }
                    },
                    enabled = when (pagerState.currentPage) {
                        3 -> vpnGranted
                        else -> true
                    }
                ) { Text(if (isLastPage) "Done" else "Next") }
            }
        }
    }
}

@Composable
private fun WelcomePage() {
    WizardPage(
        title = "SuperTesla",
        subtitle = "Android Auto for Tesla",
        description = "Stream Android Auto to your Tesla's browser.\nNo hardware required."
    )
}

@Composable
private fun AndroidAutoPage() {
    WizardPage(
        title = "Enable Head Unit Server",
        subtitle = "Android Auto Developer Settings",
        description = "1. Open Android Auto app\n" +
                "2. Settings > tap Version 10 times\n" +
                "3. Enable Developer Settings\n" +
                "4. Turn on \"Start head unit server\""
    )
}

@Composable
private fun HotspotPage(context: android.content.Context) {
    WizardPage(
        title = "Enable Hotspot",
        subtitle = "WiFi Tethering",
        description = "Enable your phone's WiFi hotspot.\nTesla will connect to it."
    ) {
        Spacer(Modifier.height(16.dp))
        OutlinedButton(onClick = {
            context.startActivity(Intent(Settings.ACTION_WIRELESS_SETTINGS).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            })
        }) { Text("Open WiFi Settings") }
    }
}

@Composable
private fun VpnPage(granted: Boolean, onRequest: () -> Unit) {
    WizardPage(
        title = "VPN Permission",
        subtitle = "Local Network Only",
        description = "SuperTesla needs VPN permission to assign a virtual IP address.\n" +
                "No traffic is intercepted or monitored."
    ) {
        Spacer(Modifier.height(16.dp))
        if (granted) {
            Text(
                "Permission granted",
                color = Color(0xFF4CAF50),
                fontWeight = FontWeight.Medium
            )
        } else {
            Button(onClick = onRequest) { Text("Grant Permission") }
        }
    }
}

@Composable
private fun ReadyPage(onComplete: () -> Unit) {
    val url = AppConfig.getServerUrl()
    val fallback = AppConfig.getServerUrlFallback()
    WizardPage(
        title = "Connect Tesla",
        subtitle = "Almost there!",
        description = "On your Tesla:\n" +
                "1. Connect WiFi to your phone's hotspot\n" +
                "2. Open the browser\n" +
                "3. Navigate to:"
    ) {
        Spacer(Modifier.height(16.dp))
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Text(
                text = url,
                modifier = Modifier.padding(16.dp),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
        Spacer(Modifier.height(8.dp))
        Text(
            text = "If that doesn't work, try: $fallback",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f),
            textAlign = TextAlign.Center
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
