package dfsbfs

import java.util.*

data class Loc(val x: Int, val y: Int, val distance: Int, val isBroken: Boolean)

private val direction = listOf(Pair(0, 1), Pair(0, -1), Pair(-1, 0), Pair(1, 0))
private val que = LinkedList<Loc>().apply { add(Loc(0, 0, 1, false)) }

fun main() = with(Scanner(System.`in`)) {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = Array(n) { IntArray(m) }
    repeat(n) { graph[it] = readln().map { input -> input.toString().toInt() }.toIntArray() }
    val visited = Array(n) { Array(m) { Array(2) { false } } }
    while (que.isNotEmpty()) {
        val q = que.poll()
        // 마지막 인댁스까지 왔으면 출력 후 종료
        if (q.x == m-1 && q.y == n-1) {
            println(q.distance)
            return@with
        }
        direction.forEach { (c, r) ->
            val col = q.y + c
            val row = q.x + r
            // index 가 (n x m) 초과시 continue
            if (!(col in 0 until n && row in 0 until m)) return@forEach
            // 벽이 아니고
            if (graph[col][row] == 0) {
                // 벽을 부수지 않은 상태이면서 방문하지 않은 곳이라면
                if (!q.isBroken && !visited[col][row][0]) {
                    visited[col][row][0] = true
                    que.add(Loc(row, col, q.distance + 1, q.isBroken))
                // 벽을 한번 부순 상태이면서 방문하지 않은 곳이라면
                } else if (q.isBroken && !visited[col][row][1]) {
                    visited[col][row][1] = true
                    que.add(Loc(row, col, q.distance + 1, q.isBroken))
                }
            // 벽이면서
            } else if (graph[col][row] == 1) {
                // 한번도 부순적이 없는 상태이면
                if (!q.isBroken) {
                    visited[col][row][1] = true
                    que.add(Loc(row, col, q.distance + 1, true))
                }
            }
        }
    }
    println(-1)
}
