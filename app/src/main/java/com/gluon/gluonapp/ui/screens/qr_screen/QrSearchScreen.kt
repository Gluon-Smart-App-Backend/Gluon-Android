package com.gluon.gluonapp.ui.screens.qr_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavController
import com.gluon.gluonapp.R
import com.gluon.gluonapp.ui.components.AppScaffold
import com.gluon.gluonapp.ui.components.button.BlueButton
import com.gluon.gluonapp.ui.components.textField.CustomSearchField
import com.gluon.gluonapp.ui.components.textField.CustomTextField
import com.gluon.gluonapp.ui.theme.GreyColor400
import com.gluon.gluonapp.ui.theme.GreyScale700
import com.gluon.gluonapp.ui.theme.cardBlueColor
import com.gluon.gluonapp.ui.theme.cardBlueNightColor
import com.gluon.gluonapp.ui.theme.colors
import com.gluon.gluonapp.ui.theme.roboto_regular
import com.gluon.gluonapp.ui.theme.roboto_semi_bold

import com.gluon.gluonapp.utils.extensions.backgroundColors


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QrSearchScreen(
    navController: NavController,
) {

    var fiscalID by remember { mutableStateOf("") }
    AppScaffold(navController = navController, isBackPress = true) {
        Column(


            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp)
                .padding(horizontal = 23.dp)


        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp),

                modifier = Modifier
                    .clip(shape = RoundedCornerShape(size = 16.dp))
                    .backgroundColors(cardBlueColor, cardBlueNightColor)
                    .width(347.dp)
                    .height(140.dp)
                    .padding(vertical = 16.dp)
            ) {
                Text(
                    text = "Add to Ficsal ID",
                    fontSize = 20.sp,
                    lineHeight = 22.sp,
                    fontFamily = roboto_semi_bold,
                    color = colors(Color.Black, Color.White),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,


                    )

                Text(
                    text = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
                    fontSize = 16.sp,
                    fontFamily = roboto_regular,
                    color = colors(GreyScale700, GreyColor400),
                    modifier = Modifier.width(311.dp),
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            CustomSearchField(
                value = fiscalID,
                onValueChange = { fiscalID = it },
                hint = "Fiscal ID",
                text = "",
                modifier = Modifier.align(Alignment.Start),
                icon = ImageVector.vectorResource(id = R.drawable.ic_info)
            )
            Spacer(modifier = Modifier.height(324.dp))
            BlueButton("Search") {

            }

        }


    }
}