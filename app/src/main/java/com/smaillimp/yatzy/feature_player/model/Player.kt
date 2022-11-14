package com.smaillimp.yatzy.feature_player.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Player(
    val name: String,
    @PrimaryKey val id: Int? = null
)