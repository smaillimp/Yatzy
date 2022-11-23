package com.smaillimp.yatzy.presentation.players.list

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
    fun `list view model gets players on init`() = runTest {
        val testDispatcher = UnconfinedTestDispatcher(testScheduler)
        val getPlayerMock = GetPlayersMock()
        PlayersListViewModel(
            PlayerUseCases(
                getPlayers = getPlayerMock,
                addPlayer = AddPlayerMock(),
                validatePlayerName = ValidatePlayerName()
            ),
            defaultDispatcher = testDispatcher
        )
        assertTrue(getPlayerMock.called, "GetPlayer use case must be called on init")
    }
}
