package com.gluon.gluonapp.ui.screens.tools_profile

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gluon.gluonapp.R

@SuppressLint("AutoboxingStateCreation")
@Composable
fun ToolsScreen(
    navController: NavController
) {

    val tabs = listOf("All", "Creative", "Technologia", "Tech...")
    val selectedTab = remember { mutableStateOf(0) }

    Box(modifier = Modifier.background(Color.White)) {
        Column {
            Spacer(Modifier.height(32.dp))
            Header()
            Spacer(Modifier.height(28.dp))
            CategoryTabs(tabs, selectedTab)
            Spacer(modifier = Modifier.height(28.dp))
            ToolGrid(navController)
        }
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 23.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            modifier = Modifier.size(37.dp),
            colors = CardDefaults.cardColors(Color(0xFF1A73E8)),
            shape = RoundedCornerShape(8.dp),
        ) {

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopEnd) {
                Card(
                    colors = CardDefaults.cardColors(Color.White),
                    modifier = Modifier.size(10.dp)
                ) {
                    Card(
                        colors = CardDefaults.cardColors(Color.Green),
                        modifier = Modifier
                            .size(9.dp)
                            .align(Alignment.CenterHorizontally)
                    ) {}
                }
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    //Əgər profil şəkli varsa ifnen yoxluyub sekil qoymaq
                    Text(text = "FA", color = Color.White)
                }
            }

        }
        Row {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_qr),
                contentDescription = "QR",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(10.dp))
            Icon(
                ImageVector.vectorResource(R.drawable.ic_search),
                contentDescription = "Search",
                tint = Color.Unspecified
            )
        }
    }
}

@Composable
fun CategoryTabs(tabs: List<String>, selectedTab: MutableState<Int>) {
    LazyRow(
        Modifier.padding(horizontal = 23.dp),
    ) {
        itemsIndexed(tabs) { index, title ->
            val selected = selectedTab.value == index
            val backgroundColor = if (selected) Color(0xFF1A73E8) else Color(0xFFF5F5F5)
            val textColor = if (selected) Color.White else Color.Black

            Box(
                modifier = Modifier
                    .padding(end = 9.dp)
                    .background(backgroundColor, RoundedCornerShape(50.dp))
                    .clickable { selectedTab.value = index }
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(title, color = textColor)
            }
        }
    }
}

@Composable
fun ToolGrid(navController: NavController) {
    val tools = listOf(
        ToolItem(
            "Ask questions",
            "generating voices easier with assistant AI",
            painterResource(R.drawable.ic_voice)
        ),
        ToolItem(
            "Image & Art",
            "generating image and art easier with assistant AI",
            painterResource(R.drawable.ic_image)
        ),
        ToolItem(
            "Calendar",
            "generating voices easier with assistant AI",
            painterResource(R.drawable.ic_calendar)
        ),
        ToolItem(
            "Note",
            "generating image and art easier with assistant AI",
            painterResource(R.drawable.ic_note)
        ),
        ToolItem(
            "Lorem Ipsum",
            "generating voices easier with assistant AI",
            painterResource(R.drawable.ic_voice)
        ),
        ToolItem(
            "Lorem Ipsum",
            "generating image and art easier with assistant AI",
            painterResource(R.drawable.ic_image)
        )
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 23.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(tools) { tool ->
            ToolCard(tool, navController)
        }
    }
}

@Composable
fun ToolCard(tool: ToolItem, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0x0D1A73E8)),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    if (tool.title == "Note") {
                        navController.navigate("note_category_screen")
                    }
                },
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = tool.icon,
                contentDescription = null,
            )
            Text(text = tool.title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(text = tool.description, fontSize = 12.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToolScreenPreview() {
    ToolsScreen(rememberNavController())
}

data class ToolItem(
    val title: String,
    val description: String,
    val icon: Painter
)
