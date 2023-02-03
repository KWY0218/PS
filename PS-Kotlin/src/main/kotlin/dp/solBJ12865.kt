package dp

import java.util.*
import kotlin.math.max

private var answer = 0
private var weight = 0
private lateinit var ps: Array<Pair<Int, Int>>


fun main() = with(Scanner(System.`in`)) {
    val (n, k) = readln().split(" ").map { it.toInt() }
    weight = k
    ps = Array(n) { Pair(0, 0) }
    repeat(n) { i ->
        val (w, v) = readln().split(" ").map { it.toInt() }
        ps[i] = Pair(w, v)
    }
    val nums = Array(n + 1) { IntArray(k + 1) }
    for (row in 1..k) {
        for (col in 1..n) {
            if (ps[col - 1].first > row) {
                nums[col][row] = nums[col - 1][row]
            } else {
                nums[col][row] = max(nums[col - 1][row], nums[col - 1][row - ps[col - 1].first] + ps[col - 1].second)
            }
        }
    }
    println(nums[n][k])
}