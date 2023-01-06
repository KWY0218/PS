package stack

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    val arr = Array(n) { 0 }
    for (i in 0 until n) {
        arr[i] = nextInt()
    }

    val stack = Stack<Int>()
    val answer = Stack<Char>()
    var idx = 0
    for (i in 1..n) {
        stack.push(i)
        answer.push('+')
        if (arr[idx] == i) {
            while (idx < n && stack.isNotEmpty() && arr[idx] == stack.peek()) {
                stack.pop()
                answer.push('-')
                idx++
            }
        }
    }
    if (stack.isEmpty()) answer.forEach { println(it) } else println("NO")
}