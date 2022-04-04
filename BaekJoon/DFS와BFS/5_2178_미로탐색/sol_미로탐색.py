import sys
from collections import deque

N, M = map(int,sys.stdin.readline().split())
site = [list(map(int,sys.stdin.readline().rstrip())) for _ in range(N)]
stack = deque([(0,0)])
move = [(-1,0),(0,1),(1,0),(0,-1)]
while stack:
    y,x = stack.popleft()
    for i in range(4):
        dy = y+move[i][0]
        dx = x+move[i][1]
        if 0<=dy<N and 0<=dx<M and site[dy][dx] == 1:
            stack.append((dy,dx))
            site[dy][dx] += site[y][x]
print(site[N-1][M-1])