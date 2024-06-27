package com.example.shop_taro.UIWindow

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shop_taro.Screens
import com.example.shop_taro.TSViewModel


@Composable
fun StartWnd(viewModel: TSViewModel, navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {navController.navigate(Screens.MainWnd.route)},
            modifier = Modifier.align(Alignment.CenterHorizontally).size(150.dp, 50.dp), // Указываем ширину и высоту
            shape = RoundedCornerShape(16.dp),colors = ButtonDefaults.buttonColors(Color.Black)
        ) {
            Text("Войти", color = Color.White)
        }

    }

}