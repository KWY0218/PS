package dfsbfs

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val n = readln().toInt()
    val graph = Array(n) { "" }
    val answer = Stack<Int>()
    val direction = arrayOf(Pair(-1, 0), Pair(0, -1), Pair(0, 1), Pair(1, 0))
    val visited = Array(n) { Array(n) { false } }
    repeat(n) {
        val row = readln()
        graph[it] = row
    }
    graph.forEachIndexed { col, g ->
        g.forEachIndexed { row, _ ->
            if (graph[col][row] == '1' && !visited[col][row]) {
                visited[col][row] = true
                val stack = Stack<Pair<Int, Int>>()
                stack.push(Pair(col, row))
                var count = 0
                while (stack.isNotEmpty()) {
                    val (c, r) = stack.pop()
                    count++
                    direction.forEach { p ->
                        val nextC = c + p.first
                        val nextR = r + p.second
                        if (nextC in 0 until n && nextR in 0 until n && !visited[nextC][nextR] && graph[nextC][nextR] == '1') {
                            stack.push(Pair(nextC, nextR))
                            visited[nextC][nextR] = true
                        }
                    }
                }
                answer.push(count)
            }
        }
    }
    println(answer.size)
    answer.sorted().forEach { println(it) }
}