package divide_and_conquer

import java.util.*

val array = arrayOf(3, 4, 1, 8, 7, 2, 6, 5)
fun main() = with(Scanner(System.`in`)) {
    array.forEach { print("$it ") }
    println()
    divide(0, 8)
    array.forEach { print("$it ") }
    println()
}

private fun divide(start: Int, end: Int) {
    if (end - start < 2) return;
    val mid = (start + end) / 2
    // divide
    divide(start, mid)
    divide(mid, end)
    // conquer
    merge(start, mid, end)
}

private fun merge(start: Int, mid: Int, end: Int) {
    var leftIndex = start
    var rightIndex = mid
    val emptyArray = IntArray(end) { 0 }
    var index = start
    while (leftIndex < mid && rightIndex < end) {
        if (array[leftIndex] > array[rightIndex]) {
            emptyArray[index] = array[rightIndex]
            index++
            rightIndex++
        } else {
            emptyArray[index] = array[leftIndex]
            index++
            leftIndex++
        }
    }
    while (leftIndex < mid) {
        emptyArray[index] = array[leftIndex]
        index++
        leftIndex++
    }
    while (rightIndex < end) {
        emptyArray[index] = array[rightIndex]
        index++
        rightIndex++
    }
    print("start $start end $end  ")
    for (i in start until end) {
        print("${emptyArray[i]} ")
        array[i] = emptyArray[i]
    }
    println()
}
