package dp

import java.util.*
import kotlin.system.exitProcess

private lateinit var stairs: Array<Int>
private var t: Int = 0
private lateinit var dp: Array<Int>

fun main() = with(Scanner(System.`in`)) {
    t = readln().toInt()
    stairs = Array(t + 1) { 0 }
    dp = Array(t + 1) { 0 }

    for (i in 1..t) {
        stairs[i] = readln().toInt()
    }
    // 자연수가 들어오므로 t == 1일 때를 예외로 출력한다
    if (t == 1) {
        println(stairs[1])
        exitProcess(0)
    }
    dp[1] = stairs[1]
    dp[2] = stairs[1] + stairs[2]
    // 0번째에서 바로 2번째로 가는 경로가 있다!! 기억하자! 0 + 2 + 3 or 0 + 1 + 3 이 가능하다.
    // 바로 이전계단과 현재 계단을 더하려면 이전 계단을 왔을 때 한칸 건너 뛴 계단일 때만 되므로 [dp[i-3] + stairs[i-1] + stairs[i]] 되고,
    // 위 값과 이전 계단을 건너 뛰어서 왔을 때 [dp[i-2]+stairs[i]] 값 중 최대 값이 현재 계단의 최적의 값이다
    for (i in 3..t) {
        dp[i] = kotlin.math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i])
    }
    println(dp[t])
}
