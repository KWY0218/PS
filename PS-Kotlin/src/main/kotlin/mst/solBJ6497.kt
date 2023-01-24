package mst

import java.util.*

private lateinit var parent: Array<Int>
private lateinit var que: LinkedList<Triple<Int, Int, Int>>

fun main() = with(Scanner(System.`in`)) {
    while (true) {
        val (m, n) = readln().split(" ").map { it.toInt() }
        if (m == 0 && n == 0) break
        que = LinkedList()
        parent = Array(m) { i -> i }
        repeat(n) {
            val (x, y, z) = readln().split(" ").map { it.toInt() }
            que.add(Triple(x, y, z))
        }
        que.sortWith { t1, t2 ->
            when {
                t1.third > t2.third -> 1
                t1.third < t2.third -> -1
                else -> 0
            }
        }
        var answer = 0
        while (que.isNotEmpty()) {
            val (start, end, weight) = que.poll()
            if (find(start) != find(end)) {
                union(start, end)
            } else {
                // 절약 할 수 있는 비용이라서 union 을 하지 않을 때 answer 을 더한다
                answer += weight
            }
        }
        println(answer)
    }
}

private fun find(child: Int): Int {
    if (parent[child] != child) {
        parent[child] = find(parent[child])
    }
    return parent[child]
}

private fun union(start: Int, end: Int) {
    val startP = find(start)
    val endP = find(end)
    if (startP > endP) {
        parent[startP] = endP
    } else {
        parent[endP] = startP
    }
}
