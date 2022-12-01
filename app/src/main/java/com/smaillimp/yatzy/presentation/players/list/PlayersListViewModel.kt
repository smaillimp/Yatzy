package com.smaillimp.yatzy.presentation.players.list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smaillimp.yatzy.feature.players.model.Player
import com.smaillimp.yatzy.feature.players.usecase.PlayerUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayersListViewModel @Inject constructor(
    private val playerUseCases: PlayerUseCases,
    private val defaultDispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _state = mutableStateOf(PlayersListState())
    val state: State<PlayersListState> = _state

    private var getUsersJob: Job? = null

    init {
        getUsers()
    }

    fun onEvent(event: PlayersListEvent) {
        when (event) {
            is PlayersListEvent.DeletePlayerName -> deletePlayer(event.player)
        }
    }

    private fun deletePlayer(player: Player) {
        viewModelScope.launch(defaultDispatcher) {
            playerUseCases.deletePlayer(player)
        }
    }

    private fun getUsers() {
        getUsersJob?.cancel()
        getUsersJob = viewModelScope.launch(defaultDispatcher) {
            playerUseCases.getPlayers().onEach { players ->
                _state.value = state.value.copy(players = players)
            }.collect()
        }
    }
}
