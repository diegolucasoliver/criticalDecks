package com.lekrom.criticaldeck.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DefaultColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Secondary
)

private val FlawColorPalette = lightColors(
    primary = FlawPrimary,
    primaryVariant = FlawPrimaryVariant,
    secondary = FlawSecondary
)

private val SuccessColorPalette = lightColors(
    primary = SuccessPrimary,
    primaryVariant = SuccessPrimaryVariant,
    secondary = SuccessSecondary
)

@Composable
fun DefaultDeckTheme(content: @Composable () -> Unit) {
    val systemUiController = rememberSystemUiController()

    systemUiController.setStatusBarColor(color = Color.Black)
    systemUiController.setNavigationBarColor(color = Secondary)

    MaterialTheme(
        colors = DefaultColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

@Composable
fun CriticalDeckTheme(flawTheme: Boolean = false, content: @Composable () -> Unit) {
    val systemUiController = rememberSystemUiController()

    val colors = if (flawTheme) {
        systemUiController.setSystemBarsColor(color = FlawPrimaryVariant)
        systemUiController.setNavigationBarColor(color = FlawSecondary)
        FlawColorPalette
    } else {
        systemUiController.setSystemBarsColor(color = SuccessPrimaryVariant)
        systemUiController.setNavigationBarColor(color = SuccessSecondary)
        SuccessColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
