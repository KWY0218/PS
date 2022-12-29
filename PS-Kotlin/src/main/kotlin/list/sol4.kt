package list

fun main() {
    productExceptSelf(intArrayOf(1, 2, 3, 4))
}
// LeetCode 238
/*
* [a,b,c,d] 일 때 [b*c*d, a*c*d, a*b*d, a*b*c] 결과가 나와야 함 [ O(n), 나누기 금지 ]
*
* 2개를 구하고, 위 아래를 곱하면 O(n)이면서 나누기를 사용하지 않고 구할 수 있다.
* [1, a, a*b, a*b*d]
* [b*c*d, c*d, d, 1]
* */
fun productExceptSelf(nums: IntArray): IntArray {
    val answer = IntArray(nums.size) { 0 }
    var sum = 1;
    nums.forEachIndexed { idx, n ->
        answer[idx] = sum
        sum *= n
    }
    sum = 1
    for (i in nums.size - 1 downTo 0) {
        answer[i] *= sum
        sum *= nums[i]
    }
    return answer
}