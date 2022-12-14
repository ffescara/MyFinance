package com.ffescara.myfinance

import android.annotation.SuppressLint
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScreenCategory(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = colorResource(id = R.color.white),
            contentColor = colorResource(id = R.color.black)
        ) {
            //bisa tambah icon
            Text(
                text = "Category",
                fontSize = 24.sp
            )
        }
    },
        bottomBar = { BottomNavigation(navController = navController)}
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            var category by remember { mutableStateOf(TextFieldValue()) }

            OutlinedTextField(
                value = category,
                onValueChange = {category = it},
                label = { Text("Category")}
            )

            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    navController.navigate(NavRoute.screen_category.name)
                },
                modifier = Modifier
                    .width(280.dp)
                    .height(50.dp)
            ) {
                Text(text = "Add")
            }

        }

    }

}

@Preview(showSystemUi = true, showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ScreenCategoryPreview() {
    ScreenCategory(rememberNavController())
}