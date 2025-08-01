package com.gluon.gluonapp.ui.components.otp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.sp
import com.gluon.gluonapp.model.OtpValue
import com.gluon.gluonapp.utils.extensions.each
import com.gluon.gluonapp.ui.theme.BlueColor
import com.gluon.gluonapp.ui.theme.BlueLight
import com.gluon.gluonapp.ui.theme.colors
import com.gluon.gluonapp.utils.Spacer


@Composable
fun Otp(
    modifier: Modifier = Modifier,
    count: Int = 4,
    onOtpChange: (value: String, finished: Boolean) -> Unit = { _, _ -> },
    onFinish: (String) -> Unit = {},
    error: Boolean = false,
    success: Boolean = false,
    errorColor: Color = Color(0xFFFF6161),
    successColor: Color = Color(0xFF29B96F),
    focusedColor:Color = colors(BlueLight,Color.White),
    cursorColor: Color = BlueColor,
    unFocusedColor:Color = Color.Gray,
    textStyle: TextStyle = TextStyle(
        fontSize = 13.sp, textAlign = TextAlign.Center, color=colors(Color.Black,Color.White)
    ),
) {

    val otpState = remember {
        mutableStateListOf(
            *MutableList(count) {
                OtpValue(focused = it == 0)
            }.toTypedArray()
        )
    }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            count.each {
                Spacer.SmallSpacer(true)
                OtpBox(
                    textStyle = textStyle,
                    unFocusedColor = unFocusedColor,
                    focusedColor = focusedColor,
                    cursorColor = cursorColor,
                    otpValue = otpState[it],
                    onValueChange = { newValue ->
                        if (otpState[it].value != newValue) {
                            if (newValue.length <= 1) {
                                otpState[it] = otpState[it].copy(value = newValue)
                                if (newValue.length == 1) {
                                    if (otpState.size - 1 > it) {
                                        otpState[it + 1].focusRequester?.requestFocus()
                                    }
                                }
                            }
                            var otp = ""
                            otpState.forEach {
                                otp += it.value
                            }
                            if (otp.length >= count)
                                onFinish(otp)
                            onOtpChange(otp, otp.length >= count)
                        }

                    },
                    onFocusChanged = { focused ->
                        otpState[it] = otpState[it].copy(focused = focused)
                    },
                    onFocusSet = { focus ->
                        otpState[it] = otpState[it].copy(focusRequester = focus)
                    },
                    onBackSpace = {
                        if (otpState[it].value.isEmpty()) {
                            if (it != 0) {
                                otpState[it - 1].focusRequester?.requestFocus()
                            }
                        }
                    },
                    error = error,
                    success = success,
                    modifier = modifier,
                    errorColor = errorColor,
                    successColor = successColor
                )
                Spacer.SmallSpacer(true)
            }
        }
    }
}