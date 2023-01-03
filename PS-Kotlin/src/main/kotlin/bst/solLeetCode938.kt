package bst

import java.util.*

fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
    var answer = 0
    val stack = Stack<TreeNode>()

    if (root != null) stack.add(root)
    while (stack.isNotEmpty()) {
        val s = stack.pop()
        if (s.left != null) stack.push(s.left)
        if (s.right != null) stack.push(s.right)
        if (s.`val` in low..high) answer += s.`val`
    }
    return answer
}