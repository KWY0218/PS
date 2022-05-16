import sys

def solve(N,W,weight):
    w = [[0]*(W+1) for _ in range(N+1)]
    for i in range(1,N+1):
        for x in range(1,W+1):
            if weight[i-1][0] > x:
                w[i][x] = w[i-1][x]
            else:
                w[i][x] = max(weight[i-1][1]+w[i-1][x-weight[i-1][0]],w[i-1][x])
    return w[N][W]
    
def main():
    T = int(sys.stdin.readline())
    for _ in range(T):
        W, N = map(int,sys.stdin.readline().split())
        nums = list(map(int,sys.stdin.readline().split()))
        weight = [(nums[2*i+1],nums[2*i]) for i in range(N)]
        print(solve(N,W,weight))
main()