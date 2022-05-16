import sys

def cansum(m,nums):
    table = [False]*(m+1)
    table[0] = True
    for i in range(m):
        if table[i]:
            for n in nums:
                if i+n<=m: table[i+n] = True
    return table[m]

def main():
    T = int(sys.stdin.readline())
    for _ in range(T):
        m, n = map(int,sys.stdin.readline().split())
        nums = list(map(int,sys.stdin.readline().split()))
        answer = cansum(m,nums)
        print("true") if answer else print("false")

main()