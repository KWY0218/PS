package divide_and_conquer

import java.util.*

private lateinit var arr: Array<IntArray>
private var answer = ""

fun main() = with(Scanner(System.`in`)) {
    val n = readln().toInt()
    arr = Array(n) { IntArray(n) }
    repeat(n) {
        // 123456 이런식으로 중간에 공백이 없을 경우 int array 로 바꾸는 방법
        arr[it] = readln().map { o -> o.toString().toInt() }.toIntArray()
    }
    divide(0, n, 0, n, n)
    println(answer)
}

private fun divide(colStart: Int, colEnd: Int, rowStart: Int, rowEnd: Int, size: Int) {
    // solBJ2630 참조
    if (size == 1) {
        answer += arr[colStart][rowStart]
        return
    }
    when (solve(colStart, colEnd, rowStart, rowEnd)) {
        0 -> {
            answer += 0
        }
        size * size -> {
            answer += 1
        }
        else -> {
            val colMid = (colStart + colEnd) / 2
            val rowMid = (rowStart + rowEnd) / 2
            answer += '('
            divide(colStart, colMid, rowStart, rowMid, size / 2)
            divide(colStart, colMid, rowMid, rowEnd, size / 2)
            divide(colMid, colEnd, rowStart, rowMid, size / 2)
            divide(colMid, colEnd, rowMid, rowEnd, size / 2)
            answer += ')'
        }
    }
}

private fun solve(colStart: Int, colEnd: Int, rowStart: Int, rowEnd: Int): Int {
    var screen = 0
    for (col in colStart until colEnd) {
        for (row in rowStart until rowEnd) {
            screen += arr[col][row]
        }
    }
    return screen
}