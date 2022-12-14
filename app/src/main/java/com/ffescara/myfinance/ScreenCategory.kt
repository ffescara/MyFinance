package com.ffescara.myfinance

import android.annotation.SuppressLint
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ffescara.myfinance.data.ListCategory
import com.ffescara.myfinance.model.Category
import com.ffescara.myfinance.ui.theme.fonts

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
                    //ambil icon dari gallery
                },
                modifier = Modifier
                    .width(280.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                    contentColor = Color.Black)
            ) {
                Text(text = "Pilih Icon")
            }

            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    navController.navigate(NavRoute.screen_main.name)
                },
                modifier = Modifier
                    .width(280.dp)
                    .height(50.dp)
            ) {
                Text(text = "Add")
            }
            Spacer(modifier = Modifier.height(30.dp))
            Divider()
            Category(category = ListCategory().loadCategory())
        }
        
    }

}

@Composable
fun Category(category: List<Category>) {
    LazyColumn() {
        items(category) { category ->
            CategoryCard(category)
        }
    }
}

@Composable
fun CategoryCard(category: Category) {
    Spacer(modifier = Modifier.padding(5.dp))
    Row() {
        Image(painter = painterResource(id = category.icon), contentDescription = "", Modifier.size(40.dp))
        Spacer(modifier = Modifier.width(5.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = category.nama,
                fontFamily = fonts,
                fontSize = 18.sp
            )
        }
    }
    Spacer(modifier = Modifier.padding(5.dp))
    Divider()
}

@Preview(showSystemUi = true, showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ScreenCategoryPreview() {
    ScreenCategory(rememberNavController())
}