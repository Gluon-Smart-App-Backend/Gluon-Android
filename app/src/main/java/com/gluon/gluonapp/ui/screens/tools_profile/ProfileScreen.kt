package com.gluon.gluonapp.ui.screens.tools_profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gluon.gluonapp.R

@Composable
fun ProfileScreen(
    navController: NavController,
) {
    Box(modifier = Modifier.background(Color.White)) {
        Box(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 23.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(Modifier.height(32.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_back),
                        null,
                        tint = Color.Unspecified,
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        }
                    )
                    Text(
                        "Profile",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 32.dp)
                    )
                }
                Spacer(Modifier.height(30.dp))
                Box(modifier = Modifier.size(72.dp), contentAlignment = Alignment.TopEnd) {
                    Image(
                        painter = painterResource(R.drawable.default_profile_image),
                        null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(72.dp)
                            .clip(CircleShape)
                    )
                    Card(
                        modifier = Modifier
                            .size(16.dp)
                            .padding(top = 5.dp, end = 5.dp)
                            .clip(CircleShape),
                        colors = CardDefaults.cardColors(Color.Green)
                    ) {}
                }
                Spacer(Modifier.height(8.dp))
                Text("Jasmin Androviç", fontSize = 16.sp, fontWeight = FontWeight.Medium)
                Spacer(Modifier.height(8.dp))
                Text(
                    " AndroviçJasmin@gmail.com",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray
                )
                Spacer(Modifier.height(20.dp))
                Text(
                    "Connects",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF1A73E8)
                )
                Spacer(Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        "1000 Followers",
                        modifier = Modifier.padding(end = 12.dp),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF1A73E8)
                    )
                    Spacer(
                        Modifier
                            .width(1.dp)
                            .height(12.dp)
                            .background(Color(0xFF1A73E8))
                    )
                    Text(
                        "1200 Following",
                        modifier = Modifier.padding(start = 12.dp),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF1A73E8)
                    )

                }
                Spacer(Modifier.height(24.dp))
                SettingsSection(R.drawable.ic_dark_mode, "Dark mode", true) {

                }
                SettingsSection(R.drawable.ic_edit, "Edit profile", false) {
                    navController.navigate("edit_profile_screen")
                }
                SettingsSection(R.drawable.ic_notification, "Notification", false) {

                }
                SettingsSection(R.drawable.ic_chat, "Chat settings", false) {

                }
                SettingsSection(R.drawable.ic_data_and_storage, "Data and storage", false) {

                }
                SettingsSection(R.drawable.ic_lock, "Privacy and security", false) {

                }

            }
        }
    }
}

@Composable
fun SettingsSection(icon: Int, name: String, isDarkModeSection: Boolean, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(25.dp),
        elevation = CardDefaults.cardElevation(2.dp),
    ) {
        Row(
            Modifier.padding(horizontal = 15.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = ImageVector.vectorResource(icon), null, tint = Color.Unspecified)
            Spacer(Modifier.width(18.dp))
            Text(
                text = name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.weight(1f)
            )
            if (isDarkModeSection) {
                CustomSwitch()
            } else {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_right_arrow),
                    null,
                    tint = Color.Unspecified
                )
            }
        }
    }
    Spacer(Modifier.height(16.dp))
}

@Composable
fun CustomSwitch() {

    var isChecked by remember { mutableStateOf(true) }

    Switch(
        modifier = Modifier.height(22.dp),
        checked = isChecked,
        onCheckedChange = { isChecked = it },
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color(0xFF1A73E8),
            checkedTrackColor = Color.Black,
            uncheckedThumbColor = Color(0xFF1A73E8),
            uncheckedTrackColor = Color.Black
        )
    )
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(rememberNavController())
}