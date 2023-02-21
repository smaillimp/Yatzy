package com.smaillimp.yatzy.presentation.game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.smaillimp.yatzy.presentation.game.dice.DiceView

@Composable
fun GameScreen() {
    Column(
        modifier = Modifier
            .padding(32.dp),
        verticalArrangement = Arrangement.Center
    ) {
        DiceView()
        DiceView()
        DiceView()
        DiceView()
        DiceView()
    }
}