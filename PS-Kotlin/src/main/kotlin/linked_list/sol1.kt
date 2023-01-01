package linked_list

// LeetCode 21
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    var temp = ListNode(-1)
    val answer = temp
    var l1 = list1
    var l2 = list2
    while (l1 != null && l2 != null) {
        if (l1.`val` > l2.`val`) {
            temp.next = ListNode(l2.`val`)
            l2 = l2.next
        } else {
            temp.next = ListNode(l1.`val`)
            l1 = l1.next
        }
        temp = temp.next!!
    }
    while (l1 != null) {
        temp.next = ListNode(l1.`val`)
        l1 = l1.next
        temp = temp.next!!
    }
    while (l2 != null) {
        temp.next = ListNode(l2.`val`)
        l2 = l2.next
        temp = temp.next!!
    }
    return answer.next
}