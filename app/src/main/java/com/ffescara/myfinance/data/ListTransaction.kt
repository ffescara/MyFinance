package com.ffescara.myfinance.data

import com.ffescara.myfinance.R
import com.ffescara.myfinance.model.Transaction

class ListTransaction() {
    fun loadTransaction(): List<Transaction> {
        return listOf<Transaction>(
            Transaction(1, "PayDay","Income","1.000.000","01/01/2022"),
            Transaction(2, "Bill","Expense","50.000","02/01/2022"),
            Transaction(3, "Food","Expense","50.000","03/01/2022"),
            Transaction(4, "Beverage","Expense","50.000","04/01/2022"),
            Transaction(5, "Bill","Expense","50.000","05/01/2022"),
            )
    }
}