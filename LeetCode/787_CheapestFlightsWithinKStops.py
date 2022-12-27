from dis import dis
import heapq

class Solution:
    def findCheapestPrice(self, n: int, flights: list[list[int]], src: int, dst: int, k: int) -> int:
        graph = dict()
        for i in range(n): graph[i] = []
        for a,b,c in flights: graph[a].append((c,b))
        distance, stack = [float('inf')]*n, []
        
        stack.append([distance[src],src,k])
        
        while stack:
            dist, site, K = stack.pop()
            if K-1>0:
                for d,s in graph[site]:
                    stack.append([d,s,K-1])
            for d,s in graph[site]:
                new_dist = d+dist
                if s==dst and new_dist<distance[s]: distance[s] = new_dist 
                distance[s] = new_dist
        
        return -1 if distance[dst]==float('inf') else distance[dst]