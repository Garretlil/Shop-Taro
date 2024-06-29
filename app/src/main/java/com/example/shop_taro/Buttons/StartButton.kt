package com.example.shop_taro.Buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.shop_taro.Screens
import com.example.shop_taro.TSViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun StartButton(
    viewModel: TSViewModel,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    symbol:String,
    navController: NavController,
    onClick:() ->Unit
) {
    Button(
        onClick = {
                val t=5
            // Переход на новый экран
            navController.navigate(Screens.MainWnd.route)
        },
        modifier = Modifier,
        shape = RoundedCornerShape(16.dp),colors = ButtonDefaults.buttonColors(Color.Black)
    ) {
        Text("Войти", color = Color.White)
    }
}