package com.smaillimp.yatzy.feature.players.usecase

import com.smaillimp.yatzy.feature.players.domain.usecase.AddPlayerInterface
import com.smaillimp.yatzy.feature.players.domain.usecase.GetPlayersInterface
import com.smaillimp.yatzy.feature.players.domain.usecase.ValidatePlayerNameInterface

data class PlayerUseCases(
    val getPlayers: GetPlayersInterface,
    val addPlayer: AddPlayerInterface,
    val validatePlayerName: ValidatePlayerNameInterface
)
