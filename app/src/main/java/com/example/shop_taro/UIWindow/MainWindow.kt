package com.example.shop_taro.UIWindow

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.BottomAppBarDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.shop_taro.R
import com.example.shop_taro.Screens
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
            composable(NavRoutes.Products.route) { Products() }
            composable(NavRoutes.Cart.route) { Cart()  }
            composable(NavRoutes.Orders.route) { Orders() }
            composable(NavRoutes.Profile.route) { Profile(viewModel,MainNavController) }
            composable(NavRoutes.Product.route) { Product() }

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
@Composable
fun Products(){
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min) // Высота соответствует содержимому
            //.weight(1f) // Занимаем половину доступного пространства
            //.padding(16.dp),


    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Title", fontSize = 16.sp,fontWeight = FontWeight.Medium, modifier = Modifier.padding(top=27.dp))
            Image(
                painter = painterResource(id = R.drawable.taro),
                contentScale = ContentScale.Fit,
                contentDescription = "Profile Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp) // Устанавливаем высоту картинки
                    .clip(RoundedCornerShape(16.dp)) // Добавляем закругление углов
            )
            Text("Taro cards",fontSize = 25.sp,fontWeight = FontWeight.Bold, modifier = Modifier.padding(top=16.dp))
            Text("10 000 ₽",fontSize = 20.sp,fontWeight = FontWeight.Bold, modifier = Modifier.padding(top=8.dp))
            Text("Body text for describing why this product is simply a must-buy",fontSize = 15.sp, modifier = Modifier.padding(top=10.dp), color = Color.Gray)
            Button(
                onClick = {},
                modifier = Modifier
                    .width(250.dp) // Устанавливаем ширину
                    .height(60.dp).padding(top = 10.dp).fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(Color.Black)
            ) {
                Text("Add to cart", color = Color.White)
            }
        }
    }

}
@Composable
fun Cart(){
    Column(Modifier.padding(20.dp)) {
        Text("Cart Page", fontSize = 30.sp)
    }

}
@Composable
fun Orders(){
    Column(Modifier.padding(20.dp)) {
        Text("Orders Page", fontSize = 30.sp)
    }
}
@Composable
fun Product(){
    OutlinedCard(
    colors = CardDefaults.cardColors(
    containerColor = MaterialTheme.colorScheme.surface,
    ),
    border = BorderStroke(1.dp, Color.Black),
    modifier = Modifier
    .size(width = 240.dp, height = 100.dp)
    ) {
        Text(
            text = "Outlined",
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }
}



