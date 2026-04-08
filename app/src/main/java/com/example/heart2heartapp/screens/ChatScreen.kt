package com.example.heart2heartapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun ChatScreen(name: String, onArgumentsButtonClick: () -> Unit) {
    Column {
        Text(
            text = "Chat screen",
            fontSize = 32.sp
        )
        Text(
            text = "Welcome to chat!"
        )
        Button(onClick = onArgumentsButtonClick) {
            Text("Send argument")
        }
    }
}