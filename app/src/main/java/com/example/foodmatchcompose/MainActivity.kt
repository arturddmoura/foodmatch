package com.example.foodmatchcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.lightColors
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Orange200 = Color(0xFFFFA726)
private val Orange500 = Color(0xFFFF9800)
private val Orange700 = Color(0xFFE65100)

private val OrangeColorScheme = ColorScheme(
    primary = Orange500,
    onPrimary = Color.White,
    primaryContainer = Orange700,
    onPrimaryContainer = Color.White,
    inversePrimary = Color.Black,
    secondary = Orange200,
    onSecondary = Color.White,
    secondaryContainer = Orange200,
    onSecondaryContainer = Color.White,
    tertiary = Orange200,
    onTertiary = Color.White,
    tertiaryContainer = Orange200,
    onTertiaryContainer = Color.White,
    background = Color.White,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
    surfaceVariant = Color.White,
    onSurfaceVariant = Color.Black,
    surfaceTint = Color.White,
    inverseSurface = Color.Black,
    inverseOnSurface = Color.White,
    error = Color.Red,
    onError = Color.White,
    errorContainer = Color.Red,
    onErrorContainer = Color.White,
    outline = Color.Gray,
    outlineVariant = Color.Gray,
    scrim = Color(0x99000000)
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = getColor(R.color.black)
            MaterialTheme(colorScheme = OrangeColorScheme) {
                FoodMatchApp()
            }
        }
    }
}

@Composable
fun FoodMatchApp() {
    MainScreen()
}
