package com.gluon.gluonapp.ui.components.textField


import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.flowlayout.FlowRow
import com.gluon.gluonapp.R
import com.gluon.gluonapp.ui.theme.BlackLight
import com.gluon.gluonapp.ui.theme.GreyColorLight
import com.gluon.gluonapp.ui.theme.GreyColorLight30
import com.gluon.gluonapp.ui.theme.WhiteColor
import com.gluon.gluonapp.ui.theme.colors
import com.gluon.gluonapp.ui.theme.roboto_regular
import com.gluon.gluonapp.utils.validation.validateEmail
import com.gluon.gluonapp.utils.validation.validatePassword


@ExperimentalMaterial3Api
@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    text:String,
    isEmail:Boolean=false,
    isPassword:Boolean=false,
    modifier: Modifier =Modifier,
    icon: ImageVector? = null
) {
    var passwordHidden by remember { mutableStateOf(true) }
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    val passwordValidation = if (isPassword && value.isNotEmpty()) validatePassword(value) else emptyList()

    val emailValidation =  if (isEmail && value.isNotEmpty()) validateEmail(value) else null

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
                    icon != null -> Icon(imageVector = icon, contentDescription = null, tint = colors(Color.Black, WhiteColor), modifier = Modifier.size(24.dp))
                    isPassword -> Icon(
                        imageVector = ImageVector.vectorResource(id = if (passwordHidden) R.drawable.ic_eye_off else R.drawable.ic_eye),
                        contentDescription = null,
                        tint = colors(Color.Black, WhiteColor),
                        modifier = Modifier
                            .size(24.dp)
                            .clickable { passwordHidden = !passwordHidden }
                    )
                }
            }

        },
        visualTransformation = when {
            !isPassword -> VisualTransformation.None
            passwordHidden -> PasswordVisualTransformation()
            else -> VisualTransformation.None
        },
        singleLine = true,
        shape = RoundedCornerShape(50.dp),
        interactionSource = interactionSource,
        modifier = Modifier

            .fillMaxWidth()

            .height(56.dp)



            .then(


                if (!isFocused) Modifier.shadow(2.dp, RoundedCornerShape(50.dp)).clip(RoundedCornerShape(50.dp))
                else Modifier.border(width = 0.5.dp, color = Color(0x331A73E8), shape = RoundedCornerShape(size = 50.dp)).shadow(3.dp, RoundedCornerShape(50.dp)).clip(RoundedCornerShape(50.dp))




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

    if (emailValidation != null && !emailValidation.second){
        Spacer(modifier = Modifier.height(4.dp))
        Column(modifier =modifier.padding(  start = 10.dp)) {
            Text(
                text = emailValidation.first,
                color = Color.Red,
                fontSize = 12.sp
            )
        }
    }
    if ( passwordValidation.isNotEmpty() && value.isNotEmpty()) {
        Spacer(modifier = Modifier.height(4.dp))
        Column (modifier =modifier.padding( top = 8.dp)) {

            ErrorMessages(passwordValidation)
        }
    }




}
@Composable
fun ErrorMessages(validations: List<Pair<String, Boolean>>) {
    FlowRow(
        mainAxisSpacing = 8.dp,
        crossAxisSpacing = 6.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        validations.forEach { (message, isValid) ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 6.dp, end = 8.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_check_yellow),
                    contentDescription = "Error",
                    tint = if (isValid)Color.Unspecified else Color.Red,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = message,
                    color = colors(Color.Black,Color.White),
                    fontSize = 12.sp
                )
            }
        }
    }
}






