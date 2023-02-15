package ps

private var m = 0
private var n = 0
private lateinit var temp:Array<Int>
private val sb = StringBuilder()

fun main() {
    val (m1,n1) = readln().split(" ").map{it.toInt()}
    m = m1
    n = n1
    temp = Array(n){ -1 }
    solve(0)
    println(sb)
}

private fun solve(idx:Int){
    if(idx == n) {
        sb.append(temp.joinToString(" ")).append("\n")
        return
    }
    for(i in 1..m) {
        temp[idx] = i
        solve(idx+1)
    }
}
