package programmers

import java.util.*

class Solution3 {
    private lateinit var visited: Array<Boolean>
    private val answer = Stack<String>()
    private fun solution(tickets: Array<Array<String>>): Array<String> {
        visited = Array(tickets.size) { false }
        // icn 부터 시작한다!
        trip("ICN", "ICN", 0, tickets)
        // list to array
        return answer.sorted()[0].split(" ").toTypedArray()
    }

    private fun trip(start: String, route: String, count: Int, tickets: Array<Array<String>>) {
        // tickets.size 인 이유는 +1 을 하면 visited 가 모두 false 라서 조건식을 충족하지 못하기 때문이다.
        if (count == tickets.size) {
            answer.add(route)
            return
        }
        tickets.forEachIndexed { idx, ticket ->
            if (ticket[0] == start && !visited[idx]) {
                visited[idx] = true
                trip(ticket[1], route + " ${ticket[1]}", count + 1, tickets)
                visited[idx] = false
            }
        }
    }
}