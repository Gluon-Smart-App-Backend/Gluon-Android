package com.gluon.gluonapp.ui.screens.chat_screen.calendar

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun CalendarButton(
    text: String,
    isSelected: Boolean = false,
    onClick: () -> Unit,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier,
    isSmallScreen: Boolean = false,
) {
    Box(
        modifier = modifier
            .height(36.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(
                if (isSelected) Color.White else Color(0xFF1E40AF).copy(alpha = 0.6f)
            )
            .border(
                width = 1.dp,
                color = if (isSelected) Color.White else Color(0xFF0F172A).copy(alpha = 0.1f),
                shape = RoundedCornerShape(25.dp)
            )
            .clickable {
                onClick()
            }
            .padding(horizontal = if (isSmallScreen) 8.dp else 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = if (isSelected) Color(0xFF1A73E8) else Color.White,
            fontSize = if (isSmallScreen) 12.sp else 14.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun CalendarViewModeButtons(
    selectedMode: String,
    onModeSelected: (String) -> Unit,
    isSmallScreen: Boolean = false,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(if (isSmallScreen) 6.dp else 8.dp)
    ) {
        // Mode buttons
        val modes = listOf("Day", "Week", "Month", "Year")

        modes.forEach { mode ->
            CalendarButton(
                text = mode,
                isSelected = selectedMode == mode,
                onClick = {
                    onModeSelected(mode)
                },
                modifier = Modifier.weight(1f),
                isSmallScreen = isSmallScreen
            )
        }
    }
}