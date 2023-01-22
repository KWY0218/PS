package dfsbfs

import java.util.*

private lateinit var graph: Array<Stack<Pair<Int, Int>>>

// INT.MAX_VALUE 로 하면 덧샘 과정에서 오버플로우가 발생해서 틀린다
// 최대 간선의 개수 200,000 이고, 가중치의 최대값은 1,000 이므로
// 200,000 * 1,000 = 2000000000
private val INF = 200000000

fun main() = with(Scanner(System.`in`)) {
    val (v, e) = readln().split(" ").map { it.toInt() }
    graph = Array(v + 1) { Stack<Pair<Int, Int>>() }

    repeat(e) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        graph[a].add(Pair(c, b))
        graph[b].add(Pair(c, a))
    }
    val (v1, v2) = readln().split(" ").map { it.toInt() }

    // 1 -> v1 -> v2 -> n
    var ans1 = 0
    ans1 += solve(1, v1, v)
    ans1 += solve(v1, v2, v)
    ans1 += solve(v2, v, v)
    // 1 -> v2 -> v1 -> n
    var ans2 = 0
    ans2 += solve(1, v2, v)
    ans2 += solve(v2, v1, v)
    ans2 += solve(v1, v, v)

    if (ans1 >= INF && ans2 >= INF) println(-1)
    else println(kotlin.math.min(ans1, ans2))
}

private fun solve(start: Int, end: Int, v: Int): Int {
    val distance = IntArray(v + 1) { INF }
    val visited = Array(v + 1) { false }
    val que = PriorityQueue(Comparator { p1: Pair<Int, Int>, p2: Pair<Int, Int> ->
        when {
            p1.first > p2.first -> 1
            p1.first < p2.first -> -1
            else -> 0
        }
    })

    distance[start] = 0
    que.add(Pair(0, start))
    while (que.isNotEmpty()) {
        val (d, curr) = que.poll()
        if (visited[curr]) continue
        visited[curr] = true
        graph[curr].forEach {
            val dist = it.first + d
            if (!visited[it.second] && dist < distance[it.second]) {
                distance[it.second] = dist
                que.add(Pair(dist, it.second))
            }
        }
    }
    return distance[end]
}