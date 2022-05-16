import sys

def cansum(m,nums,memo):
    if m<0: return False
    if m==0: return True
    if m in memo: return memo[m]
    for x in nums:
        if cansum(m-x,nums,memo):
            memo[m] = True
            return memo[m]
    memo[m] = False
    return False

def solve(m,nums):
    memo = {}
    return cansum(m,nums,memo)

def main():
    T = int(sys.stdin.readline())
    for _ in range(T):
        m, n = map(int,sys.stdin.readline().split())
        nums = list(map(int,sys.stdin.readline().split()))
        answer = solve(m,nums)
        print("true") if answer else print("false")

main()