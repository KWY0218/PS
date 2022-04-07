import sys
from collections import deque

T = int(sys.stdin.readline())
for _ in range(T):
    N, E = map(int,sys.stdin.readline().split())
    site_list = list(map(int,sys.stdin.readline().split()))
    
    site = dict()
    for i in range(N): site[i] = []
    for i in range(E):
        site[site_list[2*i]].append(site_list[2*i+1])
        site[site_list[2*i+1]].append(site_list[2*i])
    visited = [False]*N
    max_count = 0
    node_count = 0
    
    for i in range(N):
        if not visited[i]:
            node_count += 1
            temp_count = 1
            stack = deque([])
            stack.extend(site[i])
            visited[i] = True
            while stack:
                s = stack.popleft()
                if not visited[s]:
                    visited[s] = True
                    stack.extend(site[s])
                    temp_count += 1
        if max_count<temp_count: max_count = temp_count
    print(f"{node_count} {max_count}")