package com.gluon.gluonapp.ui.screens.calendar

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gluon.gluonapp.R
import com.gluon.gluonapp.ui.components.calendar.CalendarViewModeButtons
import com.gluon.gluonapp.ui.components.calendar.CalendarGrid
import com.gluon.gluonapp.ui.components.calendar.CalendarMonthNavigation
import com.gluon.gluonapp.ui.components.calendar.EventCard
import com.gluon.gluonapp.ui.theme.GluonAppTheme
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun CalendarHeaderComponents(
    onBackClick: () -> Unit,
    onSearchClick: () -> Unit,
    onPlusClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val isSmallScreen = screenWidth < 400.dp

    var selectedViewMode by remember { mutableStateOf("Month") }

    // Calendar state
    val currentDate = remember { Calendar.getInstance() }
    var currentMonth by remember {
        mutableStateOf(
            SimpleDateFormat("MMMM yyyy", Locale.getDefault()).format(currentDate.time)
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .clip(RoundedCornerShape(if (isSmallScreen) 24.dp else 40.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            // Background with curved shape
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(if (isSmallScreen) 240.dp else 280.dp)
            ) {
                Canvas(
                    modifier = Modifier.fillMaxSize()
                ) {
                    drawCurvedBackground(this)
                }

                // Header content
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = if (isSmallScreen) 16.dp else 24.dp)
                ) {
                    Spacer(modifier = Modifier.height(if (isSmallScreen) 16.dp else 20.dp))

                    // Top navigation
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = { },
                            modifier = Modifier
                                .size(40.dp)
                                .background(
                                    Color.White,
                                    shape = CircleShape
                                ),
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.back_button_calendar),
                                contentDescription = "Back to tools screen",
                                modifier = Modifier.size(20.dp)
                            )
                        }

                        Text(
                            text = "Calendar",
                            color = Color.White,
                            fontSize = if (isSmallScreen) 18.sp else 20.sp,
                            fontWeight = FontWeight.Medium
                        )

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            IconButton(
                                onClick = { },
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.search_ic_calendar),
                                    contentDescription = "Search",
                                    tint = Color.White,
                                )
                            }

                            IconButton(
                                onClick = { },
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.plus_ic_calendar),
                                    contentDescription = "Add",
                                    tint = Color.White,
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(if (isSmallScreen) 12.dp else 16.dp))

                    // View mode buttons (day, month, week, year)
                    CalendarViewModeButtons(
                        selectedMode = selectedViewMode,
                        onModeSelected = { selectedViewMode = it },
                        isSmallScreen = isSmallScreen,
                    )

                    Spacer(modifier = Modifier.height(if (isSmallScreen) 12.dp else 16.dp))

                    // Month navigation
                    CalendarMonthNavigation(
                        currentMonth = currentMonth,
                        onMonthChanged = { direction ->
                            if (direction == "prev") {
                                currentDate.add(Calendar.MONTH, -1)
                            } else {
                                currentDate.add(Calendar.MONTH, 1)
                            }
                            currentMonth = SimpleDateFormat(
                                "MMMM yyyy", Locale.getDefault()
                            )
                                .format(currentDate.time)
                        },
                        isSmallScreen = isSmallScreen
                    )
                }
            }

            // Calendar grid
            CalendarGrid(
                modifier = Modifier
                    .padding(
                        horizontal = if (isSmallScreen) 16.dp else 24.dp
                    )
                    .offset(y = (-40).dp),
                isSmallScreen = isSmallScreen,
                currentCalendar = currentDate
            )

            Spacer(
                modifier = Modifier
                    .height(
                        if (isSmallScreen) 16.dp else 20.dp
                    )
            )

//            // Upcoming events section
            Column(
                modifier = Modifier
                    .padding(
                        horizontal = if (isSmallScreen) 16.dp else 24.dp
                    )
            ) {
                Text(
                    text = "Upcoming events",
                    color = Color(0xFF1A73E8),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Event cards
                EventCard(
                    title = "Event title",
                    description = "Event description",
                    time = "Event time",
                    location = "Event place",
                    isUrgent = true,
                    isSmallScreen = isSmallScreen
                )

                Spacer(modifier = Modifier.height(12.dp)) // 20idi

                EventCard(
                    title = "Event title",
                    description = "Event description",
                    time = "Event time",
                    location = "Event place",
                    isUrgent = true,
                    isSmallScreen = isSmallScreen
                )
            }

            Spacer(modifier = Modifier.height(20.dp)) // 32 idi

            // Bottom indicator
            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(134.dp) // 182 idi
                    .height(4.dp)
                    .background(
                        Color(0xFF1C1C1B),
                        RoundedCornerShape(2.dp)
                    )
            )

            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

private fun drawCurvedBackground(drawScope: DrawScope) {
    val path = androidx.compose.ui.graphics.Path().apply {
        moveTo(0f, 0f)
        lineTo(drawScope.size.width, 0f)
        lineTo(drawScope.size.width, drawScope.size.height * 0.85f)

        // Create curved bottom
        cubicTo(
            drawScope.size.width * 0.85f, drawScope.size.height,
            drawScope.size.width * 0.6f, drawScope.size.height,
            drawScope.size.width * 0.52f, drawScope.size.height
        )
        cubicTo(
            drawScope.size.width * 0.2f, drawScope.size.height,
            0f, drawScope.size.height * 0.86f,
            0f, drawScope.size.height * 0.86f
        )
        close()
    }

    drawScope.drawPath(
        path = path,
        color = Color(0xFF1A73E8)
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewCalendar() {
    GluonAppTheme {
        CalendarHeaderComponents(
            onBackClick = {},
            onSearchClick = {},
            onPlusClick = {}
        )
    }
}