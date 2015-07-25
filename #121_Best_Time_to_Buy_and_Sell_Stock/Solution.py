class Solution:
    # @param {integer[]} prices
    # @return {integer}
    def maxProfit(self, prices):
        if (len(prices) <= 1):
        	return 0
        prevMax = prices[len(prices) - 1];
        re = 0
        for i in range(len(prices) - 2, -1, -1):
        	re = max(re, prevMax - prices[i])
        	prevMax = max(prevMax, prices[i])
        return re


t = [2, 1, 4]
sol = Solution();
print sol.maxProfit(t);
