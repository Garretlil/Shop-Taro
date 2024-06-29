package com.example.shop_taro.UIWindow

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.shop_taro.Screens
import com.example.shop_taro.TSViewModel

@Composable
fun Profile(viewModel: TSViewModel, navController: NavController) {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = viewModel.db.getData()[0],
            fontSize = 40.sp,
            fontWeight = FontWeight.W500,
            fontFamily = FontFamily.Cursive,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(40.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                //viewModel.db.delDB()
                context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
                    .edit()
                    .putBoolean("isLoggedIn", false)
                    .apply()

            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(Color.LightGray)
                .padding(vertical = 5.dp),
            colors = ButtonDefaults.buttonColors(Color.LightGray),
            shape = RoundedCornerShape(0.dp)
        ) {
            Text(
                text = "Выйти из аккаунта",
                color = Color.Red,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}