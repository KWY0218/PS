import sys
from collections import deque

N, M = map(int,sys.stdin.readline().split())
graph = dict()
for i in range(1,N+1): graph[i] = []

inDegree = [0]*(N+1)
stack = deque([])
answer = []

for _ in range(M):
    A,B = map(int,sys.stdin.readline().split())
    graph[A].append(B)
    inDegree[B] += 1

for i in range(1,N+1):
    if inDegree[i] == 0: stack.append(i)

while stack:
    s = stack.popleft()
    answer.append(s)
    for i in graph[s]:
        inDegree[i] -= 1
        if inDegree[i] == 0: stack.append(i)

print(" ".join(str(i) for i in answer))