package com.gluon.gluonapp.ui.screens.chat_screen.chat

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gluon.gluonapp.ui.components.chat.ChatHeaderComponents
import com.gluon.gluonapp.ui.components.chat.SearchBar
import com.gluon.gluonapp.ui.components.chat.SearchContent
import com.gluon.gluonapp.ui.theme.GluonAppTheme

@Composable
fun ChatMainScreen() {
    var selectedTab by remember { mutableStateOf("Chat") }
    var isSearchActive by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            ChatHeaderComponents(
                userInitials = "XX",
                onProfileClick = {},
                onQrClick = {},
                onSearchClick = {
                    isSearchActive = !isSearchActive
                    if (!isSearchActive) searchText = ""
                },
                isSearchActive = isSearchActive
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

            ChatList()
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ShowMainScreenFinal() {
    GluonAppTheme {
        ChatMainScreen()
    }
}