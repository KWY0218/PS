package mst

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val t = readln().toInt()
    repeat(t) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        val graph = Array(n) { Stack<Int>() }
        val visited = Array(n) { false }
        repeat(m) {
            val (a, b) = readln().split(" ").map { it.toInt() - 1 }
            graph[a].push(b)
            graph[b].push(a)
        }

        var answer = 0
        val que = LinkedList<Int>().apply { push(0) }
        while (que.isNotEmpty()) {
            val q = que.poll()
            if (visited[q]) continue
            answer++
            visited[q] = true
            graph[q].forEach { node ->
                if (!visited[node]) {
                    que.add(node)
                }
            }
        }
        println(answer - 1)
    }
}