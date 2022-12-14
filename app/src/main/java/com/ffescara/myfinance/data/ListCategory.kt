package com.ffescara.myfinance.data

import com.ffescara.myfinance.R
import com.ffescara.myfinance.model.Category

class ListCategory() {
    fun loadCategory(): List<Category> {
        return listOf(
            Category("PayDay", R.drawable.icons8_payday_65),
            Category("Bill", R.drawable.icons8_purchase_order_48),
            Category("Food", R.drawable.icons8_spoon_fork_64),
            Category("Beverage", R.drawable.icons8_cafe_94),
            Category("Shopping", R.drawable.icons8_shopping_cart_94),
        )
    }
}