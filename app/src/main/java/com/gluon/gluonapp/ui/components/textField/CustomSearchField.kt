package com.gluon.gluonapp.ui.components.textField

import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gluon.gluonapp.ui.theme.BlackLight
import com.gluon.gluonapp.ui.theme.GreyColorLight
import com.gluon.gluonapp.ui.theme.GreyColorLight30
import com.gluon.gluonapp.ui.theme.WhiteColor
import com.gluon.gluonapp.ui.theme.colors
import com.gluon.gluonapp.ui.theme.roboto_regular


@ExperimentalMaterial3Api
@Composable
fun CustomSearchField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    text:String,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()



    Text(
        text = text,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = roboto_regular,
        color = colors(Color.Black, Color.White),
        modifier = modifier
            .padding(bottom = 4.dp, top = 8.dp, start = 10.dp)
    )


    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = hint) },
        trailingIcon = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(end = 16.dp)
            ) {
                when {
                    icon != null -> Icon(imageVector = icon, contentDescription = null, tint = colors(
                        Color.Black, WhiteColor
                    ), modifier = Modifier.size(24.dp))

                }
            }

        },
        visualTransformation = VisualTransformation.None,
        singleLine = true,
        shape = RoundedCornerShape(50.dp),
        interactionSource = interactionSource,
        modifier = Modifier

            .fillMaxWidth()

            .height(56.dp)



            .then(


                if (!isFocused) Modifier.shadow(2.dp, RoundedCornerShape(50.dp)).clip(
                    RoundedCornerShape(50.dp)
                )
                else Modifier.border(width = 0.5.dp, color = Color(0x331A73E8), shape = RoundedCornerShape(size = 50.dp)).shadow(3.dp, RoundedCornerShape(50.dp)).clip(
                    RoundedCornerShape(50.dp)
                )




            ),

        colors = TextFieldDefaults.colors(
            focusedContainerColor = colors(GreyColorLight30, GreyColorLight),
            unfocusedContainerColor = colors(Color.White, BlackLight),
            disabledContainerColor = Color.Transparent,
            errorContainerColor = Color.Transparent,
            focusedLabelColor = Color.Transparent,
            cursorColor = MaterialTheme.colorScheme.primary,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )






}