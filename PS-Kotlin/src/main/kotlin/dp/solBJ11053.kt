package dp

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val n = readln().toInt()
    val nums = readln().split(" ").map { it.toInt() }
    val dp = IntArray(n)

    repeat(n) {
        dp[it] = 1
        for (i in 0 until it) {
            if (nums[i] < nums[it] && dp[it] < dp[i] + 1) {
                dp[it] = dp[i] + 1
            }
        }
    }
    println(dp.max())
}