import sys
import heapq

V,E = map(int,sys.stdin.readline().split())
graph = dict()
for i in range(1,V+1): graph[i] = []
for _ in range(E):
    A, B, C = map(int,sys.stdin.readline().split())
    graph[A].append((C,B))