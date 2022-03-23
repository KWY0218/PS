import sys

def solution(game_list,blocks):
    dx, dy = -1,-1
    for col in range(H):
        for row in range(W):
            if game_list[col][row] == ".":
                dx = row
                dy = col
                break
        if dy != -1: break
    
    if dy == -1 and dx == -1: return 1
    
    count = 0
    
    for block in blocks:
        check = True
        for b in block:
            site_x = dx+b[0]
            site_y = dy+b[1]
            if site_x<0 or site_x>=W or site_y<0 or site_y>=H:
                check = False
                break
            elif game_list[site_y][site_x] == "#":
                check = False
                break
                    
        if check:
            for b in block:
                site_x = dx+b[0]
                site_y = dy+b[1]
                game_list[site_y][site_x] = "#"
            count += solution(game_list,blocks)      
            for b in block:
                site_x = dx+b[0]
                site_y = dy+b[1]
                game_list[site_y][site_x] = "."
    return count   

T = int(sys.stdin.readline())
for _ in range(T):
    H, W = map(int,sys.stdin.readline().split())
    game_list = [list(sys.stdin.readline().rstrip()) for _ in range(H)]
    empty_count = sum([i.count(".") for i in game_list])
    if empty_count%3==0:
        blocks = [[(0,0),(1,0),(1,1)],[(0,0),(0,1),(1,1)],[(0,0),(0,1),(1,0)],[(0,0),(0,1),(-1,1)]]
        print(solution(game_list,blocks))
    else:
        print(0)