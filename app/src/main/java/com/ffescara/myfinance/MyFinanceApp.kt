package com.ffescara.myfinance

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyFinanceApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavRoute.screen_login.name
    ) {
        composable(NavRoute.screen_login.name) {
            ScreenLogin(navController)
        }
        composable(NavRoute.screen_main.name) {
            ScreenMain(navController)
        }
        composable(NavRoute.screen_transaction.name) {
            ScreenTransaction(navController)
        }

        //Bottom Nav
        composable(BottomNavItem.Home.screen_route) {
            ScreenMain(navController)
        }
        composable(BottomNavItem.Transaction.screen_route) {
            ScreenTransaction(navController)
        }
        composable(BottomNavItem.New.screen_route) {
            ScreenAdd(navController)
        }
        composable(BottomNavItem.Category.screen_route) {
            ScreenCategory(navController)
        }
    }
}