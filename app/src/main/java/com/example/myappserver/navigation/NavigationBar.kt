package com.example.myappserver.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myappserver.screens.AccountScreen
import com.example.myappserver.screens.MyApp
import com.example.myappserver.screens.poisk


sealed class Routes(val route: String) {
    object Home : Routes("home")
    object Search : Routes("search")
    object Account : Routes("account")
    object Begin: Routes(com.example.myappserver.navigation.NV.Routes.Benin.toString())
}


@Composable
fun BottomNavigationBar(navController: NavHostController) {
    BottomNavigation(modifier = Modifier.height(50.dp)) {

        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Search, contentDescription = "Search") },
            label = { Text("Search") },
            selected = navController.currentDestination?.route == Routes.Home.route,
            onClick = { navController.navigate(Routes.Home.route) }
        )

        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Add, contentDescription = "Home") },
            label = { Text("Add") },
            selected = navController.currentDestination?.route == Routes.Search.route,
            onClick = { navController.navigate(Routes.Search.route) }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.AccountCircle, contentDescription = "Account") },
            label = { Text("Account") },
            selected = navController.currentDestination?.route == Routes.Account.route,
            onClick = { navController.navigate(Routes.Account.route) }
        )

    }
}


@Preview
@Composable
fun compose(){
    MyApp()
}

