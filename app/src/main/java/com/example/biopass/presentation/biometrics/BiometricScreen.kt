package com.example.biopass.presentation.biometrics

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun BiometricScreen(onClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Gmail", style = TextStyle(fontSize = LocalConfiguration.current.fontScale.times(30).sp))
        Spacer(modifier = Modifier.padding(25.dp))
        Text(text = "Authentication request needed", style = TextStyle(color = Color.Blue, fontSize = LocalConfiguration.current.fontScale.times(18).sp))
        Button(onClick) {
            Text(text = "Authenticate")
        }
    }
}

