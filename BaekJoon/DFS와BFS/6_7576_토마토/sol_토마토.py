import sys
from collections import deque

M, N = map(int,sys.stdin.readline().split())
site = [list(map(int,sys.stdin.readline().split())) for _ in range(N)]
move = [(-1,0),(0,1),(1,0),(0,-1)]
stack = deque([])
for col in range(N):
    for row in range(M):
        if site[col][row] == 1: stack.append((col,row))

while stack:
    y,x = stack.popleft()
    for i in range(4):
        dy = y+move[i][0]
        dx = x+move[i][1]
        if 0<=dy<N and 0<=dx<M and site[dy][dx] == 0:
            site[dy][dx] = site[y][x]+1
            stack.append((dy,dx))

answer = True

for col in site:
    for row in col:
        if row == 0: 
            answer = False
            break
    if not answer: break

print(max([max(i) for i in site])-1) if answer else print(-1)