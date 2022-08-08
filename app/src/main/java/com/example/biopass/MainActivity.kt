package com.example.biopass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.biopass.presentation.ConnectedWeb
import com.example.biopass.presentation.login_register.BioPassLogin
import com.example.biopass.presentation.screen.Screens
import com.example.biopass.ui.theme.BioPassTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BioPassTheme {

                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screens.LoginScreen.route){
                    composable(Screens.LoginScreen.route){
                        BioPassLogin(navController)
                    }
                    composable(Screens.ConnectedWebScreen.route){
                        ConnectedWeb()
                    }
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BioPassTheme {
        Greeting("Android")
    }
}