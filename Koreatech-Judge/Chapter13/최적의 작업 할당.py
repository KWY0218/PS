import sys

def getBound(nums,start,curr_bound):
    bound = curr_bound
    for row in nums:
        min_value = float('inf')
        for r in range(len(nums)):
            if r != start and min_value>row[r]: min_value = row[r]
        bound += min_value
    return bound

T = int(sys.stdin.readline())
for _ in range(T):
    N = int(sys.stdin.readline())
    nums = [list(map(int,sys.stdin.readline().split())) for _ in range(N)]
    print(getBound(nums,0,0))