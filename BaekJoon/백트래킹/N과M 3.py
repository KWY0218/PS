import sys

def solve(temp, index, m,n):
    if index == m:
        print(" ".join(str(i) for i in temp))
        return

    for i in range(n):
        temp[index] = i+1
        solve(temp,index+1,m,n)

def main():
    N, M = map(int,sys.stdin.readline().split())
    temp = [0]*M
    solve(temp, 0,M,N)
    
main()