package dp

import java.util.*

private var answer = Int.MAX_VALUE

fun main() = with(Scanner(System.`in`)) {
    val n = readln().toInt()
    dp(n, 0)
    println(answer)
}

/*
* 현재 answer 값 보다 더 커지는 작업은 진입 하지 않는다.
* */
private fun dp(next: Int, count: Int) {
    if (next == 1) {
        answer = kotlin.math.min(count, answer)
        return
    }
    if (answer - 1 != count && next % 3 == 0) dp(next / 3, count + 1)
    if (answer - 1 != count && next % 2 == 0) dp(next / 2, count + 1)
    if (answer - 1 != count) dp(next - 1, count + 1)
}
