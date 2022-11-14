package com.smaillimp.yatzy.presentation.players.form

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import com.smaillimp.yatzy.feature_player.model.Player
import com.smaillimp.yatzy.presentation.PlayerFormViewModel

@Composable
fun PlayerFormView (
    modifier: Modifier= Modifier,
) {
    val viewModel = hiltViewModel<PlayerFormViewModel>()
    InputWithError(viewModel)
    AddUserNamebutton(viewModel)
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
fun AddUserNamebutton(viewModel: PlayerFormViewModel) {
    val state = viewModel.state.value
    Button(onClick = {
        viewModel.onEvent(PlayerFormEvent.AddPlayer(player= Player(state.playerName)))
    }) {
        Text("Add user name")
    }
}
