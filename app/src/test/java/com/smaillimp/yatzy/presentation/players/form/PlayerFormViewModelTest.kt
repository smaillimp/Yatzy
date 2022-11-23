package com.smaillimp.yatzy.presentation.players.form

import com.smaillimp.yatzy.feature.players.model.Player
import com.smaillimp.yatzy.feature.players.usecase.AddPlayerMock
import com.smaillimp.yatzy.feature.players.usecase.GetPlayersMock
import com.smaillimp.yatzy.feature.players.usecase.PlayerUseCases
import com.smaillimp.yatzy.feature.players.usecase.ValidatePlayerName
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
internal class PlayerFormViewModelTest {

    @Test
    fun `event AddPlayer triggers AddPlayer use case`() = runTest {
        val testDispatcher = UnconfinedTestDispatcher(testScheduler)
        val addPlayerMock = AddPlayerMock()
        val playerFormViewModel = PlayerFormViewModel(
            PlayerUseCases(
                getPlayers = GetPlayersMock(),
                addPlayer = addPlayerMock,
                validatePlayerName = ValidatePlayerName()
            ),
            defaultDispatcher = testDispatcher
        )
        playerFormViewModel.onEvent(PlayerFormEvent.Submit(Player(name = "Andy")))
        assertTrue(addPlayerMock.called, "use case AddPlayer must be called after event AddPlayer")
    }
}
