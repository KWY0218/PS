package programmers

private class Solution4 {
    private val words = arrayOf('A','E','I','O','U')
    private var count = 0
    private var answer = 0
    fun solution(word: String): Int {
        var t = 0
        words.forEachIndexed{ idx, w ->
            if(w == word[0]) t = idx
        }
        // A: 0, E: 782, I: 1563.. 이므로 word 의 0번째 부터 탐색을 시작한다.
        answer += 781*t
        // word 의 0번째부터 탐색을 시작한다.
        solve("${word[0]}",word)
        return answer
    }
    fun solve(temp:String, word:String) {
        count++
        if(temp.length == words.size || temp == word) {
            if(temp == word) answer += count
            return
        }
        words.forEach { w->
            solve(temp+w, word)
        }
    }
}