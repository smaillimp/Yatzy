package com.smaillimp.yatzy.di

import android.app.Application
import androidx.room.Room
import com.smaillimp.yatzy.feature.game.usecase.RollDice
import com.smaillimp.yatzy.feature.players.data.data_source.PlayerDatabase
import com.smaillimp.yatzy.feature.players.data.repository.PlayerRepository
import com.smaillimp.yatzy.feature.players.domain.repository.PlayerRepositoryInterface
import com.smaillimp.yatzy.feature.players.usecase.AddPlayer
import com.smaillimp.yatzy.feature.players.usecase.DeletePlayer
import com.smaillimp.yatzy.feature.players.usecase.GetPlayers
import com.smaillimp.yatzy.feature.players.usecase.PlayerUseCases
import com.smaillimp.yatzy.feature.players.usecase.ValidatePlayerName
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providePlayerDatabase(app: Application): PlayerDatabase {
        return Room.databaseBuilder(
            app,
            PlayerDatabase::class.java,
            PlayerDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providePlayerRepository(db: PlayerDatabase): PlayerRepositoryInterface {
        return PlayerRepository(db.playerDao)
    }

    @Provides
    @Singleton
    fun provideUserUseCases(repository: PlayerRepositoryInterface): PlayerUseCases {
        return PlayerUseCases(
            getPlayers = GetPlayers(repository),
            addPlayer = AddPlayer(repository),
            deletePlayer = DeletePlayer(repository),
            validatePlayerName = ValidatePlayerName()
        )
    }

    @Provides
    @Singleton
    fun provideRollDiceUseCase(): RollDice {
        return RollDice()
    }

    @Provides
    @Singleton
    fun providesDefaultDispatcher(): CoroutineDispatcher {
        return Dispatchers.Main
    }
}
