import sys
from collections import deque
T = int(sys.stdin.readline())
move = [(-2,-1),(-2,1),(-1,2),(1,2),(2,1),(2,-1),(1,-2),(-1,-2)]
for _ in range(T):
    I = int(sys.stdin.readline())
    x,y = map(int,sys.stdin.readline().split())
    end_x,end_y = map(int,sys.stdin.readline().split())
    visited = [[False]*I for _ in range(I)]
    
    stack = deque([(y,x,0)])
    while stack:
        y,x,count = stack.popleft()
        if x==end_x and y==end_y: break
        for i in range(8):
            dy = y+move[i][0]
            dx = x+move[i][1]
            if 0<=dy<I and 0<=dx<I and not visited[dy][dx]: 
                stack.append((dy,dx,count+1))
                visited[dy][dx] = True
    print(count)
    
'''
    18-20 line 에서 visited를 True를 해줘야 stack의 크기가 줄어든다.
'''