package com.gluon.gluonapp.ui.screens.tools_profile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gluon.gluonapp.R

@Composable
fun EditProfileScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 23.dp)
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Row {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_back),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.clickable{
                    navController.popBackStack()
                }
            )
            Text(
                text = "Edit Profile",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth().padding(end = 32.dp),
                textAlign = TextAlign.Center,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(31.dp))

        Box(
            modifier = Modifier
                .size(72.dp)
                .align(Alignment.CenterHorizontally),
            contentAlignment = Alignment.BottomEnd
        ) {
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF1A73E8)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "FA",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.White)
                    .border(1.dp, Color(0xFF007AFF), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_change_profile_picture),
                    contentDescription = "Edit",
                    tint = Color.Unspecified,
                    modifier = Modifier.padding(1.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(74.dp))


        ProfileField(label = "Name", value = "Jasmin Androviç")
        ProfileField(label = "Gender", value = "Woman")
        ProfileField(label = "Email", value = "AndrovicJasmin@gmail.com")
        ProfileField(label = "Mobil", value = "+994 234567891")
        ProfileField(label = "Country/Region", value = "Baku")

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun ProfileField(label: String, value: String) {
    Column(modifier = Modifier
        .fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.padding(start = 14.dp),
            text = label,
            color = Color(0xFF1A73E8),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(2.dp),
            shape = RoundedCornerShape(25.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 6.dp)
        ) {
            Text(
                text = value,
                modifier = Modifier.padding(16.dp),
                color = Color(0xFFA1A5AB)
            )
        }
    }
    Spacer(Modifier.height(16.dp))
}


@Preview(showBackground = true)
@Composable
fun EditProfileScreenPreview () {
    EditProfileScreen(rememberNavController())
}