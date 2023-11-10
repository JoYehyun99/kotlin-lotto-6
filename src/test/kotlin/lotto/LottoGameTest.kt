package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import ui.GameConsole
import ui.UserInputReader

class LottoGameTest {

    private val lottoGame = LottoGame(UserInputReader(), LottoMachine(), GameConsole(), LottoResultChecker())

    @Test
    fun When_Input_3000_Expect_3_3LottoTickets() {
        val input = 3000
        val tickets = lottoGame.generateLottoTickets(input)
        val expected = 3
        assertEquals(tickets.size, expected)
    }
}