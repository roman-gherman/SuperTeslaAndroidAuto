package com.supertesla.aa

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.res.painterResource
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.supertesla.aa.receiver.TeslaBluetoothReceiver
import com.supertesla.aa.service.TransporterService
import com.supertesla.aa.ui.MainScreen
import com.supertesla.aa.ui.MainViewModel
import com.supertesla.aa.ui.PermissionsScreen
import com.supertesla.aa.ui.settings.SettingsScreen
import com.supertesla.aa.ui.theme.*
import com.supertesla.aa.ui.wizard.SetupWizardScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val prefs = getSharedPreferences("settings", Context.MODE_PRIVATE)
        val wizardCompleted = prefs.getBoolean("wizard_completed", false)
        val teslaDetected = intent?.getBooleanExtra(TeslaBluetoothReceiver.EXTRA_TESLA_DETECTED, false) ?: false
        val autoStart = intent?.getBooleanExtra(TeslaBluetoothReceiver.EXTRA_AUTO_START, false) ?: false

        setContent {
            SuperTeslaAATheme {
                var screen by remember {
                    mutableStateOf(
                        when {
                            autoStart && wizardCompleted -> "main"
                            teslaDetected && wizardCompleted -> "tesla_prompt"
                            wizardCompleted -> "main"
                            else -> "wizard"
                        }
                    )
                }

                // Auto-start the service when launched from BT notification "Start" action
                LaunchedEffect(autoStart) {
                    if (autoStart && wizardCompleted) {
                        TransporterService.start(this@MainActivity)
                    }
                }

                when (screen) {
                    "wizard" -> SetupWizardScreen(
                        onComplete = {
                            prefs.edit().putBoolean("wizard_completed", true).apply()
                            screen = "main"
                        }
                    )
                    "settings" -> SettingsScreen(
                        onBack = { screen = "main" }
                    )
                    "permissions" -> PermissionsScreen(
                        onBack = { screen = "main" },
                        onAllGranted = { /* stay on screen */ }
                    )
                    "tesla_prompt" -> {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = TeslaDark
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(32.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.logo),
                                    contentDescription = "SuperTesla logo",
                                    modifier = Modifier.size(120.dp)
                                )
                                Spacer(Modifier.height(20.dp))
                                Text(
                                    text = "Tesla Detected",
                                    style = MaterialTheme.typography.displayMedium,
                                    color = TeslaBlue
                                )
                                Spacer(Modifier.height(12.dp))
                                Text(
                                    text = "Your Tesla is connected via Bluetooth",
                                    style = MaterialTheme.typography.titleMedium,
                                    color = TeslaGray
                                )
                                Spacer(Modifier.height(40.dp))
                                Text(
                                    text = "Turn on your WiFi hotspot,\nthen tap Start.",
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = TeslaWhite.copy(alpha = 0.8f),
                                    textAlign = TextAlign.Center
                                )

                                Spacer(Modifier.height(48.dp))

                                // Start button
                                Button(
                                    onClick = {
                                        screen = "main"
                                        TransporterService.start(this@MainActivity)
                                    },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(72.dp),
                                    shape = MaterialTheme.shapes.large,
                                    colors = ButtonDefaults.buttonColors(containerColor = TeslaBlue)
                                ) {
                                    Text(
                                        "Start",
                                        style = MaterialTheme.typography.headlineMedium,
                                        color = TeslaDark
                                    )
                                }

                                Spacer(Modifier.height(16.dp))

                                // Hotspot settings
                                OutlinedButton(
                                    onClick = {
                                        startActivity(Intent(Settings.ACTION_WIRELESS_SETTINGS))
                                    },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(56.dp),
                                    shape = MaterialTheme.shapes.medium,
                                    colors = ButtonDefaults.outlinedButtonColors(contentColor = TeslaGray)
                                ) {
                                    Text(
                                        "Hotspot Settings",
                                        style = MaterialTheme.typography.bodyLarge
                                    )
                                }

                                Spacer(Modifier.height(12.dp))

                                TextButton(
                                    onClick = { screen = "main" },
                                    modifier = Modifier.height(48.dp)
                                ) {
                                    Text(
                                        "Later",
                                        style = MaterialTheme.typography.bodyLarge,
                                        color = TeslaDimText
                                    )
                                }
                            }
                        }
                    }
                    else -> {
                        val viewModel: MainViewModel = hiltViewModel()
                        MainScreen(
                            viewModel = viewModel,
                            onSettings = { screen = "settings" },
                            onPermissions = { screen = "permissions" }
                        )
                    }
                }
            }
        }
    }
}
