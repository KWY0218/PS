import sys

def solution(nums,size):
    if size == 1:
        return (nums[0],nums[0])
    elif size == 2:
        return (nums[0],nums[1]) if nums[0]>nums[1] else (nums[1],nums[0])
    
    if size%2==0:
        if nums[0]>nums[1]:
            min = nums[1]
            max = nums[0]
        else:
            min = nums[0]
            max = nums[1]
        i = 2
        while i<size:
            if nums[i]>nums[i+1]:
                if min>nums[i+1]: min = nums[i+1]
                if max<nums[i]: max = nums[i]
            else:
                if min>nums[i]: min = nums[i]
                if max<nums[i+1]: max = nums[i+1]
            i+=2
        return (max,min)
    else:
        min = nums[0]
        max = nums[0]
        i = 1
        while i<size:
            if nums[i]>nums[i+1]:
                if min>nums[i+1]: min = nums[i+1]
                if max<nums[i]: max = nums[i]
            else:
                if min>nums[i]: min = nums[i]
                if max<nums[i+1]: max = nums[i+1]
            i+=2
        return (max,min)

T = int(sys.stdin.readline())
for i in range(T):
    N = int(sys.stdin.readline())
    nums = list(map(int, sys.stdin.readline().split()))
    print(" ".join(str(i) for i in solution(nums,N)))