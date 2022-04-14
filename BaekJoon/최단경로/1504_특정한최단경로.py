import sys
import heapq

def solution(start):
    distance = [float('inf')]*N
    distance[start-1] = 0
    heap = []
    heapq.heappush(heap,(distance[start-1],start))
    
    while heap:
        dist, site = heapq.heappop(heap)
        if distance[site-1]<dist: continue
        for weight,edge in graph[site]:
            new_dist = dist+weight
            if new_dist<distance[edge-1]:
                distance[edge-1] = new_dist
                heapq.heappush(heap,(distance[edge-1],edge))
    
    return distance

N,E = map(int,sys.stdin.readline().split())
graph = dict()
for i in range(1,N+1): graph[i] = []
for _ in range(E):
    a,b,c = map(int,sys.stdin.readline().split())
    graph[a].append((c,b))
    graph[b].append((c,a))
v1,v2 = map(int,sys.stdin.readline().split())

start_dist = solution(1)
v1_dist = solution(v1)
v2_dist = solution(v2)

result = min(start_dist[v1-1]+v1_dist[v2-1]+v2_dist[N-1],start_dist[v2-1]+v2_dist[v1-1]+v1_dist[N-1])

print(result) if result<float('inf') else print(-1)

'''
    1 -> v1 -> v2 -> N 또는 1 -> v2 -> v1 -> N
    이 두가지 경로 중 하나이므로
    [start 시작] start_dist에서 v1 까지 가는 최단경로 + [v1 시작] v1_dist에서 v2 까지 가는 최단경로 + [v2시작] v2_dist에서 N 까지 가는 최단경로,
    [start 시작] start_dist에서 v2 까지 가는 최단경로 + [v2 시작] v2_dist에서 v1 까지 가는 최단경로 + [v1시작] v1_dist에서 N 까지 가는 최단경로
    위 2개 중 최소값이 정답이다.
    inf에다가 어떤수를 더해도 오버플로우가 생기지 않고, inf가 출력된다.(ex float('inf') + 2000 = inf ) 
    그래서 결과 값이 inf이면 -1을 아니라면 result 값을 출력한다.
'''