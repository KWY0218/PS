import sys

'''
    문자열 쓸 때만 rstrip()
    int 형 split 할 땐 rstrip() 할 필요없음
'''
def howsum(m, nums):
    if m<0: return None
    if m == 0: return []
    for n in nums:
        sumList = howsum(m-n,nums)
        if sumList is not None:
            sumList.append(n)
            return sumList
    return None

T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    M, C = map(int,sys.stdin.readline().rstrip().split())
    N = list(map(int,sys.stdin.readline().rstrip().split()))
    answer = howsum(M,N)
    if answer is not None:
        print(len(answer), " ".join(str(i) for i in answer))
    else: print(-1)