package queue

import java.util.*
import kotlin.collections.ArrayDeque

fun main() = with(Scanner(System.`in`)) {
    val t = nextLine().toInt()
    repeat(t) {
        val p = nextLine()
        val n = nextLine().toInt()
        val str = nextLine()
        val li = ArrayDeque<Int>()

        if (n != 0) {
            for (d in str.substring(1, str.length - 1).split(",").map { it.toInt() }) {
                li.add(d)
            }
        }

        var isReverse = false
        var isError = false
        for (command in p) {
            if (command == 'R') isReverse = !isReverse
            else {
                if (li.isEmpty()) {
                    isError = true
                    break
                }
                if (isReverse) li.removeLast()
                else li.removeFirst()
            }
        }

        // isReverse 가 true 면 역순 후 string 으로 변경한다.
        val answer =
            if (isReverse) li.reversed().joinToString(",", "[", "]") else li.joinToString(",", "[", "]")
        if (isError) println("error") else println(answer)
    }
}