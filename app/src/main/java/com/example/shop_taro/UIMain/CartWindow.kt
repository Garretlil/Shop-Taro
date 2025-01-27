package com.example.shop_taro.UIMain

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.shop_taro.Model.Product
import com.example.shop_taro.TSViewModel


@Composable
fun CartItemForBucket(product: Product?, viewModel: TSViewModel, NavController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(product!!.ImageResource),
            contentScale = ContentScale.Fit,
            contentDescription = "Profile Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .clip(RoundedCornerShape(16.dp)).size(150.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = product.Name,
             modifier = Modifier.clickable {
             //viewModel.updateCurrentProduct(product)
             NavController.navigate(NavRoutes.Product.route)
             }
        )
        Text(text = product.Price.toString()+" ₽")
    }
}

@Composable
fun Cart(viewModel: TSViewModel, navController: NavHostController) {
    if(viewModel.orders.cart.listOfProducts.isEmpty()){
        Column(
            modifier = Modifier.fillMaxSize().padding(18.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text("Ваша корзина пуста:(", fontSize = 20.sp)
        }
    }
    else {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally) {

                for (i in 0..<viewModel.orders.cart.getListOfProductsFromCart().count()) {
                    item {
                        CartItemForBucket(
                            viewModel.orders.cart.getListOfProductsFromCart()[i],
                            viewModel,
                            navController
                        )
                    }
                }
                item {
                    Button(
                        onClick = {
                            viewModel.createOrder()
                            //MainNavController.navigate(Screens.MainWnd.route)
                            //viewModel.clearCart()
                            navController.navigate(NavRoutes.Orders.route)
                        },
                        modifier = Modifier.padding(bottom = 16.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(Color.Black)
                    ) {
                        Text("Оформить заказ", color = Color.White)
                    }
                }
            }

        }
    }
}