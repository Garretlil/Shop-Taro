package com.example.shop_taro.UIMain

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter

import com.example.shop_taro.Model.Product
import com.example.shop_taro.TSViewModel


@Composable
fun ProductItem(product: Product?, viewModel: TSViewModel, MainNavController: NavHostController){
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min) // Высота соответствует содержимому
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
            ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Title", fontSize = 16.sp,fontWeight = FontWeight.Medium, modifier = Modifier.padding(top=27.dp))
            Image(
                painter = rememberAsyncImagePainter(product!!.ImageResource),
                contentScale = ContentScale.Fit,
                contentDescription = "Profile Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp) // Устанавливаем высоту картинки
                    .clip(RoundedCornerShape(16.dp)) // Добавляем закругление углов
            )
            if (product != null) {
                Text(product.Name,fontSize = 25.sp,fontWeight = FontWeight.Bold, modifier = Modifier.padding(top=16.dp))
                Text(product.Price.toString()+" ₽",fontSize = 20.sp,fontWeight = FontWeight.Bold, modifier = Modifier.padding(top=8.dp))
                Text("Body text for describing why this product is simply a must-buy",fontSize = 15.sp, modifier = Modifier.padding(top=10.dp), color = Color.Gray)
            }
            Button(
                onClick = {viewModel.addToCart(product)},
                modifier = Modifier
                    .width(250.dp) // Устанавливаем ширину
                    .height(60.dp).padding(top = 10.dp).fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(Color.Black)
            ) {
                Text("В корзину", color = Color.White)
            }
        }
    }
}
@Composable
fun OneProduct(product: Product?, viewModel: TSViewModel, NavController: NavHostController) {
    LazyColumn {
            item {
                ProductItem(product,viewModel,NavController)
            }
    }
}