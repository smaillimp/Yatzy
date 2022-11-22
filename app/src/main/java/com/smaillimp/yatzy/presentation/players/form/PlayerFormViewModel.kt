package com.smaillimp.yatzy.presentation.players.form

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smaillimp.yatzy.feature.players.usecase.PlayerUseCases
import com.smaillimp.yatzy.feature.players.usecase.ValidationResult
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
            is PlayerFormEvent.Submit -> onSubmit(event)
            is PlayerFormEvent.ChangePlayerName -> onPlayerNameChange(
                event.player.name
            )
            is PlayerFormEvent.clearPlayerName -> clearPlayerName()
        }
    }

    private fun onPlayerNameChange(playerName: String) {
        updatePlayerName(playerName)
        publishError(validatePlayerName(playerName).errorMessage)
    }

    private fun onSubmit(event: PlayerFormEvent.Submit) {
        val validationResult = validatePlayerName(event.player.name)
        if (validationResult.successful) {
            addPlayer(event)
            clearPlayerName()
        } else {
            publishError(validationResult.errorMessage)
        }
    }

    private fun updatePlayerName(playerName: String) {
        _state.value = state.value.copy(playerName = playerName)
    }

    private fun addPlayer(event: PlayerFormEvent.Submit) {
        viewModelScope.launch {
            playerUseCases.addPlayer(event.player)
        }
        clearPlayerName()
    }

    private fun validatePlayerName(playerName: String): ValidationResult {
        return playerUseCases.validatePlayerName(playerName)
    }

    private fun publishError(error: String?) {
        _state.value = state.value.copy(playerNameError = error)
    }

    private fun clearPlayerName() {
        _state.value = PlayerFormState()
    }
}
