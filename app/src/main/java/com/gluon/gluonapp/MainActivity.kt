package com.gluon.gluonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.gluon.gluonapp.ui.screens.App
import com.gluon.gluonapp.ui.theme.GluonAppTheme

class MainActivity : ComponentActivity() {
    /*
    *  @OptIn(ExperimentalPagerApi::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContent {

            GluonTheme {
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



                    }
                }
            }
        }
    }
    * */




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GluonAppTheme {
                App()
            }
        }
    }
}