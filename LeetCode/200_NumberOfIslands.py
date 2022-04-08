from collections import deque

def numIslands(grid) -> int:
    move = [(0,-1),(-1,0),(1,0),(0,1)]
    col = len(grid)
    row = len(grid[0])
    visited = [[False]*row for _ in range(col)]
    stack = deque([])
    answer = 0
    
    for c in range(col):
        for r in range(row):
            if grid[c][r] == "1" and not visited[c][r]:
                answer += 1
                stack.append((c,r))
                while stack:
                    y,x = stack.popleft()
                    for i in range(4):
                        dy = y+move[i][0]
                        dx = x+move[i][1]
                        if 0<=dy<col and 0<=dx<row and grid[dy][dx]=="1" and not visited[dy][dx]:
                            stack.append((dy,dx))
                            visited[dy][dx] = True
    return answer

grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
print(numIslands(grid))