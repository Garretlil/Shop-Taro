package com.example.shop_taro.UIMain

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
import androidx.navigation.NavHostController
import com.example.shop_taro.Model.Product
import com.example.shop_taro.R
import com.example.shop_taro.ViewModels.TSViewModel

@Composable
fun CardItem(product: Product?, viewModel: TSViewModel, NavController: NavHostController) {
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
        if (product != null) {
            Text(text = product.name,modifier = Modifier.clickable {
                viewModel.updateCurrentProduct(product)
                NavController.navigate(NavRoutes.Product.route) })
            Text(text = product.price)
        }
        Button(
            onClick = {
                  viewModel.addToCart(product)
            },
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(Color.Black)
        ) {
            Text("В корзину", color = Color.White)
        }
    }
}

@Composable
fun Products(viewModel: TSViewModel, NavController: NavHostController) {
    LazyColumn {
        for (i in 0..<viewModel.catalog.getAllProducts().count()) {
            item {
                CardItem(viewModel.catalog.getAllProducts()[i],viewModel,NavController)
            }
        }
    }
}