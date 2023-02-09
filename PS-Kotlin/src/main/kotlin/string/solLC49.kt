package string

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val temp = hashMapOf<String, MutableList<String>>()
    strs.forEach { str ->
        val s = str
            .split("")
            .sorted()
            .joinToString("")
        if (temp.containsKey(s)) {
            temp[s] = mutableListOf<String>().apply {
                add(str)
            }
        } else {
            temp[s]!!.add(str)
        }
    }
    val answer = mutableListOf<List<String>>()
    temp.values.forEach { v ->
        answer.add(v.sorted())
    }
    return answer
}