package backtracking

import java.lang.Math.abs
import java.lang.Math.min
import java.util.*
import kotlin.system.exitProcess

private var n = 0
private lateinit var team: Array<IntArray>
private lateinit var isTeam: Array<Boolean>
private var answer = Int.MAX_VALUE

fun main() = with(Scanner(System.`in`)) {
    n = readln().toInt()
    team = Array(n) { IntArray(n) }
    isTeam = Array(n) { false }
    repeat(n) {
        team[it] = readln().split(" ").map { r -> r.toInt() }.toIntArray()
    }
    solve(0, 0)
    println(answer)
}

private fun solve(idx: Int, cnt: Int) {
    if (cnt == (n / 2)) {
        promising()
        return
    }
    // 조합을 구한다
    for (i in idx until n) {
        if (!isTeam[i]) {
            isTeam[i] = true
            solve(i + 1, cnt + 1)
            isTeam[i] = false
        }
    }
}

// start 팀과 link 팀의 차를 구한다
private fun promising() {
    var start = 0
    var link = 0
    team.forEachIndexed { col, c ->
        team.forEachIndexed { row, r ->
            if (isTeam[col] && isTeam[row]) {
                start += team[col][row]
            } else if (!isTeam[col] && !isTeam[row]) {
                link += team[col][row]
            }
        }
    }
    val c = abs(start - link)
    if (answer == 0) {
        println(0)
        // 0을 넣어야 한다
        exitProcess(0)
    }
    answer = min(c, answer)
}
