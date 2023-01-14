package tree

import java.util.*

private lateinit var visited: Array<Boolean>
private lateinit var answer: Array<Int>
private lateinit var graph: Array<Stack<Int>>

fun main() = with(Scanner(System.`in`)) {
    val n = readln().toInt()
    graph = Array(n) { Stack<Int>() }

    repeat(n - 1) {
        val (start, end) = readln().split(" ").map { it.toInt() - 1 }
        graph[start].add(end)
        graph[end].add(start)
    }
    visited = Array(n) { false }
    answer = Array(n) { 0 }

    dfs(0, -1)

    for (i in 1 until answer.size) println(answer[i])
}

fun dfs(currNode: Int, parent: Int) {
    visited[currNode] = true
    answer[currNode] = parent + 1
    graph[currNode].forEach {
        if (!visited[it]) {
            dfs(it, currNode)
        }
    }
}
