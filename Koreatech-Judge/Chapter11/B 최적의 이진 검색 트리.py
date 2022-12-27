import sys

def main():
    T = int(sys.stdin.readline())
    for _ in range(T):
        N = int(sys.stdin.readline())
        F = list(map(int,sys.stdin.readline().split()))
        table = [[0]*(N+2) for _ in range(N+2)]
        
        for i in range(N):
            for j in range(1,N-i+1):
                sum = 0
                temp = []
                for z in range(j,i+j+1):
                    sum += F[z-1]
                    temp.append(table[j][z-1]+table[z+1][j+i])
                table[j][j+i] = min(temp) + sum
        print(table[1][N])
main()