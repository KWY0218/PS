package list

// LeetCode 561
fun arrayPairSum(nums: IntArray): Int {
    nums.sort()
    var sum = 0
    nums.forEachIndexed {idx, num ->
        if(idx%2==1) sum += num
    }
    return sum
}