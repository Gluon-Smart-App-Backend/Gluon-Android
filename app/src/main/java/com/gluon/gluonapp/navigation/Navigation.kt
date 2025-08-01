package com.gluon.gluonapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gluon.gluonapp.ui.screens.chat_screen.chat.ChatMainScreen
import com.gluon.gluonapp.ui.screens.tools_profile_screen.ToolsScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onMenuToggle: (Boolean) -> Unit,
) {
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = "chat",
        modifier = modifier
    ) {

        composable(Screen.Chat.route) {
            ChatMainScreen()
        }

//        composable(Screen.Albums.route) {
//            MainScreen()
//        }
//
//        composable(Screen.Files.route) {
//            MainScreen()
//        }

        composable(Screen.Tools.route) {
            ToolsScreen(
                navController = navController
            )
        }
    }
}