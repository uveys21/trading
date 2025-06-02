package com.uveys.trader.presentation.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.uveys.trader.presentation.ui.main.home.HomeScreen
import com.uveys.trader.presentation.ui.main.portfolio.PortfolioScreen
import com.uveys.trader.presentation.ui.main.settings.SettingsScreen
import com.uveys.trader.presentation.ui.main.trading.TradingScreen
import com.uveys.trader.presentation.viewmodel.MainViewModel

/**
 * Ana ekran - Bottom Navigation ile 4 farklı ekran arasında geçiş sağlar
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    onNavigateToAuth: () -> Unit,
    viewModel: MainViewModel = hiltViewModel()
) {
    val navController = rememberNavController()
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Uveys Trader") },
                actions = {
                    Text(
                        text = "Bakiye: ${uiState.balance} USDT",
                        modifier = Modifier.padding(end = 16.dp)
                    )
                }
            )
        },
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                bottomNavItems.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.icon, contentDescription = screen.label) },
                        label = { Text(screen.label) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    uiState = uiState,
                    onStartStrategy = { symbol -> viewModel.startStrategy(symbol) },
                    onStopStrategy = { viewModel.stopStrategy() }
                )
            }
            composable(Screen.Trading.route) {
                TradingScreen(
                    uiState = uiState,
                    onPlaceOrder = { symbol, side, positionSide, price, quantity ->
                        viewModel.placeOrder(
                            symbol = symbol,
                            side = side,
                            positionSide = positionSide,
                            price = price,
                            quantity = quantity
                        )
                    }
                )
            }
            composable(Screen.Portfolio.route) {
                PortfolioScreen(
                    positions = uiState.positions,
                    orderHistory = uiState.orderHistory
                )
            }
            composable(Screen.Settings.route) {
                SettingsScreen(
                    onLogout = {
                        viewModel.logout()
                        onNavigateToAuth()
                    },
                    onSetLeverage = { leverage -> viewModel.setLeverage(leverage) },
                    onSetRiskPercentage = { percentage -> viewModel.setRiskPercentage(percentage) },
                    currentLeverage = uiState.leverage,
                    currentRiskPercentage = uiState.riskPercentage
                )
            }
        }
    }
}

/**
 * Bottom Navigation için ekran tanımları
 */
sealed class Screen(val route: String, val label: String, val icon: ImageVector) {
    object Home : Screen("home", "Ana Sayfa", Icons.Default.Home)
    object Trading : Screen("trading", "İşlem", Icons.Default.Analytics)
    object Portfolio : Screen("portfolio", "Portföy", Icons.Default.AccountBalance)
    object Settings : Screen("settings", "Ayarlar", Icons.Default.Settings)
}

private val bottomNavItems = listOf(
    Screen.Home,
    Screen.Trading,
    Screen.Portfolio,
    Screen.Settings
)