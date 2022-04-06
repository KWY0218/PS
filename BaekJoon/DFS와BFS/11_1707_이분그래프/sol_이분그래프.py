import sys
from collections import deque

def solution(start):
    visited[start-1] = 0
    stack = deque([start])
    answer = True
    while stack and answer:
        curr = stack.popleft()
        color = visited[curr-1]
        for i in site[curr]:
            if visited[i-1]==-1:
                visited[i-1] = 1 if color == 0 else 0
                stack.append(i)
            elif (visited[i-1]==0 and color==0) or (visited[i-1]==1 and color==1):
                answer = False
                break
    return answer

T = int(sys.stdin.readline())
for _ in range(T):
    V, E= map(int,sys.stdin.readline().split())
    site = dict()
    visited = [-1]*V
    answer = True
    for i in range(1,V+1): site[i] = []
    for _ in range(E):
        start, end = map(int,sys.stdin.readline().split())
        site[start].append(end)
        site[end].append(start)
        
    again = True
    answer = True
    while again:
        again = False
        for j in range(V):
            if visited[j] == -1: 
                answer = solution(j+1)
                if not answer: 
                    again = False
                    break
                else: again = True
    print("YES") if answer else print("NO")
    
'''
    1. 독립된 그래프도 생각해야 한다.
    2. 2개의 독립된 그래프가 있을 때, 처음이 False 2번째가 True가 나올 수도 있으니 False가 나올 때 바로 break해야한다. (line 41)
'''