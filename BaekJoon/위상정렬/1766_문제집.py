import sys
import heapq

N, M = map(int,sys.stdin.readline().split())
graph = dict()
for i in range(1,N+1): graph[i] = []
indgree = [0]*(N+1)
stack = []
answer = []

for _ in range(M):
    A,B = map(int,sys.stdin.readline().split())
    graph[A].append(B)
    indgree[B] += 1

for i in range(1,N+1):
    if indgree[i]==0: heapq.heappush(stack,i)
    
while stack:
    s = heapq.heappop(stack)
    answer.append(s)
    for i in graph[s]:
        indgree[i] -= 1
        if indgree[i]==0: heapq.heappush(stack,i)
        
print(" ".join(str(i) for i in answer))