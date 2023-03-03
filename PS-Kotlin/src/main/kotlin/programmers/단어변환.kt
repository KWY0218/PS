package programmers

import java.util.*
class Solution10 {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        if(!words.contains(target)) return 0
        var answer = Pair(begin,0)
        val que = LinkedList<Pair<String,Int>>().apply{
            add(answer)
        }
        while(que.isNotEmpty()){
            answer = que.pop()
            if(answer.first != target) {
                words.forEach { word->
                    if(valid(answer.first, word) == 1) {
                        que.add(Pair(word, answer.second+1))
                    }
                }
            } else {
                break
            }
        }
        return answer.second
    }

    fun valid(curr:String, comp: String): Int {
        var count = 0
        for(i in 0 until curr.length) {
            if(curr[i] != comp[i]) count++
        }
        return count
    }
}