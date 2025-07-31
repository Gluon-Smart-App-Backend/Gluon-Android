package com.gluon.gluonapp.ui.components.text

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.gluon.gluonapp.ui.theme.colors
import com.gluon.gluonapp.ui.theme.roboto_light
import com.gluon.gluonapp.ui.theme.roboto_medium


@Composable
fun MultiClickableText(
    text:String="",
    textAlign: TextAlign = TextAlign.Start,
    fontSize: TextUnit =22.sp,
    lineHeight: TextUnit =33.sp,
    modifier: Modifier = Modifier,
    startTxtColor: Color? = null,
    startTxtFont: FontFamily = roboto_light,
    startTxtFontWeight: FontWeight = FontWeight.Normal,
    endTxtColor: Color? = null,
    endTxtFont: FontFamily = roboto_medium,
    endTextFontWeight: FontWeight = FontWeight.Bold,
    isEndTextClickable: Boolean = false,
    onEndTextClick: () -> Unit = {}

){
    val finalStartColor = startTxtColor ?: colors(Color.Black, Color.White)
    val finalEndColor = endTxtColor ?: colors(Color.Black, Color.White)



    val parts = text.split("\n")
    val startText = parts.getOrNull(0) ?: ""
    val endText = parts.getOrNull(1) ?: ""

    val annotatedText = buildAnnotatedString {
        withStyle(
            SpanStyle(
                color = finalStartColor,
                fontFamily = startTxtFont,
                fontWeight = startTxtFontWeight
            )
        ) {
            append(startText)
        }


        withStyle(
            SpanStyle(
                color = finalEndColor,
                fontFamily = endTxtFont,
                fontWeight = endTextFontWeight,

            )
        ) {
            append(endText)
        }


    }

    ClickableText(
        text = annotatedText,
        onClick = { offset ->
            if (!isEndTextClickable) return@ClickableText onEndTextClick()


        },
        style = TextStyle(fontSize = fontSize, lineHeight = lineHeight, textAlign = textAlign),
        modifier = modifier
    )

}