package com.smaillimp.yatzy.presentation.game

import com.smaillimp.yatzy.feature.players.model.Player

sealed class GameEvent {
    data class PlayerTurn(val player: Player) : GameEvent()
    object NextStep : GameEvent()
    object LoadingPlayers : GameEvent()
    data class LoadedPlayers(val players: List<Player>) : GameEvent()
    data class SelectPlayers(val players: List<Player>) : GameEvent()
    data class PlayerSelected(val player: Player) : GameEvent()
    data class PlayerUnselected(val player: Player) : GameEvent()
}