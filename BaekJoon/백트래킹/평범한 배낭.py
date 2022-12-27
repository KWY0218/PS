import sys

class Item:
    def __init__(self,p,w) -> None:
        self.profit = p
        self.weight = w
    
    def to_string(self):
        print(f"profit: {self.profit} weight: {self.weight}")

max_profit = 0
def compute_bound(nums, W, curr_profit, curr_weight, index):
    bound = curr_profit
    total_weight = curr_weight
    n = len(nums)
    while index<n and total_weight+nums[index].weight<=W:
        total_weight += nums[index].weight
        bound += nums[index].profit
        index += 1
    if index<n: bound += (W-total_weight)*(nums[index].profit/nums[index].weight)
    return bound

def promising(nums, W, curr_profit, curr_weight, index):
    global max_profit
    if curr_weight>=W : return False
    else:
        return compute_bound(nums, W, curr_profit, curr_weight, index)>max_profit

def solve(nums, W, curr_profit, curr_weight, index):
    global max_profit
    if curr_weight <= W and curr_profit>max_profit:
        max_profit = curr_profit
    if promising(nums, W, curr_profit, curr_weight, index):
        solve(nums, W, curr_profit+nums[index].profit, curr_weight+nums[index].weight, index+1)
        solve(nums, W, curr_profit, curr_weight, index+1)

def korea_main():
    global max_profit
    T = int(sys.stdin.readline())
    for _ in range(T):
        max_profit = 0
        W, N = map(int,sys.stdin.readline().split())
        nums = list(map(int,sys.stdin.readline().split()))
        items = [Item(nums[2*i],nums[2*i+1]) for i in range(N)]
        items.sort(key = lambda x: -(x.profit/x.weight))
        solve(items, W, 0, 0, 0)
        print(max_profit)

korea_main()