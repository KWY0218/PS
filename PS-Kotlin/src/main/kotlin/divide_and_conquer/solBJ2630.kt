package divide_and_conquer

import java.util.*

private lateinit var arr: Array<IntArray>
private val answer = arrayOf(0, 0)

fun main() = with(Scanner(System.`in`)) {
    val n = readln().toInt()
    arr = Array(n) { IntArray(n) }
    repeat(n) { idx ->
        arr[idx] = readln().split(" ").map { it.toInt() }.toIntArray()
    }
    divide(0, n, 0, n, n)
    answer.forEach { println(it) }
}

fun divide(colStart: Int, colEnd: Int, rowStart: Int, rowEnd: Int, size: Int) {
    // 1칸짜리로 내려왔으면 0 또는 1을 1증가한다
    if (size == 1) {
        answer[arr[colStart][rowStart]] += 1
        return
    }
    // index 내의 값들을 모두 더했을 때
    when (solve(colStart, colEnd, rowStart, rowEnd)) {
        // 0이라면 모두 0이란 소리니까 0을 증가시킨다.
        0 -> answer[0] += 1
        // size*size 라면 모두 1이므로 1을 증가시킨다.
        size * size -> answer[1] += 1
        // 그렇지 않으면 4개로 쪼갠다.
        else -> {
            val colMid = (colStart + colEnd) / 2
            val rowMid = (rowStart + rowEnd) / 2
            divide(colStart, colMid, rowStart, rowMid, size / 2)
            divide(colStart, colMid, rowMid, rowEnd, size / 2)
            divide(colMid, colEnd, rowStart, rowMid, size / 2)
            divide(colMid, colEnd, rowMid, rowEnd, size / 2)
        }
    }
}
// index 내의 값들을 모두 더한다.
fun solve(colStart: Int, colEnd: Int, rowStart: Int, rowEnd: Int): Int {
    var paper = 0
    for (col in colStart until colEnd) {
        for (row in rowStart until rowEnd) {
            paper += arr[col][row]
        }
    }
    return paper
}
