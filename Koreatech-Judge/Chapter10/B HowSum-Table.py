import sys

def solve(m,nums):
    table = [None]*(m+1)
    table[0] = []
    for i in range(m):
        if table[i] is not None:
            for n in nums:
                if i+n<=m and table[i+n] is None:
                    table[i+n] = table[i][:]
                    table[i+n].append(n)
        if table[m] is not None: break
    return table[m]

def main():
    T = int(sys.stdin.readline())
    for _ in range(T):
        m, n = map(int,sys.stdin.readline().split())
        nums = list(map(int,sys.stdin.readline().split()))
        answer = solve(m,nums)
        if answer is None: print(-1)
        else: print(len(answer), ' '.join(str(i) for i in answer))

main()