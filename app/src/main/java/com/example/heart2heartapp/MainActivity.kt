package com.example.heart2heartapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.heart2heartapp.classes.EventViewModel
import com.example.heart2heartapp.components.BottomNavBar
import com.example.heart2heartapp.screens.ChatScreen
import com.example.heart2heartapp.screens.HeartScreen
import com.example.heart2heartapp.screens.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val BricolageFont = FontFamily(
            Font(R.font.bricolagegrotesque_medium, FontWeight.Medium)
        )
        val PoppinsFont = FontFamily(
            Font(R.font.poppins_regular, FontWeight.Normal)
        )

        setContent {
            val eventViewModel = viewModel<EventViewModel>();
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
                            navController = navController,
                            onArgumentsButtonClick = {
                                composable("event-bubble/{id}", arguments = listOf(navArgument("id") { type = NavType.IntType })) { backStackEntry ->
                                    val id = backStackEntry.arguments?.getInt("id") ?: return@composable
                                    val foundEvent = eventViewModel.getEvent(id)
                                    if(foundEvent!= null) {
                                        Text(text = "Event name: ${foundEvent.name}. Id: ${foundEvent.id}")
                                    }
                                }
                            })
                    }

                    composable("heart-screen") {
                        HeartScreen(
                            name = "HeartID", onArgumentsButtonClick = {
                                val stringToSend = "Clicked from heart"
                                // this is how the "url" will look: sendArgumentsHere/Benjamin
                                navController.navigate("sendArgumentsHere/${stringToSend}") {
                                    launchSingleTop = true
                                }

                            })
                    }

                    composable("chat-screen") {
                        ChatScreen(
                            name = "ChatID", onArgumentsButtonClick = {
                                val stringToSend = "Clicked from chat"
                                // this is how the "url" will look: sendArgumentsHere/Benjamin
                                navController.navigate("sendArgumentsHere/${stringToSend}") {
                                    launchSingleTop = true
                                }

                            })
                    }

                    /*
                    testing

                    composable(
                        "sendArgumentsHere/{name}",
                        arguments = listOf(navArgument("name") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val name = backStackEntry.arguments?.getString("name") ?: return@composable
                        SendArgumentsHere(name)
                    }
                    composable(
                        "eventBuilder/{id}",
                        arguments = listOf(navArgument("id") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val id = backStackEntry.arguments?.getString("id") ?: return@composable
                        EventBuilder(id)
                    }
                    composable("event-page/{id}", arguments = listOf(navArgument("id") { type = NavType.IntType })) { backStackEntry ->
                        val id = backStackEntry.arguments?.getInt("id") ?: return@composable
//                        val foundEvent = EventViewModel.getEvent(id)
//                        if(foundEvent!= null) {
//                            Text(text = "Event name: ${foundEvent.name}. Id: ${foundEvent.id}")
//                        }



                    }



                     */
                }
            }
        }
    }
}

@Composable
fun SendArgumentsHere(name: String) {
    Text(text = "send argument Argument: $name")
}

@Composable
fun EventBuilder(id: String) {
    Text(text = "Event builder - Argument: $id")
}