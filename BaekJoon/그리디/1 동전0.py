import sys

def main():
    N, K = map(int,sys.stdin.readline().split())
    nums = [int(sys.stdin.readline()) for _ in range(N)]
    count = 0
    while nums[-1]>K: nums.pop()
    while K>0 and nums:
        curr_price = nums.pop()
        count += K//curr_price
        K-=curr_price*(K//curr_price)
    print(count)
main()