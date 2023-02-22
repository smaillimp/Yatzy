package com.smaillimp.yatzy.presentation.game

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smaillimp.yatzy.feature.players.usecase.PlayerUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val playerUseCases: PlayerUseCases,
    private val defaultDispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _state = mutableStateOf(GameState())
    val state: State<GameState> = _state

    private var getUsersJob: Job? = null

    init {
        getUsers()
    }

    fun onEvent(event: GameEvent) {
        _state.value = state.value.copy(
            gameEvents = state.value.gameEvents.plus(event)
        )
        when (event) {
            is GameEvent.PlayerSelected -> {
                _state.value = state.value.copy(players = state.value.players.plus(event.player))
            }
            is GameEvent.PlayerUnselected -> {
                _state.value = state.value.copy(players = state.value.players.minus(event.player))
            }
            is GameEvent.LoadedPlayers -> {
                onEvent(GameEvent.SelectPlayers(event.players))
            }
            is GameEvent.NextStep -> {
                when (state.value.phase) {
                    is GamePhase.SelectingPlayers -> {
                        _state.value = state.value.copy(phase = GamePhase.Rounds)
                        onEvent(GameEvent.NextStep)
                    }
                    GamePhase.Rounds -> {
                        if (state.value.activePlayerIndex >= (state.value.players.size - 1)) {
                            _state.value = state.value.copy(activePlayerIndex = 0)
                        } else {
                            _state.value =
                                state.value.copy(activePlayerIndex = state.value.activePlayerIndex + 1)
                        }
                        onEvent(GameEvent.PlayerTurn(state.value.players[state.value.activePlayerIndex]))
                    }
                    GamePhase.End ->  Unit
                }
            }
        }
    }

    private fun getUsers() {
        getUsersJob?.cancel()
        onEvent(GameEvent.LoadingPlayers)
        getUsersJob = viewModelScope.launch(defaultDispatcher) {
            playerUseCases.getPlayers().onEach { players ->
                onEvent(GameEvent.LoadedPlayers(players))
            }.collect()
        }
    }
}
