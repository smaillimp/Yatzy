package com.smaillimp.yatzy.presentation.players

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.smaillimp.yatzy.presentation.players.form.PlayerFormView
import com.smaillimp.yatzy.presentation.players.list.PlayersListView

@Composable
fun PlayerScreen() {
    Column(
        modifier = Modifier
            .padding(32.dp),
        verticalArrangement = Arrangement.Center
    ) {
        PlayerFormView()
        PlayersListView()
    }

}
