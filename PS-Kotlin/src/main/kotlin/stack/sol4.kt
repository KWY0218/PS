package stack

import linked_list.ListNode
import java.util.*

fun pairSum(head: ListNode?): Int {
    // 길이가 2일 때 바로 반환
    if (head?.next?.next == null) return head?.`val`!! + head.next?.`val`!!

    var slow = head
    var fast = head
    // slow 를 절반 위치에 위치시킨다.
    while (fast != null) {
        slow = slow?.next
        fast = fast.next?.next
    }

    // slow `val` 값을 스택에 넣는다.
    val stack = Stack<Int>()
    while (slow != null) {
        stack.push(slow.`val`)
        slow = slow.next
    }

    var answer = -1
    var h = head
    // stack 을 pop 한 값과 node의 앞의 값을 더한다.
    while (stack.isNotEmpty()) {
        val add = stack.pop()
        answer = kotlin.math.max(add + h!!.`val`, answer)
        h = h.next
    }
    return answer
}