package com.supertesla.aa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import com.supertesla.aa.ui.MainScreen
import com.supertesla.aa.ui.MainViewModel
import com.supertesla.aa.ui.theme.SuperTeslaAATheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperTeslaAATheme {
                val viewModel: MainViewModel = hiltViewModel()
                MainScreen(viewModel = viewModel)
            }
        }
    }
}
