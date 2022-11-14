package com.smaillimp.yatzy.feature_player.data.repository

import com.smaillimp.yatzy.feature_player.data.data_source.PlayerDao
import com.smaillimp.yatzy.feature_player.domain.repository.IPlayerRepository
import com.smaillimp.yatzy.feature_player.model.Player
import kotlinx.coroutines.flow.Flow

class PlayerRepository(
    private val dao: PlayerDao
) : IPlayerRepository {
    override fun getUsers(): Flow<List<Player>> {
        return dao.getUsers()
    }

    override suspend fun getUserById(id: Int): Player? {
        return dao.getUserById(id)
    }

    override suspend fun insertUser(player: Player) {
        dao.insertUser(player)
    }

    override suspend fun updateUser(player: Player) {
        dao.insertUser(player)
    }

    override suspend fun deleteUser(player: Player) {
        dao.deleteUser(player)
    }
}