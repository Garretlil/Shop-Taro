package com.example.shop_taro

sealed class Screens(val route: String) {
    object StartWnd: Screens("StartWindow")
    object MainWnd: Screens("MainWindow")
    object TestWnd: Screens("TestWindow")
}