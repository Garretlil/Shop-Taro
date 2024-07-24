package com.example.shop_taro.UIStart

import android.content.Context
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
import androidx.navigation.NavHostController
import com.example.shop_taro.Screens
import com.example.shop_taro.TSViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthWnd(viewModel: TSViewModel, navController: NavHostController){
    val context = LocalContext.current
    val isLoggedIn = remember {
        mutableStateOf(context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
            .getBoolean("isLoggedIn", false))
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Auth", fontSize = 40.sp, fontWeight = FontWeight.W500,
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
                //var id:Int=viewModel.onAuth(name,email)
                viewModel.onAuth(name,email)
                viewModel.onChangeProfileData(name,email)
                context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
                    .edit()
                    .putBoolean("isLoggedIn", true)
                    .apply()
                navController.navigate(Screens.MainWnd.route)
            },
            modifier = Modifier.padding(bottom = 180.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(Color.Black)
        ) {
            Text("Зарегестрироваться", color = Color.White)
        }


    }


}