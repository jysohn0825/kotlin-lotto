package lotto.view

import lotto.domain.LottoCollection
import lotto.domain.LottoWonNumbers
import lotto.domain.Rank

class ResultView(private val lottoCollection: LottoCollection) {
    fun printLotto() {
        lottoCollection.lotto.forEach { println(it) }
    }

    fun printWon(wonNumbers: LottoWonNumbers) {
        val matchByWonNumber = lottoCollection.matchByWonNumber(wonNumbers)
        val wonRank = Rank.getWonRank()

        wonRank.forEach {
            println("${it.matchCondition} (${it.amount}원)- ${matchByWonNumber.rankCount[it] ?: 0}")
        }
    }

    fun printRate(wonNumbers: LottoWonNumbers) {
        val matchByWonNumber = lottoCollection.matchByWonNumber(wonNumbers)
        val rate: Double = (matchByWonNumber.sumAmount.toDouble() / (lottoCollection.lotto.size * 1000).toDouble())

        print("총 수익률은 ${"%.2f".format(rate)}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}