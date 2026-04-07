package com.example.heart2heartapp.View_model

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            var currentScreen by remember { mutableStateOf("home-screen") }

            Column {
                Text(
                    text = "Heart2Heart",
                    fontSize = 45.sp
                )

                NavHost(navController = navController, startDestination = "home-screen") {
                    composable("home-screen") {
                        HomeScreen(
                            "benjamin",
                            currentScreen = currentScreen,
                            onScreen1ButtonClick = {
                                currentScreen = "home-screen"
                                navController.navigate("home-screen"){launchSingleTop = true}

                            },
                            onScreen2ButtonClick = {
                                currentScreen = "2"
                                navController.navigate("screen-2")

                            },
                            onScreen3ButtonClick = {
                                currentScreen = "3"
                                navController.navigate("screen-3")

                            }
                        )
                    }
                    composable("screen-2") {
                        Screen2(
                            "benjamin",
                            currentScreen = currentScreen,
                            onScreen1ButtonClick = {
                                currentScreen = "home-screen"
                                navController.navigate("home-screen") {launchSingleTop = true}

                            },
                            onScreen2ButtonClick = {
                                currentScreen = "2"
                                navController.navigate("screen-2") {launchSingleTop = true}

                            },
                            onScreen3ButtonClick = {
                                currentScreen = "3"
                                navController.navigate("screen-3")

                            }
                        )
                    }
                    composable("screen-3") {
                        Screen3(
                            "benjamin",
                            currentScreen = currentScreen,
                            onScreen1ButtonClick = {
                                currentScreen = "home-screen"
                                navController.navigate("home-screen") {launchSingleTop = true}

                            },
                            onScreen2ButtonClick = {
                                currentScreen = "2"
                                navController.navigate("screen-2")

                            },
                            onScreen3ButtonClick = {
                                currentScreen = "3"
                                navController.navigate("screen-3") {launchSingleTop = true}

                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(
    name: String,
    currentScreen: String,
    onScreen2ButtonClick: () -> Unit,
    onScreen3ButtonClick: () -> Unit,
    onScreen1ButtonClick: () -> Unit
) {
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 16.dp, vertical = 15.dp))

    {
        Column(modifier = Modifier
            .weight(1f)){
            Text(
                text = "Screen 1",
                fontSize = 32.sp
            )
            Text(
                text = "Hello $name!"
            )

        }
        Row ( modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                RoundedCornerShape(50.dp)
            )
            .border(
                width = 1.dp,
                color = Color(0xFFE0E0E0),
                shape = RoundedCornerShape(50.dp)
            ),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom){

            val pink = Color(0xFFE91E8C)
            val grey = Color(0xFF9E9E9E)

            IconButton(onClick = onScreen1ButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.Home,
                    contentDescription = "Home",
                    tint = if (currentScreen == "home-screen") pink else grey,
                    modifier = Modifier.size(50.dp)
                )
            }

            IconButton(onClick = onScreen2ButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.Favorite,
                    contentDescription = "Map",
                    tint = if (currentScreen == "2") pink else grey,
                    modifier = Modifier.size(50.dp)
                )
            }

            IconButton(onClick = onScreen3ButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = "Community",
                    tint = if (currentScreen == "3") pink else grey,
                    modifier = Modifier.size(50.dp)
                )
            }
        }
    }
}


@Composable
fun Screen2( name: String,
             currentScreen: String,
             onScreen2ButtonClick: () -> Unit,
             onScreen3ButtonClick: () -> Unit,
             onScreen1ButtonClick: () -> Unit
) {
    Column (modifier = Modifier
        .fillMaxSize())
    {
        Column(modifier = Modifier
            .weight(1f)){
            Text(
                text = "Screen 2",
                fontSize = 32.sp
            )
            Text(
                text = "Hello $name!"
            )
        }
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom){

            val pink = Color(0xFFE91E8C)
            val grey = Color(0xFF9E9E9E)

            IconButton(onClick = onScreen1ButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.Home,
                    contentDescription = "Home",
                    tint = if (currentScreen == "home-screen") pink else grey,
                    modifier = Modifier.size(50.dp)
                )
            }

            IconButton(onClick = onScreen2ButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.Favorite,
                    contentDescription = "Map",
                    tint = if (currentScreen == "2") pink else grey,
                    modifier = Modifier.size(50.dp)
                )
            }

            IconButton(onClick = onScreen3ButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = "Community",
                    tint = if (currentScreen == "3") pink else grey,
                    modifier = Modifier.size(50.dp)
                )
            }
        }
    }
}


@Composable
fun Screen3( name: String,
             currentScreen: String,
             onScreen2ButtonClick: () -> Unit,
             onScreen3ButtonClick: () -> Unit,
             onScreen1ButtonClick: () -> Unit
) {
    Column (modifier = Modifier
        .fillMaxSize())
    {
        Column(modifier = Modifier
            .weight(1f)){
            Text(
                text = "Screen 3",
                fontSize = 32.sp
            )
            Text(
                text = "Hello $name!"
            )
        }
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom){

            val pink = Color(0xFFE91E8C)
            val grey = Color(0xFF9E9E9E)

            IconButton(onClick = onScreen1ButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.Home,
                    contentDescription = "Home",
                    tint = if (currentScreen == "home-screen") pink else grey,
                    modifier = Modifier.size(50.dp)
                )
            }

            IconButton(onClick = onScreen2ButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.Favorite,
                    contentDescription = "Map",
                    tint = if (currentScreen == "2") pink else grey,
                    modifier = Modifier.size(50.dp)
                )
            }

            IconButton(onClick = onScreen3ButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = "Community",
                    tint = if (currentScreen == "3") pink else grey,
                    modifier = Modifier.size(50.dp)
                )
            }
        }
    }
}
