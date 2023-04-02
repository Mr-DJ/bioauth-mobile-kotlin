package com.example.biopass.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.biopass.presentation.screen.Screens
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ConnectedWeb(navController: NavController, viewModel: BioPassViewModel) {
    val websites = viewModel.websites.observeAsState()
    val state = remember {
        mutableStateOf(false)
    }
    val coroutineScope = rememberCoroutineScope()
    coroutineScope.launch {
        viewModel.getWebsites()
        state.value = websites.value != null
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(10.dp))
//        if (!state.value){
//            CircularProgressIndicator(modifier = Modifier.size(25.dp), color = Color.Blue)
//            Spacer(modifier = Modifier.padding(10.dp))
//            Text(text = "Loading")
//        }
//        else{
            websites.value?.forEach{ it ->
                Card(
                    modifier = Modifier
                        .width(LocalConfiguration.current.screenWidthDp.dp - 80.dp)
                        .height(
                            LocalConfiguration.current.screenHeightDp.dp / 15
                        )
                        .align(Alignment.CenterHorizontally)
                        .clickable {
                            navController.navigate(Screens.BiometricScreen.route + '/')
                        },
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Cyan),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = it.websiteName)
                    }

                }
                Spacer(modifier = Modifier.padding(10.dp))
            }
        }

//    }
}