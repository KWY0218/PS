import sys

def cansum(m,nums):
    if m<0: return False
    if m==0: return True
    for n in nums:
        if cansum(m-n,nums): return True
    return False

T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    M, C = map(int,sys.stdin.readline().rstrip().split())
    N = list(map(int,sys.stdin.readline().rstrip().split()))
    print("true") if cansum(M,N) else print("false")