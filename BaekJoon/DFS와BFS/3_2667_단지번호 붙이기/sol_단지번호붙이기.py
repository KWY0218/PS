import sys

N = int(sys.stdin.readline())
visited = [[False]*N for _ in range(N)]
site = [list(map(int,sys.stdin.readline().rstrip())) for _ in range(N)]
move = [(-1,0),(0,1),(1,0),(0,-1)]
answer = []
for col in range(N):
    for row in range(N):
        if site[col][row] == 1 and not visited[col][row]:
            count = 0
            stack = [(col,row)]
            while stack:
                y, x = stack.pop()
                if not visited[y][x]:
                    visited[y][x] = True
                    count += 1
                    for i in range(4):
                        dy = y+move[i][0]
                        dx = x+move[i][1]
                        if 0<=dy<N and 0<=dx<N and site[dy][dx] == 1: stack.append((dy,dx))
            answer.append(count)
print(len(answer))
for i in sorted(answer):print(i)