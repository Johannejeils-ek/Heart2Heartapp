package com.example.heart2heartapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun HeartScreen(name: String, onArgumentsButtonClick: () -> Unit) {
    Column {
        Text(
            text = "Heart screen",
            fontSize = 32.sp
        )
        Text(
            text = "Hello $name!"
        )
        Button(onClick = onArgumentsButtonClick) {
            Text("Not yet working")
        }
    }
}