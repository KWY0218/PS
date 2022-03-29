import sys

def quick_sort(start, end):
    if start == end: return
    pivot = start
    left = pivot+1
    for i in range(start,end):
        if nums[pivot]>nums[i]:
            nums[left], nums[i] = nums[i], nums[left]
            left+=1
    nums[pivot], nums[left-1] = nums[left-1], nums[pivot]
    quick_sort(start,left-1)
    quick_sort(left,end)

def divide_sort(start,end):
    if end-start == 1: return
    mid = (start+end)//2
    divide_sort(start,mid)
    divide_sort(mid,end)
    merge(start,mid,end)

def merge(start,mid,end):
    temp = []
    left_index = start
    right_index = mid
    while left_index<mid and right_index<end:
        if nums[left_index]<nums[right_index]:
            temp.append(nums[left_index])
            left_index+=1
        else:
            temp.append(nums[right_index])
            right_index+=1
    
    while left_index<mid:
        temp.append(nums[left_index])
        left_index+=1
    while right_index<end:
        temp.append(nums[right_index])
        right_index+=1
    
    for i in range(start,end):
        nums[i] = temp[i-start]
    

T = int(sys.stdin.readline())
nums = []
for _ in range(T):
    nums.append(int(sys.stdin.readline()))
divide_sort(0,T)
[print(i) for i in nums]