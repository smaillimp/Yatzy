package com.smaillimp.yatzy.di

import android.app.Application
import androidx.room.Room
import com.smaillimp.yatzy.feature_player.data.data_source.PlayerDatabase
import com.smaillimp.yatzy.feature_player.data.repository.PlayerRepository
import com.smaillimp.yatzy.feature_player.domain.repository.IPlayerRepository
import com.smaillimp.yatzy.feature_player.use_case.AddPlayer
import com.smaillimp.yatzy.feature_player.use_case.GetPlayers
import com.smaillimp.yatzy.feature_player.use_case.PlayerUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideUserDatabase(app: Application): PlayerDatabase {
        return Room.databaseBuilder(
            app,
            PlayerDatabase::class.java,
            PlayerDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideUserRepository(db: PlayerDatabase): IPlayerRepository {
        return PlayerRepository(db.playerDao)
    }

    @Provides
    @Singleton
    fun provideUserUseCases(repository: IPlayerRepository): PlayerUseCases {
        return PlayerUseCases(
            getPlayers = GetPlayers(repository),
            addPlayer = AddPlayer(repository)
        )
    }
}