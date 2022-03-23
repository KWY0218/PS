import sys

def solution(col_start,col_end,row_start,row_end,answer,size):
    if size == 1:
        answer[papers[col_start][row_start]]+=1
        return

    paper = 0
    for col in range(col_start,col_end+1):
        for row in range(row_start,row_end+1):
            paper += papers[col][row]
    
    if paper == 0: 
        answer[0] += 1
        return
    elif paper == size*size:
        answer[1] += 1
        return
    
    col_mid = (col_start+col_end)//2
    row_mid = (row_start+row_end)//2
    
    solution(col_start,col_mid,row_start,row_mid,answer,size//2)
    solution(col_start,col_mid,row_mid+1,row_end,answer,size//2)
    solution(col_mid+1,col_end,row_start,row_mid,answer,size//2)
    solution(col_mid+1,col_end,row_mid+1,row_end,answer,size//2)
        
N = int(sys.stdin.readline())
papers = [list(map(int,sys.stdin.readline().split())) for _ in range(N)]
answer = [0,0]
solution(0,N-1,0,N-1,answer,N)
[print(i) for i in answer]