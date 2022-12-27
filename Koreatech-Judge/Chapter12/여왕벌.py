import sys

def promising(n,row):
    for i in range(n):
        if row[n] == row[i] or abs(row[n]-row[i]) == abs(n-i):
            return False
    return True

def solution(n,N,row):
    if n == N:
        print(row)
        for r in row:
            print(r)
            print(('X'*r+'Q'+'X'*(N-r-1)).strip('\n'))
        return
    else:
        for i in range(N):
            row[n] = i
            if promising(n,row): solution(n+1,N,row)

def main():
    T = int(sys.stdin.readline())
    for _ in range(T):
        N = int(sys.stdin.readline())
        if N==2 or N ==3:print()
        else:
            row = [0]*N
            solution(0,N,row)
main()