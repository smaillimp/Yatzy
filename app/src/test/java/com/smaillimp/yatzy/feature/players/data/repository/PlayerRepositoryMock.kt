package com.smaillimp.yatzy.feature.players.data.repository

import com.smaillimp.yatzy.feature.players.domain.repository.PlayerRepositoryInterface
import com.smaillimp.yatzy.feature.players.model.Player
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PlayerRepositoryMock : PlayerRepositoryInterface {
    private var players: MutableList<Player> = mutableListOf()
    private var id: Int = 0

    override fun getPlayers(): Flow<List<Player>> {
        return flow { emit(players) }
    }

    override fun getPlayerById(id: Int): Player? {
        return players.find { it.id == id }
    }

    override suspend fun insertPlayer(player: Player) {
        players.add(player.copy(id = id++))
    }

    override suspend fun updatePlayer(player: Player) {
        val playerToBeDeleted = players.find { it.id == player.id }
        players.remove(playerToBeDeleted)
        players.add(player)
    }

    override suspend fun deletePlayer(player: Player) {
        players.remove(player)
    }
}
