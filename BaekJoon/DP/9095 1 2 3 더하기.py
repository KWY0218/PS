import sys

T = int(sys.stdin.readline())
for _ in range(T):
    N = int(sys.stdin.readline())
    nums = [0]*12
    nums[1] = 1
    nums[2] = 2
    nums[3] = 4
    for i in range(4,N+1):
        nums[i] = nums[i-1]+ nums[i-2] + nums[i-3]
    print(nums[N])