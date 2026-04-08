package com.example.heart2heartapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.heart2heartapp.classes.EventViewModel

@Composable
fun HomeScreen(name: String, navController: NavController, onArgumentsButtonClick: () -> Unit) {
    val eventViewModel = viewModel<EventViewModel>()
    Column {
        LazyColumn() {
            items(eventViewModel.events) { event ->
                Text(event.name)
                Button(onClick = {
                    navController.navigate("user-page/${event.id}")
                }) {
                    Text("See user")
                }
            }
        }
    }
}