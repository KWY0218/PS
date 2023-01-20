package backtracking

import java.util.*

private lateinit var arr: IntArray
private lateinit var cal: IntArray
private var n = 0
private var min = Integer.MAX_VALUE
private var max = Integer.MIN_VALUE

fun main() = with(Scanner(System.`in`)) {
    n = readln().toInt()
    arr = readln().split(" ").map { it.toInt() }.toIntArray()
    cal = readln().split(" ").map { it.toInt() }.toIntArray()
    val answer = arr[0]
    next(1, answer)
    println(max)
    println(min)
}

fun next(index: Int, answer: Int) {
    if (index == n) {
        if (min > answer) min = answer
        if (max < answer) max = answer
        return
    }
    for (i in 0 until 4) {
        if (cal[i] != 0) {
            val temp = calculate(i, index, answer)
            cal[i] -= 1
            next(index + 1, temp)
            cal[i] += 1
        }
    }
}

fun calculate(command: Int, idx: Int, answer: Int): Int {
    return when (command) {
        0 -> answer + arr[idx]
        1 -> answer - arr[idx]
        2 -> answer * arr[idx]
        else -> answer / arr[idx]
    }
}