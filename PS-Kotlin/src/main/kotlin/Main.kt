import linked_list.ListNode
import linked_list.mergeTwoLists
import linked_list.reverseList
import stack.removeDuplicateLetters

fun main() {
    val l1 = ListNode(1)
    val l2 = ListNode(2)
    val l3 = ListNode(3)
    val l4 = ListNode(4)
    val l5 = ListNode(5)

    l1.next = l2
    l2.next = l3
    l3.next = l4
    l4.next = l5

    var l = reverseList(l1)
    while(l != null) {
        println(l.`val`)
        l = l.next
    }
}