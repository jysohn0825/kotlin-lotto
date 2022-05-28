package lotto.ui

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.util.toLottoNumbers

class InputView {
    fun readPayment(): Int {
        println(PAYMENT_TEXT)
        return readln().toInt()
    }

    fun readLastNumber(): LottoTicket {
        println(LAST_NUMBER_TEXT)
        return readln().toLottoNumbers(LOTTO_NUMBER_DIVIDE_TEXT)
    }
    fun readBonusNumber(): LottoNumber {
        println(LOTTO_BONUS_TEXT)
        return LottoNumber(readln().toInt())
    }

    companion object {
        private const val PAYMENT_TEXT = "구입금액을 입력해 주세요."
        private const val LAST_NUMBER_TEXT = "\n지난 주 당첨 번호를 입력해 주세요."
        const val LOTTO_NUMBER_DIVIDE_TEXT = ","
        private const val LOTTO_BONUS_TEXT = "보너스 볼을 입력해 주세요."
    }
}