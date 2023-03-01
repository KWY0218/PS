package programmers

class Solution8 {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        val arr = Array(n+1){ 1 }
        lost.forEach{ l->
            arr[l]--
        }
        reserve.forEach{ r->
            arr[r]++
        }
        for(i in 1..n) {
            if(arr[i]==0) {
                if(i>1 && arr[i-1]==2){
                    arr[i]++
                    arr[i-1]--
                } else if(i<n && arr[i+1]==2) {
                    arr[i]++
                    arr[i+1]--
                }
            }
        }
        var answer = 0
        for(i in 1..n) {
            if(arr[i]>0) answer++
        }
        return answer
    }
}