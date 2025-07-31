package com.gluon.gluonapp.ui.feature.language_feature

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gluon.gluonapp.R
import com.gluon.gluonapp.model.LanguageModel
import com.gluon.gluonapp.navigation.AccountScreen

import com.gluon.gluonapp.ui.components.AppScaffold
import com.gluon.gluonapp.ui.components.button.BlueButton
import com.gluon.gluonapp.ui.components.text.MultiStyleText
import com.gluon.gluonapp.ui.theme.BlackLight
import com.gluon.gluonapp.ui.theme.GreyColor300
import com.gluon.gluonapp.ui.theme.GreyScale
import com.gluon.gluonapp.ui.theme.Primary
import com.gluon.gluonapp.ui.theme.colors
import com.gluon.gluonapp.ui.theme.poppins_medium
import com.gluon.gluonapp.ui.theme.roboto_medium
import com.gluon.gluonapp.ui.theme.roboto_regular


@Composable
fun ChooseLangScreen(navController: NavController) {
    val languages = listOf(
        LanguageModel("English", "United Kingdom"),
        LanguageModel("English", "United States"),
        LanguageModel("Azerbaijani", "Azərbaycan dili"),
        LanguageModel("Turkish", "Türkçe"),
        LanguageModel("Russian", "Русский"),
        LanguageModel("Japanese", "日本語"),
        LanguageModel("Spanish", "Español"),
    )

    var selectedLangName by remember { mutableStateOf<String?>(languages[0].lngNameTr) }


    AppScaffold(navController){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp, start = 23.dp, end = 23.dp, bottom = 50.dp),
        ) {
            MultiStyleText(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = stringResource(R.string.language_screen_title),

                )

            Text(
                text = stringResource(R.string.language_screen_subtitle),
                fontSize = 12.sp,
                lineHeight = 18.sp,
                color = colors(GreyScale, GreyColor300),
                fontFamily = poppins_medium,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.size(32.dp))
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(504.dp)
                //.padding(start = 23.dp, end = 23.dp)
            ) {
                items(languages) { item ->
                    ItemLang(
                        data = item,
                        isSelected = item.lngNameTr ==selectedLangName ,
                        onClick = { selectedLangName = item.lngNameTr }
                    )
                }
            }
            Spacer(modifier = Modifier.size(26.dp))


            BlueButton("Continue"
            ){
                navController.navigate(AccountScreen)
            }



        }
    }

}





@Composable
fun ItemLang(data: LanguageModel,isSelected: Boolean,onClick: () -> Unit) {



    val textColor = if (isSelected) Primary else null

    Card(
        colors = CardDefaults.cardColors(containerColor =  colors(Color.White, BlackLight)),
        shape = RoundedCornerShape(50),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .padding(top = 8.dp, bottom = 8.dp)
            .height(56.dp)
            .fillMaxWidth()
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                onClick()

            }
    ) {
        Box(
            modifier = Modifier.fillMaxSize().padding(start = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            MultiStyleText(
                text = "${data.lngName} | \n${data.lngNameTr}",
                fontSize = 16.sp,
                lineHeight = 20.sp,
                startTxtFontWeight = FontWeight.Bold,
                startTxtFont = roboto_medium,
                endTxtFont = roboto_regular,
                endTextFontWeight = FontWeight.Normal,
                startTxtColor = textColor,
                endTxtColor = textColor
            )
        }
    }


}
@Preview(showBackground = true)
@Composable
fun ChooseLangScreenPreview(){
    val navController = rememberNavController()
    ChooseLangScreen(navController)

}