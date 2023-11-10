package lotto

import ui.GameConsole
import ui.UserInputReader

class LottoGame(
    private val userInputReader: UserInputReader,
    private val lottoMachine: LottoMachine,
    private val gameConsole: GameConsole,
    private val lottoResultChecker: LottoResultChecker
) {
    fun start() {
        val price = userInputReader.getPrice()
        val lottoTickets = generateLottoTickets(price)
        gameConsole.showLottoTickets(lottoTickets, lottoTickets.size)

        val winningResult = determineWiningResult(lottoTickets)
        gameConsole.showWinningStatistic(winningResult)
        gameConsole.showEarningRate(lottoResultChecker.calculateEarningRate(price))
    }

    fun generateLottoTickets(price: Int): List<Lotto>{
        val numberOfLotto = lottoMachine.calculateNumberOfLotto(price)
        return lottoMachine.getLottoTickets(numberOfLotto)
    }

    private fun determineWiningResult(lottoTickets: List<Lotto>): Map<WinningCriteria, Int> {
        val winningNumbers = userInputReader.getWinningNumbers()
        val bonusNumber = userInputReader.getBonusNumber(winningNumbers)
        return lottoResultChecker.compareLottoTicketsWithWinningNumbers(lottoTickets, winningNumbers, bonusNumber)
    }
}