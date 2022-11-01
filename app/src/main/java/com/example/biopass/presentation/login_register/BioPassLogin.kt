package com.example.biopass.presentation.login_register

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.biopass.presentation.screen.Screens

@Composable
fun BioPassLogin(navController: NavController) {
    val adminNameValue = remember {
        mutableStateOf(String())
    }
    val passWordValue = remember {
        mutableStateOf(String())
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = adminNameValue.value,
            onValueChange = { adminNameValue.value = it },
            label = { Text(text = "UserName")},
            modifier = Modifier
                .width(
                    LocalConfiguration.current.screenWidthDp.dp - 40.dp
                )
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.padding(20.dp))
        OutlinedTextField(
            value = passWordValue.value,
            onValueChange = { passWordValue.value = it },
            label = { Text(text = "Password")},
            modifier = Modifier
                .width(
                    LocalConfiguration.current.screenWidthDp.dp - 40.dp
                )
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.padding(20.dp))
        Button(onClick = { navController.navigate(Screens.ConnectedWebScreen.route) }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(text = "Sign In")
        }

//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            verticalAlignment = Alignment.Bottom,
//            horizontalArrangement = Arrangement.Center
//        ) {
//            Canvas(modifier = Modifier.fillMaxSize()){
//
//            }
//        }
    }

}