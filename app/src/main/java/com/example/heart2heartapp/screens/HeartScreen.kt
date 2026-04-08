package com.example.heart2heartapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeartScreen(name: String, onArgumentsButtonClick: () -> Unit) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
            .padding(
                top = 40.dp,
            ),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Text(
            text = "Din Heart2Heart",
            fontSize = 50.sp

        )
        Text(
            text = "nøglering er",
            fontSize = 50.sp
        )
        Text(
            text = "connected",
            fontSize = 50.sp
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom

            ) {
            Button(onClick = onArgumentsButtonClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF77B7), // background color
                    contentColor = Color.White          // text/icon color
                )) {
                Text(
                    text = "Disconnect",
                    fontSize = 24.sp
                )
            }
        }


    }
}
