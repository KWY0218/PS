import sys

T = int(sys.stdin.readline())
nums = dict()
for _ in range(T):
    n = int(sys.stdin.readline())
    if n in nums.keys(): nums[n] += 1
    else: nums[n] = 1

for i in sorted(nums.keys()):
    for _ in range(nums[i]):
        print(i)