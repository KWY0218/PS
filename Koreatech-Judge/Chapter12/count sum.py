import sys

def answer(M,N,index,nums):
    if index>N: return 0
    if M ==0: return 1
    count = 0
    for i in range(index,N):
        if M-nums[i]<0: break
        count += answer(M-nums[i],N,i+1,nums)
    return count

def main():
    T = int(sys.stdin.readline())
    for _ in range(T):
        M,N = map(int,sys.stdin.readline().split())
        nums = list(map(int,sys.stdin.readline().split()))
        nums.sort()
        print(answer(M,N,0,nums))
    
main()