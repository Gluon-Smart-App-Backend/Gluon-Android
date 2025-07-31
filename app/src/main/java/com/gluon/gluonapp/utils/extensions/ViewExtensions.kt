package com.gluon.gluonapp.utils.extensions

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.material3.Text
import org.w3c.dom.Text

@Composable
fun Modifier.backgroundColors(lightColor:Color, darkColor:Color): Modifier = this.background(if (isSystemInDarkTheme()) darkColor else lightColor)

