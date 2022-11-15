package com.smaillimp.yatzy.presentation.players.list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PlayersListView() {
    val viewModel = hiltViewModel<PlayersListViewModel>()
    val state = viewModel.state.value

    LazyColumn() {
        items(state.players) {
            player ->
            Text(
                text = player.name
            )
        }
    }
}
