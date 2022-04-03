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
    
    
'''
    pop 연산을 O(1)로 하기 위해서 dict 자료구조를 사용했다.
    nums의 개수를 구분하는 nums_count dict과 nums_count의 index를 담은 dict을 만든다.
    문제 A번에서 풀었던 알고리즘을 활용해서 최대 값 index를 반환하는 solution 함수를 만든다.
    k번 solution 함수를 호출한다.
    한번 solution 함수를 마치면, 반환한 최대값을 nums_count에서 pop 하고
    pop한 index의 위치와 맨 마지막 index 위치와 바꿔서 O(1)속도로 최대값 index를 제거한다.
'''