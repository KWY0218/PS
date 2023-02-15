package dp

import kotlin.system.*

fun main() {
    val n = readln().toInt()
    if(n<=2){
        println(n)
        exitProcess(0)
    }
    val dp = Array(n+1){ 0 }
    dp[1] = 1
    dp[2] = 2

    for(i in 3..n){
        dp[i] = (dp[i-1]+dp[i-2])%10007
    }
    println(dp[n]%10007)
}