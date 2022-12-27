def maxProfit(prices: list[int]) -> int:
    answer = 0
    curr = prices[0]
    for i in range(len(prices)-1):
        if prices[i] > prices[i+1]:
            answer += (prices[i]-curr)
            curr = prices[i+1]
    answer += (prices[-1]-curr)
    return answer

print(maxProfit([7,6,4,3,1]))