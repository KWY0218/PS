import sys


import sys

def countsum(m,nums,memo):
    if m<0: return 0
    if m==0: return 1
    if m in memo: return memo[m]
    count = 0
    for n in nums:
        count+=countsum(m-n,nums,memo)
    memo[m]=count
    return count

def solve(m,nums):
    memo = {}
    return countsum(m,nums,memo)

def main():
    T = int(sys.stdin.readline())
    for _ in range(T):
        m, n = map(int,sys.stdin.readline().split())
        nums = list(map(int,sys.stdin.readline().split()))
        print(solve(m,nums))
main()