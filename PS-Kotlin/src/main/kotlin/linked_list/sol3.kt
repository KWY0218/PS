package linked_list

// LeetCode 2
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var list1 = l1
    var list2 = l2
    var temp = ListNode(-1)
    val answer = temp
    var nextSum = 0
    while (list1 != null && list2 != null) {
        val sum = list1.`val` + list2.`val` + nextSum
        temp.next = ListNode(sum % 10)
        nextSum = sum / 10
        temp = temp.next!!
        list1 = list1.next
        list2 = list2.next
    }

    while (list1 != null) {
        val sum = list1.`val` + nextSum
        temp.next = ListNode(sum % 10)
        nextSum = sum / 10
        temp = temp.next!!
        list1 = list1.next
    }

    while (list2 != null) {
        val sum = list2.`val` + nextSum
        temp.next = ListNode(sum % 10)
        nextSum = sum / 10
        temp = temp.next!!
        list2 = list2.next
    }

    if(nextSum != 0) {
        temp.next = ListNode(nextSum)
        temp = temp.next!!
    }
    return answer.next
}