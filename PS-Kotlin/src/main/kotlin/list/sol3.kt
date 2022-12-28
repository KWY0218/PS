package list

import java.lang.Math.max
import java.lang.Math.min

fun main() {
    println(maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
}

// LeetCode 121
// 카데인 알고리즘
fun maxProfit(prices: IntArray): Int {
    var minPrice = prices[0]
    var maxPrice = 0
    prices.forEach { price ->
        val tempPrice = price - minPrice
        maxPrice = max(maxPrice, tempPrice)
        minPrice = min(minPrice, price)
    }
    return maxPrice
}