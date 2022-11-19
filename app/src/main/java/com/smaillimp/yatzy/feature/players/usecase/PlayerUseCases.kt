package com.smaillimp.yatzy.feature.players.usecase

import com.smaillimp.yatzy.feature.players.domain.usecase.AddPlayerInterface
import com.smaillimp.yatzy.feature.players.domain.usecase.GetPlayersInterface

data class PlayerUseCases(
    val getPlayers: GetPlayersInterface,
    val addPlayer: AddPlayerInterface
)
