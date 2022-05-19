import sys
import heapq
import math

def main():
    N = int(sys.stdin.readline())
    temp = [list(map(float,sys.stdin.readline().split())) for _ in range(N)]
    graph = dict()
    for i in range(N): graph[i] = []
    
    for i in range(len(temp)):
        for j in range(i+1,N):
            dist = math.sqrt((temp[i][0]-temp[j][0])**2+(temp[i][1]-temp[j][1])**2)
            graph[i].append((dist,j))
            graph[j].append((dist,i))
    
    stack = []
    visited = [False]*N
    answer = 0
    
    for i in graph[0]: heapq.heappush(stack,i)
    visited[0] = True
    
    while stack:
        weight, end = heapq.heappop(stack)
        if not visited[end]:
            visited[end] = True
            answer += weight
            for i in graph[end]:
                if not visited[i[1]]: heapq.heappush(stack,i)        
    print(f"{answer:.2f}")
        
main()