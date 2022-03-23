import sys

def countsum(m,nums):
    if m<0: return 0
    if m==0: return 1
    count = 0
    for n in nums:
        count += countsum(m-n,nums)
    return count

T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    M, C = map(int,sys.stdin.readline().rstrip().split())
    N = list(map(int,sys.stdin.readline().rstrip().split()))
    print(countsum(M,N))