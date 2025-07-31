package com.gluon.gluonapp.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

@Composable
fun colors(lightColor: Color, darkColor: Color): Color = if (isSystemInDarkTheme()) darkColor else lightColor
@Composable
fun painterResources(
    lightRes: Int,
    darkRes: Int
): Painter {
    return painterResource(id = if (isSystemInDarkTheme()) darkRes else lightRes)
}