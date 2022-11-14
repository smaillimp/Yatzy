package com.smaillimp.yatzy.feature_player.use_case

import com.smaillimp.yatzy.feature_player.domain.repository.IPlayerRepository
import com.smaillimp.yatzy.feature_player.model.Player
import kotlinx.coroutines.flow.Flow

class GetPlayers (
    private val repository: IPlayerRepository
){
    operator fun invoke(): Flow<List<Player>> {
        return repository.getUsers()
    }
}