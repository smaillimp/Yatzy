package com.smaillimp.yatzy.feature_player.data.data_source

import androidx.room.*
import com.smaillimp.yatzy.feature_player.model.Player
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao{
    @Query("SELECT * FROM player")
    fun getUsers(): Flow<List<Player>>

    @Query("SELECT * FROM player WHERE id = :id")
    suspend fun getUserById(id: Int): Player?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(player: Player)

    @Delete
    suspend fun deleteUser(player: Player)
}