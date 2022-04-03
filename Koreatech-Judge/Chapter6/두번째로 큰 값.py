import sys

def solution(nums,size,end):
    if size%2==1:
        nums[size-1] = nums[2*(size-1)+1]
    size -= 1
    for i in range(size-1,-1,-1):
        if nums[2*i+1]>nums[2*(i+1)]:
            nums[i] = nums[2*i+1]
        else:
            nums[i] = nums[2*(i+1)]
    index = 0
    max = nums[0]
    next_max = float('-inf')
    while 2*index+1<end and 2*(index+1)<end:
        left_index = 2*index+1
        right_index = 2*(index+1)
        
        if nums[left_index] == max:
            index = left_index
            if nums[right_index]>next_max: next_max = nums[right_index]
        else:
            index = right_index 
            if nums[left_index]>next_max: next_max = nums[left_index]
    return next_max

T = int(sys.stdin.readline())
for _ in range(T):
    N = int(sys.stdin.readline())
    nums = list(map(int,sys.stdin.readline().split()))
    if N%2 == 0:
        size = 2*N-1
        colosseum = [0]*size
        for i in range(N-1,size): colosseum[i] = nums[i-N+1]
    else:
        size = 2*N
        colosseum = [0]*size
        for i in range(N,size): colosseum[i] = nums[i-N]
    print(solution(colosseum,N,size))