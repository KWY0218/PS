import sys

def find(child,parent_list):
    if parent_list[child] != child:
        parent_list[child] = find(parent_list[child],parent_list)
    return parent_list[child]

def union(start,end,parent_list):
    start = find(start,parent_list)
    end = find(end,parent_list)
    if start<end:
        parent_list[end] = start
    else:
        parent_list[start] = end

def main():
    T = int(sys.stdin.readline())
    for _ in range(T):
        N, E = map(int,sys.stdin.readline().split())
        n = list(map(int,sys.stdin.readline().split()))
        
        graph = [(n[3*i+2],n[3*i],n[3*i+1]) for i in range(E)]
        parent_list = [i for i in range(N)]
        graph.sort()
        sum = 0
        for edge in graph:
            weight, start, end = edge
            if find(start,parent_list) != find(end,parent_list):
                union(start,end,parent_list)
                sum += weight 
        print(sum)
main()