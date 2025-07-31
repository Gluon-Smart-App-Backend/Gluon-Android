package com.gluon.gluonapp.ui.screens.chat_screen.chat_detail

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gluon.gluonapp.R
import com.gluon.gluonapp.ui.theme.GluonAppTheme

@Composable
fun ChatBottom(
    onSearch: (String) -> Unit = {},
    currentSearchQuery: String = "",
    onClearSearch: () -> Unit = {},
    onMicClick: () -> Unit,
    onPlusClick: () -> Unit,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier,
) {
    var searchQuery by remember { mutableStateOf(TextFieldValue(currentSearchQuery)) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Input Field + Mic icon
        Box(
            modifier = Modifier
                .weight(1f)
                .height(55.dp)
                .clip(RoundedCornerShape(28.dp))
                .background(Color(0xFFF5F5F5))
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (searchQuery.text.isEmpty()) {
                        Text(
                            text = "Type here....",
                            fontSize = 16.sp,
                            color = Color.Black,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    BasicTextField(
                        value = searchQuery,
                        onValueChange = {
                            searchQuery = it
                            onSearch(it.text)
                        },
                        textStyle = TextStyle(
                            fontSize = 16.sp,
                            color = Color.Black
                        ),
                        singleLine = true,
                        cursorBrush = SolidColor(Color.Black),
                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
                        keyboardActions = KeyboardActions(onSearch = {
                            onSearch(searchQuery.text)
                        }),
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                if (searchQuery.text.isNotEmpty()) {
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "Clear Search",
                        tint = Color.Gray,
                        modifier = Modifier
                            .size(20.dp)
                            .clickable {
                                searchQuery = TextFieldValue("")
                                onClearSearch()
                                onSearch("")
                            }
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Image(
                    painter = painterResource(id = R.drawable.mic_icon),
                    contentDescription = "Microphone",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { onMicClick() }
                )
            }
        }

        Spacer(modifier = Modifier.width(12.dp))

        // FAB placed inline to the right of search bar
        Box(
            modifier = Modifier
                .size(44.dp)
                .shadow(elevation = 8.dp, shape = CircleShape)
                .clip(CircleShape)
                .background(Color(0xFF1976F3))
                .clickable { onPlusClick() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.add_icon),
                contentDescription = "Add",
                tint = Color.White,
                modifier = Modifier.size(25.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Show2() {
    GluonAppTheme {
        ChatBottom(
            onSearch = {},
            currentSearchQuery = "",
            onClearSearch = {},
            onMicClick = {},
            onPlusClick = {},
        )
    }
}