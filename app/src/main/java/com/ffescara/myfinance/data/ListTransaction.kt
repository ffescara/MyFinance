package com.ffescara.myfinance.data

import com.ffescara.myfinance.R
import com.ffescara.myfinance.model.Category
import com.ffescara.myfinance.model.Transaction

class ListTransaction() {
    fun loadTransaction(): List<Transaction> {
        return listOf(
            Transaction(0,Category("Contoh", R.drawable.ic_add), "Income", "+1.000.000.000","01/01/2022"),
            Transaction(1, Category("PayDay", R.drawable.icons8_payday_65),"Income","+1.000.000","01/01/2022"),
            Transaction(2, Category("Bill", R.drawable.icons8_purchase_order_48),"Expense","-50.000","02/01/2022"),
            Transaction(3, Category("Food", R.drawable.icons8_spoon_fork_64),"Expense","-50.000","03/01/2022"),
            Transaction(4, Category("Beverage", R.drawable.icons8_cafe_94),"Expense","-50.000","04/01/2022"),
            Transaction(5, Category("Shopping", R.drawable.icons8_shopping_cart_94),"Expense","-50.000","05/01/2022"),
            Transaction(6, Category("Food", R.drawable.icons8_spoon_fork_64),"Expense","-50.000","06/01/2022"),
            Transaction(7, Category("Shopping", R.drawable.icons8_shopping_cart_94),"Expense","-50.000","07/01/2022"),
            Transaction(8, Category("Bill", R.drawable.icons8_purchase_order_48),"Expense","-50.000","08/01/2022"),
            Transaction(9, Category("Shopping", R.drawable.icons8_shopping_cart_94),"Expense","-50.000","09/01/2022"),
            Transaction(10, Category("Bill", R.drawable.icons8_purchase_order_48),"Expense","-50.000","10/01/2022"),
            Transaction(11, Category("Beverage", R.drawable.icons8_cafe_94),"Expense","-50.000","11/01/2022"),
            Transaction(12, Category("Shopping", R.drawable.icons8_shopping_cart_94),"Expense","-50.000","12/01/2022"),
            Transaction(13, Category("Food", R.drawable.icons8_spoon_fork_64),"Expense","-50.000","13/01/2022"),
            Transaction(14, Category("Beverage", R.drawable.icons8_cafe_94),"Expense","-50.000","14/01/2022"),
            Transaction(15, Category("Food", R.drawable.icons8_spoon_fork_64),"Expense","-50.000","15/01/2022"),
            )
    }
}