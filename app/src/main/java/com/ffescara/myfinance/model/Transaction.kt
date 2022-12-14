package com.ffescara.myfinance.model

data class Transaction(
    val id: Int,
    val category: Category,
    val type: String,
    val amount: String,
    val date: String
)