package linked_list

// LeetCode 24
fun swapPairs(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    var list = head
    var tempNode = ListNode(-1)
    val answer = tempNode
    while (list?.next != null) {
        val nextNode = list.next
        list.next = nextNode?.next
        nextNode?.next = list
        tempNode.next = nextNode

        tempNode = tempNode.next!!.next!!
        list = list.next
    }
    return answer.next
}