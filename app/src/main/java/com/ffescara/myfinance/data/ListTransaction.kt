package com.ffescara.myfinance.data

import com.ffescara.myfinance.model.Transaction

class ListTransaction() {
    fun loadTransaction(): List<Transaction> {
        return listOf<Transaction>(
            Transaction(1, "PayDay","Income","+1.000.000","01/01/2022"),
            Transaction(2, "Bill","Expense","-50.000","02/01/2022"),
            Transaction(3, "Food","Expense","-50.000","03/01/2022"),
            Transaction(4, "Beverage","Expense","-50.000","04/01/2022"),
            Transaction(5, "Shopping","Expense","-50.000","05/01/2022"),
            Transaction(6, "Food","Expense","-50.000","06/01/2022"),
            Transaction(7, "Shopping","Expense","-50.000","07/01/2022"),
            Transaction(8, "Bill","Expense","-50.000","08/01/2022"),
            Transaction(9, "Shopping","Expense","-50.000","09/01/2022"),
            Transaction(10, "Bill","Expense","-50.000","10/01/2022"),
            Transaction(11, "Beverage","Expense","-50.000","11/01/2022"),
            Transaction(12, "Shopping","Expense","-50.000","12/01/2022"),
            Transaction(13, "Food","Expense","-50.000","13/01/2022"),
            Transaction(14, "Beverage","Expense","-50.000","14/01/2022"),
            Transaction(15, "Food","Expense","-50.000","15/01/2022"),

            )
    }
}