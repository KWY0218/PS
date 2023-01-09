package dfsbfs

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val (N, M, R) = readln().split(" ").map { it.toInt() }
    val visited = Array(N) { false }
    val answer = Array(N) { 0 }
    var count = 1
    val graph = Array(N) { mutableListOf<Int>() }
    val stack = Stack<Int>()

    repeat(M) {
        readln().split(" ")
            .map { it.toInt() - 1 }
            .let {
                graph[it[0]].add(it[1])
                graph[it[1]].add(it[0])
            }
    }

    graph.forEach { it.sort() }

    answer[R - 1] = count
    count++
    visited[R - 1] = true
    graph[R - 1].forEach { stack.add(it) }


    while (stack.isNotEmpty()) {
        val s = stack.pop()
        if (!visited[s]) {
            graph[s].forEach { stack.add(it) }
            visited[s] = true
            answer[s] = count
            count++
        }
    }
    answer.forEach { println(it) }

}