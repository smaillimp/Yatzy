package com.smaillimp.yatzy.presentation.game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.smaillimp.yatzy.feature.players.model.Player

@Composable
fun GameScreen() {
    val viewModel = hiltViewModel<GameViewModel>()
    val state = viewModel.state.value
    Column {
        LazyColumn(
            modifier = Modifier
                .padding(32.dp),
            verticalArrangement = Arrangement.Center
        ) {
            items(state.gameEvents) { event ->
                when (event) {
                    is GameEvent.LoadingPlayers -> {
                        EventContainerCard { Loading() }
                    }
                    is GameEvent.LoadedPlayers -> {
                        EventContainerCard { Loaded() }
                    }
                    is GameEvent.SelectPlayers -> {
                        EventContainerCard {
                            PlayerSelector(
                                players = event.players,
                                viewModel = viewModel,
                                state = state
                            )
                        }
                    }
                    is GameEvent.PlayerTurn -> {
                        EventContainerCard { StartOfTurn(name = event.player.name) }
                    }
                    is GameEvent.NextStep -> {
                        EventContainerCard { Continue() }
                    }
                }
            }
        }
        Button(
            onClick = { viewModel.onEvent(GameEvent.NextStep) }
        ) {
            Text(text = "Next Round")
        }
    }
}

@Composable
fun EventContainerCard(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        elevation = 10.dp
    ) {
        content()
    }

}

@Composable
fun StartOfTurn(name: String) {
    Text(text = "It's $name turn...")
}

@Composable
fun Continue() {
    Text(text = "Continuing...")
}

@Composable
fun Loading() {
    Text(text = "Loading...")
}

@Composable
fun Loaded() {
    Text("Loaded...")
}

@Composable
fun PlayerSelector(players: List<Player>, viewModel: GameViewModel, state: GameState) {
    Column() {
        players.forEach { player ->
            Row {
                Checkbox(checked = player in state.players, onCheckedChange = {
                    if (it) {
                        viewModel.onEvent(GameEvent.PlayerSelected(player))
                    } else {
                        viewModel.onEvent(GameEvent.PlayerUnselected(player))
                    }
                })
                Text(player.name)
            }
        }
    }
}