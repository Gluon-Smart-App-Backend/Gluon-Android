package com.gluon.gluonapp.ui.feature.account_feature


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gluon.gluonapp.R
import com.gluon.gluonapp.ui.components.AppScaffold
import com.gluon.gluonapp.ui.components.text.MultiClickableText
import com.gluon.gluonapp.ui.components.button.BlueButton
import com.gluon.gluonapp.ui.components.otp.Otp
import com.gluon.gluonapp.ui.theme.BlueColor
import com.gluon.gluonapp.ui.theme.RedColor
import com.gluon.gluonapp.ui.theme.colors
import com.gluon.gluonapp.ui.theme.roboto_regular

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtpScreen(navController: NavController) {

    var error by remember {
        mutableStateOf(false)
    }
    var success by remember {
        mutableStateOf(false)
    }
    AppScaffold(isBackPress = true, navController = navController) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,

            modifier = Modifier
                .fillMaxSize()

                .padding(top = 84.dp, start = 23.dp, end = 23.dp),
        ) {

            Image(
                painter = painterResource(R.drawable.app_icon_image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .width(160.dp)
                    .height(160.dp)

            )
            Spacer(modifier = Modifier.size(60.dp))

            Text(
                text = stringResource(R.string.otp_title),
                fontSize = 20.sp,
                lineHeight = 16.sp,
                fontFamily = roboto_regular,
                color = colors(Color.Black, Color.White),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.size(16.dp))

            Text(
                text = "Enter the code sent to XX XXX XXX ",
                fontSize = 12.sp,
                lineHeight = 20.sp,
                fontFamily = roboto_regular,
                color = colors(Color.Black, Color.White),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )




            Spacer(modifier = Modifier.size(42.dp))

            Otp(
                error = error,
                success = success,

                unFocusedColor = BlueColor,

                onFinish = { otp ->
                    if (otp == "1234") {
                        success = true
                        error = false
                    } else {
                        success = false
                        error = true
                    }
                })
            Spacer(modifier = Modifier.size(28.dp))
            MultiClickableText(
                isEndTextClickable = true,
                onEndTextClick = { //Log.e("otpSender","code send to email")
                     },
                fontSize = 12.sp,
                lineHeight = 16.sp,
                startTxtFont =roboto_regular ,
                endTxtColor = RedColor,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = stringResource(R.string.otp_txtBtn),

                )



            Spacer(modifier = Modifier.size(28.dp))

            BlueButton(stringResource(R.string.otp_btn)){
                //navController.navigate(UserIdScreen)
            }




        }
    }
}