import sys
'''
    중복 제거를 선형시간에 하는 것이 중요하다.
'''
def solution(answer,used,index,nums):
    i=0
    if index == 0:
        while i<len(nums):
            if nums[i] != 0:
                used[i] = 1
                answer[0] = nums[i]
                solution(answer,used,index+1,nums)
                used[i] = 0
                answer[0] = 0
                while i<len(nums)-1 and nums[i] == nums[i+1]: i+=1
            i+=1
    elif index == 1:
        while i<len(nums):
            if not used[i]:
                used[i] = 1
                answer[1] = nums[i]
                solution(answer,used,index+1,nums)
                used[i] = 0
                answer[1] = 0
                while i<len(nums)-1 and nums[i] == nums[i+1]: i+=1
            i+=1
    elif index == 2:
        while i<len(nums):
            if not used[i] and nums[i]%2==0:
                used[i] = 1
                answer[2] = nums[i]
                print("".join(str(i) for i in answer),end=" ")
                used[i] = 0
                answer[2] = 0
                while i<len(nums)-1 and nums[i] == nums[i+1]: i+=1
            i+=1

T = int(sys.stdin.readline())
for _ in range(T):
    N = int(sys.stdin.readline())
    D = list(map(int,sys.stdin.readline().split()))
    used = [0]*N
    answer = [0]*3
    solution(answer,used,0,sorted(D))
    print()