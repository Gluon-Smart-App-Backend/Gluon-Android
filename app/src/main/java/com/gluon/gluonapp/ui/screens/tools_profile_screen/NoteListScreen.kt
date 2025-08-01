package com.gluon.gluonapp.ui.screens.tools_profile_screen

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gluon.gluonapp.R
import com.gluon.gluonapp.model.CheckItem
import com.gluon.gluonapp.model.Note

@Composable
fun NoteListScreen(
    notes: List<Note>,
    navController: NavController,
) {

    Box(
        Modifier
            .fillMaxSize()
            .background(Color.White), contentAlignment = Alignment.BottomCenter
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 23.dp, vertical = 32.dp)
        ) {
            item {
                Row {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_back),
                        null,
                        tint = Color.Unspecified
                    )
                    Spacer(Modifier.width(28.dp))
                    Text("Personal", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.height(33.dp))
            }
            items(notes) { note ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp)
                        .clickable {
                            navController.navigate("note_detail_screen")
                        },
                    colors = CardDefaults.cardColors(Color.White),
                    elevation = CardDefaults.cardElevation(3.dp)
                ) {
                    Column(modifier = Modifier.padding(vertical = 16.dp, horizontal = 28.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = note.title,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.ExtraBold,
                                modifier = Modifier.weight(1f)
                            )
                            Card(
                                shape = RoundedCornerShape(20.dp),
                                colors = CardDefaults.cardColors(Color(0xFF3F56E0))
                            ) {
                                Text(
                                    note.tag,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = Color.White,
                                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(verticalAlignment = Alignment.Bottom) {
                            Text(
                                text = note.content,
                                fontSize = 14.sp,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.weight(1f)
                            )
                            Spacer(Modifier.width(35.dp))
                            Text(
                                "Feb 09, 2024 at 6 : 20 ",
                                color = Color(0x803F56E0),
                                fontSize = 10.sp
                            )
                        }
                    }
                }
            }
        }
        Column {
            Button(
                onClick = {
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
                    .padding(horizontal = 36.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF1A73E8))
            ) {
                Text("Add New Note", fontSize = 16.sp)
            }
            Spacer(Modifier.height(32.dp))
        }

    }
}

@Preview
@Composable
fun Preview() {
    val staticList = listOf(
        Note(
            0,
            "Technofest event",
            "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
            "Personal",
            listOf(CheckItem("Text", false))
        ),
        Note(
            0,
            "Technofest event",
            "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
            "Personal",
            listOf(CheckItem("Text", false))
        ),
        Note(
            0,
            "Technofest event",
            "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
            "Personal",
            listOf(CheckItem("Text", false))
        ),
        Note(
            0,
            "Technofest event",
            "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
            "Personal",
            listOf(CheckItem("Text", false))
        ),
        Note(
            0,
            "Technofest event",
            "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
            "Personal",
            listOf(CheckItem("Text", false))
        ),
        Note(
            0,
            "Technofest event",
            "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
            "Personal",
            listOf(CheckItem("Text", false))
        ),
    )

    NoteListScreen(staticList, rememberNavController())
}