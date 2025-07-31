package com.gluon.gluonapp.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gluon.gluonapp.R
import com.gluon.gluonapp.ui.theme.BlackColor
import com.gluon.gluonapp.ui.theme.WhiteColor
import com.gluon.gluonapp.ui.theme.colors
import com.gluon.gluonapp.utils.extensions.backgroundColors


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(
    navController: NavController,
    isBackPress:Boolean=false,
    modifier: Modifier = Modifier,
    bottomBar: @Composable (() -> Unit)? = null,
    content: @Composable () -> Unit,

) {
    val imageVector:ImageVector = if(isSystemInDarkTheme()) ImageVector.vectorResource(R.drawable.ic_arrow_back_night) else ImageVector.vectorResource(
        R.drawable.ic_back_arrow_light)
    Scaffold(
        modifier = modifier
            .backgroundColors(WhiteColor, BlackColor)
            .fillMaxSize(),
        topBar = { if (isBackPress){
             TopAppBar(

                navigationIcon = {
                    IconButton(onClick = {

                        if (navController.previousBackStackEntry != null) {
                            navController.popBackStack()
                        }
                    }) {
                        Icon(
                            imageVector = imageVector,
                            contentDescription = "Back",
                            tint = Color.Unspecified,
                            modifier = Modifier.size(48.dp)
                        )
                    }

                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor =colors(WhiteColor, BlackColor),
                    titleContentColor = Color.Black
                ),
                title = { }
            )
        } },
        bottomBar = {
            bottomBar?.invoke()
        },
        content = {
            Column(Modifier.padding(it).backgroundColors(WhiteColor, BlackColor)){
                content()
            }
        }
    )
}