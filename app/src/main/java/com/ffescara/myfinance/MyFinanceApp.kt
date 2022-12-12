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
    }
}