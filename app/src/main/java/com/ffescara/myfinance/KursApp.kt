package com.ffescara.myfinance

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.ffescara.myfinance.data.Rate

@Composable
fun KursApp(listRate: List<Rate>) {
    LazyColumn {
        items(listRate) { rate ->
            KursCard(rate = rate)
        }
    }
}

@Composable
fun KursCard(rate: Rate) {
    Text(text = rate.USD.toString())
}