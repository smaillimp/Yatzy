package com.smaillimp.yatzy.presentation.players.form

import com.smaillimp.yatzy.feature.players.domain.usecase.AddPlayerInterface
import com.smaillimp.yatzy.feature.players.domain.usecase.GetPlayersInterface
import com.smaillimp.yatzy.feature.players.model.Player
import com.smaillimp.yatzy.feature.players.usecase.PlayerUseCases
import com.smaillimp.yatzy.feature.players.usecase.ValidatePlayerName
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

@ExperimentalCoroutinesApi
internal class PlayerFormViewModelTest {

    @Test
    fun `event AddPlayer triggers AddPlayer use case`() = runTest {
        val testDispatcher = UnconfinedTestDispatcher(testScheduler)
        val addPlayerMock = mock<AddPlayerInterface> {
            onBlocking { invoke(any<Player>()) } doReturn Unit
        }
        val playerFormViewModel = PlayerFormViewModel(
            PlayerUseCases(
                getPlayers = mock<GetPlayersInterface> {},
                addPlayer = addPlayerMock,
                validatePlayerName = ValidatePlayerName()
            ),
            defaultDispatcher = testDispatcher
        )
        playerFormViewModel.onEvent(PlayerFormEvent.Submit(Player(name = "Andy")))
        verify(addPlayerMock, times(1)).invoke(any<Player>())
    }
}
