package com.quiettube.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val QuietColorScheme = darkColorScheme(
    background = QuietBackground,
    surface = QuietSurface,
    primary = QuietAccent,
    secondary = QuietAccentDim,
    onBackground = QuietOnSurface,
    onSurface = QuietOnSurface,
)

@Composable
fun QuietTubeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = QuietColorScheme,
        typography = Typography,
        content = content,
    )
}
