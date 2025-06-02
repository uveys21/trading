package com.uveys.trader.presentation.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uveys.trader.presentation.ui.auth.AuthScreen
import com.uveys.trader.presentation.ui.theme.UveysTraderTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UveysTraderTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UveysTraderApp()
                }
            }
        }
    }
}

@Composable
fun UveysTraderApp() {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "auth") {
        composable("auth") {
            AuthScreen(
                onNavigateToMain = { navController.navigate("main") },
                onNavigateToDemo = { navController.navigate("main") }
            )
        }
        composable("main") {
            MainScreen(
                onNavigateToAuth = {
                    navController.navigate("auth") {
                        popUpTo("main") { inclusive = true }
                    }
                }
            )
        }
    }
}
