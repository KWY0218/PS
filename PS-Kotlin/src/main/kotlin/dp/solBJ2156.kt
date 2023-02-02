package dp

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val n = readln().toInt()
    val nums = IntArray(n + 1)
    for (i in 1..n) {
        nums[i] = readln().toInt()
    }
    val dp = IntArray(n + 1)
    dp[1] = nums[1]
    if (n > 1) {
        dp[2] = nums[1] + nums[2]
    }
    for (i in 3..n) {
        dp[i] = kotlin.math.max(dp[i - 1], kotlin.math.max(dp[i - 2], dp[i - 3] + nums[i - 1]) + nums[i])
    }
    println(dp[n])
}