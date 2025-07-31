package com.gluon.gluonapp.ui.feature.account_feature

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gluon.gluonapp.R
import com.google.accompanist.pager.ExperimentalPagerApi

import com.gluon.gluonapp.ui.components.AppScaffold
import com.gluon.gluonapp.ui.components.button.BlueButton
import com.gluon.gluonapp.ui.components.tabs.CustomTabLayout
import com.gluon.gluonapp.ui.components.tabs.TabItem
import com.gluon.gluonapp.ui.components.textField.CustomTextField
import com.gluon.gluonapp.ui.theme.GreyColor300
import com.gluon.gluonapp.ui.theme.colors
import com.gluon.gluonapp.ui.theme.roboto_regular
import com.gluon.gluonapp.ui.theme.roboto_semi_bold


@ExperimentalPagerApi
@Composable
fun AccountScreen(navController: NavController){


    val tabs = listOf(
        TabItem("Sign Up") { RegisterScreen(navController) },
        TabItem("Login") { LoginScreen(navController) },

    )

    val isChangeText = remember { mutableStateOf(true) }
    val title =   remember { mutableStateOf("Get Started Now ") }
    val subtitle =   remember { mutableStateOf("Create an acccount to explore about our app") }

    AppScaffold(navController, isBackPress = true) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,

            modifier = Modifier
                .fillMaxSize()

                .padding(top = 82.dp),
        ) {


            Text(
                text = title.value,
                fontSize = 26.sp,
                lineHeight = 16.sp,
                fontFamily = roboto_semi_bold,
                color = colors(Color.Black,Color.White),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.size(14.dp))

            Text(
                text = subtitle.value,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontFamily = roboto_regular,
                color = colors(Color.Black,GreyColor300),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.size(32.dp))
            CustomTabLayout(navController,Modifier.fillMaxSize(),tabs){
                title.value=""
                if (isChangeText.value==true){
                    isChangeText.value=false
                    title.value="Hello Again !"
                    subtitle.value="Welcome back You've been missed"

                }else{
                    isChangeText.value=true
                    title.value="Get Started Now "
                    subtitle.value="Create an acccount to explore about our app"

                }
            }








        }

    }

}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavController){
    val scrollState = rememberScrollState()
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.verticalScroll(scrollState).imePadding() .padding(start = 23.dp, end = 23.dp)) {
        var email by remember { mutableStateOf("") }
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }


        CustomTextField(
            value = username,
            onValueChange = { username = it },
            hint = "",
            isEmail = false,
            isPassword = false,
            modifier = Modifier.align(Alignment.Start),
            text = "Full Name"

        )

        CustomTextField(
            value = email,
            isEmail = true,
            onValueChange = { email = it },
            hint = "",
            text = "Email",
            modifier = Modifier.align(Alignment.Start),
            icon = ImageVector.vectorResource(id = R.drawable.ic_message)
        )
        CustomTextField(
            value = password,
            onValueChange = { password = it },
            hint = "",
            isPassword = true,
            text = "Password",
            modifier = Modifier.align(Alignment.Start),
        )


        Spacer(modifier = Modifier.size(20.dp))
        BlueButton("Sign Up"){
          //  navController.navigate(OtpScreen)
        }




    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController){
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier .padding(start = 23.dp, end = 23.dp)) {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        CustomTextField(
            value = email,
            onValueChange = { email = it },
            hint = "",
            text = "Email",
            isEmail = true,
            modifier = Modifier.align(Alignment.Start),
            icon = ImageVector.vectorResource(id = R.drawable.ic_message)
        )
        CustomTextField(
            value = password,
            isPassword = true,
            onValueChange = { password = it },
            hint = "",
            text = "Password",
            modifier = Modifier.align(Alignment.Start),
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {


            Text(
                text = "Forgot Password?",
                fontSize = 14.sp,
                color = Color(0xFF1976D2),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = LocalIndication.current
                    ) {

                    }
            )
        }
        Spacer(modifier = Modifier.size(10.dp))
        BlueButton("Login"){
            //navController.navigate(UserIdScreen)
        }



    }
}

