package com.smaillimp.yatzy.presentation.players.list

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

    private fun getUsers() {
        getUsersJob?.cancel()
        getUsersJob = viewModelScope.launch(defaultDispatcher) {
            playerUseCases.getPlayers().onEach { players ->
                _state.value = state.value.copy(players = players)
            }.collect()
        }
    }
}
