package com.example.myappserver.screens

import WebServer.RegC
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

@Composable
fun regC(onClick: () -> Unit){
    val company_type = remember {
        mutableStateOf("")
    }
    val company_name = remember{
        mutableStateOf("")
    }
    val company_email = remember {
        mutableStateOf("")
    }
    val contact_person_name = remember {
        mutableStateOf("")
    }
    val passwordC = remember {
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
        Text(text = "Вид компании", fontSize = 20.sp)
        TextField(value = company_type.value,
            onValueChange = {newText -> company_type.value = newText},
            modifier = Modifier.background(Color.Gray))
        Text(text = "Наименование компании", fontSize = 20.sp)
        TextField(value = company_name.value,
            onValueChange = {newText -> company_name.value = newText},
            modifier = Modifier.background(Color.Gray))
        Text(text = "Почта компании", fontSize = 20.sp)
        TextField(value = company_email.value,
            onValueChange = {newText -> company_email.value = newText},
            modifier = Modifier.background(Color.Gray))
        Text(text = "ФИО контактного лица", fontSize = 20.sp)
        TextField(value = contact_person_name.value,
            onValueChange = {newText -> contact_person_name.value = newText},
            modifier = Modifier.background(Color.Gray))
        Text(text = "Пароль",
            fontSize = 20.sp)
        TextField(value = passwordC.value,
            onValueChange = {newText -> passwordC.value = newText},
            modifier = Modifier.background(Color.Gray))
        Button(onClick = {
            RegC.sendData(company_type.value, company_name.value, company_email.value, contact_person_name.value, passwordC.value, { responseData -> println("Response data: $responseData")}, { exception ->
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
fun Comp(){
    regC{}
}