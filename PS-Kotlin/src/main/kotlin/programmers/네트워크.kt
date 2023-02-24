package programmers

import java.util.*
private class Solution5 {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        val visited = Array(n) {false}
        // 연결 리스트를 만든다.
        val graph = hashMapOf<Int,Stack<Int>>().apply {
            repeat(n) {
                this[it] = Stack<Int>()
            }
        }
        // 연결되어 있는 컴퓨터들끼리 연결시킨다.
        computers.forEachIndexed { idx, computer ->
            computer.forEachIndexed { i, c ->
                if(idx != i && c == 1) graph[idx]!!.add(i)
            }
        }
        var count = 0
        while(true) {
            // 시작점을 구하고
            var next = -1
            for(i in 0 until n) {
                if(!visited[i]) {
                    next = i
                    break
                }
            }
            // 만약 전부 방문했으면 while 문을 탈출한다.
            if(next == -1) break
            count++
            // 시작점과 연결된 컴퓨터를 전부 que 안에 넣는다.
            val que = LinkedList<Int>().apply{
                graph[next]!!.forEach {
                    add(it)
                }
            }
            // 시작점과 연결된 컴퓨터를 전부 방문한다.
            visited[next] = true
            while(que.isNotEmpty()){
                val n = que.pop()
                if(!visited[n]){
                    visited[n] = true
                    graph[n]!!.forEach{
                        que.add(it)
                    }
                }
            }
        }
        return count
    }
}