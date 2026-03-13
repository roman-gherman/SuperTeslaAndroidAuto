package com.supertesla.aa.ui.theme

import android.app.Activity
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat

// Tesla-inspired color palette
val TeslaDark = Color(0xFF0A0A0A)
val TeslaSurface = Color(0xFF1A1A1A)
val TeslaSurfaceVariant = Color(0xFF242424)
val TeslaBlue = Color(0xFF4FC3F7)
val TeslaBlueDark = Color(0xFF0288D1)
val TeslaGreen = Color(0xFF66BB6A)
val TeslaRed = Color(0xFFEF5350)
val TeslaAmber = Color(0xFFFFCA28)
val TeslaWhite = Color(0xFFF5F5F5)
val TeslaGray = Color(0xFF9E9E9E)
val TeslaDimText = Color(0xFF757575)
val TeslaPrimaryContainer = Color(0xFF0D3247)
val TeslaErrorContainer = Color(0xFF3D1517)

private val TeslaDarkColorScheme = darkColorScheme(
    primary = TeslaBlue,
    onPrimary = Color.Black,
    primaryContainer = TeslaPrimaryContainer,
    onPrimaryContainer = TeslaBlue,
    secondary = Color(0xFF81D4FA),
    onSecondary = Color.Black,
    tertiary = Color(0xFFB3E5FC),
    background = TeslaDark,
    onBackground = TeslaWhite,
    surface = TeslaSurface,
    onSurface = TeslaWhite,
    surfaceVariant = TeslaSurfaceVariant,
    onSurfaceVariant = TeslaGray,
    error = TeslaRed,
    onError = Color.White,
    errorContainer = TeslaErrorContainer,
    onErrorContainer = TeslaRed,
    outline = Color(0xFF333333),
    outlineVariant = Color(0xFF2A2A2A),
)

private val TeslaTypography = Typography(
    displayLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp,
        lineHeight = 44.sp,
        letterSpacing = (-0.5).sp,
    ),
    displayMedium = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 40.sp,
    ),
    headlineLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = 36.sp,
    ),
    headlineMedium = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        lineHeight = 32.sp,
    ),
    titleLarge = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        lineHeight = 24.sp,
    ),
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 26.sp,
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
    ),
    labelLarge = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 22.sp,
    ),
    labelMedium = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
    ),
)

private val TeslaShapes = Shapes(
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(24.dp),
    extraLarge = RoundedCornerShape(32.dp),
)

@Composable
fun SuperTeslaAATheme(
    content: @Composable () -> Unit
) {
    val colorScheme = TeslaDarkColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = TeslaDark.toArgb()
            window.navigationBarColor = TeslaDark.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
            WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars = false
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = TeslaTypography,
        shapes = TeslaShapes,
        content = content
    )
}
