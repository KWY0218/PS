package priority_que

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val n = readln().toInt()
    val minusQue = PriorityQueue<Int>(Collections.reverseOrder())
    val plusQue = PriorityQueue<Int>()
    repeat(n) {
        when (val c = readln().toInt()) {
            0 -> {
                if (minusQue.isEmpty() && plusQue.isEmpty()) println(0)
                else if (!minusQue.isEmpty() && plusQue.isEmpty()) println(minusQue.poll())
                else if (minusQue.isEmpty() && !plusQue.isEmpty()) println(plusQue.poll())
                else if (-minusQue.peek() > plusQue.peek()) println(plusQue.poll())
                else if (-minusQue.peek() <= plusQue.peek()) println(minusQue.poll())
            }

            else -> {
                if (c > 0) plusQue.add(c)
                else minusQue.add(c)
            }
        }
    }
}