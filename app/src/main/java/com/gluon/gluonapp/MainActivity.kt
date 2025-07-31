package com.gluon.gluonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.gluon.gluonapp.ui.screens.App
import com.gluon.gluonapp.ui.theme.GluonAppTheme

class MainActivity : ComponentActivity() {
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