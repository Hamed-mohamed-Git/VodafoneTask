package com.vodafone.task.core.designSystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import org.jetbrains.annotations.VisibleForTesting


@VisibleForTesting
internal val VTLightColorScheme = lightColorScheme(
    // Primary Colors (Brand series)
    primary = Brand400,                 // Main brand color
    onPrimary = Color.White,            // Text/icon color on primary
    primaryContainer = Brand100,        // Light primary variant for containers
    onPrimaryContainer = Brand700,      // Darker contrast color on primary container

    // Secondary Colors (Secondary series)
    secondary = Secondary500,           // Main secondary color
    onSecondary = Color.White,          // Text/icon color on secondary
    secondaryContainer = Secondary200,  // Light secondary variant for containers
    onSecondaryContainer = Secondary600, // Darker contrast on secondary container

    // Tertiary Colors (using Success series as an example)
    tertiary = Success400,              // Positive/Success color as tertiary
    onTertiary = Color.White,           // Light color for contrast on tertiary
    tertiaryContainer = Success100,     // Lighter success variant
    onTertiaryContainer = Success700,   // Dark contrast on tertiary container

    // Background and Surface Colors (Gray series)
    background = Gray50,                // Background color
    onBackground = Gray800,             // Dark text color on background
    surface = Color.White,              // Main surface color
    onSurface = Gray300,                // Text/icon color on surface
    surfaceVariant = Gray100,           // Variant surface color for subtle elements
    onSurfaceVariant = Gray500,         // Contrast color for surface variant

    // Inverse Colors
    surfaceTint = Brand400,             // Tint for surfaces, usually matches primary
    inverseSurface = Gray800,           // Dark background for inverse elements
    inverseOnSurface = Gray25,          // Light text on inverse surface

    // Error Colors (Error series)
    error = Error500,                   // Error color
    onError = Color.White,              // Text/icon color on error
    errorContainer = Error100,          // Light error variant for containers
    onErrorContainer = Error700,        // Dark contrast for error container
)

@Composable
fun VodafoneTaskTheme(
    direction: LayoutDirection = LayoutDirection.Ltr,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(LocalLayoutDirection provides direction) {
        MaterialTheme(
            colorScheme = VTLightColorScheme,
            typography = VTTypography,
            content = content
        )
    }
}
