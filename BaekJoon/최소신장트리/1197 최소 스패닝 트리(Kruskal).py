import sys

def find(child, parent_list):
    if child != parent_list[child]:
        parent_list[child] = find(parent_list[child],parent_list)
    return parent_list[child]

def union(start, end, parent_list):
    start_p = find(start, parent_list)
    end_p = find(end, parent_list)
    
    if start_p>end_p:
        parent_list[start_p] = end_p
    else:
        parent_list[end_p] = start_p

def main():
    V, E = map(int,sys.stdin.readline().split())
    stack = [list(map(int,sys.stdin.readline().split())) for _ in range(E)]
    parent_list = [i for i in range(V+1)]
    stack.sort(key= lambda x: x[2],reverse=True)
    answer = 0
    
    while stack:
        start, end, weight = stack.pop()
        if find(start,parent_list) != find(end,parent_list):
            answer += weight
            union(start,end,parent_list)
    print(answer)
main()