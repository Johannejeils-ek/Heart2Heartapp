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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.heart2heartapp.classes.EventViewModel
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
                bottomBar = { BottomNavBar(navController) }) { innerPadding ->
                NavHost(
                    navController = navController,
                    startDestination = "home-screen",
                    modifier = Modifier.padding(innerPadding)
                ) {

                    composable("home-screen") {
                        HomeScreen(
                            name = "HomeID",
                            navController = navController,
                            onArgumentsButtonClick = {
                                val stringToSend = "Clicked from home"
                                val eventId = "3"
                                // this is how the "url" will look: sendArgumentsHere/Benjamin
                                navController.navigate("eventBuilder/${eventId}") {
                                    launchSingleTop = true
                                }
                            })
                    }

                    composable("heart-screen") {
                        HeartScreen(
                            name = "HeartID", onArgumentsButtonClick = {
                                val stringToSend = "Clicked from heart"
                                // this is how the "url" will look: sendArgumentsHere/Benjamin
                                navController.navigate("sendArgumentsHere/${stringToSend}"){
                                    launchSingleTop = true
                                }

                            })
                    }

                    composable("chat-screen") {
                        ChatScreen(
                            name = "ChatID", onArgumentsButtonClick = {
                                val stringToSend = "Clicked from chat"
                                // this is how the "url" will look: sendArgumentsHere/Benjamin
                                navController.navigate("sendArgumentsHere/${stringToSend}"){
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

// NAVBAR-------------------------------------------------
@Composable
fun BottomNavBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val pink = Color(0xFFE91E8C)
    val grey = Color(0xFF9E9E9E)

    NavigationBar(
        containerColor = Color.Transparent,
        tonalElevation = 0.dp,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(50.dp)
            )
            .border(
                width = 1.dp,
                color = Color(0xFFE0E0E0),
                shape = RoundedCornerShape(50.dp)
            )
    ) {
// HOME
        NavigationBarItem(
            selected = currentRoute == "home-screen",
            onClick = {
                navController.navigate("home-screen") { launchSingleTop = true }
            },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Home,
                    contentDescription = "Home",
                    tint = if (currentRoute == "home-screen") pink else grey,
                    modifier = Modifier.size(32.dp)
                )
            },
            label = null
        )

        // HEART
        NavigationBarItem(
            selected = currentRoute == "heart-screen",
            onClick = {
                navController.navigate("heart-screen") { launchSingleTop = true }
            },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Favorite,
                    contentDescription = "Heart",
                    tint = if (currentRoute == "heart-screen") pink else grey,
                    modifier = Modifier.size(32.dp)
                )
            },
            label = null
        )

        // CHAT
        NavigationBarItem(
            selected = currentRoute == "chat-screen",
            onClick = {
                navController.navigate("chat-screen") { launchSingleTop = true }
            },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = "Chat",
                    tint = if (currentRoute == "chat-screen") pink else grey,
                    modifier = Modifier.size(32.dp)
                )
            },
            label = null
        )
    }
}