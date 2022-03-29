import sys
import random

def quick_sort(start,end):
    if start==end: return
    pivot = start
    left = pivot+1
    for i in range(left,end):
        if nums[pivot]>nums[i]:
            nums[left], nums[i] = nums[i], nums[left]
            left+=1
    nums[pivot], nums[left-1] = nums[left-1], nums[pivot]
    quick_sort(start,left-1)
    quick_sort(left,end)
    
def random_quick_sort(start,end):
    if start==end: return
    random_pivot = random.randrange(start,end)
    nums[random_pivot], nums[start] = nums[start], nums[random_pivot]
    
    pivot = start
    left = pivot+1
    for i in range(left,end):
        if nums[pivot]>nums[i]:
            nums[left], nums[i] = nums[i], nums[left]
            left+=1
    nums[pivot], nums[left-1] = nums[left-1], nums[pivot]
    random_quick_sort(start,left-1)
    random_quick_sort(left,end)
    
T = int(sys.stdin.readline())
for _ in range(T):
    N = int(sys.stdin.readline())
    nums = list(map(int,sys.stdin.readline().split()))
    random_quick_sort(0,N)
    
    answer = [0]*N
    
    mid = N//2 if N%2 == 0 else N//2+1
    
    for i in range(0,N-mid):
        answer[2*i+1] = nums[N-i-1]        
    for i in range(0,mid):
        answer[2*i] = nums[mid-i-1]
    print(N)
    print(" ".join(str(i) for i in answer))