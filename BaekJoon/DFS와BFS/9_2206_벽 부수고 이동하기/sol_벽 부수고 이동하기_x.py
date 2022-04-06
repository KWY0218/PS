import sys
from collections import deque

def solution(y,x,broken,visited,site):
    stack = deque([])
    stack.append((y,x,broken))
    visited[y][x][broken] = 1
    
    while stack:
        y,x,broken = stack.popleft()
        if y==(N-1) and x==(M-1): return visited[y][x][broken]
        for i in range(4):
            dy = y+move[i][0]
            dx = x+move[i][1]
            if 0<=dy<N and 0<=dx<M:
                if site[dy][dx] == 0 and visited[dy][dx][broken] == 0:
                    stack.append((y,x,broken))
                    visited[dy][dx][broken] = visited[y][x][broken] + 1
                elif site[dy][dx] == 1 and broken == 1:
                    stack.append((y,x,broken-1))
                    visited[dy][dx][broken-1] = visited[y][x][broken] + 1
    return -1

N, M = map(int,sys.stdin.readline().split())
site = [list(map(int,sys.stdin.readline().rstrip())) for _ in range(N)]
move = [(-1,0),(0,1),(1,0),(0,-1)]
visited = [[[0]*2 for _ in range(M)] for _ in range(N)]
print(visited)
print(solution(0,0,1,visited,site))
print(visited)