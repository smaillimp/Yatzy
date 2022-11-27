package com.smaillimp.yatzy.presentation.players.form

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.smaillimp.yatzy.feature.players.model.Player

@Composable
fun PlayerFormView() {
    val viewModel = hiltViewModel<PlayerFormViewModel>()
    val focusManager = LocalFocusManager.current
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        InputWithError(viewModel = viewModel, focusManager = focusManager)
        AddPlayerButton(viewModel = viewModel)
    }
}

@Composable
fun InputWithError(viewModel: PlayerFormViewModel, focusManager: FocusManager) {
    val state = viewModel.state.value
    Column() {
        TextField(
            singleLine = true,
            value = state.playerName,
            onValueChange = {
                viewModel.onEvent(PlayerFormEvent.ChangePlayerName(Player(it)))
            },
            trailingIcon = {
                if (state.playerName.isNotEmpty()) {
                    IconButton(onClick = {
                        viewModel.onEvent(PlayerFormEvent.clearPlayerName)
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Clear,
                            contentDescription = "Clear"
                        )
                    }
                }
            },
            isError = state.playerNameError != null,
            modifier = Modifier
                .fillMaxWidth(0.77f)
                .height(60.dp),
            placeholder = {
                Text(text = "Player Name")
            },
            keyboardOptions = KeyboardOptions(
                autoCorrect = false,
                keyboardType = KeyboardType.Ascii,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            ),
        )
        if (state.playerNameError != null) {
            Text(
                text = state.playerNameError,
                color = MaterialTheme.colors.error,
            )
        }
    }
}

@Composable
fun AddPlayerButton(viewModel: PlayerFormViewModel) {
    val state = viewModel.state.value
    Button(
        modifier = Modifier
            .height(60.dp),
        onClick = {
            viewModel.onEvent(
                PlayerFormEvent.Submit(player = Player(state.playerName))
            )
        }) {
        Text("Add")
    }
}
