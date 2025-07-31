package com.gluon.gluonapp.ui.screens.tools_profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.AssistChip
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.gluon.gluonapp.R

@Composable
fun NoteDetailScreen(note: Note) {

    var content by remember { mutableStateOf(note.content) }
    val tags = listOf("Family", "Hobby", "Work")

    Box(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_back),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Spacer(Modifier.width(16.dp))
                Text(
                    text = "My Notes",
                    fontSize = 20.sp,
                    modifier = Modifier.weight(1f),
                    fontWeight = FontWeight.ExtraBold
                )
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_turn_back),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Spacer(Modifier.width(16.dp))
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_turn_forward),
                    contentDescription = null,
                    tint = Color.Unspecified
                )

            }
            Spacer(Modifier.height(37.dp))
            HorizontalDivider(Modifier.height(5.dp), color = Color(0x0D1A73E8))
            Spacer(Modifier.height(24.dp))
            Row(Modifier.padding(horizontal = 23.dp)) {
                Text(
                    text = "Feb 09, 2024 at 6 : 20 ",
                    fontSize = 14.sp,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_save),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }
            Spacer(Modifier.height(24.dp))
            TextField(
                value = content,
                onValueChange = { content = it },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                placeholder = { Text("Write your note...") }
            )
            Spacer(Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_add_item),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Spacer(Modifier.width(20.dp))
                Text(text = "Add Item ", fontSize = 16.sp)
            }
            Spacer(Modifier.height(34.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0x0D1A73E8), shape = RoundedCornerShape(16.dp))
            ) {
                Text(
                    "Choose tag",
                    modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                    color = Color.Black,
                    fontWeight = FontWeight.Medium
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState())
                        .padding(top = 11.dp, start = 16.dp, end = 16.dp)
                ) {
                    tags.forEach { tag ->
                        AssistChip(colors = AssistChipDefaults.assistChipColors(Color(0xFF1A73E8)),
                            shape = RoundedCornerShape(20.dp),
                            border = BorderStroke(0.dp, color = Color(0xFF1A73E8)),
                            onClick = {

                            }, label = { Text(tag, color = Color.White) })
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
            }

            Spacer(Modifier.height(20.dp))
            NoteEditorToolbar()
        }
    }
}

@Composable
fun NoteEditorToolbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0x0D1A73E8), shape = RoundedCornerShape(16.dp)),
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        IconButton(onClick = { /* bold */ }) {
            Icon(
                ImageVector.vectorResource(R.drawable.ic_bold),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
        IconButton(onClick = { /* italic */ }) {
            Icon(
                ImageVector.vectorResource(R.drawable.ic_italic),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
        IconButton(onClick = { /* underline */ }) {
            Icon(
                ImageVector.vectorResource(R.drawable.ic_underline),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
        IconButton(onClick = { /* text color */ }) {
            Icon(
                ImageVector.vectorResource(R.drawable.ic_text_color),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
        IconButton(onClick = { /* align */ }) {
            Icon(
                ImageVector.vectorResource(R.drawable.ic_text_align_justify_center),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
        IconButton(onClick = { /* align */ }) {
            Icon(
                ImageVector.vectorResource(R.drawable.ic_text_align_left),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
        IconButton(onClick = { /* align */ }) {
            Icon(
                ImageVector.vectorResource(R.drawable.ic_text_align_center),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
        IconButton(onClick = { /* align */ }) {
            Icon(
                ImageVector.vectorResource(R.drawable.ic_text_align_right),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
    }
}

data class NoteCategory(
    val title: String,
    val description: String,
    val icon: Int
)