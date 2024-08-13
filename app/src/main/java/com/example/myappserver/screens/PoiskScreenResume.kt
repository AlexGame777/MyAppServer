package com.example.myappserver.screens

import WebServer.ResumesApi
import WebServer.VacanciesApi
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
import com.example.myappserver.models.Resume


@Composable
fun poiskR (){

    ResumeListScreen()

}


@Composable
fun SearchBarR(onSearch: (String) -> Unit) {
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
fun ResumeListScreen() {
    var resumes by remember { mutableStateOf<List<Resume>>(emptyList()) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            val fetchedResume = withContext(Dispatchers.IO) {
                ResumesApi.fetchResumes()
            }
            resumes = fetchedResume
        }
    }

    Scaffold(

    ) { innerPadding ->

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {

            Spacer(modifier = Modifier.padding(15.dp))
            SearchBarR {
                // Search functionality here
            }

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(resumes) { resume ->
                    ResumeItem(resume)
                }
            }
        }
    }

}




@Composable
fun ResumeItem(resume: Resume) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            androidx.compose.material3.Text(text = "Имя: ${resume.name}", style = MaterialTheme.typography.headlineMedium)
            androidx.compose.material3.Text(text = "Специальность: ${resume.position}")
            androidx.compose.material3.Text(text = "Опыт: ${resume.experience}")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun expirR(){
    poisk()
}