package com.ffescara.myfinance

import android.annotation.SuppressLint
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ffescara.myfinance.data.ListTransaction
import com.ffescara.myfinance.model.Transaction

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScreenMain(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = colorResource(id = R.color.white),
            contentColor = colorResource(id = R.color.black)
        ) {
            //bisa tambah icon
            Text(
                text = "MyWallet",
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
            Column(
                Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Balance")
                Row() {
                    Text("Rp.")
                    Text("500.000", fontWeight = FontWeight.Bold, fontSize = 24.sp)
                }

                Row() {
                    Column() {
                        Text("Income")
                        Text("+ Rp.1.000.000", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    }
                    Spacer(modifier = Modifier.width(30.dp))
                    Column() {
                        Text("Expense")
                        Text("- Rp.500.000", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    }
                }
            }

            Card(
                elevation = 8.dp,
                modifier = Modifier.padding(8.dp)
            ) {
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
                            style = MaterialTheme.typography.h5,
                        )
                        Text(
                            modifier = Modifier.weight(1f),
                            text = ">",
                            style = MaterialTheme.typography.h5,
                            textAlign = TextAlign.Center,

                            )
                    }

                }
            }


            Column(modifier = Modifier.weight(3f)){
                    Transaksi(transaction = ListTransaction().loadTransaction())
            }
        }
    }

}

@Composable
fun Transaksi(transaction: List<Transaction>) {
    Column() {
        transaction.forEach { transaction ->
            TransactionCard(transaction = transaction)
        }
    }
}

@Composable
fun TransactionCard(transaction: Transaction) {
    Card(
        elevation = 8.dp,
        modifier = Modifier.padding(8.dp)
    ) {
        Row() {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = transaction.category,
                    style = MaterialTheme.typography.h6,
                )
                Text(
                    text = transaction.date,
                    style = MaterialTheme.typography.h6,
                )
            }
            Spacer(modifier = Modifier.width(30.dp))
            Text(
                text = transaction.amount,
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Right,
                modifier = Modifier.weight(1f)
            )
        }

    }
}

@Preview(showSystemUi = true, showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ScreenMainPreview() {
    ScreenMain(rememberNavController())
}