package com.example.shop_taro

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shop_taro.UIWindow.MainWnd
import com.example.shop_taro.UIWindow.StartWnd

@Composable
fun NavGraph (viewModel: TSViewModel,navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screens.StartWnd.route)
    {
        composable(route = Screens.StartWnd.route){
            StartWnd(viewModel, navController)
        }
        composable(route = Screens.MainWnd.route){
            MainWnd(viewModel,navController)
        }

    }
}