package com.example.shop_taro.UIMain

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shop_taro.Model.Order
import com.example.shop_taro.R
import com.example.shop_taro.ViewModels.TSViewModel


@Composable
fun OrderCard(order:Order) {
    Row (
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalArrangement = Arrangement.SpaceAround)
    {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min) // Занимает минимальную высоту, необходимую для содержимого
                .padding(16.dp)
                .weight(1f),
            //elevation = 4.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Заголовок
                Text(
                    text = "Заказ № "+order.idOrder.toString(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                // Статус
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = order.status.name,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
                // Три изображения (placeholder)
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    for (i in 0..<order.products.count()) {
                        Image(
                            painter = painterResource(id = order.products[i]!!.imageResource),
                            contentDescription = "Image $i",
                            modifier = Modifier.size(50.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Сумма заказа: "+order.summa.toString()+" ₽",
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun Orders(viewModel:TSViewModel){
    LazyColumn {
        for (i in 0..<viewModel.orders.getAllOrders().count()) {
            item {
                OrderCard(viewModel.orders.getAllOrders()[i])
            }
        }
    }
}