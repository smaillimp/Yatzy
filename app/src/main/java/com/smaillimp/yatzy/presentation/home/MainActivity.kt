package com.smaillimp.yatzy.presentation.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.smaillimp.yatzy.Screen
import com.smaillimp.yatzy.presentation.game.GameScreen
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
                    PlayerSelectionScreen(navController = navController)
                }
                composable(route = Screen.GameScreen.route) {
                    GameScreen()
                }
            }
        }
    }
}

@Composable
fun Home(navController: NavController) {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        Button(onClick = { navController.navigate(Screen.PlayerScreen.route) }) {
            Text(text = "Edit Players")
        }
    }
}

@Composable
fun PlayerSelectionScreen(navController: NavController) {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        Column() {
            PlayerScreen()
            Button(
                onClick = { navController.navigate(Screen.GameScreen.route) },
            ) {
                Text(text = "Start Game")
            }
        }
    }
}
