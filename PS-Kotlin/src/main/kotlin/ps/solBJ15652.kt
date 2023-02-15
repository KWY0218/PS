package ps

private val sb = StringBuilder()
private lateinit var temp:Array<Int>
private var m = 0
private var n = 0

fun main() {
    val (m1,n1) = readln().split(" ").map{it.toInt()}
    m = m1
    n = n1
    temp = Array(n){-1}
    solve(1,0)
    println(sb)
}

private fun solve(start:Int, idx:Int) {
    if(idx == n) {
        sb.append(temp.joinToString(" ")).append("\n")
        return
    }
    for(i in start..m){
        temp[idx] = i
        solve(i,idx+1)
    }
}
