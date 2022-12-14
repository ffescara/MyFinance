package com.ffescara.myfinance

import android.annotation.SuppressLint
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ffescara.myfinance.data.ListTransaction
import com.ffescara.myfinance.model.Transaction
import com.ffescara.myfinance.ui.theme.fonts

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScreenMain(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = colorResource(id = R.color.white),
            contentColor = colorResource(id = R.color.black),
        ) {
            //bisa tambah icon
            Image(painter = painterResource(id = R.drawable.icons8_wallet_48), contentDescription = "Wallet", Modifier.size(35.dp))
            Text(
                text = "MyWallet",
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterVertically)
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
            //Recap
            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icons8_rupiah_64),
                    contentDescription = "Rupiah",
                    modifier = Modifier.align(Alignment.CenterVertically))
                Spacer(modifier = Modifier.width(5.dp))
                Text("500.000", fontWeight = FontWeight.Bold, fontFamily = fonts, fontSize = 30.sp)

            }
            Text(
                text = "Total Balance",
                fontFamily = fonts,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Image(painter = painterResource(id = R.drawable.icons8_safe_in_48), contentDescription = "Safe In", Modifier.size(40.dp))
                Spacer(modifier = Modifier.width(10.dp))
                Column() {
                    Text("Income",  fontFamily = fonts)
                    Text("+ Rp.1.000.000", fontWeight = FontWeight.Bold, fontFamily = fonts, fontSize = 16.sp)
                }
                Spacer(modifier = Modifier.width(20.dp))
                Image(painter = painterResource(id = R.drawable.icons8_safe_out_48), contentDescription = "Safe Out", Modifier.size(40.dp))
                Spacer(modifier = Modifier.width(10.dp))
                Column() {
                    Text("Expense", fontFamily = fonts)
                    Text("- Rp.500.000", fontWeight = FontWeight.Bold, fontFamily = fonts, fontSize = 16.sp)
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row() {
                Button(
                    onClick = {
                        navController.navigate(NavRoute.screen_transaction.name)
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.white))
                    //modifier = Modifier.background(color = Color.White)
                ) {
                    Text(
                        modifier = Modifier.weight(5f),
                        text = "Latest Transaction",
                        fontFamily = fonts,
                        fontSize = 18.sp
                    )
                    Image(painter = painterResource(id = R.drawable.icons8_chevron_right_30), contentDescription = "", Modifier.size(16.dp))
                }

            }

            Column(modifier = Modifier
                .weight(3f)
                .padding(8.dp)
            ){
                Transaksi(transaction = ListTransaction().loadTransaction().sortedByDescending { it.id }.take(5))
            }
        }
    }

}

@Composable
fun Transaksi(transaction: List<Transaction>) {
    LazyColumn() {
        items(transaction) { transaction ->
            TransactionCard(transaction)
        }
    }
}

@Composable
fun TransactionCard(transaction: Transaction) {
    Spacer(modifier = Modifier.padding(5.dp))
    Row() {
        Image(painter = painterResource(id = transaction.category.icon), contentDescription = "", Modifier.size(40.dp))
        Spacer(modifier = Modifier.width(5.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = transaction.category.nama,
                fontFamily = fonts,
                fontSize = 18.sp
            )
            Text(
                text = transaction.date,
                fontFamily = fonts,
                fontSize = 12.sp
            )
        }
        Spacer(modifier = Modifier.width(30.dp))
        Text(
            text = transaction.amount,
            fontFamily = fonts,
            fontSize = 18.sp,
            textAlign = TextAlign.Right,
            modifier = Modifier.weight(1f)
        )
    }
    Spacer(modifier = Modifier.padding(5.dp))
    Divider()
}

@Preview(showSystemUi = true, showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ScreenMainPreview() {
    ScreenMain(rememberNavController())
}