import sys
import heapq

T = int(sys.stdin.readline())
for _ in range(T):
    N, E = map(int,sys.stdin.readline().split())
    n = list(map(int,sys.stdin.readline().split()))
    graph = dict()
    for i in range(N): graph[i] = []
    for i in range(E):
        graph[n[3*i]].append([n[3*i+2],n[3*i+1]])
        graph[n[3*i+1]].append([n[3*i+2],n[3*i]])
        
    minheap = []
    visited = [False]*N
    
    for i in graph[0]: heapq.heappush(minheap,i)
    visited[0] = True
    sum = 0
    
    while minheap:
        currNode = heapq.heappop(minheap)
        if not visited[currNode[1]]:
            visited[currNode[1]] = True
            sum += currNode[0]
            for i in graph[currNode[1]]: heapq.heappush(minheap,i)

    print(sum)