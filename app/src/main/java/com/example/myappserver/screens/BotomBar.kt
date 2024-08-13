package com.example.myappserver.screens


import androidx.compose.foundation.layout.*

import androidx.compose.runtime.Composable

import androidx.navigation.compose.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myappserver.navigation.BottomNavigationBar
import com.example.myappserver.navigation.Routes


@Composable
fun MyApp() {
    val navController = rememberNavController()
    androidx.compose.material.Scaffold(
        bottomBar = { Box(Modifier.padding(bottom = 49.dp)) {
            BottomNavigationBar(navController)
        } }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Routes.Home.route,
            Modifier.padding(innerPadding)
        ) {
            composable(Routes.Home.route) { poisk() }
            composable(Routes.Search.route){CreateResumeScreen()}
            composable(Routes.Account.route) { AccountScreen{navController.navigate(Routes.Begin.route)} }
        }
    }
}





@Composable
@Preview(showBackground = true)
fun btombar(){
    MyApp()
}
