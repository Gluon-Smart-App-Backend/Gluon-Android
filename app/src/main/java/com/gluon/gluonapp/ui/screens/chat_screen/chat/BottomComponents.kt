package com.gluon.gluonapp.ui.screens.chat_screen.chat

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.gluon.gluonapp.R

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun BottomNavComponents(
    navController: NavHostController,
) {

    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val isSmallScreen = screenWidth < 400.dp

    val navbarHeight = if (isSmallScreen) 70.dp else 84.dp
    val horizontalPadding = when {
        isSmallScreen -> 16.dp
        screenWidth < 768.dp -> 20.dp
        else -> 24.dp
    }

    val addButtonSize = if (isSmallScreen) 36.dp else 42.dp
    val iconSize = 24.dp

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(navbarHeight)
            .shadow(
                elevation = 2.dp,
                spotColor = Color
                    .Black
                    .copy(alpha = 0.1f),
                ambientColor = Color
                    .Black
                    .copy(alpha = 0.05f)
            )
            .background(Color.White)
            .padding(horizontal = horizontalPadding)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Chat Item
            NavItem(
                iconRes = R.drawable.chat_icon,
                label = "Chat",
                isSelected = currentRoute?.startsWith("Chat") == true,
                onClick = { },
                isSmallScreen = isSmallScreen
            )

            // Albums Item
            NavItem(
                iconRes = R.drawable.album_icon,
                label = "Albums",
                isSelected = currentRoute?.startsWith("Albums") == true,
                onClick = { },
                isSmallScreen = isSmallScreen
            )

            // Add Button (Center)
            Box(
                modifier = Modifier
                    .size(addButtonSize)
                    .clickable { },
                contentAlignment = Alignment.Center
            ) {

                // Blue circle background
                Box(
                    modifier = Modifier
                        .size(addButtonSize)
                        .clip(CircleShape)
                        .background(Color(0xFF1A73E8))
                        .zIndex(1f)
                )

                // Plus icon
                Icon(
                    imageVector = ImageVector
                        .vectorResource(R.drawable.add_icon),
                    contentDescription = "Add",
                    tint = Color.White,
                    modifier = Modifier
                        .size(iconSize)
                        .zIndex(2f)
                )
            }

            // Files Item
            NavItem(
                iconRes = R.drawable.update_icon,
                label = "Files",
                isSelected = currentRoute?.startsWith("Files") == true,
                onClick = { },
                isSmallScreen = isSmallScreen
            )

            // Tools Item
            NavItem(
                iconRes = R.drawable.tools_icon,
                label = "Tools",
                isSelected = currentRoute?.startsWith("Tools") == true,
                onClick = { },
                isSmallScreen = isSmallScreen
            )
        }
    }
}

@Composable
private fun NavItem(
    iconRes: Int,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    isSmallScreen: Boolean,
) {
    val activeColor = Color(0xFF1A73E8)
    val inactiveColor = Color(0xFF141B34)

    Column(
        modifier = Modifier
            .clickable { onClick() }
            .padding(vertical = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(iconRes),
            contentDescription = label,
            tint = if (isSelected) activeColor else inactiveColor,
            modifier = Modifier.size(24.dp)
        )

        Text(
            text = label,
            fontSize = if (isSmallScreen) 10.sp else 12.sp,
            lineHeight = if (isSmallScreen) 20.sp else 24.sp,
            color = if (isSelected) activeColor else inactiveColor,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal
        )
    }
}