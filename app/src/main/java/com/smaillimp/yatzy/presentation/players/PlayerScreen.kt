package com.smaillimp.yatzy.presentation.players

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.smaillimp.yatzy.presentation.players.form.PlayerFormView
import com.smaillimp.yatzy.presentation.players.list.PlayersListView
import com.smaillimp.yatzy.presentation.ui.theme.YatzyTheme

@Composable
fun PlayerScreen() {
    YatzyTheme() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column(
                modifier = Modifier
                    .padding(32.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                PlayerFormView()
                PlayersListView()
            }
        }
    }
}
