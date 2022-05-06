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
        N = int(sys.stdin.readline())
        n = list(map(int,sys.stdin.readline().split()))
        nums = [(n[2*i],n[2*i+1]) for i in range(N)]
        parent_list = [i for i in range(N+1)]
        count = 1
        answer = []

        for start_edge,end_edge in nums:
            if find(start_edge,parent_list) != find(end_edge,parent_list):
                union(start_edge,end_edge,parent_list)
                count += 1
            else:
                print(f"{start_edge} {end_edge}")
                break
main()