import sys
import heapq

def solution(start):
    distance = [float('inf')]*N
    distance[start-1] = 0
    heap = []
    heapq.heappush(heap,(distance[start-1],start))
    
    while heap:
        weight, site = heapq.heappop(heap)
        if distance[site-1]<weight: continue
        for w,s in graph[site]:
            new_dist = weight+w
            if new_dist<distance[s-1]:
                distance[s-1] = new_dist
                heapq.heappush(heap,(distance[s-1],s))
    return distance

N = int(sys.stdin.readline())
M = int(sys.stdin.readline())
graph = dict()
for i in range(1,N+1): graph[i] = []
for _ in range(M):
    A, B, C = map(int,sys.stdin.readline().split())
    graph[A].append((C,B))
for i in range(1,N+1):
    print(" ".join(str(j) if j != float('inf') else str(0) for j in solution(i)))