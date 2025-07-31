package com.gluon.gluonapp.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.gluon.gluonapp.navigation.AppNavGraph
import com.gluon.gluonapp.navigation.Screen
import com.gluon.gluonapp.ui.screens.chat_screen.chat.BottomNavComponents
import com.gluon.gluonapp.utils.NavigationUtils.getCurrentRoute

@Composable
fun App(
    modifier: Modifier = Modifier
) {

    //Status bar
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White,
            darkIcons = true
        )
    }

    val navController = rememberNavController()

    val bottomBarScreens = listOf(
        Screen.Chat.route,
        Screen.Albums.route,
        Screen.Files.route,
        Screen.Tools.route
    )

    // **Menu açık mı?**
    var isMenuOpen by remember { mutableStateOf(false) }

    Scaffold(
        bottomBar = {
            val currentRoute = getCurrentRoute(navController)
            val shouldShowBottomBar = currentRoute?.let { route ->
                bottomBarScreens.any { screen ->
                    route.startsWith(screen.split("/")[0])
                }
            } ?: false

            if (!isMenuOpen && shouldShowBottomBar) {
                BottomNavComponents(
                    navController = navController,
                )
            }
        }
    ) { innerPadding ->
        // **Menü açık/kapalı bilgisini AppNavGraph'e ilet**
        AppNavGraph(
            navController = navController,
            modifier = Modifier.padding(innerPadding),
            onMenuToggle = { isMenuOpen = it }, // **Burada menü durumunu güncelliyoruz**
        )
    }

}