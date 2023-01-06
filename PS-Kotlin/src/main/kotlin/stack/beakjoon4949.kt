package stack

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val valid = hashMapOf(
        ')' to '(',
        ']' to '['
    )
    while (true) {
        val str = nextLine()
        if (str == ".") break
        val stack = Stack<Char>()
        var answer = true

        for (s in str) {
            if (s == '(' || s == '[') stack.push(s)
            else if (s == ')' || s == ']') {
                if (stack.isEmpty() || stack.pop() != valid[s]) {
                    answer = false
                    break
                }
            }
        }
        if (stack.isEmpty() && answer) println("yes") else println("no")
    }
}