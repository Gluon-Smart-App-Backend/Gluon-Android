package com.gluon.gluonapp.ui.components.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalendarMonthNavigation(
    currentMonth: String,
    onMonthChanged: (String) -> Unit,
    isSmallScreen: Boolean = false,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(Color.White)
            .border(
                width = 1.dp,
                color = Color(0xFF1A73E8),
                shape = RoundedCornerShape(24.dp)
            )
            .padding(horizontal = if (isSmallScreen) 12.dp else 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Default.KeyboardArrowLeft,
                contentDescription = "Previous month",
                tint = Color(0xFF141B34).copy(alpha = 0.5f),
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        onMonthChanged("prev")
                    }
            )

            Text(
                text = currentMonth,
                color = Color(0xFF0F172A),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )

            Icon(
                Icons.Default.KeyboardArrowRight,
                contentDescription = "Next month",
                tint = Color(0xFF141B34).copy(alpha = 0.5f),
                modifier = Modifier
                    .size(20.dp)
                    .clickable {
                        onMonthChanged("next")
                    }
            )
        }
    }
}
