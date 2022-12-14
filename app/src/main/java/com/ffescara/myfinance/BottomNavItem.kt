package com.ffescara.myfinance

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object Home : BottomNavItem("Home", R.drawable.icons8_home_page_48,"home")
    object Transaction: BottomNavItem("Transaction",R.drawable.icons8_purchase_order_48,"transaction")
    object New: BottomNavItem("New",R.drawable.ic_add,"new")
    object Category: BottomNavItem("Category",R.drawable.icons8_diversity_48,"category")
}
