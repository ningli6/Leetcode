'''
first iteration, from left to right, find the max profit you can get if you sell on that day
second iteration, from right to left, find the max profit you can get if you buy in on that day
third iteration, find the max profit
'''

class Solution:
    # @param {integer[]} prices
    # @return {integer}
    def maxProfit(self, prices):
        if not prices or len(prices) < 2:
        	return 0
        sell = [0 for x in range(len(prices))]
        buy = [0 for x in range(len(prices))]
        minVal = prices[0]
        for x in range(1, len(prices)):
        	sell[x] = max(0, prices[x] - minVal)
        	minVal = min(minVal, prices[x])
        maxVal = prices[len(prices) - 1]
        for x in range(len(prices) - 2, -1, -1):
        	buy[x] = max(0, maxVal - prices[x])
        	maxVal = max(maxVal, prices[x])
        print sell
        print buy
        re = 0
        for x in range(len(prices) - 1):
        	re = max(re, sell[x] + buy[x + 1])
        return max(re, buy[0], sell[len(prices) - 1])

sol = Solution()
print sol.maxProfit([1, 5, 3, 4, 5])