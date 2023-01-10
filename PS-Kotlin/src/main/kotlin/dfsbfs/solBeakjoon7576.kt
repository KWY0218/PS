package dfsbfs

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val (m, n) = readln().split(" ").map { it.toInt() }
    val graph = Array(n) { IntArray(m) { 0 } }
    repeat(n) { i ->
        graph[i] = readln().split(" ").map { it.toInt() }.toIntArray()
    }

    val visited = Array(n) { Array(m) { false } }
    val direction = arrayOf(Pair(-1, 0), Pair(0, -1), Pair(0, 1), Pair(1, 0))
    val stack = LinkedList<Pair<Int, Int>>()
    var count = 0
    graph.forEachIndexed { c, row ->
        row.forEachIndexed { r, g ->
            if (g == 1) {
                visited[c][r] = true
                stack.push(Pair(c, r))
            }
            if (g == 1 || g == -1) count++
        }
    }

    if (count == m * n) {
        println(0)
        return@with
    }

    while (stack.isNotEmpty()) {
        val (c, r) = stack.pop()
        direction.forEach { p ->
            val col = c + p.first
            val row = r + p.second
            if (col in 0 until n && row in 0 until m && !visited[col][row] && graph[col][row] == 0) {
                visited[c][r] = true
                graph[col][row] = graph[c][r] + 1
                stack.add(Pair(col, row))
            }
        }
    }
    var answer = -1
    var isAnswer = true
    graph.forEach { row ->
        if (row.contains(0)) isAnswer = false
        answer = kotlin.math.max(answer, row.max())
    }
    if (isAnswer) println(answer - 1) else println(-1)
}