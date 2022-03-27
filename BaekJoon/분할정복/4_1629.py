import sys

def solution(A,B,C):
    if B==0: return 1
    if B==1: return A
    if B%2==0:
        temp = (solution(A,B//2,C)**2)%C
    else:
        temp = ((solution(A,B//2,C)**2)*solution(A,1,C))%C
    return temp

A,B,C = list(map(int,sys.stdin.readline().split()))
remain = A%C
print(14*14%12)