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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gluon.gluonapp.R

@Composable
fun NoteCategoryScreen(navController: NavController) {
    val categories = listOf(
        NoteCategory(
            "University",
            "generating voices easier with asistant AI",
            R.drawable.ic_university
        ),
        NoteCategory("Family", "generating voices easier with asistant AI", R.drawable.ic_family),
        NoteCategory("Work", "generating voices easier with asistant AI", R.drawable.ic_work),
        NoteCategory(
            "Personal",
            "generating voices easier with asistant AI",
            R.drawable.ic_personal
        ),
        NoteCategory("Tech", "generating voices easier with asistant AI", R.drawable.ic_tech),
        NoteCategory("Hobby", "generating voices easier with asistant AI", R.drawable.ic_hobby)
    )

    Box(modifier = Modifier.fillMaxSize().background(Color.White)){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 32.dp, horizontal = 23.dp)
        ) {
            Row  (verticalAlignment = Alignment.CenterVertically){
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_back),
                    null,
                    tint = Color.Unspecified
                )
                Spacer(Modifier.width(28.dp))
                Text("Note", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.height(28.dp))
            var selectedCategory by remember { mutableStateOf("All") }

            LazyRow(modifier = Modifier.padding(vertical = 8.dp)) {
                items(categories) { category ->
                    FilterChip(
                        modifier = Modifier.height(40.dp),
                        shape = RoundedCornerShape(50.dp),
                        selected = selectedCategory == category.title,
                        onClick = {
                            selectedCategory = category.title
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = Color(0xFF1A73E8),
                            containerColor = Color.White,
                            selectedLabelColor = Color.White,
                        ),
                        label = { Text(category.title) }
                    )
                    Spacer(modifier = Modifier.width(9.dp))
                }
            }

            Spacer(Modifier.height(28.dp))
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(categories) { category ->
                    Card(
                        modifier = Modifier.fillMaxWidth().clickable{
                            if(category.title == "Personal"){
                                navController.navigate("note_list_screen")
                            }
                        },
                        colors = CardDefaults.cardColors(Color(0x0D1A73E8)),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Row(modifier = Modifier.padding(16.dp)) {
                            Icon(
                                imageVector = ImageVector.vectorResource(category.icon),
                                contentDescription = null,
                                tint = Color.Unspecified
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Column {
                                Text(
                                    text = category.title,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Medium
                                )
                                Text(category.description, fontSize = 12.sp)
                            }
                        }
                    }
                    Spacer(Modifier.height(20.dp))
                }
            }

            Button(
                onClick = {
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF1A73E8))
            ) {
                Text("Add New Note", fontSize = 16.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    //NoteDetailScreen((Note(0, "TITLE", "", "TAG", listOf(CheckItem("TEXT", true)))))
    NoteCategoryScreen(rememberNavController())
}