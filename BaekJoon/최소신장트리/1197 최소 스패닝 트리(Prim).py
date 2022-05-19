import sys
import heapq

def main():
    V, E = map(int,sys.stdin.readline().split())
    graph = dict()
    for i in range(1,V+1): graph[i] = []
    
    for _ in range(E):
        A, B, C = list(map(int,sys.stdin.readline().split()))
        graph[A].append((C,B))
        graph[B].append((C,A))
    
    visited = [False]*(V+1)
    answer = 0
    stack = []
    for i in graph[1]: heapq.heappush(stack,i)
    visited[1] = True
    while stack:
        weight, end = heapq.heappop(stack)
        if not visited[end]:
            visited[end] = True
            answer += weight
            for i in graph[end]: 
                if not visited[i[1]]: heapq.heappush(stack,i)
    print(answer)

main()