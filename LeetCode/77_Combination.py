class Solution:
    def combine(self, n: int, k: int) -> list[list[int]]:
        answer = []
        
        def dfs(index,height,temp):
            if height == k: 
                answer.append(temp[:])
            
            for i in range(index,n+1):
                temp.append(i)
                dfs(i+1,height+1,temp)
                temp.pop()
        dfs(1,0,[])
        return answer