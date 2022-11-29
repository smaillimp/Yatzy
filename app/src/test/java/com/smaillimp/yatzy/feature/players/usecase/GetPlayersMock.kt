package com.smaillimp.yatzy.feature.players.usecase

import com.smaillimp.yatzy.feature.players.domain.usecase.GetPlayersInterface
import com.smaillimp.yatzy.feature.players.model.Player
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPlayersMock : GetPlayersInterface {
    var called = false
    var players = listOf(Player(name = "Smaillim"), Player("Andy"))

    override fun invoke(): Flow<List<Player>> {
        called = true
        return flow { emit(players) }
    }
}
