class Solution:
    def combinationSum(self, candidates: list[int], target: int) -> list[list[int]]:
        answer = []
        def dfs(count, index, temp):
            if count == 0: answer.append(temp[:])
            if count<0: return
            
            for i in range(index,len(candidates)):
                dfs(count-candidates[i],i,temp+[candidates[i]])
        dfs(target,0,[])
        return answer
    
'''
    index를 바꿔줘야 중복이 안생긴다.
'''