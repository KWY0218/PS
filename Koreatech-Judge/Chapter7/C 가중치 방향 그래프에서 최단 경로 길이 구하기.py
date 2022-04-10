import sys
import heapq

T = int(sys.stdin.readline())
for _ in range(T):
    input = list(map(int,sys.stdin.readline().split()))
    input_node = list(map(int,sys.stdin.readline().split()))
    N, E, S, K, D = input[0], input[1], input[2], input[3], input[4:]
    graph = dict()
    minheap, distance = [], [float('inf')]*N
    
    for i in range(N): graph[i] = []
    for i in range(E): graph[input_node[3*i]].append([input_node[3*i+2],input_node[3*i+1]])
    distance[S] = 0
    heapq.heappush(minheap,(distance[S],S))
    while minheap:
        dist, site = heapq.heappop(minheap)
        if distance[site] < dist: continue
        for d, s in graph[site]:
            new_distance = dist+d
            if new_distance<distance[s]:
                distance[s] = new_distance
                heapq.heappush(minheap,(distance[s],s))
    
    print(" ".join(str(distance[D[i]]) if distance[D[i]]!=float('inf') else str(-1) for i in range(K)))