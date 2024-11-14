package com.csis4175.bookcycles.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(

    /* Original
        primary = Purple80,
        secondary = PurpleGrey80,
        tertiary = Pink80
    */


    primary = Color(0xff000000),

    onPrimary = Color(0xffffffff),

    primaryContainer = Color(0xff000000),

    onPrimaryContainer = Color(0xffffffff),

)

private val LightColorScheme = lightColorScheme(

    /* Original
        primary = Purple40,
        secondary = PurpleGrey40,
        tertiary = Pink40,
    */

    /* Other default colors to override
        background = Color(0xFFFFFBFE),
        surface = Color(0xFFFFFBFE),
        onPrimary = Color.White,
        onSecondary = Color.White,
        onTertiary = Color.White,
        onBackground = Color(0xFF1C1B1F),
        onSurface = Color(0xFF1C1B1F),
    */

    primary = Color(0xff161219),

    onPrimary = Color(0xffffffff),

    primaryContainer = Color(0xff2b282e),

    onPrimaryContainer = Color(0xffffffff),

    background = Color(0xFFFFFBFE),
)

@Composable
fun BookCyclesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
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

//    val view = LocalView.current
//    val window = (view.context as Activity).window
//    window.statusBarColor = colorScheme.primary.toArgb()



    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}