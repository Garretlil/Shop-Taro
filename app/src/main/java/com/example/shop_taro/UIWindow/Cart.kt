package com.example.shop_taro.UIWindow

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.shop_taro.Card
import com.example.shop_taro.R
import com.example.shop_taro.Screens
import com.example.shop_taro.TSViewModel

@Composable
fun CartItemForBusket(card: Card, viewModel: TSViewModel,NavController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        Image(

            painter = painterResource(id = R.drawable.taro),
            contentScale = ContentScale.Fit,
            contentDescription = "Profile Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp) // Устанавливаем высоту картинки
                .clip(RoundedCornerShape(16.dp)).size(150.dp) // Добавляем закругление углов
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = card.name,modifier = Modifier.clickable { NavController.navigate(NavRoutes.Product.route) })
        Text(text = card.price)
    }
}

@Composable
fun Cart(viewModel: TSViewModel, MainNavController: NavHostController) {
    LazyColumn {
        for (i in 0..<viewModel.cart.getListOfCards().count()) {
            item {
                CartItemForBusket(viewModel.cart.getListOfCards()[i],viewModel,MainNavController)
            }
        }
    }
}