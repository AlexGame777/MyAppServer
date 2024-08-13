package com.example.myappserver.screens


import androidx.compose.foundation.layout.*

import androidx.compose.runtime.Composable

import androidx.navigation.compose.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myappserver.navigation.BottomNavigationBarC

import com.example.myappserver.navigation.RoutesC


@Composable
fun MyAppC() {
    val navController = rememberNavController()
    androidx.compose.material.Scaffold(
        bottomBar = { Box(Modifier.padding(bottom = 49.dp)) {
            BottomNavigationBarC(navController)
        } }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = RoutesC.HomeC.route,
            Modifier.padding(innerPadding)
        ) {
            composable(RoutesC.HomeC.route) { poiskR() }
            composable(RoutesC.SearchC.route){CreateVacanciScreen()}
            composable(RoutesC.AccountC.route) { AccountScreenC() }
        }
    }
}





@Composable
@Preview(showBackground = true)
fun btombarC(){
    MyAppC()
}
