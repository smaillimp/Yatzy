package com.smaillimp.yatzy.presentation.players.list

import com.smaillimp.yatzy.feature.players.domain.usecase.AddPlayerInterface
import com.smaillimp.yatzy.feature.players.domain.usecase.GetPlayersInterface
import com.smaillimp.yatzy.feature.players.model.Player
import com.smaillimp.yatzy.feature.players.usecase.PlayerUseCases
import com.smaillimp.yatzy.feature.players.usecase.ValidatePlayerName
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

@ExperimentalCoroutinesApi
internal class PlayerListViewModelTest {

    @Test
    fun `number of players is equal to players returned by GetPlayers`() = runTest {
        val testDispatcher = UnconfinedTestDispatcher(testScheduler)
        val players = listOf(Player("Smaillim"), Player("Andy"))
        val getPlayerMock = mock<GetPlayersInterface> {
            on { invoke() } doReturn flow { emit(players) }
        }
        val viewModelUnderTest = PlayersListViewModel(
            PlayerUseCases(
                getPlayers = getPlayerMock,
                addPlayer = mock<AddPlayerInterface> {},
                validatePlayerName = ValidatePlayerName()
            ),
            defaultDispatcher = testDispatcher
        )
        verify(getPlayerMock, times(1)).invoke()
        viewModelUnderTest.state.value.players.size shouldBe players.size
    }
}
