package programmers

import kotlin.math.*
class Solution7 {
    lateinit var visited: Array<Boolean>
    var answer = -1
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        visited = Array(dungeons.size){false}
        travel(k,0,dungeons)
        return answer
    }
    fun travel(curr:Int, count:Int, dungeons: Array<IntArray>) {
        for(i in 0 until dungeons.size) {
            if(!visited[i]) {
                if(curr>=dungeons[i][0]) {
                    visited[i] = true
                    travel(curr-dungeons[i][1],count+1,dungeons)
                    visited[i] = false
                }
            }
        }
        answer = max(count,answer)
    }
}