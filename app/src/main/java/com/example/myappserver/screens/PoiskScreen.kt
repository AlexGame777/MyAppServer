package com.example.myappserver.screens

import WebServer.VacanciesApi
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myappserver.models.Vacancy
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable



@Composable
fun poisk (){

    VacancyListScreen()

}


@Composable
fun SearchBar(onSearch: (String) -> Unit) {
    var searchQuery by remember { mutableStateOf("") }

    TextField(
        value = searchQuery,
        onValueChange = {
            searchQuery = it
            onSearch(it)
        },
        label = { Text("Search") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    )
}






@Composable
fun VacancyListScreen() {
    var vacancies by remember { mutableStateOf<List<Vacancy>>(emptyList()) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            val fetchedVacancies = withContext(Dispatchers.IO) {
                VacanciesApi.fetchVacancies()
            }
            vacancies = fetchedVacancies
        }
    }

    Scaffold(

    ) { innerPadding ->

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {

            Spacer(modifier = Modifier.padding(15.dp))
            SearchBar {
                // Search functionality here
            }

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(vacancies) { vacancy ->
                    VacancyItem(vacancy)
                }
            }
        }
    }

}




@Composable
fun VacancyItem(vacancy: Vacancy) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Название: ${vacancy.name_v}", style = MaterialTheme.typography.headlineMedium)
            Text(text = "Зарплата: ${vacancy.zp}")
            Text(text = "Компания: ${vacancy.name_comp}")
            Text(text = "Город: ${vacancy.city}")
            Text(text = "Опыт: ${vacancy.prof_exp}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun expir(){
    poisk()
}