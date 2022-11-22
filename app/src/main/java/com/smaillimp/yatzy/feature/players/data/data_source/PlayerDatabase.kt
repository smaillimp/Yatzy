package com.smaillimp.yatzy.feature.players.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.smaillimp.yatzy.feature.players.model.Player

@Database(
    entities = [Player::class],
    version = 1,
    exportSchema = false
)
abstract class PlayerDatabase : RoomDatabase() {
    abstract val playerDao: PlayerDao
    companion object {
        const val DATABASE_NAME = "player_db"
    }
}
