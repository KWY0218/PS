package stack

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val n = nextLine().toInt()
    for (i in 0 until n) {
        val str = nextLine()
        val stack = Stack<Char>()
        var answer = true
        for (s in str) {
            if (s == '(') stack.push(s)
            else {
                if (stack.isNotEmpty()) stack.pop()
                else {
                    answer = false
                    break
                }
            }
        }
        if(stack.isEmpty() && answer) println("YES") else println("NO")
    }
}