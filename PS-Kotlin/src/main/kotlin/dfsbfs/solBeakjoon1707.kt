package dfsbfs

import java.util.*

private lateinit var graph: Array<Stack<Int>>
private lateinit var visited: Array<Int>
private var answer = true

/*
* 이분그래프를 만족하기 위해선 인접한 노드가 자신의 state 와 다르면 된다.
* 
* */
fun main() = with(Scanner(System.`in`)) {
    val k = readln().toInt()
    repeat(k) {
        val (v, e) = readln().split(" ").map { it.toInt() }
        graph = Array(v) { Stack<Int>() }
        repeat(e) {
            val (n1, n2) = readln().split(" ").map { it.toInt() - 1 }
            graph[n1].push(n2)
            graph[n2].push(n1)
        }
        visited = Array(v) { 0 }

        while (true) {
            var index = -1
            for(i in 0 until v) {
                if (visited[i] == 0) {
                    index = i
                    break
                }
            }
            if (index == -1) break
            dfs(index, 1)
            if (!answer) break
        }
        if (answer) println("YES") else println("NO")
        // 전역 변수라서 초기화 한다.
        answer = true
    }
}

fun dfs(n: Int, state: Int) {
    if (!answer) return
    visited[n] = state
    graph[n].forEach { node ->
        when (visited[node]) {
            state -> {
                answer = false
                return
            }
            0 -> {
                visited[node] = state * -1
                dfs(node, state * -1)
            }
        }
    }
}