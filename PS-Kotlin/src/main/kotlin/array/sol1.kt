package array
// Runtime 261ns
fun twoSum(nums: IntArray, target: Int): IntArray {
    var fInx = -1
    var sInx = -1
    nums.forEachIndexed { index, num ->
        val t = target - num
        for(i in index+1 until nums.size){
            if(t == nums[i]){
                fInx = index
                sInx = i
                break
            }
        }
        if(sInx != -1) return@forEachIndexed
    }
    return intArrayOf( fInx, sInx )
}

// Other , Runtime 218ns
fun otherTwoSum(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int, Int>()
    for(i in 0..nums.size-1) {
        if(!map.contains(nums.get(i))){
            map.put(target-nums.get(i),i)
        } else {
            val key = map.get(nums.get(i))
            key?.let {
                return intArrayOf(it,i)
            }
        }
    }
    return intArrayOf(-1,-1)
}