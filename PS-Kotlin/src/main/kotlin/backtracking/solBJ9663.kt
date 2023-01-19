package backtracking

import java.util.*
import kotlin.math.abs

// 열마다 놓을 퀸의 자리를 입력하는 배열
private lateinit var arr: Array<Int>
private var n: Int = 0
private var answer = 0
fun main() = with(Scanner(System.`in`)) {
    n = readln().toInt()
    arr = Array(n) { 0 }
    nextCol(0)
    println(answer)
}

private fun nextCol(col: Int) {
    // 끝까지 왔으면 정답을 더한다
    if (col == n) {
        answer += 1
        return
    }
    // n 만큼 반복해서 해당 열에 퀸을 한자리씩 놓아본다.
    repeat(n) { row ->
        // n 번째 열에 row 행을 놓는것이
        arr[col] = row
        // 유망하다면 해당 열의 행에 퀸을 넣고
        if (promising(col)) {
            // 다음 열로 이동한다.
            nextCol(col + 1)
        }
    }
}

private fun promising(col: Int): Boolean {
    // 현재까지 놓은 col 만큼 검사를 한다.
    repeat(col) {
        // 같은 행에 놓여져 있으면 false 를 반환한다.
        if (arr[it] == arr[col]) return false
        // 대각선에 놓여져 있으면 false 를 반환한다.
        // 대각선 공식 : 해당 열의 차 와 해당 행의 차가 같으면 대각선에 위치한 것이다.
        else if (abs(col - it) == abs(arr[col] - arr[it])) return false
    }
    return true
}