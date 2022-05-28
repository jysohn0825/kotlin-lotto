package lotto.domain

class StatResults(val statResults: List<StatResult>) {
    fun yield(receipt: Receipt): Double {
        val totalProfit = statResults.sumOf { it.sum }
        return Profit(
            totalProfit.toDouble(),
            receipt.buyPrice().toDouble()
        ).yields
    }
}