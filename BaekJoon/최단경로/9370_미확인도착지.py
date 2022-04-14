import sys
import heapq

def solution(start):
    heap = []
    distance = [float('inf')]*n
    distance[start-1] = 0
    heapq.heappush(heap,[distance[start-1],start])
    
    while heap:
        dist, site = heapq.heappop(heap)
        if distance[site-1]<dist: continue
        for weight, edge in graph[site]:
            new_dist = weight + dist
            if new_dist<distance[edge-1]: 
                distance[edge-1] = new_dist
                heapq.heappush(heap,[distance[edge-1],edge])
    
    return distance

T = int(sys.stdin.readline())
for _ in range(T):
    n, m, t = map(int,sys.stdin.readline().split())
    s, g, h = map(int,sys.stdin.readline().split())
    graph = dict()
    dest = []
    for i in range(1,n+1): graph[i] = []
    for _ in range(m):
        a, b, d = map(int,sys.stdin.readline().split())
        graph[a].append([d,b])
        graph[b].append([d,a])
    for _ in range(t): dest.append(int(sys.stdin.readline()))
    
    start_dist = solution(s)
    g_dist = solution(g)
    h_dist = solution(h)
    
    answer = []
    for i in dest:
        com = min(start_dist[g-1]+g_dist[h-1]+h_dist[i-1], start_dist[h-1]+h_dist[g-1]+g_dist[i-1])
        if start_dist[i-1] ==  com:
            if start_dist[i-1] != float('inf'): answer.append(i)
    answer.sort()
    print(" ".join(str(i) for i in answer))
    
    '''
        start 지점에서 도착지 까지의 최소 거리와
        start -> g -> h -> 도착지 또는 start -> h -> g -> 도착지의
        거리가 같다면 출력하는 것이다.
        
        주의할 점은 도착지까지의 거리가 inf이고, 비교 거리의 값이 inf여도 inf가 출력되므로
        inf가 나올 때를 따로 구분하면서 answer에 append 해야 한다.
        
    '''