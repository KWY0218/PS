package ps

private lateinit var visited: Array<Boolean>
private lateinit var temp: Array<Int>
private var n = 0
private var m = 0
fun main() {
    val (n1,m1) = readln().split(" ").map{it.toInt()}
    n = n1
    m = m1
    visited = Array(n+1){false}
    temp = Array(m){-1}
    solve(1,0)
}

private fun solve(start:Int, idx:Int) {
    if(idx == m) {
        temp.forEach{
            print("$it ")
        }
        println()
        return
    }
    for(i in start..n) {
        if(!visited[i]){
            visited[i] = true
            temp[idx] = i
            solve(i+1,idx+1)
            visited[i] = false
        }
    }
}
