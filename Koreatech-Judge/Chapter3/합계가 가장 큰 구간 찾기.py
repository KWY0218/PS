import sys

def find_max(start,end):
    if end==start: return nums[start]
    
    mid = (start+end)//2
    left_max = float("-inf")
    temp = 0
    for i in range(mid,start-1,-1):
        temp += nums[i]
        left_max = max(left_max,temp)
    
    right_max = float("-inf")
    temp = 0
    for i in range(mid+1,end+1):
        temp += nums[i]
        right_max = max(right_max,temp)
    
    left = find_max(start,mid)
    right = find_max(mid+1,end)
    
    return max(left_max+right_max,left,right)
    
T = int(sys.stdin.readline())
for _ in range(T):
    N  = int(sys.stdin.readline())
    nums = list(map(int,sys.stdin.readline().split()))
    print(find_max(0,N-1))