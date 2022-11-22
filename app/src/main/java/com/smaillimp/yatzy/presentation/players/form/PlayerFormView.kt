package com.smaillimp.yatzy.presentation.players.form

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import com.smaillimp.yatzy.feature.players.model.Player

@Composable
fun PlayerFormView() {
    val viewModel = hiltViewModel<PlayerFormViewModel>()
    InputWithError(viewModel = viewModel)
    AddPlayerButton(viewModel = viewModel)
    MockClearFormButton(viewModel = viewModel)
}

@Composable
fun InputWithError(viewModel: PlayerFormViewModel) {
    val state = viewModel.state.value
    TextField(
        value = state.playerName,
        onValueChange = {
            viewModel.onEvent(PlayerFormEvent.ChangePlayerName(Player(it)))
        },
        isError = state.playerNameError != null,
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            Text(text = "Player Name")
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Ascii
        )
    )
    if (state.playerNameError != null) {
        Text(
            text = state.playerNameError,
            color = MaterialTheme.colors.error,
        )
    }
}

@Composable
fun AddPlayerButton(viewModel: PlayerFormViewModel) {
    val state = viewModel.state.value
    Button(onClick = {
        viewModel.onEvent(
            PlayerFormEvent.Submit(player = Player(state.playerName))
        )
    }) {
        Text("Add Player")
    }
}

@Composable
fun MockClearFormButton(viewModel: PlayerFormViewModel) {
    Button(onClick = {
        viewModel.onEvent(PlayerFormEvent.clearPlayerName)
    }) {
        Text("Clear Form")
    }
}
