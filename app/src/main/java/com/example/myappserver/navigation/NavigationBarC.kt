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
import androidx.navigation.compose.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myappserver.screens.AccountScreen
import com.example.myappserver.screens.MyAppC
import com.example.myappserver.screens.poisk


sealed class RoutesC(val route: String) {
    object HomeC : RoutesC("home")
    object SearchC : RoutesC("search")
    object AccountC : RoutesC("account")
}


@Composable
fun BottomNavigationBarC(navController: NavHostController) {
    BottomNavigation(modifier = Modifier.height(50.dp)) {
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Search, contentDescription = "Search") },
            label = { Text("Search") },
            selected = navController.currentDestination?.route == RoutesC.HomeC.route,
            onClick = { navController.navigate(RoutesC.HomeC.route) }
        )

        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Add, contentDescription = "Home") },
            label = { Text("Home") },
            selected = navController.currentDestination?.route == RoutesC.SearchC.route,
            onClick = { navController.navigate(RoutesC.SearchC.route) }
        )

        BottomNavigationItem(
            icon = { Icon(Icons.Filled.AccountCircle, contentDescription = "Account") },
            label = { Text("Account") },
            selected = navController.currentDestination?.route == RoutesC.AccountC.route,
            onClick = { navController.navigate(RoutesC.AccountC.route) }
        )
    }
}


@Preview
@Composable
fun composeC(){
    MyAppC()
}

