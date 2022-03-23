import sys

def solution(col_start,col_end,row_start,row_end,size):
    if col_end-col_start == 1:
        answer[papers[col_start][row_start]] += 1
        return
    
    check = True
    target = papers[col_start][row_start]
    for col in range(col_start,col_end):
        for row in range(row_start,row_end):
            if target != papers[col][row]:
                check = False
                break
        if not check: break
        
    if check:
        answer[target] += 1
        return
    
    col_d1 = col_start + size//3
    col_d2 = col_d1 + size//3
    row_d1 = row_start + size//3
    row_d2 = row_d1 + size//3
    
    solution(col_start,col_d1,row_start,row_d1,size//3)
    solution(col_start,col_d1,row_d1,row_d2,size//3)
    solution(col_start,col_d1,row_d2,row_end,size//3)
    solution(col_d1,col_d2,row_start,row_d1,size//3)
    solution(col_d1,col_d2,row_d1,row_d2,size//3)
    solution(col_d1,col_d2,row_d2,row_end,size//3)
    solution(col_d2,col_end,row_start,row_d1,size//3)
    solution(col_d2,col_end,row_d1,row_d2,size//3)
    solution(col_d2,col_end,row_d2,row_end,size//3)
    return    

N = int(sys.stdin.readline())
papers = [list(map(int,sys.stdin.readline().split())) for _ in range(N)]
answer = {-1:0,0:0,1:0}
solution(0,N,0,N,N)
[print(i) for i in answer.values()]