package com.gluon.gluonapp.ui.components

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import coil.ImageLoader
import coil.decode.SvgDecoder

@Composable
fun BottomNavigation(
    navController: NavHostController,
) {
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components { add(SvgDecoder.Factory()) }
        .build()

    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    val context = LocalContext.current

    val view = LocalView.current
    val window = (view.context as Activity).window

}