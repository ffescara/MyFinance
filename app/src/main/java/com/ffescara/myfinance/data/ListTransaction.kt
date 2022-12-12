package com.ffescara.myfinance.data

import com.ffescara.myfinance.R
import com.ffescara.myfinance.model.Transaction

class ListTransaction() {
    fun loadTransaction(): List<Transaction> {
        return listOf<Transaction>(
            Transaction(R.string.transaction1, R.string.category1),
            Transaction(R.string.transaction2, R.string.category2),
            Transaction(R.string.transaction3, R.string.category3),
            Transaction(R.string.transaction4, R.string.category4),
            Transaction(R.string.transaction5, R.string.category5),
            Transaction(R.string.transaction6, R.string.category6),
            Transaction(R.string.transaction7, R.string.category7)
            )
    }
}