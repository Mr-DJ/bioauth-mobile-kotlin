package com.example.biopass.presentation.login

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

@Composable
fun BioPassLogin() {
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
            modifier = Modifier.width(
                LocalConfiguration.current.screenWidthDp.dp - 40.dp
            )
        )
        Spacer(modifier = Modifier.padding(25.dp))
        OutlinedTextField(
            value = passWordValue.value,
            onValueChange = { passWordValue.value = it },
            modifier = Modifier.width(
                LocalConfiguration.current.screenWidthDp.dp - 40.dp
            )
        )
        
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Sign In")
        }
    }
}