package com.smaillimp.yatzy.presentation.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.smaillimp.yatzy.Screen
import com.smaillimp.yatzy.presentation.players.PlayerScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
                composable(route = Screen.MainScreen.route) {
                    Home(navController)
                }
                composable(route = Screen.PlayerScreen.route) {
                    PlayerScreen()
                }
            }
        }
    }
}

@Composable
fun Home(navController: NavController) {
    Button(onClick = { navController.navigate(Screen.PlayerScreen.route) }) {
        Text(text = "Edit Players")
    }
}
