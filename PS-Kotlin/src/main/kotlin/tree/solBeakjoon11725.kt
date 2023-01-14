package tree

import java.util.*

lateinit var visited: Array<Boolean>
lateinit var answer: Array<Int>
lateinit var graph: Array<Stack<Int>>

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

    // first : 다음 노드 , second : 부모노드
    val que = LinkedList<Pair<Int, Int>>().apply {
        graph[0].forEach {
            add(Pair(it, 0))
            answer[it] = 1
            visited[it] = true
        }
    }
    while (que.isNotEmpty()) {
        val q = que.pop()
        answer[q.first] = q.second + 1
        graph[q.first].forEach { next ->
            if (!visited[next]) {
                visited[next] = true
                que.add(Pair(next, q.first))
            }
        }
    }

    for (i in 1 until answer.size) println(answer[i])
}
