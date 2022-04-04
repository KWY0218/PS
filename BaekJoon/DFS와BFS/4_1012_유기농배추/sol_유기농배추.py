import sys

T = int(sys.stdin.readline())
move = [(-1,0),(0,1),(1,0),(0,-1)]
for _ in range(T):
    M, N, K = list(map(int,sys.stdin.readline().split()))
    site = [[0]*M for _ in range(N)]
    visited = [[False]*M for _ in range(N)]
    for _ in range(K):
        x,y = map(int,sys.stdin.readline().split())
        site[y][x] = 1
    
    count = 0
    for col in range(N):
        for row in range(M):
            if site[col][row] == 1 and not visited[col][row]:
                stack = [(col,row)]
                while stack:
                    y,x = stack.pop()
                    if not visited[y][x]:
                        visited[y][x] = True
                        for i in range(4):
                            dy = y+move[i][0]
                            dx = x+move[i][1]
                            if 0<=dx<M and 0<=dy<N and site[dy][dx] == 1: stack.append((dy,dx))
                count += 1
    print(count)