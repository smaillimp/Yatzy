package com.smaillimp.yatzy.feature.players.data.repository

import com.smaillimp.yatzy.feature.players.data.data_source.PlayerDao
import com.smaillimp.yatzy.feature.players.domain.repository.PlayerRepositoryInterface
import com.smaillimp.yatzy.feature.players.model.Player
import kotlinx.coroutines.flow.Flow

class PlayerRepository(
    private val dao: PlayerDao
) : PlayerRepositoryInterface {
    override fun getPlayers(): Flow<List<Player>> {
        return dao.getPlayers()
    }

    override fun getPlayerById(id: Int): Player? {
        return dao.getPlayerById(id)
    }

    override suspend fun insertPlayer(player: Player) {
        dao.insertPlayer(player)
    }

    override suspend fun updatePlayer(player: Player) {
        dao.insertPlayer(player)
    }

    override suspend fun deletePlayer(player: Player) {
        dao.deletePlayer(player)
    }
}
