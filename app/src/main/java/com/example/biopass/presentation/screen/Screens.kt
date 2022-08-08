package com.example.biopass.presentation.screen

sealed class Screens(val route : String){
    object LoginScreen : Screens("login_screen")
    object ConnectedWebScreen : Screens("connected_web_screen")
    object BiometricScreen : Screens("biometric_screen")
}
