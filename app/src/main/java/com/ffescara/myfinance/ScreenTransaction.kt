package com.ffescara.myfinance

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ffescara.myfinance.data.ListTransaction

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScreenTransaction(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = colorResource(id = R.color.white),
            contentColor = colorResource(id = R.color.black)
        ) {
            //bisa tambah icon
            Text(
                text = "Latest Transaction",
                fontSize = 24.sp
            )
        }
    },
        bottomBar = { BottomNavigation(navController = navController)}
    ) {
        Transaksi(transaction = ListTransaction().loadTransaction().sortedByDescending { it.id })
    }
}

@Preview(showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ScreenTransactionPreview() {
    ScreenTransaction(rememberNavController())
}