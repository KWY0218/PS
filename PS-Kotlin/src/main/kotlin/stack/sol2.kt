package stack

import java.util.*

// LeetCode 739
fun dailyTemperatures(temperatures: IntArray): IntArray {
    val stack = Stack<Int>()
    val answer = IntArray(temperatures.size) { 0 }
    temperatures.forEachIndexed { idx, temp ->
        // stack 내에 최근에 들어온 값과 현재 값을 비교한다.
        while (stack.isNotEmpty() && temperatures[stack[stack.size-1]] < temp) {
            val index = stack.pop()
            answer[index] = idx - index
        }
        stack.add(idx)
    }
    return answer
}