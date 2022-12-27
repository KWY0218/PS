import sys
import heapq        
class Node:
    def __init__(self, level, profit, weight):
        self.level = level
        self.profit = profit
        self.weight = weight
        self.bound = 0
        self.items = []
    
    def __it__(self,other):
        return self.bound<other.bound
    def __gt__(self,other):
        return self.bound<other.bound
           
def get_bound(node):
    if node.weight >= W:
        return 0
    else:
        result = node.profit
        j = node.level + 1
        totweight = node.weight
        while j <= n-1 and totweight + w[j] <= W:
            totweight = totweight + w[j]
            result = result + p[j]
            j+=1
        k = j
        if k<=n-1:
            result = result + (W - totweight) * p_per_weight[k]
        return result
    
T = int(sys.stdin.readline())
for _ in range(T):
    W,n = map(int,sys.stdin.readline().split())
    nums = list(map(int,sys.stdin.readline().split()))
    p = [nums[2*i] for i in range(n)]
    w = [nums[2*i+1] for i in range(n)]
    p_per_weight = [p[i]/w[i] for i in range(n)]
    
    pq = []
    v = Node(-1, 0, 0)
    maxprofit = 0 
    v.bound = get_bound(v)
    
    heapq.heappush(pq,v)

    while len(pq) != 0:
        v = heapq.heappop(pq)
        if v.bound > maxprofit: 
            u = Node(0, 0, 0)
            u.level = v.level + 1
            u.profit = v.profit + p[u.level]
            u.weight = v.weight + w[u.level]
            u.items = v.items.copy()
            u.items.append(u.level)
            
            if u.weight <= W and u.profit > maxprofit: 
                maxprofit = u.profit
                
            u.bound = get_bound(u)
            
            if u.bound > maxprofit:
                heapq.heappush(pq,u)

            u2 = Node(u.level, v.profit, v.weight)
            u2.bound = get_bound(u2)
            u2.items = v.items.copy()
            if u2.bound > maxprofit:
                heapq.heappush(pq,u2)
    print(maxprofit)