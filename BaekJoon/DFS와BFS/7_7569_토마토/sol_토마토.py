import sys
from collections import deque

M, N, H = list(map(int,sys.stdin.readline().split()))
site = [[list(map(int,sys.stdin.readline().split())) for _ in range(N)] for _ in range(H)]
move = [(-1,0,0),(1,0,0),(0,-1,0),(0,0,1),(0,1,0),(0,0,-1)]
stack = deque([])

for h in range(H):
    for c in range(N):
        for r in range(M):
            if site[h][c][r] == 1: stack.append((h,c,r))

while stack:
    z, y, x = stack.popleft()
    for i in range(6):
        dz = z+move[i][0]
        dy = y+move[i][1]
        dx = x+move[i][2]
        if 0<=dz<H and 0<=dy<N and 0<=dx<M and site[dz][dy][dx] == 0:
            site[dz][dy][dx] = site[z][y][x]+1
            stack.append((dz,dy,dx))

answer = True

for h in range(H):
    for c in range(N):
        for r in range(M):
            if site[h][c][r] == 0:
                answer = False
                break
        if not answer: break
    if not answer: break

print(max([max([max(j) for j in i]) for i in site])-1) if answer else print(-1)
