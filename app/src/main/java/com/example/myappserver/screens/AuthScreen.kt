package com.example.myappserver.screens

import WebServer.Auth
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myappserver.navigation.NV.Routes
import com.example.myappserver.ui.theme.MyAppServerTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking







@Composable
fun AuthScreen(onClick: () -> Unit){
    val login = remember {
        mutableStateOf("")
    }

    val pas = remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Text(text = "Логин", fontSize = 23.sp)
        TextField(value = login.value,
            onValueChange = {newText -> login.value = newText},
            modifier = Modifier.background(color = Color.Gray))

        Text(text = "Пароль", fontSize = 23.sp)
        TextField(value = pas.value,
            onValueChange = {newText -> pas.value = newText},
            modifier = Modifier.background(color = Color.Gray))

        Button(onClick = { onClick()
            CoroutineScope(Dispatchers.IO).launch {
            val authService = Auth
            val response = authService.auth(login.value, pas.value)
            if (response.isSuccessful && response.body?.string()?.contains("\"success\":true")!= null) {
                println("Авторизован")
            } else {
                println("Не найден в бд или Ошибка")
            }
        }}) {
            Text(text = "Click", fontSize = 20.sp, modifier = Modifier.padding(5.dp))
        }
    }



}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MyAppServerTheme {
        AuthScreen{}
    }
}