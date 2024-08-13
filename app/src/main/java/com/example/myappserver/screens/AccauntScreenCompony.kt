package com.example.myappserver.screens

import WebServer.ResumesApi
import WebServer.VacanciesApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myappserver.R
import com.example.myappserver.models.Resume
import com.example.myappserver.models.Vacancy
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun AccountScreenC() {

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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.image_icon),
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .padding(top = 16.dp)
            )

            // Display user name
            Text(
                text = "Имя пользователя",
                fontSize = 24.sp,
                modifier = Modifier.padding(top = 16.dp)
            )

            // Display user email
            Text(
                text = "email@domain.com",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 8.dp)
            )

            // Display buttons for different actions
            Button(
                onClick = { /* Navigate to edit profile screen */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Text(text = "Редактировать профиль")
            }

            Button(
                onClick = { /* Navigate to settings screen */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Text(text = "Настройки")
            }

            Button(
                onClick = { /* Log out */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Text(text = "Выйти")
            }

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(vacancies) { vacancy ->
                    VacancyItemAC(vacancy)
                }
            }

        }
    }
}


@Composable
fun VacancyItemAC(vacancy: Vacancy) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            androidx.compose.material3.Text(
                text = "Название: ${vacancy.name_v}",
                style = MaterialTheme.typography.headlineMedium
            )
            androidx.compose.material3.Text(text = "Зарплата: ${vacancy.zp}")
            androidx.compose.material3.Text(text = "Компания: ${vacancy.name_comp}")
            androidx.compose.material3.Text(text = "Город: ${vacancy.city}")
            androidx.compose.material3.Text(text = "Опыт: ${vacancy.prof_exp}")
        }
    }
}



@Preview
@Composable
fun asountC(){
    AccountScreenC()
}