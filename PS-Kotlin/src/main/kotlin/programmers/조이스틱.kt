package programmers

import kotlin.math.*
class Solution9 {
    fun solution(name: String): Int {
        var answer = 0
        // 정직하게 이동했을 때
        var move = name.length -1
        for(i in 0 until name.length){
            answer+=runCol(name[i])
            var index = i+1
            while(index<name.length && name[index]=='A') index++
            // 오른쪽으로 갔다가 다시 왼쪽으로 가는 경우
            // 현재 위치까지 갔다가 다시 돌아가야 되므로 i*2
            // 연속된 지점까지 왼쪽으로 가야하므로 name.length-index
            move = min(move,(i*2)+name.length-index)
            // 왼쪽 먼저 갔다가 다시 오른쪽으로 가는 경우
            // 왼쪽갔다가 다시 되돌아와야해서 (name.length-index)*2
            // 그 후 다시 오른쪽으로 이동하므로 i
            move = min(move,(name.length-index)*2 + i)
        }

        return answer+move
    }
    // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 13 12 11 10 9 8 7 6 5 4 3 2 1
    fun runCol(c: Char):Int {
        val diff = c.toInt() - 'A'.toInt()
        return if(diff<=13) diff else 26-diff
    }
}