package com.swapi.app.presentation.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFFFE81F),
    onPrimary = Color.Black,
    primaryContainer = Color(0xFF1A1A2E),
    onPrimaryContainer = Color(0xFFFFE81F),  // yellow arrow + title on dark bar
    secondary = Color(0xFF4FC3F7),
    tertiary = Color(0xFF81C784)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF1A1A2E),
    onPrimary = Color.White,
    primaryContainer = Color(0xFF1A1A2E),
    onPrimaryContainer = Color(0xFFFFE81F),
    secondary = Color(0xFF0277BD),
    tertiary = Color(0xFF2E7D32)
)

@Composable
fun SwapiAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(),
        content = content
    )
}
