package com.gluon.gluonapp.ui.components.tabs

import androidx.compose.runtime.Composable

data class TabItem(
    val title: String,
    val screen: @Composable () -> Unit
)