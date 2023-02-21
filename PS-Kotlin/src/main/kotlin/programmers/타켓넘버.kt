package programmers

private class Solution {
    var answer = 0
    private fun solution(numbers: IntArray, target: Int): Int {
        solve(0,0,numbers,target)
        return answer
    }

    private fun solve(currSum:Int,next: Int, numbers:IntArray,target: Int) {
        if(next == numbers.size) {
            if(target == currSum) answer++
            return
        }
        solve(currSum + numbers[next], next+1, numbers, target)
        solve(currSum - numbers[next], next+1, numbers, target)
    }
}