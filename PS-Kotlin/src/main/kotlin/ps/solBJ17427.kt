package ps

/*
* N= 10일 때,
* [1][1,2][1,3][1,2,4][1,5][1,2,3,6][1,7][1,2,4,8][1,3,9][1,2,5,10]
* 1의 개수 = 10개
* 2의 개수 = 5개
* ...
* 10의 개수 = 1개
*
* 1*10 + 2*5 + ... + 10*1
* */

fun main() {
    val n = readln().toInt()
    var answer = 0L
    for (i in 1..n) {
        answer += i*(n/i)
    }
    println(answer)
}
