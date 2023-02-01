package com.smaillimp.yatzy.presentation.game.dice

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DiceView() {
    val viewModel = hiltViewModel<DiceViewModel>()
    val state = viewModel.state.value

    Dice(viewModel = viewModel, state = state)
}

@Composable
fun Dice(viewModel: DiceViewModel, state: DiceState) {
    Button(onClick = {
        viewModel.onEvent(
            DiceEvent.RollDice
        )
    }) {
        Text(text = state.eyes.toString())
    }
}
