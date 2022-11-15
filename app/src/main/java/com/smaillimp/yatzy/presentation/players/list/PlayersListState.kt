package com.smaillimp.yatzy.presentation.players.list

import com.smaillimp.yatzy.feature.players.model.Player

data class PlayersListState(
    val players: List<Player> = emptyList(),
)
