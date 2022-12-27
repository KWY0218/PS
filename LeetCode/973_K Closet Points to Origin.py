import heapq
class Solution:
    def kClosest(self, points: list[list[int]], k: int) -> list[list[int]]:
        answer = []
        temp = []
        def divide(p):
            if len(p) == 1:
                dist = (p[0][0])**2 + (p[0][1])**2
                heapq.heappush(answer,(dist,p[0]))
                return
            mid = len(p)//2
            divide(p[:mid])
            divide(p[mid:])
            return
        divide(points)
        for _ in range(k): temp.append(heapq.heappop(answer)[1])
        return temp