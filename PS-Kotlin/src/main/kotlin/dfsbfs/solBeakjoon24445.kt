package dfsbfs

import java.util.*

private lateinit var graph: Array<Stack<Int>>
private lateinit var visited: Array<Boolean>
private lateinit var count: Array<Int>
private var num = 1

fun main() = with(Scanner(System.`in`)) {
    val (n, m, r) = readln().split(" ").map { it.toInt() }
    graph = Array(n) { Stack<Int>() }
    visited = Array(n) { false }
    count = Array(n) { 0 }

    repeat(m) {
        readln().split(" ")
            .map { it.toInt() - 1 }
            .let {
                graph[it[0]].push(it[1])
                graph[it[1]].push(it[0])
            }
    }
    graph.forEach { it.sortDescending() }
    bfs(r - 1)
    count.forEach { println(it) }
}

fun bfs(n: Int) {
    val que = LinkedList<Int>()
    que.add(n)
    visited[n] = true
    count[n] = num++
    while (que.isNotEmpty()) {
        val q = que.poll()
        graph[q].forEach { node ->
            if (!visited[node]) {
                count[node] = num++
                visited[node] = true
                que.add(node)
            }
        }
    }
}