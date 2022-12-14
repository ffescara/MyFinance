package com.ffescara.myfinance.data

data class Kurs(
    val lastUpdate: Number,
    val base: String,
    val rates: Rate,
)