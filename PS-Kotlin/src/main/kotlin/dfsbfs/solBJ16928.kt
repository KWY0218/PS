package dfsbfs

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val (m, n) = readln().split(" ").map { it.toInt() }
    val chance = hashMapOf<Int, Int>()
    val visited = Array(100) { false }
    repeat(m + n) {
        val (start, end) = readln().split(" ").map { it.toInt() }
        chance[start] = end
    }
    // first : 위치 , second : 주사위 굴린 수
    val que = LinkedList<Pair<Int, Int>>().apply { add(Pair(1, 0)) }
    while (que.isNotEmpty()) {
        val (curr, diceCount) = que.poll()
        visited[curr] = true
        for (i in 1..6) {
            val next = curr + i
            if (next >= 100) {
                println(diceCount + 1)
                return@with
            }
            if (!visited[next]) {
                if (chance.containsKey(next)) {
                    que.add(Pair(chance[next]!!, diceCount + 1))
                } else {
                    que.add(Pair(next, diceCount + 1))
                }
                visited[next] = true
            }
        }
    }
}