package com.example.myappserver.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myappserver.ui.theme.MyAppServerTheme

@Composable
fun BeginerScreen(onClick: () -> Unit, onClick2: () -> Unit){


    Column(modifier = Modifier
        .background(Color.White)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = "WorkCity",
            fontSize = 28.sp,
            modifier = Modifier.padding(40.dp))

        Button(onClick = {onClick()},
            modifier = Modifier
                .width(350.dp),
            shape = RoundedCornerShape(15.dp)) {
            Text(text = "Нужно найти работу", fontSize = 20.sp, modifier = Modifier.padding(5.dp))

        }

        Spacer(modifier = Modifier.padding(20.dp))

        Button(onClick = {onClick2()}, modifier = Modifier
            .width(350.dp),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(text = "Нужно найти новые кадры", fontSize = 20.sp, modifier = Modifier.padding(5.dp))
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyAppServerTheme {
        BeginerScreen(onClick = { /*TODO*/ }) {

        }
    }
}