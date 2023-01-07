package queue

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val c = nextLine().toInt()
    for (i in 0 until c) {
        val (n, m) = nextLine().split(" ").map { it.toInt() }
        var nums = nextLine().split(" ").map { it.toInt() }
        val li = LinkedList<Pair<Int, Int>>()
        nums.forEachIndexed { idx, data ->
            li.add(Pair(idx, data))
        }
        nums = nums.sortedByDescending { it }
        var count = 0
        nums.forEach { num ->
            while (true) {
                if (num != li.peek().second) li.add(li.pop())
                else {
                    val data = li.pop()
                    count++
                    if (data.first == m) {
                        println(count)
                        return@forEach
                    }
                    break
                }
            }
        }
    }
}