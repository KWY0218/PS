package queue

import java.util.LinkedList
import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val size = nextInt()
    val que = LinkedList<Int>()
    while (true) {
        val data = nextInt()
        if (data == -1) break
        if (data == 0 && que.isNotEmpty()) que.pop()
        else if (que.size < size) que.add(data)
    }
    if (que.isEmpty()) println("empty")
    else que.forEach { print("$it ") }
}