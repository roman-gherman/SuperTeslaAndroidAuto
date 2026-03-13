package com.supertesla.aa

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
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

        setContent {
            SuperTeslaAATheme {
                var screen by remember {
                    mutableStateOf(if (wizardCompleted) "main" else "wizard")
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
