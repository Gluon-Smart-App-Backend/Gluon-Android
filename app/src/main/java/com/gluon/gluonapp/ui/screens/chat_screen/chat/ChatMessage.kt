package com.gluon.gluonapp.ui.screens.chat_screen.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gluon.gluonapp.R
import com.gluon.gluonapp.ui.theme.GluonAppTheme

data class ChatUser(
    val id: String,
    val name: String,
    val profileImage: String,
    val isOnline: Boolean,
    val lastMessage: String,
    val timestamp: String,
    val unreadCount: Int = 0,
    val messageStatus: MessageStatus = MessageStatus.NONE,
    val isLastMessageFromMe: Boolean = false,
)

enum class MessageStatus {
    NONE,
    SENT,
    DELIVERED,
    READ
}

// Mock data
val mockUsers = listOf(
    ChatUser(
        id = "1",
        name = "Jasmin Androgenic",
        profileImage = "",
        isOnline = true,
        lastMessage = "Thank you,Boss",
        timestamp = "14:00",
        unreadCount = 1,
        messageStatus = MessageStatus.NONE,
        isLastMessageFromMe = false
    ),
    ChatUser(
        id = "2",
        name = "Eric Broses Smith",
        profileImage = "",
        isOnline = true,
        lastMessage = "Ok, let me check 😉",
        timestamp = "13:00",
        messageStatus = MessageStatus.READ,
        isLastMessageFromMe = true
    ),
    ChatUser(
        id = "3",
        name = "Hader Colas",
        profileImage = "",
        isOnline = false,
        lastMessage = "Ok, let me check",
        timestamp = "12:00",
        messageStatus = MessageStatus.SENT,
        isLastMessageFromMe = true
    ),
    ChatUser(
        id = "4",
        name = "Aleksandra Clavichord",
        profileImage = "",
        isOnline = false,
        lastMessage = "Ok, let me check 😉",
        timestamp = "12:00",
        messageStatus = MessageStatus.DELIVERED,
        isLastMessageFromMe = true
    ),
    ChatUser(
        id = "5",
        name = "Samantha Bishop",
        profileImage = "",
        isOnline = false,
        lastMessage = "Ok, let me check 😉",
        timestamp = "Yesterday",
        unreadCount = 1,
        messageStatus = MessageStatus.NONE,
        isLastMessageFromMe = false
    ),
    ChatUser(
        id = "6",
        name = "Peter Dunham",
        profileImage = "",
        isOnline = false,
        lastMessage = "Hey,call me back",
        timestamp = "17 May",
        unreadCount = 25,
        messageStatus = MessageStatus.NONE,
        isLastMessageFromMe = false
    ),
    ChatUser(
        id = "7",
        name = "Peter Dunham",
        profileImage = "",
        isOnline = false,
        lastMessage = "Hey,call me back",
        timestamp = "17 May",
        unreadCount = 25,
        messageStatus = MessageStatus.NONE,
        isLastMessageFromMe = false
    )
)

@Composable
fun ChatList() {
    LazyColumn(
        modifier = Modifier
            .padding(top = 70.dp)
            .fillMaxSize(),
    ) {
        items(mockUsers) { user ->
            ChatListItem(user = user)
        }
    }
}

@Composable
fun ChatListItem(user: ChatUser) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Profile Image with Online Status
        Box(
            modifier = Modifier.size(56.dp)
        ) {
            // Profile Image Placeholder
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .background(
                        Color.Gray.copy(alpha = 0.3f),
                        CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = user.name.split(" ").map { it.first() }.joinToString(""),
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }

            // Online Status Indicator
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .background(
                        if (user.isOnline) Color(0xFF01D116) else Color.Gray,
                        CircleShape
                    )
                    .align(Alignment.BottomEnd)
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        // Chat Content
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // User Name
                Text(
                    text = user.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color(0xFF232323),
                    modifier = Modifier.weight(1f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                // Timestamp
                Text(
                    text = user.timestamp,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Message with status
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Message Status Icons
                    if (user.isLastMessageFromMe) {
                        when (user.messageStatus) {
                            MessageStatus.SENT -> {
                                Icon(
                                    Icons.Default.Check,
                                    contentDescription = "Sent",
                                    tint = Color.Black,
                                    modifier = Modifier.size(18.dp)
                                )
                            }

                            MessageStatus.DELIVERED -> {
                                Icon(
                                    painter = painterResource(R.drawable.single_tick),
                                    contentDescription = "Delivered",
                                    tint = Color.Black,
                                    modifier = Modifier.size(18.dp)
                                )
                            }

                            MessageStatus.READ -> {
                                Icon(
                                    painter = painterResource(R.drawable.double_tick),
                                    contentDescription = "Read",
                                    tint = Color.Black,
                                    modifier = Modifier.size(18.dp)
                                )
                            }

                            MessageStatus.NONE -> {}
                        }

                        if (user.messageStatus != MessageStatus.NONE) {
                            Spacer(modifier = Modifier.width(4.dp))
                        }
                    }

                    // Message Text
                    Text(
                        text = user.lastMessage,
                        fontSize = 16.sp,
                        color = Color.Gray,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                // Unread Count Badge
                if (user.unreadCount > 0) {
                    Box(
                        modifier = Modifier
                            .background(
                                Color(0xFF007AFF),
                                CircleShape
                            )
                            .size(19.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = if (user.unreadCount > 99) "99+" else user.unreadCount.toString(),
                            color = Color.White,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatListPreview() {
    GluonAppTheme {
        ChatList()
    }
}