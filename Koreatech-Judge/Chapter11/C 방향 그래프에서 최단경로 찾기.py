import sys

def main():
    N, E = map(int,sys.stdin.readline().split())
    node = list(map(int,sys.stdin.readline().split()))
    graph = []
    for i in range(N):
        graph.append([float('inf')]*N)
        graph[i][i] = 0
    for i in range(E): graph[node[3*i]][node[3*i+1]] = node[3*i+2]
    
    for k in range(N):
        for i in range(N):
            for j in range(N):
                graph[i][j] = min(graph[i][j],graph[i][k]+graph[k][j])
    result = (-1,-1,float('-inf'))
    
    for i in range(N):
        if graph[i][i]<0: return -1
        else: 
            temp = [float('-inf') if graph[i][j]==float('inf') else graph[i][j] for j in range(N)]
            m = max(temp)
            if result[2]<m:
                result = (i,temp.index(m),m)
    return result            

T = int(sys.stdin.readline())
for _ in range(T):
    temp = main()
    if temp == -1: print(-1)
    else: print(temp[0],temp[1],temp[2])