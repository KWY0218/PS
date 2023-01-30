package dp

import java.util.*

/*
* 1 = 1 , 2 = 2 , 3 = 3, 4 = 5, 5 = 8, 6 = 13 ...
* dp[n] = dp[n-2]+dp[n-1] 공식이 성립되는 것을 볼 수 있다.
* 또, 15746 으로 나눈 나머지 값을 호출해야 하므로
* (A+B)%C = (A%C + B%C)%C 가 성립한다는 모듈러 연산의 분배 법칙을 사용하면 된다.
* */
fun main() = with(Scanner(System.`in`)) {
    val n = readln().toInt()
    if (n == 1) {
        println(1)
        kotlin.system.exitProcess(0)
    }
    val dp = Array(n + 1) { 0 }
    dp[1] = 1
    dp[2] = 2
    for (i in 3..n) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % 15746
    }
    println(dp[n])
}
