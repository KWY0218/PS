import sys

N = int(sys.stdin.readline())
nums = [int(sys.stdin.readline()) for _ in range(N)]
if N==1: print(nums[0])
else:
    D = [[0,0] for _ in range(N+1)]
    D[1][0], D[1][1], D[2][0], D[2][1] = nums[0], 0, nums[1], nums[0]+nums[1]
    for i in range(3,N+1):
        D[i][1] = D[i-1][0]+nums[i-1]
        D[i][0] = max(D[i-2][0],D[i-2][1])+nums[i-1]
    print(max(D[N][0],D[N][1]))