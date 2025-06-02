package com.uveys.trader.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


// Tüm temalarda dengeli ve okunabilir yeşil tonu
private val PrimaryGreen = Color(0xFF81C784) // Muted yeşil

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryGreen,
    secondary = Color(0xFF80DEEA),
    tertiary = Color(0xFF9575CD),
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E),
    error = Color(0xFFEF5350),
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onTertiary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    onError = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryGreen,
    secondary = Color(0xFF4DD0E1),
    tertiary = Color(0xFF7E57C2),
    background = Color(0xFFF9F9F9),
    surface = Color(0xFFFFFFFF),
    error = Color(0xFFD32F2F),
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onTertiary = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black,
    onError = Color.White
)



@Composable
fun UveysTraderTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
