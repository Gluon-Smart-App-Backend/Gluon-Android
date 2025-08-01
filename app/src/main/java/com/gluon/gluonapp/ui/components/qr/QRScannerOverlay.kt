package com.gluon.gluonapp.ui.components.qr

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.gluon.gluonapp.R


@Composable
fun QRScannerOverlay(
    frameSize: Dp = 250.dp,
    lineColor: Color = Color.Green,
    lineWidth: Dp = 2.dp,
    lineDuration: Int = 2000
) {
    val infiniteTransition = rememberInfiniteTransition()
    val lineOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = lineDuration, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        modifier = Modifier
            .size(250.dp)
            .background(Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(frameSize)
                .border(3.dp, Color.Transparent, RoundedCornerShape(12.dp))
        ) {
            Image(
                painter = painterResource(id = R.drawable.qr_border),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(lineWidth)
                    .align(Alignment.TopCenter)
                    .graphicsLayer {
                        translationY = lineOffset * (frameSize.toPx() - lineWidth.toPx())
                    }
                    .background(lineColor)
            )
        }
    }
}