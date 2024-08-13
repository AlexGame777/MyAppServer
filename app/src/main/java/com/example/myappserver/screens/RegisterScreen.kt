package com.example.myappserver.screens

import WebServer.ServerData
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
import com.example.myappserver.ui.theme.MyAppServerTheme

@Composable
fun registerScreen(onClick: () -> Unit){

    val f_name = remember {
        mutableStateOf("")
    }
    val l_name = remember{
        mutableStateOf("")
    }
    val login = remember {
        mutableStateOf("")
    }
    val pas = remember {
        mutableStateOf("")
    }


    Column(modifier = Modifier
        .background(Color.White)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = "WorkCity",
            fontSize = 28.sp,
            modifier = Modifier.padding(40.dp))
        Text(text = "Registratoin", modifier = Modifier.padding(10.dp), fontSize = 20.sp)
        Text(text = "Имя")
        TextField(value = f_name.value,
            onValueChange = {newText -> f_name.value = newText},
            modifier = Modifier.background(Color.Gray))
        Text(text = "Фамилия")
        TextField(value = l_name.value,
            onValueChange = {newText -> l_name.value = newText},
            modifier = Modifier.background(Color.Gray))
        Text(text = "Логин", fontSize = 20.sp)
        TextField(value = login.value,
            onValueChange = {newText -> login.value = newText},
            modifier = Modifier.background(Color.Gray))
        Text(text = "Пароль",
            fontSize = 20.sp)
        TextField(value = pas.value,
            onValueChange = {newText -> pas.value = newText},
            modifier = Modifier.background(Color.Gray))
        Button(onClick = {
            ServerData.sendData(f_name.value, l_name.value, login.value, pas.value, { responseData -> println("Response data: $responseData")},{ exception ->
                println("Failed to execute request, cause: ${exception.message}")})}) {
            Text(text = "Зарегистрироватся", fontSize = 20.sp, modifier = Modifier.padding(5.dp))

        }
        Button(onClick = {onClick()}) {
            Text(text = "Авторизироваться")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    MyAppServerTheme {
        registerScreen{}
    }
}