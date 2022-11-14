package com.smaillimp.yatzy.presentation.players.list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smaillimp.yatzy.feature_player.use_case.PlayerUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PlayersListViewModel @Inject constructor(
    private val playerUseCases: PlayerUseCases,
) : ViewModel() {
    private val _state = mutableStateOf(PlayersListState())
    val state: State<PlayersListState> = _state

    private var getUsersJob: Job? = null

    init {
        getUsers()
    }

    private fun getUsers() {
        getUsersJob?.cancel()
        getUsersJob = playerUseCases.getPlayers().onEach {
                users -> _state.value = state.value.copy(players=users)
        }.launchIn(viewModelScope)
    }
}
