package dp

import java.util.*

private lateinit var m: Array<Int>
private var count = 0

fun main() = with(Scanner(System.`in`)) {
    val n = readln().toInt()
    m = Array(n + 1) { -1 }
    println("${fibonacci(n)} ${count - 1}")
}

private fun fibonacci(n: Int): Int {
    return if (n < 2) n
    else if (m[n] != -1) m[n]
    else {
        m[n] = fibonacci(n - 1) + fibonacci(n - 2)
        count++
        m[n]
    }
}
