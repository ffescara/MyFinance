package com.ffescara.myfinance

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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
        TopAppBar() {
            //bisa tambah icon
            Text(
                text = "MyWallet",
                fontSize = 24.sp
            )
        }
    }) {
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
            TransactionCard(transaction)
        }
    }
}

@Composable
fun TransactionCard(transaction: Transaction) {
    Card(
        elevation = 8.dp,
        modifier = Modifier.padding(8.dp)
    ) {
        Column() {
            Row(modifier = Modifier.width(350.dp)) {
                Text(
                    text = stringResource(id = transaction.categoryResourceId),
                    modifier = Modifier.padding(8.dp).weight(1f),
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = stringResource(id = transaction.textResourceId),
                    modifier = Modifier.padding(8.dp).weight(1f),
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Right
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ScreenMainPreview() {
    ScreenMain(rememberNavController())
}