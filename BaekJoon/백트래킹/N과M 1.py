import sys

def solve(temp, used, index, m,n):
    if index == m:
        print(" ".join(str(i) for i in temp))
        return

    for i in range(n):
        if not used[i]:
            temp[index] = i+1
            used[i] = True
            solve(temp,used,index+1,m,n)
            used[i] = False

def main():
    N, M = map(int,sys.stdin.readline().split())
    temp = [0]*M
    used = [False]*N
    solve(temp, used,0,M,N)
    
main()