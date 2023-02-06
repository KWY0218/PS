package string

import java.util.*

fun reverseString(s: CharArray): Unit {
    for (i in 0 until s.size / 2) {
        val preTemp = s[i]
        val postTemp = s[s.size - 1 - i]
        s[i] = postTemp
        s[s.size - 1 - i] = preTemp
    }
}