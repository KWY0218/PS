package stack

import java.util.*

// LeetCode 316 참고
fun removeDuplicateLetters(s: String): String {
    val counter = hashMapOf<Char, Int>()
    val answer = Stack<Char>()
    s.forEach { c ->
        if (counter.contains(c)) counter[c] = counter[c]!! + 1
        else counter[c] = 1
    }
    s.forEach { c ->
        counter[c] = counter[c]!! - 1
        // continue
        if (answer.contains(c)) return@forEach
        // stack이 비어있지 않고, c가 stack 마지막 인덱스 보다 작고, stack 마지막 인덱스에 있는 값이 뒤에 더 있으면 pop 한다.
        while (answer.isNotEmpty() && answer[answer.size - 1] > c && counter[answer[answer.size - 1]]!! > 0) {
            answer.pop()
        }
        answer.push(c)
    }
    return answer.joinToString("")
}

// LeetCode 316 내 풀이
// 반례: bca 일 때 b가 들어오면 팝해야하지만 안함
// 중복한 값이 들어올 때 바로 뒤에 있는 값과 비교하는 로직
// 바로 뒤에 있는 값만 비교해서 오류가 생긴다.
//fun removeDuplicateLetters(s: String): String {
//    val valid = hashMapOf<Char, Int>()
//    val answer = Stack<Char>()
//    s.forEachIndexed { _, c ->
//        if (valid.contains(c)) {
//            val idx = valid[c]!!
//            if (idx != answer.size - 1 && answer[idx] > answer[idx + 1]) {
//                for (i in idx until answer.size - 1) {
//                    answer[i] = answer[i + 1]
//                    valid[answer[i]] = i
//                }
//                answer[answer.size - 1] = c
//                valid[c] = answer.size - 1
//            }
//        } else {
//            valid[c] = answer.size
//            answer.push(c)
//        }
//    }
//    return answer.joinToString("")
//}