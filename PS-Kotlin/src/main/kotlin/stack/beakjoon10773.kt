package stack

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val k = nextInt()
    val li = Stack<Int>()
    for (i in 0 until k) {
        val n = nextInt()
        if (n == 0) li.pop()
        else li.push(n)
    }
    if (li.isEmpty()) println(0) else println(li.sum())
}