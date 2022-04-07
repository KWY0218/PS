import sys
from collections import deque
import copy

T =int(sys.stdin.readline())
move = [(1,0),(0,1)]
for _ in range(T):
    M,N = map(int,sys.stdin.readline().split())
    graph = [list(map(int,sys.stdin.readline().split())) for _ in range(M)]
    visited = [[False]*N for _ in range(M)]
    copy_graph = copy.deepcopy(graph)
    stack = deque([(0,0)])
    
    while stack:
        y,x = stack.popleft()
        for i in range(2):
            dy = y+ move[i][0]
            dx = x+ move[i][1]
            if 0<=dy<M and 0<=dx<N and not visited[dy][dx]:
                visited[dy][dx] = True
                graph[dy][dx] += graph[y][x]
                stack.append((dy,dx))
            elif 0<=dy<M and 0<=dx<N and visited[dy][dx]:
                temp = copy_graph[dy][dx]+graph[y][x]
                if temp<graph[dy][dx]: graph[dy][dx] = temp
    print(graph[M-1][N-1])

'''
    복사 graph를 deepcopy 하기위해서 copy.deepcopy를 통해 복사했다.
    deepcopy를 하지 않으면 graph의 값이 변할 때 copy_graph의 값도 변하기 때문이다.
'''    