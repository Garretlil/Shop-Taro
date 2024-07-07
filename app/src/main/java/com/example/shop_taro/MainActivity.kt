package com.example.shop_taro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.example.shop_taro.Model.dagger.CatalogComponent
import com.example.shop_taro.Model.dagger.DaggerCatalogComponent
import com.example.shop_taro.ViewModels.TSViewModel
import com.example.shop_taro.ui.theme.ShopTaroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShopTaroTheme {
                    val navController = rememberNavController()
                    //val catalogComponent = (applicationContext as Taro_market).getCatalogComponent()
                    val viewModel: TSViewModel by viewModels()
                    NavGraph(viewModel, navController = navController)
            }
        }
    }
}
