package com.smaillimp.yatzy.presentation.game.dice

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.smaillimp.yatzy.feature.game.usecase.RollDice
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DiceViewModel @Inject constructor(
    private val rollUseCase: RollDice
) : ViewModel() {
    private val _state = mutableStateOf(DiceState())
    val state: State<DiceState> = _state

    fun onEvent(event: DiceEvent) {
        when (event) {
            is DiceEvent.RollDice -> {
                rollUseCase(state.value.dice)
                _state.value = state.value.copy(eyes = state.value.dice.eyes)
            }
        }
    }
}