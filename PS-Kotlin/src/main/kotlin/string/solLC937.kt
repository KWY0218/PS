package string

fun mostCommonWord(paragraph: String, banned: Array<String>): String {
    val p = paragraph
        .toLowerCase()
        .replace("[^a-zA-z0-9 ]".toRegex(), "")
        .split(" ")
        .groupingBy { it }
        .eachCount()
        .toList()
        .sortedByDescending { it.second }
    var answer = ""
    for (i in 0 until p.size) {
        if (p[i].first != "" && !(banned.contains(p[i].first))) {
            answer = p[i].first
            break
        }
    }
    return answer
}