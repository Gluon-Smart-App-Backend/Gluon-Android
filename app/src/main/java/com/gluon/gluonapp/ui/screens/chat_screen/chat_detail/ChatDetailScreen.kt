package com.gluon.gluonapp.ui.screens.chat_screen.chat_detail

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gluon.gluonapp.ui.screens.chat_screen.chat.SearchBar
import com.gluon.gluonapp.ui.screens.chat_screen.chat.SearchContent
import com.gluon.gluonapp.ui.theme.GluonAppTheme

@Composable
fun ChatDetailScreen(
    profileImageUrl: String,
    onBackClick: () -> Unit,
    onProfileClick: () -> Unit,
    onNameClick: () -> Unit,
    onTaskClick: () -> Unit,
    onCalendarClick: () -> Unit,
    onSearch: (String) -> Unit = {},
    currentSearchQuery: String = "",
    onClearSearch: () -> Unit = {},
    onMicClick: () -> Unit,
    onPlusClick: () -> Unit,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier,
) {

    var isSearchActive by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            ChatHeader(
                profileImageUrl = profileImageUrl,
                onBackClick = onBackClick,
                onProfileClick = onProfileClick,
                onNameClick = onNameClick,
                onTaskClick = onTaskClick,
                onCalendarClick = onCalendarClick,
                modifier = modifier
            )
        },
        bottomBar = {
            ChatBottom(
                onSearch = onSearch,
                currentSearchQuery = currentSearchQuery,
                onClearSearch = onClearSearch,
                onMicClick = onMicClick,
                onPlusClick = onPlusClick,
                modifier = modifier
            )
        },

        content = { innerPadding ->

            Column(
                modifier = Modifier
                    .padding(innerPadding)
            ) {

                AnimatedVisibility(visible = isSearchActive) {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                    ) {
                        SearchBar(
                            searchText = searchText,
                            onSearchTextChange = { searchText = it },
                            onClearSearch = { searchText = "" }
                        )

                        SearchContent(searchText = searchText)
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ShowChatDetail() {
    GluonAppTheme {
        ChatDetailScreen(
            profileImageUrl = "https://example.com/profile.jpg",
            onBackClick = {},
            onProfileClick = {},
            onNameClick = {},
            onTaskClick = {},
            onCalendarClick = {},
            onSearch = {},
            currentSearchQuery = "",
            onClearSearch = {},
            onMicClick = {},
            onPlusClick = {},
        )
    }
}