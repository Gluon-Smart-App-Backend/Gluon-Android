package com.gluon.gluonapp.navigation

sealed class Screen(val route: String) {

    data object Chat : Screen("Chat")
    data object Albums : Screen("Albums")
    data object Files : Screen("Files")
    data object Tools : Screen("Tools")
}