package com.example.heart2heartapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.heart2heartapp.classes.EventViewModel

@Composable
fun HomeScreen(name: String,
    onEventClick: (Int) -> Unit
) {
    val eventViewModel = viewModel<EventViewModel>()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF)),
    ) {
        LazyColumn() {
            items(eventViewModel.events) { event ->
                Image(painter = painterResource(event.image), contentDescription = "Event image")
                Text(event.name)
                Button(onClick = { onEventClick(event.id) }) {
                    Text("Se Event")
                }
            }
        }
    }
}