package com.example.shop_taro.UIMain

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.shop_taro.TSViewModel

import com.example.shop_taro.ui.theme.IconColor

sealed class NavRoutes(val route: String) {
    object Products : NavRoutes("products")
    object Cart : NavRoutes("cart")
    object Orders : NavRoutes("orders")
    object Profile : NavRoutes("profile")
    object Product : NavRoutes("product")
}
@Composable
fun MainWnd(viewModel: TSViewModel, MainNavController: NavController) {
    val navController = rememberNavController()
    Column() {
        NavHost(navController, startDestination = NavRoutes.Products.route, modifier = Modifier.weight(1f)) {
            composable(NavRoutes.Products.route) { Products(viewModel,navController) }
            composable(NavRoutes.Cart.route)     { Cart(viewModel, navController) }
            composable(NavRoutes.Orders.route)   { Orders(viewModel) }
            composable(NavRoutes.Profile.route)  { Profile(viewModel,MainNavController) }
            composable(NavRoutes.Product.route)  { OneProduct(viewModel.currentProduct,viewModel,navController) }

        }
        BottomNavigationBar(navController = navController)
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar(containerColor= Color.White) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        NavBarItems.BarItems.forEach { navItem ->
            NavigationBarItem(colors= NavigationBarItemDefaults.colors(selectedIconColor = IconColor, indicatorColor =IconColor ),
                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {saveState = true}
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(imageVector = navItem.image,
                        contentDescription = navItem.title)
                },
                label = {
                    Text(text = navItem.title)
                }
            )
        }
    }
}

object NavBarItems {
    val BarItems = listOf(
        BarItem(
            title = "Каталог",
            image = Icons.Filled.Menu,
            route = "products"
        ),
        BarItem(
            title = "Корзина",
            image = Icons.Filled.ShoppingCart,
            route = "cart"
        ),
        BarItem(
            title = "Заказы",
            image = Icons.Filled.MoreVert,
            route = "orders"
        ),
        BarItem(
           title = "Профиль",
           image = Icons.Filled.Person,
           route = "profile"
         )
    )
}

data class BarItem(
    val title: String,
    val image: ImageVector,
    val route: String
)





