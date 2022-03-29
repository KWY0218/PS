import sys
N =int(sys.stdin.readline())
nums = list(map(int,sys.stdin.readline().split()))
count = dict()
index = 0
for i in sorted(nums):
    if i not in count.keys():
        count[i] = index
        index+=1
print(" ".join(str(count[i]) for i in nums))