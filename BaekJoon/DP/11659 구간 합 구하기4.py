import sys

# [i:j] = sum[:j] - sum[:i]

N,M = map(int,sys.stdin.readline().split())
nums = list(map(int,sys.stdin.readline().split()))
D = [0]*(N+1)
for i in range(1,N+1): D[i] = D[i-1]+nums[i-1]
for _ in range(M):
    i, j = map(int,sys.stdin.readline().split())
    print(D[j] - D[i-1])