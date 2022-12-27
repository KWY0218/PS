import sys

def main():
    T = int(sys.stdin.readline())
    for _ in range(T):
        M, G, X, Y = sys.stdin.readline().rstrip().split()
        M, G = int(M), int(G)
        
        table = [[0]*(len(Y)+1) for _ in range(len(X)+1)]
        
        for i in range(len(X)+1): table[i][0] = i*M
        for i in range(1,len(Y)+1): table[0][i] = i*M
        
        for i in range(1,1+len(X)):
            for j in range(1,1+len(Y)):
                temp = 0
                if X[i-1] != Y[j-1]:
                    temp = G
                table[i][j] = min(table[i-1][j-1] + temp, table[i-1][j]+M,table[i][j-1]+M)
        print(table[len(X)][len(Y)])

main()