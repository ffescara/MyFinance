package com.ffescara.myfinance

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScreenAdd(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = colorResource(id = R.color.white),
            contentColor = colorResource(id = R.color.black)
        ) {
            //bisa tambah icon
            Text(
                text = "New Transaction",
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
           Spacer(modifier = Modifier.height(10.dp))
           var amount by remember { mutableStateOf(TextFieldValue()) }
           OutlinedTextField(
               value = amount,
               onValueChange = {amount = it},
               label = { Text("Amount")},
               singleLine = true,
               keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
           )

           Spacer(modifier = Modifier.height(10.dp))

           val contextForToast = LocalContext.current.applicationContext
           val listItems = arrayOf("Bill", "Food", "Shopping", "Beverage", "PayDay")
           var selectedItem by remember {
               mutableStateOf(listItems[0])
           }
           var expanded by remember {
               mutableStateOf(false)
           }
           // the box
           ExposedDropdownMenuBox(
               expanded = expanded,
               onExpandedChange = {
                   expanded = !expanded
               }
           ) {
               TextField(
                   value = selectedItem,
                   onValueChange = {},
                   readOnly = true,
                   trailingIcon = {
                       ExposedDropdownMenuDefaults.TrailingIcon(
                           expanded = expanded
                       )
                   },
                   colors = ExposedDropdownMenuDefaults.textFieldColors()
               )
               ExposedDropdownMenu(
                   expanded = expanded,
                   onDismissRequest = { expanded = false }
               ) {
                   listItems.forEach { selectedOption ->
                       // menu item
                       DropdownMenuItem(onClick = {
                           selectedItem = selectedOption
                           Toast.makeText(contextForToast, selectedOption, Toast.LENGTH_SHORT).show()
                           expanded = false
                       }) {
                           Text(text = selectedOption)
                       }
                   }
               }
           }

           Spacer(modifier = Modifier.height(10.dp))

           val contextForToast2 = LocalContext.current.applicationContext
           val listItems2 = arrayOf("Income", "Expense")
           var selectedItem2 by remember {
               mutableStateOf(listItems2[0])
           }
           var expanded2 by remember {
               mutableStateOf(false)
           }
           // the box
           ExposedDropdownMenuBox(
               expanded = expanded2,
               onExpandedChange = {
                   expanded2 = !expanded2
               }
           ) {
               TextField(
                   value = selectedItem2,
                   onValueChange = {},
                   readOnly = true,
                   trailingIcon = {
                       ExposedDropdownMenuDefaults.TrailingIcon(
                           expanded = expanded2
                       )
                   },
                   colors = ExposedDropdownMenuDefaults.textFieldColors()
               )
               ExposedDropdownMenu(
                   expanded = expanded2,
                   onDismissRequest = { expanded2 = false }
               ) {
                   listItems2.forEach { selectedOption ->
                       // menu item
                       DropdownMenuItem(onClick = {
                           selectedItem2 = selectedOption
                           Toast.makeText(contextForToast2, selectedOption, Toast.LENGTH_SHORT).show()
                           expanded2 = false
                       }) {
                           Text(text = selectedOption)
                       }
                   }
               }
           }

           Spacer(modifier = Modifier.height(10.dp))
           var note by remember { mutableStateOf(TextFieldValue()) }
           OutlinedTextField(
               value = note,
               onValueChange = {note = it},
               label = { Text("Note")}
           )

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

       }
    }
}

@Preview(showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ScreenAddPreview() {
    ScreenAdd(rememberNavController())
}