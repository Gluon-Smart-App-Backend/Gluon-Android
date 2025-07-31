package com.gluon.gluonapp.ui.components.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.gluon.gluonapp.ui.theme.Primary
import com.gluon.gluonapp.ui.theme.roboto_medium

@Composable
fun BlueButton(
   text:String,
   modifier: Modifier = Modifier.fillMaxWidth(),
   fontSize:TextUnit = 16.sp,
   lineHeight:TextUnit =36.2.sp,
   fontFamily: FontFamily = roboto_medium,
   onClick:(()-> Unit)? = null
){
    Button(
        onClick = {
            onClick?.invoke()

        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Primary,
            contentColor = Color.White

        ),

        modifier = modifier
    ) {
        Text(
            text = text,
            fontSize = fontSize,
            lineHeight = lineHeight,
            fontFamily = fontFamily,
        )

    }

}