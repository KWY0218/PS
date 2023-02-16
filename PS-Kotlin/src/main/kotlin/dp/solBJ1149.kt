package dp

fun main() {
    val n = readln().toInt()
    val dp = Array(n){ Array(n){0} }

    repeat(n) {
        val (r,g,b) = (readln().split(" ").map{it.toInt()})
        dp[it][0] = r
        dp[it][1] = g
        dp[it][2] = b
    }

    for(i in 1 until n){
        dp[i][0] += kotlin.math.min(dp[i-1][1],dp[i-1][2])
        dp[i][1] += kotlin.math.min(dp[i-1][0],dp[i-1][2])
        dp[i][2]  += kotlin.math.min(dp[i-1][0],dp[i-1][1])
    }
    println(kotlin.math.min(kotlin.math.min(dp[n-1][0],dp[n-1][1]),dp[n-1][2]))
}
