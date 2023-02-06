package string

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val n = readln().toInt()
    var answer = 0
    repeat(n) {
        val str = readln()
        val checkAns = hashSetOf<Char>()
        var isAns = true
        var beforeChar = ' '
        for (c in str) {
            if (beforeChar != c && checkAns.contains(c)) {
                isAns = false
                break
            } else {
                checkAns.add(c)
                beforeChar = c
            }
        }
        if (isAns) answer++
    }
    println(answer)
}