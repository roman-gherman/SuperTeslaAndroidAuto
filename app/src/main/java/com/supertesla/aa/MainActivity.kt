package com.supertesla.aa

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.supertesla.aa.receiver.TeslaBluetoothReceiver
import com.supertesla.aa.service.MainService
import com.supertesla.aa.ui.MainScreen
import com.supertesla.aa.ui.MainViewModel
import com.supertesla.aa.ui.settings.SettingsScreen
import com.supertesla.aa.ui.theme.SuperTeslaAATheme
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
                            teslaDetected && wizardCompleted -> "tesla_prompt"
                            wizardCompleted -> "main"
                            else -> "wizard"
                        }
                    )
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
                    "tesla_prompt" -> {
                        // Quick prompt when launched from Tesla BT notification
                        AlertDialog(
                            onDismissRequest = { screen = "main" },
                            title = { Text("Tesla Detected") },
                            text = {
                                Text("Turn on your WiFi hotspot, then tap Start.\n\nYour Tesla will connect to it automatically.")
                            },
                            confirmButton = {
                                Button(onClick = {
                                    screen = "main"
                                    MainService.start(this@MainActivity)
                                }) { Text("Start") }
                            },
                            dismissButton = {
                                Row {
                                    TextButton(onClick = {
                                        startActivity(Intent(Settings.ACTION_WIRELESS_SETTINGS))
                                    }) { Text("Hotspot Settings") }
                                    Spacer(Modifier.width(8.dp))
                                    TextButton(onClick = {
                                        screen = "main"
                                    }) { Text("Later") }
                                }
                            }
                        )
                    }
                    else -> {
                        val viewModel: MainViewModel = hiltViewModel()
                        MainScreen(
                            viewModel = viewModel,
                            onSettings = { screen = "settings" }
                        )
                    }
                }
            }
        }
    }
}
