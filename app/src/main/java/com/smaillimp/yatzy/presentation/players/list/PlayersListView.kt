package com.smaillimp.yatzy.presentation.players.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.smaillimp.yatzy.feature.players.model.Player

@Composable
fun PlayersListView() {
    val viewModel = hiltViewModel<PlayersListViewModel>()
    val state = viewModel.state.value

    LazyColumn() {
        items(state.players) { player ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = player.name
                )
                DeletePlayerButton(viewModel, player)
            }
        }
    }
}

@Composable
fun DeletePlayerButton(viewModel: PlayersListViewModel, player: Player) {
    IconButton(
        onClick = {
            viewModel.onEvent(
                PlayersListEvent.DeletePlayerName(player = player)
            )
        }
    ) {
        Icon(
            Icons.Rounded.Delete,
            contentDescription = "Delete"
        )
    }
}
