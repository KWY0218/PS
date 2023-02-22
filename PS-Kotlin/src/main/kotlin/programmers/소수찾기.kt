package programmers

private class Solution2 {
    val temp = mutableSetOf<Int>()
    fun solution(numbers: String): Int {
        val nums = numbers.toList()
        for(i in 1..nums.size) {
            search(0,Array(i){ ' ' },nums,Array(nums.size){false})
        }
        var count = 0
        temp.forEach {
            if(isAns(it)) count++
        }
        return count
    }

    private fun search(next:Int,holder:Array<Char>,nums:List<Char>,visited:Array<Boolean>) {
        if(next == holder.size) {
            temp.add(holder.joinToString("").toInt())
            return
        }
        for(i in 0 until nums.size) {
            if(!visited[i]){
                visited[i] = true
                holder[next] = nums[i]
                search(next+1,holder,nums,visited)
                visited[i] = false
            }
        }
    }

    private fun isAns(target:Int):Boolean {
        if(target<2) return false
        if(target == 2) return true
        for(i in 2 until target) {
            if(target % i == 0) return false
        }
        return true
    }
}