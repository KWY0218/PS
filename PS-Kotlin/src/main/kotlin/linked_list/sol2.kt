package linked_list

// LeetCode 206
fun reverseList(head: ListNode?): ListNode? {
    if(head == null) return null
    var temp = ListNode(head.`val`)
    var h = head
    h = h.next
    while(h != null) {
        val currentNode = ListNode(h.`val`)
        currentNode.next = temp
        temp = currentNode
        h = h.next
    }
    return temp
}