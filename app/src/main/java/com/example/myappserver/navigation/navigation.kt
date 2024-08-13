package com.example.myappserver.navigation.NV

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.myappserver.screens.AccountScreen
import com.example.myappserver.screens.AuthScreen
import com.example.myappserver.screens.BeginerScreen
import com.example.myappserver.screens.CreateResumeScreen
import com.example.myappserver.screens.MyApp
import com.example.myappserver.screens.MyAppC
import com.example.myappserver.screens.authC
import com.example.myappserver.screens.poisk
import com.example.myappserver.screens.regC
import com.example.myappserver.screens.registerScreen


sealed class Routes(val rout: String){
    object Reg : Routes("reg")
    object Benin : Routes("begin")
    object RegC: Routes("regc")
    object Auth : Routes("auth")
    object Poisk : Routes("poisk")
    object AuthC: Routes("authc")
    object Beg: Routes("Beg")
    object PoiskC : Routes("poiskC")
}

@Composable
fun start(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.Benin.rout) {

        composable(Routes.Beg.rout){ CreateResumeScreen()}
        composable(Routes.Benin.rout) { BeginerScreen(
            onClick = {navController.navigate(Routes.Reg.rout)},
            onClick2 = {navController.navigate(Routes.RegC.rout)})}
        composable(Routes.RegC.rout){ regC{navController.navigate(Routes.AuthC.rout)}}
        composable(Routes.AuthC.rout){ authC{navController.navigate(Routes.PoiskC.rout)}}
        composable(Routes.PoiskC.rout){ MyAppC()}
        composable(Routes.Reg.rout) { registerScreen{navController.navigate(Routes.Auth.rout)}}
        composable(Routes.Auth.rout) { AuthScreen{navController.navigate(Routes.Poisk.rout)} }
        composable(Routes.Poisk.rout) { MyApp()}
    }
}


