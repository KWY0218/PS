package stack

import java.util.*

// LeetCode 20
fun isValid(s: String): Boolean {
    val stack = Stack<Char>()
    val valid = hashMapOf(
        ')' to '(',
        '}' to '{',
        ']' to '['
    )
    s.forEach { c ->
        if (c == '(' || c == '{' || c == '[') {
            stack.push(c)
        } else {
            // s = "]" 일 경우 stack 내부는 empty 이므로 false 반환
            if (stack.isEmpty() || valid[c] != stack.pop()) return false
        }
    }
    // s = "[" 일 경우 stack 내부가 다 비워져있지 않으므로 false 반환
    return stack.isEmpty()
}