package com.gluon.gluonapp.ui.screens.account_screen


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gluon.gluonapp.R
import com.gluon.gluonapp.ui.components.AppScaffold
import com.gluon.gluonapp.ui.components.button.BlueButton
import com.gluon.gluonapp.ui.components.text.MultiStyleText
import com.gluon.gluonapp.ui.theme.GreyColor300

import com.gluon.gluonapp.ui.theme.colors
import com.gluon.gluonapp.ui.theme.painterResources
import com.gluon.gluonapp.ui.theme.roboto_medium
import com.gluon.gluonapp.ui.theme.roboto_regular
import com.gluon.gluonapp.ui.theme.roboto_semi_bold

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)

@Composable
fun UserIdScreen(navController: NavController) {


    AppScaffold(navController) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

            modifier = Modifier
                .fillMaxSize()


                .padding(start = 23.dp, end = 23.dp),
        ) {

            MultiStyleText(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "Hello \nAllienz !",
                fontSize = 24.sp,
                lineHeight = 40.sp,
            )
            MultiStyleText(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "Welcome to \nGluonChat",
                fontSize = 24.sp,
                lineHeight = 40.sp,
            )



            Spacer(modifier = Modifier.size(32.dp))

            Column(
                modifier = Modifier
                    .size(347.dp)
                    .paint(
                        painter = painterResources(
                            R.drawable.img_back_logo,
                            R.drawable.img_back_logo_night,
                        ),
                        contentScale = ContentScale.Crop // və ya Fit, FillBounds, Inside
                    )
            ) {
                Spacer(modifier = Modifier.size(100.dp))
                Text(
                    text = "Your ID number",
                    fontSize = 24.sp,
                    lineHeight = 16.sp,
                    fontFamily = roboto_medium,
                    color = colors(Color.Black, GreyColor300),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.size(40.dp))

                Text(
                    text = "146380",
                    fontSize = 40.sp,
                    lineHeight = 40.sp,
                    fontFamily = roboto_semi_bold,
                    color = colors(Color.Black, GreyColor300),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.size(46.dp))
                Text(
                    text = "You can share with your friends and connect each other",
                    fontSize = 16.sp,
                    lineHeight = 22.sp,
                    fontFamily = roboto_regular,
                    color = colors(Color.Black, GreyColor300),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

            }





            BlueButton("Share") {
               // navController.navigate(com.novation.gluon.navigation.UserIdScreen)
            }

            TextButton(
                onClick = {// navController.navigate(PlanScreen)
                },
                colors = ButtonDefaults.textButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(0.dp),
                modifier = Modifier.padding(0.dp)
            ) {
                Text(
                    text = "Next",
                    fontSize = 16.sp,
                    lineHeight = 22.sp,
                    color = colors(Color.Black, GreyColor300),
                    fontWeight = FontWeight.Normal,
                    fontFamily = roboto_medium
                )
            }


        }
    }


}