package mst

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val (v, e) = readln().split(" ").map { it.toInt() }
    val graph = Array(v + 1) { Stack<Pair<Int, Int>>() }
    val visited = Array(v + 1) { false }
    repeat(e) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        graph[a].push(Pair(c, b))
        graph[b].push(Pair(c, a))
    }

    val que = PriorityQueue { n1: Pair<Int, Int>, n2: Pair<Int, Int> ->
        when {
            n1.first > n2.first -> 1
            n1.first < n2.first -> -1
            else -> 0
        }
    }.apply { add(Pair(0, 1)) }

    var answer = 0
    while (que.isNotEmpty()) {
        val (w, end) = que.poll()
        if (visited[end]) continue
        visited[end] = true
        answer += w
        graph[end].forEach { node ->
            if (!visited[node.second]) {
                que.add(node)
            }
        }
    }
    println(answer)
}