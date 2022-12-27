import queue
import sys

class Node:
    def __init__(self,bound ,path):
        self.bound= bound
        self.path = path
        
def TSP():
    global minLength
    path=[start]
    v = Node(0,path)

    v.bound = compBound(v)
    q = queue.PriorityQueue()
    q.put((v.bound,v.path))
    while not q.empty():
        v.bound, v.path= q.get()
        if(v.bound < minLength):
            if len(v.path)==n-1:
                A = v.path[:]
                B = [x for x in V if x not in A]
                C=[x for x in B if x !=start]
                if compLength(v.path)+W[v.path[n-2]][C[0]]+W[C[0]][start] < minLength:
                    minLength = compLength(v.path)+W[v.path[n-2]][C[0]]+W[C[0]][start]
            else:
                C=[ x for x in V if x not in v.path]
                for x in C:
                    u = Node(0,v.path+[x]) 
                    u.bound = compBound(u)
                    if u.bound < minLength:
                        q.put((u.bound,u.path))

def compBound(u):
    global start
    tbound = 0
    A = u.path[:]
    B = [x for x in A if x != start]
    C= [x for x in V if x not in A]
    tMin=10000
    for y in C:
        if W[u.path [ len(u.path)-1]][y]>0 and W[u.path [ len(u.path)-1]][y] < tMin:
            tMin = W[u.path [ len(u.path)-1]][y]
    tbound += tMin
    for y in C:
        tMin = 10000
        D = [ x for x in C if x != y]
        D.append(start)
        for z in D:
            if W[y][z]>0 and W[y][z]<tMin:
                tMin=W[y][z]
        tbound += tMin
    return tbound+compLength(u.path)

def compLength(a):
    length =0
    for x in range (0,len(a)-1):
        length += W[a[x]][a[x+1]]
    return length


T = int(sys.stdin.readline())
for _ in range(T):
    n = int(sys.stdin.readline())
    W = [list(map(int,sys.stdin.readline().split())) for _ in range(n)]
    start =0
    V = [i for i in range(n)]
    minLength=10000
    TSP()
    print(minLength)