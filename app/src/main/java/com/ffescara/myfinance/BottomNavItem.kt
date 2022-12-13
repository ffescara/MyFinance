package com.ffescara.myfinance

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object Home : BottomNavItem("Home", R.drawable.ic_home,"home")
    object Transaction: BottomNavItem("Transaction",R.drawable.ic_transaction,"transaction")
    object New: BottomNavItem("New",R.drawable.ic_add,"new")
    object Category: BottomNavItem("Category",R.drawable.ic_category,"category")
    object Profile: BottomNavItem("Profile",R.drawable.ic_profile,"profile")
}
