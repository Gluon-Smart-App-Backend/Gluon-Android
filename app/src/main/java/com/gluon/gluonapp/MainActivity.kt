package com.gluon.gluonapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gluon.gluonapp.navigation.AccountScreen
import com.gluon.gluonapp.navigation.ChooseLangScreen
import com.gluon.gluonapp.navigation.OnBoardingScreen
import com.gluon.gluonapp.navigation.OtpScreen
import com.gluon.gluonapp.navigation.QrDetailScreen
import com.gluon.gluonapp.navigation.QrScanScreen
import com.gluon.gluonapp.navigation.QrSearchScreen
import com.gluon.gluonapp.navigation.UserIdScreen
import com.gluon.gluonapp.ui.screens.App
import com.gluon.gluonapp.ui.screens.account_screen.AccountScreen
import com.gluon.gluonapp.ui.screens.account_screen.ChooseLangScreen
import com.gluon.gluonapp.ui.screens.account_screen.OnboardingScreen
import com.gluon.gluonapp.ui.screens.account_screen.OtpScreen
import com.gluon.gluonapp.ui.screens.account_screen.UserIdScreen
import com.gluon.gluonapp.ui.screens.qr_screen.QrDetailScreen
import com.gluon.gluonapp.ui.screens.qr_screen.QrScanScreen
import com.gluon.gluonapp.ui.screens.qr_screen.QrSearchScreen
import com.gluon.gluonapp.ui.theme.GluonAppTheme
import com.google.accompanist.pager.ExperimentalPagerApi

class MainActivity : ComponentActivity() {


    @OptIn(ExperimentalPagerApi::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContent {

            GluonAppTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxSize()
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = OnBoardingScreen
                    ) {

                        composable<OnBoardingScreen> {

                            OnboardingScreen(navController = navController)
                        }

                        composable<ChooseLangScreen> {

                            ChooseLangScreen(navController = navController)
                        }
                        composable<AccountScreen> {

                            AccountScreen(navController = navController)
                        }
                        composable<OtpScreen> {

                            OtpScreen(navController = navController)
                        }
                        composable<UserIdScreen> {

                            UserIdScreen(navController = navController)
                        }
                        composable<QrScanScreen> {

                            QrScanScreen(navController = navController)
                        }
                        composable<QrDetailScreen> {

                            QrDetailScreen(navController = navController)
                        }
                        composable<QrSearchScreen> {

                            QrSearchScreen(navController = navController)
                        }



                    }
                }
            }
        }
    }





//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            GluonAppTheme {
//                App()
//            }
//        }
//    }
}