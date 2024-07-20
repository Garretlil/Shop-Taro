package com.example.shop_taro

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shop_taro.TSViewModel
import com.example.shop_taro.UIMain.MainWnd
import com.example.shop_taro.UIMain.TestWnd
import com.example.shop_taro.UIStart.AuthWnd
import com.example.shop_taro.UIStart.StartWnd


@Composable
fun NavGraph (viewModel: TSViewModel, navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screens.StartWnd.route)
    {
        composable(route = Screens.StartWnd.route) {
            StartWnd(viewModel, navController)
        }
        composable(route = Screens.MainWnd.route) {
            MainWnd(viewModel, navController)
        }
        composable(route = Screens.TestWnd.route) {
            TestWnd()
        }
        composable(route = Screens.AuthWnd.route) {
            AuthWnd(viewModel, navController)
        }
    }
}