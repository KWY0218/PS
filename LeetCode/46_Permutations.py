class Solution:
    def permute(self, nums: list[int]) -> list[list[int]]:
        used = [0]*len(nums)
        answer = []
        
        # answer.append(word[:]) 이렇게 해야 복사 됌
        def dfs(index,word):
            if index == len(nums):
                answer.append(word[:])
                return
            
            for w in range(len(nums)):
                if not used[w]:
                    used[w] = 1
                    word.append(nums[w])
                    dfs(index+1,word)
                    word.pop()
                    used[w] = 0
        
        dfs(0,[])
        return answer