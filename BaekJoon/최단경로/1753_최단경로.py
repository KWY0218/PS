import sys
import heapq

V, E = map(int, sys.stdin.readline().split())
K = int(sys.stdin.readline())
graph = dict()
heap, distance =[], [float('inf')]*V
for i in range(1,V+1): graph[i] = []
for _ in range(E):
    start, end, weight = map(int, sys.stdin.readline().split())
    graph[start].append([weight,end])

distance[K-1] = 0
heapq.heappush(heap,(distance[K-1],K))
while heap:
    dist, site = heapq.heappop(heap)
    if distance[site-1]<dist: continue
    for w, e in graph[site]:
        new_dist = w+dist
        if new_dist<distance[e-1]:
            distance[e-1] = new_dist
            heapq.heappush(heap, (distance[e-1],e))
for i in distance: 
    if i == float('inf'): print("INF") 
    else: print(i)