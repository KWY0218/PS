class Solution:
    def subsets(self, nums: list[int]) -> list[list[int]]:
        answer = []
        
        def dfs(index,temp):
            if index == len(nums): return
            
            for i in range(index,len(nums)):
                temp.append(nums[i])
                dfs(i+1,temp)
                answer.append(temp[:])
                temp.pop()
        dfs(0,[])
        answer.append([])
        return answer