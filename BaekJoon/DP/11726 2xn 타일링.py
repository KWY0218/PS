import sys

N = int(sys.stdin.readline())
nums = [0]*1001
nums[1] = 1
nums[2] = 2

for i in range(3,N+1): nums[i] = (nums[i-1]+nums[i-2])%10007
print(nums[N])