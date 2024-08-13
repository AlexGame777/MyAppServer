package com.example.myappserver.screens

import WebServer.AddResume
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
fun CreateResumeScreen() {

    val name = remember {
        mutableStateOf("")
    }
    val position = remember{
        mutableStateOf("")
    }
    val experience = remember {
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
        Text(text = "Create Resume", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = name.value, onValueChange = {newText -> name.value = newText})
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = position.value, onValueChange = {newText -> position.value = newText})
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = experience.value, onValueChange = {newText -> experience.value = newText})
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {AddResume.sendData(name.value, position.value, experience.value, { responseData -> println("Response data: $responseData")},{ exception ->
                println("Failed to execute request, cause: ${exception.message}")})},
        ) {
            Text("Добавить Резюме")
        }
    }
}

@Preview
@Composable
fun conpos(){
    CreateResumeScreen()
}