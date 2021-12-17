package com.nnshende.card_database.ui.theme

import Black1
import Blue300
import Blue400
import Blue600
import Blue700
import Grey1
import RedErrorDark
import RedErrorLight
import Teal300
import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Blue300,
    primaryVariant = Blue700,
    onPrimary = Color.White,
    secondary = Color.Black,
    secondaryVariant = Teal300,
    onSecondary = Color.White,
    error = RedErrorLight,
    onError = RedErrorDark,
    background = Color.Black,
    onBackground = Color.White,
    surface = Black1,
    onSurface = Color.White,
)

@SuppressLint("ConflictingOnColor")
private val LightColorPalette = lightColors(
    primary = Blue600,
    primaryVariant = Blue400,
    onPrimary = Black1,
    secondary = Color.White,
    secondaryVariant = Teal300,
    onSecondary = Color.Black,
    error = RedErrorDark,
    onError = RedErrorLight,
    background = Grey1,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Black1,
)

@Composable
fun YugiohCardsAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if(darkTheme){
        DarkColorPalette
    } else{
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = QuickSandTypography,
        shapes = AppShapes,
        content = content
    )
}