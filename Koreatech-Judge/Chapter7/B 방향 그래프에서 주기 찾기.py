import sys

T = int(sys.stdin.readline())
for _ in range(T):
    N, E = map(int,sys.stdin.readline().split())
    site_list = list(map(int,sys.stdin.readline().split()))
    
    site = dict()
    for i in range(N): site[i] = []
    for i in range(E):
        site[site_list[2*i]].append(site_list[2*i+1])
    
    for i in range(N):
        visited = [False]*N
        stack = []
        stack.extend(site[i])
        answer = False
        print(site)
        while stack:
            start = stack.pop()
            if i == start: 
                answer = True
                break
            if not visited[start]:
                visited[start] = True
                stack.extend(site[start])
        if answer: break
    print("true") if answer else print("false")
    
'''
    방향 그래프이기 때문에 0->2->3->2 는 안되지만, 2->3->2는 되기 때문에 매번 visited를 초기화한다.
'''