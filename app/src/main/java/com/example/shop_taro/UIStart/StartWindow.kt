package com.example.shop_taro.UIStart

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
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
import com.example.shop_taro.ViewModels.TSViewModel
import com.example.shop_taro.ui.theme.BlueR


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartWnd(viewModel: TSViewModel, navController: NavController) {
    val context = LocalContext.current
    val isLoggedIn = remember {
        mutableStateOf(context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
            .getBoolean("isLoggedIn", false))
    }

    if (isLoggedIn.value) {
        navController.navigate(Screens.MainWnd.route)
    } else {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Welcome to TS!", fontSize = 40.sp, fontWeight = FontWeight.W500,
            fontFamily = FontFamily.Cursive,
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Center, modifier = Modifier
        )

        var email by remember { mutableStateOf("") }
        var name by remember { mutableStateOf("") }

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Имя") },
            modifier = Modifier.padding(bottom = 20.dp, top = 100.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Black, // Цвет границы в неактивном состоянии
                focusedBorderColor = Color.Black // Цвет границы в активном состоянии
            ),
            singleLine = true
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.padding(bottom = 30.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Black, // Цвет границы в неактивном состоянии
                focusedBorderColor = Color.Black // Цвет границы в активном состоянии
            ), singleLine = true
        )

        Button(
            onClick = {
                //var id:Int=viewModel.onLogin(name,email) получение id из retrofit
                if (viewModel.onLogin(name,email)) {
                    context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
                        .edit()
                        .putBoolean("isLoggedIn", true)
                        .apply()
                    viewModel.updateUser(name,email)
                    navController.navigate(Screens.MainWnd.route)
                }
            },
            modifier = Modifier.padding(bottom = 180.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(Color.Black)
        ) {
            Text("К покупкам", color = Color.White)
        }
        Text(
            "Ещё нет аккаунта?", fontSize = 15.sp, fontWeight = FontWeight.W300,
            //fontFamily = FontFamily.Cursive,
            //textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Center, modifier = Modifier.padding(bottom=50.dp)
        )
        Text(
            "Регистрация", fontSize = 15.sp, fontWeight = FontWeight.W300,
            //fontFamily = FontFamily.Cursive,
            //textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Center,color = BlueR,
            modifier = Modifier.padding(bottom=50.dp)
            .clickable { navController.navigate(Screens.AuthWnd.route) }
        )
    }
 }
}

