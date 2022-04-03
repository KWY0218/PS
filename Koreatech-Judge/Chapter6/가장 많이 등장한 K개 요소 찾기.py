import sys
import random

def solution(nums,start,end,target):
    random_pivot = random.randrange(start,end)
    nums[random_pivot], nums[start] = nums[start], nums[random_pivot]
    
    pivot = start
    left = pivot + 1
    for i in range(left,end):
        if nums[pivot]>nums[i]:
            nums[left], nums[i] = nums[i], nums[left]
            left+=1
    nums[pivot], nums[left-1] = nums[left-1], nums[pivot]
    if left == target: return nums[left-1]
    elif left>target: return solution(nums,start,left-1,target)
    elif left<target: return solution(nums,left,end,target)

T = int(sys.stdin.readline())
for _ in range(T):
    N, K = map(int,sys.stdin.readline().split())
    nums = list(map(int,sys.stdin.readline().split()))
    print(solution(nums,0,N,K))