package com.example.heart2heartapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.heart2heartapp.classes.viewModel.EventViewModel
import com.example.heart2heartapp.components.BottomNavBar
import com.example.heart2heartapp.screens.ChatScreen
import com.example.heart2heartapp.screens.EventScreen
import com.example.heart2heartapp.screens.HeartScreen
import com.example.heart2heartapp.screens.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val eventViewModel = viewModel<EventViewModel>()
            val navController = rememberNavController()
            Scaffold(
                containerColor = Color(0xFFFFFFFF),
                bottomBar = { BottomNavBar(navController) }) { innerPadding ->
                NavHost(
                    navController = navController,
                    startDestination = "heart-screen",
                    modifier = Modifier.padding(innerPadding)
                ) {

                    composable("home-screen") {
                        HomeScreen(
                            name = "HomeID",
                            onEventClick = { id ->
                                navController.navigate("event-screen/${id}") {
                                    launchSingleTop = true
                                }
                            }
                        )
                    }

                    composable("event-screen/{id}",
                        arguments = listOf(navArgument("id") { type = NavType.IntType })
                    ) {
                        backStackEntry ->
                        val id = backStackEntry.arguments?.getInt("id") ?: return@composable
                        EventScreen(eventId = id, eventViewModel = eventViewModel)
                    }

                    composable("heart-screen") {
                        HeartScreen(
                            name = "HeartID",
                            onArgumentsButtonClick = {
                                val stringToSend = "Clicked from heart"
                                navController.navigate("sendArgumentsHere/${stringToSend}") {
                                    launchSingleTop = true
                                }
                            }
                        )
                    }

                    composable("chat-screen") {
                        ChatScreen()
                    }
                }
            }
        }
    }
}