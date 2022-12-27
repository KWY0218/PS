import sys

max_profit=0

class Item:
    def __init__(self, v, w):
        self.v = v
        self.w = w
        
    def to_string(self):
        print(f"profit: {self.v} weight: {self.w}")
    
def computeBound(items, W, curr_profit, curr_weight, index):
    bound = curr_profit
    to_weight = curr_weight
    n = len(items)
    while index<n and to_weight+items[index].w<=W:
        to_weight += items[index].w
        bound += items[index].v
        index += 1
    if index<n:
        bound += (W-to_weight) * (items[index].v / items[index].w)
    return bound

def promising(items, W, curr_profit, curr_weight, index):
    global max_profit
    if curr_weight >= W:
        return False
    else:
        return computeBound(items,W, curr_profit, curr_weight,index) > max_profit
    
def knapsack(items, W, curr_profit, curr_weight, index):
    global max_profit
    if curr_weight <= W and curr_profit > max_profit:
        max_profit = curr_profit
    if promising(items,W,curr_profit, curr_weight, index):
        knapsack(items,W,curr_profit+items[index].v, curr_weight+items[index].w,index+1)
        knapsack(items, W, curr_profit, curr_weight, index + 1)
    
def main():
    global max_profit
    T = int(sys.stdin.readline())
    for i in range(T):
        max_profit = 0
        W, N = map(int, input().split())
        l = list(map(int, input().split()))
        items = []
        for i in range(N):
            items.append(Item(l[2 * i], l[2 * i + 1]))
        for i in range(N): items[i].to_string()
        items.sort(key=lambda a:-(a.v/a.w))
        knapsack(items,W,0,0,0)
        print(max_profit)

main()