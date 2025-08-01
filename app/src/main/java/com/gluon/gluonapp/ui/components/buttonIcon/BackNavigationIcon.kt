package com.gluon.gluonapp.ui.components.buttonIcon


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gluon.gluonapp.R


@Composable
fun BackNavigationIcon(navController: NavController, modifier:Modifier=Modifier.padding(start = 23.dp)) {
    val imageVector: ImageVector = if(isSystemInDarkTheme()) ImageVector.vectorResource(R.drawable.ic_arrow_back_night) else ImageVector.vectorResource(
        R.drawable.ic_back_arrow_light)
    IconButton(modifier =modifier , onClick = {

        if (navController.previousBackStackEntry != null) {
            navController.popBackStack()
        }
    }) {
        Icon(
            imageVector = imageVector,
            contentDescription = "Back",
            tint = Color.Unspecified,
            modifier = Modifier.size(32.dp)
        )
    }
}