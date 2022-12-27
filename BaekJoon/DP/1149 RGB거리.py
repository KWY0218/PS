import sys

T = int(sys.stdin.readline())
R, G, B = [], [], []
for _ in range(T):
    r, g, b = list(map(int,sys.stdin.readline().split()))
    R.append(r)
    G.append(g)
    B.append(b)

nums = [[0]*T for _ in range(3)]
nums[0][0] = R[0]
nums[1][0] = G[0]
nums[2][0] = B[0]

for i in range(1,T):
    nums[0][i] = min(nums[1][i-1],nums[2][i-1])+R[i]
    nums[1][i] = min(nums[0][i-1],nums[2][i-1])+G[i]
    nums[2][i] = min(nums[0][i-1],nums[1][i-1])+B[i]

print(min(nums[0][T-1],nums[1][T-1],nums[2][T-1]))