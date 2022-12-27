import sys
import heapq

N, M = map(int,sys.stdin.readline().split())
graph, distance, heap = dict(), [float('inf')]*N, []
for i in range(1,N+1): graph[i]=[]
for _ in range(M):
    A,B,C = map(int,sys.stdin.readline().split())
    graph[A].append((C,B))
distance[0] = 0
heapq.heappush(heap,(distance[0],1))

while heap:
    dist, site = heapq.heappop(heap)
    
    for weight, edge in graph[site]:
        new_dist = dist+weight
        if new_dist<distance[edge-1]:
            distance[edge-1] = new_dist
            heapq.heappush(heap,(distance[edge-1],edge))
print(distance)