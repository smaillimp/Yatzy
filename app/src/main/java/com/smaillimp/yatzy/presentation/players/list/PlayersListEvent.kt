package com.smaillimp.yatzy.presentation.players.list

import com.smaillimp.yatzy.feature.players.model.Player

sealed class PlayersListEvent {
    data class DeletePlayerName(val player: Player) : PlayersListEvent()
}
