package com.smaillimp.yatzy.presentation.game.dice

import android.util.Log
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner

@Composable
fun DiceView(
    viewModel: DiceViewModel = hiltViewModel()
) {
//    val viewModel = hiltViewModel<DiceViewModel>()
    val state = viewModel.state.value
    Log.i("XX", viewModel.toString())
    Log.i("XX", LocalViewModelStoreOwner.current.toString())
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
