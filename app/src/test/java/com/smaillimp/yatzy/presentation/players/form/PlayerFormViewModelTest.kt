package com.smaillimp.yatzy.presentation.players.form

import com.smaillimp.yatzy.feature.players.model.Player
import com.smaillimp.yatzy.feature.players.usecase.AddPlayerMock
import com.smaillimp.yatzy.feature.players.usecase.GetPlayersMock
import com.smaillimp.yatzy.feature.players.usecase.PlayerUseCases
import com.smaillimp.yatzy.feature.players.usecase.ValidatePlayerName
import com.smaillimp.yatzy.utility.MainCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
internal class PlayerFormViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Test
    fun `event AddPlayer triggers AddPlayer use case`() = runTest {
        val addPlayerMock = AddPlayerMock()
        val playerFormViewModel = PlayerFormViewModel(
            PlayerUseCases(
                getPlayers = GetPlayersMock(),
                addPlayer = addPlayerMock,
                validatePlayerName = ValidatePlayerName()
            )
        )
        playerFormViewModel.onEvent(PlayerFormEvent.AddPlayer(Player(name = "Andy")))
        advanceUntilIdle()
        assertTrue("use case AddPlayer must be called after event AddPlayer", addPlayerMock.called)
    }
}
