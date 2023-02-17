package dp

import kotlin.math.*

fun main() {
    val n = readln().toInt()
    val nums = readln().split(" ").map { it.toInt() }
    val dp = Array(n+1){0}

    for(i in 1..n){
        for(j in 1..i){
            dp[i] = max(dp[i], dp[i-j]+nums[j-1])
        }
    }
    println(dp[n])
}
