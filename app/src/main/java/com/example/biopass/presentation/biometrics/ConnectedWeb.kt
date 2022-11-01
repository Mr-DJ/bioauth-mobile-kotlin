package com.example.biopass.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.biopass.presentation.screen.Screens


val webList = listOf<String>("Amazon","FlipKart","Lobby","Kaggle","Swift","Edureka","KBC","Indian Times","Myntra","Meeshow","Snapdeal","OLX","Trivago","Gmail")

@Composable
fun ConnectedWeb(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(10.dp))
        webList.forEach{ it ->
            Card(
                modifier = Modifier
                    .width(LocalConfiguration.current.screenWidthDp.dp - 80.dp)
                    .height(
                        LocalConfiguration.current.screenHeightDp.dp / 15
                    )
                    .align(Alignment.CenterHorizontally)
                    .clickable {
                        navController.navigate(Screens.BiometricScreen.route)
                    },
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Cyan),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = it)
                }

            }
            Spacer(modifier = Modifier.padding(10.dp))
        }
    }
}