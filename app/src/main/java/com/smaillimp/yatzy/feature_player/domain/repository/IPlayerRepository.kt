package com.smaillimp.yatzy.feature_player.domain.repository

import com.smaillimp.yatzy.feature_player.model.Player
import kotlinx.coroutines.flow.Flow

interface IPlayerRepository {
    fun getUsers(): Flow<List<Player>>
    suspend fun getUserById(id: Int): Player?
    suspend fun insertUser(player: Player)
    suspend fun updateUser(player:Player)
    suspend fun deleteUser(player: Player)
}