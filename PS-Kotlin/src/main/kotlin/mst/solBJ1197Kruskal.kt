package mst

import java.util.*

private lateinit var parent: Array<Int>

fun main() = with(Scanner(System.`in`)) {
    val (v, e) = readln().split(" ").map { it.toInt() }
    parent = Array(v + 1) { i -> i }
    val que = LinkedList<Triple<Int, Int, Int>>()
    repeat(e) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        que.add(Triple(a, b, c))
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
            answer += weight
            union(start, end)
        }
    }
    println(answer)
}

private fun find(child: Int): Int {
    if (parent[child] != child) {
        // 부모 노드 최신화를 시켜준다.
        parent[child] = find(parent[child])
    }
    return parent[child]
}

private fun union(start: Int, end: Int) {
    val startParent = find(start)
    val endParent = find(end)
    if (startParent < endParent) {
        parent[endParent] = startParent
    } else {
        parent[startParent] = endParent
    }
}
