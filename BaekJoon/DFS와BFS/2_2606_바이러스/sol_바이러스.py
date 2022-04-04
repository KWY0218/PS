import sys
from collections import deque
 
T = int(sys.stdin.readline())
site = dict()
for i in range(1,T+1): site[i] = []
N = int(sys.stdin.readline())
for _ in range(N):
    x, y = map(int,sys.stdin.readline().split())
    site[x].append(y)
    site[y].append(x)
visited = [False]*T
stack = deque([])
stack.extend(site[1])
visited[0] = True
while stack:
    cur = stack.popleft()
    if not visited[cur-1]:
        stack.extend(site[cur])
        visited[cur-1] = True
print(sum(visited)-1)