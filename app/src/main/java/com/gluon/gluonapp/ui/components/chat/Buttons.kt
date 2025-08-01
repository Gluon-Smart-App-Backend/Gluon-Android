package com.gluon.gluonapp.ui.components.chat

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gluon.gluonapp.R
import com.gluon.gluonapp.ui.theme.GluonAppTheme

@Composable
fun MyIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    @DrawableRes iconResId: Int,
    contentDescription: String,
    isActive: Boolean = false,
) {
    val backgroundColor by animateColorAsState(
        targetValue = if (isActive) Color(0xFF1E88E5) else Color(0xFFF5F5F5),
        animationSpec = tween(200), label = ""
    )

    val iconTint by animateColorAsState(
        targetValue = if (isActive) Color.White else Color(0xFF666666),
        animationSpec = tween(200), label = ""
    )

    IconButton(
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = CircleShape
            ),
        onClick = onClick
    ) {

        Icon(
            painter = painterResource(id = iconResId),
            contentDescription = contentDescription,
            tint = iconTint,
            modifier = Modifier
                .size(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyIconButtonPreview() {
    GluonAppTheme {
        MyIconButton(
            onClick = {},
            iconResId = R.drawable.search_svg,
            contentDescription = ""
        )
    }
}