import sys
from collections import deque

def solution():
    move = [(-1,0),(0,1),(1,0),(0,-1)]

    stack = deque([(0,0,0)])
    visited[0][0][0] = 1
    while stack:
        y,x,broken = stack.popleft()
        if y == (N-1) and x == (M-1):
            return visited[N-1][M-1][broken]
        for i in range(4):
            dy = y+move[i][0]
            dx = x+move[i][1]
            
            if 0<=dy<N and 0<=dx<M:
                if graph[dy][dx] == 0 and visited[dy][dx][broken] == 0:
                    visited[dy][dx][broken] = visited[y][x][broken]+1
                    stack.append((dy,dx,broken))
                elif graph[dy][dx] == 1 and broken ==0:
                    visited[dy][dx][broken+1] = visited[y][x][broken]+1
                    stack.append((dy,dx,broken+1))
    return -1

N,M = map(int,sys.stdin.readline().split())
graph = [list(map(int,sys.stdin.readline().rstrip())) for _ in range(N)]
visited = [[[0]*2 for _ in range(M)] for _ in range(N)]
print(solution())

'''
    함수로 만들어서 틀리면 -1을 반환해줘야 함
'''