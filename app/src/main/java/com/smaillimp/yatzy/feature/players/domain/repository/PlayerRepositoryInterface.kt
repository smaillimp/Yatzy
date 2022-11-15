package com.smaillimp.yatzy.feature.players.domain.repository

import com.smaillimp.yatzy.feature.players.model.Player
import kotlinx.coroutines.flow.Flow

interface PlayerRepositoryInterface {
    fun getPlayers(): Flow<List<Player>>
    fun getPlayerById(id: Int): Player?
    suspend fun insertPlayer(player: Player)
    suspend fun updatePlayer(player: Player)
    suspend fun deletePlayer(player: Player)
}
