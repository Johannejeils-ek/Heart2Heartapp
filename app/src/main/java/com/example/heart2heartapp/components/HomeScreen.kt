package com.example.heart2heartapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.heart2heartapp.classes.EventViewModel

@Composable
fun HomeScreen(name: String, onArgumentsButtonClick: () -> Unit) {
    val eventViewModel = viewModel<EventViewModel>();
    val navController = rememberNavController()
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
        /*
        HomeScreen({
            navController.navigate("screen-2")
        })

         */
    }
}