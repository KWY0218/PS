package string

fun isPalindrome(s: String): Boolean {
    val str = s.lowercase().replace("[^a-zA-Z0-9]".toRegex(), "")
    var answer = true
    for (i in 0 until str.length/2) {
        if (str[i] != str[str.length - i]) {
            answer = false
        }
    }
    return answer
}