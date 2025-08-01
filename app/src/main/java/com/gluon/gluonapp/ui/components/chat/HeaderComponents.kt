package com.gluon.gluonapp.ui.components.chat

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gluon.gluonapp.R
import com.gluon.gluonapp.ui.theme.GluonAppTheme

@Composable
fun ChatHeaderComponents(
    userInitials: String = "",
    onProfileClick: () -> Unit = {},
    onQrClick: () -> Unit = {},
    onSearchClick: () -> Unit = {},
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier,
    isSearchActive: Boolean = false,
) {
    Surface(
        color = Color.White,
        modifier = modifier
            .fillMaxWidth()
            .statusBarsPadding()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 12.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            //profile avatar
            Box(
                modifier = Modifier
                    .size(34.dp)
                    .background(
                        color = Color(0xFF1E88E5),
                        shape = CircleShape
                    )
                    .clickable { onProfileClick() },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = userInitials,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                //green point
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .background(
                            color = Color(0xFF4CAF50),
                            shape = CircleShape
                        )
                        .border(
                            width = 2.dp,
                            color = Color.White,
                            shape = CircleShape
                        )
                        .align(Alignment.BottomEnd)
                        .offset(x = 2.dp, y = 2.dp)
                )
            }

            //right zone
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // QR kod
                MyIconButton(
                    onClick = onQrClick,
                    modifier = modifier,
                    iconResId = R.drawable.qr_code_svg,
                    contentDescription = "QR COde Scanner"
                )

                //Search button
                MyIconButton(
                    onClick = onSearchClick,
                    modifier = modifier,
                    iconResId = R.drawable.search_svg,
                    contentDescription = "Search button",
                    isActive = isSearchActive
                )
            }
        }
    }
}

@Composable
fun SearchBar(
    searchText: String,
    onSearchTextChange: (String) -> Unit,
    onClearSearch: () -> Unit,
) {
    Surface(
        color = Color.White,
        shadowElevation = 8.dp,
        shape = CircleShape
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.search_child_panel_icon),
                contentDescription = "Search",
                tint = Color(0xFF666666),
                modifier = Modifier.size(20.dp)
            )

            Spacer(
                modifier = Modifier.width(8.dp)
            )

            BasicTextField(
                value = searchText,
                onValueChange = onSearchTextChange,
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 8.dp),
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black
                ),
                singleLine = true,
                decorationBox = { innerTextField ->
                    if (searchText.isEmpty()) {
                        Text(
                            modifier = Modifier
                                .padding(start = 30.dp),
                            text = "Search",
                            color = Color(0xFF999999),
                            fontSize = 16.sp
                        )
                    }
                    innerTextField()
                }
            )

            if (searchText.isNotEmpty()) {
                IconButton(onClick = onClearSearch) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "Clear search",
                        tint = Color(0xFF666666),
                        modifier = Modifier
                            .size(20.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun SearchContent(
    searchText: String,
) {

    val items = listOf(
        Triple("Unread", R.drawable.unread_icon) {},
        Triple("Connections", R.drawable.connections_icon) {},
        Triple("Voice", R.drawable.voice_icon) {},
        Triple("Pictures", R.drawable.pictures_icon) {},
        Triple("Video", R.drawable.video_icon) {},
        Triple("Questionnaires", R.drawable.questionnaires_icon) {},
    )

    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 18.dp,
                end = 18.dp,
                top = 16.dp
            ),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        items.forEach { (title, icon, onClick) ->
            FilterCard(title = title, iconResId = icon, onClick = onClick)
        }
    }
}

@Composable
fun FilterCard(
    title: String,
    @DrawableRes iconResId: Int,
    onClick: () -> Unit,
) {
    Surface(
        modifier = Modifier
            .wrapContentSize()
            .clip(RoundedCornerShape(24.dp))
            .clickable { onClick() },
        color = Color(0xFFF5F5F5),
        shadowElevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .padding(
                    horizontal = 16.dp,
                    vertical = 10.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = iconResId),
                contentDescription = title,
                tint = Color(0xFF1E88E5),
                modifier = Modifier.size(20.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = title,
                fontSize = 14.sp,
                color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatHeaderComponentsPreview() {
    GluonAppTheme {
        ChatHeaderComponents(
            userInitials = "XX",
            onProfileClick = {},
            onQrClick = {},
            onSearchClick = {}
        )
    }
}