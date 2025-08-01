package com.gluon.gluonapp.ui.components.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EventCard(
    title: String,
    description: String,
    time: String,
    location: String,
    isUrgent: Boolean = false,
    isSmallScreen: Boolean = false,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(if (isSmallScreen) 100.dp else 110.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp) // 2 idi
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            // Blue accent bar
            Box(
                modifier = Modifier
                    .width(4.dp) // 40 idi
                    .height(40.dp) // 4 idi
                    .background(Color(0xFF1A73E8))
                    .align(Alignment.CenterStart)
                    .offset(x = 0.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp)
            ) {
                // Urgent label
                if (isUrgent) {
                    Text(
                        text = "Urgent",
                        color = Color(0xFF3F56E0),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                }

                // Title
                Text(
                    text = title,
                    color = Color(0xFF030712),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(2.dp)) // 4 idi

                // Description
                Text(
                    text = description,
                    color = Color(0xFF030712).copy(alpha = 0.5f),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Time and location row
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Time
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Default.ThumbUp,
                            contentDescription = "Time",
                            tint = Color(0xFF3F56E0).copy(alpha = 0.5f),
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = time,
                            color = Color(0xFF3F56E0),
                            fontSize = 12.sp, // 14 idi
                            fontWeight = FontWeight.Medium
                        )
                    }

                    // Location
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Default.LocationOn,
                            contentDescription = "Location",
                            tint = Color(0xFF3F56E0).copy(alpha = 0.5f),
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = location,
                            color = Color(0xFF3F56E0),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }

            // Done button
            Button(
                onClick = { },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
                    .width(80.dp)
                    .height(32.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1E40AF)
                ),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(0.dp)

            ) {
                Text(
                    text = "Done",
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}
