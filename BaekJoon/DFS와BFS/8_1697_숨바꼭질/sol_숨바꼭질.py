import sys
from collections import deque

N, K = map(int,sys.stdin.readline().split())
visited = [False]*100001
stack = deque([(N,0)])

while stack:
    s, count = stack.popleft()
    if s==K: break
    visited[s] = True
    if s-1>-1 and not visited[s-1]: stack.append((s-1,count+1))
    if s+1<100001 and not visited[s+1]: stack.append((s+1,count+1))
    if 2*s<100001 and not visited[2*s]: stack.append((2*s,count+1))
print(count)