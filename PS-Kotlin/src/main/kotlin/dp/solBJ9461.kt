package dp

import java.util.*

private lateinit var memory: Array<Long>

/*
* 1, 1, 1, 2, 2, 3, 4, 5, 7, 9 ...
* f(1) = 1, f(2) = 1, f(3) = 1, f(4) = 2, f(5) = 2, f(6) = 3, f(7) = 4, f(8) = 5 ...
* f(n-3) + f(n-2) 공식이 성립
* N 이 100이 들어온다면 오버플로우가 발생하므로 Long 타입으로 지정한다
* */
fun main() = with(Scanner(System.`in`)) {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        memory = Array(n + 1) { -1 }
        println(sol(n))
    }
}

private fun sol(n: Int): Long {
    return if (n < 4) 1
    else if (memory[n] != -1L) memory[n]
    else {
        memory[n] = sol(n - 3) + sol(n - 2)
        memory[n]
    }
}
