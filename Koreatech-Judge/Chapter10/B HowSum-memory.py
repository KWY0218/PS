import sys

def howsum(m,nums,memo):
    if m<0: return None
    if m==0: return []
    if m in memo: return memo[m]
    for x in nums:
        curr = howsum(m-x,nums,memo)
        if curr is not None:
            memo[m] = curr[:]
            memo[m].append(x)
            return memo[m]
    memo[m] = None
    return None

def solve(m,nums):
    memo = {}
    return howsum(m,nums,memo)

def main():
    T = int(sys.stdin.readline())
    for _ in range(T):
        m, n = map(int,sys.stdin.readline().split())
        nums = list(map(int,sys.stdin.readline().split()))
        answer = solve(m,nums)
        print(-1) if answer is None else print(str(len(answer))+" "+" ".join(str(i) for i in answer))

main()