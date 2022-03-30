
def maxSubArray(nums: list[int]) -> int:
    if len(nums) == 1: return nums[0]
    mid = len(nums)//2
    left_max = maxSubArray(nums[:mid])
    right_max = maxSubArray(nums[mid:])
    
    left = float('-inf')
    sum = 0
    for i in range(mid-1,-1,-1):
        sum += nums[i]
        if sum>left: left = sum
    
    right = float('-inf')
    sum = 0
    for i in range(mid,len(nums)):
        sum += nums[i]
        if sum>right: right = sum
    print(f"nums: ${nums}, left_max: ${left_max}, right_max: ${right_max}, middle: ${left+right}")
    return max(right+left,left_max,right_max)

print(maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))