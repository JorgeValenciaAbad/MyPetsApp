package com.example.mypets.ui.theme

import android.app.Activity
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.example.mypets.R


private val LightColors = lightColorScheme(
    primary = primary,
    onPrimary = onPrimary,
    primaryContainer = light_primaryContainer,
    onPrimaryContainer = light_onPrimaryContainer,
    secondary = secondary,
    onSecondary = onSecondary,
    secondaryContainer = light_secondaryContainer,
    onSecondaryContainer = light_onSecondaryContainer,
    tertiary = tertiary,
    onTertiary = onTertiary,
    tertiaryContainer = light_tertiaryContainer,
    onTertiaryContainer = light_onTertiaryContainer,
    error = light_error,
    errorContainer = light_errorContainer,
    onError = light_onError,
    onErrorContainer = light_onErrorContainer,
    background = light_background,
    onBackground = light_onBackground,
    surface = surface,
    onSurface = light_onSurface,
    surfaceVariant = light_surfaceVariant,
    onSurfaceVariant = light_onSurfaceVariant,
    outline = light_outline,
    inverseOnSurface = light_inverseOnSurface,
    inverseSurface = light_inverseSurface,
    inversePrimary = light_inversePrimary,
    surfaceTint = light_surfaceTint,
    outlineVariant = light_outlineVariant,
    scrim = light_scrim,
)


private val DarkColors = darkColorScheme(
    primary = primary,
    onPrimary = onPrimary,
    primaryContainer = dark_primaryContainer,
    onPrimaryContainer = dark_onPrimaryContainer,
    secondary = secondary,
    onSecondary = onSecondary,
    secondaryContainer = dark_secondaryContainer,
    onSecondaryContainer = dark_onSecondaryContainer,
    tertiary = tertiary,
    onTertiary = onTertiary,
    tertiaryContainer = dark_tertiaryContainer,
    onTertiaryContainer = dark_onTertiaryContainer,
    error = light_error,
    errorContainer = light_errorContainer,
    onError = light_onError,
    onErrorContainer = light_onErrorContainer,
    background = dark_background,
    onBackground = dark_onBackground,
    surface = surface,
    onSurface = dark_onSurface,
    surfaceVariant = dark_surfaceVariant,
    onSurfaceVariant = dark_onSurfaceVariant,
    outline = dark_outline,
    inverseOnSurface = dark_inverseOnSurface,
    inverseSurface = dark_inverseSurface,
    inversePrimary = dark_inversePrimary,
    surfaceTint = dark_surfaceTint,
    outlineVariant = dark_outlineVariant,
    scrim = dark_scrim,
)

@Composable
fun MyPetsTheme(
    isLogin:Boolean,
  darkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit
) {
  val colors = if (!darkTheme) {
    LightColors
  } else {
    DarkColors
  }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            val insets = WindowCompat.getInsetsController(window, view)
            window.statusBarColor =  if(isLogin) Color.Transparent.toArgb() else primaryVariant.toArgb()
            window.navigationBarColor =if (isLogin) Color.Transparent.toArgb() else colors.background.toArgb()

            if (isLogin) {
                window.setBackgroundDrawableResource(R.drawable.background)
            } else {
                window.setBackgroundDrawable(ColorDrawable(colors.background.toArgb()))
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
                window.isNavigationBarContrastEnforced = false
            }
            insets.isAppearanceLightNavigationBars = !darkTheme
        }
    }
  MaterialTheme(
    colorScheme = colors,
    content = content
  )
}