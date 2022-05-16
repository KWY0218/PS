import sys

def bestsum(m,nums,memo):
    if m<0: return None
    if m==0: return []
    if m in memo: return memo[m]
    best = None
    for x in nums:
        curr = bestsum(m-x,nums,memo)
        if curr is not None:
            if best == None or len(best)>len(curr)+1:
                next = curr[:]
                next.append(x)
                best = next
    memo[m] = best
    return best

def solve(m,nums):
    memo = {}
    return bestsum(m,nums,memo)

def main():
    T = int(sys.stdin.readline())
    for _ in range(T):
        m, n = map(int,sys.stdin.readline().split())
        nums = list(map(int,sys.stdin.readline().split()))
        answer = solve(m,nums)
        print(-1) if answer is None else print(str(len(answer))+" "+" ".join(str(i) for i in answer))

main()