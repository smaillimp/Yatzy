package com.smaillimp.yatzy

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object PlayerScreen : Screen("player_screen")
    object  GameScreen : Screen("game_screen")
}
