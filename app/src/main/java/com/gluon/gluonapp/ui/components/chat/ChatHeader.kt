package com.gluon.gluonapp.ui.components.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import com.gluon.gluonapp.R
import com.gluon.gluonapp.ui.theme.GluonAppTheme

@Composable
fun ChatHeader(
    profileImageUrl: String,
    onBackClick: () -> Unit,
    onProfileClick: () -> Unit,
    onNameClick: () -> Unit,
    onTaskClick: () -> Unit,
    onCalendarClick: () -> Unit,
    modifier: Modifier = Modifier,
) {

    // Optional: an ImageLoader for SVG usage
    val imageLoader = coil.ImageLoader.Builder(LocalContext.current)
        .components { add(SvgDecoder.Factory()) }
        .build()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(R.drawable.back_button_calendar),
                contentDescription = "Back Icon",
                modifier = Modifier
                    .clickable { onBackClick() }
//                painter = rememberAsyncImagePainter(
//                    model = "file:///android_asset/Menu.svg",
//                    imageLoader = imageLoader
            )

            Spacer(modifier = Modifier.width(12.dp))

            Box(
                modifier = Modifier
                    .background(Color(0xFfF5F5F5))
            ) {
                AsyncImage(
                    model = profileImageUrl,
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .clickable { onProfileClick() }
                        .size(40.dp)
                        .clip(CircleShape)
                )

                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(Color.Green, CircleShape)
                        .align(Alignment.BottomEnd)
                        .border(1.5.dp, Color.Black, CircleShape)
                        .offset(x = 28.dp, y = 28.dp)
                )
            }

            Spacer(modifier = Modifier.width(20.dp))

            Row {
                Text(
                    modifier = Modifier
                        .clickable { onNameClick() },
                    text = "Name here",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                )
            }
        }

        Row(
            modifier = Modifier
                .background(Color.Transparent)
        ) {
            Icon(
                contentDescription = "Daily task",
                painter = painterResource(R.drawable.task_daily),
                modifier = Modifier.clickable {
                    onTaskClick()
                }
            )
            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                contentDescription = "Calendar Edit",
                painter = painterResource(R.drawable.calendar_edit),
                modifier = Modifier.clickable {
                    onCalendarClick()
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Show() {
    GluonAppTheme {
        ChatHeader(
            profileImageUrl = "https://example.com/profile.jpg",
            onBackClick = {},
            onProfileClick = {},
            onNameClick = {},
            onTaskClick = {},
            onCalendarClick = {},
        )
    }
}