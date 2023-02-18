package ps

fun main() {
    val days = hashMapOf<Int, Int>().apply {
        put(1, 31)
        put(2, 28)
        put(3, 31)
        put(4, 30)
        put(5, 31)
        put(6, 30)
        put(7, 31)
        put(8, 31)
        put(9, 30)
        put(10, 31)
        put(11, 30)
        put(12, 31)
    }
    val (month, day) = readln().split(" ").map { it.toInt() }
    var daySum = 0
    if (month > 1) {
        for (i in 1 until month) {
            daySum += days[i]!!
        }
    }
    daySum += day
    when(daySum%7){
        0-> println("SUN")
        1-> println("MON")
        2-> println("TUE")
        3-> println("WED")
        4-> println("THU")
        5-> println("FRI")
        6-> println("SAT")
    }
}