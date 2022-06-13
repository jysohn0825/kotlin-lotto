package lotto

import lotto.domain.LottoSeller
import lotto.ui.InputUI
import lotto.ui.OutputUI

fun main() {
    val money = InputUI.receivePurchaseAmount()

    val lottoList = LottoSeller.buy(money)

    OutputUI.drawPurchaseMessage(lottoList.size)
    OutputUI.drawLotto(lottoList)

    val winningNumbers = InputUI.receiveWinningNumbers()
    val bonusNumber = InputUI.receiveBonusNumber()

    val lottoResult = lottoList.match(winningNumbers, bonusNumber)

    OutputUI.drawWinningResult(lottoResult)
    OutputUI.drawWinningRevenueRate(lottoResult.revenueRate)
}