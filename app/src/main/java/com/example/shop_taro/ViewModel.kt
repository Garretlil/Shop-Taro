package com.example.shop_taro

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel

class TSViewModel(application: Application): AndroidViewModel(application){

    var showtext: MutableState<String> = mutableStateOf("TS")

}