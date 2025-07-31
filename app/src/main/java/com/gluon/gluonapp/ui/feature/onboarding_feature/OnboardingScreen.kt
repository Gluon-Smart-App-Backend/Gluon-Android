package com.gluon.gluonapp.ui.feature.onboarding_feature


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gluon.gluonapp.R
import com.gluon.gluonapp.navigation.ChooseLangScreen

import com.gluon.gluonapp.ui.components.AppScaffold
import com.gluon.gluonapp.ui.components.button.BlueButton
import com.gluon.gluonapp.ui.theme.GreyColor400
import com.gluon.gluonapp.ui.theme.GreyScale700
import com.gluon.gluonapp.ui.theme.colors
import com.gluon.gluonapp.ui.theme.roboto_bold
import com.gluon.gluonapp.ui.theme.roboto_medium


@Composable
fun OnboardingScreen(
    navController: NavController,
) {
    AppScaffold(navController) {
        Column(
            modifier = Modifier
                .fillMaxSize()

                .padding(top = 220.dp, start = 23.dp, end = 23.dp),
        ) {
            Column(
                modifier = Modifier
                    .heightIn(516.dp)
                    .widthIn(347.dp),
                horizontalAlignment = Alignment.CenterHorizontally
                //verticalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(R.drawable.app_icon_image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(160.dp)
                        .height(160.dp)

                )
                Spacer(modifier = Modifier.size(48.dp))
                Text(
                    text = stringResource(R.string.onboarding_title),
                    fontSize = 40.sp,
                    lineHeight = 56.sp,
                    fontFamily = roboto_bold,
                    color = colors(Color.Black, Color.White),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = stringResource(R.string.onboarding_subtitle),
                    fontSize = 18.sp,
                    lineHeight = 32.4.sp,
                    fontFamily = roboto_medium,
                    color = colors(GreyScale700, GreyColor400),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.size(48.dp))

                BlueButton(
                    stringResource(R.string.onboarding_btn_text),
                    modifier = Modifier
                        .width(304.dp)
                        .height(54.dp)
                ) {
                    navController.navigate(ChooseLangScreen)

                }



            }


        }
    }

}

@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    val navController = rememberNavController()
    OnboardingScreen(navController)

}