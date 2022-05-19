import sys

def main():
    T = int(sys.stdin.readline())
    for _ in range(T):
        N, M = map(int,sys.stdin.readline().split())
        graph = dict()
        for i in range(1,N+1): graph[i] = [] 
        for _ in range(M):
            a, b = map(int,sys.stdin.readline().split())
            graph[a].append(b)
            graph[b].append(a)
        visited = [False]*(N+1)
        stack = []
        answer = 0
        for i in range(1,N+1):
            stack.extend(graph[i])
            while stack:
                s = stack.pop()
                if not visited[s]:
                    visited[s] = True
                    answer += 1
        print(answer-1)
main()