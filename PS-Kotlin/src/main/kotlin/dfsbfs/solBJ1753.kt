package dfsbfs

import java.util.*

private lateinit var graph: Array<Stack<Pair<Int, Int>>>
private lateinit var visited: IntArray
private val stack: PriorityQueue<Pair<Int, Int>> = PriorityQueue(Comparator<Pair<Int, Int>> { a, b ->
    when {
        a.first > b.first -> 1
        a.first < b.first -> -1
        else -> 0
    }
})

fun main() = with(Scanner(System.`in`)) {
    val (v, e) = readln().split(" ").map { it.toInt() }
    val start = readln().toInt()
    graph = Array(v + 1) { Stack<Pair<Int, Int>>() }
    visited = IntArray(v + 1) { Integer.MAX_VALUE }
    repeat(e) {
        val (u, v2, w) = readln().split(" ").map { it.toInt() }
        graph[u].push(Pair(w, v2))
    }
    stack.add(Pair(0, start))
    visited[start] = 0
    while (stack.isNotEmpty()) {
        val (w, curr) = stack.poll()
        if (visited[curr] < w) continue
        graph[curr].forEach {
            val dist = it.first + w
            if (dist < visited[it.second]) {
                visited[it.second] = dist
                stack.add(Pair(dist, it.second))
            }
        }
    }
    for (i in 1..v) {
        if (visited[i] == Integer.MAX_VALUE) println("INF")
        else println(visited[i])
    }
}