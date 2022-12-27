import sys

'''
    오른쪽 원소를 추가할 때, 왼쪽의 남은 요소의 개수가 역쌍의 개수이다.
'''

def merge_sort(start,end):
    if (end-start) < 2: return 0
    mid = (start+end)//2
    merge_sort(start,mid)
    merge_sort(mid,end)
    merge(start,mid,end)

def merge(start,mid,end):
    left_index = start
    right_index = mid
    sort_list = []
    while left_index<mid and right_index<end:
        if K[left_index]>K[right_index]:
            sort_list.append(K[right_index])
            right_index += 1
        else:
            sort_list.append(K[left_index])
            left_index += 1
    
    while left_index<mid:
        sort_list.append(K[left_index])
        left_index += 1
        
    while right_index<end:
        sort_list.append(K[right_index])
        right_index += 1   
    
    for i in range(start,end):
        K[i] = sort_list[i-start]

T = int(sys.stdin.readline())
for _ in range(T):  
    N = int(sys.stdin.readline())
    K = list(map(int,sys.stdin.readline().split()))
    merge_sort(0,len(K))
    print(K)