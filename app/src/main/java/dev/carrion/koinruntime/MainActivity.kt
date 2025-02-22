package dev.carrion.koinruntime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dev.carrion.koinruntime.presentation.home.HomeScreen
import dev.carrion.koinruntime.presentation.ui.theme.KoinRuntimeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KoinRuntimeTheme {
                HomeScreen()
            }
        }
    }
}
