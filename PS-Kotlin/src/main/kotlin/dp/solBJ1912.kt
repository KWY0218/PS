package dp

import java.util.*

private lateinit var nums: IntArray
private var n = 0

fun main() = with(Scanner(System.`in`)) {
    n = readln().toInt()
    nums = readln().split(" ").map { it.toInt() }.toIntArray()
    val dp = IntArray(n)
    dp[0] = nums[0]
    for (i in 1 until n) {
        val temp = dp[i - 1] + nums[i]
        if (temp > nums[i]) dp[i] = temp
        else dp[i] = nums[i]
    }
    println(dp.max())
}
