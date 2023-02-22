package com.smaillimp.yatzy.presentation.game

import com.smaillimp.yatzy.feature.players.model.Player

data class GameState(
    val players: List<Player> = emptyList(),
    val activePlayerIndex: Int = 0,
    val gameEvents: List<GameEvent> = emptyList(),
    val phase: GamePhase = GamePhase.SelectingPlayers
)

sealed class GamePhase {
    object SelectingPlayers : GamePhase()
    object Rounds : GamePhase()
    object End : GamePhase()
}


