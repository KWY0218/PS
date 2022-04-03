import sys

def solution(nums_count,index,size):
    if size == 1: return 0
    if size == 2:
        if nums_count[index[0]] > nums_count[index[1]]: return 0
        else: return 1
    
    if size%2==0:
        if nums_count[index[0]] > nums_count[index[1]]: max_index = 0
        else: max_index = 1
        i = 2
        while i<size:
            if nums_count[index[i]]<nums_count[index[i+1]]:
                if nums_count[index[max_index]]<nums_count[index[i+1]]: max_index = i+1
            else:
                if nums_count[index[max_index]]<nums_count[index[i]]: max_index = i
            i+=2
        return max_index
    else:
        max_index = 0
        i = 1
        while i<size:
            if nums_count[index[i]]<nums_count[index[i+1]]:
                if nums_count[index[max_index]]<nums_count[index[i+1]]: max_index = i+1
            else:
                if nums_count[index[max_index]]<nums_count[index[i]]: max_index = i
            i+=2
        return max_index

T = int(sys.stdin.readline())
for _ in range(T):
    N, K = map(int,sys.stdin.readline().split())
    nums = list(map(int,sys.stdin.readline().split()))
    nums_count = dict()
    index = dict()
    i= 0
    for n in nums:
        if n in nums_count.keys(): nums_count[n] += 1
        else:
            nums_count[n] = 1
            index[i] = n
            i += 1
    for _ in range(K):
        temp = solution(nums_count,index,i)
        print(index[temp],end=" ")
        nums_count.pop(index[temp])
        index[temp] = index[i-1]
        i-=1
    print()