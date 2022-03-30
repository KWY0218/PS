class Solution:
    def majorityElement(self, nums: list[int]) -> int:
        temp = dict()
        for i in nums:
            if i in temp.keys(): temp[i] += 1
            else: temp[i] = 0
        answer = float('-inf')
        t = 0
        for k,v in temp.items():
            if answer<v: 
                answer = v
                t = k
        return t