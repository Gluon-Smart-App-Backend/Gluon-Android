package com.gluon.gluonapp.ui.components.tabs

import androidx.compose.animation.Animatable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Tab
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.TabRow
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.gluon.gluonapp.ui.theme.BlackLight
import com.gluon.gluonapp.ui.theme.Primary
import com.gluon.gluonapp.ui.theme.colors
import com.gluon.gluonapp.ui.theme.roboto_medium
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CustomTabLayout(
    navController: NavController,
    modifier: Modifier = Modifier.fillMaxSize(),
    tabItems: List<TabItem>,
    change: () -> Unit
) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    val tabItemColors = colors(Color.White, BlackLight)
    val tabColors = remember {
        tabItems.map { Animatable(tabItemColors) }
    }



    Column {

        TabRow(
            selectedTabIndex = pagerState.currentPage,
            backgroundColor = colors(Color.White, BlackLight),
            modifier = Modifier
                .padding(start = 23.dp, end = 23.dp)
                .shadow(elevation = 8.dp, RoundedCornerShape(30.dp))
                .clip(RoundedCornerShape(30.dp)),
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    modifier = Modifier
                        .pagerTabIndicatorOffset(pagerState, tabPositions)
                        .width(0.dp)
                        .height(0.dp)
                )
            },
            divider = {}
        ) {
            tabItems.forEachIndexed { index, tabItem ->

                val color = tabColors[index]


                LaunchedEffect(pagerState.currentPage) {
                    color.animateTo(if (pagerState.currentPage == index) Primary else tabItemColors)
                }

                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        change()
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(
                            text = tabItem.title,
                            style = TextStyle(
                                color = if (pagerState.currentPage == index) Color.White else colors(
                                    Color.Black,
                                    Color.White
                                ),
                                fontSize = 16.sp,
                                lineHeight = 22.sp,
                                fontFamily = roboto_medium
                            )
                        )
                    },
                    modifier = Modifier.background(
                        color = color.value,

                        shape = RoundedCornerShape(30.dp)
                    )
                )
            }
        }

        HorizontalPager(
            count = tabItems.size,
            state = pagerState,
            modifier = modifier
        ) { page ->
            Box(modifier = Modifier.fillMaxSize()) {
                tabItems[page].screen()
            }
        }
    }
}