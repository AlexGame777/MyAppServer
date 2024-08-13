package com.example.myappserver.screens

import WebServer.AddResume
import WebServer.AddVakance
import androidx.compose.runtime.Composable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun CreateVacanciScreen() {

    val name_v = remember {
        mutableStateOf("")
    }
    val zp = remember{
        mutableStateOf("")
    }
    val name_comp = remember {
        mutableStateOf("")
    }
    val city = remember {
        mutableStateOf("")
    }
    val prof_exp = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Create Vacancy", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Наименование вакансии")
        OutlinedTextField(value = name_v.value, onValueChange = {newText -> name_v.value = newText})
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Зароботная плата")
        OutlinedTextField(value = zp.value, onValueChange = {newText -> zp.value = newText})
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Наименование компании")
        OutlinedTextField(value = name_comp.value, onValueChange = {newText -> name_comp.value = newText})
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Город")
        OutlinedTextField(value = city.value, onValueChange = {newText -> city.value = newText})
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Требуемый опыт от сотрудника")
        OutlinedTextField(value = prof_exp.value, onValueChange = {newText -> prof_exp.value = newText})
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {AddVakance.sendData(name_v.value, zp.value, name_comp.value, city.value, prof_exp.value, { responseData -> println("Response data: $responseData")},{ exception ->
                println("Failed to execute request, cause: ${exception.message}")})},
        ) {
            Text("Добавить Резюме")
        }
    }
}

@Preview
@Composable
fun conposV(){
    CreateVacanciScreen()
}