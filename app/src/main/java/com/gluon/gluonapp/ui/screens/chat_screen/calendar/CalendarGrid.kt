package com.gluon.gluonapp.ui.screens.chat_screen.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Calendar

@Composable
fun CalendarGrid(
    modifier: Modifier = Modifier,
    isSmallScreen: Boolean = false,
    currentCalendar: Calendar = Calendar.getInstance(),
) {

    // current day
    val today = Calendar.getInstance()
    val currentDay = today.get(Calendar.DAY_OF_MONTH)
    val currentMonth = today.get(Calendar.MONTH)
    val currentYear = today.get(Calendar.YEAR)

    // check month and year
    val displayedMonth = currentCalendar.get(Calendar.MONTH)
    val displayedYear = currentCalendar.get(Calendar.YEAR)

    // Get first day of month and calculate starting position
    val firstDayOfMonth = Calendar.getInstance().apply {
        set(displayedYear, displayedMonth, 1)
    }
    val firstDayOfWeek = firstDayOfMonth.get(Calendar.DAY_OF_WEEK) - 1 // 0-based
    val daysInMonth = currentCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)


    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(255.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(if (isSmallScreen) 16.dp else 24.dp)
        ) {

            // Day headers
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                val dayHeaders = listOf("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT")
                dayHeaders.forEach { day ->
                    Text(
                        text = day,
                        color = Color(0xFF0F172A).copy(alpha = 0.5f),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.width(30.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Calendar dates
            LazyVerticalGrid(
                columns = GridCells.Fixed(7),
                verticalArrangement = Arrangement.spacedBy(6.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                // Actual days
                items(daysInMonth) { dayIndex ->
                    val date = dayIndex + 1
                    CalendarDateCell(
                        date = date,
                        isSelected = false,
                        isToday = (date == currentDay &&
                                displayedMonth == currentMonth &&
                                displayedYear == currentYear)
                    )
                }
            }
        }
    }
}

@Composable
fun CalendarDateCell(
    date: Int,
    isSelected: Boolean = false,
    isToday: Boolean = false,
) {
    Box(
        modifier = Modifier
            .size(30.dp)
            .background(
                when {
                    isToday -> Color(0xFF1A73E8)
                    isSelected -> Color(0xFF1A73E8)
                    else -> Color.Transparent
                },
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = date.toString(),
            color = when {
                isToday -> Color.White
                isSelected -> Color.White
                else -> Color(0xFF6B7280)
            },
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}
