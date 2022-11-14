package com.smaillimp.yatzy.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smaillimp.yatzy.feature_player.use_case.PlayerUseCases
import com.smaillimp.yatzy.presentation.players.form.PlayerFormEvent
import com.smaillimp.yatzy.presentation.players.form.PlayerFormState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayerFormViewModel @Inject constructor(
    private val playerUseCases: PlayerUseCases,
) : ViewModel() {
    private val _state = mutableStateOf(PlayerFormState())
    var state: State<PlayerFormState> = _state

    fun onEvent(event: PlayerFormEvent) {
        when (event) {
            is PlayerFormEvent.AddPlayer -> {
                viewModelScope.launch {
                    playerUseCases.addPlayer(event.player)
                }
            }
            is PlayerFormEvent.ChangePlayerName -> {
                _state.value = state.value.copy(playerName = event.player.name)
            }
        }
    }
}
