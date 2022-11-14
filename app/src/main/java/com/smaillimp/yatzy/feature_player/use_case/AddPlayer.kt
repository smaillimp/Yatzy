package com.smaillimp.yatzy.feature_player.use_case

import com.smaillimp.yatzy.feature_player.domain.repository.IPlayerRepository
import com.smaillimp.yatzy.feature_player.model.Player

class AddPlayer (
    private val repository: IPlayerRepository
){
    suspend operator fun invoke(player: Player) {
        repository.insertUser(player)
    }
}