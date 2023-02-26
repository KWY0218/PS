package programmers

import kotlin.math.*
import java.util.*
private class Solution6 {
    /*
        answer = abs(left - right)
        test 함수로 계산한다.
        0 ~ wires.size 까지 하나씩 뺀 배열을 test 함수에 넣는다.
        answer = min(test(),answer)
    */
    lateinit var visited: Array<Boolean>
    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer: Int = 101
        for(i in 0 until wires.size) {
            visited = Array(n+1) { false }
            val temp = Array(wires.size-1){ IntArray(2) }
            var index = 0
            wires.forEachIndexed{ idx, w->
                if(idx != i) {
                    temp[index] = w
                    index++
                }
            }
            test(temp,n)
            var count = 0
            for(i in 1..n) {
                if(visited[i]) count++
            }
            answer = min(answer, abs(2*count-n))
        }
        return answer
    }
    fun test(wires:Array<IntArray>,n:Int) {
        val graph = Array<Stack<Int>>(n+1) { Stack<Int>() }
        wires.forEach{ w->
            graph[w[0]].push(w[1])
            graph[w[1]].push(w[0])
        }
        val stack = Stack<Int>().apply{
            graph[1].forEach{
                push(it)
            }
        }
        while(stack.isNotEmpty()) {
            val s = stack.pop()
            if(!visited[s]) {
                visited[s] = true
                graph[s].forEach{ stack.push(it) }
            }
        }
    }
}