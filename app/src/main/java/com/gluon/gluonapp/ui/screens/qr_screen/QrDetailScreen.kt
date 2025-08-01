package com.gluon.gluonapp.ui.screens.qr_screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gluon.gluonapp.R
import com.gluon.gluonapp.ui.components.AppScaffold
import com.gluon.gluonapp.ui.theme.DarkWhite
import com.gluon.gluonapp.ui.theme.LightBlack
import com.gluon.gluonapp.ui.theme.Primary
import com.gluon.gluonapp.ui.theme.colors
import com.gluon.gluonapp.ui.theme.roboto_light
import com.gluon.gluonapp.ui.theme.roboto_medium
import com.gluon.gluonapp.ui.theme.roboto_regular


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QrDetailScreen(
    navController: NavController,
) {
    var username =remember { mutableStateOf("Lui Smith") }
    var bio =remember { mutableStateOf("") }





    val items = listOf("team work", "team work", "team work")



    AppScaffold(navController = navController, isBackPress = true) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp)


        ) {



            Card(
                shape = RoundedCornerShape(50.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                colors = CardDefaults.cardColors(
                    containerColor = colors(Color.White, LightBlack),
                    contentColor = Color.Black
                ),
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .width(350.dp)
                    .height(460.dp)

            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),

                    ) {
                    Row(

                        modifier = Modifier

                            .fillMaxWidth()
                            .height(230.dp),


                        ) {
                        Column(
                            verticalArrangement = Arrangement.Top,
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 38.dp, top = 28.dp),

                            ) {
                            Text(
                                text = username.value,
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    lineHeight = 22.sp,
                                    fontFamily = roboto_medium,
                                    fontWeight = FontWeight(700),
                                    color = colors(Color.Black, Color.White),

                                    )
                            )
                            Text(
                                text = "Entrepreneur",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    lineHeight = 22.sp,
                                    fontFamily = roboto_medium,
                                    fontWeight = FontWeight(500),
                                    color = colors(Color.Black, Color.White),

                                    )
                            )
                            Text(
                                text = "website URL: https//.....",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    lineHeight = 22.sp,
                                    fontFamily = roboto_light,
                                    fontWeight = FontWeight(400),
                                    color = colors(Color(0x99000000), DarkWhite),

                                    )
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                items(items.chunked(2)) { rowItems ->
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(2.dp),
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        for (item in rowItems) {
                                            Box(
                                                modifier = Modifier
                                                    .weight(1f)
                                                    .height(32.dp)
                                                    .clip(RoundedCornerShape(12.dp))
                                                    .background(
                                                        color = Color(0xFFF5F5F5),
                                                        shape = RoundedCornerShape(size = 30.dp)
                                                    ),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Text(
                                                    text = item,
                                                    textAlign = TextAlign.Center,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        lineHeight = 16.sp,
                                                        fontFamily = roboto_regular,
                                                        fontWeight = FontWeight(400),
                                                        color = Color(0xFF333333),

                                                        )
                                                )
                                            }
                                        }


                                        if (rowItems.size < 2) {
                                            Spacer(modifier = Modifier.weight(1f))
                                        }
                                    }
                                }
                            }


                        }
                        Column(
                            verticalArrangement = Arrangement.Bottom,
                            modifier = Modifier

                                .padding(start = 16.dp, top = 8.dp),

                            ) {
                            Image(

                                painter = painterResource(id = R.drawable.img),
                                contentDescription = "Sample Image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(130.dp)
                                    .align(Alignment.End),
                            )

                        }


                    }

                    Column(
                        verticalArrangement = Arrangement.Top,

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(230.dp)
                            .clip(
                                RoundedCornerShape(
                                    bottomStart = 50.dp,
                                    bottomEnd = 50.dp,
                                    topStart = 50.dp,
                                    topEnd = 0.dp
                                )
                            )
                            .background(Color(0xFF1A73E8)),

                        ) {


                        Row(

                            modifier = Modifier

                                .fillMaxWidth()
                                .height(230.dp),


                            ) {

                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .fillMaxHeight()

                                    .padding(start = 38.dp, top = 25.dp),

                                ) {
                                Image(

                                    painter = painterResource(id = R.drawable.img_1),
                                    contentDescription = "Sample Image",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.size(140.dp),
                                )

                            }
                            Column(
                                verticalArrangement = Arrangement.Top,
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(start = 21.dp, top = 20.dp),

                                ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                                ) {
                                    Icon(
                                        imageVector = ImageVector.vectorResource(R.drawable.ic_copy),
                                        contentDescription = "Favorite Icon",
                                        tint = Color.Unspecified
                                    )
                                    Icon(
                                        imageVector = ImageVector.vectorResource(R.drawable.ic_share),
                                        contentDescription = "Favorite Icon",
                                        tint = Color.Unspecified
                                    )
                                    Icon(
                                        imageVector = ImageVector.vectorResource(R.drawable.ic_dots),
                                        contentDescription = "Favorite Icon",
                                        tint = Color.Unspecified
                                    )

                                }
                                Spacer(modifier = Modifier.height(16.dp))
                                Column(modifier = Modifier.height(114.dp)) {
                                    Text(
                                        text = "Personal Data",
                                        style = TextStyle(
                                            fontSize = 14.sp,
                                            lineHeight = 22.sp,
                                            fontFamily = roboto_regular,
                                            fontWeight = FontWeight(500),
                                            color = Color(0xFFFFFFFF),

                                            )
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = "ID Number",
                                        style = TextStyle(
                                            fontSize = 14.sp,
                                            lineHeight = 22.sp,
                                            fontFamily = roboto_regular,
                                            fontWeight = FontWeight(500),
                                            color = Color(0xFFFFFFFF),

                                            )
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = "311097152",
                                        style = TextStyle(
                                            fontSize = 14.sp,
                                            lineHeight = 22.sp,
                                            fontFamily = roboto_regular,
                                            fontWeight = FontWeight(500),
                                            color = Color(0xFFFFFFFF),

                                            )
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = "Location",
                                        style = TextStyle(
                                            fontSize = 14.sp,
                                            lineHeight = 22.sp,
                                            fontFamily = roboto_regular,
                                            fontWeight = FontWeight(500),
                                            color = Color(0xFFFFFFFF),

                                            )
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = "Baku,Azerbaijan.",
                                        style = TextStyle(
                                            fontSize = 14.sp,
                                            lineHeight = 22.sp,
                                            fontFamily = roboto_regular,
                                            fontWeight = FontWeight(500),
                                            color = Color(0xFFFFFFFF),

                                            )
                                    )
                                }


                            }


                        }

                    }
                }
            }
            Spacer(modifier = Modifier.height(80.dp))
            Button(
                onClick = {
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Primary,
                    contentColor = Color.White

                ),

                modifier = Modifier

                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 20.dp)
            ) {
                Text(
                    text = "Connect",
                    fontSize = 16.sp,
                    lineHeight = 36.2.sp,
                    fontFamily = roboto_medium,
                )

            }

        }
    }
}





