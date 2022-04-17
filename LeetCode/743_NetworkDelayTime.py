import heapq

class Solution:
    def networkDelayTime(self, times: list[list[int]], n: int, k: int) -> int:
        graph = dict()
        heap = []
        for i in range(1,n+1): graph[i] = []
        for a,b,c in times: graph[a].append((c,b))
        distance = [float('inf')]*(n+1)
        
        distance[k] = 0
        heapq.heappush(heap,graph[k])
        
        while heap:
            weight, site = heapq.heappop(heap)
            if distance[site]<weight: continue
            for w,s in graph[site]:
                new_dist = weight+w
                if new_dist<distance[s]:
                    distance[s] = new_dist
                    heapq.heappush(heap,(distance[s],s))
        
        return -1 if max(distance) == float('inf') else max(distance)