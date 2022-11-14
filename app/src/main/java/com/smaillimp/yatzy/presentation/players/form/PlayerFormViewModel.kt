package com.smaillimp.yatzy.presentation.players.form

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smaillimp.yatzy.feature.players.usecase.PlayerUseCases
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
                val playerNameValidationResult = playerUseCases.validatePlayerName(event.player.name)
                val hasError = listOf(playerNameValidationResult).any { !it.successful }

                if (hasError) {
                    _state.value = state.value.copy(
                        playerNameError = playerNameValidationResult.errorMessage,
                    )
                    return
                }
                viewModelScope.launch {
                    playerUseCases.addPlayer(event.player)
                }
                _state.value = PlayerFormState()
            }
            is PlayerFormEvent.ChangePlayerName -> {
                _state.value = state.value.copy(playerName = event.player.name)
            }
        }
    }
}
