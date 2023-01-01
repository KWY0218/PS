import linked_list.ListNode
import linked_list.mergeTwoLists
import stack.removeDuplicateLetters

fun main() {
    val l11 = ListNode(1)
    val l12 = ListNode(2)
    val l13 = ListNode(4)

    val l21 = ListNode(1)
    val l22 = ListNode(3)
    val l23 = ListNode(4)

    l11.next = l12
    l12.next = l13

    l21.next = l22
    l22.next = l23

    var l = mergeTwoLists(l11, l21)
    while(l != null) {
        println(l.`val`)
        l = l.next
    }
}